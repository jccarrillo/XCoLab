package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ModelInputGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ModelInputGroupLocalService
 * @generated
 */
public class ModelInputGroupLocalServiceWrapper
    implements ModelInputGroupLocalService,
        ServiceWrapper<ModelInputGroupLocalService> {
    private ModelInputGroupLocalService _modelInputGroupLocalService;

    public ModelInputGroupLocalServiceWrapper(
        ModelInputGroupLocalService modelInputGroupLocalService) {
        _modelInputGroupLocalService = modelInputGroupLocalService;
    }

    /**
    * Adds the model input group to the database. Also notifies the appropriate model listeners.
    *
    * @param modelInputGroup the model input group
    * @return the model input group that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.ModelInputGroup addModelInputGroup(
        com.ext.portlet.model.ModelInputGroup modelInputGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _modelInputGroupLocalService.addModelInputGroup(modelInputGroup);
    }

    /**
    * Creates a new model input group with the primary key. Does not add the model input group to the database.
    *
    * @param modelInputGroupPK the primary key for the new model input group
    * @return the new model input group
    */
    @Override
    public com.ext.portlet.model.ModelInputGroup createModelInputGroup(
        long modelInputGroupPK) {
        return _modelInputGroupLocalService.createModelInputGroup(modelInputGroupPK);
    }

    /**
    * Deletes the model input group with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param modelInputGroupPK the primary key of the model input group
    * @return the model input group that was removed
    * @throws PortalException if a model input group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.ModelInputGroup deleteModelInputGroup(
        long modelInputGroupPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _modelInputGroupLocalService.deleteModelInputGroup(modelInputGroupPK);
    }

    /**
    * Deletes the model input group from the database. Also notifies the appropriate model listeners.
    *
    * @param modelInputGroup the model input group
    * @return the model input group that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.ModelInputGroup deleteModelInputGroup(
        com.ext.portlet.model.ModelInputGroup modelInputGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _modelInputGroupLocalService.deleteModelInputGroup(modelInputGroup);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _modelInputGroupLocalService.dynamicQuery();
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
        return _modelInputGroupLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelInputGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _modelInputGroupLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelInputGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _modelInputGroupLocalService.dynamicQuery(dynamicQuery, start,
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
        return _modelInputGroupLocalService.dynamicQueryCount(dynamicQuery);
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
        return _modelInputGroupLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.ext.portlet.model.ModelInputGroup fetchModelInputGroup(
        long modelInputGroupPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _modelInputGroupLocalService.fetchModelInputGroup(modelInputGroupPK);
    }

    /**
    * Returns the model input group with the primary key.
    *
    * @param modelInputGroupPK the primary key of the model input group
    * @return the model input group
    * @throws PortalException if a model input group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.ModelInputGroup getModelInputGroup(
        long modelInputGroupPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _modelInputGroupLocalService.getModelInputGroup(modelInputGroupPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _modelInputGroupLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the model input groups.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelInputGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of model input groups
    * @param end the upper bound of the range of model input groups (not inclusive)
    * @return the range of model input groups
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.ext.portlet.model.ModelInputGroup> getModelInputGroups(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _modelInputGroupLocalService.getModelInputGroups(start, end);
    }

    /**
    * Returns the number of model input groups.
    *
    * @return the number of model input groups
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getModelInputGroupsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _modelInputGroupLocalService.getModelInputGroupsCount();
    }

    /**
    * Updates the model input group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param modelInputGroup the model input group
    * @return the model input group that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.ModelInputGroup updateModelInputGroup(
        com.ext.portlet.model.ModelInputGroup modelInputGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _modelInputGroupLocalService.updateModelInputGroup(modelInputGroup);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _modelInputGroupLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _modelInputGroupLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _modelInputGroupLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.List<com.ext.portlet.model.ModelInputGroup> getInputGroups(
        edu.mit.cci.roma.client.Simulation sim) {
        return _modelInputGroupLocalService.getInputGroups(sim);
    }

    @Override
    public java.util.List<com.ext.portlet.model.ModelInputGroup> getChildGroups(
        com.ext.portlet.model.ModelInputGroup group) {
        return _modelInputGroupLocalService.getChildGroups(group);
    }

    @Override
    public java.util.List<com.ext.portlet.model.ModelInputItem> getInputItems(
        com.ext.portlet.model.ModelInputGroup group) {
        return _modelInputGroupLocalService.getInputItems(group);
    }

    @Override
    public com.ext.portlet.model.ModelInputGroup getParent(
        com.ext.portlet.model.ModelInputGroup group) {
        return _modelInputGroupLocalService.getParent(group);
    }

    @Override
    public edu.mit.cci.roma.client.Simulation getModel(
        com.ext.portlet.model.ModelInputGroup group)
        throws com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return _modelInputGroupLocalService.getModel(group);
    }

    @Override
    public edu.mit.cci.roma.client.MetaData getMetaData(
        com.ext.portlet.model.ModelInputGroup group)
        throws com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return _modelInputGroupLocalService.getMetaData(group);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ModelInputGroupLocalService getWrappedModelInputGroupLocalService() {
        return _modelInputGroupLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedModelInputGroupLocalService(
        ModelInputGroupLocalService modelInputGroupLocalService) {
        _modelInputGroupLocalService = modelInputGroupLocalService;
    }

    @Override
    public ModelInputGroupLocalService getWrappedService() {
        return _modelInputGroupLocalService;
    }

    @Override
    public void setWrappedService(
        ModelInputGroupLocalService modelInputGroupLocalService) {
        _modelInputGroupLocalService = modelInputGroupLocalService;
    }
}
