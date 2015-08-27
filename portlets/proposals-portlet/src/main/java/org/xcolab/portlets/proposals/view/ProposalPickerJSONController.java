package org.xcolab.portlets.proposals.view;

import com.ext.portlet.ProposalAttributeKeys;
import com.ext.portlet.model.*;
import com.ext.portlet.service.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.xcolab.portlets.proposals.utils.ProposalPickerFilterUtil;
import org.xcolab.portlets.proposals.utils.ProposalsContext;
import org.xcolab.portlets.proposals.wrappers.ContestWrapper;
import org.xcolab.portlets.proposals.wrappers.ProposalWrapper;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.*;

/**
 * User: patrickhiesel Date: 03/12/13 Time: 09:46
 */

@Controller
@RequestMapping("view")
public class ProposalPickerJSONController {

	private static int MAXCHARS_FOR_NAMES = 75;
	private static Log _log = LogFactoryUtil.getLog(ProposalPickerJSONController.class);

	@Autowired
	private ProposalsContext proposalsContext;

	@ResourceMapping("proposalPicker")
	public void proposalPicker(
			ResourceRequest request,
			ResourceResponse response,
			@RequestParam(value = "type", required = false) String requestType,
			@RequestParam(value = "filterKey", required = false) String filterType,
			@RequestParam(required = false) String filterText,
			@RequestParam(required = false) int start,
			@RequestParam(required = false) int end,
			@RequestParam(required = false) String sortOrder,
			@RequestParam(required = false) String sortColumn,
			@RequestParam(required = false) Long sectionId,
			@RequestParam(required = false) long contestPK) throws IOException,
			SystemException, PortalException {

		String user = request.getRemoteUser();

		List<Pair<Proposal, Date>> proposals = null;

		if (requestType.equalsIgnoreCase("subscriptionsAndSupporting")) {
			proposals = getFilteredSubscribedSupportingProposalsForUser(
					Long.parseLong(user), filterType, sectionId, request);
		} else if (requestType.equalsIgnoreCase("subscriptions")) {
			proposals = getFilteredSubscribedProposalsForUser(
					Long.parseLong(user), filterType, sectionId, request);
		} else if (requestType.equalsIgnoreCase("supporting")) {
			proposals = getFilteredSupportingProposalsForUser(
					Long.parseLong(user), filterType, sectionId, request);
		} else if (requestType.equalsIgnoreCase("all")
				|| requestType.equalsIgnoreCase("contests")) {
			proposals = getFilteredAllProposalsForUser(Long.parseLong(user),
					filterType, sectionId, contestPK, request);
		}
		int totalCount;
		if (proposals != null) {
			if (filterText != null && filterText.length() > 0)
				ProposalPickerFilterUtil.TEXTBASED.filter(proposals, filterText);
			totalCount = proposals.size();

			sortProposalsList(sortOrder, sortColumn, proposals);
			if (end >= totalCount && totalCount > 0)
				end = totalCount;
			if (totalCount > (end - start))
				proposals = proposals.subList(start, end);

		} else {
			totalCount = 0;
			_log.error("Could not retrieve proposals: proposals variable should not be null for valid filterKeys." +
					"(filterKey was "+filterText+")");
		}
		response.getPortletOutputStream().write(
				getJSONObjectMapping(proposals, totalCount).getBytes());
	}

	@ResourceMapping("proposalPickerContests")
	public void proposalPickerContests(
			ResourceRequest request,
			ResourceResponse response,
			@RequestParam(value = "type", required = false) String requestType,
			@RequestParam(value = "filterKey", required = false) String filterType,
			@RequestParam(required = false) String filterText,
			@RequestParam(required = false) int start,
			@RequestParam(required = false) int end,
			@RequestParam(required = false) String sortOrder,
			@RequestParam(required = false, value = "contestSortColumn") String sortColumn,
			@RequestParam(required = false) Long sectionId) throws IOException,
			SystemException, PortalException {

		List<Pair<ContestWrapper, Date>> contests = getFilteredContests(
				filterType, sectionId, request);

		if (filterText != null && filterText.length() > 0) {
			ProposalPickerFilterUtil.TEXTBASED.filterContests(contests,
					filterText);
		}
		int totalCount = contests.size();

		// sortList(sortOrder,sortColumn,contests);
		if (end >= contests.size() && contests.size() > 0) {
			end = contests.size();
		}
		sortContestsList(sortOrder, sortColumn, contests);
		if (contests.size() > (end - start)) {
			contests = contests.subList(start, end);
		}

		response.getPortletOutputStream().write(
				getJSONObjectMappingContests(contests, totalCount).getBytes());
	}

	/**
	 * This method is used to fill the counting bubbles for each tab
	 */
	@ResourceMapping("proposalPickerCounter")
	public void proposalPickerCounter(ResourceRequest request,
									  ResourceResponse response) throws IOException, SystemException,
			PortalException {
		String filterType = request.getParameter("filterKey");
		long sectionId = Long.parseLong(request.getParameter("sectionId"));
		long userId = Long.parseLong(request.getRemoteUser());

		int numberOfSubscriptions = getFilteredSubscribedProposalsForUser(
				userId, filterType, sectionId, request).size();
		int numberOfSupporting = getFilteredSupportingProposalsForUser(userId,
				filterType, sectionId, request).size();
		int numberOfProposals = getFilteredAllProposalsForUser(userId,
				filterType, sectionId, 0L, request).size();
		int numberOfSubscriptionsSupporting = getFilteredSubscribedSupportingProposalsForUser(
				userId, filterType, sectionId, request).size();
		int numberOfContests = getFilteredContests(filterType, sectionId, request).size();

		JSONObject wrapper = JSONFactoryUtil.createJSONObject();
		wrapper.put("numberOfSubscriptions", numberOfSubscriptions);
		wrapper.put("numberOfSupporting", numberOfSupporting);
		wrapper.put("numberOfProposals", numberOfProposals);
		wrapper.put("numberOfSubscriptionsSupporting",
				numberOfSubscriptionsSupporting);
		wrapper.put("numberOfContests", numberOfContests);
		response.getPortletOutputStream().write(wrapper.toString().getBytes());
	}

	private String getJSONObjectMapping(List<Pair<Proposal, Date>> proposals,
										int totalNumberOfProposals) throws SystemException, PortalException {
		JSONObject wrapper = JSONFactoryUtil.createJSONObject();
		JSONArray proposalsJSON = JSONFactoryUtil.createJSONArray();

		for (Pair<Proposal, Date> p : proposals) {
			ProposalWrapper wrappedProposal = new ProposalWrapper(p.getLeft());
			JSONObject o = JSONFactoryUtil.createJSONObject();
			o.put("id", p.getLeft().getProposalId());
			o.put("proposalName", StringUtils.abbreviate(
					StringEscapeUtils.unescapeXml(wrappedProposal.getName()), MAXCHARS_FOR_NAMES));
			o.put("contestName", StringUtils.abbreviate(wrappedProposal
					.getContest().getContestShortName(), MAXCHARS_FOR_NAMES));
			o.put("contestId", wrappedProposal.getContest().getContestPK());
			if (StringUtils.isNotBlank(wrappedProposal.getTeam())) {
				o.put("team", wrappedProposal.getTeam());
			}
			o.put("authorName", wrappedProposal.getAuthorName());
			o.put("authorId", wrappedProposal.getAuthorId());
			o.put("dateSubscribed", p.getRight().getTime());
			o.put("commentsCount", wrappedProposal.getCommentsCount());
			o.put("supportersCount", wrappedProposal.getSupportersCount());
			o.put("pitch", wrappedProposal.getPitch());
			o.put("ribbon", wrappedProposal.getRibbon());
			o.put("ribbonText", wrappedProposal.getRibbonText());
			o.put("featured", wrappedProposal.isFeatured());

			JSONArray proposalContests = JSONFactoryUtil.createJSONArray();
			// for now there can be only one contest
			JSONObject contest = JSONFactoryUtil.createJSONObject();
			contest.put("name", wrappedProposal.getContest()
					.getContestShortName());
			contest.put("id", wrappedProposal.getContest().getContestPK());
			contest.put("contestLogoId", wrappedProposal.getContest()
					.getContestLogoId());
			proposalContests.put(contest);

			o.put("contests", proposalContests);
			proposalsJSON.put(o);
		}

		wrapper.put("proposals", proposalsJSON);
		wrapper.put("totalCount", totalNumberOfProposals);
		return wrapper.toString();
	}

	private String getJSONObjectMappingContests(
			List<Pair<ContestWrapper, Date>> contests, int totalNumberOfContests)
			throws SystemException, PortalException {
		JSONObject wrapper = JSONFactoryUtil.createJSONObject();
		JSONArray proposalsJSON = JSONFactoryUtil.createJSONArray();

		for (Pair<ContestWrapper, Date> p : contests) {
			ContestWrapper wrapped = p.getLeft();
			JSONObject o = JSONFactoryUtil.createJSONObject();

			o.put("id", p.getLeft().getContestPK());
			o.put("contestShortName", StringUtils.abbreviate(
					wrapped.getContestShortName(), MAXCHARS_FOR_NAMES));
			o.put("contestName", StringUtils.abbreviate(
					wrapped.getContestName(), MAXCHARS_FOR_NAMES));
			o.put("contestPK", wrapped.getContestPK());
			o.put("flagText", wrapped.getFlagText());
			o.put("flag", wrapped.getFlag());
			o.put("flagTooltip", wrapped.getFlagTooltip());
			o.put("proposalsCount", wrapped.getProposalsCount());
			o.put("totalCommentsCount", wrapped.getTotalCommentsCount());
			o.put("what", wrapped.getWhatName());
			o.put("who", wrapped.getWhoName());
			o.put("where", wrapped.getWhereName());
			o.put("date", p.getRight().getTime());
			proposalsJSON.put(o);
		}

		wrapper.put("contests", proposalsJSON);
		wrapper.put("totalCount", totalNumberOfContests);
		return wrapper.toString();
	}

	private void sortProposalsList(String sortOrder, String sortColumn,
								   List<Pair<Proposal, Date>> proposals) {
		switch (sortColumn.toLowerCase()) {
			case "contest":
				Collections.sort(proposals, new Comparator<Pair<Proposal, Date>>() {
					@Override
					public int compare(Pair<Proposal, Date> o1,
									   Pair<Proposal, Date> o2) {
						try {
							return Proposal2PhaseLocalServiceUtil
									.getCurrentContestForProposal(
											o1.getLeft().getProposalId())
									.getContestName()
									.compareTo(
											Proposal2PhaseLocalServiceUtil
													.getCurrentContestForProposal(
															o2.getLeft()
																	.getProposalId())
													.getContestName());
						} catch (Exception e) {
							return 0;
						}
					}
				});
				break;
			case "proposal":
				Collections.sort(proposals, new Comparator<Pair<Proposal, Date>>() {
					@Override
					public int compare(Pair<Proposal, Date> o1,
									   Pair<Proposal, Date> o2) {
						try {
							return ProposalLocalServiceUtil
									.getAttribute(o1.getLeft().getProposalId(),
											ProposalAttributeKeys.NAME, 0l)
									.getStringValue()
									.compareTo(
											ProposalLocalServiceUtil.getAttribute(
													o2.getLeft().getProposalId(),
													ProposalAttributeKeys.NAME, 0l)
													.getStringValue());
						} catch (Exception e) {
							return 0;
						}
					}
				});
				break;
			case "author":
				Collections.sort(proposals, new Comparator<Pair<Proposal, Date>>() {
					@Override
					public int compare(Pair<Proposal, Date> o1,
									   Pair<Proposal, Date> o2) {
						try {
							ProposalAttribute t1 = ProposalLocalServiceUtil
									.getAttribute(o1.getLeft().getProposalId(),
											ProposalAttributeKeys.TEAM, 0);
							ProposalAttribute t2 = ProposalLocalServiceUtil
									.getAttribute(o2.getLeft().getProposalId(),
											ProposalAttributeKeys.TEAM, 0);

							String author1 = t1 == null
									|| t1.getStringValue().trim().length() == 0 ? UserLocalServiceUtil
									.getUser(o1.getLeft().getAuthorId())
									.getScreenName() : t1.getStringValue();
							String author2 = t2 == null
									|| t2.getStringValue().trim().length() == 0 ? UserLocalServiceUtil
									.getUser(o2.getLeft().getAuthorId())
									.getScreenName() : t2.getStringValue();

							return author1.compareTo(author2);
						} catch (Exception e) {
							return 0;
						}
					}
				});
				break;
			case "date":
				Collections.sort(proposals, new Comparator<Pair<Proposal, Date>>() {
					@Override
					public int compare(Pair<Proposal, Date> o1,
									   Pair<Proposal, Date> o2) {
						return o1.getRight().compareTo(o2.getRight());
					}
				});
				break;
			case "supporters":
				Collections.sort(proposals, new Comparator<Pair<Proposal, Date>>() {
					@Override
					public int compare(Pair<Proposal, Date> o1,
									   Pair<Proposal, Date> o2) {
						try {
							return ProposalLocalServiceUtil.getSupportersCount(o1
									.getLeft().getProposalId()) - ProposalLocalServiceUtil
									.getSupportersCount(o2.getLeft()
											.getProposalId());
						} catch (PortalException | SystemException e) {
							return 0;
						}
					}
				});
				break;
			case "comments":
				Collections.sort(proposals, new Comparator<Pair<Proposal, Date>>() {
					@Override
					public int compare(Pair<Proposal, Date> o1,
									   Pair<Proposal, Date> o2) {
						try {
							return (int) (ProposalLocalServiceUtil
									.getCommentsCount(o1.getLeft().getProposalId()) - ProposalLocalServiceUtil
									.getCommentsCount(o2.getLeft().getProposalId()));
						} catch (PortalException | SystemException e) {
							return 0;
						}
					}
				});
				break;
		}

		if (sortOrder != null && sortOrder.toLowerCase().equals("desc")) {
			Collections.reverse(proposals);
		}
	}

	private void sortContestsList(String sortOrder, String sortColumn,
								  List<Pair<ContestWrapper, Date>> contests) {
		if (sortColumn != null) {
			switch (sortColumn.toLowerCase()) {
				case "name":
					Collections.sort(contests, new Comparator<Pair<ContestWrapper, Date>>() {
						@Override
						public int compare(Pair<ContestWrapper, Date> o1,
										   Pair<ContestWrapper, Date> o2) {
							return o1.getLeft().getContestShortName()
									.compareTo(o2.getLeft().getContestShortName());
						}
					});
					break;
				case "comments":
					Collections.sort(contests, new Comparator<Pair<ContestWrapper, Date>>() {
						@Override
						public int compare(Pair<ContestWrapper, Date> o1,
										   Pair<ContestWrapper, Date> o2) {
							try {
								return (int) (o1.getLeft().getTotalCommentsCount() - o2
										.getLeft().getTotalCommentsCount());
							} catch (PortalException | SystemException e) {
								return 0;
							}
						}
					});
					break;
				case "what":
					Collections.sort(contests, new Comparator<Pair<ContestWrapper, Date>>() {
						@Override
						public int compare(Pair<ContestWrapper, Date> o1,
										   Pair<ContestWrapper, Date> o2) {
							try {
								return o1.getLeft().getWhatName()
										.compareTo(o2.getLeft().getWhatName());
							} catch (PortalException | SystemException e) {
								return 0;
							}
						}
					});
					break;
				case "where":
					Collections.sort(contests, new Comparator<Pair<ContestWrapper, Date>>() {
						@Override
						public int compare(Pair<ContestWrapper, Date> o1,
										   Pair<ContestWrapper, Date> o2) {
							try {
								return o1.getLeft().getWhereName()
										.compareTo(o2.getLeft().getWhereName());
							} catch (PortalException | SystemException e) {
								return 0;
							}
						}
					});
					break;
				case "who":
					Collections.sort(contests, new Comparator<Pair<ContestWrapper, Date>>() {
						@Override
						public int compare(Pair<ContestWrapper, Date> o1,
										   Pair<ContestWrapper, Date> o2) {
							try {
								return o1.getLeft().getWhoName()
										.compareTo(o2.getLeft().getWhoName());
							} catch (PortalException | SystemException e) {
								return 0;
							}
						}
					});
					break;
				case "how":
					Collections.sort(contests, new Comparator<Pair<ContestWrapper, Date>>() {
						@Override
						public int compare(Pair<ContestWrapper, Date> o1,
										   Pair<ContestWrapper, Date> o2) {
							try {
								return o1.getLeft().getHowName()
										.compareTo(o2.getLeft().getHowName());
							} catch (PortalException | SystemException e) {
								return 0;
							}
						}
					});
					break;
				default:
					Collections.sort(contests, new Comparator<Pair<ContestWrapper, Date>>() {
						@Override
						public int compare(Pair<ContestWrapper, Date> o1,
										   Pair<ContestWrapper, Date> o2) {
							try {
								return (int) (o1.getLeft().getProposalsCount() - o2
										.getLeft().getProposalsCount());
							} catch (PortalException | SystemException e) {
								return 0;
							}
						}
					});
			}
		}

		if (sortOrder != null && sortOrder.toLowerCase().equals("desc")) {
			Collections.reverse(contests);
		}
	}

	private List<Pair<ContestWrapper, Date>> getFilteredContests(
			String filterKey, long sectionId, ResourceRequest request) throws SystemException,
			PortalException {

		List<Pair<ContestWrapper, Date>> contests = new ArrayList<>();
		
		for (Contest c: ContestLocalServiceUtil.getContests(0, Integer.MAX_VALUE)) {
			contests.add(Pair.of(new ContestWrapper(c),
					c.getCreated() == null ? new Date(0) : c.getCreated()));
		}

//		for (Contest c : ContestLocalServiceUtil.getContestsMatchingTier(contestTier.getTierType())) {
//			contests.add(Pair.of(new ContestWrapper(c),
//					c.getCreated() == null ? new Date(0) : c.getCreated()));
//		}

		return contests;
	}

	private List<Pair<Proposal, Date>> getFilteredSubscribedSupportingProposalsForUser(
			long userId, String filterKey, long sectionId, PortletRequest request)
			throws SystemException, PortalException {
		List<Pair<Proposal, Date>> proposals = getFilteredSubscribedProposalsForUser(
				userId, filterKey, sectionId, request);

		Set<Long> includedProposals = new HashSet<>();
		for (Pair<Proposal, Date> entry : proposals) {
			includedProposals.add(entry.getLeft().getProposalId());
		}
		for (Pair<Proposal, Date> entry : getFilteredSupportingProposalsForUser(
				userId, filterKey, sectionId, request)) {
			if (includedProposals.contains(entry.getLeft().getProposalId()))
				continue;
			proposals.add(entry);
		}

		return proposals;
	}

	private List<Pair<Proposal, Date>> getFilteredSubscribedProposalsForUser(
			long userId, String filterKey, long sectionId, PortletRequest request)
			throws SystemException, PortalException {
		List<Pair<Proposal, Date>> proposals = new ArrayList<>();
		List<ActivitySubscription> activitySubscriptions = ActivitySubscriptionLocalServiceUtil
				.findByUser(userId);
		for (ActivitySubscription as : activitySubscriptions) {
			if (as.getClassNameId() == ClassNameLocalServiceUtil
					.getClassNameId(Proposal.class)) {
				proposals.add(Pair.of(
						ProposalLocalServiceUtil.getProposal(as.getClassPK()),
						as.getCreateDate()));
			}
		}

		filterProposals(proposals, filterKey, sectionId, request);

		return proposals;
	}

	private List<Pair<Proposal, Date>> getFilteredSupportingProposalsForUser(
			long userId, String filterKey, long sectionId, PortletRequest request)
			throws SystemException, PortalException {
		List<Pair<Proposal, Date>> proposals = new ArrayList<>();
		for (ProposalSupporter ps : ProposalSupporterLocalServiceUtil
				.getProposals(userId)) {
			proposals.add(Pair.of(
					ProposalLocalServiceUtil.getProposal(ps.getProposalId()),
					ps.getCreateDate()));
		}

		filterProposals(proposals, filterKey, sectionId, request);

		return proposals;
	}

	private List<Pair<Proposal, Date>> getFilteredAllProposalsForUser(
			long userId, String filterKey, long sectionId, Long contestPK, PortletRequest request)
			throws SystemException, PortalException {
		List<Pair<Proposal, Date>> proposals = new ArrayList<>();
		List<Proposal> proposalsRaw = null;
		if (contestPK > 0) {
			proposalsRaw = ProposalLocalServiceUtil
					.getProposalsInContest(contestPK);
		} else {
			proposalsRaw = ProposalLocalServiceUtil.getProposals(0,
					Integer.MAX_VALUE);
		}
		for (Proposal p : proposalsRaw) {
			proposals.add(Pair.of(p, new Date(0)));
		}

		filterProposals(proposals, filterKey, sectionId, request);

		return proposals;
	}

	private void filterProposals(List<Pair<Proposal, Date>> proposals,
				String filterKey, long sectionId, PortletRequest request)
			throws SystemException, PortalException {
		ProposalPickerFilterUtil.getFilterByParameter(filterKey).filter(
				proposals);

		PlanSectionDefinition planSectionDefinition = PlanSectionDefinitionLocalServiceUtil.getPlanSectionDefinition(sectionId);
		if (planSectionDefinition.getFocusAreaId() < 0) {
			ProposalPickerFilterUtil.SECTION_DEF_FOCUS_AREA_FILTER.filter(proposals, -1 * planSectionDefinition.getFocusAreaId());
			if (request != null) {
				Contest contest = proposalsContext.getContest(request);
				ProposalPickerFilterUtil.SECTION_DEF_FOCUS_AREA_FILTER.filter(proposals, contest.getFocusAreaId());
			}
		} else {
			ProposalPickerFilterUtil.SECTION_DEF_FOCUS_AREA_FILTER.filter(proposals, planSectionDefinition);
		}

		ProposalPickerFilterUtil.CONTEST_TIER.filter(proposals, planSectionDefinition.getTier());
	}
}
