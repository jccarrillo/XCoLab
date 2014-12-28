package com.ext.portlet.service.persistence;

import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.ProposalRating;
import com.ext.portlet.model.impl.ProposalImpl;
import com.ext.portlet.model.impl.ProposalRatingImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;

/**
 * Created by kmang on 28/12/14.
 */


public class ProposalFinderImpl extends BasePersistenceImpl<Proposal> implements ProposalFinder {

    public List<Proposal> findByContestPhaseIdAndVisible(long contestPhaseId, int start, int end) throws SystemException {
        Session session = null;
        try {
            session = openSession();

            String sql = CustomSQLUtil.get(FIND_BY_CONTEST_PHASE_ID_AND_VISIBLE);

            SQLQuery q = session.createSQLQuery(sql);
            q.setCacheable(true);
            q.addEntity("xcolab_Proposal", ProposalImpl.class);

            QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(contestPhaseId);
            qPos.add(contestPhaseId);

            return (List<Proposal>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            try {
                throw new SystemException(e);
            } catch (SystemException se) {
                se.printStackTrace();
            }
        } finally {
            closeSession(session);
        }

        return null;
    }

    public static final String FIND_BY_CONTEST_PHASE_ID_AND_VISIBLE =
            ProposalFinder.class.getName() +
                    ".findByContestPhaseIdAndVisible";
}
