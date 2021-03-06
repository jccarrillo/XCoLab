package com.ext.portlet.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the PointDistributionTarget service. Represents a row in the &quot;xcolab_PointDistributionTarget&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.PointDistributionTargetModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.PointDistributionTargetImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PointDistributionTarget
 * @see com.ext.portlet.model.impl.PointDistributionTargetImpl
 * @see com.ext.portlet.model.impl.PointDistributionTargetModelImpl
 * @generated
 */
public interface PointDistributionTargetModel extends BaseModel<PointDistributionTarget> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a point distribution target model instance should use the {@link PointDistributionTarget} interface instead.
     */

    /**
     * Returns the primary key of this point distribution target.
     *
     * @return the primary key of this point distribution target
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this point distribution target.
     *
     * @param primaryKey the primary key of this point distribution target
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this point distribution target.
     *
     * @return the ID of this point distribution target
     */
    public long getId();

    /**
     * Sets the ID of this point distribution target.
     *
     * @param id the ID of this point distribution target
     */
    public void setId(long id);

    /**
     * Returns the contest ID of this point distribution target.
     *
     * @return the contest ID of this point distribution target
     */
    public long getContestId();

    /**
     * Sets the contest ID of this point distribution target.
     *
     * @param contestId the contest ID of this point distribution target
     */
    public void setContestId(long contestId);

    /**
     * Returns the proposal ID of this point distribution target.
     *
     * @return the proposal ID of this point distribution target
     */
    public long getProposalId();

    /**
     * Sets the proposal ID of this point distribution target.
     *
     * @param proposalId the proposal ID of this point distribution target
     */
    public void setProposalId(long proposalId);

    /**
     * Returns the number of points of this point distribution target.
     *
     * @return the number of points of this point distribution target
     */
    public double getNumberOfPoints();

    /**
     * Sets the number of points of this point distribution target.
     *
     * @param numberOfPoints the number of points of this point distribution target
     */
    public void setNumberOfPoints(double numberOfPoints);

    /**
     * Returns the point type override of this point distribution target.
     *
     * @return the point type override of this point distribution target
     */
    public long getPointTypeOverride();

    /**
     * Sets the point type override of this point distribution target.
     *
     * @param pointTypeOverride the point type override of this point distribution target
     */
    public void setPointTypeOverride(long pointTypeOverride);

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
        com.ext.portlet.model.PointDistributionTarget pointDistributionTarget);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.PointDistributionTarget> toCacheModel();

    @Override
    public com.ext.portlet.model.PointDistributionTarget toEscapedModel();

    @Override
    public com.ext.portlet.model.PointDistributionTarget toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
