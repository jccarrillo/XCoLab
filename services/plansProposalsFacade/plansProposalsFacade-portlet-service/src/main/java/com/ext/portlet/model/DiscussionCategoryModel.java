package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DiscussionCategory service. Represents a row in the &quot;xcolab_DiscussionCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.DiscussionCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.DiscussionCategoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DiscussionCategory
 * @see com.ext.portlet.model.impl.DiscussionCategoryImpl
 * @see com.ext.portlet.model.impl.DiscussionCategoryModelImpl
 * @generated
 */
public interface DiscussionCategoryModel extends BaseModel<DiscussionCategory> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a discussion category model instance should use the {@link DiscussionCategory} interface instead.
     */

    /**
     * Returns the primary key of this discussion category.
     *
     * @return the primary key of this discussion category
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this discussion category.
     *
     * @param primaryKey the primary key of this discussion category
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the pk of this discussion category.
     *
     * @return the pk of this discussion category
     */
    public long getPk();

    /**
     * Sets the pk of this discussion category.
     *
     * @param pk the pk of this discussion category
     */
    public void setPk(long pk);

    /**
     * Returns the category ID of this discussion category.
     *
     * @return the category ID of this discussion category
     */
    public long getCategoryId();

    /**
     * Sets the category ID of this discussion category.
     *
     * @param categoryId the category ID of this discussion category
     */
    public void setCategoryId(long categoryId);

    /**
     * Returns the category group ID of this discussion category.
     *
     * @return the category group ID of this discussion category
     */
    public long getCategoryGroupId();

    /**
     * Sets the category group ID of this discussion category.
     *
     * @param categoryGroupId the category group ID of this discussion category
     */
    public void setCategoryGroupId(long categoryGroupId);

    /**
     * Returns the author ID of this discussion category.
     *
     * @return the author ID of this discussion category
     */
    public long getAuthorId();

    /**
     * Sets the author ID of this discussion category.
     *
     * @param authorId the author ID of this discussion category
     */
    public void setAuthorId(long authorId);

    /**
     * Returns the name of this discussion category.
     *
     * @return the name of this discussion category
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this discussion category.
     *
     * @param name the name of this discussion category
     */
    public void setName(String name);

    /**
     * Returns the description of this discussion category.
     *
     * @return the description of this discussion category
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this discussion category.
     *
     * @param description the description of this discussion category
     */
    public void setDescription(String description);

    /**
     * Returns the create date of this discussion category.
     *
     * @return the create date of this discussion category
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this discussion category.
     *
     * @param createDate the create date of this discussion category
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the deleted of this discussion category.
     *
     * @return the deleted of this discussion category
     */
    public Date getDeleted();

    /**
     * Sets the deleted of this discussion category.
     *
     * @param deleted the deleted of this discussion category
     */
    public void setDeleted(Date deleted);

    /**
     * Returns the threads count of this discussion category.
     *
     * @return the threads count of this discussion category
     */
    public int getThreadsCount();

    /**
     * Sets the threads count of this discussion category.
     *
     * @param threadsCount the threads count of this discussion category
     */
    public void setThreadsCount(int threadsCount);

    /**
     * Returns the last activity date of this discussion category.
     *
     * @return the last activity date of this discussion category
     */
    public Date getLastActivityDate();

    /**
     * Sets the last activity date of this discussion category.
     *
     * @param lastActivityDate the last activity date of this discussion category
     */
    public void setLastActivityDate(Date lastActivityDate);

    /**
     * Returns the last activity author ID of this discussion category.
     *
     * @return the last activity author ID of this discussion category
     */
    public long getLastActivityAuthorId();

    /**
     * Sets the last activity author ID of this discussion category.
     *
     * @param lastActivityAuthorId the last activity author ID of this discussion category
     */
    public void setLastActivityAuthorId(long lastActivityAuthorId);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(
        com.ext.portlet.model.DiscussionCategory discussionCategory);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.DiscussionCategory> toCacheModel();

    @Override
    public com.ext.portlet.model.DiscussionCategory toEscapedModel();

    @Override
    public com.ext.portlet.model.DiscussionCategory toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
