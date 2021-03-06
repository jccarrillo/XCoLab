package com.liferay.portal.spring.bean;

import com.liferay.portal.cluster.ClusterableAdvice;
import com.liferay.portal.kernel.bean.BeanLocatorException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BeanReferenceAnnotationBeanPostProcessorMock implements BeanFactoryAware, BeanPostProcessor {

    private static final Log _log = LogFactoryUtil.getLog(BeanReferenceAnnotationBeanPostProcessorMock.class);
    private static final String _JAVA_LANG_OBJECT = "java.lang.Object";
    private static final String _ORG_SPRINGFRAMEWORK = "org.springframework";

    private BeanFactory _beanFactory;
    private final Map<String, Object> _beans = new HashMap<>();

    public void destroy() {
        _beans.clear();
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof IdentifiableBean) {
            IdentifiableBean identifiableBean = (IdentifiableBean) bean;

            identifiableBean.setBeanIdentifier(beanName);
        } else if (beanName.endsWith("Service")) {
            if (_log.isWarnEnabled()) {
                _log.warn(beanName + " should implement " + IdentifiableBean.class.getName() + " for "
                        + ClusterableAdvice.class.getName());
            }
        }

        _autoInject(bean, beanName, bean.getClass());

        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        _beanFactory = beanFactory;
    }

    private void _autoInject(Object targetBean, String targetBeanName, Class<?> beanClass) {

        if ((beanClass == null) || beanClass.isInterface()) {
            return;
        }

        String className = beanClass.getName();

        if (className.equals(_JAVA_LANG_OBJECT) || className.startsWith(_ORG_SPRINGFRAMEWORK)) {

            return;
        }

        Field[] fields = beanClass.getDeclaredFields();

        for (Field field : fields) {
            BeanReference beanReference = field.getAnnotation(BeanReference.class);

            String referencedBeanName;
            Class<?> referencedBeanType;

            if (beanReference != null) {
                referencedBeanName = beanReference.name();
                referencedBeanType = beanReference.type();
            } else {
                continue;
            }

            if (!Object.class.equals(referencedBeanType)) {
                referencedBeanName = referencedBeanType.getName();
            }

            Object referencedBean = _beans.get(referencedBeanName);

            if (referencedBean == null) {
                try {
                    referencedBean = _beanFactory.getBean(referencedBeanName);
                } catch (NoSuchBeanDefinitionException nsbde) {
                    try {
                        referencedBean = PortalBeanLocatorUtil.locate(referencedBeanName);
                        if (referencedBean == null) {
                            System.out.println("\t\t\tCan't find bean : " + referencedBeanName);
                            continue;
                        }
                    } catch (BeanLocatorException ble) {
                        // do nothing
                        continue;
                    }
                }

                _beans.put(referencedBeanName, referencedBean);
            }

            ReflectionUtils.makeAccessible(field);

            try {
                field.set(targetBean, referencedBean);
                
            } catch (IllegalAccessException | IllegalArgumentException e) {
                throw new BeanCreationException(targetBeanName, "Could not inject BeanReference fields", e);
            }
        }
        
        _autoInject(targetBean, targetBeanName, beanClass.getSuperclass());
        
    }
}
