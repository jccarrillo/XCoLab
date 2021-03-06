package org.xcolab.portlets.proposals.utils;

import org.xcolab.portlets.proposals.wrappers.ProposalWrapper;

import java.util.Comparator;

public enum ProposalsColumn {
    NAME(new Comparator<ProposalWrapper>() {

        @Override
        public int compare(ProposalWrapper o1, ProposalWrapper o2) {
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
        
    }), 
    AUTHOR(new Comparator<ProposalWrapper>() {

        @Override
        public int compare(ProposalWrapper o1, ProposalWrapper o2) {
            return o1.getAuthorName().toLowerCase().compareTo(o2.getAuthorName().toLowerCase());
        }
        
    }),
    SUPPORTERS(new Comparator<ProposalWrapper>() {

        @Override
        public int compare(ProposalWrapper o1, ProposalWrapper o2) {
            return (int) (o1.getSupportersCount() - o2.getSupportersCount());
        }
        
    }),
    VOTES(new Comparator<ProposalWrapper>() {

        @Override
        public int compare(ProposalWrapper o1, ProposalWrapper o2) {
            try {
                return (int) (o1.getVotesCount() - o2.getVotesCount());
            }
            catch (Exception e) {
                return (int) (o1.getProposalId() - o2.getProposalId());
            }
        }
        
    }),
    COMMENTS(new Comparator<ProposalWrapper>() {

        @Override
        public int compare(ProposalWrapper o1, ProposalWrapper o2) {
            return (int) (o1.getCommentsCount() - o2.getCommentsCount());
        }
    }),
    JUDGESTATUS(new Comparator<ProposalWrapper>() {

        @Override
        public int compare(ProposalWrapper o1, ProposalWrapper o2) {
            return (o1.getJudgeStatus().getStatusValue() - o2.getJudgeStatus().getStatusValue());
        }
    }),
    OVERALLSTATUS(new Comparator<ProposalWrapper>() {

        @Override
        public int compare(ProposalWrapper o1, ProposalWrapper o2) {
            return (o1.getOverallStatus().getStatusValue() - o2.getOverallStatus().getStatusValue());
        }
    }),
    SCREENINGSTATUS(new Comparator<ProposalWrapper>() {

        @Override
        public int compare(ProposalWrapper o1, ProposalWrapper o2) {
            return (o1.getScreeningStatus().getStatusValue() - o2.getScreeningStatus().getStatusValue());
        }
    }),
    MODIFIED(new Comparator<ProposalWrapper>() {

        @Override
        public int compare(ProposalWrapper o1, ProposalWrapper o2) {
            return o1.getLastModifiedDate().compareTo(o2.getLastModifiedDate());
        }
    }),
    CONTRIBUTORS(new Comparator<ProposalWrapper>() {

        @Override
        public int compare(ProposalWrapper o1, ProposalWrapper o2) {
            if (o1.isOpen()) {
                return o2.isOpen() ? 0 : -1;
            } else {
                return o2.isOpen() ? 1 : 0;
            }
        }
    });
    
    private final Comparator<ProposalWrapper> proposalsComparator;
    
    ProposalsColumn(Comparator<ProposalWrapper> comparator) {
        proposalsComparator = comparator;
    }

    public Comparator<ProposalWrapper> getComparator() {
        return proposalsComparator;
    }

}
