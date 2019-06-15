package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsOwnerHonorDTO {

    /**
     *HONOR_ID
    **/
    @JSONField(name="honorId")
    private String honorId;

    /**
     *OWNER_ID
    **/
    @JSONField(name="ownerId")
    private String ownerId;

    /**
     *荣誉级别
    **/
    @JSONField(name="honorLevel")
    private String honorLevel;

    /**
     *荣誉名称
    **/
    @JSONField(name="honorTitle")
    private String honorTitle;

    /**
     *荣誉描述
    **/
    @JSONField(name="honorDesc")
    private String honorDesc;

    /**
     *获得日期
    **/
    @JSONField(name="honorDate")
    private String honorDate;

    /**
     *备注
    **/
    @JSONField(name="remark")
    private String remark;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private String iseffect;

    /**
     *创建人
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *创建日期
    **/
    @JSONField(name="credate")
    private String credate;

    /**
     *创建时间
    **/
    @JSONField(name="cretime")
    private String cretime;

    /**
     *修改人
    **/
    @JSONField(name="ediusrcode")
    private String ediusrcode;

    /**
     *修改日期
    **/
    @JSONField(name="edidate")
    private String edidate;

    /**
     *修改时间
    **/
    @JSONField(name="editime")
    private String editime;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *审核状态,0-未上报，1-未审核，2-审核通过，3-审核不通过
    **/
    @JSONField(name="auditStatus")
    private String auditStatus;

    /**
     *审核意见
    **/
    @JSONField(name="auditContent")
    private String auditContent;

    /**
     *审核机构
    **/
    @JSONField(name="auditDep")
    private String auditDep;

    /**
     *审核人
    **/
    @JSONField(name="auditUsr")
    private String auditUsr;

    /**
     *审核时间
    **/
    @JSONField(name="auditDate")
    private String auditDate;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getHonorId() {
        return honorId;
    }

    public void setHonorId(String honorId) {
        this.honorId = honorId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getHonorLevel() {
        return honorLevel;
    }

    public void setHonorLevel(String honorLevel) {
        this.honorLevel = honorLevel;
    }

    public String getHonorTitle() {
        return honorTitle;
    }

    public void setHonorTitle(String honorTitle) {
        this.honorTitle = honorTitle;
    }

    public String getHonorDesc() {
        return honorDesc;
    }

    public void setHonorDesc(String honorDesc) {
        this.honorDesc = honorDesc;
    }

    public String getHonorDate() {
        return honorDate;
    }

    public void setHonorDate(String honorDate) {
        this.honorDate = honorDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIseffect() {
        return iseffect;
    }

    public void setIseffect(String iseffect) {
        this.iseffect = iseffect;
    }

    public String getCreusrcode() {
        return creusrcode;
    }

    public void setCreusrcode(String creusrcode) {
        this.creusrcode = creusrcode;
    }

    public String getCredate() {
        return credate;
    }

    public void setCredate(String credate) {
        this.credate = credate;
    }

    public String getCretime() {
        return cretime;
    }

    public void setCretime(String cretime) {
        this.cretime = cretime;
    }

    public String getEdiusrcode() {
        return ediusrcode;
    }

    public void setEdiusrcode(String ediusrcode) {
        this.ediusrcode = ediusrcode;
    }

    public String getEdidate() {
        return edidate;
    }

    public void setEdidate(String edidate) {
        this.edidate = edidate;
    }

    public String getEditime() {
        return editime;
    }

    public void setEditime(String editime) {
        this.editime = editime;
    }

    public Double getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(Double sysopertime) {
        this.sysopertime = sysopertime;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent;
    }

    public String getAuditDep() {
        return auditDep;
    }

    public void setAuditDep(String auditDep) {
        this.auditDep = auditDep;
    }

    public String getAuditUsr() {
        return auditUsr;
    }

    public void setAuditUsr(String auditUsr) {
        this.auditUsr = auditUsr;
    }

    public String getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(String auditDate) {
        this.auditDate = auditDate;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}