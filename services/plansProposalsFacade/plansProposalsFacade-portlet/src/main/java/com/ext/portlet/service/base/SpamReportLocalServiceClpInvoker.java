package com.ext.portlet.service.base;

import com.ext.portlet.service.SpamReportLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SpamReportLocalServiceClpInvoker {
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
    private String _methodName504;
    private String[] _methodParameterTypes504;
    private String _methodName505;
    private String[] _methodParameterTypes505;
    private String _methodName510;
    private String[] _methodParameterTypes510;
    private String _methodName511;
    private String[] _methodParameterTypes511;
    private String _methodName512;
    private String[] _methodParameterTypes512;
    private String _methodName513;
    private String[] _methodParameterTypes513;
    private String _methodName514;
    private String[] _methodParameterTypes514;
    private String _methodName515;
    private String[] _methodParameterTypes515;
    private String _methodName516;
    private String[] _methodParameterTypes516;
    private String _methodName517;
    private String[] _methodParameterTypes517;

    public SpamReportLocalServiceClpInvoker() {
        _methodName0 = "addSpamReport";

        _methodParameterTypes0 = new String[] { "com.ext.portlet.model.SpamReport" };

        _methodName1 = "createSpamReport";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteSpamReport";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteSpamReport";

        _methodParameterTypes3 = new String[] { "com.ext.portlet.model.SpamReport" };

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

        _methodName10 = "fetchSpamReport";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getSpamReport";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getSpamReports";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getSpamReportsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateSpamReport";

        _methodParameterTypes15 = new String[] {
                "com.ext.portlet.model.SpamReport"
            };

        _methodName504 = "getBeanIdentifier";

        _methodParameterTypes504 = new String[] {  };

        _methodName505 = "setBeanIdentifier";

        _methodParameterTypes505 = new String[] { "java.lang.String" };

        _methodName510 = "create";

        _methodParameterTypes510 = new String[] {  };

        _methodName511 = "create";

        _methodParameterTypes511 = new String[] {
                "long", "long", "long", "boolean"
            };

        _methodName512 = "getBySpamUserId";

        _methodParameterTypes512 = new String[] { "long" };

        _methodName513 = "getByDiscussionMessageId";

        _methodParameterTypes513 = new String[] { "long" };

        _methodName514 = "getByReporterUserId";

        _methodParameterTypes514 = new String[] { "long" };

        _methodName515 = "hasReporterUserIdDiscussionMessageId";

        _methodParameterTypes515 = new String[] { "long", "long" };

        _methodName516 = "getByReporterUserIdDiscussionMessageId";

        _methodParameterTypes516 = new String[] { "long", "long" };

        _methodName517 = "getBySpamUserIdDiscussionMessageId";

        _methodParameterTypes517 = new String[] { "long", "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return SpamReportLocalServiceUtil.addSpamReport((com.ext.portlet.model.SpamReport) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return SpamReportLocalServiceUtil.createSpamReport(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return SpamReportLocalServiceUtil.deleteSpamReport(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return SpamReportLocalServiceUtil.deleteSpamReport((com.ext.portlet.model.SpamReport) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return SpamReportLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return SpamReportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return SpamReportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return SpamReportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return SpamReportLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return SpamReportLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return SpamReportLocalServiceUtil.fetchSpamReport(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return SpamReportLocalServiceUtil.getSpamReport(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return SpamReportLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return SpamReportLocalServiceUtil.getSpamReports(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return SpamReportLocalServiceUtil.getSpamReportsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return SpamReportLocalServiceUtil.updateSpamReport((com.ext.portlet.model.SpamReport) arguments[0]);
        }

        if (_methodName504.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes504, parameterTypes)) {
            return SpamReportLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName505.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes505, parameterTypes)) {
            SpamReportLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName510.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes510, parameterTypes)) {
            return SpamReportLocalServiceUtil.create();
        }

        if (_methodName511.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes511, parameterTypes)) {
            return SpamReportLocalServiceUtil.create(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                ((Boolean) arguments[3]).booleanValue());
        }

        if (_methodName512.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes512, parameterTypes)) {
            return SpamReportLocalServiceUtil.getBySpamUserId(((Long) arguments[0]).longValue());
        }

        if (_methodName513.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes513, parameterTypes)) {
            return SpamReportLocalServiceUtil.getByDiscussionMessageId(((Long) arguments[0]).longValue());
        }

        if (_methodName514.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes514, parameterTypes)) {
            return SpamReportLocalServiceUtil.getByReporterUserId(((Long) arguments[0]).longValue());
        }

        if (_methodName515.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes515, parameterTypes)) {
            return SpamReportLocalServiceUtil.hasReporterUserIdDiscussionMessageId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName516.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes516, parameterTypes)) {
            return SpamReportLocalServiceUtil.getByReporterUserIdDiscussionMessageId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName517.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes517, parameterTypes)) {
            return SpamReportLocalServiceUtil.getBySpamUserIdDiscussionMessageId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
