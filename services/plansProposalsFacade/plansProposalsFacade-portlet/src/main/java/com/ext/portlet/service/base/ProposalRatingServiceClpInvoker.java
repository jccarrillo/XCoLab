package com.ext.portlet.service.base;

import com.ext.portlet.service.ProposalRatingServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProposalRatingServiceClpInvoker {
    private String _methodName574;
    private String[] _methodParameterTypes574;
    private String _methodName575;
    private String[] _methodParameterTypes575;

    public ProposalRatingServiceClpInvoker() {
        _methodName574 = "getBeanIdentifier";

        _methodParameterTypes574 = new String[] {  };

        _methodName575 = "setBeanIdentifier";

        _methodParameterTypes575 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName574.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes574, parameterTypes)) {
            return ProposalRatingServiceUtil.getBeanIdentifier();
        }

        if (_methodName575.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes575, parameterTypes)) {
            ProposalRatingServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
