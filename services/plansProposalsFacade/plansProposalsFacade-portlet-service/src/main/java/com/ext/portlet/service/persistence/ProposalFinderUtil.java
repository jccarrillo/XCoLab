package com.ext.portlet.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class ProposalFinderUtil {
    private static ProposalFinder _finder;

    public static java.util.List<com.ext.portlet.model.Proposal> findByContestPhaseIdAndVisible(
        long contestPhaseId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .findByContestPhaseIdAndVisible(contestPhaseId, start, end);
    }

    public static ProposalFinder getFinder() {
        if (_finder == null) {
            _finder = (ProposalFinder) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    ProposalFinder.class.getName());

            ReferenceRegistry.registerReference(ProposalFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(ProposalFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(ProposalFinderUtil.class, "_finder");
    }
}
