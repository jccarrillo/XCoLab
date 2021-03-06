package org.xcolab.utils;

import com.ext.portlet.model.ContestType;
import com.ext.portlet.service.ContestTypeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.xcolab.client.admin.enums.ConfigurationAttributeKey;
import org.xcolab.util.exceptions.DatabaseAccessException;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;

public final class TemplateReplacementUtil {

    private static final Log _log = LogFactoryUtil.getLog(TemplateReplacementUtil.class);

    private final static String COLAB_NAME_PLACEHOLDER = "<colab-name/>";
    private final static String COLAB_SHORT_NAME_PLACEHOLDER = "<colab-short-name/>";
    private final static String COLAB_URL = "<colab-url/>";

    private final static String ADMIN_EMAIL_PLACEHOLDER = "<admin-email/>";
    private final static String ADMIN_FROM_EMAIL_PLACEHOLDER = "<admin-from-email/>";

    private final static String PROPOSAL_PLACEHOLDER = "<proposal/>";
    private final static String CONTEST_PLACEHOLDER = "<contest/>";
    private final static String PROPOSALS_PLACEHOLDER = "<proposals/>";
    private final static String CONTESTS_PLACEHOLDER = "<contests/>";

    private TemplateReplacementUtil() {
    }

    public static String replacePlatformConstants(String text) {
        final String colabName = ConfigurationAttributeKey.COLAB_NAME.getStringValue();
        final String colabShortName = ConfigurationAttributeKey.COLAB_SHORT_NAME.getStringValue();
        final String colabUrl = ConfigurationAttributeKey.COLAB_URL.getStringValue();
        final String adminEmail = ConfigurationAttributeKey.ADMIN_EMAIL.getStringValue();
        final String adminFromEmail = ConfigurationAttributeKey.ADMIN_FROM_EMAIL.getStringValue();

        return text.replaceAll(COLAB_NAME_PLACEHOLDER, colabName)
                .replaceAll(COLAB_SHORT_NAME_PLACEHOLDER, colabShortName)
                .replaceAll(COLAB_URL, colabUrl)
                .replaceAll(ADMIN_EMAIL_PLACEHOLDER, adminEmail)
                .replaceAll(ADMIN_FROM_EMAIL_PLACEHOLDER, adminFromEmail);
    }

    public static String replaceContestTypeStrings(String text, ContestType contestType) {
        try {
            if (contestType == null) {
                contestType = ContestTypeLocalServiceUtil.getContestType(
                        ConfigurationAttributeKey.DEFAULT_CONTEST_TYPE_ID.getLongValue());
            }
            return text.replaceAll(PROPOSAL_PLACEHOLDER, contestType.getProposalName())
                    .replaceAll(PROPOSALS_PLACEHOLDER, contestType.getProposalNamePlural())
                    .replaceAll(CONTEST_PLACEHOLDER, contestType.getContestName())
                    .replaceAll(CONTESTS_PLACEHOLDER, contestType.getContestNamePlural());
        } catch (SystemException e) {
            throw new DatabaseAccessException(e);
        } catch (PortalException e) {
            throw new IllegalStateException("Default contest type does not exist: "
                    + ConfigurationAttributeKey.DEFAULT_CONTEST_TYPE_ID.getLongValue());
        }
    }

    public static InternetAddress getAdminFromEmailAddress() throws UnsupportedEncodingException {
            final String adminFromEmail = ConfigurationAttributeKey.ADMIN_FROM_EMAIL
                    .getStringValue();
            return new InternetAddress(adminFromEmail,
                    TemplateReplacementUtil.replacePlatformConstants("The <colab-name/> Team"));
    }
}
