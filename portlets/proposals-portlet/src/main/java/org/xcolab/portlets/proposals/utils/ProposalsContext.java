package org.xcolab.portlets.proposals.utils;

import com.ext.portlet.model.Contest;
import com.ext.portlet.model.ContestPhase;
import com.ext.portlet.model.ContestType;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.Proposal2Phase;
import com.liferay.portal.model.User;

import org.xcolab.client.members.pojo.Member;
import org.xcolab.portlets.proposals.permissions.ProposalsDisplayPermissions;
import org.xcolab.portlets.proposals.permissions.ProposalsPermissions;
import org.xcolab.portlets.proposals.wrappers.ContestWrapper;
import org.xcolab.portlets.proposals.wrappers.ProposalWrapper;
import org.xcolab.portlets.proposals.wrappers.ProposalsPreferencesWrapper;
import org.xcolab.wrappers.BaseContestPhaseWrapper;

import javax.portlet.PortletRequest;

public interface ProposalsContext {

    Contest getContest(PortletRequest request);

    ContestPhase getContestPhase(PortletRequest request);

    Proposal getProposal(PortletRequest request);

    ProposalsPermissions getPermissions(PortletRequest request);

    ProposalsDisplayPermissions getDisplayPermissions(PortletRequest request);

    Proposal2Phase getProposal2Phase(PortletRequest request);

    Long getViewContestPhaseId(PortletRequest request);

    ProposalWrapper getProposalWrapped(PortletRequest request);

    ContestWrapper getContestWrapped(PortletRequest request);

    BaseContestPhaseWrapper getContestPhaseWrapped(PortletRequest request);

    ContestType getContestType(PortletRequest request);

    User getUser(PortletRequest request);

    Member getMember(PortletRequest request);

    void invalidateContext(PortletRequest request);

    ProposalsPreferencesWrapper getProposalsPreferences(PortletRequest request);

}