package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsQualityEventDTO {

    /**
     *事件ID
    **/
    @JSONField(name="eventId")
    private String eventId;

    /**
     *OWNER_ID
    **/
    @JSONField(name="ownerId")
    private String ownerId;

    /**
     *发生时间
    **/
    @JSONField(name="eventTime")
    private String eventTime;

    /**
     *发生日期
    **/
    @JSONField(name="eventDate")
    private String eventDate;

    /**
     *事件原因
    **/
    @JSONField(name="eventReason")
    private String eventReason;

    /**
     *发生地点
    **/
    @JSONField(name="eventPlace")
    private String eventPlace;

    /**
     *发生事实
    **/
    @JSONField(name="eventFact")
    private String eventFact;

    /**
     *记录人
    **/
    @JSONField(name="recorder")
    private String recorder;

    /**
     *责任人
    **/
    @JSONField(name="dutyPerson")
    private String dutyPerson;

    /**
     *车辆ID
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

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
     *从业人员编号
    **/
    @JSONField(name="cmpsnid")
    private String cmpsnid;

    /**
     *从业资格证号
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
     *被媒体曝光
    **/
    @JSONField(name="exposure")
    private String exposure;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventReason() {
        return eventReason;
    }

    public void setEventReason(String eventReason) {
        this.eventReason = eventReason;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventFact() {
        return eventFact;
    }

    public void setEventFact(String eventFact) {
        this.eventFact = eventFact;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getDutyPerson() {
        return dutyPerson;
    }

    public void setDutyPerson(String dutyPerson) {
        this.dutyPerson = dutyPerson;
    }

    public String getCmvecid() {
        return cmvecid;
    }

    public void setCmvecid(String cmvecid) {
        this.cmvecid = cmvecid;
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

    public String getCmpsnid() {
        return cmpsnid;
    }

    public void setCmpsnid(String cmpsnid) {
        this.cmpsnid = cmpsnid;
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

    public String getExposure() {
        return exposure;
    }

    public void setExposure(String exposure) {
        this.exposure = exposure;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}