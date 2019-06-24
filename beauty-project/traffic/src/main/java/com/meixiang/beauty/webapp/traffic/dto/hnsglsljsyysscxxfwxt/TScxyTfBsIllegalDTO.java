package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsIllegalDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *违法ID
    **/
    @JSONField(name="illegalId")
    private String illegalId;

    /**
     *OWNER_ID
    **/
    @JSONField(name="ownerId")
    private String ownerId;

    /**
     *案由ID
    **/
    @JSONField(name="caseId")
    private String caseId;

    /**
     *执法单号
    **/
    @JSONField(name="caseNo")
    private String caseNo;

    /**
     *违法日期
    **/
    @JSONField(name="illegalDate")
    private String illegalDate;

    /**
     *违法时间
    **/
    @JSONField(name="illegalTime")
    private String illegalTime;

    /**
     *责任人
    **/
    @JSONField(name="dutyPerson")
    private String dutyPerson;

    /**
     *违法地点
    **/
    @JSONField(name="illegalPlace")
    private String illegalPlace;

    /**
     *违法事实
    **/
    @JSONField(name="illegalFact")
    private String illegalFact;

    /**
     *处罚情况
    **/
    @JSONField(name="illegalPublish")
    private String illegalPublish;

    /**
     *违法处罚日期
    **/
    @JSONField(name="publishDate")
    private String publishDate;

    /**
     *处罚机关
    **/
    @JSONField(name="publishOrg")
    private String publishOrg;

    /**
     *车辆ID
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

    /**
     *当事人ID
    **/
    @JSONField(name="cmpsnid")
    private String cmpsnid;

    /**
     *记录人
    **/
    @JSONField(name="recorder")
    private String recorder;

    /**
     *执法人员1
    **/
    @JSONField(name="lawPeerson1")
    private String lawPeerson1;

    /**
     *执法证号1
    **/
    @JSONField(name="lawPsnNo1")
    private String lawPsnNo1;

    /**
     *执法人员2
    **/
    @JSONField(name="lawPerson2")
    private String lawPerson2;

    /**
     *执法证号2
    **/
    @JSONField(name="lawPsnNo2")
    private String lawPsnNo2;

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
     *详见字典AUDIT_STATUS
    **/
    @JSONField(name="auditStatus")
    private String auditStatus;

    /**
     *人员扣分
    **/
    @JSONField(name="lostPoint")
    private Double lostPoint;

    /**
     *审核意见
    **/
    @JSONField(name="auditContent")
    private String auditContent;

    /**
     *从业资格证编号
    **/
    @JSONField(name="enbeworrecordid")
    private String enbeworrecordid;

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
     *从业指标ID
    **/
    @JSONField(name="targetId")
    private String targetId;

    @JSONField(name="busScore")
    private Integer busScore;

    @JSONField(name="cbIds")
    private String cbIds;

    /**
     *信用信息来源
    **/
    @JSONField(name="eventSource")
    private String eventSource;

    /**
     *身份证号
    **/
    @JSONField(name="cardno")
    private String cardno;

    /**
     *驾驶员姓名
    **/
    @JSONField(name="drivername")
    private String drivername;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getIllegalId() {
        return illegalId;
    }

    public void setIllegalId(String illegalId) {
        this.illegalId = illegalId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getIllegalDate() {
        return illegalDate;
    }

    public void setIllegalDate(String illegalDate) {
        this.illegalDate = illegalDate;
    }

    public String getIllegalTime() {
        return illegalTime;
    }

    public void setIllegalTime(String illegalTime) {
        this.illegalTime = illegalTime;
    }

    public String getDutyPerson() {
        return dutyPerson;
    }

    public void setDutyPerson(String dutyPerson) {
        this.dutyPerson = dutyPerson;
    }

    public String getIllegalPlace() {
        return illegalPlace;
    }

    public void setIllegalPlace(String illegalPlace) {
        this.illegalPlace = illegalPlace;
    }

    public String getIllegalFact() {
        return illegalFact;
    }

    public void setIllegalFact(String illegalFact) {
        this.illegalFact = illegalFact;
    }

    public String getIllegalPublish() {
        return illegalPublish;
    }

    public void setIllegalPublish(String illegalPublish) {
        this.illegalPublish = illegalPublish;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishOrg() {
        return publishOrg;
    }

    public void setPublishOrg(String publishOrg) {
        this.publishOrg = publishOrg;
    }

    public String getCmvecid() {
        return cmvecid;
    }

    public void setCmvecid(String cmvecid) {
        this.cmvecid = cmvecid;
    }

    public String getCmpsnid() {
        return cmpsnid;
    }

    public void setCmpsnid(String cmpsnid) {
        this.cmpsnid = cmpsnid;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getLawPeerson1() {
        return lawPeerson1;
    }

    public void setLawPeerson1(String lawPeerson1) {
        this.lawPeerson1 = lawPeerson1;
    }

    public String getLawPsnNo1() {
        return lawPsnNo1;
    }

    public void setLawPsnNo1(String lawPsnNo1) {
        this.lawPsnNo1 = lawPsnNo1;
    }

    public String getLawPerson2() {
        return lawPerson2;
    }

    public void setLawPerson2(String lawPerson2) {
        this.lawPerson2 = lawPerson2;
    }

    public String getLawPsnNo2() {
        return lawPsnNo2;
    }

    public void setLawPsnNo2(String lawPsnNo2) {
        this.lawPsnNo2 = lawPsnNo2;
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

    public Double getLostPoint() {
        return lostPoint;
    }

    public void setLostPoint(Double lostPoint) {
        this.lostPoint = lostPoint;
    }

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent;
    }

    public String getEnbeworrecordid() {
        return enbeworrecordid;
    }

    public void setEnbeworrecordid(String enbeworrecordid) {
        this.enbeworrecordid = enbeworrecordid;
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

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Integer getBusScore() {
        return busScore;
    }

    public void setBusScore(Integer busScore) {
        this.busScore = busScore;
    }

    public String getCbIds() {
        return cbIds;
    }

    public void setCbIds(String cbIds) {
        this.cbIds = cbIds;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}