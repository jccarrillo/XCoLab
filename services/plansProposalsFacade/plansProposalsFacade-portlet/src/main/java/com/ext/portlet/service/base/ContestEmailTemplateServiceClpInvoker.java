package com.ext.portlet.service.base;

import com.ext.portlet.service.ContestEmailTemplateServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContestEmailTemplateServiceClpInvoker {
    private String _methodName644;
    private String[] _methodParameterTypes644;
    private String _methodName645;
    private String[] _methodParameterTypes645;

    public ContestEmailTemplateServiceClpInvoker() {
        _methodName644 = "getBeanIdentifier";

        _methodParameterTypes644 = new String[] {  };

        _methodName645 = "setBeanIdentifier";

        _methodParameterTypes645 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName644.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes644, parameterTypes)) {
            return ContestEmailTemplateServiceUtil.getBeanIdentifier();
        }

        if (_methodName645.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes645, parameterTypes)) {
            ContestEmailTemplateServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
