package com.ext.portlet.model.impl;

import com.ext.portlet.model.Message;
import com.ext.portlet.service.MessageLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Message service. Represents a row in the &quot;xcolab_Message&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MessageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageImpl
 * @see com.ext.portlet.model.Message
 * @generated
 */
public abstract class MessageBaseImpl extends MessageModelImpl
    implements Message {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a message model instance should use the {@link Message} interface instead.
     */
    public void persist() throws SystemException {
        if (this.isNew()) {
            MessageLocalServiceUtil.addMessage(this);
        } else {
            MessageLocalServiceUtil.updateMessage(this);
        }
    }
}