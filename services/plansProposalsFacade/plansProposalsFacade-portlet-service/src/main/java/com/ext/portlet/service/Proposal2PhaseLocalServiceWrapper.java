package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Proposal2PhaseLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Proposal2PhaseLocalService
 * @generated
 */
public class Proposal2PhaseLocalServiceWrapper
    implements Proposal2PhaseLocalService,
        ServiceWrapper<Proposal2PhaseLocalService> {
    private Proposal2PhaseLocalService _proposal2PhaseLocalService;

    public Proposal2PhaseLocalServiceWrapper(
        Proposal2PhaseLocalService proposal2PhaseLocalService) {
        _proposal2PhaseLocalService = proposal2PhaseLocalService;
    }

    /**
    * Adds the proposal2 phase to the database. Also notifies the appropriate model listeners.
    *
    * @param proposal2Phase the proposal2 phase
    * @return the proposal2 phase that was added
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.Proposal2Phase addProposal2Phase(
        com.ext.portlet.model.Proposal2Phase proposal2Phase)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.addProposal2Phase(proposal2Phase);
    }

    /**
    * Creates a new proposal2 phase with the primary key. Does not add the proposal2 phase to the database.
    *
    * @param proposal2PhasePK the primary key for the new proposal2 phase
    * @return the new proposal2 phase
    */
    public com.ext.portlet.model.Proposal2Phase createProposal2Phase(
        com.ext.portlet.service.persistence.Proposal2PhasePK proposal2PhasePK) {
        return _proposal2PhaseLocalService.createProposal2Phase(proposal2PhasePK);
    }

    /**
    * Deletes the proposal2 phase with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param proposal2PhasePK the primary key of the proposal2 phase
    * @throws PortalException if a proposal2 phase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteProposal2Phase(
        com.ext.portlet.service.persistence.Proposal2PhasePK proposal2PhasePK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _proposal2PhaseLocalService.deleteProposal2Phase(proposal2PhasePK);
    }

    /**
    * Deletes the proposal2 phase from the database. Also notifies the appropriate model listeners.
    *
    * @param proposal2Phase the proposal2 phase
    * @throws SystemException if a system exception occurred
    */
    public void deleteProposal2Phase(
        com.ext.portlet.model.Proposal2Phase proposal2Phase)
        throws com.liferay.portal.kernel.exception.SystemException {
        _proposal2PhaseLocalService.deleteProposal2Phase(proposal2Phase);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.ext.portlet.model.Proposal2Phase fetchProposal2Phase(
        com.ext.portlet.service.persistence.Proposal2PhasePK proposal2PhasePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.fetchProposal2Phase(proposal2PhasePK);
    }

    /**
    * Returns the proposal2 phase with the primary key.
    *
    * @param proposal2PhasePK the primary key of the proposal2 phase
    * @return the proposal2 phase
    * @throws PortalException if a proposal2 phase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.Proposal2Phase getProposal2Phase(
        com.ext.portlet.service.persistence.Proposal2PhasePK proposal2PhasePK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.getProposal2Phase(proposal2PhasePK);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the proposal2 phases.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of proposal2 phases
    * @param end the upper bound of the range of proposal2 phases (not inclusive)
    * @return the range of proposal2 phases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.Proposal2Phase> getProposal2Phases(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.getProposal2Phases(start, end);
    }

    /**
    * Returns the number of proposal2 phases.
    *
    * @return the number of proposal2 phases
    * @throws SystemException if a system exception occurred
    */
    public int getProposal2PhasesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.getProposal2PhasesCount();
    }

    /**
    * Updates the proposal2 phase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param proposal2Phase the proposal2 phase
    * @return the proposal2 phase that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.Proposal2Phase updateProposal2Phase(
        com.ext.portlet.model.Proposal2Phase proposal2Phase)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.updateProposal2Phase(proposal2Phase);
    }

    /**
    * Updates the proposal2 phase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param proposal2Phase the proposal2 phase
    * @param merge whether to merge the proposal2 phase with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the proposal2 phase that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.Proposal2Phase updateProposal2Phase(
        com.ext.portlet.model.Proposal2Phase proposal2Phase, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.updateProposal2Phase(proposal2Phase,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _proposal2PhaseLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _proposal2PhaseLocalService.setBeanIdentifier(beanIdentifier);
    }

    public com.ext.portlet.model.Proposal2Phase create(long proposalId,
        long contestPhaseId) {
        return _proposal2PhaseLocalService.create(proposalId, contestPhaseId);
    }

    public com.ext.portlet.model.Proposal2Phase getByProposalIdContestPhaseId(
        long proposalId, long contestPhaseId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.getByProposalIdContestPhaseId(proposalId,
            contestPhaseId);
    }

    public com.ext.portlet.model.Contest getCurrentContestForProposal(
        long proposalId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.getCurrentContestForProposal(proposalId);
    }

    public com.ext.portlet.model.Proposal2Phase getForVersion(
        com.ext.portlet.model.ProposalVersion proposalVersion)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.getForVersion(proposalVersion);
    }

    public java.util.List<java.lang.Long> getContestPhasesForProposal(
        long proposalId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.getContestPhasesForProposal(proposalId);
    }

    public java.util.List<com.ext.portlet.model.ContestPhase> getActiveContestPhasesForProposal(
        long proposalId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _proposal2PhaseLocalService.getActiveContestPhasesForProposal(proposalId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public Proposal2PhaseLocalService getWrappedProposal2PhaseLocalService() {
        return _proposal2PhaseLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedProposal2PhaseLocalService(
        Proposal2PhaseLocalService proposal2PhaseLocalService) {
        _proposal2PhaseLocalService = proposal2PhaseLocalService;
    }

    public Proposal2PhaseLocalService getWrappedService() {
        return _proposal2PhaseLocalService;
    }

    public void setWrappedService(
        Proposal2PhaseLocalService proposal2PhaseLocalService) {
        _proposal2PhaseLocalService = proposal2PhaseLocalService;
    }
}