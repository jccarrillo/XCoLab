package com.ext.portlet.service.persistence;

import com.ext.portlet.model.ModelOutputChartOrder;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the model output chart order service. This utility wraps {@link ModelOutputChartOrderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModelOutputChartOrderPersistence
 * @see ModelOutputChartOrderPersistenceImpl
 * @generated
 */
public class ModelOutputChartOrderUtil {
    private static ModelOutputChartOrderPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(ModelOutputChartOrder modelOutputChartOrder) {
        getPersistence().clearCache(modelOutputChartOrder);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<ModelOutputChartOrder> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ModelOutputChartOrder> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ModelOutputChartOrder> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ModelOutputChartOrder update(
        ModelOutputChartOrder modelOutputChartOrder) throws SystemException {
        return getPersistence().update(modelOutputChartOrder);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ModelOutputChartOrder update(
        ModelOutputChartOrder modelOutputChartOrder,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(modelOutputChartOrder, serviceContext);
    }

    /**
    * Returns the model output chart order where modelId = &#63; and modelOutputLabel = &#63; or throws a {@link com.ext.portlet.NoSuchModelOutputChartOrderException} if it could not be found.
    *
    * @param modelId the model ID
    * @param modelOutputLabel the model output label
    * @return the matching model output chart order
    * @throws com.ext.portlet.NoSuchModelOutputChartOrderException if a matching model output chart order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ModelOutputChartOrder findByModelIdAndLabel(
        long modelId, java.lang.String modelOutputLabel)
        throws com.ext.portlet.NoSuchModelOutputChartOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByModelIdAndLabel(modelId, modelOutputLabel);
    }

    /**
    * Returns the model output chart order where modelId = &#63; and modelOutputLabel = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param modelId the model ID
    * @param modelOutputLabel the model output label
    * @return the matching model output chart order, or <code>null</code> if a matching model output chart order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ModelOutputChartOrder fetchByModelIdAndLabel(
        long modelId, java.lang.String modelOutputLabel)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByModelIdAndLabel(modelId, modelOutputLabel);
    }

    /**
    * Returns the model output chart order where modelId = &#63; and modelOutputLabel = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param modelId the model ID
    * @param modelOutputLabel the model output label
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching model output chart order, or <code>null</code> if a matching model output chart order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ModelOutputChartOrder fetchByModelIdAndLabel(
        long modelId, java.lang.String modelOutputLabel,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByModelIdAndLabel(modelId, modelOutputLabel,
            retrieveFromCache);
    }

    /**
    * Removes the model output chart order where modelId = &#63; and modelOutputLabel = &#63; from the database.
    *
    * @param modelId the model ID
    * @param modelOutputLabel the model output label
    * @return the model output chart order that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ModelOutputChartOrder removeByModelIdAndLabel(
        long modelId, java.lang.String modelOutputLabel)
        throws com.ext.portlet.NoSuchModelOutputChartOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .removeByModelIdAndLabel(modelId, modelOutputLabel);
    }

    /**
    * Returns the number of model output chart orders where modelId = &#63; and modelOutputLabel = &#63;.
    *
    * @param modelId the model ID
    * @param modelOutputLabel the model output label
    * @return the number of matching model output chart orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByModelIdAndLabel(long modelId,
        java.lang.String modelOutputLabel)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByModelIdAndLabel(modelId, modelOutputLabel);
    }

    /**
    * Caches the model output chart order in the entity cache if it is enabled.
    *
    * @param modelOutputChartOrder the model output chart order
    */
    public static void cacheResult(
        com.ext.portlet.model.ModelOutputChartOrder modelOutputChartOrder) {
        getPersistence().cacheResult(modelOutputChartOrder);
    }

    /**
    * Caches the model output chart orders in the entity cache if it is enabled.
    *
    * @param modelOutputChartOrders the model output chart orders
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.ModelOutputChartOrder> modelOutputChartOrders) {
        getPersistence().cacheResult(modelOutputChartOrders);
    }

    /**
    * Creates a new model output chart order with the primary key. Does not add the model output chart order to the database.
    *
    * @param modelOutputChartOrderPK the primary key for the new model output chart order
    * @return the new model output chart order
    */
    public static com.ext.portlet.model.ModelOutputChartOrder create(
        long modelOutputChartOrderPK) {
        return getPersistence().create(modelOutputChartOrderPK);
    }

    /**
    * Removes the model output chart order with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param modelOutputChartOrderPK the primary key of the model output chart order
    * @return the model output chart order that was removed
    * @throws com.ext.portlet.NoSuchModelOutputChartOrderException if a model output chart order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ModelOutputChartOrder remove(
        long modelOutputChartOrderPK)
        throws com.ext.portlet.NoSuchModelOutputChartOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(modelOutputChartOrderPK);
    }

    public static com.ext.portlet.model.ModelOutputChartOrder updateImpl(
        com.ext.portlet.model.ModelOutputChartOrder modelOutputChartOrder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(modelOutputChartOrder);
    }

    /**
    * Returns the model output chart order with the primary key or throws a {@link com.ext.portlet.NoSuchModelOutputChartOrderException} if it could not be found.
    *
    * @param modelOutputChartOrderPK the primary key of the model output chart order
    * @return the model output chart order
    * @throws com.ext.portlet.NoSuchModelOutputChartOrderException if a model output chart order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ModelOutputChartOrder findByPrimaryKey(
        long modelOutputChartOrderPK)
        throws com.ext.portlet.NoSuchModelOutputChartOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(modelOutputChartOrderPK);
    }

    /**
    * Returns the model output chart order with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param modelOutputChartOrderPK the primary key of the model output chart order
    * @return the model output chart order, or <code>null</code> if a model output chart order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ModelOutputChartOrder fetchByPrimaryKey(
        long modelOutputChartOrderPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(modelOutputChartOrderPK);
    }

    /**
    * Returns all the model output chart orders.
    *
    * @return the model output chart orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ModelOutputChartOrder> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the model output chart orders.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelOutputChartOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of model output chart orders
    * @param end the upper bound of the range of model output chart orders (not inclusive)
    * @return the range of model output chart orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ModelOutputChartOrder> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the model output chart orders.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelOutputChartOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of model output chart orders
    * @param end the upper bound of the range of model output chart orders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of model output chart orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ModelOutputChartOrder> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the model output chart orders from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of model output chart orders.
    *
    * @return the number of model output chart orders
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ModelOutputChartOrderPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ModelOutputChartOrderPersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    ModelOutputChartOrderPersistence.class.getName());

            ReferenceRegistry.registerReference(ModelOutputChartOrderUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ModelOutputChartOrderPersistence persistence) {
    }
}
