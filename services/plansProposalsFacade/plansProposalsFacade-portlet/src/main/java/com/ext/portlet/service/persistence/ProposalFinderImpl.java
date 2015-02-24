package com.ext.portlet.service.persistence;

import com.ext.portlet.model.PlanItem;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.ProposalRating;
import com.ext.portlet.model.impl.PlanItemImpl;
import com.ext.portlet.model.impl.PlanItemModelImpl;
import com.ext.portlet.model.impl.ProposalImpl;
import com.ext.portlet.model.impl.ProposalModelImpl;
import com.ext.portlet.model.impl.ProposalRatingImpl;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
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

    public static final String FINDER_CLASS_NAME_ENTITY = Proposal.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY + ".List";

    private static final FinderPath FINDER_PATH_FETCH_BY_CONTEST_PHASE_ID_AND_VISIBLE;
    static {
        FINDER_PATH_FETCH_BY_CONTEST_PHASE_ID_AND_VISIBLE = new FinderPath(ProposalModelImpl.ENTITY_CACHE_ENABLED,
                ProposalModelImpl.FINDER_CACHE_ENABLED, ProposalImpl.class, FINDER_CLASS_NAME_LIST,
                "fetchByContestPhaseIdAndVisible", new String[] {Long.class.getName()});
    }

    public List<Proposal> findByContestPhaseIdAndVisible(long contestPhaseId, int start, int end) throws SystemException {
        Object[] args = new Object[] { contestPhaseId };

        List<Proposal> matchingProposals = (List<Proposal>)
                FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONTEST_PHASE_ID_AND_VISIBLE, args, this);

        if (matchingProposals == null) {
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

                matchingProposals = (List<Proposal>) QueryUtil.list(q, getDialect(), start, end);

                if (matchingProposals != null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTEST_PHASE_ID_AND_VISIBLE, args, matchingProposals);
                }
            } catch (Exception e) {
                try {
                    throw new SystemException(e);
                } catch (SystemException se) {
                    se.printStackTrace();
                }
            } finally {
                closeSession(session);
            }
        }

        return matchingProposals;
    }

    public static final String FIND_BY_CONTEST_PHASE_ID_AND_VISIBLE =
            ProposalFinder.class.getName() +
                    ".findByContestPhaseIdAndVisible";
}
