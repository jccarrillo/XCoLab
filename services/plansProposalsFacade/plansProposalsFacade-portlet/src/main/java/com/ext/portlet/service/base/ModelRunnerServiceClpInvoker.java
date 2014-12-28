package com.ext.portlet.service.base;

import com.ext.portlet.service.ModelRunnerServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ModelRunnerServiceClpInvoker {
    private String _methodName562;
    private String[] _methodParameterTypes562;
    private String _methodName563;
    private String[] _methodParameterTypes563;
    private String _methodName567;
    private String[] _methodParameterTypes567;
    private String _methodName568;
    private String[] _methodParameterTypes568;
    private String _methodName569;
    private String[] _methodParameterTypes569;
    private String _methodName570;
    private String[] _methodParameterTypes570;

    public ModelRunnerServiceClpInvoker() {
        _methodName562 = "getBeanIdentifier";

        _methodParameterTypes562 = new String[] {  };

        _methodName563 = "setBeanIdentifier";

        _methodParameterTypes563 = new String[] { "java.lang.String" };

        _methodName567 = "getScenario";

        _methodParameterTypes567 = new String[] { "long" };

        _methodName568 = "getModel";

        _methodParameterTypes568 = new String[] { "long" };

        _methodName569 = "runModel";

        _methodParameterTypes569 = new String[] { "long", "java.lang.String" };

        _methodName570 = "refreshModels";

        _methodParameterTypes570 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName562.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes562, parameterTypes)) {
            return ModelRunnerServiceUtil.getBeanIdentifier();
        }

        if (_methodName563.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes563, parameterTypes)) {
            ModelRunnerServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName567.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes567, parameterTypes)) {
            return ModelRunnerServiceUtil.getScenario(((Long) arguments[0]).longValue());
        }

        if (_methodName568.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes568, parameterTypes)) {
            return ModelRunnerServiceUtil.getModel(((Long) arguments[0]).longValue());
        }

        if (_methodName569.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes569, parameterTypes)) {
            return ModelRunnerServiceUtil.runModel(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);
        }

        if (_methodName570.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes570, parameterTypes)) {
            ModelRunnerServiceUtil.refreshModels();

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
