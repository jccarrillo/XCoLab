package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the MessagingRedirectLink service. Represents a row in the &quot;xcolab_MessagingRedirectLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.MessagingRedirectLinkModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.MessagingRedirectLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingRedirectLink
 * @see com.ext.portlet.model.impl.MessagingRedirectLinkImpl
 * @see com.ext.portlet.model.impl.MessagingRedirectLinkModelImpl
 * @generated
 */
public interface MessagingRedirectLinkModel extends BaseModel<MessagingRedirectLink> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a messaging redirect link model instance should use the {@link MessagingRedirectLink} interface instead.
     */

    /**
     * Returns the primary key of this messaging redirect link.
     *
     * @return the primary key of this messaging redirect link
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this messaging redirect link.
     *
     * @param primaryKey the primary key of this messaging redirect link
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the redirect ID of this messaging redirect link.
     *
     * @return the redirect ID of this messaging redirect link
     */
    public long getRedirectId();

    /**
     * Sets the redirect ID of this messaging redirect link.
     *
     * @param redirectId the redirect ID of this messaging redirect link
     */
    public void setRedirectId(long redirectId);

    /**
     * Returns the link of this messaging redirect link.
     *
     * @return the link of this messaging redirect link
     */
    @AutoEscape
    public String getLink();

    /**
     * Sets the link of this messaging redirect link.
     *
     * @param link the link of this messaging redirect link
     */
    public void setLink(String link);

    /**
     * Returns the message ID of this messaging redirect link.
     *
     * @return the message ID of this messaging redirect link
     */
    public long getMessageId();

    /**
     * Sets the message ID of this messaging redirect link.
     *
     * @param messageId the message ID of this messaging redirect link
     */
    public void setMessageId(long messageId);

    /**
     * Returns the create date of this messaging redirect link.
     *
     * @return the create date of this messaging redirect link
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this messaging redirect link.
     *
     * @param createDate the create date of this messaging redirect link
     */
    public void setCreateDate(Date createDate);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(MessagingRedirectLink messagingRedirectLink);

    public int hashCode();

    public CacheModel<MessagingRedirectLink> toCacheModel();

    public MessagingRedirectLink toEscapedModel();

    public String toString();

    public String toXmlString();
}