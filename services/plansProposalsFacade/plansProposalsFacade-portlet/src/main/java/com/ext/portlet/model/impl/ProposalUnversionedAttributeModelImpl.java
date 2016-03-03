package com.ext.portlet.model.impl;

import com.ext.portlet.model.ProposalUnversionedAttribute;
import com.ext.portlet.model.ProposalUnversionedAttributeModel;
import com.ext.portlet.model.ProposalUnversionedAttributeSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ProposalUnversionedAttribute service. Represents a row in the &quot;xcolab_ProposalUnversionedAttribute&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ProposalUnversionedAttributeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProposalUnversionedAttributeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalUnversionedAttributeImpl
 * @see com.ext.portlet.model.ProposalUnversionedAttribute
 * @see com.ext.portlet.model.ProposalUnversionedAttributeModel
 * @generated
 */
@JSON(strict = true)
public class ProposalUnversionedAttributeModelImpl extends BaseModelImpl<ProposalUnversionedAttribute>
    implements ProposalUnversionedAttributeModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a proposal unversioned attribute model instance should use the {@link com.ext.portlet.model.ProposalUnversionedAttribute} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ProposalUnversionedAttribute";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "proposalId", Types.BIGINT },
            { "createAuthorId", Types.BIGINT },
            { "lastAuthorId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP },
            { "lastUpdateDate", Types.TIMESTAMP },
            { "name", Types.VARCHAR },
            { "addtionalId", Types.INTEGER },
            { "numericValue", Types.BIGINT },
            { "stringValue", Types.VARCHAR },
            { "realValue", Types.DOUBLE }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ProposalUnversionedAttribute (id_ LONG not null primary key,proposalId LONG,createAuthorId LONG,lastAuthorId LONG,createDate DATE null,lastUpdateDate DATE null,name VARCHAR(75) null,addtionalId INTEGER,numericValue LONG,stringValue VARCHAR(75) null,realValue DOUBLE)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ProposalUnversionedAttribute";
    public static final String ORDER_BY_JPQL = " ORDER BY proposalUnversionedAttribute.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_ProposalUnversionedAttribute.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ProposalUnversionedAttribute"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ProposalUnversionedAttribute"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.ProposalUnversionedAttribute"),
            true);
    public static long NAME_COLUMN_BITMASK = 1L;
    public static long PROPOSALID_COLUMN_BITMASK = 2L;
    public static long ID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ProposalUnversionedAttribute"));
    private static ClassLoader _classLoader = ProposalUnversionedAttribute.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ProposalUnversionedAttribute.class
        };
    private long _id;
    private long _proposalId;
    private long _originalProposalId;
    private boolean _setOriginalProposalId;
    private long _createAuthorId;
    private long _lastAuthorId;
    private Date _createDate;
    private Date _lastUpdateDate;
    private String _name;
    private String _originalName;
    private int _addtionalId;
    private long _numericValue;
    private String _stringValue;
    private double _realValue;
    private long _columnBitmask;
    private ProposalUnversionedAttribute _escapedModel;

    public ProposalUnversionedAttributeModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ProposalUnversionedAttribute toModel(
        ProposalUnversionedAttributeSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ProposalUnversionedAttribute model = new ProposalUnversionedAttributeImpl();

        model.setId(soapModel.getId());
        model.setProposalId(soapModel.getProposalId());
        model.setCreateAuthorId(soapModel.getCreateAuthorId());
        model.setLastAuthorId(soapModel.getLastAuthorId());
        model.setCreateDate(soapModel.getCreateDate());
        model.setLastUpdateDate(soapModel.getLastUpdateDate());
        model.setName(soapModel.getName());
        model.setAddtionalId(soapModel.getAddtionalId());
        model.setNumericValue(soapModel.getNumericValue());
        model.setStringValue(soapModel.getStringValue());
        model.setRealValue(soapModel.getRealValue());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ProposalUnversionedAttribute> toModels(
        ProposalUnversionedAttributeSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ProposalUnversionedAttribute> models = new ArrayList<ProposalUnversionedAttribute>(soapModels.length);

        for (ProposalUnversionedAttributeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return ProposalUnversionedAttribute.class;
    }

    @Override
    public String getModelClassName() {
        return ProposalUnversionedAttribute.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("proposalId", getProposalId());
        attributes.put("createAuthorId", getCreateAuthorId());
        attributes.put("lastAuthorId", getLastAuthorId());
        attributes.put("createDate", getCreateDate());
        attributes.put("lastUpdateDate", getLastUpdateDate());
        attributes.put("name", getName());
        attributes.put("addtionalId", getAddtionalId());
        attributes.put("numericValue", getNumericValue());
        attributes.put("stringValue", getStringValue());
        attributes.put("realValue", getRealValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Long proposalId = (Long) attributes.get("proposalId");

        if (proposalId != null) {
            setProposalId(proposalId);
        }

        Long createAuthorId = (Long) attributes.get("createAuthorId");

        if (createAuthorId != null) {
            setCreateAuthorId(createAuthorId);
        }

        Long lastAuthorId = (Long) attributes.get("lastAuthorId");

        if (lastAuthorId != null) {
            setLastAuthorId(lastAuthorId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date lastUpdateDate = (Date) attributes.get("lastUpdateDate");

        if (lastUpdateDate != null) {
            setLastUpdateDate(lastUpdateDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Integer addtionalId = (Integer) attributes.get("addtionalId");

        if (addtionalId != null) {
            setAddtionalId(addtionalId);
        }

        Long numericValue = (Long) attributes.get("numericValue");

        if (numericValue != null) {
            setNumericValue(numericValue);
        }

        String stringValue = (String) attributes.get("stringValue");

        if (stringValue != null) {
            setStringValue(stringValue);
        }

        Double realValue = (Double) attributes.get("realValue");

        if (realValue != null) {
            setRealValue(realValue);
        }
    }

    @JSON
    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;
    }

    @JSON
    @Override
    public long getProposalId() {
        return _proposalId;
    }

    @Override
    public void setProposalId(long proposalId) {
        _columnBitmask |= PROPOSALID_COLUMN_BITMASK;

        if (!_setOriginalProposalId) {
            _setOriginalProposalId = true;

            _originalProposalId = _proposalId;
        }

        _proposalId = proposalId;
    }

    public long getOriginalProposalId() {
        return _originalProposalId;
    }

    @JSON
    @Override
    public long getCreateAuthorId() {
        return _createAuthorId;
    }

    @Override
    public void setCreateAuthorId(long createAuthorId) {
        _createAuthorId = createAuthorId;
    }

    @JSON
    @Override
    public long getLastAuthorId() {
        return _lastAuthorId;
    }

    @Override
    public void setLastAuthorId(long lastAuthorId) {
        _lastAuthorId = lastAuthorId;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    @Override
    public Date getLastUpdateDate() {
        return _lastUpdateDate;
    }

    @Override
    public void setLastUpdateDate(Date lastUpdateDate) {
        _lastUpdateDate = lastUpdateDate;
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
    public int getAddtionalId() {
        return _addtionalId;
    }

    @Override
    public void setAddtionalId(int addtionalId) {
        _addtionalId = addtionalId;
    }

    @JSON
    @Override
    public long getNumericValue() {
        return _numericValue;
    }

    @Override
    public void setNumericValue(long numericValue) {
        _numericValue = numericValue;
    }

    @JSON
    @Override
    public String getStringValue() {
        if (_stringValue == null) {
            return StringPool.BLANK;
        } else {
            return _stringValue;
        }
    }

    @Override
    public void setStringValue(String stringValue) {
        _stringValue = stringValue;
    }

    @JSON
    @Override
    public double getRealValue() {
        return _realValue;
    }

    @Override
    public void setRealValue(double realValue) {
        _realValue = realValue;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            ProposalUnversionedAttribute.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ProposalUnversionedAttribute toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ProposalUnversionedAttribute) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ProposalUnversionedAttributeImpl proposalUnversionedAttributeImpl = new ProposalUnversionedAttributeImpl();

        proposalUnversionedAttributeImpl.setId(getId());
        proposalUnversionedAttributeImpl.setProposalId(getProposalId());
        proposalUnversionedAttributeImpl.setCreateAuthorId(getCreateAuthorId());
        proposalUnversionedAttributeImpl.setLastAuthorId(getLastAuthorId());
        proposalUnversionedAttributeImpl.setCreateDate(getCreateDate());
        proposalUnversionedAttributeImpl.setLastUpdateDate(getLastUpdateDate());
        proposalUnversionedAttributeImpl.setName(getName());
        proposalUnversionedAttributeImpl.setAddtionalId(getAddtionalId());
        proposalUnversionedAttributeImpl.setNumericValue(getNumericValue());
        proposalUnversionedAttributeImpl.setStringValue(getStringValue());
        proposalUnversionedAttributeImpl.setRealValue(getRealValue());

        proposalUnversionedAttributeImpl.resetOriginalValues();

        return proposalUnversionedAttributeImpl;
    }

    @Override
    public int compareTo(
        ProposalUnversionedAttribute proposalUnversionedAttribute) {
        long primaryKey = proposalUnversionedAttribute.getPrimaryKey();

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

        if (!(obj instanceof ProposalUnversionedAttribute)) {
            return false;
        }

        ProposalUnversionedAttribute proposalUnversionedAttribute = (ProposalUnversionedAttribute) obj;

        long primaryKey = proposalUnversionedAttribute.getPrimaryKey();

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
        ProposalUnversionedAttributeModelImpl proposalUnversionedAttributeModelImpl =
            this;

        proposalUnversionedAttributeModelImpl._originalProposalId = proposalUnversionedAttributeModelImpl._proposalId;

        proposalUnversionedAttributeModelImpl._setOriginalProposalId = false;

        proposalUnversionedAttributeModelImpl._originalName = proposalUnversionedAttributeModelImpl._name;

        proposalUnversionedAttributeModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ProposalUnversionedAttribute> toCacheModel() {
        ProposalUnversionedAttributeCacheModel proposalUnversionedAttributeCacheModel =
            new ProposalUnversionedAttributeCacheModel();

        proposalUnversionedAttributeCacheModel.id = getId();

        proposalUnversionedAttributeCacheModel.proposalId = getProposalId();

        proposalUnversionedAttributeCacheModel.createAuthorId = getCreateAuthorId();

        proposalUnversionedAttributeCacheModel.lastAuthorId = getLastAuthorId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            proposalUnversionedAttributeCacheModel.createDate = createDate.getTime();
        } else {
            proposalUnversionedAttributeCacheModel.createDate = Long.MIN_VALUE;
        }

        Date lastUpdateDate = getLastUpdateDate();

        if (lastUpdateDate != null) {
            proposalUnversionedAttributeCacheModel.lastUpdateDate = lastUpdateDate.getTime();
        } else {
            proposalUnversionedAttributeCacheModel.lastUpdateDate = Long.MIN_VALUE;
        }

        proposalUnversionedAttributeCacheModel.name = getName();

        String name = proposalUnversionedAttributeCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            proposalUnversionedAttributeCacheModel.name = null;
        }

        proposalUnversionedAttributeCacheModel.addtionalId = getAddtionalId();

        proposalUnversionedAttributeCacheModel.numericValue = getNumericValue();

        proposalUnversionedAttributeCacheModel.stringValue = getStringValue();

        String stringValue = proposalUnversionedAttributeCacheModel.stringValue;

        if ((stringValue != null) && (stringValue.length() == 0)) {
            proposalUnversionedAttributeCacheModel.stringValue = null;
        }

        proposalUnversionedAttributeCacheModel.realValue = getRealValue();

        return proposalUnversionedAttributeCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", proposalId=");
        sb.append(getProposalId());
        sb.append(", createAuthorId=");
        sb.append(getCreateAuthorId());
        sb.append(", lastAuthorId=");
        sb.append(getLastAuthorId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", lastUpdateDate=");
        sb.append(getLastUpdateDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", addtionalId=");
        sb.append(getAddtionalId());
        sb.append(", numericValue=");
        sb.append(getNumericValue());
        sb.append(", stringValue=");
        sb.append(getStringValue());
        sb.append(", realValue=");
        sb.append(getRealValue());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(37);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ProposalUnversionedAttribute");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>proposalId</column-name><column-value><![CDATA[");
        sb.append(getProposalId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createAuthorId</column-name><column-value><![CDATA[");
        sb.append(getCreateAuthorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastAuthorId</column-name><column-value><![CDATA[");
        sb.append(getLastAuthorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastUpdateDate</column-name><column-value><![CDATA[");
        sb.append(getLastUpdateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>addtionalId</column-name><column-value><![CDATA[");
        sb.append(getAddtionalId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>numericValue</column-name><column-value><![CDATA[");
        sb.append(getNumericValue());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stringValue</column-name><column-value><![CDATA[");
        sb.append(getStringValue());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>realValue</column-name><column-value><![CDATA[");
        sb.append(getRealValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}