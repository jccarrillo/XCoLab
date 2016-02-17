package org.xcolab.portlets.search.views;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.xcolab.portlets.search.SearchBean;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by johannes on 12/6/15.
 */
@Controller
@RequestMapping("view")
public class SearchController {

    @RenderMapping
    public String showCategories(PortletRequest request, PortletResponse response, Model model,
                                 @RequestParam(required = false) String searchPhrase,
                                 @RequestParam(required = false) String searchLocation,
                                 @RequestParam(required = false) Integer pageNumber)
            throws SystemException, IOException, ParseException, InvalidTokenOffsetsException, com.liferay.portal.kernel.search.ParseException, com.liferay.portal.kernel.search.SearchException {

        model.addAttribute("searchBean", new SearchBean(searchPhrase, searchLocation, pageNumber));

        return "search";
    }
}
