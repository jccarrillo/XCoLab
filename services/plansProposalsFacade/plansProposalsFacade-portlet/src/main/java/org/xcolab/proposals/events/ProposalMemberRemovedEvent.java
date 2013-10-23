package org.xcolab.proposals.events;

import com.ext.portlet.model.Proposal;
import com.liferay.portal.model.User;

public class ProposalMemberRemovedEvent extends BaseProposalUserActivityEvent {

    public ProposalMemberRemovedEvent(Proposal proposal, User user) {
        super(proposal, user);
    }

}
