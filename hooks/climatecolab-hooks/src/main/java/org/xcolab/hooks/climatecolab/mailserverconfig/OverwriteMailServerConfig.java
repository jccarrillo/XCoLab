package org.xcolab.hooks.climatecolab.mailserverconfig;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.PortalPreferences;
import com.liferay.portal.service.PortalPreferencesLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OverwriteMailServerConfig extends SimpleAction {
    private Log _log = LogFactoryUtil.getLog(OverwriteMailServerConfig.class);
    private final static String PRODUCTION_SERVER_IP_ADRESS = "18.4.70.53";
    private final static List<String> PRODUCTION_SERVER_NAMES = Arrays.asList("climatecolab.org", "climatecolab.com", "ssm-balaur.mit.edu");
    private final static List<Integer> PRODUCTION_SERVER_PORTS = Arrays.asList(18081);
    private final static String EMAIL_SENT_FILE_NAME = ".xcolab.sendmails";

    /*public OverwriteMailServerConfig() {
        super();
    }*/
    @Override
    public void run(String[] ids) {
        _log.info("Checking server and overwriting mail server config if this is not the production server!");
        boolean isProductionServer = isProductionServerName() && isSendEmailFileAvailable();
        // TODO remove
        isProductionServer = isSendEmailFileAvailable();
        if (!isProductionServer) {
            overwriteEmailConfigInDatabase();
        }
    }

    private boolean isProductionServerName() {
        String serverName = PortalUtil.getComputerName();
        Integer serverPort = PortalUtil.getPortalPort(false);
        _log.info("Sever info -> serverName: " + serverName + " serverPort: " + serverPort);
        // TODO remove
        System.out.println("Sever info -> serverName: " + serverName + " serverPort: " + serverPort);
        boolean validProductionServer = PRODUCTION_SERVER_NAMES.contains(serverPort);
        boolean validProductionServerPort = PRODUCTION_SERVER_PORTS.contains(serverPort);
        return  validProductionServer && validProductionServerPort;
    }

    private boolean isSendEmailFileAvailable() {
        String root = PropsUtil.get("liferay.home");
        //check if the send emails file exists
        return new File(root + "/" + EMAIL_SENT_FILE_NAME).isFile();
    }

    private void overwriteEmailConfigInDatabase() {
        final DynamicQuery mailPreferences = DynamicQueryFactoryUtil.forClass(PortalPreferences.class);
        mailPreferences.add(
                PropertyFactoryUtil.forName("ownerId").eq(0L)).add(
                PropertyFactoryUtil.forName("ownerType").eq(1)
        );

        try {
            List<PortalPreferences> result = PortalPreferencesLocalServiceUtil.dynamicQuery(mailPreferences);
            if (result.size() == 1) {
                PortalPreferences p = result.get(0);
                String prefs = p.getPreferences();

                //replace the smtp mail server entry
                Pattern smtpServerPattern = Pattern.compile("<preference><name>mail.session.mail.smtp.host</name><value>(.*?)</value></preference>");
                Matcher m = smtpServerPattern.matcher(prefs);
                String newPrefs = m.replaceAll("<preference><name>mail.session.mail.smtp.host</name><value>example.com</value></preference>");

                p.setPreferences(newPrefs);
                PortalPreferencesLocalServiceUtil.updatePortalPreferences(p);

                //clear cache
                MultiVMPoolUtil.clear();
                CacheRegistryUtil.clear();

                _log.info("OverwriteMailServerConfig overwrote the SMTP mail server configuration because we are not on production.");
            } else {
                _log.warn("OverwriteMailServerConfig found too many matching PortalPreferences (ownerId=0, ownerType=1).");
            }
        } catch (SystemException e) {
            _log.error("OverwriteMailServerConfig failed. Please be careful with emails and check your stmp settings immediately", e);
            e.printStackTrace();
        }
    }
}