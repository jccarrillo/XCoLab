package org.xcolab.jsp.tags.judging;

import com.ext.portlet.model.ContestPhase;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.service.ContestPhaseLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.exceptions.MemberNotFoundException;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.portlets.proposals.wrappers.ProposalJudgeWrapper;
import org.xcolab.portlets.proposals.wrappers.ProposalWrapper;
import org.xcolab.util.exceptions.DatabaseAccessException;

import javax.portlet.PortletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class JudgeReviewStatusTag extends BodyTagSupport {
    
    private long userId;

    private long proposalId;

    private long contestPhaseId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProposalId() {
        return proposalId;
    }

    public void setProposalId(long proposalId) {
        this.proposalId = proposalId;
    }

    public long getContestPhaseId() {
        return contestPhaseId;
    }

    public void setContestPhaseId(long contestPhaseId) {
        this.contestPhaseId = contestPhaseId;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            Member judge = MembersClient.getMember(userId);
            Proposal proposal = ProposalLocalServiceUtil.getProposal(proposalId);
            ContestPhase contestPhase = ContestPhaseLocalServiceUtil.getContestPhase(contestPhaseId);
            ProposalJudgeWrapper judgeWrapper = new ProposalJudgeWrapper(new ProposalWrapper(proposal, contestPhase), judge);

            PortletRequest portletRequest = (PortletRequest) pageContext.getAttribute("javax.portlet.request", PageContext.REQUEST_SCOPE);
            if (portletRequest == null) {
                throw new JspException("Can't find portlet request");
            }
            pageContext.setAttribute("judgeReviewStatus", judgeWrapper.getJudgeReviewStatus());
        } catch (PortalException e) {
            throw new IllegalArgumentException("Could not load proposal " +proposalId
                    + " and contest phase " + contestPhaseId);
        } catch (SystemException e) {
            throw new DatabaseAccessException(e);
        } catch (MemberNotFoundException e) {
            throw new IllegalArgumentException("User does not exist: " + id);
        }
        return EVAL_BODY_INCLUDE; 
    }
    
    
}
