package org.xcolab.service.search.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.xcolab.service.search.domain.SearchDao;
import org.xcolab.service.search.service.search.SearchService;
import org.xcolab.service.search.wrappers.SearchResult;
import org.xcolab.service.utils.PaginationHelper;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private SearchDao searchDao;

    @RequestMapping("/search")
    public List<SearchResult> findMembers(
            @RequestParam(required = false) Integer startRecord,
            @RequestParam(required = false) Integer limitRecord,
            @RequestParam(required = false) String sort,
            @RequestParam String query) {
        final PaginationHelper paginationHelper = new PaginationHelper(startRecord, limitRecord,
                sort);
        return searchService.searchMembers(paginationHelper, query);
    }
}
