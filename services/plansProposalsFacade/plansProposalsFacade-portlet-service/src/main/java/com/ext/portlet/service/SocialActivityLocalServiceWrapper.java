package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SocialActivityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivityLocalService
 * @generated
 */
public class SocialActivityLocalServiceWrapper
    implements SocialActivityLocalService,
        ServiceWrapper<SocialActivityLocalService> {
    private SocialActivityLocalService _socialActivityLocalService;

    public SocialActivityLocalServiceWrapper(
        SocialActivityLocalService socialActivityLocalService) {
        _socialActivityLocalService = socialActivityLocalService;
    }

    /**
    * Adds the social activity to the database. Also notifies the appropriate model listeners.
    *
    * @param socialActivity the social activity
    * @return the social activity that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.SocialActivity addSocialActivity(
        com.ext.portlet.model.SocialActivity socialActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.addSocialActivity(socialActivity);
    }

    /**
    * Creates a new social activity with the primary key. Does not add the social activity to the database.
    *
    * @param activityId the primary key for the new social activity
    * @return the new social activity
    */
    @Override
    public com.ext.portlet.model.SocialActivity createSocialActivity(
        long activityId) {
        return _socialActivityLocalService.createSocialActivity(activityId);
    }

    /**
    * Deletes the social activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param activityId the primary key of the social activity
    * @return the social activity that was removed
    * @throws PortalException if a social activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.SocialActivity deleteSocialActivity(
        long activityId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.deleteSocialActivity(activityId);
    }

    /**
    * Deletes the social activity from the database. Also notifies the appropriate model listeners.
    *
    * @param socialActivity the social activity
    * @return the social activity that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.SocialActivity deleteSocialActivity(
        com.ext.portlet.model.SocialActivity socialActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.deleteSocialActivity(socialActivity);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _socialActivityLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.SocialActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.SocialActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.ext.portlet.model.SocialActivity fetchSocialActivity(
        long activityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.fetchSocialActivity(activityId);
    }

    /**
    * Returns the social activity with the primary key.
    *
    * @param activityId the primary key of the social activity
    * @return the social activity
    * @throws PortalException if a social activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.SocialActivity getSocialActivity(
        long activityId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.getSocialActivity(activityId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the social activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.SocialActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of social activities
    * @param end the upper bound of the range of social activities (not inclusive)
    * @return the range of social activities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.ext.portlet.model.SocialActivity> getSocialActivities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.getSocialActivities(start, end);
    }

    /**
    * Returns the number of social activities.
    *
    * @return the number of social activities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getSocialActivitiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.getSocialActivitiesCount();
    }

    /**
    * Updates the social activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param socialActivity the social activity
    * @return the social activity that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.SocialActivity updateSocialActivity(
        com.ext.portlet.model.SocialActivity socialActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _socialActivityLocalService.updateSocialActivity(socialActivity);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _socialActivityLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _socialActivityLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _socialActivityLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SocialActivityLocalService getWrappedSocialActivityLocalService() {
        return _socialActivityLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSocialActivityLocalService(
        SocialActivityLocalService socialActivityLocalService) {
        _socialActivityLocalService = socialActivityLocalService;
    }

    @Override
    public SocialActivityLocalService getWrappedService() {
        return _socialActivityLocalService;
    }

    @Override
    public void setWrappedService(
        SocialActivityLocalService socialActivityLocalService) {
        _socialActivityLocalService = socialActivityLocalService;
    }
}
