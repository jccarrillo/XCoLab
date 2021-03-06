package com.ext.portlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.service.http.ContestTeamMemberServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.service.http.ContestTeamMemberServiceSoap
 * @generated
 */
public class ContestTeamMemberSoap implements Serializable {
    private long _id;
    private long _contestId;
    private long _userId;
    private long _roleId;

    public ContestTeamMemberSoap() {
    }

    public static ContestTeamMemberSoap toSoapModel(ContestTeamMember model) {
        ContestTeamMemberSoap soapModel = new ContestTeamMemberSoap();

        soapModel.setId(model.getId());
        soapModel.setContestId(model.getContestId());
        soapModel.setUserId(model.getUserId());
        soapModel.setRoleId(model.getRoleId());

        return soapModel;
    }

    public static ContestTeamMemberSoap[] toSoapModels(
        ContestTeamMember[] models) {
        ContestTeamMemberSoap[] soapModels = new ContestTeamMemberSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContestTeamMemberSoap[][] toSoapModels(
        ContestTeamMember[][] models) {
        ContestTeamMemberSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContestTeamMemberSoap[models.length][models[0].length];
        } else {
            soapModels = new ContestTeamMemberSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContestTeamMemberSoap[] toSoapModels(
        List<ContestTeamMember> models) {
        List<ContestTeamMemberSoap> soapModels = new ArrayList<ContestTeamMemberSoap>(models.size());

        for (ContestTeamMember model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContestTeamMemberSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getContestId() {
        return _contestId;
    }

    public void setContestId(long contestId) {
        _contestId = contestId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getRoleId() {
        return _roleId;
    }

    public void setRoleId(long roleId) {
        _roleId = roleId;
    }
}
