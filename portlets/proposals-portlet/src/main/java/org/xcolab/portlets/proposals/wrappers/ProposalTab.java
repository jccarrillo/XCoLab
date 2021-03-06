package org.xcolab.portlets.proposals.wrappers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.xcolab.portlets.proposals.permissions.ProposalsPermissions;
import org.xcolab.portlets.proposals.utils.ProposalsContext;

import javax.portlet.PortletRequest;

public enum ProposalTab {
    DESCRIPTION("Description", Type.NORMAL, ProposalTabCanAccessAlgorithm.alwaysTrue, ProposalTabCanAccessAlgorithm.canEditAccess, ProposalTabActivityCountAlgorithm.alwaysZero),
    ACTIONSIMPACTS("Model results", Type.NORMAL,
            new ProposalTabCanAccessAlgorithm() {

                @Override
                public boolean canAccess(ProposalsPermissions permissions, ProposalsContext context,
                        PortletRequest request) {

                    // user is allowed to access actions and impacts only when there is a model defined 
                    // for current contest (model id in proposalwrapper will be > 0)
                    try {
                        Long contestPK = context.getContest(request).getContestPK();
                        Long contestPKofFirst2015Contest = 1301101L;
                        return contestPK <= contestPKofFirst2015Contest
                                && context.getProposalWrapped(request).getModelId() > 0;
                    } catch (PortalException | SystemException e) {
                        _log.error("Can't access proposals model id", e);
                    }
                    return false;
                }
                private final Log _log = LogFactoryUtil.getLog(ProposalTabActivityCountAlgorithm.class);
    }
            , ProposalTabCanAccessAlgorithm.canEditAccess, ProposalTabActivityCountAlgorithm.alwaysZero), // TODO might need to change this
    IMPACT("Impact", Type.NORMAL, ProposalTabCanAccessAlgorithm.impactViewAccess, ProposalTabCanAccessAlgorithm.impactEditAccess, ProposalTabActivityCountAlgorithm.alwaysZero),
    TEAM("Contributors", Type.NORMAL, ProposalTabCanAccessAlgorithm.alwaysTrue, ProposalTabCanAccessAlgorithm.alwaysFalse, ProposalTabActivityCountAlgorithm.membersCount),
    COMMENTS("Comments", Type.NORMAL, ProposalTabCanAccessAlgorithm.alwaysTrue, ProposalTabCanAccessAlgorithm.alwaysFalse, ProposalTabActivityCountAlgorithm.commentsCount),
    SCREENING("Screening", Type.HIGHLIGHT, ProposalTabCanAccessAlgorithm.screeningAccess, ProposalTabCanAccessAlgorithm.alwaysFalse, ProposalTabActivityCountAlgorithm.alwaysZero),
    ADVANCING("Advancing", Type.HIGHLIGHT, ProposalTabCanAccessAlgorithm.advancingAccess, ProposalTabCanAccessAlgorithm.alwaysFalse, ProposalTabActivityCountAlgorithm.alwaysZero),
    EVALUATION("Evaluation Results", Type.NORMAL, ProposalTabCanAccessAlgorithm.evaluationResultsAccess, ProposalTabCanAccessAlgorithm.alwaysFalse, ProposalTabActivityCountAlgorithm.evaluationCommentsCount),
    FELLOW_REVIEW("Fellow Review", Type.NORMAL, ProposalTabCanAccessAlgorithm.fellowReviewAccess, ProposalTabCanAccessAlgorithm.alwaysFalse, ProposalTabActivityCountAlgorithm.fellowReviewCommentsCount),
    ADMIN("Admin", Type.NORMAL, ProposalTabCanAccessAlgorithm.adminOnlyAccess, ProposalTabCanAccessAlgorithm.alwaysFalse, ProposalTabActivityCountAlgorithm.alwaysZero),
    POINTS("Points", Type.NORMAL, ProposalTabCanAccessAlgorithm.pointsViewAccess, ProposalTabCanAccessAlgorithm.pointsEditAccess, ProposalTabActivityCountAlgorithm.alwaysZero);

    private final String displayName;
    private final Type tabType;
    private final ProposalTabCanAccessAlgorithm canAccessTabAlgorithm;
    private final ProposalTabCanAccessAlgorithm canEditAlgorithm;
    private final ProposalTabActivityCountAlgorithm activitiesCountAlgorithm;
    
    ProposalTab(String displayName, Type tabType, ProposalTabCanAccessAlgorithm canAccessTabAlgorithm,
                ProposalTabCanAccessAlgorithm canEditAlgorithm,
                ProposalTabActivityCountAlgorithm activitiesCountAlgorithm) {
        this.displayName = displayName;
        this.tabType = tabType;
        this.canAccessTabAlgorithm = canAccessTabAlgorithm;
        this.canEditAlgorithm = canEditAlgorithm;
        this.activitiesCountAlgorithm = activitiesCountAlgorithm;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    public boolean isDefault() {
        return this.ordinal() == 0;
    }
    
    public boolean getCanAccess(ProposalsPermissions permissions, ProposalsContext context, PortletRequest request) {
        return canAccessTabAlgorithm.canAccess(permissions, context, request);
    }

    public boolean getCanEdit(ProposalsPermissions permissions, ProposalsContext context, PortletRequest request) {
        return canEditAlgorithm.canAccess(permissions, context, request);
    }
    
    public int getActivityCount(ProposalsContext context, PortletRequest request) {
        return activitiesCountAlgorithm.getActivityCount(context, request);
    }

    public Type getTabType() {
        return tabType;
    }

    public enum Type {
        NORMAL(""),
        HIGHLIGHT("highlight");

        private final String cssModifier;

        Type(String cssModifier) {

            this.cssModifier = cssModifier;
        }

        public String getCssModifier() {
            return cssModifier;
        }
    }
    
}