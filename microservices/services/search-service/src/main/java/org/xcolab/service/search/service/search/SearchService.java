package org.xcolab.service.search.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.xcolab.service.search.domain.SearchDao;
import org.xcolab.service.search.wrappers.MemberSearchResult;
import org.xcolab.service.search.wrappers.SearchResult;
import org.xcolab.service.utils.PaginationHelper;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private final SearchDao searchDao;

    @Autowired
    public SearchService(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    public List<SearchResult> searchMembers(PaginationHelper paginationHelper, String query) {
        final List<MemberSearchResult> memberResults = searchDao
                .searchMembers(paginationHelper, query);
        final List<SearchResult> searchResults = new ArrayList<>();
        for (MemberSearchResult result : memberResults) {
            searchResults.add(result.getSearchResult(query));
        }
        return searchResults;
    }
}