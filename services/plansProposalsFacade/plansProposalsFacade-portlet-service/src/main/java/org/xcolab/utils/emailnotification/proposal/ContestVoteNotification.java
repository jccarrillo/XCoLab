package org.xcolab.utils.emailnotification.proposal;

import com.ext.portlet.model.Contest;
import com.ext.portlet.model.Proposal;
import com.liferay.portal.service.ServiceContext;

import org.xcolab.client.members.pojo.Member;
import org.xcolab.utils.LinkUtils;
import org.xcolab.utils.emailnotification.basic.ProposalNotification;

public class ContestVoteNotification extends ProposalNotification {

    private static final String DEFAULT_TEMPLATE_STRING = "CONTEST_VOTE_DEFAULT";

    public ContestVoteNotification(Member recipient, Contest contest, Proposal votedProposal,
            ServiceContext serviceContext) {
        super(votedProposal, contest, recipient,
                LinkUtils.getNonBlankStringOrDefault(contest.getVoteTemplateString(), DEFAULT_TEMPLATE_STRING),
                serviceContext);
    }
}
