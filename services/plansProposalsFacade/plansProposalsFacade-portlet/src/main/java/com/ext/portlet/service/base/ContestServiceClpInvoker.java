package com.ext.portlet.service.base;

import com.ext.portlet.service.ContestServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContestServiceClpInvoker {
    private String _methodName562;
    private String[] _methodParameterTypes562;
    private String _methodName563;
    private String[] _methodParameterTypes563;
    private String _methodName568;
    private String[] _methodParameterTypes568;
    private String _methodName569;
    private String[] _methodParameterTypes569;

    public ContestServiceClpInvoker() {
        _methodName562 = "getBeanIdentifier";

        _methodParameterTypes562 = new String[] {  };

        _methodName563 = "setBeanIdentifier";

        _methodParameterTypes563 = new String[] { "java.lang.String" };

        _methodName568 = "getContestsOpenForProposals";

        _methodParameterTypes568 = new String[] {  };

        _methodName569 = "getNumberOfUnreadMessages";

        _methodParameterTypes569 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName562.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes562, parameterTypes)) {
            return ContestServiceUtil.getBeanIdentifier();
        }

        if (_methodName563.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes563, parameterTypes)) {
            ContestServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName568.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes568, parameterTypes)) {
            return ContestServiceUtil.getContestsOpenForProposals();
        }

        if (_methodName569.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes569, parameterTypes)) {
            return ContestServiceUtil.getNumberOfUnreadMessages();
        }

        throw new UnsupportedOperationException();
    }
}
