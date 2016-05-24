package org.xcolab.service.search.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.xcolab.service.search.domain.SearchDao;
import org.xcolab.service.search.wrappers.SearchResult;
import org.xcolab.service.utils.PaginationHelper;

import java.util.List;

@Service
public class SearchService {

    private final SearchDao searchDao;

    @Autowired
    public SearchService(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    public List<SearchResult> searchProposals(PaginationHelper paginationHelper, String query) {
        final List<SearchResult> results = searchDao
                .searchProposalAttributes(paginationHelper, query);
        for (SearchResult result : results) {
            result.applyHighlight(query);
        }
        return results;
    }

    public List<SearchResult> searchMembers(PaginationHelper paginationHelper, String query) {
        final List<SearchResult> results = searchDao
                .searchMembers(paginationHelper, query);
        for (SearchResult result : results) {
            result.applyHighlight(query);
        }
        return results;
    }
}