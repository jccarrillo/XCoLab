package org.xcolab.portlets.search.items;

import com.ext.portlet.model.DiscussionCategoryGroup;
import com.ext.portlet.model.DiscussionMessage;
import com.ext.portlet.service.DiscussionCategoryGroupLocalServiceUtil;
import com.ext.portlet.service.DiscussionMessageLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.xcolab.client.comment.CommentClient;
import org.xcolab.client.comment.exceptions.CommentNotFoundException;
import org.xcolab.client.comment.exceptions.ThreadNotFoundException;
import org.xcolab.client.comment.pojo.Comment;
import org.xcolab.client.comment.pojo.CommentThread;
import org.xcolab.client.search.pojo.SearchPojo;
import org.xcolab.jspTags.discussion.wrappers.ThreadWrapper;

import java.io.IOException;

public class DiscussionSearchItem extends AbstractSearchItem {

    private final static String[] TITLE_FIELDS = {"title"};
    private final static String[] CONTENT_FIELDS = {"content"};

    private DiscussionMessage discussionMessage;
    private DiscussionCategoryGroup categoryGroup;

    private CommentThread thread;

    private Comment comment;

    private String searchQuery;

    @Override
    public void init(SearchPojo pojo, String searchQuery) {
        try {
            comment = CommentClient.getComment(pojo.getClassPrimaryKey());
            thread = CommentClient.getThread(comment.getThreadId());
            this.searchQuery = searchQuery;
        } catch (CommentNotFoundException | ThreadNotFoundException ignored) {

        }
    }

    @Override
    public String getPrintName() {
        return "Discussions";
    }

    @Override
    public String getTitle() {
        String title = thread.getTitle();
        if (StringUtils.isBlank(title)) {
            return "Comment";
        }
        return highlight(title, searchQuery);
    }

    @Override
    public String getLinkUrl() {
        return thread.getLinkUrl();
    }

    @Override
    public String getContent() {
        String content = highlight(this.comment.getContent(), searchQuery);
        return content.substring(0, Math.min(content.length(), MAX_CONTENT_LENGTH)) + " ...";
    }

    @Override
    public boolean isVisible() {
        return ((!getLinkUrl().isEmpty()) && (!thread.getIsQuiet()));
    }
}
