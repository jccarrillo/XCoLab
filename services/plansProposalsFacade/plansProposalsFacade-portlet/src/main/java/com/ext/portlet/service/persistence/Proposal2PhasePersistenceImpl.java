package com.ext.portlet.service.persistence;

import com.ext.portlet.NoSuchProposal2PhaseException;
import com.ext.portlet.model.Proposal2Phase;
import com.ext.portlet.model.impl.Proposal2PhaseImpl;
import com.ext.portlet.model.impl.Proposal2PhaseModelImpl;
import com.ext.portlet.service.persistence.Proposal2PhasePersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the proposal2 phase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Proposal2PhasePersistence
 * @see Proposal2PhaseUtil
 * @generated
 */
public class Proposal2PhasePersistenceImpl extends BasePersistenceImpl<Proposal2Phase>
    implements Proposal2PhasePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link Proposal2PhaseUtil} to access the proposal2 phase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = Proposal2PhaseImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseModelImpl.FINDER_CACHE_ENABLED,
            Proposal2PhaseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseModelImpl.FINDER_CACHE_ENABLED,
            Proposal2PhaseImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSALID =
        new FinderPath(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseModelImpl.FINDER_CACHE_ENABLED,
            Proposal2PhaseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByProposalId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID =
        new FinderPath(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseModelImpl.FINDER_CACHE_ENABLED,
            Proposal2PhaseImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProposalId",
            new String[] { Long.class.getName() },
            Proposal2PhaseModelImpl.PROPOSALID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PROPOSALID = new FinderPath(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProposalId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_PROPOSALID_PROPOSALID_2 = "proposal2Phase.id.proposalId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTESTPHASEID =
        new FinderPath(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseModelImpl.FINDER_CACHE_ENABLED,
            Proposal2PhaseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByContestPhaseId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTESTPHASEID =
        new FinderPath(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseModelImpl.FINDER_CACHE_ENABLED,
            Proposal2PhaseImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContestPhaseId",
            new String[] { Long.class.getName() },
            Proposal2PhaseModelImpl.CONTESTPHASEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONTESTPHASEID = new FinderPath(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContestPhaseId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CONTESTPHASEID_CONTESTPHASEID_2 = "proposal2Phase.id.contestPhaseId = ?";
    private static final String _SQL_SELECT_PROPOSAL2PHASE = "SELECT proposal2Phase FROM Proposal2Phase proposal2Phase";
    private static final String _SQL_SELECT_PROPOSAL2PHASE_WHERE = "SELECT proposal2Phase FROM Proposal2Phase proposal2Phase WHERE ";
    private static final String _SQL_COUNT_PROPOSAL2PHASE = "SELECT COUNT(proposal2Phase) FROM Proposal2Phase proposal2Phase";
    private static final String _SQL_COUNT_PROPOSAL2PHASE_WHERE = "SELECT COUNT(proposal2Phase) FROM Proposal2Phase proposal2Phase WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "proposal2Phase.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Proposal2Phase exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Proposal2Phase exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(Proposal2PhasePersistenceImpl.class);
    private static Proposal2Phase _nullProposal2Phase = new Proposal2PhaseImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Proposal2Phase> toCacheModel() {
                return _nullProposal2PhaseCacheModel;
            }
        };

    private static CacheModel<Proposal2Phase> _nullProposal2PhaseCacheModel = new CacheModel<Proposal2Phase>() {
            @Override
            public Proposal2Phase toEntityModel() {
                return _nullProposal2Phase;
            }
        };

    public Proposal2PhasePersistenceImpl() {
        setModelClass(Proposal2Phase.class);
    }

    /**
     * Returns all the proposal2 phases where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @return the matching proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Proposal2Phase> findByProposalId(long proposalId)
        throws SystemException {
        return findByProposalId(proposalId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the proposal2 phases where proposalId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.Proposal2PhaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param proposalId the proposal ID
     * @param start the lower bound of the range of proposal2 phases
     * @param end the upper bound of the range of proposal2 phases (not inclusive)
     * @return the range of matching proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Proposal2Phase> findByProposalId(long proposalId, int start,
        int end) throws SystemException {
        return findByProposalId(proposalId, start, end, null);
    }

    /**
     * Returns an ordered range of all the proposal2 phases where proposalId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.Proposal2PhaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param proposalId the proposal ID
     * @param start the lower bound of the range of proposal2 phases
     * @param end the upper bound of the range of proposal2 phases (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Proposal2Phase> findByProposalId(long proposalId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID;
            finderArgs = new Object[] { proposalId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSALID;
            finderArgs = new Object[] { proposalId, start, end, orderByComparator };
        }

        List<Proposal2Phase> list = (List<Proposal2Phase>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Proposal2Phase proposal2Phase : list) {
                if ((proposalId != proposal2Phase.getProposalId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PROPOSAL2PHASE_WHERE);

            query.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(Proposal2PhaseModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(proposalId);

                if (!pagination) {
                    list = (List<Proposal2Phase>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Proposal2Phase>(list);
                } else {
                    list = (List<Proposal2Phase>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first proposal2 phase in the ordered set where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposal2 phase
     * @throws com.ext.portlet.NoSuchProposal2PhaseException if a matching proposal2 phase could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase findByProposalId_First(long proposalId,
        OrderByComparator orderByComparator)
        throws NoSuchProposal2PhaseException, SystemException {
        Proposal2Phase proposal2Phase = fetchByProposalId_First(proposalId,
                orderByComparator);

        if (proposal2Phase != null) {
            return proposal2Phase;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("proposalId=");
        msg.append(proposalId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProposal2PhaseException(msg.toString());
    }

    /**
     * Returns the first proposal2 phase in the ordered set where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposal2 phase, or <code>null</code> if a matching proposal2 phase could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase fetchByProposalId_First(long proposalId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Proposal2Phase> list = findByProposalId(proposalId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last proposal2 phase in the ordered set where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposal2 phase
     * @throws com.ext.portlet.NoSuchProposal2PhaseException if a matching proposal2 phase could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase findByProposalId_Last(long proposalId,
        OrderByComparator orderByComparator)
        throws NoSuchProposal2PhaseException, SystemException {
        Proposal2Phase proposal2Phase = fetchByProposalId_Last(proposalId,
                orderByComparator);

        if (proposal2Phase != null) {
            return proposal2Phase;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("proposalId=");
        msg.append(proposalId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProposal2PhaseException(msg.toString());
    }

    /**
     * Returns the last proposal2 phase in the ordered set where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposal2 phase, or <code>null</code> if a matching proposal2 phase could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase fetchByProposalId_Last(long proposalId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByProposalId(proposalId);

        if (count == 0) {
            return null;
        }

        List<Proposal2Phase> list = findByProposalId(proposalId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the proposal2 phases before and after the current proposal2 phase in the ordered set where proposalId = &#63;.
     *
     * @param proposal2PhasePK the primary key of the current proposal2 phase
     * @param proposalId the proposal ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next proposal2 phase
     * @throws com.ext.portlet.NoSuchProposal2PhaseException if a proposal2 phase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase[] findByProposalId_PrevAndNext(
        Proposal2PhasePK proposal2PhasePK, long proposalId,
        OrderByComparator orderByComparator)
        throws NoSuchProposal2PhaseException, SystemException {
        Proposal2Phase proposal2Phase = findByPrimaryKey(proposal2PhasePK);

        Session session = null;

        try {
            session = openSession();

            Proposal2Phase[] array = new Proposal2PhaseImpl[3];

            array[0] = getByProposalId_PrevAndNext(session, proposal2Phase,
                    proposalId, orderByComparator, true);

            array[1] = proposal2Phase;

            array[2] = getByProposalId_PrevAndNext(session, proposal2Phase,
                    proposalId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Proposal2Phase getByProposalId_PrevAndNext(Session session,
        Proposal2Phase proposal2Phase, long proposalId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PROPOSAL2PHASE_WHERE);

        query.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(Proposal2PhaseModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(proposalId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(proposal2Phase);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Proposal2Phase> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the proposal2 phases where proposalId = &#63; from the database.
     *
     * @param proposalId the proposal ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByProposalId(long proposalId) throws SystemException {
        for (Proposal2Phase proposal2Phase : findByProposalId(proposalId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(proposal2Phase);
        }
    }

    /**
     * Returns the number of proposal2 phases where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @return the number of matching proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByProposalId(long proposalId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PROPOSALID;

        Object[] finderArgs = new Object[] { proposalId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PROPOSAL2PHASE_WHERE);

            query.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(proposalId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the proposal2 phases where contestPhaseId = &#63;.
     *
     * @param contestPhaseId the contest phase ID
     * @return the matching proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Proposal2Phase> findByContestPhaseId(long contestPhaseId)
        throws SystemException {
        return findByContestPhaseId(contestPhaseId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the proposal2 phases where contestPhaseId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.Proposal2PhaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param contestPhaseId the contest phase ID
     * @param start the lower bound of the range of proposal2 phases
     * @param end the upper bound of the range of proposal2 phases (not inclusive)
     * @return the range of matching proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Proposal2Phase> findByContestPhaseId(long contestPhaseId,
        int start, int end) throws SystemException {
        return findByContestPhaseId(contestPhaseId, start, end, null);
    }

    /**
     * Returns an ordered range of all the proposal2 phases where contestPhaseId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.Proposal2PhaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param contestPhaseId the contest phase ID
     * @param start the lower bound of the range of proposal2 phases
     * @param end the upper bound of the range of proposal2 phases (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Proposal2Phase> findByContestPhaseId(long contestPhaseId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTESTPHASEID;
            finderArgs = new Object[] { contestPhaseId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTESTPHASEID;
            finderArgs = new Object[] {
                    contestPhaseId,
                    
                    start, end, orderByComparator
                };
        }

        List<Proposal2Phase> list = (List<Proposal2Phase>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Proposal2Phase proposal2Phase : list) {
                if ((contestPhaseId != proposal2Phase.getContestPhaseId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PROPOSAL2PHASE_WHERE);

            query.append(_FINDER_COLUMN_CONTESTPHASEID_CONTESTPHASEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(Proposal2PhaseModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(contestPhaseId);

                if (!pagination) {
                    list = (List<Proposal2Phase>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Proposal2Phase>(list);
                } else {
                    list = (List<Proposal2Phase>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first proposal2 phase in the ordered set where contestPhaseId = &#63;.
     *
     * @param contestPhaseId the contest phase ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposal2 phase
     * @throws com.ext.portlet.NoSuchProposal2PhaseException if a matching proposal2 phase could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase findByContestPhaseId_First(long contestPhaseId,
        OrderByComparator orderByComparator)
        throws NoSuchProposal2PhaseException, SystemException {
        Proposal2Phase proposal2Phase = fetchByContestPhaseId_First(contestPhaseId,
                orderByComparator);

        if (proposal2Phase != null) {
            return proposal2Phase;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("contestPhaseId=");
        msg.append(contestPhaseId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProposal2PhaseException(msg.toString());
    }

    /**
     * Returns the first proposal2 phase in the ordered set where contestPhaseId = &#63;.
     *
     * @param contestPhaseId the contest phase ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposal2 phase, or <code>null</code> if a matching proposal2 phase could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase fetchByContestPhaseId_First(long contestPhaseId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Proposal2Phase> list = findByContestPhaseId(contestPhaseId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last proposal2 phase in the ordered set where contestPhaseId = &#63;.
     *
     * @param contestPhaseId the contest phase ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposal2 phase
     * @throws com.ext.portlet.NoSuchProposal2PhaseException if a matching proposal2 phase could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase findByContestPhaseId_Last(long contestPhaseId,
        OrderByComparator orderByComparator)
        throws NoSuchProposal2PhaseException, SystemException {
        Proposal2Phase proposal2Phase = fetchByContestPhaseId_Last(contestPhaseId,
                orderByComparator);

        if (proposal2Phase != null) {
            return proposal2Phase;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("contestPhaseId=");
        msg.append(contestPhaseId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProposal2PhaseException(msg.toString());
    }

    /**
     * Returns the last proposal2 phase in the ordered set where contestPhaseId = &#63;.
     *
     * @param contestPhaseId the contest phase ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposal2 phase, or <code>null</code> if a matching proposal2 phase could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase fetchByContestPhaseId_Last(long contestPhaseId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByContestPhaseId(contestPhaseId);

        if (count == 0) {
            return null;
        }

        List<Proposal2Phase> list = findByContestPhaseId(contestPhaseId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the proposal2 phases before and after the current proposal2 phase in the ordered set where contestPhaseId = &#63;.
     *
     * @param proposal2PhasePK the primary key of the current proposal2 phase
     * @param contestPhaseId the contest phase ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next proposal2 phase
     * @throws com.ext.portlet.NoSuchProposal2PhaseException if a proposal2 phase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase[] findByContestPhaseId_PrevAndNext(
        Proposal2PhasePK proposal2PhasePK, long contestPhaseId,
        OrderByComparator orderByComparator)
        throws NoSuchProposal2PhaseException, SystemException {
        Proposal2Phase proposal2Phase = findByPrimaryKey(proposal2PhasePK);

        Session session = null;

        try {
            session = openSession();

            Proposal2Phase[] array = new Proposal2PhaseImpl[3];

            array[0] = getByContestPhaseId_PrevAndNext(session, proposal2Phase,
                    contestPhaseId, orderByComparator, true);

            array[1] = proposal2Phase;

            array[2] = getByContestPhaseId_PrevAndNext(session, proposal2Phase,
                    contestPhaseId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Proposal2Phase getByContestPhaseId_PrevAndNext(Session session,
        Proposal2Phase proposal2Phase, long contestPhaseId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PROPOSAL2PHASE_WHERE);

        query.append(_FINDER_COLUMN_CONTESTPHASEID_CONTESTPHASEID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(Proposal2PhaseModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(contestPhaseId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(proposal2Phase);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Proposal2Phase> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the proposal2 phases where contestPhaseId = &#63; from the database.
     *
     * @param contestPhaseId the contest phase ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByContestPhaseId(long contestPhaseId)
        throws SystemException {
        for (Proposal2Phase proposal2Phase : findByContestPhaseId(
                contestPhaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(proposal2Phase);
        }
    }

    /**
     * Returns the number of proposal2 phases where contestPhaseId = &#63;.
     *
     * @param contestPhaseId the contest phase ID
     * @return the number of matching proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByContestPhaseId(long contestPhaseId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTESTPHASEID;

        Object[] finderArgs = new Object[] { contestPhaseId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PROPOSAL2PHASE_WHERE);

            query.append(_FINDER_COLUMN_CONTESTPHASEID_CONTESTPHASEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(contestPhaseId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the proposal2 phase in the entity cache if it is enabled.
     *
     * @param proposal2Phase the proposal2 phase
     */
    @Override
    public void cacheResult(Proposal2Phase proposal2Phase) {
        EntityCacheUtil.putResult(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseImpl.class, proposal2Phase.getPrimaryKey(),
            proposal2Phase);

        proposal2Phase.resetOriginalValues();
    }

    /**
     * Caches the proposal2 phases in the entity cache if it is enabled.
     *
     * @param proposal2Phases the proposal2 phases
     */
    @Override
    public void cacheResult(List<Proposal2Phase> proposal2Phases) {
        for (Proposal2Phase proposal2Phase : proposal2Phases) {
            if (EntityCacheUtil.getResult(
                        Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
                        Proposal2PhaseImpl.class, proposal2Phase.getPrimaryKey()) == null) {
                cacheResult(proposal2Phase);
            } else {
                proposal2Phase.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all proposal2 phases.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(Proposal2PhaseImpl.class.getName());
        }

        EntityCacheUtil.clearCache(Proposal2PhaseImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the proposal2 phase.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Proposal2Phase proposal2Phase) {
        EntityCacheUtil.removeResult(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseImpl.class, proposal2Phase.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Proposal2Phase> proposal2Phases) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Proposal2Phase proposal2Phase : proposal2Phases) {
            EntityCacheUtil.removeResult(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
                Proposal2PhaseImpl.class, proposal2Phase.getPrimaryKey());
        }
    }

    /**
     * Creates a new proposal2 phase with the primary key. Does not add the proposal2 phase to the database.
     *
     * @param proposal2PhasePK the primary key for the new proposal2 phase
     * @return the new proposal2 phase
     */
    @Override
    public Proposal2Phase create(Proposal2PhasePK proposal2PhasePK) {
        Proposal2Phase proposal2Phase = new Proposal2PhaseImpl();

        proposal2Phase.setNew(true);
        proposal2Phase.setPrimaryKey(proposal2PhasePK);

        return proposal2Phase;
    }

    /**
     * Removes the proposal2 phase with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param proposal2PhasePK the primary key of the proposal2 phase
     * @return the proposal2 phase that was removed
     * @throws com.ext.portlet.NoSuchProposal2PhaseException if a proposal2 phase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase remove(Proposal2PhasePK proposal2PhasePK)
        throws NoSuchProposal2PhaseException, SystemException {
        return remove((Serializable) proposal2PhasePK);
    }

    /**
     * Removes the proposal2 phase with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the proposal2 phase
     * @return the proposal2 phase that was removed
     * @throws com.ext.portlet.NoSuchProposal2PhaseException if a proposal2 phase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase remove(Serializable primaryKey)
        throws NoSuchProposal2PhaseException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Proposal2Phase proposal2Phase = (Proposal2Phase) session.get(Proposal2PhaseImpl.class,
                    primaryKey);

            if (proposal2Phase == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchProposal2PhaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(proposal2Phase);
        } catch (NoSuchProposal2PhaseException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Proposal2Phase removeImpl(Proposal2Phase proposal2Phase)
        throws SystemException {
        proposal2Phase = toUnwrappedModel(proposal2Phase);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(proposal2Phase)) {
                proposal2Phase = (Proposal2Phase) session.get(Proposal2PhaseImpl.class,
                        proposal2Phase.getPrimaryKeyObj());
            }

            if (proposal2Phase != null) {
                session.delete(proposal2Phase);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (proposal2Phase != null) {
            clearCache(proposal2Phase);
        }

        return proposal2Phase;
    }

    @Override
    public Proposal2Phase updateImpl(
        com.ext.portlet.model.Proposal2Phase proposal2Phase)
        throws SystemException {
        proposal2Phase = toUnwrappedModel(proposal2Phase);

        boolean isNew = proposal2Phase.isNew();

        Proposal2PhaseModelImpl proposal2PhaseModelImpl = (Proposal2PhaseModelImpl) proposal2Phase;

        Session session = null;

        try {
            session = openSession();

            if (proposal2Phase.isNew()) {
                session.save(proposal2Phase);

                proposal2Phase.setNew(false);
            } else {
                session.merge(proposal2Phase);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !Proposal2PhaseModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((proposal2PhaseModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        proposal2PhaseModelImpl.getOriginalProposalId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSALID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID,
                    args);

                args = new Object[] { proposal2PhaseModelImpl.getProposalId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSALID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID,
                    args);
            }

            if ((proposal2PhaseModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTESTPHASEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        proposal2PhaseModelImpl.getOriginalContestPhaseId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTESTPHASEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTESTPHASEID,
                    args);

                args = new Object[] { proposal2PhaseModelImpl.getContestPhaseId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTESTPHASEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTESTPHASEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
            Proposal2PhaseImpl.class, proposal2Phase.getPrimaryKey(),
            proposal2Phase);

        return proposal2Phase;
    }

    protected Proposal2Phase toUnwrappedModel(Proposal2Phase proposal2Phase) {
        if (proposal2Phase instanceof Proposal2PhaseImpl) {
            return proposal2Phase;
        }

        Proposal2PhaseImpl proposal2PhaseImpl = new Proposal2PhaseImpl();

        proposal2PhaseImpl.setNew(proposal2Phase.isNew());
        proposal2PhaseImpl.setPrimaryKey(proposal2Phase.getPrimaryKey());

        proposal2PhaseImpl.setProposalId(proposal2Phase.getProposalId());
        proposal2PhaseImpl.setContestPhaseId(proposal2Phase.getContestPhaseId());
        proposal2PhaseImpl.setVersionFrom(proposal2Phase.getVersionFrom());
        proposal2PhaseImpl.setVersionTo(proposal2Phase.getVersionTo());
        proposal2PhaseImpl.setSortWeight(proposal2Phase.getSortWeight());
        proposal2PhaseImpl.setAutopromoteCandidate(proposal2Phase.isAutopromoteCandidate());

        return proposal2PhaseImpl;
    }

    /**
     * Returns the proposal2 phase with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the proposal2 phase
     * @return the proposal2 phase
     * @throws com.ext.portlet.NoSuchProposal2PhaseException if a proposal2 phase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase findByPrimaryKey(Serializable primaryKey)
        throws NoSuchProposal2PhaseException, SystemException {
        Proposal2Phase proposal2Phase = fetchByPrimaryKey(primaryKey);

        if (proposal2Phase == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchProposal2PhaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return proposal2Phase;
    }

    /**
     * Returns the proposal2 phase with the primary key or throws a {@link com.ext.portlet.NoSuchProposal2PhaseException} if it could not be found.
     *
     * @param proposal2PhasePK the primary key of the proposal2 phase
     * @return the proposal2 phase
     * @throws com.ext.portlet.NoSuchProposal2PhaseException if a proposal2 phase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase findByPrimaryKey(Proposal2PhasePK proposal2PhasePK)
        throws NoSuchProposal2PhaseException, SystemException {
        return findByPrimaryKey((Serializable) proposal2PhasePK);
    }

    /**
     * Returns the proposal2 phase with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the proposal2 phase
     * @return the proposal2 phase, or <code>null</code> if a proposal2 phase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Proposal2Phase proposal2Phase = (Proposal2Phase) EntityCacheUtil.getResult(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
                Proposal2PhaseImpl.class, primaryKey);

        if (proposal2Phase == _nullProposal2Phase) {
            return null;
        }

        if (proposal2Phase == null) {
            Session session = null;

            try {
                session = openSession();

                proposal2Phase = (Proposal2Phase) session.get(Proposal2PhaseImpl.class,
                        primaryKey);

                if (proposal2Phase != null) {
                    cacheResult(proposal2Phase);
                } else {
                    EntityCacheUtil.putResult(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
                        Proposal2PhaseImpl.class, primaryKey,
                        _nullProposal2Phase);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(Proposal2PhaseModelImpl.ENTITY_CACHE_ENABLED,
                    Proposal2PhaseImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return proposal2Phase;
    }

    /**
     * Returns the proposal2 phase with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param proposal2PhasePK the primary key of the proposal2 phase
     * @return the proposal2 phase, or <code>null</code> if a proposal2 phase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposal2Phase fetchByPrimaryKey(Proposal2PhasePK proposal2PhasePK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) proposal2PhasePK);
    }

    /**
     * Returns all the proposal2 phases.
     *
     * @return the proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Proposal2Phase> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the proposal2 phases.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.Proposal2PhaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of proposal2 phases
     * @param end the upper bound of the range of proposal2 phases (not inclusive)
     * @return the range of proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Proposal2Phase> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the proposal2 phases.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.Proposal2PhaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of proposal2 phases
     * @param end the upper bound of the range of proposal2 phases (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Proposal2Phase> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Proposal2Phase> list = (List<Proposal2Phase>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PROPOSAL2PHASE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PROPOSAL2PHASE;

                if (pagination) {
                    sql = sql.concat(Proposal2PhaseModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Proposal2Phase>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Proposal2Phase>(list);
                } else {
                    list = (List<Proposal2Phase>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the proposal2 phases from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Proposal2Phase proposal2Phase : findAll()) {
            remove(proposal2Phase);
        }
    }

    /**
     * Returns the number of proposal2 phases.
     *
     * @return the number of proposal2 phases
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_PROPOSAL2PHASE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the proposal2 phase persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.ext.portlet.model.Proposal2Phase")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Proposal2Phase>> listenersList = new ArrayList<ModelListener<Proposal2Phase>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Proposal2Phase>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(Proposal2PhaseImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
