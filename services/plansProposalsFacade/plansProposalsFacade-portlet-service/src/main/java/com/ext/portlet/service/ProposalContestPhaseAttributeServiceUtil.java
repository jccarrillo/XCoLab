package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ProposalContestPhaseAttribute. This utility wraps
 * {@link com.ext.portlet.service.impl.ProposalContestPhaseAttributeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ProposalContestPhaseAttributeService
 * @see com.ext.portlet.service.base.ProposalContestPhaseAttributeServiceBaseImpl
 * @see com.ext.portlet.service.impl.ProposalContestPhaseAttributeServiceImpl
 * @generated
 */
public class ProposalContestPhaseAttributeServiceUtil {
    private static ProposalContestPhaseAttributeService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.ProposalContestPhaseAttributeServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static ProposalContestPhaseAttributeService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ProposalContestPhaseAttributeService.class.getName());

            if (invokableService instanceof ProposalContestPhaseAttributeService) {
                _service = (ProposalContestPhaseAttributeService) invokableService;
            } else {
                _service = new ProposalContestPhaseAttributeServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(ProposalContestPhaseAttributeServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ProposalContestPhaseAttributeService service) {
    }
}
