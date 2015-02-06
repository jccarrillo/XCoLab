package org.xcolab.portlets.proposals.view;

import com.ext.portlet.model.DiscussionCategoryGroup;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.service.ContestPhaseTypeLocalServiceUtil;
import com.ext.portlet.service.DiscussionCategoryGroupLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xcolab.enums.MemberRole;
import org.xcolab.portlets.proposals.utils.ProposalsContext;
import org.xcolab.portlets.proposals.wrappers.ProposalTab;

import javax.portlet.PortletRequest;

@Controller
@RequestMapping("view")
public class ProposalDiscussionTabController extends BaseProposalTabController {
    @Autowired
    private ProposalsContext proposalsContext;
    
    @RequestMapping(params = {"pageToDisplay=proposalDetails_DISCUSSION"})
    public String showDiscussion(PortletRequest request, Model model)
            throws PortalException, SystemException  {

        try {
            if(isPhaseStatusClosedOrOpenForSubmission(request)) {
                model.addAttribute("showDiscussion", false);
            } else {
                Long discussionId = ProposalLocalServiceUtil.getDiscussionIdAndGenerateIfNull(proposalsContext.getProposal(request));
                model.addAttribute("discussionId", discussionId);
                model.addAttribute("showDiscussion", true);
                model.addAttribute("authorId", proposalsContext.getProposal(request).getAuthorId());
                model.addAttribute("proposalId", proposalsContext.getProposal(request).getProposalId());
            }
        } catch (Exception e){
            model.addAttribute("showDiscussion", false);
        }

        setCommonModelAndPageAttributes(request, model, ProposalTab.DISCUSSION);
        return "proposalDiscussion";
    }

    private boolean isPhaseStatusClosedOrOpenForSubmission(PortletRequest request
    ) throws SystemException, PortalException {
        Long contestPhaseType = proposalsContext.getContestPhase(request).getContestPhaseType();
        boolean phaseStatusOpenForSubmission =
                ContestPhaseTypeLocalServiceUtil.getContestPhaseType(contestPhaseType).getStatus().equalsIgnoreCase("OPEN_FOR_SUBMISSION");
        boolean phaseStatusClosed =
                ContestPhaseTypeLocalServiceUtil.getContestPhaseType(contestPhaseType).getStatus().equalsIgnoreCase("CLOSED");
        return phaseStatusOpenForSubmission || phaseStatusClosed;
    }

    private boolean isUserFellowOrJudge(User user){
        boolean fellow = false;
        boolean judge = false;

        try {
            judge = RoleLocalServiceUtil.hasUserRole(user.getUserId(), MemberRole.JUDGES.getRoleId());
            fellow = RoleLocalServiceUtil.hasUserRole(user.getUserId(), MemberRole.FELLOW.getRoleId());
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return fellow || judge;
    }

    private boolean isUserProposalAuthorOrTeamMember(User user, Proposal proposal){

        try {
            boolean author = proposal.getAuthorId() == user.getUserId();
            boolean member = ProposalLocalServiceUtil.isUserAMember(proposal.getProposalId(), user.getUserId());
            return author || member;
        } catch (PortalException | SystemException e) {
        }

        return false;
    }

    private boolean isUserAllowToAddComments(User user, Proposal proposal){
        return isUserFellowOrJudge(user) || isUserProposalAuthorOrTeamMember(user, proposal);
    }
    
}
