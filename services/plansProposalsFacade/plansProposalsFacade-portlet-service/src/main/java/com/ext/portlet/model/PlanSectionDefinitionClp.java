package com.ext.portlet.model;

import com.ext.portlet.service.ClpSerializer;
import com.ext.portlet.service.PlanSectionDefinitionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class PlanSectionDefinitionClp extends BaseModelImpl<PlanSectionDefinition>
    implements PlanSectionDefinition {
    private long _id;
    private String _type;
    private String _adminTitle;
    private String _title;
    private String _defaultText;
    private String _helpText;
    private int _characterLimit;
    private long _focusAreaId;
    private long _tier;
    private String _allowedContestTypeIds;
    private String _allowedValues;
    private String _additionalIds;
    private boolean _locked;
    private boolean _contestIntegrationRelevance;
    private BaseModel<?> _planSectionDefinitionRemoteModel;
    private Class<?> _clpSerializerClass = com.ext.portlet.service.ClpSerializer.class;

    public PlanSectionDefinitionClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return PlanSectionDefinition.class;
    }

    @Override
    public String getModelClassName() {
        return PlanSectionDefinition.class.getName();
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
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("type", getType());
        attributes.put("adminTitle", getAdminTitle());
        attributes.put("title", getTitle());
        attributes.put("defaultText", getDefaultText());
        attributes.put("helpText", getHelpText());
        attributes.put("characterLimit", getCharacterLimit());
        attributes.put("focusAreaId", getFocusAreaId());
        attributes.put("tier", getTier());
        attributes.put("allowedContestTypeIds", getAllowedContestTypeIds());
        attributes.put("allowedValues", getAllowedValues());
        attributes.put("additionalIds", getAdditionalIds());
        attributes.put("locked", getLocked());
        attributes.put("contestIntegrationRelevance",
            getContestIntegrationRelevance());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String type = (String) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        String adminTitle = (String) attributes.get("adminTitle");

        if (adminTitle != null) {
            setAdminTitle(adminTitle);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String defaultText = (String) attributes.get("defaultText");

        if (defaultText != null) {
            setDefaultText(defaultText);
        }

        String helpText = (String) attributes.get("helpText");

        if (helpText != null) {
            setHelpText(helpText);
        }

        Integer characterLimit = (Integer) attributes.get("characterLimit");

        if (characterLimit != null) {
            setCharacterLimit(characterLimit);
        }

        Long focusAreaId = (Long) attributes.get("focusAreaId");

        if (focusAreaId != null) {
            setFocusAreaId(focusAreaId);
        }

        Long tier = (Long) attributes.get("tier");

        if (tier != null) {
            setTier(tier);
        }

        String allowedContestTypeIds = (String) attributes.get(
                "allowedContestTypeIds");

        if (allowedContestTypeIds != null) {
            setAllowedContestTypeIds(allowedContestTypeIds);
        }

        String allowedValues = (String) attributes.get("allowedValues");

        if (allowedValues != null) {
            setAllowedValues(allowedValues);
        }

        String additionalIds = (String) attributes.get("additionalIds");

        if (additionalIds != null) {
            setAdditionalIds(additionalIds);
        }

        Boolean locked = (Boolean) attributes.get("locked");

        if (locked != null) {
            setLocked(locked);
        }

        Boolean contestIntegrationRelevance = (Boolean) attributes.get(
                "contestIntegrationRelevance");

        if (contestIntegrationRelevance != null) {
            setContestIntegrationRelevance(contestIntegrationRelevance);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_planSectionDefinitionRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getType() {
        return _type;
    }

    @Override
    public void setType(String type) {
        _type = type;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setType", String.class);

                method.invoke(_planSectionDefinitionRemoteModel, type);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAdminTitle() {
        return _adminTitle;
    }

    @Override
    public void setAdminTitle(String adminTitle) {
        _adminTitle = adminTitle;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setAdminTitle", String.class);

                method.invoke(_planSectionDefinitionRemoteModel, adminTitle);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_planSectionDefinitionRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDefaultText() {
        return _defaultText;
    }

    @Override
    public void setDefaultText(String defaultText) {
        _defaultText = defaultText;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setDefaultText", String.class);

                method.invoke(_planSectionDefinitionRemoteModel, defaultText);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getHelpText() {
        return _helpText;
    }

    @Override
    public void setHelpText(String helpText) {
        _helpText = helpText;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setHelpText", String.class);

                method.invoke(_planSectionDefinitionRemoteModel, helpText);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getCharacterLimit() {
        return _characterLimit;
    }

    @Override
    public void setCharacterLimit(int characterLimit) {
        _characterLimit = characterLimit;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setCharacterLimit", int.class);

                method.invoke(_planSectionDefinitionRemoteModel, characterLimit);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getFocusAreaId() {
        return _focusAreaId;
    }

    @Override
    public void setFocusAreaId(long focusAreaId) {
        _focusAreaId = focusAreaId;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setFocusAreaId", long.class);

                method.invoke(_planSectionDefinitionRemoteModel, focusAreaId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getTier() {
        return _tier;
    }

    @Override
    public void setTier(long tier) {
        _tier = tier;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setTier", long.class);

                method.invoke(_planSectionDefinitionRemoteModel, tier);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAllowedContestTypeIds() {
        return _allowedContestTypeIds;
    }

    @Override
    public void setAllowedContestTypeIds(String allowedContestTypeIds) {
        _allowedContestTypeIds = allowedContestTypeIds;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setAllowedContestTypeIds",
                        String.class);

                method.invoke(_planSectionDefinitionRemoteModel,
                    allowedContestTypeIds);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAllowedValues() {
        return _allowedValues;
    }

    @Override
    public void setAllowedValues(String allowedValues) {
        _allowedValues = allowedValues;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setAllowedValues", String.class);

                method.invoke(_planSectionDefinitionRemoteModel, allowedValues);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAdditionalIds() {
        return _additionalIds;
    }

    @Override
    public void setAdditionalIds(String additionalIds) {
        _additionalIds = additionalIds;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setAdditionalIds", String.class);

                method.invoke(_planSectionDefinitionRemoteModel, additionalIds);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getLocked() {
        return _locked;
    }

    @Override
    public boolean isLocked() {
        return _locked;
    }

    @Override
    public void setLocked(boolean locked) {
        _locked = locked;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setLocked", boolean.class);

                method.invoke(_planSectionDefinitionRemoteModel, locked);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getContestIntegrationRelevance() {
        return _contestIntegrationRelevance;
    }

    @Override
    public boolean isContestIntegrationRelevance() {
        return _contestIntegrationRelevance;
    }

    @Override
    public void setContestIntegrationRelevance(
        boolean contestIntegrationRelevance) {
        _contestIntegrationRelevance = contestIntegrationRelevance;

        if (_planSectionDefinitionRemoteModel != null) {
            try {
                Class<?> clazz = _planSectionDefinitionRemoteModel.getClass();

                Method method = clazz.getMethod("setContestIntegrationRelevance",
                        boolean.class);

                method.invoke(_planSectionDefinitionRemoteModel,
                    contestIntegrationRelevance);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getPlanSectionDefinitionRemoteModel() {
        return _planSectionDefinitionRemoteModel;
    }

    public void setPlanSectionDefinitionRemoteModel(
        BaseModel<?> planSectionDefinitionRemoteModel) {
        _planSectionDefinitionRemoteModel = planSectionDefinitionRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _planSectionDefinitionRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_planSectionDefinitionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PlanSectionDefinitionLocalServiceUtil.addPlanSectionDefinition(this);
        } else {
            PlanSectionDefinitionLocalServiceUtil.updatePlanSectionDefinition(this);
        }
    }

    @Override
    public PlanSectionDefinition toEscapedModel() {
        return (PlanSectionDefinition) ProxyUtil.newProxyInstance(PlanSectionDefinition.class.getClassLoader(),
            new Class[] { PlanSectionDefinition.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PlanSectionDefinitionClp clone = new PlanSectionDefinitionClp();

        clone.setId(getId());
        clone.setType(getType());
        clone.setAdminTitle(getAdminTitle());
        clone.setTitle(getTitle());
        clone.setDefaultText(getDefaultText());
        clone.setHelpText(getHelpText());
        clone.setCharacterLimit(getCharacterLimit());
        clone.setFocusAreaId(getFocusAreaId());
        clone.setTier(getTier());
        clone.setAllowedContestTypeIds(getAllowedContestTypeIds());
        clone.setAllowedValues(getAllowedValues());
        clone.setAdditionalIds(getAdditionalIds());
        clone.setLocked(getLocked());
        clone.setContestIntegrationRelevance(getContestIntegrationRelevance());

        return clone;
    }

    @Override
    public int compareTo(PlanSectionDefinition planSectionDefinition) {
        long primaryKey = planSectionDefinition.getPrimaryKey();

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

        if (!(obj instanceof PlanSectionDefinitionClp)) {
            return false;
        }

        PlanSectionDefinitionClp planSectionDefinition = (PlanSectionDefinitionClp) obj;

        long primaryKey = planSectionDefinition.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", adminTitle=");
        sb.append(getAdminTitle());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", defaultText=");
        sb.append(getDefaultText());
        sb.append(", helpText=");
        sb.append(getHelpText());
        sb.append(", characterLimit=");
        sb.append(getCharacterLimit());
        sb.append(", focusAreaId=");
        sb.append(getFocusAreaId());
        sb.append(", tier=");
        sb.append(getTier());
        sb.append(", allowedContestTypeIds=");
        sb.append(getAllowedContestTypeIds());
        sb.append(", allowedValues=");
        sb.append(getAllowedValues());
        sb.append(", additionalIds=");
        sb.append(getAdditionalIds());
        sb.append(", locked=");
        sb.append(getLocked());
        sb.append(", contestIntegrationRelevance=");
        sb.append(getContestIntegrationRelevance());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.PlanSectionDefinition");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>adminTitle</column-name><column-value><![CDATA[");
        sb.append(getAdminTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>defaultText</column-name><column-value><![CDATA[");
        sb.append(getDefaultText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>helpText</column-name><column-value><![CDATA[");
        sb.append(getHelpText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>characterLimit</column-name><column-value><![CDATA[");
        sb.append(getCharacterLimit());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>focusAreaId</column-name><column-value><![CDATA[");
        sb.append(getFocusAreaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tier</column-name><column-value><![CDATA[");
        sb.append(getTier());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>allowedContestTypeIds</column-name><column-value><![CDATA[");
        sb.append(getAllowedContestTypeIds());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>allowedValues</column-name><column-value><![CDATA[");
        sb.append(getAllowedValues());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>additionalIds</column-name><column-value><![CDATA[");
        sb.append(getAdditionalIds());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>locked</column-name><column-value><![CDATA[");
        sb.append(getLocked());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contestIntegrationRelevance</column-name><column-value><![CDATA[");
        sb.append(getContestIntegrationRelevance());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
