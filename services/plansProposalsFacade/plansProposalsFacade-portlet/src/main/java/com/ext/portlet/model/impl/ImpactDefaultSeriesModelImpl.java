package com.ext.portlet.model.impl;

import com.ext.portlet.model.ImpactDefaultSeries;
import com.ext.portlet.model.ImpactDefaultSeriesModel;
import com.ext.portlet.model.ImpactDefaultSeriesSoap;
import com.ext.portlet.service.persistence.ImpactDefaultSeriesPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ImpactDefaultSeries service. Represents a row in the &quot;xcolab_ImpactDefaultSeries&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ImpactDefaultSeriesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ImpactDefaultSeriesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImpactDefaultSeriesImpl
 * @see com.ext.portlet.model.ImpactDefaultSeries
 * @see com.ext.portlet.model.ImpactDefaultSeriesModel
 * @generated
 */
@JSON(strict = true)
public class ImpactDefaultSeriesModelImpl extends BaseModelImpl<ImpactDefaultSeries>
    implements ImpactDefaultSeriesModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a impact default series model instance should use the {@link com.ext.portlet.model.ImpactDefaultSeries} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ImpactDefaultSeries";
    public static final Object[][] TABLE_COLUMNS = {
            { "seriesId", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "focusAreaId", Types.BIGINT },
            { "visible", Types.BOOLEAN },
            { "editable", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ImpactDefaultSeries (seriesId LONG not null,name VARCHAR(75) not null,description VARCHAR(1000) null,focusAreaId LONG,visible BOOLEAN,editable BOOLEAN,primary key (seriesId, name))";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ImpactDefaultSeries";
    public static final String ORDER_BY_JPQL = " ORDER BY impactDefaultSeries.id.seriesId ASC, impactDefaultSeries.id.name ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_ImpactDefaultSeries.seriesId ASC, xcolab_ImpactDefaultSeries.name ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ImpactDefaultSeries"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ImpactDefaultSeries"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.ImpactDefaultSeries"),
            true);
    public static long EDITABLE_COLUMN_BITMASK = 1L;
    public static long FOCUSAREAID_COLUMN_BITMASK = 2L;
    public static long NAME_COLUMN_BITMASK = 4L;
    public static long SERIESID_COLUMN_BITMASK = 8L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ImpactDefaultSeries"));
    private static ClassLoader _classLoader = ImpactDefaultSeries.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ImpactDefaultSeries.class
        };
    private long _seriesId;
    private long _originalSeriesId;
    private boolean _setOriginalSeriesId;
    private String _name;
    private String _originalName;
    private String _description;
    private long _focusAreaId;
    private long _originalFocusAreaId;
    private boolean _setOriginalFocusAreaId;
    private boolean _visible;
    private boolean _editable;
    private boolean _originalEditable;
    private boolean _setOriginalEditable;
    private long _columnBitmask;
    private ImpactDefaultSeries _escapedModel;

    public ImpactDefaultSeriesModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ImpactDefaultSeries toModel(ImpactDefaultSeriesSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ImpactDefaultSeries model = new ImpactDefaultSeriesImpl();

        model.setSeriesId(soapModel.getSeriesId());
        model.setName(soapModel.getName());
        model.setDescription(soapModel.getDescription());
        model.setFocusAreaId(soapModel.getFocusAreaId());
        model.setVisible(soapModel.getVisible());
        model.setEditable(soapModel.getEditable());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ImpactDefaultSeries> toModels(
        ImpactDefaultSeriesSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ImpactDefaultSeries> models = new ArrayList<ImpactDefaultSeries>(soapModels.length);

        for (ImpactDefaultSeriesSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public ImpactDefaultSeriesPK getPrimaryKey() {
        return new ImpactDefaultSeriesPK(_seriesId, _name);
    }

    @Override
    public void setPrimaryKey(ImpactDefaultSeriesPK primaryKey) {
        setSeriesId(primaryKey.seriesId);
        setName(primaryKey.name);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new ImpactDefaultSeriesPK(_seriesId, _name);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((ImpactDefaultSeriesPK) primaryKeyObj);
    }

    @Override
    public Class<?> getModelClass() {
        return ImpactDefaultSeries.class;
    }

    @Override
    public String getModelClassName() {
        return ImpactDefaultSeries.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("seriesId", getSeriesId());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("focusAreaId", getFocusAreaId());
        attributes.put("visible", getVisible());
        attributes.put("editable", getEditable());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long seriesId = (Long) attributes.get("seriesId");

        if (seriesId != null) {
            setSeriesId(seriesId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long focusAreaId = (Long) attributes.get("focusAreaId");

        if (focusAreaId != null) {
            setFocusAreaId(focusAreaId);
        }

        Boolean visible = (Boolean) attributes.get("visible");

        if (visible != null) {
            setVisible(visible);
        }

        Boolean editable = (Boolean) attributes.get("editable");

        if (editable != null) {
            setEditable(editable);
        }
    }

    @JSON
    @Override
    public long getSeriesId() {
        return _seriesId;
    }

    @Override
    public void setSeriesId(long seriesId) {
        _columnBitmask |= SERIESID_COLUMN_BITMASK;

        if (!_setOriginalSeriesId) {
            _setOriginalSeriesId = true;

            _originalSeriesId = _seriesId;
        }

        _seriesId = seriesId;
    }

    public long getOriginalSeriesId() {
        return _originalSeriesId;
    }

    @JSON
    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _columnBitmask |= NAME_COLUMN_BITMASK;

        if (_originalName == null) {
            _originalName = _name;
        }

        _name = name;
    }

    public String getOriginalName() {
        return GetterUtil.getString(_originalName);
    }

    @JSON
    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @JSON
    @Override
    public long getFocusAreaId() {
        return _focusAreaId;
    }

    @Override
    public void setFocusAreaId(long focusAreaId) {
        _columnBitmask |= FOCUSAREAID_COLUMN_BITMASK;

        if (!_setOriginalFocusAreaId) {
            _setOriginalFocusAreaId = true;

            _originalFocusAreaId = _focusAreaId;
        }

        _focusAreaId = focusAreaId;
    }

    public long getOriginalFocusAreaId() {
        return _originalFocusAreaId;
    }

    @JSON
    @Override
    public boolean getVisible() {
        return _visible;
    }

    @Override
    public boolean isVisible() {
        return _visible;
    }

    @Override
    public void setVisible(boolean visible) {
        _visible = visible;
    }

    @JSON
    @Override
    public boolean getEditable() {
        return _editable;
    }

    @Override
    public boolean isEditable() {
        return _editable;
    }

    @Override
    public void setEditable(boolean editable) {
        _columnBitmask |= EDITABLE_COLUMN_BITMASK;

        if (!_setOriginalEditable) {
            _setOriginalEditable = true;

            _originalEditable = _editable;
        }

        _editable = editable;
    }

    public boolean getOriginalEditable() {
        return _originalEditable;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ImpactDefaultSeries toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ImpactDefaultSeries) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ImpactDefaultSeriesImpl impactDefaultSeriesImpl = new ImpactDefaultSeriesImpl();

        impactDefaultSeriesImpl.setSeriesId(getSeriesId());
        impactDefaultSeriesImpl.setName(getName());
        impactDefaultSeriesImpl.setDescription(getDescription());
        impactDefaultSeriesImpl.setFocusAreaId(getFocusAreaId());
        impactDefaultSeriesImpl.setVisible(getVisible());
        impactDefaultSeriesImpl.setEditable(getEditable());

        impactDefaultSeriesImpl.resetOriginalValues();

        return impactDefaultSeriesImpl;
    }

    @Override
    public int compareTo(ImpactDefaultSeries impactDefaultSeries) {
        ImpactDefaultSeriesPK primaryKey = impactDefaultSeries.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ImpactDefaultSeries)) {
            return false;
        }

        ImpactDefaultSeries impactDefaultSeries = (ImpactDefaultSeries) obj;

        ImpactDefaultSeriesPK primaryKey = impactDefaultSeries.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public void resetOriginalValues() {
        ImpactDefaultSeriesModelImpl impactDefaultSeriesModelImpl = this;

        impactDefaultSeriesModelImpl._originalSeriesId = impactDefaultSeriesModelImpl._seriesId;

        impactDefaultSeriesModelImpl._setOriginalSeriesId = false;

        impactDefaultSeriesModelImpl._originalName = impactDefaultSeriesModelImpl._name;

        impactDefaultSeriesModelImpl._originalFocusAreaId = impactDefaultSeriesModelImpl._focusAreaId;

        impactDefaultSeriesModelImpl._setOriginalFocusAreaId = false;

        impactDefaultSeriesModelImpl._originalEditable = impactDefaultSeriesModelImpl._editable;

        impactDefaultSeriesModelImpl._setOriginalEditable = false;

        impactDefaultSeriesModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ImpactDefaultSeries> toCacheModel() {
        ImpactDefaultSeriesCacheModel impactDefaultSeriesCacheModel = new ImpactDefaultSeriesCacheModel();

        impactDefaultSeriesCacheModel.seriesId = getSeriesId();

        impactDefaultSeriesCacheModel.name = getName();

        String name = impactDefaultSeriesCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            impactDefaultSeriesCacheModel.name = null;
        }

        impactDefaultSeriesCacheModel.description = getDescription();

        String description = impactDefaultSeriesCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            impactDefaultSeriesCacheModel.description = null;
        }

        impactDefaultSeriesCacheModel.focusAreaId = getFocusAreaId();

        impactDefaultSeriesCacheModel.visible = getVisible();

        impactDefaultSeriesCacheModel.editable = getEditable();

        return impactDefaultSeriesCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{seriesId=");
        sb.append(getSeriesId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", focusAreaId=");
        sb.append(getFocusAreaId());
        sb.append(", visible=");
        sb.append(getVisible());
        sb.append(", editable=");
        sb.append(getEditable());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ImpactDefaultSeries");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>seriesId</column-name><column-value><![CDATA[");
        sb.append(getSeriesId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>focusAreaId</column-name><column-value><![CDATA[");
        sb.append(getFocusAreaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>visible</column-name><column-value><![CDATA[");
        sb.append(getVisible());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>editable</column-name><column-value><![CDATA[");
        sb.append(getEditable());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
