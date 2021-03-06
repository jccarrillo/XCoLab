package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ContestTeamMemberRole service. Represents a row in the &quot;xcolab_ContestTeamMemberRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ContestTeamMemberRoleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ContestTeamMemberRoleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestTeamMemberRole
 * @see com.ext.portlet.model.impl.ContestTeamMemberRoleImpl
 * @see com.ext.portlet.model.impl.ContestTeamMemberRoleModelImpl
 * @generated
 */
public interface ContestTeamMemberRoleModel extends BaseModel<ContestTeamMemberRole> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a contest team member role model instance should use the {@link ContestTeamMemberRole} interface instead.
     */

    /**
     * Returns the primary key of this contest team member role.
     *
     * @return the primary key of this contest team member role
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this contest team member role.
     *
     * @param primaryKey the primary key of this contest team member role
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this contest team member role.
     *
     * @return the ID of this contest team member role
     */
    public long getId();

    /**
     * Sets the ID of this contest team member role.
     *
     * @param id the ID of this contest team member role
     */
    public void setId(long id);

    /**
     * Returns the role of this contest team member role.
     *
     * @return the role of this contest team member role
     */
    @AutoEscape
    public String getRole();

    /**
     * Sets the role of this contest team member role.
     *
     * @param role the role of this contest team member role
     */
    public void setRole(String role);

    /**
     * Returns the sort of this contest team member role.
     *
     * @return the sort of this contest team member role
     */
    public int getSort();

    /**
     * Sets the sort of this contest team member role.
     *
     * @param sort the sort of this contest team member role
     */
    public void setSort(int sort);

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
        com.ext.portlet.model.ContestTeamMemberRole contestTeamMemberRole);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.ContestTeamMemberRole> toCacheModel();

    @Override
    public com.ext.portlet.model.ContestTeamMemberRole toEscapedModel();

    @Override
    public com.ext.portlet.model.ContestTeamMemberRole toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
