package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the PlanAttributeFilter service. Represents a row in the &quot;xcolab_PlanAttributeFilter&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.PlanAttributeFilterModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.PlanAttributeFilterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanAttributeFilter
 * @see com.ext.portlet.model.impl.PlanAttributeFilterImpl
 * @see com.ext.portlet.model.impl.PlanAttributeFilterModelImpl
 * @generated
 */
public interface PlanAttributeFilterModel extends BaseModel<PlanAttributeFilter> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a plan attribute filter model instance should use the {@link PlanAttributeFilter} interface instead.
     */

    /**
     * Returns the primary key of this plan attribute filter.
     *
     * @return the primary key of this plan attribute filter
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this plan attribute filter.
     *
     * @param primaryKey the primary key of this plan attribute filter
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the plan attribute filter ID of this plan attribute filter.
     *
     * @return the plan attribute filter ID of this plan attribute filter
     */
    public long getPlanAttributeFilterId();

    /**
     * Sets the plan attribute filter ID of this plan attribute filter.
     *
     * @param planAttributeFilterId the plan attribute filter ID of this plan attribute filter
     */
    public void setPlanAttributeFilterId(long planAttributeFilterId);

    /**
     * Returns the attribute name of this plan attribute filter.
     *
     * @return the attribute name of this plan attribute filter
     */
    @AutoEscape
    public String getAttributeName();

    /**
     * Sets the attribute name of this plan attribute filter.
     *
     * @param attributeName the attribute name of this plan attribute filter
     */
    public void setAttributeName(String attributeName);

    /**
     * Returns the plan user settings ID of this plan attribute filter.
     *
     * @return the plan user settings ID of this plan attribute filter
     */
    public long getPlanUserSettingsId();

    /**
     * Sets the plan user settings ID of this plan attribute filter.
     *
     * @param planUserSettingsId the plan user settings ID of this plan attribute filter
     */
    public void setPlanUserSettingsId(long planUserSettingsId);

    /**
     * Returns the max of this plan attribute filter.
     *
     * @return the max of this plan attribute filter
     */
    public Double getMax();

    /**
     * Sets the max of this plan attribute filter.
     *
     * @param max the max of this plan attribute filter
     */
    public void setMax(Double max);

    /**
     * Returns the min of this plan attribute filter.
     *
     * @return the min of this plan attribute filter
     */
    public Double getMin();

    /**
     * Sets the min of this plan attribute filter.
     *
     * @param min the min of this plan attribute filter
     */
    public void setMin(Double min);

    /**
     * Returns the string val of this plan attribute filter.
     *
     * @return the string val of this plan attribute filter
     */
    @AutoEscape
    public String getStringVal();

    /**
     * Sets the string val of this plan attribute filter.
     *
     * @param stringVal the string val of this plan attribute filter
     */
    public void setStringVal(String stringVal);

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

    public int compareTo(PlanAttributeFilter planAttributeFilter);

    public int hashCode();

    public CacheModel<PlanAttributeFilter> toCacheModel();

    public PlanAttributeFilter toEscapedModel();

    public String toString();

    public String toXmlString();
}