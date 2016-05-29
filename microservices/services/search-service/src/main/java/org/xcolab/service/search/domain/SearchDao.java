package org.xcolab.service.search.domain;

import org.xcolab.service.search.wrappers.MemberSearchResult;
import org.xcolab.service.search.wrappers.SearchResult;
import org.xcolab.service.utils.PaginationHelper;

import java.util.List;

public interface SearchDao {
    List<SearchResult> searchProposalAttributes(PaginationHelper paginationHelper, String query);
    List<MemberSearchResult> searchMembers(PaginationHelper paginationHelper, String query);
}
