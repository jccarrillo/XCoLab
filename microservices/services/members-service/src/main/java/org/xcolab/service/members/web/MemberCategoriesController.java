package org.xcolab.service.members.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.xcolab.model.tables.pojos.MemberCategory;
import org.xcolab.service.members.domain.membercategory.MemberCategoryDao;
import org.xcolab.service.members.service.membercategory.MemberCategoryService;
import org.xcolab.service.utils.PaginationHelper;

import java.util.List;

@RestController
public class MemberCategoriesController {

    @Autowired
    private MemberCategoryDao memberCategoryDao;

    @Autowired
    private MemberCategoryService memberCategoryService;

    @RequestMapping(value = "/membercategories/{roleId}", method = RequestMethod.GET)
    public MemberCategory getMemberCategory(@PathVariable long roleId) {
        return this.memberCategoryDao.getMemberCategory(roleId);
    }

    @RequestMapping(value = "/membercategories", method = RequestMethod.GET)
    public List<MemberCategory> getMemberCategory(
            @RequestParam(required = false) Integer startRecord,
            @RequestParam(required = false) Integer limitRecord,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String displayName,
            @RequestParam(required = false) String categoryName) {
        PaginationHelper paginationHelper = new PaginationHelper(startRecord, limitRecord, sort);
        return this.memberCategoryDao.findByGiven(paginationHelper, displayName, categoryName);
    }
}
