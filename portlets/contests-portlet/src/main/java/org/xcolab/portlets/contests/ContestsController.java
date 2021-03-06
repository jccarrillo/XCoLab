package org.xcolab.portlets.contests;

import com.ext.portlet.model.Contest;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.xcolab.util.exceptions.DatabaseAccessException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;


@Controller
@RequestMapping("view")
public class ContestsController {

    private static final Log _log = LogFactoryUtil.getLog(ContestsController.class);
    
    public ContestsController() {
    }

    @RequestMapping
    public String showContests(PortletRequest request, PortletResponse response, Model model)  {

        ContestPreferences contestPreferences = new ContestPreferences(request);

        List<ContestWrapper> contestWrappers = new ArrayList<>();
        try {
            List<Contest> contests;
            if (contestPreferences.getSelectedContests().isEmpty()) {
                contests = ContestLocalServiceUtil.findByActiveFeatured(true, true);
            } else {
                contests = new ArrayList<>();
                for (Long contestId : contestPreferences.getSelectedContests()) {
                    try {
                        contests.add(ContestLocalServiceUtil.getContest(contestId));
                    } catch (PortalException e) {
                        _log.error("Could not find contest " + contestId);
                    }
                }
            }

            Collections.shuffle(contests);
            for (Contest contest : contests) {
                if (contestWrappers.size() >= contestPreferences.getFeedSize()) {
                    break;
                }
                if (contest.getContestPrivate()) {
                    continue;
                }
                contestWrappers.add(new ContestWrapper(contest));
            }

            model.addAttribute("contests", contestWrappers);
            model.addAttribute("preferences", contestPreferences);
            return "showContests";
        } catch (SystemException e) {
            throw new DatabaseAccessException(e);
        }
    }
}