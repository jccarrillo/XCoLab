package com.ext.portlet.model;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the MessagingUserPreferences service. Represents a row in the &quot;xcolab_MessagingUserPreferences&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.MessagingUserPreferencesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.MessagingUserPreferencesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingUserPreferences
 * @see com.ext.portlet.model.impl.MessagingUserPreferencesImpl
 * @see com.ext.portlet.model.impl.MessagingUserPreferencesModelImpl
 * @generated
 */
public interface MessagingUserPreferencesModel extends BaseModel<MessagingUserPreferences> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a messaging user preferences model instance should use the {@link MessagingUserPreferences} interface instead.
     */

    /**
     * Returns the primary key of this messaging user preferences.
     *
     * @return the primary key of this messaging user preferences
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this messaging user preferences.
     *
     * @param primaryKey the primary key of this messaging user preferences
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the messaging preferences ID of this messaging user preferences.
     *
     * @return the messaging preferences ID of this messaging user preferences
     */
    public long getMessagingPreferencesId();

    /**
     * Sets the messaging preferences ID of this messaging user preferences.
     *
     * @param messagingPreferencesId the messaging preferences ID of this messaging user preferences
     */
    public void setMessagingPreferencesId(long messagingPreferencesId);

    /**
     * Returns the user ID of this messaging user preferences.
     *
     * @return the user ID of this messaging user preferences
     */
    public long getUserId();

    /**
     * Sets the user ID of this messaging user preferences.
     *
     * @param userId the user ID of this messaging user preferences
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this messaging user preferences.
     *
     * @return the user uuid of this messaging user preferences
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this messaging user preferences.
     *
     * @param userUuid the user uuid of this messaging user preferences
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the email on send of this messaging user preferences.
     *
     * @return the email on send of this messaging user preferences
     */
    public boolean getEmailOnSend();

    /**
     * Returns <code>true</code> if this messaging user preferences is email on send.
     *
     * @return <code>true</code> if this messaging user preferences is email on send; <code>false</code> otherwise
     */
    public boolean isEmailOnSend();

    /**
     * Sets whether this messaging user preferences is email on send.
     *
     * @param emailOnSend the email on send of this messaging user preferences
     */
    public void setEmailOnSend(boolean emailOnSend);

    /**
     * Returns the email on receipt of this messaging user preferences.
     *
     * @return the email on receipt of this messaging user preferences
     */
    public boolean getEmailOnReceipt();

    /**
     * Returns <code>true</code> if this messaging user preferences is email on receipt.
     *
     * @return <code>true</code> if this messaging user preferences is email on receipt; <code>false</code> otherwise
     */
    public boolean isEmailOnReceipt();

    /**
     * Sets whether this messaging user preferences is email on receipt.
     *
     * @param emailOnReceipt the email on receipt of this messaging user preferences
     */
    public void setEmailOnReceipt(boolean emailOnReceipt);

    /**
     * Returns the email on activity of this messaging user preferences.
     *
     * @return the email on activity of this messaging user preferences
     */
    public boolean getEmailOnActivity();

    /**
     * Returns <code>true</code> if this messaging user preferences is email on activity.
     *
     * @return <code>true</code> if this messaging user preferences is email on activity; <code>false</code> otherwise
     */
    public boolean isEmailOnActivity();

    /**
     * Sets whether this messaging user preferences is email on activity.
     *
     * @param emailOnActivity the email on activity of this messaging user preferences
     */
    public void setEmailOnActivity(boolean emailOnActivity);

    /**
     * Returns the email activity daily digest of this messaging user preferences.
     *
     * @return the email activity daily digest of this messaging user preferences
     */
    public boolean getEmailActivityDailyDigest();

    /**
     * Returns <code>true</code> if this messaging user preferences is email activity daily digest.
     *
     * @return <code>true</code> if this messaging user preferences is email activity daily digest; <code>false</code> otherwise
     */
    public boolean isEmailActivityDailyDigest();

    /**
     * Sets whether this messaging user preferences is email activity daily digest.
     *
     * @param emailActivityDailyDigest the email activity daily digest of this messaging user preferences
     */
    public void setEmailActivityDailyDigest(boolean emailActivityDailyDigest);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(
        com.ext.portlet.model.MessagingUserPreferences messagingUserPreferences);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.MessagingUserPreferences> toCacheModel();

    @Override
    public com.ext.portlet.model.MessagingUserPreferences toEscapedModel();

    @Override
    public com.ext.portlet.model.MessagingUserPreferences toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
