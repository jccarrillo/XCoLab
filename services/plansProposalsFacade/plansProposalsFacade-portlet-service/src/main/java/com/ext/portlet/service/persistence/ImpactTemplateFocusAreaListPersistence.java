package com.ext.portlet.service.persistence;

import com.ext.portlet.model.ImpactTemplateFocusAreaList;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the impact template focus area list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImpactTemplateFocusAreaListPersistenceImpl
 * @see ImpactTemplateFocusAreaListUtil
 * @generated
 */
public interface ImpactTemplateFocusAreaListPersistence extends BasePersistence<ImpactTemplateFocusAreaList> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ImpactTemplateFocusAreaListUtil} to access the impact template focus area list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the impact template focus area list in the entity cache if it is enabled.
    *
    * @param impactTemplateFocusAreaList the impact template focus area list
    */
    public void cacheResult(
        com.ext.portlet.model.ImpactTemplateFocusAreaList impactTemplateFocusAreaList);

    /**
    * Caches the impact template focus area lists in the entity cache if it is enabled.
    *
    * @param impactTemplateFocusAreaLists the impact template focus area lists
    */
    public void cacheResult(
        java.util.List<com.ext.portlet.model.ImpactTemplateFocusAreaList> impactTemplateFocusAreaLists);

    /**
    * Creates a new impact template focus area list with the primary key. Does not add the impact template focus area list to the database.
    *
    * @param focusAreaListId the primary key for the new impact template focus area list
    * @return the new impact template focus area list
    */
    public com.ext.portlet.model.ImpactTemplateFocusAreaList create(
        long focusAreaListId);

    /**
    * Removes the impact template focus area list with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param focusAreaListId the primary key of the impact template focus area list
    * @return the impact template focus area list that was removed
    * @throws com.ext.portlet.NoSuchImpactTemplateFocusAreaListException if a impact template focus area list with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ImpactTemplateFocusAreaList remove(
        long focusAreaListId)
        throws com.ext.portlet.NoSuchImpactTemplateFocusAreaListException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.ext.portlet.model.ImpactTemplateFocusAreaList updateImpl(
        com.ext.portlet.model.ImpactTemplateFocusAreaList impactTemplateFocusAreaList)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the impact template focus area list with the primary key or throws a {@link com.ext.portlet.NoSuchImpactTemplateFocusAreaListException} if it could not be found.
    *
    * @param focusAreaListId the primary key of the impact template focus area list
    * @return the impact template focus area list
    * @throws com.ext.portlet.NoSuchImpactTemplateFocusAreaListException if a impact template focus area list with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ImpactTemplateFocusAreaList findByPrimaryKey(
        long focusAreaListId)
        throws com.ext.portlet.NoSuchImpactTemplateFocusAreaListException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the impact template focus area list with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param focusAreaListId the primary key of the impact template focus area list
    * @return the impact template focus area list, or <code>null</code> if a impact template focus area list with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ImpactTemplateFocusAreaList fetchByPrimaryKey(
        long focusAreaListId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the impact template focus area lists.
    *
    * @return the impact template focus area lists
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ImpactTemplateFocusAreaList> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the impact template focus area lists.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ImpactTemplateFocusAreaListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of impact template focus area lists
    * @param end the upper bound of the range of impact template focus area lists (not inclusive)
    * @return the range of impact template focus area lists
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ImpactTemplateFocusAreaList> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the impact template focus area lists.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ImpactTemplateFocusAreaListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of impact template focus area lists
    * @param end the upper bound of the range of impact template focus area lists (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of impact template focus area lists
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ImpactTemplateFocusAreaList> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the impact template focus area lists from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of impact template focus area lists.
    *
    * @return the number of impact template focus area lists
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
