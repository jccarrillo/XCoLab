package com.ext.portlet.model.impl;

import com.ext.portlet.model.ProposalAttribute;
import com.ext.portlet.service.ProposalAttributeLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ProposalAttribute service. Represents a row in the &quot;xcolab_ProposalAttribute&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProposalAttributeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalAttributeImpl
 * @see com.ext.portlet.model.ProposalAttribute
 * @generated
 */
public abstract class ProposalAttributeBaseImpl
    extends ProposalAttributeModelImpl implements ProposalAttribute {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a proposal attribute model instance should use the {@link ProposalAttribute} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ProposalAttributeLocalServiceUtil.addProposalAttribute(this);
        } else {
            ProposalAttributeLocalServiceUtil.updateProposalAttribute(this);
        }
    }
}
