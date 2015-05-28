package com.ext.portlet.model;

import com.ext.portlet.service.persistence.Users_RolesPK;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Users_Roles service. Represents a row in the &quot;xcolab_Users_Roles&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.Users_RolesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.Users_RolesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Users_Roles
 * @see com.ext.portlet.model.impl.Users_RolesImpl
 * @see com.ext.portlet.model.impl.Users_RolesModelImpl
 * @generated
 */
public interface Users_RolesModel extends BaseModel<Users_Roles> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a users_ roles model instance should use the {@link Users_Roles} interface instead.
     */

    /**
     * Returns the primary key of this users_ roles.
     *
     * @return the primary key of this users_ roles
     */
    public Users_RolesPK getPrimaryKey();

    /**
     * Sets the primary key of this users_ roles.
     *
     * @param primaryKey the primary key of this users_ roles
     */
    public void setPrimaryKey(Users_RolesPK primaryKey);

    /**
     * Returns the user ID of this users_ roles.
     *
     * @return the user ID of this users_ roles
     */
    public long getUserId();

    /**
     * Sets the user ID of this users_ roles.
     *
     * @param userId the user ID of this users_ roles
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this users_ roles.
     *
     * @return the user uuid of this users_ roles
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this users_ roles.
     *
     * @param userUuid the user uuid of this users_ roles
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the role ID of this users_ roles.
     *
     * @return the role ID of this users_ roles
     */
    public long getRoleId();

    /**
     * Sets the role ID of this users_ roles.
     *
     * @param roleId the role ID of this users_ roles
     */
    public void setRoleId(long roleId);

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
    public int compareTo(Users_Roles users_Roles);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Users_Roles> toCacheModel();

    @Override
    public Users_Roles toEscapedModel();

    @Override
    public Users_Roles toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}