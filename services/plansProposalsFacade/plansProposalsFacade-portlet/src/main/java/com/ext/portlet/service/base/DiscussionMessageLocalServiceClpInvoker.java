package com.ext.portlet.service.base;

import com.ext.portlet.service.DiscussionMessageLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DiscussionMessageLocalServiceClpInvoker {
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
    private String _methodName593;
    private String[] _methodParameterTypes593;
    private String _methodName594;
    private String[] _methodParameterTypes594;
    private String _methodName595;
    private String[] _methodParameterTypes595;
    private String _methodName596;
    private String[] _methodParameterTypes596;
    private String _methodName597;
    private String[] _methodParameterTypes597;
    private String _methodName598;
    private String[] _methodParameterTypes598;
    private String _methodName599;
    private String[] _methodParameterTypes599;
    private String _methodName600;
    private String[] _methodParameterTypes600;
    private String _methodName601;
    private String[] _methodParameterTypes601;
    private String _methodName602;
    private String[] _methodParameterTypes602;
    private String _methodName603;
    private String[] _methodParameterTypes603;
    private String _methodName604;
    private String[] _methodParameterTypes604;
    private String _methodName605;
    private String[] _methodParameterTypes605;
    private String _methodName606;
    private String[] _methodParameterTypes606;
    private String _methodName607;
    private String[] _methodParameterTypes607;
    private String _methodName608;
    private String[] _methodParameterTypes608;

    public DiscussionMessageLocalServiceClpInvoker() {
        _methodName0 = "addDiscussionMessage";

        _methodParameterTypes0 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName1 = "createDiscussionMessage";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteDiscussionMessage";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteDiscussionMessage";

        _methodParameterTypes3 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
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

        _methodName10 = "fetchDiscussionMessage";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getDiscussionMessage";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getDiscussionMessages";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getDiscussionMessagesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateDiscussionMessage";

        _methodParameterTypes15 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName578 = "getBeanIdentifier";

        _methodParameterTypes578 = new String[] {  };

        _methodName579 = "setBeanIdentifier";

        _methodParameterTypes579 = new String[] { "java.lang.String" };

        _methodName584 = "getThreadsByCategory";

        _methodParameterTypes584 = new String[] { "long" };

        _methodName585 = "getThreadMessages";

        _methodParameterTypes585 = new String[] { "long" };

        _methodName586 = "getThreadMessagesCount";

        _methodParameterTypes586 = new String[] { "long" };

        _methodName587 = "getThreadByThreadId";

        _methodParameterTypes587 = new String[] { "long" };

        _methodName588 = "addThread";

        _methodParameterTypes588 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String",
                "com.liferay.portal.model.User"
            };

        _methodName589 = "addMessage";

        _methodParameterTypes589 = new String[] {
                "long", "long", "long", "java.lang.String", "java.lang.String",
                "com.liferay.portal.model.User"
            };

        _methodName590 = "search";

        _methodParameterTypes590 = new String[] { "java.lang.String", "long" };

        _methodName591 = "getMessageByMessageId";

        _methodParameterTypes591 = new String[] { "long" };

        _methodName592 = "reIndex";

        _methodParameterTypes592 = new String[] {  };

        _methodName593 = "reIndex";

        _methodParameterTypes593 = new String[] { "long" };

        _methodName594 = "getThreadMessages";

        _methodParameterTypes594 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName595 = "getThreadMessagesCount";

        _methodParameterTypes595 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName596 = "store";

        _methodParameterTypes596 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName597 = "addThreadMessage";

        _methodParameterTypes597 = new String[] {
                "com.ext.portlet.model.DiscussionMessage", "java.lang.String",
                "java.lang.String", "com.liferay.portal.model.User"
            };

        _methodName598 = "getAuthor";

        _methodParameterTypes598 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName599 = "getLastActivityAuthor";

        _methodParameterTypes599 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName600 = "delete";

        _methodParameterTypes600 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName601 = "update";

        _methodParameterTypes601 = new String[] {
                "com.ext.portlet.model.DiscussionMessage", "java.lang.String",
                "java.lang.String"
            };

        _methodName602 = "getCategory";

        _methodParameterTypes602 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName603 = "getCategoryGroup";

        _methodParameterTypes603 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName604 = "getThread";

        _methodParameterTypes604 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName605 = "getFlags";

        _methodParameterTypes605 = new String[] {
                "com.ext.portlet.model.DiscussionMessage"
            };

        _methodName606 = "addFlag";

        _methodParameterTypes606 = new String[] {
                "com.ext.portlet.model.DiscussionMessage", "java.lang.String",
                "java.lang.String", "com.liferay.portal.model.User"
            };

        _methodName607 = "removeFlag";

        _methodParameterTypes607 = new String[] {
                "com.ext.portlet.model.DiscussionMessage", "java.lang.String"
            };

        _methodName608 = "hasFlag";

        _methodParameterTypes608 = new String[] { "long", "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.addDiscussionMessage((com.ext.portlet.model.DiscussionMessage) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.createDiscussionMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.deleteDiscussionMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.deleteDiscussionMessage((com.ext.portlet.model.DiscussionMessage) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.fetchDiscussionMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getDiscussionMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getDiscussionMessages(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getDiscussionMessagesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.updateDiscussionMessage((com.ext.portlet.model.DiscussionMessage) arguments[0]);
        }

        if (_methodName578.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes578, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName579.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes579, parameterTypes)) {
            DiscussionMessageLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName584.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes584, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getThreadsByCategory(((Long) arguments[0]).longValue());
        }

        if (_methodName585.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes585, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getThreadMessages(((Long) arguments[0]).longValue());
        }

        if (_methodName586.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes586, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getThreadMessagesCount(((Long) arguments[0]).longValue());
        }

        if (_methodName587.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes587, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getThreadByThreadId(((Long) arguments[0]).longValue());
        }

        if (_methodName588.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes588, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.addThread(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (com.liferay.portal.model.User) arguments[4]);
        }

        if (_methodName589.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes589, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.addMessage(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (com.liferay.portal.model.User) arguments[5]);
        }

        if (_methodName590.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes590, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.search((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName591.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes591, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getMessageByMessageId(((Long) arguments[0]).longValue());
        }

        if (_methodName592.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes592, parameterTypes)) {
            DiscussionMessageLocalServiceUtil.reIndex();

            return null;
        }

        if (_methodName593.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes593, parameterTypes)) {
            DiscussionMessageLocalServiceUtil.reIndex(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName594.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes594, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getThreadMessages((com.ext.portlet.model.DiscussionMessage) arguments[0]);
        }

        if (_methodName595.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes595, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getThreadMessagesCount((com.ext.portlet.model.DiscussionMessage) arguments[0]);
        }

        if (_methodName596.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes596, parameterTypes)) {
            DiscussionMessageLocalServiceUtil.store((com.ext.portlet.model.DiscussionMessage) arguments[0]);

            return null;
        }

        if (_methodName597.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes597, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.addThreadMessage((com.ext.portlet.model.DiscussionMessage) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (com.liferay.portal.model.User) arguments[3]);
        }

        if (_methodName598.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes598, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getAuthor((com.ext.portlet.model.DiscussionMessage) arguments[0]);
        }

        if (_methodName599.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes599, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getLastActivityAuthor((com.ext.portlet.model.DiscussionMessage) arguments[0]);
        }

        if (_methodName600.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes600, parameterTypes)) {
            DiscussionMessageLocalServiceUtil.delete((com.ext.portlet.model.DiscussionMessage) arguments[0]);

            return null;
        }

        if (_methodName601.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes601, parameterTypes)) {
            DiscussionMessageLocalServiceUtil.update((com.ext.portlet.model.DiscussionMessage) arguments[0],
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);

            return null;
        }

        if (_methodName602.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes602, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getCategory((com.ext.portlet.model.DiscussionMessage) arguments[0]);
        }

        if (_methodName603.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes603, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getCategoryGroup((com.ext.portlet.model.DiscussionMessage) arguments[0]);
        }

        if (_methodName604.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes604, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getThread((com.ext.portlet.model.DiscussionMessage) arguments[0]);
        }

        if (_methodName605.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes605, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.getFlags((com.ext.portlet.model.DiscussionMessage) arguments[0]);
        }

        if (_methodName606.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes606, parameterTypes)) {
            DiscussionMessageLocalServiceUtil.addFlag((com.ext.portlet.model.DiscussionMessage) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (com.liferay.portal.model.User) arguments[3]);

            return null;
        }

        if (_methodName607.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes607, parameterTypes)) {
            DiscussionMessageLocalServiceUtil.removeFlag((com.ext.portlet.model.DiscussionMessage) arguments[0],
                (java.lang.String) arguments[1]);

            return null;
        }

        if (_methodName608.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes608, parameterTypes)) {
            return DiscussionMessageLocalServiceUtil.hasFlag(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
