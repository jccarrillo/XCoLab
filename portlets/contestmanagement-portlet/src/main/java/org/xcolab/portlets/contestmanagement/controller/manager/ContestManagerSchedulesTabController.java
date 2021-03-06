package org.xcolab.portlets.contestmanagement.controller.manager;

import com.ext.portlet.model.ContestPhaseType;
import com.ext.portlet.model.ContestSchedule;
import com.ext.portlet.service.ContestPhaseTypeLocalServiceUtil;
import com.ext.portlet.service.ContestScheduleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.xcolab.enums.ContestPhasePromoteType;
import org.xcolab.interfaces.TabEnum;
import org.xcolab.portlets.contestmanagement.entities.ContestManagerTabs;
import org.xcolab.portlets.contestmanagement.entities.LabelStringValue;
import org.xcolab.portlets.contestmanagement.entities.LabelValue;
import org.xcolab.portlets.contestmanagement.utils.ContestCreatorUtil;
import org.xcolab.portlets.contestmanagement.utils.SetRenderParameterUtil;
import org.xcolab.portlets.contestmanagement.wrappers.ContestScheduleWrapper;
import org.xcolab.portlets.contestmanagement.wrappers.ElementSelectIdWrapper;
import org.xcolab.util.exceptions.DatabaseAccessException;
import org.xcolab.wrapper.TabWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

@Controller
@RequestMapping("view")
public class ContestManagerSchedulesTabController extends ContestManagerBaseTabController {

    private final static Log _log = LogFactoryUtil.getLog(ContestManagerSchedulesTabController.class);
    static final private TabEnum tab = ContestManagerTabs.SCHEDULES;
    static final private String TAB_VIEW = "manager/schedulesTab";

    @ModelAttribute("currentTabWrapped")
    @Override
    public TabWrapper populateCurrentTabWrapped(PortletRequest request) throws PortalException, SystemException {
        tabWrapper = new TabWrapper(tab, request, tabContext);
        request.getPortletSession().setAttribute("tabWrapper", tabWrapper);
        return tabWrapper;
    }

    @ModelAttribute("contestPhaseTypesSelectionItems")
    public List<LabelValue> populateContestPhaseTypesSelectionItems() {
        return getContestPhaseTypesSelectionItems();
    }

    @ModelAttribute("contestPhaseAutopromoteSelectionItems")
    public List<LabelStringValue> populateContestPhaseAutopromoteSelectionItems() {
        return getContestPhaseAutopromoteSelectionItems();
    }

    @RequestMapping(params = "tab=SCHEDULES")
    public String showScheduleTabController(PortletRequest request, PortletResponse response, Model model,
            @RequestParam(value = "elementId", required = false) Long elementId) {
        if (!tabWrapper.getCanView()) {
            return NO_PERMISSION_TAB_VIEW;
        }

        try {
            Long scheduleId = elementId != null ? elementId : getFirstScheduleId();
            model.addAttribute("scheduleId", scheduleId);
            if (scheduleId >= 0) {
                model.addAttribute("contestScheduleWrapper", new ContestScheduleWrapper(scheduleId));
            }
            model.addAttribute("elementSelectIdWrapper", new ElementSelectIdWrapper(scheduleId,
                    ContestScheduleWrapper.getAllScheduleTemplateSelectionItems()));
            setPageAttributes(request, model, tab);
            return TAB_VIEW;
        } catch (SystemException | PortalException e) {
            _log.warn("Exception while rendering CMS schedules tab", e);
            SetRenderParameterUtil.addActionExceptionMessageToSession(request, e);
        }
        return NOT_FOUND_TAB_VIEW;
    }

    @RequestMapping(params = "action=createContestSchedule")
    public void createNewScheduleTabController(ActionRequest request, Model model, ActionResponse response) {

        if (!tabWrapper.getCanEdit()) {
            SetRenderParameterUtil.setNoPermissionErrorRenderParameter(response);
            return;
        }

        try {
            ContestSchedule newContestSchedule = ContestCreatorUtil.createNewSchedule();
            SetRenderParameterUtil
                    .setSuccessRenderRedirectManagerTab(response, tab.getName(), newContestSchedule.getId());

        } catch (IOException e) {
            _log.warn("Create contest schedule failed with: ", e);
            SetRenderParameterUtil.setExceptionRenderParameter(response, e);
        }
    }

    @RequestMapping(params = "action=deleteContestSchedule")
    public void deleteScheduleTabController(ActionRequest request, Model model,
            @RequestParam(value = "scheduleId", required = true) Long scheduleId,
            ActionResponse response) {
        if (!tabWrapper.getCanEdit()) {
            SetRenderParameterUtil.setNoPermissionErrorRenderParameter(response);
            return;
        }
        try {
            ContestScheduleWrapper.deleteContestSchedule(scheduleId);
            SetRenderParameterUtil.setSuccessRenderRedirectManagerTab(response, tab.getName(), getFirstScheduleId());
        } catch (IOException e) {
            _log.warn("Delete contest schedule failed with: ", e);
            SetRenderParameterUtil.setExceptionRenderParameter(response, e);
        }
    }

    @RequestMapping(params = "action=updateContestSchedule")
    public void updateScheduleTabController(ActionRequest request, Model model,
            @ModelAttribute ContestScheduleWrapper updateContestScheduleWrapper,
            BindingResult result, ActionResponse response) {
        if (!tabWrapper.getCanEdit()) {
            SetRenderParameterUtil.setNoPermissionErrorRenderParameter(response);
            return;
        }

        if (result.hasErrors()) {
            model.addAttribute("elementSelectIdWrapper",
                    new ElementSelectIdWrapper(updateContestScheduleWrapper.getScheduleId(),
                            ContestScheduleWrapper.getAllScheduleTemplateSelectionItems()));
            SetRenderParameterUtil.setErrorRenderParameter(response, "updateContestSchedule");
            return;
        }

        try {
            updateContestScheduleWrapper.persist();
            SetRenderParameterUtil.addActionSuccessMessageToSession(request);
            SetRenderParameterUtil.setSuccessRenderRedirectManagerTab(response, tab.getName(),
                    updateContestScheduleWrapper.getScheduleId());
        } catch (IOException e) {
            _log.warn("Update contest schedule failed with: ", e);
            SetRenderParameterUtil.setExceptionRenderParameter(response, e);
        }
    }

    @RequestMapping(params = {"action=updateContestSchedule", "error=true"})
    public String reportError(PortletRequest request, Model model) throws PortalException, SystemException {
        return TAB_VIEW;
    }

    private Long getFirstScheduleId() {
        try {
            final List<ContestSchedule> contestSchedules =
                    ContestScheduleLocalServiceUtil.getContestSchedules(0, Integer.MAX_VALUE);
            if (!contestSchedules.isEmpty()) {
                return contestSchedules.get(0).getId();
            }
            return -1L;
        } catch (SystemException e) {
            throw new DatabaseAccessException(e);
        }
    }

    private List<LabelValue> getContestPhaseTypesSelectionItems() {
        List<LabelValue> contestPhaseTypesSelectionItems = new ArrayList<>();
        try {
            List<ContestPhaseType> contestPhases =
                    ContestPhaseTypeLocalServiceUtil.getContestPhaseTypes(0, Integer.MAX_VALUE);
            for (ContestPhaseType contestPhaseType : contestPhases) {
                contestPhaseTypesSelectionItems
                        .add(new LabelValue(contestPhaseType.getId(), contestPhaseType.getName()));
            }
        } catch (SystemException e) {
            _log.warn("Could not get contest phase types selection items: ", e);
        }
        return contestPhaseTypesSelectionItems;
    }

    private List<LabelStringValue> getContestPhaseAutopromoteSelectionItems() {
        List<LabelStringValue> contestPhaseAutopromoteSelectionItems = new ArrayList<>();
        for (ContestPhasePromoteType contestPhasePromoteType : ContestPhasePromoteType.values()) {
            contestPhaseAutopromoteSelectionItems
                    .add(new LabelStringValue(contestPhasePromoteType.getValue(), contestPhasePromoteType.getValue()));
        }
        return contestPhaseAutopromoteSelectionItems;
    }
}