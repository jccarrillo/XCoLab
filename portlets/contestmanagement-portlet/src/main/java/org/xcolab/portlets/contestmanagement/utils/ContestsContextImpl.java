package org.xcolab.portlets.contestmanagement.utils;

import com.ext.portlet.model.Contest;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import org.springframework.stereotype.Component;
import org.xcolab.interfaces.TabContext;
import org.xcolab.interfaces.TabPermissions;
import org.xcolab.util.exceptions.DatabaseAccessException;
import org.xcolab.util.exceptions.InternalException;
import org.xcolab.wrappers.BaseContestWrapper;

import javax.portlet.PortletRequest;

@Component
public class ContestsContextImpl implements TabContext {
    private static final String CONTEXT_ATTRIBUTE_PREFIX = "_proposalsPortlet_";
    private static final String CONTEXT_INITIALIZED_ATTRIBUTE = CONTEXT_ATTRIBUTE_PREFIX + "contextInitialized";
    private static final String PERMISSIONS_ATTRIBUTE = CONTEXT_ATTRIBUTE_PREFIX + "permissions";
    private static final String CONTEST_ATTRIBUTE = CONTEXT_ATTRIBUTE_PREFIX + "contest";
    private static final String USER_ATTRIBUTE = CONTEXT_ATTRIBUTE_PREFIX + "user";
    private static final String CONTEST_WRAPPED_ATTRIBUTE = CONTEXT_ATTRIBUTE_PREFIX + "contestWrapped";
    private static final String CONTEST_ID_PARAM = "contestId";
    private static final String CONTEST_MANAGEMENT_PARAM = "manager";

    public ContestsContextImpl() {
    }

    @Override
    public Contest getContest(PortletRequest request) {
        return getAttribute(request, CONTEST_ATTRIBUTE, Contest.class);
    }

    @Override
    public BaseContestWrapper getContestWrapped(PortletRequest request) {
        return getAttribute(request, CONTEST_WRAPPED_ATTRIBUTE, BaseContestWrapper.class);
    }

    @Override
    public TabPermissions getPermissions(PortletRequest request) {
        return getAttribute(request, PERMISSIONS_ATTRIBUTE, TabPermissions.class);
    }

    @Override
    public User getUser(PortletRequest request) {
        return getAttribute(request, USER_ATTRIBUTE, User.class);
    }

    @Override
    public void invalidateContext(PortletRequest request) {
        request.removeAttribute(CONTEXT_INITIALIZED_ATTRIBUTE);
    }

    private <T> T getAttribute(PortletRequest request, String attributeName, Class<T> clasz) {
        Object contextInitialized = request.getAttribute(CONTEXT_INITIALIZED_ATTRIBUTE);
        if (contextInitialized == null) {
            init(request);
        }
        return (T) request.getAttribute(attributeName);
    }

    private void init(PortletRequest request) {
        final Boolean mangerView = ParamUtil.getBoolean(request, CONTEST_MANAGEMENT_PARAM);
        if (mangerView) {
            request.setAttribute(PERMISSIONS_ATTRIBUTE, new ContestManagementPermissions(request));
        } else {
            final Long contestId = ParamUtil.getLong(request, CONTEST_ID_PARAM);
            Contest contest;
            try {
                contest = ContestLocalServiceUtil.getContest(contestId);
            } catch (PortalException e) {
                throw new InternalException(e);
            } catch (SystemException e) {
                throw new DatabaseAccessException(e);
            }

            if (contest != null) {
                request.setAttribute(CONTEST_ATTRIBUTE, contest);
                request.setAttribute(CONTEST_WRAPPED_ATTRIBUTE, new BaseContestWrapper(contest));
                request.setAttribute(PERMISSIONS_ATTRIBUTE, new ContestPermissions(request, contest));
            }
        }

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        request.setAttribute(USER_ATTRIBUTE, themeDisplay.getUser());
        request.setAttribute(CONTEXT_INITIALIZED_ATTRIBUTE, true);
    }

    private final static Log _log = LogFactoryUtil.getLog(ContestsContextImpl.class);
}
