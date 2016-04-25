package org.xcolab.service.contents.service.contentarticleversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xcolab.model.tables.pojos.ContentArticleVersion;
import org.xcolab.service.contents.domain.contentarticleversion.ContentArticleVersionDao;

@Service
public class ContentArticleVersionService {

    private final ContentArticleVersionDao contentArticleVersionDao;

    @Autowired
    public ContentArticleVersionService(ContentArticleVersionDao contentArticleVersionDao) {
        this.contentArticleVersionDao = contentArticleVersionDao;
    }

    public ContentArticleVersion create(ContentArticleVersion contentArticle) {
        return this.contentArticleVersionDao.create(contentArticle);
    }

    public void update(ContentArticleVersion contentArticle) {
        this.contentArticleVersionDao.update(contentArticle);
    }

    public ContentArticleVersion get(Long contentArticleId) {
        return this.contentArticleVersionDao.get(contentArticleId);
    }
}