package com.ext.portlet.service.persistence;

import com.ext.portlet.model.ProposalRatingType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the proposal rating type service. This utility wraps {@link ProposalRatingTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalRatingTypePersistence
 * @see ProposalRatingTypePersistenceImpl
 * @generated
 */
public class ProposalRatingTypeUtil {
    private static ProposalRatingTypePersistence _persistence;

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
    public static void clearCache(ProposalRatingType proposalRatingType) {
        getPersistence().clearCache(proposalRatingType);
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
    public static List<ProposalRatingType> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ProposalRatingType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ProposalRatingType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ProposalRatingType update(
        ProposalRatingType proposalRatingType) throws SystemException {
        return getPersistence().update(proposalRatingType);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ProposalRatingType update(
        ProposalRatingType proposalRatingType, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(proposalRatingType, serviceContext);
    }

    /**
    * Caches the proposal rating type in the entity cache if it is enabled.
    *
    * @param proposalRatingType the proposal rating type
    */
    public static void cacheResult(
        com.ext.portlet.model.ProposalRatingType proposalRatingType) {
        getPersistence().cacheResult(proposalRatingType);
    }

    /**
    * Caches the proposal rating types in the entity cache if it is enabled.
    *
    * @param proposalRatingTypes the proposal rating types
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.ProposalRatingType> proposalRatingTypes) {
        getPersistence().cacheResult(proposalRatingTypes);
    }

    /**
    * Creates a new proposal rating type with the primary key. Does not add the proposal rating type to the database.
    *
    * @param id the primary key for the new proposal rating type
    * @return the new proposal rating type
    */
    public static com.ext.portlet.model.ProposalRatingType create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the proposal rating type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the proposal rating type
    * @return the proposal rating type that was removed
    * @throws com.ext.portlet.NoSuchProposalRatingTypeException if a proposal rating type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ProposalRatingType remove(long id)
        throws com.ext.portlet.NoSuchProposalRatingTypeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.ext.portlet.model.ProposalRatingType updateImpl(
        com.ext.portlet.model.ProposalRatingType proposalRatingType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(proposalRatingType);
    }

    /**
    * Returns the proposal rating type with the primary key or throws a {@link com.ext.portlet.NoSuchProposalRatingTypeException} if it could not be found.
    *
    * @param id the primary key of the proposal rating type
    * @return the proposal rating type
    * @throws com.ext.portlet.NoSuchProposalRatingTypeException if a proposal rating type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ProposalRatingType findByPrimaryKey(
        long id)
        throws com.ext.portlet.NoSuchProposalRatingTypeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the proposal rating type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the proposal rating type
    * @return the proposal rating type, or <code>null</code> if a proposal rating type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ProposalRatingType fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the proposal rating types.
    *
    * @return the proposal rating types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ProposalRatingType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the proposal rating types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalRatingTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of proposal rating types
    * @param end the upper bound of the range of proposal rating types (not inclusive)
    * @return the range of proposal rating types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ProposalRatingType> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the proposal rating types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalRatingTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of proposal rating types
    * @param end the upper bound of the range of proposal rating types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of proposal rating types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ProposalRatingType> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the proposal rating types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of proposal rating types.
    *
    * @return the number of proposal rating types
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ProposalRatingTypePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ProposalRatingTypePersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    ProposalRatingTypePersistence.class.getName());

            ReferenceRegistry.registerReference(ProposalRatingTypeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ProposalRatingTypePersistence persistence) {
    }
}
