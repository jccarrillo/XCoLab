package com.ext.portlet.service.persistence;

import com.ext.portlet.NoSuchModelInputItemException;
import com.ext.portlet.model.ModelInputItem;
import com.ext.portlet.model.impl.ModelInputItemImpl;
import com.ext.portlet.model.impl.ModelInputItemModelImpl;
import com.ext.portlet.service.persistence.ModelInputItemPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the model input item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModelInputItemPersistence
 * @see ModelInputItemUtil
 * @generated
 */
public class ModelInputItemPersistenceImpl extends BasePersistenceImpl<ModelInputItem>
    implements ModelInputItemPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ModelInputItemUtil} to access the model input item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ModelInputItemImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED,
            ModelInputItemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED,
            ModelInputItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MODELGROUPID =
        new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED,
            ModelInputItemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByModelGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODELGROUPID =
        new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED,
            ModelInputItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModelGroupId",
            new String[] { Long.class.getName() },
            ModelInputItemModelImpl.MODELGROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MODELGROUPID = new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModelGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_MODELGROUPID_MODELGROUPID_2 = "modelInputItem.modelGroupId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_MODELINPUTID = new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED,
            ModelInputItemImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByModelInputId", new String[] { Long.class.getName() },
            ModelInputItemModelImpl.MODELINPUTITEMID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MODELINPUTID = new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModelInputId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_MODELINPUTID_MODELINPUTITEMID_2 = "modelInputItem.modelInputItemID = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MODELID = new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED,
            ModelInputItemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByModelId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODELID =
        new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED,
            ModelInputItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModelId",
            new String[] { Long.class.getName() },
            ModelInputItemModelImpl.MODELID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MODELID = new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModelId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_MODELID_MODELID_2 = "modelInputItem.modelId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID = new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED,
            ModelInputItemImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByModelIdModelInputId",
            new String[] { Long.class.getName(), Long.class.getName() },
            ModelInputItemModelImpl.MODELID_COLUMN_BITMASK |
            ModelInputItemModelImpl.MODELINPUTITEMID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MODELIDMODELINPUTID = new FinderPath(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByModelIdModelInputId",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_MODELIDMODELINPUTID_MODELID_2 = "modelInputItem.modelId = ? AND ";
    private static final String _FINDER_COLUMN_MODELIDMODELINPUTID_MODELINPUTITEMID_2 =
        "modelInputItem.modelInputItemID = ?";
    private static final String _SQL_SELECT_MODELINPUTITEM = "SELECT modelInputItem FROM ModelInputItem modelInputItem";
    private static final String _SQL_SELECT_MODELINPUTITEM_WHERE = "SELECT modelInputItem FROM ModelInputItem modelInputItem WHERE ";
    private static final String _SQL_COUNT_MODELINPUTITEM = "SELECT COUNT(modelInputItem) FROM ModelInputItem modelInputItem";
    private static final String _SQL_COUNT_MODELINPUTITEM_WHERE = "SELECT COUNT(modelInputItem) FROM ModelInputItem modelInputItem WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "modelInputItem.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ModelInputItem exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ModelInputItem exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ModelInputItemPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "type"
            });
    private static ModelInputItem _nullModelInputItem = new ModelInputItemImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ModelInputItem> toCacheModel() {
                return _nullModelInputItemCacheModel;
            }
        };

    private static CacheModel<ModelInputItem> _nullModelInputItemCacheModel = new CacheModel<ModelInputItem>() {
            @Override
            public ModelInputItem toEntityModel() {
                return _nullModelInputItem;
            }
        };

    public ModelInputItemPersistenceImpl() {
        setModelClass(ModelInputItem.class);
    }

    /**
     * Returns all the model input items where modelGroupId = &#63;.
     *
     * @param modelGroupId the model group ID
     * @return the matching model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelInputItem> findByModelGroupId(long modelGroupId)
        throws SystemException {
        return findByModelGroupId(modelGroupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the model input items where modelGroupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelInputItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param modelGroupId the model group ID
     * @param start the lower bound of the range of model input items
     * @param end the upper bound of the range of model input items (not inclusive)
     * @return the range of matching model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelInputItem> findByModelGroupId(long modelGroupId,
        int start, int end) throws SystemException {
        return findByModelGroupId(modelGroupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the model input items where modelGroupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelInputItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param modelGroupId the model group ID
     * @param start the lower bound of the range of model input items
     * @param end the upper bound of the range of model input items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelInputItem> findByModelGroupId(long modelGroupId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODELGROUPID;
            finderArgs = new Object[] { modelGroupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MODELGROUPID;
            finderArgs = new Object[] {
                    modelGroupId,
                    
                    start, end, orderByComparator
                };
        }

        List<ModelInputItem> list = (List<ModelInputItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ModelInputItem modelInputItem : list) {
                if ((modelGroupId != modelInputItem.getModelGroupId())) {
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

            query.append(_SQL_SELECT_MODELINPUTITEM_WHERE);

            query.append(_FINDER_COLUMN_MODELGROUPID_MODELGROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ModelInputItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(modelGroupId);

                if (!pagination) {
                    list = (List<ModelInputItem>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ModelInputItem>(list);
                } else {
                    list = (List<ModelInputItem>) QueryUtil.list(q,
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
     * Returns the first model input item in the ordered set where modelGroupId = &#63;.
     *
     * @param modelGroupId the model group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching model input item
     * @throws com.ext.portlet.NoSuchModelInputItemException if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem findByModelGroupId_First(long modelGroupId,
        OrderByComparator orderByComparator)
        throws NoSuchModelInputItemException, SystemException {
        ModelInputItem modelInputItem = fetchByModelGroupId_First(modelGroupId,
                orderByComparator);

        if (modelInputItem != null) {
            return modelInputItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modelGroupId=");
        msg.append(modelGroupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchModelInputItemException(msg.toString());
    }

    /**
     * Returns the first model input item in the ordered set where modelGroupId = &#63;.
     *
     * @param modelGroupId the model group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching model input item, or <code>null</code> if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem fetchByModelGroupId_First(long modelGroupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ModelInputItem> list = findByModelGroupId(modelGroupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last model input item in the ordered set where modelGroupId = &#63;.
     *
     * @param modelGroupId the model group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching model input item
     * @throws com.ext.portlet.NoSuchModelInputItemException if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem findByModelGroupId_Last(long modelGroupId,
        OrderByComparator orderByComparator)
        throws NoSuchModelInputItemException, SystemException {
        ModelInputItem modelInputItem = fetchByModelGroupId_Last(modelGroupId,
                orderByComparator);

        if (modelInputItem != null) {
            return modelInputItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modelGroupId=");
        msg.append(modelGroupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchModelInputItemException(msg.toString());
    }

    /**
     * Returns the last model input item in the ordered set where modelGroupId = &#63;.
     *
     * @param modelGroupId the model group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching model input item, or <code>null</code> if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem fetchByModelGroupId_Last(long modelGroupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByModelGroupId(modelGroupId);

        if (count == 0) {
            return null;
        }

        List<ModelInputItem> list = findByModelGroupId(modelGroupId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the model input items before and after the current model input item in the ordered set where modelGroupId = &#63;.
     *
     * @param modelInputItemPK the primary key of the current model input item
     * @param modelGroupId the model group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next model input item
     * @throws com.ext.portlet.NoSuchModelInputItemException if a model input item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem[] findByModelGroupId_PrevAndNext(
        long modelInputItemPK, long modelGroupId,
        OrderByComparator orderByComparator)
        throws NoSuchModelInputItemException, SystemException {
        ModelInputItem modelInputItem = findByPrimaryKey(modelInputItemPK);

        Session session = null;

        try {
            session = openSession();

            ModelInputItem[] array = new ModelInputItemImpl[3];

            array[0] = getByModelGroupId_PrevAndNext(session, modelInputItem,
                    modelGroupId, orderByComparator, true);

            array[1] = modelInputItem;

            array[2] = getByModelGroupId_PrevAndNext(session, modelInputItem,
                    modelGroupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ModelInputItem getByModelGroupId_PrevAndNext(Session session,
        ModelInputItem modelInputItem, long modelGroupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MODELINPUTITEM_WHERE);

        query.append(_FINDER_COLUMN_MODELGROUPID_MODELGROUPID_2);

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
            query.append(ModelInputItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(modelGroupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(modelInputItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ModelInputItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the model input items where modelGroupId = &#63; from the database.
     *
     * @param modelGroupId the model group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByModelGroupId(long modelGroupId)
        throws SystemException {
        for (ModelInputItem modelInputItem : findByModelGroupId(modelGroupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(modelInputItem);
        }
    }

    /**
     * Returns the number of model input items where modelGroupId = &#63;.
     *
     * @param modelGroupId the model group ID
     * @return the number of matching model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByModelGroupId(long modelGroupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_MODELGROUPID;

        Object[] finderArgs = new Object[] { modelGroupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MODELINPUTITEM_WHERE);

            query.append(_FINDER_COLUMN_MODELGROUPID_MODELGROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(modelGroupId);

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
     * Returns the model input item where modelInputItemID = &#63; or throws a {@link com.ext.portlet.NoSuchModelInputItemException} if it could not be found.
     *
     * @param modelInputItemID the model input item i d
     * @return the matching model input item
     * @throws com.ext.portlet.NoSuchModelInputItemException if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem findByModelInputId(long modelInputItemID)
        throws NoSuchModelInputItemException, SystemException {
        ModelInputItem modelInputItem = fetchByModelInputId(modelInputItemID);

        if (modelInputItem == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("modelInputItemID=");
            msg.append(modelInputItemID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchModelInputItemException(msg.toString());
        }

        return modelInputItem;
    }

    /**
     * Returns the model input item where modelInputItemID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param modelInputItemID the model input item i d
     * @return the matching model input item, or <code>null</code> if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem fetchByModelInputId(long modelInputItemID)
        throws SystemException {
        return fetchByModelInputId(modelInputItemID, true);
    }

    /**
     * Returns the model input item where modelInputItemID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param modelInputItemID the model input item i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching model input item, or <code>null</code> if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem fetchByModelInputId(long modelInputItemID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { modelInputItemID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MODELINPUTID,
                    finderArgs, this);
        }

        if (result instanceof ModelInputItem) {
            ModelInputItem modelInputItem = (ModelInputItem) result;

            if ((modelInputItemID != modelInputItem.getModelInputItemID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_MODELINPUTITEM_WHERE);

            query.append(_FINDER_COLUMN_MODELINPUTID_MODELINPUTITEMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(modelInputItemID);

                List<ModelInputItem> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELINPUTID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "ModelInputItemPersistenceImpl.fetchByModelInputId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    ModelInputItem modelInputItem = list.get(0);

                    result = modelInputItem;

                    cacheResult(modelInputItem);

                    if ((modelInputItem.getModelInputItemID() != modelInputItemID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELINPUTID,
                            finderArgs, modelInputItem);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODELINPUTID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ModelInputItem) result;
        }
    }

    /**
     * Removes the model input item where modelInputItemID = &#63; from the database.
     *
     * @param modelInputItemID the model input item i d
     * @return the model input item that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem removeByModelInputId(long modelInputItemID)
        throws NoSuchModelInputItemException, SystemException {
        ModelInputItem modelInputItem = findByModelInputId(modelInputItemID);

        return remove(modelInputItem);
    }

    /**
     * Returns the number of model input items where modelInputItemID = &#63;.
     *
     * @param modelInputItemID the model input item i d
     * @return the number of matching model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByModelInputId(long modelInputItemID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_MODELINPUTID;

        Object[] finderArgs = new Object[] { modelInputItemID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MODELINPUTITEM_WHERE);

            query.append(_FINDER_COLUMN_MODELINPUTID_MODELINPUTITEMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(modelInputItemID);

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
     * Returns all the model input items where modelId = &#63;.
     *
     * @param modelId the model ID
     * @return the matching model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelInputItem> findByModelId(long modelId)
        throws SystemException {
        return findByModelId(modelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the model input items where modelId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelInputItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param modelId the model ID
     * @param start the lower bound of the range of model input items
     * @param end the upper bound of the range of model input items (not inclusive)
     * @return the range of matching model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelInputItem> findByModelId(long modelId, int start, int end)
        throws SystemException {
        return findByModelId(modelId, start, end, null);
    }

    /**
     * Returns an ordered range of all the model input items where modelId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelInputItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param modelId the model ID
     * @param start the lower bound of the range of model input items
     * @param end the upper bound of the range of model input items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelInputItem> findByModelId(long modelId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODELID;
            finderArgs = new Object[] { modelId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MODELID;
            finderArgs = new Object[] { modelId, start, end, orderByComparator };
        }

        List<ModelInputItem> list = (List<ModelInputItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ModelInputItem modelInputItem : list) {
                if ((modelId != modelInputItem.getModelId())) {
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

            query.append(_SQL_SELECT_MODELINPUTITEM_WHERE);

            query.append(_FINDER_COLUMN_MODELID_MODELID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ModelInputItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(modelId);

                if (!pagination) {
                    list = (List<ModelInputItem>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ModelInputItem>(list);
                } else {
                    list = (List<ModelInputItem>) QueryUtil.list(q,
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
     * Returns the first model input item in the ordered set where modelId = &#63;.
     *
     * @param modelId the model ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching model input item
     * @throws com.ext.portlet.NoSuchModelInputItemException if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem findByModelId_First(long modelId,
        OrderByComparator orderByComparator)
        throws NoSuchModelInputItemException, SystemException {
        ModelInputItem modelInputItem = fetchByModelId_First(modelId,
                orderByComparator);

        if (modelInputItem != null) {
            return modelInputItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modelId=");
        msg.append(modelId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchModelInputItemException(msg.toString());
    }

    /**
     * Returns the first model input item in the ordered set where modelId = &#63;.
     *
     * @param modelId the model ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching model input item, or <code>null</code> if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem fetchByModelId_First(long modelId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ModelInputItem> list = findByModelId(modelId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last model input item in the ordered set where modelId = &#63;.
     *
     * @param modelId the model ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching model input item
     * @throws com.ext.portlet.NoSuchModelInputItemException if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem findByModelId_Last(long modelId,
        OrderByComparator orderByComparator)
        throws NoSuchModelInputItemException, SystemException {
        ModelInputItem modelInputItem = fetchByModelId_Last(modelId,
                orderByComparator);

        if (modelInputItem != null) {
            return modelInputItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modelId=");
        msg.append(modelId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchModelInputItemException(msg.toString());
    }

    /**
     * Returns the last model input item in the ordered set where modelId = &#63;.
     *
     * @param modelId the model ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching model input item, or <code>null</code> if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem fetchByModelId_Last(long modelId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByModelId(modelId);

        if (count == 0) {
            return null;
        }

        List<ModelInputItem> list = findByModelId(modelId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the model input items before and after the current model input item in the ordered set where modelId = &#63;.
     *
     * @param modelInputItemPK the primary key of the current model input item
     * @param modelId the model ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next model input item
     * @throws com.ext.portlet.NoSuchModelInputItemException if a model input item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem[] findByModelId_PrevAndNext(long modelInputItemPK,
        long modelId, OrderByComparator orderByComparator)
        throws NoSuchModelInputItemException, SystemException {
        ModelInputItem modelInputItem = findByPrimaryKey(modelInputItemPK);

        Session session = null;

        try {
            session = openSession();

            ModelInputItem[] array = new ModelInputItemImpl[3];

            array[0] = getByModelId_PrevAndNext(session, modelInputItem,
                    modelId, orderByComparator, true);

            array[1] = modelInputItem;

            array[2] = getByModelId_PrevAndNext(session, modelInputItem,
                    modelId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ModelInputItem getByModelId_PrevAndNext(Session session,
        ModelInputItem modelInputItem, long modelId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MODELINPUTITEM_WHERE);

        query.append(_FINDER_COLUMN_MODELID_MODELID_2);

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
            query.append(ModelInputItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(modelId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(modelInputItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ModelInputItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the model input items where modelId = &#63; from the database.
     *
     * @param modelId the model ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByModelId(long modelId) throws SystemException {
        for (ModelInputItem modelInputItem : findByModelId(modelId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(modelInputItem);
        }
    }

    /**
     * Returns the number of model input items where modelId = &#63;.
     *
     * @param modelId the model ID
     * @return the number of matching model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByModelId(long modelId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_MODELID;

        Object[] finderArgs = new Object[] { modelId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MODELINPUTITEM_WHERE);

            query.append(_FINDER_COLUMN_MODELID_MODELID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(modelId);

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
     * Returns the model input item where modelId = &#63; and modelInputItemID = &#63; or throws a {@link com.ext.portlet.NoSuchModelInputItemException} if it could not be found.
     *
     * @param modelId the model ID
     * @param modelInputItemID the model input item i d
     * @return the matching model input item
     * @throws com.ext.portlet.NoSuchModelInputItemException if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem findByModelIdModelInputId(long modelId,
        long modelInputItemID)
        throws NoSuchModelInputItemException, SystemException {
        ModelInputItem modelInputItem = fetchByModelIdModelInputId(modelId,
                modelInputItemID);

        if (modelInputItem == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("modelId=");
            msg.append(modelId);

            msg.append(", modelInputItemID=");
            msg.append(modelInputItemID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchModelInputItemException(msg.toString());
        }

        return modelInputItem;
    }

    /**
     * Returns the model input item where modelId = &#63; and modelInputItemID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param modelId the model ID
     * @param modelInputItemID the model input item i d
     * @return the matching model input item, or <code>null</code> if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem fetchByModelIdModelInputId(long modelId,
        long modelInputItemID) throws SystemException {
        return fetchByModelIdModelInputId(modelId, modelInputItemID, true);
    }

    /**
     * Returns the model input item where modelId = &#63; and modelInputItemID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param modelId the model ID
     * @param modelInputItemID the model input item i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching model input item, or <code>null</code> if a matching model input item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem fetchByModelIdModelInputId(long modelId,
        long modelInputItemID, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { modelId, modelInputItemID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID,
                    finderArgs, this);
        }

        if (result instanceof ModelInputItem) {
            ModelInputItem modelInputItem = (ModelInputItem) result;

            if ((modelId != modelInputItem.getModelId()) ||
                    (modelInputItemID != modelInputItem.getModelInputItemID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_MODELINPUTITEM_WHERE);

            query.append(_FINDER_COLUMN_MODELIDMODELINPUTID_MODELID_2);

            query.append(_FINDER_COLUMN_MODELIDMODELINPUTID_MODELINPUTITEMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(modelId);

                qPos.add(modelInputItemID);

                List<ModelInputItem> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "ModelInputItemPersistenceImpl.fetchByModelIdModelInputId(long, long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    ModelInputItem modelInputItem = list.get(0);

                    result = modelInputItem;

                    cacheResult(modelInputItem);

                    if ((modelInputItem.getModelId() != modelId) ||
                            (modelInputItem.getModelInputItemID() != modelInputItemID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID,
                            finderArgs, modelInputItem);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ModelInputItem) result;
        }
    }

    /**
     * Removes the model input item where modelId = &#63; and modelInputItemID = &#63; from the database.
     *
     * @param modelId the model ID
     * @param modelInputItemID the model input item i d
     * @return the model input item that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem removeByModelIdModelInputId(long modelId,
        long modelInputItemID)
        throws NoSuchModelInputItemException, SystemException {
        ModelInputItem modelInputItem = findByModelIdModelInputId(modelId,
                modelInputItemID);

        return remove(modelInputItem);
    }

    /**
     * Returns the number of model input items where modelId = &#63; and modelInputItemID = &#63;.
     *
     * @param modelId the model ID
     * @param modelInputItemID the model input item i d
     * @return the number of matching model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByModelIdModelInputId(long modelId, long modelInputItemID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_MODELIDMODELINPUTID;

        Object[] finderArgs = new Object[] { modelId, modelInputItemID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_MODELINPUTITEM_WHERE);

            query.append(_FINDER_COLUMN_MODELIDMODELINPUTID_MODELID_2);

            query.append(_FINDER_COLUMN_MODELIDMODELINPUTID_MODELINPUTITEMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(modelId);

                qPos.add(modelInputItemID);

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
     * Caches the model input item in the entity cache if it is enabled.
     *
     * @param modelInputItem the model input item
     */
    @Override
    public void cacheResult(ModelInputItem modelInputItem) {
        EntityCacheUtil.putResult(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemImpl.class, modelInputItem.getPrimaryKey(),
            modelInputItem);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELINPUTID,
            new Object[] { modelInputItem.getModelInputItemID() },
            modelInputItem);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID,
            new Object[] {
                modelInputItem.getModelId(),
                modelInputItem.getModelInputItemID()
            }, modelInputItem);

        modelInputItem.resetOriginalValues();
    }

    /**
     * Caches the model input items in the entity cache if it is enabled.
     *
     * @param modelInputItems the model input items
     */
    @Override
    public void cacheResult(List<ModelInputItem> modelInputItems) {
        for (ModelInputItem modelInputItem : modelInputItems) {
            if (EntityCacheUtil.getResult(
                        ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
                        ModelInputItemImpl.class, modelInputItem.getPrimaryKey()) == null) {
                cacheResult(modelInputItem);
            } else {
                modelInputItem.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all model input items.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ModelInputItemImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ModelInputItemImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the model input item.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ModelInputItem modelInputItem) {
        EntityCacheUtil.removeResult(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemImpl.class, modelInputItem.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(modelInputItem);
    }

    @Override
    public void clearCache(List<ModelInputItem> modelInputItems) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ModelInputItem modelInputItem : modelInputItems) {
            EntityCacheUtil.removeResult(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
                ModelInputItemImpl.class, modelInputItem.getPrimaryKey());

            clearUniqueFindersCache(modelInputItem);
        }
    }

    protected void cacheUniqueFindersCache(ModelInputItem modelInputItem) {
        if (modelInputItem.isNew()) {
            Object[] args = new Object[] { modelInputItem.getModelInputItemID() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MODELINPUTID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELINPUTID, args,
                modelInputItem);

            args = new Object[] {
                    modelInputItem.getModelId(),
                    modelInputItem.getModelInputItemID()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MODELIDMODELINPUTID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID,
                args, modelInputItem);
        } else {
            ModelInputItemModelImpl modelInputItemModelImpl = (ModelInputItemModelImpl) modelInputItem;

            if ((modelInputItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_MODELINPUTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        modelInputItem.getModelInputItemID()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MODELINPUTID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELINPUTID,
                    args, modelInputItem);
            }

            if ((modelInputItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        modelInputItem.getModelId(),
                        modelInputItem.getModelInputItemID()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MODELIDMODELINPUTID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID,
                    args, modelInputItem);
            }
        }
    }

    protected void clearUniqueFindersCache(ModelInputItem modelInputItem) {
        ModelInputItemModelImpl modelInputItemModelImpl = (ModelInputItemModelImpl) modelInputItem;

        Object[] args = new Object[] { modelInputItem.getModelInputItemID() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODELINPUTID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODELINPUTID, args);

        if ((modelInputItemModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_MODELINPUTID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    modelInputItemModelImpl.getOriginalModelInputItemID()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODELINPUTID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODELINPUTID, args);
        }

        args = new Object[] {
                modelInputItem.getModelId(),
                modelInputItem.getModelInputItemID()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODELIDMODELINPUTID,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID,
            args);

        if ((modelInputItemModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    modelInputItemModelImpl.getOriginalModelId(),
                    modelInputItemModelImpl.getOriginalModelInputItemID()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODELIDMODELINPUTID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODELIDMODELINPUTID,
                args);
        }
    }

    /**
     * Creates a new model input item with the primary key. Does not add the model input item to the database.
     *
     * @param modelInputItemPK the primary key for the new model input item
     * @return the new model input item
     */
    @Override
    public ModelInputItem create(long modelInputItemPK) {
        ModelInputItem modelInputItem = new ModelInputItemImpl();

        modelInputItem.setNew(true);
        modelInputItem.setPrimaryKey(modelInputItemPK);

        return modelInputItem;
    }

    /**
     * Removes the model input item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param modelInputItemPK the primary key of the model input item
     * @return the model input item that was removed
     * @throws com.ext.portlet.NoSuchModelInputItemException if a model input item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem remove(long modelInputItemPK)
        throws NoSuchModelInputItemException, SystemException {
        return remove((Serializable) modelInputItemPK);
    }

    /**
     * Removes the model input item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the model input item
     * @return the model input item that was removed
     * @throws com.ext.portlet.NoSuchModelInputItemException if a model input item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem remove(Serializable primaryKey)
        throws NoSuchModelInputItemException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ModelInputItem modelInputItem = (ModelInputItem) session.get(ModelInputItemImpl.class,
                    primaryKey);

            if (modelInputItem == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchModelInputItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(modelInputItem);
        } catch (NoSuchModelInputItemException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ModelInputItem removeImpl(ModelInputItem modelInputItem)
        throws SystemException {
        modelInputItem = toUnwrappedModel(modelInputItem);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(modelInputItem)) {
                modelInputItem = (ModelInputItem) session.get(ModelInputItemImpl.class,
                        modelInputItem.getPrimaryKeyObj());
            }

            if (modelInputItem != null) {
                session.delete(modelInputItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (modelInputItem != null) {
            clearCache(modelInputItem);
        }

        return modelInputItem;
    }

    @Override
    public ModelInputItem updateImpl(
        com.ext.portlet.model.ModelInputItem modelInputItem)
        throws SystemException {
        modelInputItem = toUnwrappedModel(modelInputItem);

        boolean isNew = modelInputItem.isNew();

        ModelInputItemModelImpl modelInputItemModelImpl = (ModelInputItemModelImpl) modelInputItem;

        Session session = null;

        try {
            session = openSession();

            if (modelInputItem.isNew()) {
                session.save(modelInputItem);

                modelInputItem.setNew(false);
            } else {
                session.merge(modelInputItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ModelInputItemModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((modelInputItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODELGROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        modelInputItemModelImpl.getOriginalModelGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODELGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODELGROUPID,
                    args);

                args = new Object[] { modelInputItemModelImpl.getModelGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODELGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODELGROUPID,
                    args);
            }

            if ((modelInputItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODELID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        modelInputItemModelImpl.getOriginalModelId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODELID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODELID,
                    args);

                args = new Object[] { modelInputItemModelImpl.getModelId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODELID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODELID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelInputItemImpl.class, modelInputItem.getPrimaryKey(),
            modelInputItem);

        clearUniqueFindersCache(modelInputItem);
        cacheUniqueFindersCache(modelInputItem);

        return modelInputItem;
    }

    protected ModelInputItem toUnwrappedModel(ModelInputItem modelInputItem) {
        if (modelInputItem instanceof ModelInputItemImpl) {
            return modelInputItem;
        }

        ModelInputItemImpl modelInputItemImpl = new ModelInputItemImpl();

        modelInputItemImpl.setNew(modelInputItem.isNew());
        modelInputItemImpl.setPrimaryKey(modelInputItem.getPrimaryKey());

        modelInputItemImpl.setModelInputItemPK(modelInputItem.getModelInputItemPK());
        modelInputItemImpl.setModelId(modelInputItem.getModelId());
        modelInputItemImpl.setModelInputItemID(modelInputItem.getModelInputItemID());
        modelInputItemImpl.setModelGroupId(modelInputItem.getModelGroupId());
        modelInputItemImpl.setDisplayItemOrder(modelInputItem.getDisplayItemOrder());
        modelInputItemImpl.setType(modelInputItem.getType());
        modelInputItemImpl.setProperties(modelInputItem.getProperties());

        return modelInputItemImpl;
    }

    /**
     * Returns the model input item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the model input item
     * @return the model input item
     * @throws com.ext.portlet.NoSuchModelInputItemException if a model input item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelInputItemException, SystemException {
        ModelInputItem modelInputItem = fetchByPrimaryKey(primaryKey);

        if (modelInputItem == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchModelInputItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return modelInputItem;
    }

    /**
     * Returns the model input item with the primary key or throws a {@link com.ext.portlet.NoSuchModelInputItemException} if it could not be found.
     *
     * @param modelInputItemPK the primary key of the model input item
     * @return the model input item
     * @throws com.ext.portlet.NoSuchModelInputItemException if a model input item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem findByPrimaryKey(long modelInputItemPK)
        throws NoSuchModelInputItemException, SystemException {
        return findByPrimaryKey((Serializable) modelInputItemPK);
    }

    /**
     * Returns the model input item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the model input item
     * @return the model input item, or <code>null</code> if a model input item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ModelInputItem modelInputItem = (ModelInputItem) EntityCacheUtil.getResult(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
                ModelInputItemImpl.class, primaryKey);

        if (modelInputItem == _nullModelInputItem) {
            return null;
        }

        if (modelInputItem == null) {
            Session session = null;

            try {
                session = openSession();

                modelInputItem = (ModelInputItem) session.get(ModelInputItemImpl.class,
                        primaryKey);

                if (modelInputItem != null) {
                    cacheResult(modelInputItem);
                } else {
                    EntityCacheUtil.putResult(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
                        ModelInputItemImpl.class, primaryKey,
                        _nullModelInputItem);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ModelInputItemModelImpl.ENTITY_CACHE_ENABLED,
                    ModelInputItemImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return modelInputItem;
    }

    /**
     * Returns the model input item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param modelInputItemPK the primary key of the model input item
     * @return the model input item, or <code>null</code> if a model input item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelInputItem fetchByPrimaryKey(long modelInputItemPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) modelInputItemPK);
    }

    /**
     * Returns all the model input items.
     *
     * @return the model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelInputItem> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the model input items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelInputItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of model input items
     * @param end the upper bound of the range of model input items (not inclusive)
     * @return the range of model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelInputItem> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the model input items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelInputItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of model input items
     * @param end the upper bound of the range of model input items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of model input items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelInputItem> findAll(int start, int end,
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

        List<ModelInputItem> list = (List<ModelInputItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MODELINPUTITEM);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MODELINPUTITEM;

                if (pagination) {
                    sql = sql.concat(ModelInputItemModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ModelInputItem>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ModelInputItem>(list);
                } else {
                    list = (List<ModelInputItem>) QueryUtil.list(q,
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
     * Removes all the model input items from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ModelInputItem modelInputItem : findAll()) {
            remove(modelInputItem);
        }
    }

    /**
     * Returns the number of model input items.
     *
     * @return the number of model input items
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

                Query q = session.createQuery(_SQL_COUNT_MODELINPUTITEM);

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

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the model input item persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.ext.portlet.model.ModelInputItem")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ModelInputItem>> listenersList = new ArrayList<ModelListener<ModelInputItem>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ModelInputItem>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ModelInputItemImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
