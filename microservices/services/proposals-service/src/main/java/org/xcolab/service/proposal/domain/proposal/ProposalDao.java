package org.xcolab.service.proposal.domain.proposal;

import org.xcolab.model.tables.pojos.Proposal;
import org.xcolab.service.proposal.exceptions.NotFoundException;
import org.xcolab.service.utils.PaginationHelper;

import java.util.List;

public interface ProposalDao {

    List<Proposal> findByGiven(PaginationHelper paginationHelper, Long contestId, Boolean visible,
            Long contestPhaseId, Integer ribbon);

    Proposal create(Proposal proposal);

    Proposal get(Long proposalId) throws NotFoundException;

    boolean update(Proposal proposal);

}
