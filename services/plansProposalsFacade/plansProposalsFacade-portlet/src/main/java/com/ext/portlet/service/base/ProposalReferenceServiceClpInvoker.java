package com.ext.portlet.service.base;

import com.ext.portlet.service.ProposalReferenceServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProposalReferenceServiceClpInvoker {
    private String _methodName502;
    private String[] _methodParameterTypes502;
    private String _methodName503;
    private String[] _methodParameterTypes503;

    public ProposalReferenceServiceClpInvoker() {
        _methodName502 = "getBeanIdentifier";

        _methodParameterTypes502 = new String[] {  };

        _methodName503 = "setBeanIdentifier";

        _methodParameterTypes503 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName502.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes502, parameterTypes)) {
            return ProposalReferenceServiceUtil.getBeanIdentifier();
        }

        if (_methodName503.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes503, parameterTypes)) {
            ProposalReferenceServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
