package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ProposalMoveHistory service. Represents a row in the &quot;xcolab_ProposalMoveHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ProposalMoveHistoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ProposalMoveHistoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalMoveHistory
 * @see com.ext.portlet.model.impl.ProposalMoveHistoryImpl
 * @see com.ext.portlet.model.impl.ProposalMoveHistoryModelImpl
 * @generated
 */
public interface ProposalMoveHistoryModel extends BaseModel<ProposalMoveHistory> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a proposal move history model instance should use the {@link ProposalMoveHistory} interface instead.
     */

    /**
     * Returns the primary key of this proposal move history.
     *
     * @return the primary key of this proposal move history
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this proposal move history.
     *
     * @param primaryKey the primary key of this proposal move history
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the id_ of this proposal move history.
     *
     * @return the id_ of this proposal move history
     */
    public long getId_();

    /**
     * Sets the id_ of this proposal move history.
     *
     * @param id_ the id_ of this proposal move history
     */
    public void setId_(long id_);

    /**
     * Returns the source proposal ID of this proposal move history.
     *
     * @return the source proposal ID of this proposal move history
     */
    public long getSourceProposalId();

    /**
     * Sets the source proposal ID of this proposal move history.
     *
     * @param sourceProposalId the source proposal ID of this proposal move history
     */
    public void setSourceProposalId(long sourceProposalId);

    /**
     * Returns the source contest ID of this proposal move history.
     *
     * @return the source contest ID of this proposal move history
     */
    public long getSourceContestId();

    /**
     * Sets the source contest ID of this proposal move history.
     *
     * @param sourceContestId the source contest ID of this proposal move history
     */
    public void setSourceContestId(long sourceContestId);

    /**
     * Returns the source phase ID of this proposal move history.
     *
     * @return the source phase ID of this proposal move history
     */
    public long getSourcePhaseId();

    /**
     * Sets the source phase ID of this proposal move history.
     *
     * @param sourcePhaseId the source phase ID of this proposal move history
     */
    public void setSourcePhaseId(long sourcePhaseId);

    /**
     * Returns the target proposal ID of this proposal move history.
     *
     * @return the target proposal ID of this proposal move history
     */
    public long getTargetProposalId();

    /**
     * Sets the target proposal ID of this proposal move history.
     *
     * @param targetProposalId the target proposal ID of this proposal move history
     */
    public void setTargetProposalId(long targetProposalId);

    /**
     * Returns the target contest ID of this proposal move history.
     *
     * @return the target contest ID of this proposal move history
     */
    public long getTargetContestId();

    /**
     * Sets the target contest ID of this proposal move history.
     *
     * @param targetContestId the target contest ID of this proposal move history
     */
    public void setTargetContestId(long targetContestId);

    /**
     * Returns the target phase ID of this proposal move history.
     *
     * @return the target phase ID of this proposal move history
     */
    public long getTargetPhaseId();

    /**
     * Sets the target phase ID of this proposal move history.
     *
     * @param targetPhaseId the target phase ID of this proposal move history
     */
    public void setTargetPhaseId(long targetPhaseId);

    /**
     * Returns the moving user ID of this proposal move history.
     *
     * @return the moving user ID of this proposal move history
     */
    public long getMovingUserId();

    /**
     * Sets the moving user ID of this proposal move history.
     *
     * @param movingUserId the moving user ID of this proposal move history
     */
    public void setMovingUserId(long movingUserId);

    /**
     * Returns the moving user uuid of this proposal move history.
     *
     * @return the moving user uuid of this proposal move history
     * @throws SystemException if a system exception occurred
     */
    public String getMovingUserUuid() throws SystemException;

    /**
     * Sets the moving user uuid of this proposal move history.
     *
     * @param movingUserUuid the moving user uuid of this proposal move history
     */
    public void setMovingUserUuid(String movingUserUuid);

    /**
     * Returns the move date of this proposal move history.
     *
     * @return the move date of this proposal move history
     */
    public Date getMoveDate();

    /**
     * Sets the move date of this proposal move history.
     *
     * @param moveDate the move date of this proposal move history
     */
    public void setMoveDate(Date moveDate);

    /**
     * Returns the move type of this proposal move history.
     *
     * @return the move type of this proposal move history
     */
    @AutoEscape
    public String getMoveType();

    /**
     * Sets the move type of this proposal move history.
     *
     * @param moveType the move type of this proposal move history
     */
    public void setMoveType(String moveType);

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
        com.ext.portlet.model.ProposalMoveHistory proposalMoveHistory);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.ProposalMoveHistory> toCacheModel();

    @Override
    public com.ext.portlet.model.ProposalMoveHistory toEscapedModel();

    @Override
    public com.ext.portlet.model.ProposalMoveHistory toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
