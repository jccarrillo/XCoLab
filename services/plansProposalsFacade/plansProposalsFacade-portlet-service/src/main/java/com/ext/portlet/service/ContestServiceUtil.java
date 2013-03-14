package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the contest remote service. This utility wraps {@link com.ext.portlet.service.impl.ContestServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestService
 * @see com.ext.portlet.service.base.ContestServiceBaseImpl
 * @see com.ext.portlet.service.impl.ContestServiceImpl
 * @generated
 */
public class ContestServiceUtil {
    private static ContestService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.ContestServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */
    public static void clearService() {
        _service = null;
    }

    public static ContestService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ContestService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    ContestService.class.getName(), portletClassLoader);

            _service = new ContestServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(ContestServiceUtil.class,
                "_service");
            MethodCache.remove(ContestService.class);
        }

        return _service;
    }

    public void setService(ContestService service) {
        MethodCache.remove(ContestService.class);

        _service = service;

        ReferenceRegistry.registerReference(ContestServiceUtil.class, "_service");
        MethodCache.remove(ContestService.class);
    }
}