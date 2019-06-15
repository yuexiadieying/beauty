package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsEntStabilityDTO {

    /**
     *上访ID
    **/
    @JSONField(name="stabId")
    private String stabId;

    /**
     *OWNER_ID
    **/
    @JSONField(name="ownerId")
    private String ownerId;

    /**
     *违规上访情况简介
    **/
    @JSONField(name="stabInfo")
    private String stabInfo;

    /**
     *事件时间
    **/
    @JSONField(name="eventTime")
    private String eventTime;

    /**
     *主要原因
    **/
    @JSONField(name="stabReason")
    private String stabReason;

    /**
     *事件经过
    **/
    @JSONField(name="stabDetail")
    private String stabDetail;

    /**
     *参加人数
    **/
    @JSONField(name="stabPersons")
    private Double stabPersons;

    /**
     *上访地址
    **/
    @JSONField(name="stabUpdepart")
    private String stabUpdepart;

    /**
     *社会影响
    **/
    @JSONField(name="socialInfluence")
    private String socialInfluence;

    /**
     *车辆ID
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

    /**
     *投诉人
    **/
    @JSONField(name="complainspn")
    private String complainspn;

    /**
     *来访车号
    **/
    @JSONField(name="visitcarnum")
    private String visitcarnum;

    /**
     *反映问题
    **/
    @JSONField(name="reflexsituation")
    private String reflexsituation;

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
     *信用信息来源
    **/
    @JSONField(name="eventSource")
    private String eventSource;

    /**
     *处理情况
    **/
    @JSONField(name="dealResult")
    private String dealResult;

    /**
     *扣分分值
    **/
    @JSONField(name="stabScore")
    private Double stabScore;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getStabId() {
        return stabId;
    }

    public void setStabId(String stabId) {
        this.stabId = stabId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getStabInfo() {
        return stabInfo;
    }

    public void setStabInfo(String stabInfo) {
        this.stabInfo = stabInfo;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getStabReason() {
        return stabReason;
    }

    public void setStabReason(String stabReason) {
        this.stabReason = stabReason;
    }

    public String getStabDetail() {
        return stabDetail;
    }

    public void setStabDetail(String stabDetail) {
        this.stabDetail = stabDetail;
    }

    public Double getStabPersons() {
        return stabPersons;
    }

    public void setStabPersons(Double stabPersons) {
        this.stabPersons = stabPersons;
    }

    public String getStabUpdepart() {
        return stabUpdepart;
    }

    public void setStabUpdepart(String stabUpdepart) {
        this.stabUpdepart = stabUpdepart;
    }

    public String getSocialInfluence() {
        return socialInfluence;
    }

    public void setSocialInfluence(String socialInfluence) {
        this.socialInfluence = socialInfluence;
    }

    public String getCmvecid() {
        return cmvecid;
    }

    public void setCmvecid(String cmvecid) {
        this.cmvecid = cmvecid;
    }

    public String getComplainspn() {
        return complainspn;
    }

    public void setComplainspn(String complainspn) {
        this.complainspn = complainspn;
    }

    public String getVisitcarnum() {
        return visitcarnum;
    }

    public void setVisitcarnum(String visitcarnum) {
        this.visitcarnum = visitcarnum;
    }

    public String getReflexsituation() {
        return reflexsituation;
    }

    public void setReflexsituation(String reflexsituation) {
        this.reflexsituation = reflexsituation;
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

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public Double getStabScore() {
        return stabScore;
    }

    public void setStabScore(Double stabScore) {
        this.stabScore = stabScore;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}