package org.xcolab.hooks.climatecolab.strutsaction;

import com.ext.portlet.ProposalAttributeKeys;
import com.ext.portlet.messaging.MessageUtil;
import com.ext.portlet.model.ContestType;
import com.ext.portlet.service.ContestTypeLocalServiceUtil;
import com.ext.portlet.service.ProposalAttributeLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.MembershipRequest;
import com.liferay.portal.model.User;
import com.liferay.portal.service.MembershipRequestLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.mail.MailEngineException;

import org.xcolab.util.exceptions.InternalException;
import org.xcolab.utils.TemplateReplacementUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProposalMembershipInvitationResponseStrutsAction extends BaseStrutsAction {

	private static final String MSG_MEMBERSHIP_INVITE_RESPONSE_SUBJECT = "Response to your membership invite";

	/**
	 * The response message when the proposal membership invitee accepts the invitation
	 */
	private static final String MSG_MEMBERSHIP_INVITE_RESPONSE_CONTENT_ACCEPTED = "Your invitation of %s to join the <proposal/> %s has been accepted.";

	/**
	 * The response message when the proposal membership invitee rejects the invitation
	 */
	private static final String MSG_MEMBERSHIP_INVITE_RESPONSE_CONTENT_REJECTED = "Your invitation of %s to join the <proposal/> %s has been rejected.";


	@Override
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws PortalException, SystemException, IOException {

		long membershipId = GetterUtil.get(request.getParameter("requestId"), 0L);
		long proposalId = GetterUtil.get(request.getParameter("proposalId"), 0L);
		String action = request.getParameter("do");

		MembershipRequest membershipRequest = MembershipRequestLocalServiceUtil.getMembershipRequest(membershipId);

		List<Long> recipients = new ArrayList<>();
		List<User> contributors = ProposalLocalServiceUtil.getMembers(proposalId);

		for (User user : contributors) {
			recipients.add(user.getUserId());
		}

		ContestType contestType = ContestTypeLocalServiceUtil.getContestTypeFromProposalId(proposalId);
		String proposalName = ProposalAttributeLocalServiceUtil.getAttribute(proposalId, ProposalAttributeKeys.NAME,0).getStringValue();
		String proposalLink = String.format("<a href='%s'>%s</a>", ProposalLocalServiceUtil.getProposalLinkUrl(proposalId), proposalName);

		if (membershipRequest != null) {
			User invitee = UserLocalServiceUtil.getUserById(membershipRequest.getUserId());
			if (action.equalsIgnoreCase("ACCEPT")) {
				ProposalLocalServiceUtil.approveMembershipRequest(proposalId, membershipRequest.getUserId(), membershipRequest, "The invitation was accepted.", invitee.getUserId());
                final String membershipAcceptedMessage = TemplateReplacementUtil.replaceContestTypeStrings(MSG_MEMBERSHIP_INVITE_RESPONSE_CONTENT_ACCEPTED, contestType);
                sendMessage(invitee.getUserId(),recipients,MSG_MEMBERSHIP_INVITE_RESPONSE_SUBJECT,String.format(membershipAcceptedMessage, invitee.getFullName(), proposalLink));
			} else if (action.equalsIgnoreCase("DECLINE")) {
				ProposalLocalServiceUtil.dennyMembershipRequest(proposalId, membershipRequest.getUserId(), membershipId, "The invitation was rejected.", invitee.getUserId());
                final String membershipRejectedMessage = TemplateReplacementUtil.replaceContestTypeStrings(MSG_MEMBERSHIP_INVITE_RESPONSE_CONTENT_REJECTED, contestType);
                sendMessage(invitee.getUserId(),recipients,MSG_MEMBERSHIP_INVITE_RESPONSE_SUBJECT,String.format(membershipRejectedMessage, invitee.getFullName(), proposalLink));
			}
		}

		response.sendRedirect(ProposalLocalServiceUtil.getProposalLinkUrl(proposalId));
		return StringPool.BLANK;
	}

	private void sendMessage(long sender, List<Long> recipients, String subject, String content) {
		try{
			MessageUtil.sendMessage(subject, content, sender, sender, recipients);
		} catch (AddressException | MailEngineException | UnsupportedEncodingException e) {
			throw new InternalException("Could not send message " + subject, e);
		}
	}
}
