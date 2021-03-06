package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MessagingIgnoredRecipientsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MessagingIgnoredRecipientsLocalService
 * @generated
 */
public class MessagingIgnoredRecipientsLocalServiceWrapper
    implements MessagingIgnoredRecipientsLocalService,
        ServiceWrapper<MessagingIgnoredRecipientsLocalService> {
    private MessagingIgnoredRecipientsLocalService _messagingIgnoredRecipientsLocalService;

    public MessagingIgnoredRecipientsLocalServiceWrapper(
        MessagingIgnoredRecipientsLocalService messagingIgnoredRecipientsLocalService) {
        _messagingIgnoredRecipientsLocalService = messagingIgnoredRecipientsLocalService;
    }

    /**
    * Adds the messaging ignored recipients to the database. Also notifies the appropriate model listeners.
    *
    * @param messagingIgnoredRecipients the messaging ignored recipients
    * @return the messaging ignored recipients that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.MessagingIgnoredRecipients addMessagingIgnoredRecipients(
        com.ext.portlet.model.MessagingIgnoredRecipients messagingIgnoredRecipients)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _messagingIgnoredRecipientsLocalService.addMessagingIgnoredRecipients(messagingIgnoredRecipients);
    }

    /**
    * Creates a new messaging ignored recipients with the primary key. Does not add the messaging ignored recipients to the database.
    *
    * @param ignoredRecipientId the primary key for the new messaging ignored recipients
    * @return the new messaging ignored recipients
    */
    @Override
    public com.ext.portlet.model.MessagingIgnoredRecipients createMessagingIgnoredRecipients(
        long ignoredRecipientId) {
        return _messagingIgnoredRecipientsLocalService.createMessagingIgnoredRecipients(ignoredRecipientId);
    }

    /**
    * Deletes the messaging ignored recipients with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ignoredRecipientId the primary key of the messaging ignored recipients
    * @return the messaging ignored recipients that was removed
    * @throws PortalException if a messaging ignored recipients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.MessagingIgnoredRecipients deleteMessagingIgnoredRecipients(
        long ignoredRecipientId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _messagingIgnoredRecipientsLocalService.deleteMessagingIgnoredRecipients(ignoredRecipientId);
    }

    /**
    * Deletes the messaging ignored recipients from the database. Also notifies the appropriate model listeners.
    *
    * @param messagingIgnoredRecipients the messaging ignored recipients
    * @return the messaging ignored recipients that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.MessagingIgnoredRecipients deleteMessagingIgnoredRecipients(
        com.ext.portlet.model.MessagingIgnoredRecipients messagingIgnoredRecipients)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _messagingIgnoredRecipientsLocalService.deleteMessagingIgnoredRecipients(messagingIgnoredRecipients);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _messagingIgnoredRecipientsLocalService.dynamicQuery();
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
        return _messagingIgnoredRecipientsLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.MessagingIgnoredRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _messagingIgnoredRecipientsLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.MessagingIgnoredRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _messagingIgnoredRecipientsLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _messagingIgnoredRecipientsLocalService.dynamicQueryCount(dynamicQuery);
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
        return _messagingIgnoredRecipientsLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.ext.portlet.model.MessagingIgnoredRecipients fetchMessagingIgnoredRecipients(
        long ignoredRecipientId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _messagingIgnoredRecipientsLocalService.fetchMessagingIgnoredRecipients(ignoredRecipientId);
    }

    /**
    * Returns the messaging ignored recipients with the primary key.
    *
    * @param ignoredRecipientId the primary key of the messaging ignored recipients
    * @return the messaging ignored recipients
    * @throws PortalException if a messaging ignored recipients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.MessagingIgnoredRecipients getMessagingIgnoredRecipients(
        long ignoredRecipientId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _messagingIgnoredRecipientsLocalService.getMessagingIgnoredRecipients(ignoredRecipientId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _messagingIgnoredRecipientsLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the messaging ignored recipientses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.MessagingIgnoredRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of messaging ignored recipientses
    * @param end the upper bound of the range of messaging ignored recipientses (not inclusive)
    * @return the range of messaging ignored recipientses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.ext.portlet.model.MessagingIgnoredRecipients> getMessagingIgnoredRecipientses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _messagingIgnoredRecipientsLocalService.getMessagingIgnoredRecipientses(start,
            end);
    }

    /**
    * Returns the number of messaging ignored recipientses.
    *
    * @return the number of messaging ignored recipientses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getMessagingIgnoredRecipientsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _messagingIgnoredRecipientsLocalService.getMessagingIgnoredRecipientsesCount();
    }

    /**
    * Updates the messaging ignored recipients in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param messagingIgnoredRecipients the messaging ignored recipients
    * @return the messaging ignored recipients that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.MessagingIgnoredRecipients updateMessagingIgnoredRecipients(
        com.ext.portlet.model.MessagingIgnoredRecipients messagingIgnoredRecipients)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _messagingIgnoredRecipientsLocalService.updateMessagingIgnoredRecipients(messagingIgnoredRecipients);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _messagingIgnoredRecipientsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _messagingIgnoredRecipientsLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _messagingIgnoredRecipientsLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.ext.portlet.model.MessagingIgnoredRecipients findByUserId(
        java.lang.Long userId)
        throws com.ext.portlet.NoSuchMessagingIgnoredRecipientsException,
            com.liferay.portal.kernel.exception.SystemException {
        return _messagingIgnoredRecipientsLocalService.findByUserId(userId);
    }

    @Override
    public com.ext.portlet.model.MessagingIgnoredRecipients findByEmail(
        java.lang.String email)
        throws com.ext.portlet.NoSuchMessagingIgnoredRecipientsException,
            com.liferay.portal.kernel.exception.SystemException {
        return _messagingIgnoredRecipientsLocalService.findByEmail(email);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MessagingIgnoredRecipientsLocalService getWrappedMessagingIgnoredRecipientsLocalService() {
        return _messagingIgnoredRecipientsLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMessagingIgnoredRecipientsLocalService(
        MessagingIgnoredRecipientsLocalService messagingIgnoredRecipientsLocalService) {
        _messagingIgnoredRecipientsLocalService = messagingIgnoredRecipientsLocalService;
    }

    @Override
    public MessagingIgnoredRecipientsLocalService getWrappedService() {
        return _messagingIgnoredRecipientsLocalService;
    }

    @Override
    public void setWrappedService(
        MessagingIgnoredRecipientsLocalService messagingIgnoredRecipientsLocalService) {
        _messagingIgnoredRecipientsLocalService = messagingIgnoredRecipientsLocalService;
    }
}
