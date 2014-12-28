package com.ext.portlet.service.base;

import com.ext.portlet.service.ProposalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProposalServiceClpInvoker {
    private String _methodName562;
    private String[] _methodParameterTypes562;
    private String _methodName563;
    private String[] _methodParameterTypes563;
    private String _methodName568;
    private String[] _methodParameterTypes568;
    private String _methodName569;
    private String[] _methodParameterTypes569;
    private String _methodName570;
    private String[] _methodParameterTypes570;
    private String _methodName571;
    private String[] _methodParameterTypes571;
    private String _methodName572;
    private String[] _methodParameterTypes572;

    public ProposalServiceClpInvoker() {
        _methodName562 = "getBeanIdentifier";

        _methodParameterTypes562 = new String[] {  };

        _methodName563 = "setBeanIdentifier";

        _methodParameterTypes563 = new String[] { "java.lang.String" };

        _methodName568 = "getProposalVersionFirstIndex";

        _methodParameterTypes568 = new String[] { "long", "long" };

        _methodName569 = "getProposalVersionIndex";

        _methodParameterTypes569 = new String[] { "long", "long" };

        _methodName570 = "getProposalVersions";

        _methodParameterTypes570 = new String[] {
                "long", "long", "long", "int", "int"
            };

        _methodName571 = "getProposalVersions";

        _methodParameterTypes571 = new String[] { "long", "int", "int" };

        _methodName572 = "getProposalContestSections";

        _methodParameterTypes572 = new String[] { "long", "int", "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName562.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes562, parameterTypes)) {
            return ProposalServiceUtil.getBeanIdentifier();
        }

        if (_methodName563.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes563, parameterTypes)) {
            ProposalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName568.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes568, parameterTypes)) {
            return ProposalServiceUtil.getProposalVersionFirstIndex(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName569.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes569, parameterTypes)) {
            return ProposalServiceUtil.getProposalVersionIndex(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName570.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes570, parameterTypes)) {
            return ProposalServiceUtil.getProposalVersions(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                ((Integer) arguments[3]).intValue(),
                ((Integer) arguments[4]).intValue());
        }

        if (_methodName571.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes571, parameterTypes)) {
            return ProposalServiceUtil.getProposalVersions(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName572.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes572, parameterTypes)) {
            return ProposalServiceUtil.getProposalContestSections(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Long) arguments[2]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
