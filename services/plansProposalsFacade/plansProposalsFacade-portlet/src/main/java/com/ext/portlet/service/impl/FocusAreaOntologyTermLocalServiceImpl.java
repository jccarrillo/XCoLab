package com.ext.portlet.service.impl;

import com.ext.portlet.model.FocusArea;
import com.ext.portlet.model.FocusAreaOntologyTerm;
import com.ext.portlet.model.OntologyTerm;
import com.ext.portlet.service.FocusAreaLocalServiceUtil;
import com.ext.portlet.service.FocusAreaOntologyTermLocalServiceUtil;
import com.ext.portlet.service.OntologyTermLocalServiceUtil;
import com.ext.portlet.service.base.FocusAreaOntologyTermLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;

import java.util.List;

/**
 * The implementation of the focus area ontology term local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.service.FocusAreaOntologyTermLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.service.base.FocusAreaOntologyTermLocalServiceBaseImpl
 * @see com.ext.portlet.service.FocusAreaOntologyTermLocalServiceUtil
 */
public class FocusAreaOntologyTermLocalServiceImpl
    extends FocusAreaOntologyTermLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ext.portlet.service.FocusAreaOntologyTermLocalServiceUtil} to access the focus area ontology term local service.
     */

    @Override
    public List<FocusAreaOntologyTerm> findTermsByFocusArea(Long focusAreaId) throws SystemException {
        return focusAreaOntologyTermPersistence.findByFocusAreaId(focusAreaId);
    }
    
    @Override
    public void addAreaTerm(Long focusAreaId, Long termId) throws PortalException, SystemException {
        FocusArea fa = FocusAreaLocalServiceUtil.getFocusArea(focusAreaId);
        FocusAreaLocalServiceUtil.addTerm(fa, termId);
    }
    
    @Override
    public void removeAreaTerm(Long focusAreaId, Long termId) throws PortalException, SystemException {
        FocusArea fa = FocusAreaLocalServiceUtil.getFocusArea(focusAreaId);
        FocusAreaLocalServiceUtil.removeTerm(fa, termId);
        
    }
    
    
    @Override
    public void store(FocusAreaOntologyTerm faot) throws SystemException {
        if (faot.isNew()) {
            FocusAreaOntologyTermLocalServiceUtil.addFocusAreaOntologyTerm(faot);
        }
        else {
            FocusAreaOntologyTermLocalServiceUtil.updateFocusAreaOntologyTerm(faot);
        }
    }
    
    @Override
    public OntologyTerm getTerm(FocusAreaOntologyTerm faot) throws PortalException, SystemException {
        return OntologyTermLocalServiceUtil.getOntologyTerm(faot.getOntologyTermId());
    }
    
    @Override
    public FocusArea getArea(FocusAreaOntologyTerm faot) throws PortalException, SystemException {
        return FocusAreaLocalServiceUtil.getFocusArea(faot.getFocusAreaId());
    }

    @Override
    public List<Long> getFocusAreaOntologyTermIdsByFocusAreaAndSpaceId(long focusAreaId, long ontologySpaceId)
            throws PortalException, SystemException {
        long ontologyTermId = getOntologyTermIdByFocusAreaAndSpaceId(focusAreaId, ontologySpaceId);
        return getFocusAreaIdsByOntologyTermId(ontologyTermId);
    }

    private long getOntologyTermIdByFocusAreaAndSpaceId(Long focusAreaId, Long ontologySpaceId)
            throws SystemException, PortalException {
        List<FocusAreaOntologyTerm> ontologyTermsForFocusArea;

        DynamicQuery retrieveOntologyTermsForFocusArea =
                DynamicQueryFactoryUtil.forClass(FocusAreaOntologyTerm.class, PortletClassLoaderUtil.getClassLoader())
                        .add(PropertyFactoryUtil.forName("primaryKey.focusAreaId").eq(focusAreaId));
        ontologyTermsForFocusArea = FocusAreaOntologyTermLocalServiceUtil.dynamicQuery(retrieveOntologyTermsForFocusArea);

        for(FocusAreaOntologyTerm focusAreaOntologyTerm : ontologyTermsForFocusArea){
            long FocusAreaOntologyTermOntologyTermId = focusAreaOntologyTerm.getOntologyTermId();
            OntologyTerm ontologyTerm =  OntologyTermLocalServiceUtil.getOntologyTerm(FocusAreaOntologyTermOntologyTermId);
            if(ontologyTerm.getOntologySpaceId() == ontologySpaceId){
                return ontologyTerm.getId();
            }
        }

        throw new PortalException("Could not find ontologyTermId for focusAreaId: " + focusAreaId.toString() +
                " and ontologySpaceId: " + ontologySpaceId.toString());
    }

    private List<Long> getFocusAreaIdsByOntologyTermId(Long ontologyTermId) throws SystemException {

        ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
        projectionList.add(ProjectionFactoryUtil.property("primaryKey.focusAreaId"));

        DynamicQuery retrieveFocusAreaOntologyTerms =
                DynamicQueryFactoryUtil.forClass(FocusAreaOntologyTerm.class, PortletClassLoaderUtil.getClassLoader())
                        .add(PropertyFactoryUtil.forName("primaryKey.ontologyTermId").eq(ontologyTermId))
                        .setProjection(projectionList);

        return FocusAreaOntologyTermLocalServiceUtil.dynamicQuery(retrieveFocusAreaOntologyTerms);
    }
}
