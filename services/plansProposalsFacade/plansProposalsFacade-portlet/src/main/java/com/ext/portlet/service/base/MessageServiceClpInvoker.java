package com.ext.portlet.service.base;

import com.ext.portlet.service.MessageServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MessageServiceClpInvoker {
    private String _methodName562;
    private String[] _methodParameterTypes562;
    private String _methodName563;
    private String[] _methodParameterTypes563;

    public MessageServiceClpInvoker() {
        _methodName562 = "getBeanIdentifier";

        _methodParameterTypes562 = new String[] {  };

        _methodName563 = "setBeanIdentifier";

        _methodParameterTypes563 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName562.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes562, parameterTypes)) {
            return MessageServiceUtil.getBeanIdentifier();
        }

        if (_methodName563.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes563, parameterTypes)) {
            MessageServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
