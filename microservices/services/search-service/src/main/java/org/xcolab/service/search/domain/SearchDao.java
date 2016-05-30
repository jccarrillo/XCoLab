package org.xcolab.service.search.domain;

import org.xcolab.service.search.wrappers.MemberSearchResult;
import org.xcolab.service.utils.PaginationHelper;

import java.util.List;

public interface SearchDao {
    List<MemberSearchResult> searchMembers(PaginationHelper paginationHelper, String query);
}
