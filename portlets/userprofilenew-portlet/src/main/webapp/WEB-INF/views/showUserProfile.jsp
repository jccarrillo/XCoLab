<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:collab="http://climatecolab.org/tags/collab_1.0"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:form="http://www.springframework.org/tags/form"
    xmlns:portlet="http://java.sun.com/portlet_2_0" version="2.0">

    <jsp:directive.include file="./init.jspx" />

	<c:if test="${messageSent}">
		<script type="text/javascript" >
			messageSent();
		</script>
	</c:if>

	<c:if test="${limitExceeded}">
		<script type="text/javascript" >
			limitExceeded();
		</script>
	</c:if>

	<c:if test="${updateSuccess}">
		<script type="text/javascript" >
			updateSuccess();
		</script>
	</c:if>


	<div id="bread" class="pro">
		<a href="/web/guest/community">Community</a> <img
			src="/climatecolab-theme/images/arrow.gif" width="8" height="8" /> <a
			href="/web/guest/members">Members</a> <img
			src="/climatecolab-theme/images/arrow.gif" width="8" height="8" /> <a
			href="/web/guest/member/-/member/userId/${currentUser.userId}">${userBean.screenName}</a>
	</div>

	<div id="main" class="${currentUser.viewingOwnProfile ? '' : 'full'} userProfile">
		<h1>Member Profile</h1>
		<div class="profile_action">
		<c:if test="${currentUser.viewingOwnProfile}">
			<div class="blue-button">
				<a href="/web/guest/member/-/member/userId/${currentUser.userId}/page/edit">Manage profile and settings</a>
			</div>
		</c:if>

		<c:if test="${currentUser.canSendMessage and not currentUser.viewingOwnProfile }">
			<div class="blue-button">
			<a href="javascript:;"
			   onclick="if (!deferUntilLogin()) { return false; } else { showSendMessageForm(); }">Send
				<strong>${userBean.firstName}</strong> a Message </a>
			</div>
		</c:if>
		</div>
		<div class="comm_member" style="margin-top: 0;">

			<c:if test="${currentUser.attendsConference}">
				<a href="/web/guest/conference2014" class="attendingConference"><img src="/climatecolab-theme/images/attending-conference.png" alt="Attends MIT Conference 2014"/></a>
			</c:if>

			<div class="badge-container">
				<c:forEach var="badge" items="${currentUser.badges}">
					<div class="badge-big badge-${badge.badgeType}">

                        <span class="badge-title">
                            <a href="/web/guest/plans/-/plans/contestId/${badge.contestId}/planId/${badge.planId}" style="${badge.badgeTitle.length() gt 8 ? 'top: 26px;' : ''};">${badge.badgeTitle}</a>
                        </span>

						<div class="badge-text" style="${badge.badgeText.length() gt 15 ? 'font-size: 7px;' : ''}${fn:substring(badge.badgeText,0,6) eq 'Judges' ? 'width: 47px;' : ''}">${badge.badgeText.length() gt 13 ? badge.badgeText : ''}</div>
						<span class="badge-year">${badge.badgeYear}</span>
					</div>
				</c:forEach>
			</div>

			<div class="comm_member-photo">
				<img src="${baseImagePath}${userBean.portrait}" width="150" height="150"
					 alt="${currentUser.realName}" />
			</div>

			<div class="comm_member-info">
				<table border="0" cellpadding="0" cellspacing="0" class="colab members topInfo">
					<tbody>
					<!-- <tr>
							<td colspan="2"><h2>Member Profile</h2></td>
						</tr> -->
						<tr>
							<td class="memname">${currentUser.realName}</td>
						</tr>
						<tr>
							<td>
								<div class="role-indicator" style="margin-top: 5px;">
									<div style="width: 16px">
										<img 	src="/climatecolab-theme/images/icon_mem-${currentUser.role.lowerCase}.png"
												width="16" height="16" />
									</div>
									${currentUser.role.printName}
								</div>
							</td>
						</tr>
					</tbody>
				</table>

				<div class="memdiv" style="background-color:#707070;">.</div>

				<table border="0" cellpadding="0" cellspacing="0" class="colab members otherInfo" style="width:300px;">
					<tbody>
					<tr>
						<td class="b" nowrap="nowrap" width="50%">Screen Name</td>
						<td>${userBean.screenName}</td>
					</tr>
					<tr>
						<td class="b" nowrap="nowrap" width="50%">Member Since</td>
						<td>
							<fmt:formatDate value="${currentUser.joinDate}" type="date" dateStyle="short" timeZone="America/New_York" />
						</td>
					</tr>

					<c:if test="${currentUser.viewingOwnProfile}">
						<tr>
							<td class="b" width="50%">Email</td>
							<td width="50%">
								<a href="mailto:${userBean.email}">${userBean.emailStored}</a>

								<c:if test="${currentUser.displayEMailErrorMessage}">
									<span class="iceMsgError portlet-msg-error Error form_error_messageError">Please update your email address. Only votes from members with valid email addresses will be counted. </span>
								</c:if>

							</td>
						</tr>
					</c:if>

					<c:if test="${not empty userBean.country}">
						<tr>
							<td class="b" width="50%">Country</td>
							<td width="50%">${userBean.country}</td>
						</tr>
					</c:if>

					</tbody>
				</table>
			</div>
			<div class="clearfix">&#160;</div>
		</div>

		<h2 style="margin-top: 20px;">Short Bio</h2>
		<p>
			${userBean.shortBio}
		</p>

		<h2 style="margin-top: 20px;">Proposals</h2>
		<c:if test="${empty currentUser.proposals}">
				${userBean.firstName} has not yet contributed to any Climate CoLab proposals.
		</c:if>

		<table class="colab">
			<c:forEach var="proposal" items="${currentUser.proposals}">
				<tr class="colabRow">
					<td>

						<collab:planLink planId="${proposal.planId}"
										 contestId="${proposal.contestId}"
										 text="${proposal.proposalName}" />
					</td>
					<td style="text-align: right;"><fmt:formatDate value="${proposal.proposalCreationDate}" type="date" dateStyle="short" timeZone="America/New_York" /></td>
				</tr>
			</c:forEach>
		</table>

		<h2>Supporting</h2>
		<c:if test="${empty currentUser.supportedPlans}">
				${userBean.firstName} has not yet supported any Climate CoLab proposals.
		</c:if>

		<table class="colab">
			<c:forEach var="supportedPlan" items="${currentUser.supportedPlans}">
				<tr class="colabRow">
					<td>
						<collab:planLink planId="${supportedPlan.planId}"
														 contestId="${supportedPlan.contestId}"
														 text="${supportedPlan.planName}" />
					</td>
					<td style="text-align: right;"><fmt:formatDate value="${supportedPlan.createdDate}" type="date" dateStyle="short" timeZone="America/New_York" /></td>
				</tr>
			</c:forEach>
		</table>

		<h2 style="margin-top: 20px;">Activities</h2>

		<table class="colab">
			<c:forEach var="activity" items="${currentUser.activities}">
				<tr class="colabRow">
					<td>${activity.body}</td>
					<td style="text-align: right;"><fmt:formatDate value="${activity.createdDate}" type="date" dateStyle="short" timeZone="America/New_York" /></td>
				</tr>
			</c:forEach>
		</table>

		<div class="blue-button">
			<a href="/web/guest/activities/-/feeds?userId=${currentUser.userId}">SEE ALL</a>
		</div>
	</div>
	<!-- /main -->

	<c:if test="${currentUser.viewingOwnProfile}">
		<div class="right_col3">
			<div class="comm_rightcol">
				<div class="comm_rightcol-title">INBOX</div>

				<c:if test="${empty currentUser.messages}">
					<p>No new messages.</p>
				</c:if>

				<c:forEach var="message" items="${currentUser.messages}"> <!-- test="${not empty currentUser.messages}" -->

					<div class="comm_rightcol-time">
						<c:choose>
							<c:when test="${message.daysAgo == 0}">
								Today
							</c:when>
							<c:when test="${message.daysAgo == 1}">
								Yesterday
							</c:when>
							<c:when test="${message.daysAgo > 1}">
									${message.daysAgo} days ago
							</c:when>
						</c:choose>
						&#160;
						<fmt:formatDate value="${message.createDate}" type="time" timeStyle="medium" timeZone="America/New_York" />
					</div>

					<div class="activityBody">
						<collab:userLinkSimple text="${message.from.screenName}" userId="${message.from.userId}" />
						sent you a message:&#160; <a
							href="/web/guest/messaging?p_p_id=${currentUser.messagingPortletId}&amp;messageId=${message.messageId}">${message.subject}</a>
					</div>

				</c:forEach>

				<div class="rounded_button brn">
					<a href="/web/guest/messaging?p_p_id=${currentUser.messagingPortletId}&amp;compose=true">COMPOSE</a>
				</div>

				<div class="rounded_button brn">
					<a href="/web/guest/messaging">ALL MESSAGES</a>
				</div>

				<div class="clearfix"></div>
			</div>

			<div class="comm_rightcol">
				<form:form>
					<div class="comm_rightcol-title">SUBSCRIBED ACTIVITY</div>

					<c:if test="${empty currentUser.subscribedActivities}">
						<p>No new activities.</p>
					</c:if>

					<c:forEach var="activity" items="${currentUser.subscribedActivities}" begin="0" end="5"> <!-- test="${not empty currentUser.subscribedActivities}" -->

						<div class="comm_rightcol-time">
							<c:choose>
								<c:when test="${activity.daysAgo == 0}">
									Today
								</c:when>
								<c:when test="${activity.daysAgo == 1}">
									Yesterday
								</c:when>
								<c:when test="${activity.daysAgo > 1}">
									${activity.daysAgo} days ago
								</c:when>
							</c:choose>
							&#160;
							<fmt:formatDate value="${activity.createdDate}" type="time" timeStyle="medium" timeZone="America/New_York" />
						</div>

						<div class="activityBody">
								${activity.body}
						</div>

					</c:forEach>

					<div class="rounded_button brn">
						<a href="/web/guest/member/-/member/userId/${currentUser.userId}/page/subscriptionsManage">MANAGE</a>
					</div>

					<div class="rounded_button brn">
						<c:if test="${not empty currentUser.subscribedActivities}">
							<a href="/web/guest/member/-/member/userId/${currentUser.userId}/page/subscriptions">SEE ALL</a>
						</c:if>
					</div>
				</form:form>
			</div>
		</div>
	</c:if>
	<!-- /right_col -->

	<div id="sendMessageOverlay" class="sendMessagePopup"
		 style="position: fixed; width: 100%; height: 100%; top: 0; left: 0; z-index: 100; display: none;">
		<div class="savechanges-wrap ">
			<div class="savechanges">
				<h4>Send <strong>${currentUser.realName}</strong> a message</h4>

				<portlet:actionURL var="sendMessageForm" >
					<portlet:param name="action" value="send" />
				</portlet:actionURL>

				<form:form action="${sendMessageForm }" commandName="messageBean" id="messageForm">
					<input type="hidden" name="action" value="send" />
					<div class="reg_errors"><!--  --></div>
					<form:errors cssClass="alert alert-error" />

					<div>
						<p>
							<strong>Subject:</strong> &#160; <span class="error hidden">
								* value required</span><br />
							<form:input cssClass="popuplogin_input sendMessage_subject" path="messageSubject" /><br />
						</p>

						<c:if test="${messageBean.messageHoneypotPosition eq 0}">
							<p class="p">
								<strong>Leave this blank:</strong> &#160;  <span class="error hidden">
								* value required</span><br />
								<form:input cssClass="popuplogin_input sendMessage_subject" path="messageHoneypot" /><br />
							</p>
						</c:if>

						<p>
							<strong>Message:</strong> &#160;
							<form:textarea cssClass="popuplogin_input sendMessage_message" path="messageText" /><br />
							<div class="reg_errors"><!--  -->
								<form:errors cssClass="alert alert-error error" path="messageText" />
							</div>
						</p>

						<c:if test="${messageBean.messageHoneypotPosition eq 1}">
							<p class="p">
								<strong>Leave this blank:</strong> &#160; <span class="error hidden">
								* value required</span><br />
								<form:textarea cssClass="popuplogin_input sendMessage_subject" path="messageHoneypot" /><br />
							</p>
						</c:if>
					</div>

					<div class="btns">
						<div class="blue-button">
							<a href="javascript:;" onclick="if (sendMessageFormValid()) { lockSendMessageForm(); } else { return false; }">Send message</a>
						</div>

						<div class="gray-button">
							<a href="javascript:;"
							   onclick="clearSendMessageForm(); hideSendMessagForm(); return false;">Cancel</a>
						</div>
					</div>
				</form:form>

			</div>
			<!-- /popup login -->
			<div class="clearfix"></div>

		</div>
	</div>

</jsp:root>