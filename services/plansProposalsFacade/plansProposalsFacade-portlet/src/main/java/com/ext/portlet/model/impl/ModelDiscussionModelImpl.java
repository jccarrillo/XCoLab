package com.ext.portlet.model.impl;

import com.ext.portlet.model.ModelDiscussion;
import com.ext.portlet.model.ModelDiscussionModel;
import com.ext.portlet.model.ModelDiscussionSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ModelDiscussion service. Represents a row in the &quot;xcolab_ModelDiscussion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ModelDiscussionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ModelDiscussionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModelDiscussionImpl
 * @see com.ext.portlet.model.ModelDiscussion
 * @see com.ext.portlet.model.ModelDiscussionModel
 * @generated
 */
@JSON(strict = true)
public class ModelDiscussionModelImpl extends BaseModelImpl<ModelDiscussion>
    implements ModelDiscussionModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a model discussion model instance should use the {@link com.ext.portlet.model.ModelDiscussion} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ModelDiscussion";
    public static final Object[][] TABLE_COLUMNS = {
            { "modelDiscussionId", Types.BIGINT },
            { "modelId", Types.BIGINT },
            { "categoryId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ModelDiscussion (modelDiscussionId LONG not null primary key,modelId LONG,categoryId LONG)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ModelDiscussion";
    public static final String ORDER_BY_JPQL = " ORDER BY modelDiscussion.modelDiscussionId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_ModelDiscussion.modelDiscussionId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ModelDiscussion"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ModelDiscussion"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.ModelDiscussion"),
            true);
    public static long CATEGORYID_COLUMN_BITMASK = 1L;
    public static long MODELID_COLUMN_BITMASK = 2L;
    public static long MODELDISCUSSIONID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ModelDiscussion"));
    private static ClassLoader _classLoader = ModelDiscussion.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ModelDiscussion.class
        };
    private long _modelDiscussionId;
    private long _modelId;
    private long _originalModelId;
    private boolean _setOriginalModelId;
    private long _categoryId;
    private long _originalCategoryId;
    private boolean _setOriginalCategoryId;
    private long _columnBitmask;
    private ModelDiscussion _escapedModel;

    public ModelDiscussionModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ModelDiscussion toModel(ModelDiscussionSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ModelDiscussion model = new ModelDiscussionImpl();

        model.setModelDiscussionId(soapModel.getModelDiscussionId());
        model.setModelId(soapModel.getModelId());
        model.setCategoryId(soapModel.getCategoryId());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ModelDiscussion> toModels(
        ModelDiscussionSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ModelDiscussion> models = new ArrayList<ModelDiscussion>(soapModels.length);

        for (ModelDiscussionSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _modelDiscussionId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setModelDiscussionId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _modelDiscussionId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return ModelDiscussion.class;
    }

    @Override
    public String getModelClassName() {
        return ModelDiscussion.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("modelDiscussionId", getModelDiscussionId());
        attributes.put("modelId", getModelId());
        attributes.put("categoryId", getCategoryId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long modelDiscussionId = (Long) attributes.get("modelDiscussionId");

        if (modelDiscussionId != null) {
            setModelDiscussionId(modelDiscussionId);
        }

        Long modelId = (Long) attributes.get("modelId");

        if (modelId != null) {
            setModelId(modelId);
        }

        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }
    }

    @JSON
    @Override
    public long getModelDiscussionId() {
        return _modelDiscussionId;
    }

    @Override
    public void setModelDiscussionId(long modelDiscussionId) {
        _modelDiscussionId = modelDiscussionId;
    }

    @JSON
    @Override
    public long getModelId() {
        return _modelId;
    }

    @Override
    public void setModelId(long modelId) {
        _columnBitmask |= MODELID_COLUMN_BITMASK;

        if (!_setOriginalModelId) {
            _setOriginalModelId = true;

            _originalModelId = _modelId;
        }

        _modelId = modelId;
    }

    public long getOriginalModelId() {
        return _originalModelId;
    }

    @JSON
    @Override
    public long getCategoryId() {
        return _categoryId;
    }

    @Override
    public void setCategoryId(long categoryId) {
        _columnBitmask |= CATEGORYID_COLUMN_BITMASK;

        if (!_setOriginalCategoryId) {
            _setOriginalCategoryId = true;

            _originalCategoryId = _categoryId;
        }

        _categoryId = categoryId;
    }

    public long getOriginalCategoryId() {
        return _originalCategoryId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            ModelDiscussion.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ModelDiscussion toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ModelDiscussion) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ModelDiscussionImpl modelDiscussionImpl = new ModelDiscussionImpl();

        modelDiscussionImpl.setModelDiscussionId(getModelDiscussionId());
        modelDiscussionImpl.setModelId(getModelId());
        modelDiscussionImpl.setCategoryId(getCategoryId());

        modelDiscussionImpl.resetOriginalValues();

        return modelDiscussionImpl;
    }

    @Override
    public int compareTo(ModelDiscussion modelDiscussion) {
        long primaryKey = modelDiscussion.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ModelDiscussion)) {
            return false;
        }

        ModelDiscussion modelDiscussion = (ModelDiscussion) obj;

        long primaryKey = modelDiscussion.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        ModelDiscussionModelImpl modelDiscussionModelImpl = this;

        modelDiscussionModelImpl._originalModelId = modelDiscussionModelImpl._modelId;

        modelDiscussionModelImpl._setOriginalModelId = false;

        modelDiscussionModelImpl._originalCategoryId = modelDiscussionModelImpl._categoryId;

        modelDiscussionModelImpl._setOriginalCategoryId = false;

        modelDiscussionModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ModelDiscussion> toCacheModel() {
        ModelDiscussionCacheModel modelDiscussionCacheModel = new ModelDiscussionCacheModel();

        modelDiscussionCacheModel.modelDiscussionId = getModelDiscussionId();

        modelDiscussionCacheModel.modelId = getModelId();

        modelDiscussionCacheModel.categoryId = getCategoryId();

        return modelDiscussionCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{modelDiscussionId=");
        sb.append(getModelDiscussionId());
        sb.append(", modelId=");
        sb.append(getModelId());
        sb.append(", categoryId=");
        sb.append(getCategoryId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ModelDiscussion");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>modelDiscussionId</column-name><column-value><![CDATA[");
        sb.append(getModelDiscussionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelId</column-name><column-value><![CDATA[");
        sb.append(getModelId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
