package com.ext.portlet.service.base;

import com.ext.portlet.service.PlanDescriptionServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PlanDescriptionServiceClpInvoker {
    private String _methodName562;
    private String[] _methodParameterTypes562;
    private String _methodName563;
    private String[] _methodParameterTypes563;

    public PlanDescriptionServiceClpInvoker() {
        _methodName562 = "getBeanIdentifier";

        _methodParameterTypes562 = new String[] {  };

        _methodName563 = "setBeanIdentifier";

        _methodParameterTypes563 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName562.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes562, parameterTypes)) {
            return PlanDescriptionServiceUtil.getBeanIdentifier();
        }

        if (_methodName563.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes563, parameterTypes)) {
            PlanDescriptionServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
