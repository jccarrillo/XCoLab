package org.xcolab.portlets.loginregister;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;

import javax.portlet.ActionRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class Helper {

    private static final Log _log = LogFactoryUtil.getLog(Helper.class);

    public static String removeParamFromRequestStr(String requestStr, String param) {
        return requestStr == null ? null : requestStr.replaceAll("&?" + param + "=[^&#]*", "");
    }

    public static String modifyRedirectUrl(String redirect, ActionRequest actionRequest, Map<String, String> parameters)
            throws UnsupportedEncodingException {

        StringBuilder sb = new StringBuilder();
        // remove error info from url
        String[] locationAndHash = redirect.split("#");
        String[] locationAndQueryString = locationAndHash[0].split("\\?");

        sb.append(locationAndQueryString[0]);
        sb.append("?");

        if (locationAndQueryString.length > 1 && locationAndQueryString[1].length() > 0) {
            sb.append(locationAndQueryString[1]);
            sb.append("&");
        }

        Iterator<String> iter = SessionErrors.iterator(actionRequest);
        boolean appendAnd = false;

        while (iter.hasNext()) {
            if (appendAnd) {
                sb.append("&");
            }

            sb.append("signinRegError=");
            String exception = iter.next();
            sb.append(exception.substring(exception.lastIndexOf(".") + 1));
            _log.error("User encountered exception during login: " + exception);

            appendAnd = true;
        }

        for (String key : parameters.keySet()) {
            if (appendAnd) {
                sb.append("&");
            }
            appendAnd = true;
            sb.append(key).append("=").append(URLEncoder.encode(parameters.get(key), "UTF-8"));
        }

        if (locationAndHash.length > 1) {
            sb.append("#");
            sb.append(locationAndHash[1]);
        }

        redirect = sb.toString();

        return redirect;
    }
}
