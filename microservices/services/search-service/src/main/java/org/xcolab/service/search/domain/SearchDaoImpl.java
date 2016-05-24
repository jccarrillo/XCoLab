package org.xcolab.service.search.domain;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.xcolab.service.search.wrappers.SearchResult;
import org.xcolab.service.utils.PaginationHelper;
import org.xcolab.service.utils.db.jooq.fulltext.FulltextCondition;

import java.util.List;

import static org.xcolab.model.Tables.MEMBER;
import static org.xcolab.model.Tables.PROPOSAL_ATTRIBUTE;
import static org.xcolab.service.utils.db.jooq.CustomDsl.match;

@Repository
public class SearchDaoImpl implements SearchDao {

    @Autowired
    private DSLContext dslContext;

    @Override
    public List<SearchResult> searchProposalAttributes(PaginationHelper paginationHelper,
            String query) {
        final FulltextCondition fulltextCondition =
                match(PROPOSAL_ATTRIBUTE.STRING_VALUE).against(query);
        final Field<Double> relevance = fulltextCondition.as("relevance");
        return dslContext.select(PROPOSAL_ATTRIBUTE.STRING_VALUE.as("title"),
                        PROPOSAL_ATTRIBUTE.STRING_VALUE.as("content"), relevance)
                .from(PROPOSAL_ATTRIBUTE)
                .where(fulltextCondition)
                .orderBy(relevance.desc())
                .limit(paginationHelper.getStartRecord(), paginationHelper.getLimitRecord())
                .fetchInto(SearchResult.class);
    }

    @Override
    public List<SearchResult> searchMembers(PaginationHelper paginationHelper, String query) {
        final FulltextCondition fulltextCondition =
                match(MEMBER.FIRST_NAME, MEMBER.LAST_NAME, MEMBER.SHORT_BIO, MEMBER.SCREEN_NAME)
                        .against(query);
        final Field<Double> relevance = fulltextCondition.as("relevance");
        return dslContext.select(
                    MEMBER.FIRST_NAME.concat(" ")
                            .concat(MEMBER.LAST_NAME).concat(" (")
                            .concat(MEMBER.SCREEN_NAME).concat(")")
                            .as("title"),
                    MEMBER.SHORT_BIO.as("content"), relevance)
                .from(MEMBER)
                .where(fulltextCondition)
                .orderBy(relevance.desc())
                .limit(paginationHelper.getStartRecord(), paginationHelper.getLimitRecord())
                .fetchInto(SearchResult.class);
    }
}
