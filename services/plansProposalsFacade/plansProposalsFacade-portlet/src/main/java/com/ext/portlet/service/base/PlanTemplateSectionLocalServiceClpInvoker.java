package com.ext.portlet.service.base;

import com.ext.portlet.service.PlanTemplateSectionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PlanTemplateSectionLocalServiceClpInvoker {
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
    private String _methodName518;
    private String[] _methodParameterTypes518;
    private String _methodName519;
    private String[] _methodParameterTypes519;
    private String _methodName524;
    private String[] _methodParameterTypes524;
    private String _methodName525;
    private String[] _methodParameterTypes525;
    private String _methodName526;
    private String[] _methodParameterTypes526;
    private String _methodName527;
    private String[] _methodParameterTypes527;
    private String _methodName528;
    private String[] _methodParameterTypes528;
    private String _methodName529;
    private String[] _methodParameterTypes529;

    public PlanTemplateSectionLocalServiceClpInvoker() {
        _methodName0 = "addPlanTemplateSection";

        _methodParameterTypes0 = new String[] {
                "com.ext.portlet.model.PlanTemplateSection"
            };

        _methodName1 = "createPlanTemplateSection";

        _methodParameterTypes1 = new String[] {
                "com.ext.portlet.service.persistence.PlanTemplateSectionPK"
            };

        _methodName2 = "deletePlanTemplateSection";

        _methodParameterTypes2 = new String[] {
                "com.ext.portlet.service.persistence.PlanTemplateSectionPK"
            };

        _methodName3 = "deletePlanTemplateSection";

        _methodParameterTypes3 = new String[] {
                "com.ext.portlet.model.PlanTemplateSection"
            };

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

        _methodName10 = "fetchPlanTemplateSection";

        _methodParameterTypes10 = new String[] {
                "com.ext.portlet.service.persistence.PlanTemplateSectionPK"
            };

        _methodName11 = "getPlanTemplateSection";

        _methodParameterTypes11 = new String[] {
                "com.ext.portlet.service.persistence.PlanTemplateSectionPK"
            };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getPlanTemplateSections";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getPlanTemplateSectionsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updatePlanTemplateSection";

        _methodParameterTypes15 = new String[] {
                "com.ext.portlet.model.PlanTemplateSection"
            };

        _methodName518 = "getBeanIdentifier";

        _methodParameterTypes518 = new String[] {  };

        _methodName519 = "setBeanIdentifier";

        _methodParameterTypes519 = new String[] { "java.lang.String" };

        _methodName524 = "findByPlanTemplateId";

        _methodParameterTypes524 = new String[] { "java.lang.Long" };

        _methodName525 = "findByPlanSectionDefinitionId";

        _methodParameterTypes525 = new String[] { "java.lang.Long" };

        _methodName526 = "addPlanTemplateSection";

        _methodParameterTypes526 = new String[] {
                "java.lang.Long", "java.lang.Long", "int"
            };

        _methodName527 = "removePlanTemplateSection";

        _methodParameterTypes527 = new String[] {
                "java.lang.Long", "java.lang.Long"
            };

        _methodName528 = "store";

        _methodParameterTypes528 = new String[] {
                "com.ext.portlet.model.PlanTemplateSection"
            };

        _methodName529 = "remove";

        _methodParameterTypes529 = new String[] {
                "com.ext.portlet.model.PlanTemplateSection"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.addPlanTemplateSection((com.ext.portlet.model.PlanTemplateSection) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.createPlanTemplateSection((com.ext.portlet.service.persistence.PlanTemplateSectionPK) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.deletePlanTemplateSection((com.ext.portlet.service.persistence.PlanTemplateSectionPK) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.deletePlanTemplateSection((com.ext.portlet.model.PlanTemplateSection) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.fetchPlanTemplateSection((com.ext.portlet.service.persistence.PlanTemplateSectionPK) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.getPlanTemplateSection((com.ext.portlet.service.persistence.PlanTemplateSectionPK) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.getPlanTemplateSections(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.getPlanTemplateSectionsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.updatePlanTemplateSection((com.ext.portlet.model.PlanTemplateSection) arguments[0]);
        }

        if (_methodName518.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes518, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName519.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes519, parameterTypes)) {
            PlanTemplateSectionLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName524.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes524, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.findByPlanTemplateId((java.lang.Long) arguments[0]);
        }

        if (_methodName525.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes525, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.findByPlanSectionDefinitionId((java.lang.Long) arguments[0]);
        }

        if (_methodName526.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes526, parameterTypes)) {
            return PlanTemplateSectionLocalServiceUtil.addPlanTemplateSection((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1],
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName527.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes527, parameterTypes)) {
            PlanTemplateSectionLocalServiceUtil.removePlanTemplateSection((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1]);

            return null;
        }

        if (_methodName528.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes528, parameterTypes)) {
            PlanTemplateSectionLocalServiceUtil.store((com.ext.portlet.model.PlanTemplateSection) arguments[0]);

            return null;
        }

        if (_methodName529.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes529, parameterTypes)) {
            PlanTemplateSectionLocalServiceUtil.remove((com.ext.portlet.model.PlanTemplateSection) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
