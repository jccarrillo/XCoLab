package org.xcolab.portlets.proposals.wrappers;

import com.ext.portlet.NoSuchContestException;
import com.ext.portlet.model.Contest;
import com.ext.portlet.model.ContestPhase;
import com.ext.portlet.model.ProposalRating;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.Proposal2PhaseLocalServiceUtil;
import com.ext.portlet.service.ProposalRatingLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import org.xcolab.client.members.MembersClient;

import java.util.List;

public class ProposalFellowWrapper extends ProposalWrapper {

    public ProposalFellowWrapper(ProposalWrapper proposal, User currentUser) throws NoSuchContestException {
        super(proposal);
        try {
            //find out contestPhase
            Contest baseContest = Proposal2PhaseLocalServiceUtil.getCurrentContestForProposal(proposal.getProposalId());
            ContestPhase contestPhase = ContestLocalServiceUtil.getActiveOrLastPhase(baseContest);

            List<ProposalRating> list = ProposalRatingLocalServiceUtil.getFellowRatingForProposalAndUser(
                    currentUser.getUserId(),
                    proposal.getProposalId(),
                    contestPhase.getContestPhasePK());
            this.proposalRatings = new ProposalRatingsWrapper(
                    MembersClient.getMemberUnchecked(currentUser.getUserId()), list);
        } catch (PortalException | SystemException e) {
            this.proposalRatings = null;
        }
    }
}
