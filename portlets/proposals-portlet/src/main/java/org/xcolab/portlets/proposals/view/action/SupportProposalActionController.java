package org.xcolab.portlets.proposals.view.action;

import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xcolab.analytics.AnalyticsUtil;
import org.xcolab.portlets.proposals.exceptions.ProposalsAuthorizationException;
import org.xcolab.portlets.proposals.utils.ProposalsContext;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;

@Controller
@RequestMapping("view")
public class SupportProposalActionController {

    @Autowired
    private ProposalsContext proposalsContext;
    
    private final static String SUPPORT_ANALYTICS_KEY = "SUPPORTED_ENTRIES";
    private final static String SUPPORT_ANALYTICS_CATEGORY = "User";
    private final static String SUPPORT_ANALYTICS_ACTION = "Support contest entry";
    private final static String SUPPORT_ANALYTICS_LABEL = "";

    
    @RequestMapping(params = {"action=supportProposalAction"})
    public synchronized void handleAction(ActionRequest request, Model model, ActionResponse response,
            @RequestParam(required = false) String forwardToTab)
            throws PortalException, SystemException, ProposalsAuthorizationException, IOException {
        
        if (proposalsContext.getPermissions(request).getCanSupportProposal()) {
            long userId = proposalsContext.getUser(request).getUserId();
            long proposalId = proposalsContext.getProposal(request).getProposalId();

            if (ProposalLocalServiceUtil.isSupporter(proposalId, userId)) {
                ProposalLocalServiceUtil.removeSupporter(proposalId, userId);
            }
            else {
                ProposalLocalServiceUtil.addSupporter(proposalId, userId);
                int supportedCount = ProposalLocalServiceUtil.getUserSupportedProposalsCount(userId);
                if (supportedCount > 0) {
                    int analyticsValue = AnalyticsUtil.getAnalyticsValueForCount(supportedCount);
                    AnalyticsUtil.publishEvent(request, userId, SUPPORT_ANALYTICS_KEY + analyticsValue,
            			SUPPORT_ANALYTICS_CATEGORY,
            			SUPPORT_ANALYTICS_ACTION,
            			SUPPORT_ANALYTICS_LABEL,
            			analyticsValue);
                }
            }
            String proposalLinkUrl = ProposalLocalServiceUtil.getProposalLinkUrl(proposalId);
            if (!StringUtils.isBlank(forwardToTab)) {
                proposalLinkUrl += "/tab/" + forwardToTab;
            }
            response.sendRedirect(proposalLinkUrl);
        }
        else {
            throw new ProposalsAuthorizationException("User isn't allowed to toggle support for proposal");
        }
    }

}
