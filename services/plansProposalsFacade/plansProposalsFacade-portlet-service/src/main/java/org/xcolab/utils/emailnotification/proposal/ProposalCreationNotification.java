package org.xcolab.utils.emailnotification.proposal;

import com.ext.portlet.model.Contest;
import com.ext.portlet.model.Proposal;
import com.liferay.portal.service.ServiceContext;

import org.xcolab.client.members.MembersClient;
import org.xcolab.utils.LinkUtils;
import org.xcolab.utils.emailnotification.basic.ProposalNotification;

public class ProposalCreationNotification extends ProposalNotification {

    private static final String DEFAULT_TEMPLATE_STRING = "PROPOSAL_CREATION_DEFAULT";

    public ProposalCreationNotification(Proposal createdProposal, Contest contest,
            ServiceContext serviceContext) {
        super(createdProposal, contest, MembersClient.getMemberUnchecked(createdProposal.getAuthorId()),
                LinkUtils.getNonBlankStringOrDefault(contest.getProposalCreationTemplateString(),
                        DEFAULT_TEMPLATE_STRING),
                serviceContext);
    }
}
