package com.ext.portlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PlanSectionDefinition}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanSectionDefinition
 * @generated
 */
public class PlanSectionDefinitionWrapper implements PlanSectionDefinition,
    ModelWrapper<PlanSectionDefinition> {
    private PlanSectionDefinition _planSectionDefinition;

    public PlanSectionDefinitionWrapper(
        PlanSectionDefinition planSectionDefinition) {
        _planSectionDefinition = planSectionDefinition;
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

    /**
    * Returns the primary key of this plan section definition.
    *
    * @return the primary key of this plan section definition
    */
    @Override
    public long getPrimaryKey() {
        return _planSectionDefinition.getPrimaryKey();
    }

    /**
    * Sets the primary key of this plan section definition.
    *
    * @param primaryKey the primary key of this plan section definition
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _planSectionDefinition.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this plan section definition.
    *
    * @return the ID of this plan section definition
    */
    @Override
    public long getId() {
        return _planSectionDefinition.getId();
    }

    /**
    * Sets the ID of this plan section definition.
    *
    * @param id the ID of this plan section definition
    */
    @Override
    public void setId(long id) {
        _planSectionDefinition.setId(id);
    }

    /**
    * Returns the type of this plan section definition.
    *
    * @return the type of this plan section definition
    */
    @Override
    public java.lang.String getType() {
        return _planSectionDefinition.getType();
    }

    /**
    * Sets the type of this plan section definition.
    *
    * @param type the type of this plan section definition
    */
    @Override
    public void setType(java.lang.String type) {
        _planSectionDefinition.setType(type);
    }

    /**
    * Returns the admin title of this plan section definition.
    *
    * @return the admin title of this plan section definition
    */
    @Override
    public java.lang.String getAdminTitle() {
        return _planSectionDefinition.getAdminTitle();
    }

    /**
    * Sets the admin title of this plan section definition.
    *
    * @param adminTitle the admin title of this plan section definition
    */
    @Override
    public void setAdminTitle(java.lang.String adminTitle) {
        _planSectionDefinition.setAdminTitle(adminTitle);
    }

    /**
    * Returns the title of this plan section definition.
    *
    * @return the title of this plan section definition
    */
    @Override
    public java.lang.String getTitle() {
        return _planSectionDefinition.getTitle();
    }

    /**
    * Sets the title of this plan section definition.
    *
    * @param title the title of this plan section definition
    */
    @Override
    public void setTitle(java.lang.String title) {
        _planSectionDefinition.setTitle(title);
    }

    /**
    * Returns the default text of this plan section definition.
    *
    * @return the default text of this plan section definition
    */
    @Override
    public java.lang.String getDefaultText() {
        return _planSectionDefinition.getDefaultText();
    }

    /**
    * Sets the default text of this plan section definition.
    *
    * @param defaultText the default text of this plan section definition
    */
    @Override
    public void setDefaultText(java.lang.String defaultText) {
        _planSectionDefinition.setDefaultText(defaultText);
    }

    /**
    * Returns the help text of this plan section definition.
    *
    * @return the help text of this plan section definition
    */
    @Override
    public java.lang.String getHelpText() {
        return _planSectionDefinition.getHelpText();
    }

    /**
    * Sets the help text of this plan section definition.
    *
    * @param helpText the help text of this plan section definition
    */
    @Override
    public void setHelpText(java.lang.String helpText) {
        _planSectionDefinition.setHelpText(helpText);
    }

    /**
    * Returns the character limit of this plan section definition.
    *
    * @return the character limit of this plan section definition
    */
    @Override
    public int getCharacterLimit() {
        return _planSectionDefinition.getCharacterLimit();
    }

    /**
    * Sets the character limit of this plan section definition.
    *
    * @param characterLimit the character limit of this plan section definition
    */
    @Override
    public void setCharacterLimit(int characterLimit) {
        _planSectionDefinition.setCharacterLimit(characterLimit);
    }

    /**
    * Returns the focus area ID of this plan section definition.
    *
    * @return the focus area ID of this plan section definition
    */
    @Override
    public long getFocusAreaId() {
        return _planSectionDefinition.getFocusAreaId();
    }

    /**
    * Sets the focus area ID of this plan section definition.
    *
    * @param focusAreaId the focus area ID of this plan section definition
    */
    @Override
    public void setFocusAreaId(long focusAreaId) {
        _planSectionDefinition.setFocusAreaId(focusAreaId);
    }

    /**
    * Returns the tier of this plan section definition.
    *
    * @return the tier of this plan section definition
    */
    @Override
    public long getTier() {
        return _planSectionDefinition.getTier();
    }

    /**
    * Sets the tier of this plan section definition.
    *
    * @param tier the tier of this plan section definition
    */
    @Override
    public void setTier(long tier) {
        _planSectionDefinition.setTier(tier);
    }

    /**
    * Returns the allowed contest type IDs of this plan section definition.
    *
    * @return the allowed contest type IDs of this plan section definition
    */
    @Override
    public java.lang.String getAllowedContestTypeIds() {
        return _planSectionDefinition.getAllowedContestTypeIds();
    }

    /**
    * Sets the allowed contest type IDs of this plan section definition.
    *
    * @param allowedContestTypeIds the allowed contest type IDs of this plan section definition
    */
    @Override
    public void setAllowedContestTypeIds(java.lang.String allowedContestTypeIds) {
        _planSectionDefinition.setAllowedContestTypeIds(allowedContestTypeIds);
    }

    /**
    * Returns the allowed values of this plan section definition.
    *
    * @return the allowed values of this plan section definition
    */
    @Override
    public java.lang.String getAllowedValues() {
        return _planSectionDefinition.getAllowedValues();
    }

    /**
    * Sets the allowed values of this plan section definition.
    *
    * @param allowedValues the allowed values of this plan section definition
    */
    @Override
    public void setAllowedValues(java.lang.String allowedValues) {
        _planSectionDefinition.setAllowedValues(allowedValues);
    }

    /**
    * Returns the additional IDs of this plan section definition.
    *
    * @return the additional IDs of this plan section definition
    */
    @Override
    public java.lang.String getAdditionalIds() {
        return _planSectionDefinition.getAdditionalIds();
    }

    /**
    * Sets the additional IDs of this plan section definition.
    *
    * @param additionalIds the additional IDs of this plan section definition
    */
    @Override
    public void setAdditionalIds(java.lang.String additionalIds) {
        _planSectionDefinition.setAdditionalIds(additionalIds);
    }

    /**
    * Returns the locked of this plan section definition.
    *
    * @return the locked of this plan section definition
    */
    @Override
    public boolean getLocked() {
        return _planSectionDefinition.getLocked();
    }

    /**
    * Returns <code>true</code> if this plan section definition is locked.
    *
    * @return <code>true</code> if this plan section definition is locked; <code>false</code> otherwise
    */
    @Override
    public boolean isLocked() {
        return _planSectionDefinition.isLocked();
    }

    /**
    * Sets whether this plan section definition is locked.
    *
    * @param locked the locked of this plan section definition
    */
    @Override
    public void setLocked(boolean locked) {
        _planSectionDefinition.setLocked(locked);
    }

    /**
    * Returns the contest integration relevance of this plan section definition.
    *
    * @return the contest integration relevance of this plan section definition
    */
    @Override
    public boolean getContestIntegrationRelevance() {
        return _planSectionDefinition.getContestIntegrationRelevance();
    }

    /**
    * Returns <code>true</code> if this plan section definition is contest integration relevance.
    *
    * @return <code>true</code> if this plan section definition is contest integration relevance; <code>false</code> otherwise
    */
    @Override
    public boolean isContestIntegrationRelevance() {
        return _planSectionDefinition.isContestIntegrationRelevance();
    }

    /**
    * Sets whether this plan section definition is contest integration relevance.
    *
    * @param contestIntegrationRelevance the contest integration relevance of this plan section definition
    */
    @Override
    public void setContestIntegrationRelevance(
        boolean contestIntegrationRelevance) {
        _planSectionDefinition.setContestIntegrationRelevance(contestIntegrationRelevance);
    }

    @Override
    public boolean isNew() {
        return _planSectionDefinition.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _planSectionDefinition.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _planSectionDefinition.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _planSectionDefinition.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _planSectionDefinition.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _planSectionDefinition.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _planSectionDefinition.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _planSectionDefinition.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _planSectionDefinition.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _planSectionDefinition.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _planSectionDefinition.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PlanSectionDefinitionWrapper((PlanSectionDefinition) _planSectionDefinition.clone());
    }

    @Override
    public int compareTo(
        com.ext.portlet.model.PlanSectionDefinition planSectionDefinition) {
        return _planSectionDefinition.compareTo(planSectionDefinition);
    }

    @Override
    public int hashCode() {
        return _planSectionDefinition.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.ext.portlet.model.PlanSectionDefinition> toCacheModel() {
        return _planSectionDefinition.toCacheModel();
    }

    @Override
    public com.ext.portlet.model.PlanSectionDefinition toEscapedModel() {
        return new PlanSectionDefinitionWrapper(_planSectionDefinition.toEscapedModel());
    }

    @Override
    public com.ext.portlet.model.PlanSectionDefinition toUnescapedModel() {
        return new PlanSectionDefinitionWrapper(_planSectionDefinition.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _planSectionDefinition.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _planSectionDefinition.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _planSectionDefinition.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PlanSectionDefinitionWrapper)) {
            return false;
        }

        PlanSectionDefinitionWrapper planSectionDefinitionWrapper = (PlanSectionDefinitionWrapper) obj;

        if (Validator.equals(_planSectionDefinition,
                    planSectionDefinitionWrapper._planSectionDefinition)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public PlanSectionDefinition getWrappedPlanSectionDefinition() {
        return _planSectionDefinition;
    }

    @Override
    public PlanSectionDefinition getWrappedModel() {
        return _planSectionDefinition;
    }

    @Override
    public void resetOriginalValues() {
        _planSectionDefinition.resetOriginalValues();
    }
}
