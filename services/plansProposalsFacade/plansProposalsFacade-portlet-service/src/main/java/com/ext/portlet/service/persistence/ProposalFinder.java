package com.ext.portlet.service.persistence;

public interface ProposalFinder {
    public java.util.List<com.ext.portlet.model.Proposal> findByContestPhaseIdAndVisible(
        long contestPhaseId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;
}
