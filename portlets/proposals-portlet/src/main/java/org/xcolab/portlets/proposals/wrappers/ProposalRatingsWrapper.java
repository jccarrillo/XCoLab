package org.xcolab.portlets.proposals.wrappers;

import com.ext.portlet.model.ContestPhase;
import com.ext.portlet.model.ProposalRating;
import com.ext.portlet.service.ContestPhaseLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.apache.commons.lang.StringEscapeUtils;

import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.exceptions.MemberNotFoundException;
import org.xcolab.client.members.pojo.Member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProposalRatingsWrapper {
    private final static Log _log = LogFactoryUtil.getLog(ProposalRatingsWrapper.class);
    private final List<ProposalRatingWrapper> proposalRatings;
    private final Member author;
    private String comment;
    private ContestPhase contestPhase;

    public ProposalRatingsWrapper(long authorId, List<ProposalRating> proposalRatings,
            Long roundFactor) throws MemberNotFoundException {
        this(MembersClient.getMember(authorId), proposalRatings, roundFactor);
    }

    public ProposalRatingsWrapper(long authorId) throws MemberNotFoundException {
        this(MembersClient.getMember(authorId), Collections.<ProposalRating>emptyList());
    }
    public ProposalRatingsWrapper(long authorId, List<ProposalRating> proposalRatings) {
        this(MembersClient.getMemberUnchecked(authorId), proposalRatings);
    }

    public ProposalRatingsWrapper(Member author, List<ProposalRating> proposalRatings) {
        this(author, proposalRatings, 1L);
    }

    public ProposalRatingsWrapper(Member author, List<ProposalRating> proposalRatings, Long roundFactor) {
        List<ProposalRatingWrapper> wrapped = new ArrayList<>();
        for (ProposalRating r : proposalRatings) {
            wrapped.add(new ProposalRatingWrapper(r, roundFactor));
        }

        //sort the list
        Collections.sort(wrapped, new Comparator<ProposalRatingWrapper>() {
            @Override
            public int compare(ProposalRatingWrapper r1, ProposalRatingWrapper r2) {
                return r1.getRatingTypeId().compareTo(r2.getRatingTypeId());
            }
        });

        this.proposalRatings = wrapped;
        this.author = author;
    }


    public List<ProposalRatingWrapper> getRatings() {
        return proposalRatings;
    }

    public String getComment() {
        if(comment != null){
            return comment;
        } else {
            for (ProposalRatingWrapper r : proposalRatings) {
                if (r.unwrap().isCommentEnabled()) {
                    return r.unwrap().getComment();
                }
            }
            return "";
        }
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentEscaped() {
        String comment = this.getComment();
        comment = StringEscapeUtils.escapeHtml(comment);
        comment = comment.replaceAll("\n", "<br>");
        return comment;
    }

    public void setContestPhase(ContestPhase contestPhase){
        this.contestPhase = contestPhase;
    }

    public String getContestPhase(){
        String contestPhaseTitle = "";

        try {
            if(this.contestPhase != null) {
                contestPhaseTitle = ContestPhaseLocalServiceUtil.getName(this.contestPhase);
            } else {
                if (!proposalRatings.isEmpty()) {
                    long contestPhaseId = proposalRatings.get(0).unwrap().getContestPhaseId();
                    ContestPhase contestPhase = ContestPhaseLocalServiceUtil.getContestPhase(contestPhaseId);
                    contestPhaseTitle = ContestPhaseLocalServiceUtil.getName(contestPhase);
                }
            }
        } catch (PortalException | SystemException e){
            _log.warn("Could not get phase title for rating wrapper", e);
        }

        return contestPhaseTitle.replace("selection", "Evaluation");
    }

    public boolean isReviewComplete() {
        if (!this.proposalRatings.isEmpty()) {
            boolean result = true;
            for (ProposalRatingWrapper r : proposalRatings) {
                if (!r.unwrap().isRatingComplete()) {
                    result = false;
                }
            }
            return result;
        } else {
            return false;
        }
    }

    public Member getAuthor() {
        return author;
    }
}
