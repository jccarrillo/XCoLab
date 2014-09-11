package com.ext.portlet.model.impl;

import com.ext.portlet.model.TrackedVisit;
import com.ext.portlet.model.TrackedVisitModel;
import com.ext.portlet.model.TrackedVisitSoap;

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
 * The base model implementation for the TrackedVisit service. Represents a row in the &quot;xcolab_TrackedVisit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.TrackedVisitModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TrackedVisitImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrackedVisitImpl
 * @see com.ext.portlet.model.TrackedVisit
 * @see com.ext.portlet.model.TrackedVisitModel
 * @generated
 */
@JSON(strict = true)
public class TrackedVisitModelImpl extends BaseModelImpl<TrackedVisit>
    implements TrackedVisitModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a tracked visit model instance should use the {@link com.ext.portlet.model.TrackedVisit} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_TrackedVisit";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "uuid_", Types.VARCHAR },
            { "ip", Types.VARCHAR },
            { "city", Types.VARCHAR },
            { "country", Types.VARCHAR },
            { "url", Types.VARCHAR },
            { "browser", Types.VARCHAR },
            { "headers", Types.VARCHAR },
            { "referer", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_TrackedVisit (id_ LONG not null primary key,uuid_ VARCHAR(36) null,ip VARCHAR(45) null,city VARCHAR(255) null,country VARCHAR(2) null,url VARCHAR(2048) null,browser TEXT null,headers TEXT null,referer VARCHAR(2048) null,createDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_TrackedVisit";
    public static final String ORDER_BY_JPQL = " ORDER BY trackedVisit.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_TrackedVisit.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.TrackedVisit"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.TrackedVisit"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.TrackedVisit"),
            true);
    public static long UUID_COLUMN_BITMASK = 1L;
    public static long ID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.TrackedVisit"));
    private static ClassLoader _classLoader = TrackedVisit.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            TrackedVisit.class
        };
    private long _id;
    private String _uuid;
    private String _originalUuid;
    private String _ip;
    private String _city;
    private String _country;
    private String _url;
    private String _browser;
    private String _headers;
    private String _referer;
    private Date _createDate;
    private long _columnBitmask;
    private TrackedVisit _escapedModel;

    public TrackedVisitModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static TrackedVisit toModel(TrackedVisitSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        TrackedVisit model = new TrackedVisitImpl();

        model.setId(soapModel.getId());
        model.setUuid(soapModel.getUuid());
        model.setIp(soapModel.getIp());
        model.setCity(soapModel.getCity());
        model.setCountry(soapModel.getCountry());
        model.setUrl(soapModel.getUrl());
        model.setBrowser(soapModel.getBrowser());
        model.setHeaders(soapModel.getHeaders());
        model.setReferer(soapModel.getReferer());
        model.setCreateDate(soapModel.getCreateDate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<TrackedVisit> toModels(TrackedVisitSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<TrackedVisit> models = new ArrayList<TrackedVisit>(soapModels.length);

        for (TrackedVisitSoap soapModel : soapModels) {
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
        return TrackedVisit.class;
    }

    @Override
    public String getModelClassName() {
        return TrackedVisit.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("uuid", getUuid());
        attributes.put("ip", getIp());
        attributes.put("city", getCity());
        attributes.put("country", getCountry());
        attributes.put("url", getUrl());
        attributes.put("browser", getBrowser());
        attributes.put("headers", getHeaders());
        attributes.put("referer", getReferer());
        attributes.put("createDate", getCreateDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        String ip = (String) attributes.get("ip");

        if (ip != null) {
            setIp(ip);
        }

        String city = (String) attributes.get("city");

        if (city != null) {
            setCity(city);
        }

        String country = (String) attributes.get("country");

        if (country != null) {
            setCountry(country);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String browser = (String) attributes.get("browser");

        if (browser != null) {
            setBrowser(browser);
        }

        String headers = (String) attributes.get("headers");

        if (headers != null) {
            setHeaders(headers);
        }

        String referer = (String) attributes.get("referer");

        if (referer != null) {
            setReferer(referer);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
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
    public String getUuid() {
        if (_uuid == null) {
            return StringPool.BLANK;
        } else {
            return _uuid;
        }
    }

    @Override
    public void setUuid(String uuid) {
        if (_originalUuid == null) {
            _originalUuid = _uuid;
        }

        _uuid = uuid;
    }

    public String getOriginalUuid() {
        return GetterUtil.getString(_originalUuid);
    }

    @JSON
    @Override
    public String getIp() {
        if (_ip == null) {
            return StringPool.BLANK;
        } else {
            return _ip;
        }
    }

    @Override
    public void setIp(String ip) {
        _ip = ip;
    }

    @JSON
    @Override
    public String getCity() {
        if (_city == null) {
            return StringPool.BLANK;
        } else {
            return _city;
        }
    }

    @Override
    public void setCity(String city) {
        _city = city;
    }

    @JSON
    @Override
    public String getCountry() {
        if (_country == null) {
            return StringPool.BLANK;
        } else {
            return _country;
        }
    }

    @Override
    public void setCountry(String country) {
        _country = country;
    }

    @JSON
    @Override
    public String getUrl() {
        if (_url == null) {
            return StringPool.BLANK;
        } else {
            return _url;
        }
    }

    @Override
    public void setUrl(String url) {
        _url = url;
    }

    @JSON
    @Override
    public String getBrowser() {
        if (_browser == null) {
            return StringPool.BLANK;
        } else {
            return _browser;
        }
    }

    @Override
    public void setBrowser(String browser) {
        _browser = browser;
    }

    @JSON
    @Override
    public String getHeaders() {
        if (_headers == null) {
            return StringPool.BLANK;
        } else {
            return _headers;
        }
    }

    @Override
    public void setHeaders(String headers) {
        _headers = headers;
    }

    @JSON
    @Override
    public String getReferer() {
        if (_referer == null) {
            return StringPool.BLANK;
        } else {
            return _referer;
        }
    }

    @Override
    public void setReferer(String referer) {
        _referer = referer;
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

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            TrackedVisit.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public TrackedVisit toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (TrackedVisit) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        TrackedVisitImpl trackedVisitImpl = new TrackedVisitImpl();

        trackedVisitImpl.setId(getId());
        trackedVisitImpl.setUuid(getUuid());
        trackedVisitImpl.setIp(getIp());
        trackedVisitImpl.setCity(getCity());
        trackedVisitImpl.setCountry(getCountry());
        trackedVisitImpl.setUrl(getUrl());
        trackedVisitImpl.setBrowser(getBrowser());
        trackedVisitImpl.setHeaders(getHeaders());
        trackedVisitImpl.setReferer(getReferer());
        trackedVisitImpl.setCreateDate(getCreateDate());

        trackedVisitImpl.resetOriginalValues();

        return trackedVisitImpl;
    }

    @Override
    public int compareTo(TrackedVisit trackedVisit) {
        long primaryKey = trackedVisit.getPrimaryKey();

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

        if (!(obj instanceof TrackedVisit)) {
            return false;
        }

        TrackedVisit trackedVisit = (TrackedVisit) obj;

        long primaryKey = trackedVisit.getPrimaryKey();

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
        TrackedVisitModelImpl trackedVisitModelImpl = this;

        trackedVisitModelImpl._originalUuid = trackedVisitModelImpl._uuid;

        trackedVisitModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<TrackedVisit> toCacheModel() {
        TrackedVisitCacheModel trackedVisitCacheModel = new TrackedVisitCacheModel();

        trackedVisitCacheModel.id = getId();

        trackedVisitCacheModel.uuid = getUuid();

        String uuid = trackedVisitCacheModel.uuid;

        if ((uuid != null) && (uuid.length() == 0)) {
            trackedVisitCacheModel.uuid = null;
        }

        trackedVisitCacheModel.ip = getIp();

        String ip = trackedVisitCacheModel.ip;

        if ((ip != null) && (ip.length() == 0)) {
            trackedVisitCacheModel.ip = null;
        }

        trackedVisitCacheModel.city = getCity();

        String city = trackedVisitCacheModel.city;

        if ((city != null) && (city.length() == 0)) {
            trackedVisitCacheModel.city = null;
        }

        trackedVisitCacheModel.country = getCountry();

        String country = trackedVisitCacheModel.country;

        if ((country != null) && (country.length() == 0)) {
            trackedVisitCacheModel.country = null;
        }

        trackedVisitCacheModel.url = getUrl();

        String url = trackedVisitCacheModel.url;

        if ((url != null) && (url.length() == 0)) {
            trackedVisitCacheModel.url = null;
        }

        trackedVisitCacheModel.browser = getBrowser();

        String browser = trackedVisitCacheModel.browser;

        if ((browser != null) && (browser.length() == 0)) {
            trackedVisitCacheModel.browser = null;
        }

        trackedVisitCacheModel.headers = getHeaders();

        String headers = trackedVisitCacheModel.headers;

        if ((headers != null) && (headers.length() == 0)) {
            trackedVisitCacheModel.headers = null;
        }

        trackedVisitCacheModel.referer = getReferer();

        String referer = trackedVisitCacheModel.referer;

        if ((referer != null) && (referer.length() == 0)) {
            trackedVisitCacheModel.referer = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            trackedVisitCacheModel.createDate = createDate.getTime();
        } else {
            trackedVisitCacheModel.createDate = Long.MIN_VALUE;
        }

        return trackedVisitCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", uuid=");
        sb.append(getUuid());
        sb.append(", ip=");
        sb.append(getIp());
        sb.append(", city=");
        sb.append(getCity());
        sb.append(", country=");
        sb.append(getCountry());
        sb.append(", url=");
        sb.append(getUrl());
        sb.append(", browser=");
        sb.append(getBrowser());
        sb.append(", headers=");
        sb.append(getHeaders());
        sb.append(", referer=");
        sb.append(getReferer());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.TrackedVisit");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ip</column-name><column-value><![CDATA[");
        sb.append(getIp());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>city</column-name><column-value><![CDATA[");
        sb.append(getCity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>country</column-name><column-value><![CDATA[");
        sb.append(getCountry());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>url</column-name><column-value><![CDATA[");
        sb.append(getUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>browser</column-name><column-value><![CDATA[");
        sb.append(getBrowser());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>headers</column-name><column-value><![CDATA[");
        sb.append(getHeaders());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>referer</column-name><column-value><![CDATA[");
        sb.append(getReferer());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}