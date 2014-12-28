package com.ext.portlet.service.base;

import com.ext.portlet.service.PlanTypeLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PlanTypeLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName578;
    private String[] _methodParameterTypes578;
    private String _methodName579;
    private String[] _methodParameterTypes579;
    private String _methodName584;
    private String[] _methodParameterTypes584;
    private String _methodName585;
    private String[] _methodParameterTypes585;
    private String _methodName586;
    private String[] _methodParameterTypes586;
    private String _methodName587;
    private String[] _methodParameterTypes587;
    private String _methodName588;
    private String[] _methodParameterTypes588;
    private String _methodName589;
    private String[] _methodParameterTypes589;
    private String _methodName590;
    private String[] _methodParameterTypes590;
    private String _methodName591;
    private String[] _methodParameterTypes591;
    private String _methodName592;
    private String[] _methodParameterTypes592;

    public PlanTypeLocalServiceClpInvoker() {
        _methodName0 = "addPlanType";

        _methodParameterTypes0 = new String[] { "com.ext.portlet.model.PlanType" };

        _methodName1 = "createPlanType";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deletePlanType";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deletePlanType";

        _methodParameterTypes3 = new String[] { "com.ext.portlet.model.PlanType" };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchPlanType";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPlanType";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getPlanTypes";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getPlanTypesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updatePlanType";

        _methodParameterTypes15 = new String[] { "com.ext.portlet.model.PlanType" };

        _methodName578 = "getBeanIdentifier";

        _methodParameterTypes578 = new String[] {  };

        _methodName579 = "setBeanIdentifier";

        _methodParameterTypes579 = new String[] { "java.lang.String" };

        _methodName584 = "getDefaultPlanType";

        _methodParameterTypes584 = new String[] {  };

        _methodName585 = "getColumnsByPlanTypeId";

        _methodParameterTypes585 = new String[] { "long" };

        _methodName586 = "getAttributesByPlanTypeId";

        _methodParameterTypes586 = new String[] { "long" };

        _methodName587 = "isRegionalType";

        _methodParameterTypes587 = new String[] { "long" };

        _methodName588 = "getAvailableModels";

        _methodParameterTypes588 = new String[] { "com.ext.portlet.model.PlanType" };

        _methodName589 = "getDefaultModel";

        _methodParameterTypes589 = new String[] { "com.ext.portlet.model.PlanType" };

        _methodName590 = "getColumns";

        _methodParameterTypes590 = new String[] { "com.ext.portlet.model.PlanType" };

        _methodName591 = "getAttributes";

        _methodParameterTypes591 = new String[] { "com.ext.portlet.model.PlanType" };

        _methodName592 = "isRegional";

        _methodParameterTypes592 = new String[] { "com.ext.portlet.model.PlanType" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return PlanTypeLocalServiceUtil.addPlanType((com.ext.portlet.model.PlanType) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return PlanTypeLocalServiceUtil.createPlanType(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return PlanTypeLocalServiceUtil.deletePlanType(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return PlanTypeLocalServiceUtil.deletePlanType((com.ext.portlet.model.PlanType) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return PlanTypeLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return PlanTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return PlanTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return PlanTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return PlanTypeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return PlanTypeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return PlanTypeLocalServiceUtil.fetchPlanType(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getPlanType(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getPlanTypes(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getPlanTypesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return PlanTypeLocalServiceUtil.updatePlanType((com.ext.portlet.model.PlanType) arguments[0]);
        }

        if (_methodName578.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes578, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName579.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes579, parameterTypes)) {
            PlanTypeLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName584.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes584, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getDefaultPlanType();
        }

        if (_methodName585.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes585, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getColumnsByPlanTypeId(((Long) arguments[0]).longValue());
        }

        if (_methodName586.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes586, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getAttributesByPlanTypeId(((Long) arguments[0]).longValue());
        }

        if (_methodName587.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes587, parameterTypes)) {
            return PlanTypeLocalServiceUtil.isRegionalType(((Long) arguments[0]).longValue());
        }

        if (_methodName588.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes588, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getAvailableModels((com.ext.portlet.model.PlanType) arguments[0]);
        }

        if (_methodName589.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes589, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getDefaultModel((com.ext.portlet.model.PlanType) arguments[0]);
        }

        if (_methodName590.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes590, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getColumns((com.ext.portlet.model.PlanType) arguments[0]);
        }

        if (_methodName591.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes591, parameterTypes)) {
            return PlanTypeLocalServiceUtil.getAttributes((com.ext.portlet.model.PlanType) arguments[0]);
        }

        if (_methodName592.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes592, parameterTypes)) {
            return PlanTypeLocalServiceUtil.isRegional((com.ext.portlet.model.PlanType) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
