package com.ext.portlet.model.impl;

import com.ext.portlet.model.EmailList;
import com.ext.portlet.model.EmailListModel;
import com.ext.portlet.model.EmailListSoap;

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
import java.util.List;

/**
 * The base model implementation for the EmailList service. Represents a row in the &quot;xcolab_EmailList&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.EmailListModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmailListImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailListImpl
 * @see com.ext.portlet.model.EmailList
 * @see com.ext.portlet.model.EmailListModel
 * @generated
 */
@JSON(strict = true)
public class EmailListModelImpl extends BaseModelImpl<EmailList>
    implements EmailListModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a email list model instance should use the {@link com.ext.portlet.model.EmailList} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_EmailList";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "email", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_EmailList (id_ LONG not null primary key,name VARCHAR(256) null,email VARCHAR(256) null)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_EmailList";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.EmailList"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.EmailList"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.EmailList"),
            true);
    public static long EMAIL_COLUMN_BITMASK = 1L;
    public static long NAME_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.EmailList"));
    private static ClassLoader _classLoader = EmailList.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            EmailList.class
        };
    private long _id;
    private String _name;
    private String _originalName;
    private String _email;
    private String _originalEmail;
    private transient ExpandoBridge _expandoBridge;
    private long _columnBitmask;
    private EmailList _escapedModelProxy;

    public EmailListModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static EmailList toModel(EmailListSoap soapModel) {
        EmailList model = new EmailListImpl();

        model.setId(soapModel.getId());
        model.setName(soapModel.getName());
        model.setEmail(soapModel.getEmail());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<EmailList> toModels(EmailListSoap[] soapModels) {
        List<EmailList> models = new ArrayList<EmailList>(soapModels.length);

        for (EmailListSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return EmailList.class;
    }

    public String getModelClassName() {
        return EmailList.class.getName();
    }

    @JSON
    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    @JSON
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

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
    public String getEmail() {
        if (_email == null) {
            return StringPool.BLANK;
        } else {
            return _email;
        }
    }

    public void setEmail(String email) {
        _columnBitmask |= EMAIL_COLUMN_BITMASK;

        if (_originalEmail == null) {
            _originalEmail = _email;
        }

        _email = email;
    }

    public String getOriginalEmail() {
        return GetterUtil.getString(_originalEmail);
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public EmailList toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (EmailList) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
                    EmailList.class.getName(), getPrimaryKey());
        }

        return _expandoBridge;
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        getExpandoBridge().setAttributes(serviceContext);
    }

    @Override
    public Object clone() {
        EmailListImpl emailListImpl = new EmailListImpl();

        emailListImpl.setId(getId());
        emailListImpl.setName(getName());
        emailListImpl.setEmail(getEmail());

        emailListImpl.resetOriginalValues();

        return emailListImpl;
    }

    public int compareTo(EmailList emailList) {
        long primaryKey = emailList.getPrimaryKey();

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
        if (obj == null) {
            return false;
        }

        EmailList emailList = null;

        try {
            emailList = (EmailList) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = emailList.getPrimaryKey();

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
        EmailListModelImpl emailListModelImpl = this;

        emailListModelImpl._originalName = emailListModelImpl._name;

        emailListModelImpl._originalEmail = emailListModelImpl._email;

        emailListModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<EmailList> toCacheModel() {
        EmailListCacheModel emailListCacheModel = new EmailListCacheModel();

        emailListCacheModel.id = getId();

        emailListCacheModel.name = getName();

        String name = emailListCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            emailListCacheModel.name = null;
        }

        emailListCacheModel.email = getEmail();

        String email = emailListCacheModel.email;

        if ((email != null) && (email.length() == 0)) {
            emailListCacheModel.email = null;
        }

        return emailListCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.EmailList");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}