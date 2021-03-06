package org.xcolab.wrappers;

import com.ext.portlet.model.Contest;
import com.ext.portlet.model.ContestPhase;
import com.ext.portlet.model.ContestTeamMember;
import com.ext.portlet.model.ContestTeamMemberRole;
import com.ext.portlet.model.ContestType;
import com.ext.portlet.model.FocusArea;
import com.ext.portlet.model.OntologyTerm;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.ContestPhaseLocalServiceUtil;
import com.ext.portlet.service.ContestTypeLocalServiceUtil;
import com.ext.portlet.service.FocusAreaLocalServiceUtil;
import com.ext.portlet.service.OntologyTermLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;

import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.exceptions.MemberNotFoundException;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.helpers.Tuple;
import org.xcolab.util.exceptions.DatabaseAccessException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseContestWrapper {

    private final static Log _log = LogFactoryUtil.getLog(BaseContestWrapper.class);
    private final static Map<Long, FocusArea> faCache = new HashMap<>();
    private final Map<String, List<OntologyTerm>> ontologySpaceCache = new HashMap<>();

    protected static final String WHERE = "where";
    protected static final String WHAT = "what";
    protected static final String WHO = "who";
    protected static final String HOW = "how";

    protected List<BaseContestPhaseWrapper> phases;
    protected ContestType contestType;
    protected List<BaseContestTeamRoleWrapper> contestTeamMembersByRole;
    protected final Contest contest;
    protected BaseContestPhaseWrapper activePhase;

    public BaseContestWrapper(long contestId) throws SystemException, PortalException {
        this(ContestLocalServiceUtil.getContest(contestId));
    }

    public BaseContestWrapper(Contest contest) {
        this.contest = contest;
    }

    public void persist() throws SystemException {
        contest.persist();
    }

    public long getContestPK() {
        return contest.getContestPK();
    }

    public void setContestPK(long ContestPK) {
        contest.setContestPK(ContestPK);
    }

    public String getContestName() {
        return contest.getContestName();
    }

    public void setContestName(String ContestName) {
        contest.setContestName(ContestName);
    }

    public String getContestShortName() {
        return contest.getContestShortName();
    }

    public void setContestShortName(String ContestShortName) {
        contest.setContestShortName(ContestShortName);
    }

    public Date getCreated() {
        return contest.getCreated();
    }

    public void setCreated(Date created) {
        contest.setCreated(created);
    }

    public Date getUpdated() {
        return contest.getUpdated();
    }

    public void setUpdated(Date updated) {
        contest.setUpdated(updated);
    }

    public long getAuthorId() {
        return contest.getAuthorId();
    }

    public void setAuthorId(long authorId) {
        contest.setAuthorId(authorId);
    }

    public boolean getContestActive() {
        return contest.getContestActive();
    }

    public boolean isContestActive() {
        return contest.isContestActive();
    }

    public void setContestActive(boolean contestActive) {
        contest.setContestActive(contestActive);
    }

    public long getPlanTemplateId() {
        return contest.getPlanTemplateId();
    }

    public void setPlanTemplateId(long planTemplateId) {
        contest.setPlanTemplateId(planTemplateId);
    }

    public long getFocusAreaId() {
        return contest.getFocusAreaId();
    }

    public void setFocusAreaId(long focusAreaId) {
        contest.setFocusAreaId(focusAreaId);
    }

    public long getContestLogoId() {
        return contest.getContestLogoId();
    }

    public void setContestLogoId(long contestLogoId) {
        contest.setContestLogoId(contestLogoId);
    }

    public boolean getFeatured() {
        return contest.getFeatured();
    }

    public boolean isFeatured() {
        return contest.isFeatured();
    }

    public void setFeatured(boolean featured) {
        contest.setFeatured(featured);
    }

    public boolean getPlansOpenByDefault() {
        return contest.getPlansOpenByDefault();
    }

    public boolean isPlansOpenByDefault() {
        return contest.isPlansOpenByDefault();
    }

    public void setPlansOpenByDefault(boolean plansOpenByDefault) {
        contest.setPlansOpenByDefault(plansOpenByDefault);
    }

    public long getSponsorLogoId() {
        return contest.getSponsorLogoId();
    }

    public void setSponsorLogoId(long sponsorLogoId) {
        contest.setSponsorLogoId(sponsorLogoId);
    }

    public String getSponsorText() {
        return contest.getSponsorText();
    }

    public void setSponsorText(String sponsorText) {
        contest.setSponsorText(sponsorText);
    }

    public String getSponsorLink() {
        return contest.getSponsorLink();
    }

    public void setSponsorLink(String sponsorLink) {
        contest.setSponsorLink(sponsorLink);
    }

    public boolean getSponsorLinkAvailable() {
        return !contest.getSponsorLink().equals("");
    }

    public int getFlag() {
        return contest.getFlag();
    }

    public void setFlag(int flag) {
        contest.setFlag(flag);
    }

    public String getFlagText() {
        return contest.getFlagText();
    }

    public void setFlagText(String flagText) {
        contest.setFlagText(flagText);
    }

    public String getFlagTooltip() {
        return contest.getFlagTooltip();
    }

    public void setFlagTooltip(String flagTooltip) {
        contest.setFlagTooltip(flagTooltip);
    }

    public long getGroupId() {
        return contest.getGroupId();
    }

    public void setGroupId(long groupId) {
        contest.setGroupId(groupId);
    }

    public long getDiscussionGroupId() {
        return contest.getDiscussionGroupId();
    }

    public void setDiscussionGroupId(long discussionGroupId) {
        contest.setDiscussionGroupId(discussionGroupId);
    }

    public int getWeight() {
        return contest.getWeight();
    }

    public void setWeight(int weight) {
        contest.setWeight(weight);
    }

    public long getContestTier() {
        return contest.getContestTier();
    }

    public void setContestTier(long contestTier) {
        contest.setContestTier(contestTier);
    }

    public boolean getContestPrivate() {
        return contest.getContestPrivate();
    }

    public void setContestPrivate(boolean contestPrivate) {
        contest.setContestPrivate(contestPrivate);
    }

    public String getResourcesUrl() {
        return contest.getResourcesUrl();
    }

    public void setResourcesUrl(String resourcesUrl) {
        contest.setResourcesUrl(resourcesUrl);
    }

    public boolean getShow_in_list_view(){ return contest.getShow_in_list_view();}

    public void setShow_in_list_view(boolean show_in_list_view){ contest.setShow_in_list_view(show_in_list_view);}

    public boolean getShow_in_tile_view(){ return contest.getShow_in_tile_view();}

    public void setShow_in_tile_view(boolean show_in_tile_view){ contest.setShow_in_tile_view(show_in_tile_view);}

    public boolean getShow_in_outline_view(){ return contest.getShow_in_outline_view();}

    public void setShow_in_outline_view(boolean show_in_tile_view){ contest.setShow_in_outline_view(show_in_tile_view);}

    public boolean getHideRibbons() {
        return contest.getHideRibbons();
    }

    public long getContestTypeId() {
        return contest.getContestTypeId();
    }

    public long getContestYear() {
        return contest.getContestYear();
    }

    public void setContestYear(long contestYear) {
        contest.setContestYear(contestYear);
    }

    public String getContestUrlName() {
        return contest.getContestUrlName();
    }

    public void setContestUrlName(String contestUrlName) {
        contest.setContestUrlName(contestUrlName);
    }

    public void setHideRibbons(boolean hideRibbons) {
        contest.setHideRibbons(hideRibbons);
    }

    public long getProposalsCount() {
        try {
            return ContestLocalServiceUtil.getProposalsCount(contest);
        } catch (SystemException e) {
            throw new DatabaseAccessException(e);
        } catch (PortalException e) {
            _log.error("Could not count proposals in contest " + contest.getContestPK());
            return 0L;
        }
    }

    public long getTotalProposalsCount() {
        Set<Proposal> proposalList = new HashSet<>();
        try {
            List<ContestPhase> contestPhases = ContestPhaseLocalServiceUtil
                    .getPhasesForContest(contest);
            for (ContestPhase contestPhase : contestPhases) {
                try {
                List<Proposal> proposals = ProposalLocalServiceUtil
                        .getActiveProposalsInContestPhase(contestPhase.getContestPhasePK());
                proposalList.addAll(proposals);
                } catch (PortalException e) {
                    _log.error("Proposal count: failed to retrieve active proposals in contest phase " + contestPhase
                            .getContestPhasePK());
                }
            }
        } catch (SystemException e) {
            throw new DatabaseAccessException(e);
        }
        return proposalList.size();
    }

    public long getCommentsCount() {
        return ContestLocalServiceUtil.getCommentsCount(contest);
    }

    public List<OntologyTerm> getWho() {
        return getTermFromSpace(WHO);
    }

    public List<OntologyTerm> getWhat() {
        return getTermFromSpace(WHAT);
    }

    public List<OntologyTerm> getWhere() {
        return getTermFromSpace(WHERE);
    }

    public List<OntologyTerm> getHow() {
        return getTermFromSpace(HOW);
    }

    protected List<OntologyTerm> getTermFromSpace(String space) {
        try {
            if (!ontologySpaceCache.containsKey(space) && (getFocusAreaId() > 0)) {
                if (!faCache.containsKey(contest.getFocusAreaId())) {
                    FocusArea fa = FocusAreaLocalServiceUtil.getFocusArea(contest
                            .getFocusAreaId());
                    if (fa == null) {
                        ontologySpaceCache.put(space, null);
                        return null;
                    }
                    faCache.put(fa.getId(), fa);
                }
                List<OntologyTerm> terms = new ArrayList<>();
                for (OntologyTerm t : FocusAreaLocalServiceUtil
                        .getTerms(faCache.get(contest.getFocusAreaId()))) {
                    if (OntologyTermLocalServiceUtil.getSpace(t).getName()
                            .equalsIgnoreCase(space)) {
                        terms.add(t);
                    }
                }
                ontologySpaceCache.put(space, terms.isEmpty() ? null : terms);
            }
            return ontologySpaceCache.get(space);
        } catch (SystemException e) {
            throw new DatabaseAccessException(e);
        } catch (PortalException e) {
            throw new IllegalStateException("Dead id reference for contest "
                    + contest.getContestPK() + " retrieving ontology term for space " + space);
        }
    }

    public List<BaseContestPhaseWrapper> getPhases() {
        if (phases == null) {
            phases = new ArrayList<>();
            for (ContestPhase phase : ContestLocalServiceUtil.getAllPhases(contest)) {
                phases.add(new BaseContestPhaseWrapper(phase));
            }
        }
        return phases;
    }

    public List<BaseContestTeamRoleWrapper> getContestTeamMembersByRole() {
        if (contestTeamMembersByRole == null) {
            try {
                Map<Tuple<String, Integer>, List<Member>> teamRoleUsersMap = new HashMap<>();
                for (ContestTeamMember teamMember : ContestLocalServiceUtil
                        .getTeamMembers(contest)) {
                    try {
                        ContestTeamMemberRole role = ContestLocalServiceUtil
                                .getRoleForMember(teamMember);
                        List<Member> roleUsers = teamRoleUsersMap
                                .get(new Tuple<>(role.getRole(), role.getSort()));
                        if (roleUsers == null) {
                            roleUsers = new ArrayList<>();
                            teamRoleUsersMap
                                    .put(new Tuple<>(role.getRole(), role.getSort()), roleUsers);
                        }
                        roleUsers.add(MembersClient.getMember(teamMember.getUserId()));
                    } catch (MemberNotFoundException e) {
                        _log.warn("Contest team member " + teamMember.getUserId() + " does not have an account");
                    } catch (NoSuchModelException e) {
                        throw new IllegalStateException("ContestTeamMemberRole "
                                + teamMember.getRoleId() + " does not exist");
                    }
                }
                contestTeamMembersByRole = new ArrayList<>(teamRoleUsersMap.size());
                for (Map.Entry<Tuple<String, Integer>, List<Member>> entry : teamRoleUsersMap.entrySet()) {
                    final Tuple<String, Integer> role = entry.getKey();
                    contestTeamMembersByRole.add(new BaseContestTeamRoleWrapper(role.getLeft(), entry.getValue(), role.getRight()));
                }
                Collections.sort(contestTeamMembersByRole);
            } catch (SystemException e) {
                throw new DatabaseAccessException(e);
            }
        }
        return contestTeamMembersByRole;
    }

    public boolean getHasUserRoleInContest(User userInQuestion, String role) {

        for (BaseContestTeamRoleWrapper c : getContestTeamMembersByRole()) {
            if (c.getRoleName().equalsIgnoreCase(role)) {
                for (Member user : c.getUsers()) {
                    if (user.equals(userInQuestion)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public BaseContestPhaseWrapper getActivePhase() throws PortalException, SystemException {
        if (activePhase == null) {
            ContestPhase phase = ContestLocalServiceUtil.getActivePhase(contest);
            if (phase == null) {
                return null;
            }
            activePhase = new BaseContestPhaseWrapper(phase);
        }
        return activePhase;
    }

    public List<Member> getContestJudges() {
        List<Member> judges = null;
        for (BaseContestTeamRoleWrapper c : getContestTeamMembersByRole()) {
            if (c.getRoleName().equalsIgnoreCase("Judge")) {
                judges = c.getUsers();
            }
        }
        if(judges == null) {
            return Collections.emptyList();
        }
        return judges;
    }

    public List<Member> getContestFellows() {
        List<Member> fellows = null;
        for (BaseContestTeamRoleWrapper c : getContestTeamMembersByRole()) {
            if (c.getRoleName().equalsIgnoreCase("Fellow")) {
                fellows = c.getUsers();
            }
        }
        return fellows;
    }

    public List<Member> getContestAdvisors() {
        List<Member> advisors = null;
        for (BaseContestTeamRoleWrapper c : getContestTeamMembersByRole()) {
            if (c.getRoleName().equalsIgnoreCase("Advisor")) {
                advisors = c.getUsers();
            }
        }
        if (advisors == null) {
            return Collections.emptyList();
        }
        return advisors;
    }

    public ContestType getContestType() {
        try {
            if (contestType == null) {
                contestType = ContestTypeLocalServiceUtil
                        .fetchContestType(contest.getContestTypeId());
            }
            return contestType;
        } catch (SystemException e) {
            throw new DatabaseAccessException(e);
        }
    }

    public Contest getWrapped() {
        return contest;
    }

    public String getContestUrl() {
        return ContestLocalServiceUtil.getContestLinkUrl(contest);
    }

    public Long getResourceArticleId() {
        return contest.getResourceArticleId();
    }

    public String getResourceArticleUrl() {
        return "/web/guest/wiki/-/wiki/resources/" + contest.getContestYear()
                + "/" + contest.getContestUrlName();
    }
}
