package com.ext.portlet.model.impl;

import com.ext.portlet.model.ContestSchedule;
import com.ext.portlet.service.ContestScheduleLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ContestSchedule service. Represents a row in the &quot;xcolab_ContestSchedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContestScheduleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestScheduleImpl
 * @see com.ext.portlet.model.ContestSchedule
 * @generated
 */
public abstract class ContestScheduleBaseImpl extends ContestScheduleModelImpl
    implements ContestSchedule {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a contest schedule model instance should use the {@link ContestSchedule} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ContestScheduleLocalServiceUtil.addContestSchedule(this);
        } else {
            ContestScheduleLocalServiceUtil.updateContestSchedule(this);
        }
    }
}
