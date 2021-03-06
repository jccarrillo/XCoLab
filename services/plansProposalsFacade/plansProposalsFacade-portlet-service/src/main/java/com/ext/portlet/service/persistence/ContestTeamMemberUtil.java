package com.ext.portlet.service.persistence;

import com.ext.portlet.model.ContestTeamMember;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the contest team member service. This utility wraps {@link ContestTeamMemberPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestTeamMemberPersistence
 * @see ContestTeamMemberPersistenceImpl
 * @generated
 */
public class ContestTeamMemberUtil {
    private static ContestTeamMemberPersistence _persistence;

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
    public static void clearCache(ContestTeamMember contestTeamMember) {
        getPersistence().clearCache(contestTeamMember);
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
    public static List<ContestTeamMember> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ContestTeamMember> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ContestTeamMember> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ContestTeamMember update(ContestTeamMember contestTeamMember)
        throws SystemException {
        return getPersistence().update(contestTeamMember);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ContestTeamMember update(
        ContestTeamMember contestTeamMember, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(contestTeamMember, serviceContext);
    }

    /**
    * Returns all the contest team members where contestId = &#63;.
    *
    * @param contestId the contest ID
    * @return the matching contest team members
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestTeamMember> findByContestId(
        long contestId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByContestId(contestId);
    }

    /**
    * Returns a range of all the contest team members where contestId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ContestTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param contestId the contest ID
    * @param start the lower bound of the range of contest team members
    * @param end the upper bound of the range of contest team members (not inclusive)
    * @return the range of matching contest team members
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestTeamMember> findByContestId(
        long contestId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByContestId(contestId, start, end);
    }

    /**
    * Returns an ordered range of all the contest team members where contestId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ContestTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param contestId the contest ID
    * @param start the lower bound of the range of contest team members
    * @param end the upper bound of the range of contest team members (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contest team members
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestTeamMember> findByContestId(
        long contestId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContestId(contestId, start, end, orderByComparator);
    }

    /**
    * Returns the first contest team member in the ordered set where contestId = &#63;.
    *
    * @param contestId the contest ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contest team member
    * @throws com.ext.portlet.NoSuchContestTeamMemberException if a matching contest team member could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestTeamMember findByContestId_First(
        long contestId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchContestTeamMemberException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContestId_First(contestId, orderByComparator);
    }

    /**
    * Returns the first contest team member in the ordered set where contestId = &#63;.
    *
    * @param contestId the contest ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contest team member, or <code>null</code> if a matching contest team member could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestTeamMember fetchByContestId_First(
        long contestId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContestId_First(contestId, orderByComparator);
    }

    /**
    * Returns the last contest team member in the ordered set where contestId = &#63;.
    *
    * @param contestId the contest ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contest team member
    * @throws com.ext.portlet.NoSuchContestTeamMemberException if a matching contest team member could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestTeamMember findByContestId_Last(
        long contestId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchContestTeamMemberException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContestId_Last(contestId, orderByComparator);
    }

    /**
    * Returns the last contest team member in the ordered set where contestId = &#63;.
    *
    * @param contestId the contest ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contest team member, or <code>null</code> if a matching contest team member could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestTeamMember fetchByContestId_Last(
        long contestId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContestId_Last(contestId, orderByComparator);
    }

    /**
    * Returns the contest team members before and after the current contest team member in the ordered set where contestId = &#63;.
    *
    * @param id the primary key of the current contest team member
    * @param contestId the contest ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contest team member
    * @throws com.ext.portlet.NoSuchContestTeamMemberException if a contest team member with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestTeamMember[] findByContestId_PrevAndNext(
        long id, long contestId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchContestTeamMemberException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContestId_PrevAndNext(id, contestId, orderByComparator);
    }

    /**
    * Removes all the contest team members where contestId = &#63; from the database.
    *
    * @param contestId the contest ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByContestId(long contestId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByContestId(contestId);
    }

    /**
    * Returns the number of contest team members where contestId = &#63;.
    *
    * @param contestId the contest ID
    * @return the number of matching contest team members
    * @throws SystemException if a system exception occurred
    */
    public static int countByContestId(long contestId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByContestId(contestId);
    }

    /**
    * Caches the contest team member in the entity cache if it is enabled.
    *
    * @param contestTeamMember the contest team member
    */
    public static void cacheResult(
        com.ext.portlet.model.ContestTeamMember contestTeamMember) {
        getPersistence().cacheResult(contestTeamMember);
    }

    /**
    * Caches the contest team members in the entity cache if it is enabled.
    *
    * @param contestTeamMembers the contest team members
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.ContestTeamMember> contestTeamMembers) {
        getPersistence().cacheResult(contestTeamMembers);
    }

    /**
    * Creates a new contest team member with the primary key. Does not add the contest team member to the database.
    *
    * @param id the primary key for the new contest team member
    * @return the new contest team member
    */
    public static com.ext.portlet.model.ContestTeamMember create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the contest team member with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the contest team member
    * @return the contest team member that was removed
    * @throws com.ext.portlet.NoSuchContestTeamMemberException if a contest team member with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestTeamMember remove(long id)
        throws com.ext.portlet.NoSuchContestTeamMemberException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.ext.portlet.model.ContestTeamMember updateImpl(
        com.ext.portlet.model.ContestTeamMember contestTeamMember)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(contestTeamMember);
    }

    /**
    * Returns the contest team member with the primary key or throws a {@link com.ext.portlet.NoSuchContestTeamMemberException} if it could not be found.
    *
    * @param id the primary key of the contest team member
    * @return the contest team member
    * @throws com.ext.portlet.NoSuchContestTeamMemberException if a contest team member with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestTeamMember findByPrimaryKey(
        long id)
        throws com.ext.portlet.NoSuchContestTeamMemberException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the contest team member with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the contest team member
    * @return the contest team member, or <code>null</code> if a contest team member with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestTeamMember fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the contest team members.
    *
    * @return the contest team members
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestTeamMember> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the contest team members.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ContestTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contest team members
    * @param end the upper bound of the range of contest team members (not inclusive)
    * @return the range of contest team members
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestTeamMember> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the contest team members.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ContestTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contest team members
    * @param end the upper bound of the range of contest team members (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of contest team members
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestTeamMember> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the contest team members from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of contest team members.
    *
    * @return the number of contest team members
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ContestTeamMemberPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ContestTeamMemberPersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    ContestTeamMemberPersistence.class.getName());

            ReferenceRegistry.registerReference(ContestTeamMemberUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ContestTeamMemberPersistence persistence) {
    }
}
