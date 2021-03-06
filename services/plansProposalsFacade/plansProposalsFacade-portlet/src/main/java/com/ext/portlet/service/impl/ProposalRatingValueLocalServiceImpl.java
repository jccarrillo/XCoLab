package com.ext.portlet.service.impl;

import com.ext.portlet.model.ProposalRatingValue;
import com.ext.portlet.service.base.ProposalRatingValueLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the proposal rating value local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.service.ProposalRatingValueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.service.base.ProposalRatingValueLocalServiceBaseImpl
 * @see com.ext.portlet.service.ProposalRatingValueLocalServiceUtil
 */
public class ProposalRatingValueLocalServiceImpl
    extends ProposalRatingValueLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ext.portlet.service.ProposalRatingValueLocalServiceUtil} to access the proposal rating value local service.
     */

    @Override
    public List<ProposalRatingValue> getRatingValuesForRatingTypeId(long proposalRatingTypeId) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(ProposalRatingValue.class)
                .add(PropertyFactoryUtil.forName("ratingTypeId").eq(proposalRatingTypeId));
        query.addOrder(OrderFactoryUtil.asc("value"));
        return dynamicQuery(query);
    }
}