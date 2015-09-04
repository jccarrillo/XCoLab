package org.xcolab.portlets.proposals.utils;

import com.ext.portlet.ProposalAttributeKeys;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.ProposalAttribute;
import com.ext.portlet.service.Proposal2PhaseLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.UserLocalServiceUtil;
import org.apache.commons.lang3.tuple.Pair;
import org.xcolab.portlets.proposals.wrappers.ContestWrapper;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Utility class to sort lists of contests or proposals by a string parameter
 * Created by johannes on 9/3/15.
 */
public class ProposalPickerSortingUtil {

    public static void sortContestsList(String sortOrder, String sortColumn,
                                        List<Pair<ContestWrapper, Date>> contests, final Map<Long, String> removedContests) {
        if (sortColumn != null) {

            boolean descendingSortOrder = (sortOrder != null) && sortOrder.toLowerCase().equals("desc");
            final int sortOrderModifier = descendingSortOrder? -1 : 1;

            switch (sortColumn.toLowerCase()) {
                case "name":
                    Collections.sort(contests, new Comparator<Pair<ContestWrapper, Date>>() {
                        @Override
                        public int compare(Pair<ContestWrapper, Date> o1,
                                           Pair<ContestWrapper, Date> o2) {
                            final boolean contest1wasRemoved = removedContests.containsKey(o1.getLeft().getContestPK());
                            final boolean contest2wasRemoved = removedContests.containsKey(o2.getLeft().getContestPK());
                            if (contest1wasRemoved != contest2wasRemoved) {
                                return contest2wasRemoved ? 1 : -1;
                            }
                            return sortOrderModifier * o1.getLeft().getContestShortName()
                                    .compareTo(o2.getLeft().getContestShortName());
                        }
                    });
                    break;
                case "comments":
                    Collections.sort(contests, new Comparator<Pair<ContestWrapper, Date>>() {
                        @Override
                        public int compare(Pair<ContestWrapper, Date> o1,
                                           Pair<ContestWrapper, Date> o2) {
                            final boolean contest1wasRemoved = removedContests.containsKey(o1.getLeft().getContestPK());
                            final boolean contest2wasRemoved = removedContests.containsKey(o2.getLeft().getContestPK());
                            if (contest1wasRemoved != contest2wasRemoved) {
                                return contest2wasRemoved ? 1 : -1;
                            }
                            try {
                                return sortOrderModifier * (int) (o1.getLeft().getTotalCommentsCount() - o2
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
                            final boolean contest1wasRemoved = removedContests.containsKey(o1.getLeft().getContestPK());
                            final boolean contest2wasRemoved = removedContests.containsKey(o2.getLeft().getContestPK());
                            if (contest1wasRemoved != contest2wasRemoved) {
                                return contest2wasRemoved ? 1 : -1;
                            }
                            try {
                                return sortOrderModifier * o1.getLeft().getWhatName()
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
                            final boolean contest1wasRemoved = removedContests.containsKey(o1.getLeft().getContestPK());
                            final boolean contest2wasRemoved = removedContests.containsKey(o2.getLeft().getContestPK());
                            if (contest1wasRemoved != contest2wasRemoved) {
                                return contest2wasRemoved ? 1 : -1;
                            }
                            try {
                                return sortOrderModifier * o1.getLeft().getWhereName()
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
                            final boolean contest1wasRemoved = removedContests.containsKey(o1.getLeft().getContestPK());
                            final boolean contest2wasRemoved = removedContests.containsKey(o2.getLeft().getContestPK());
                            if (contest1wasRemoved != contest2wasRemoved) {
                                return contest2wasRemoved ? 1 : -1;
                            }
                            try {
                                return sortOrderModifier * o1.getLeft().getWhoName()
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
                            final boolean contest1wasRemoved = removedContests.containsKey(o1.getLeft().getContestPK());
                            final boolean contest2wasRemoved = removedContests.containsKey(o2.getLeft().getContestPK());
                            if (contest1wasRemoved != contest2wasRemoved) {
                                return contest2wasRemoved ? 1 : -1;
                            }
                            try {
                                return sortOrderModifier * o1.getLeft().getHowName()
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
                            final boolean contest1wasRemoved = removedContests.containsKey(o1.getLeft().getContestPK());
                            final boolean contest2wasRemoved = removedContests.containsKey(o2.getLeft().getContestPK());
                            if (contest1wasRemoved != contest2wasRemoved) {
                                return contest2wasRemoved ? 1 : -1;
                            }
                            try {
                                return sortOrderModifier * (int) (o1.getLeft().getProposalsCount() - o2
                                        .getLeft().getProposalsCount());
                            } catch (PortalException | SystemException e) {
                                return 0;
                            }
                        }
                    });
            }
        }
    }

    public static void sortProposalsList(String sortOrder, String sortColumn,
                                   List<Pair<Proposal, Date>> proposals) {

        if (sortColumn != null) {

            boolean descendingSortOrder = (sortOrder != null) && sortOrder.toLowerCase().equals("desc");
            final int sortOrderModifier = descendingSortOrder ? -1 : 1;

            switch (sortColumn.toLowerCase()) {
                case "contest":
                    Collections.sort(proposals, new Comparator<Pair<Proposal, Date>>() {
                        @Override
                        public int compare(Pair<Proposal, Date> o1,
                                           Pair<Proposal, Date> o2) {
                            try {
                                return sortOrderModifier * Proposal2PhaseLocalServiceUtil
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
                                return sortOrderModifier * ProposalLocalServiceUtil
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

                                return sortOrderModifier * author1.compareTo(author2);
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
                                return sortOrderModifier * ProposalLocalServiceUtil.getSupportersCount(o1
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
                                return sortOrderModifier * (int) (ProposalLocalServiceUtil
                                        .getCommentsCount(o1.getLeft().getProposalId()) - ProposalLocalServiceUtil
                                        .getCommentsCount(o2.getLeft().getProposalId()));
                            } catch (PortalException | SystemException e) {
                                return 0;
                            }
                        }
                    });
                    break;
            }
        }
    }
}