package com.ext.portlet.service.base;

import com.ext.portlet.service.MessageLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MessageLocalServiceClpInvoker {
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
    private String _methodName660;
    private String[] _methodParameterTypes660;
    private String _methodName661;
    private String[] _methodParameterTypes661;
    private String _methodName666;
    private String[] _methodParameterTypes666;
    private String _methodName667;
    private String[] _methodParameterTypes667;
    private String _methodName668;
    private String[] _methodParameterTypes668;
    private String _methodName669;
    private String[] _methodParameterTypes669;
    private String _methodName670;
    private String[] _methodParameterTypes670;
    private String _methodName671;
    private String[] _methodParameterTypes671;
    private String _methodName672;
    private String[] _methodParameterTypes672;
    private String _methodName673;
    private String[] _methodParameterTypes673;

    public MessageLocalServiceClpInvoker() {
        _methodName0 = "addMessage";

        _methodParameterTypes0 = new String[] { "com.ext.portlet.model.Message" };

        _methodName1 = "createMessage";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteMessage";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteMessage";

        _methodParameterTypes3 = new String[] { "com.ext.portlet.model.Message" };

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

        _methodName10 = "fetchMessage";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getMessage";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getMessages";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getMessagesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateMessage";

        _methodParameterTypes15 = new String[] { "com.ext.portlet.model.Message" };

        _methodName660 = "getBeanIdentifier";

        _methodParameterTypes660 = new String[] {  };

        _methodName661 = "setBeanIdentifier";

        _methodParameterTypes661 = new String[] { "java.lang.String" };

        _methodName666 = "countSentMessage";

        _methodParameterTypes666 = new String[] { "long" };

        _methodName667 = "findSentMessages";

        _methodParameterTypes667 = new String[] { "long", "int", "int" };

        _methodName668 = "getRecipients";

        _methodParameterTypes668 = new String[] { "com.ext.portlet.model.Message" };

        _methodName669 = "hasReciever";

        _methodParameterTypes669 = new String[] {
                "com.ext.portlet.model.Message", "long"
            };

        _methodName670 = "isOpened";

        _methodParameterTypes670 = new String[] {
                "com.ext.portlet.model.Message", "long"
            };

        _methodName671 = "setOpened";

        _methodParameterTypes671 = new String[] {
                "com.ext.portlet.model.Message", "long"
            };

        _methodName672 = "isArchived";

        _methodParameterTypes672 = new String[] {
                "com.ext.portlet.model.Message", "long"
            };

        _methodName673 = "setArchived";

        _methodParameterTypes673 = new String[] {
                "com.ext.portlet.model.Message", "long"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return MessageLocalServiceUtil.addMessage((com.ext.portlet.model.Message) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return MessageLocalServiceUtil.createMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return MessageLocalServiceUtil.deleteMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return MessageLocalServiceUtil.deleteMessage((com.ext.portlet.model.Message) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return MessageLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return MessageLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return MessageLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return MessageLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return MessageLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return MessageLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return MessageLocalServiceUtil.fetchMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return MessageLocalServiceUtil.getMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return MessageLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return MessageLocalServiceUtil.getMessages(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return MessageLocalServiceUtil.getMessagesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return MessageLocalServiceUtil.updateMessage((com.ext.portlet.model.Message) arguments[0]);
        }

        if (_methodName660.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes660, parameterTypes)) {
            return MessageLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName661.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes661, parameterTypes)) {
            MessageLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName666.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes666, parameterTypes)) {
            return MessageLocalServiceUtil.countSentMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName667.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes667, parameterTypes)) {
            return MessageLocalServiceUtil.findSentMessages(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName668.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes668, parameterTypes)) {
            return MessageLocalServiceUtil.getRecipients((com.ext.portlet.model.Message) arguments[0]);
        }

        if (_methodName669.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes669, parameterTypes)) {
            return MessageLocalServiceUtil.hasReciever((com.ext.portlet.model.Message) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName670.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes670, parameterTypes)) {
            return MessageLocalServiceUtil.isOpened((com.ext.portlet.model.Message) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName671.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes671, parameterTypes)) {
            MessageLocalServiceUtil.setOpened((com.ext.portlet.model.Message) arguments[0],
                ((Long) arguments[1]).longValue());

            return null;
        }

        if (_methodName672.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes672, parameterTypes)) {
            return MessageLocalServiceUtil.isArchived((com.ext.portlet.model.Message) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName673.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes673, parameterTypes)) {
            MessageLocalServiceUtil.setArchived((com.ext.portlet.model.Message) arguments[0],
                ((Long) arguments[1]).longValue());

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
