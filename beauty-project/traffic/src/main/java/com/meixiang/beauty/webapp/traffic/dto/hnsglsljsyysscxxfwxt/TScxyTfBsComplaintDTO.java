package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsComplaintDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *投诉ID
    **/
    @JSONField(name="compId")
    private String compId;

    /**
     *OWNER_ID
    **/
    @JSONField(name="ownerId")
    private String ownerId;

    /**
     *投诉人
    **/
    @JSONField(name="compName")
    private String compName;

    /**
     *投诉日期
    **/
    @JSONField(name="compDate")
    private String compDate;

    /**
     *投诉内容
    **/
    @JSONField(name="compContent")
    private String compContent;

    /**
     *投诉部门
    **/
    @JSONField(name="compDepart")
    private String compDepart;

    /**
     *社会影响
    **/
    @JSONField(name="socialInfluence")
    private String socialInfluence;

    /**
     *违法事实
    **/
    @JSONField(name="compInfact")
    private String compInfact;

    /**
     *处理情况
    **/
    @JSONField(name="compDeal")
    private String compDeal;

    /**
     *投诉电话
    **/
    @JSONField(name="compPhone")
    private String compPhone;

    /**
     *投诉人来源
    **/
    @JSONField(name="compSource")
    private String compSource;

    /**
     *被投诉人
    **/
    @JSONField(name="complainted")
    private String complainted;

    /**
     *电子邮件
    **/
    @JSONField(name="email")
    private String email;

    /**
     *媒体曝光
    **/
    @JSONField(name="mediaexp")
    private String mediaexp;

    /**
     *处罚类型
    **/
    @JSONField(name="publishType")
    private String publishType;

    /**
     *投诉类型
    **/
    @JSONField(name="compType")
    private String compType;

    /**
     *投诉人联系电话
    **/
    @JSONField(name="userPhone")
    private String userPhone;

    /**
     *记录人单位
    **/
    @JSONField(name="recorderUnit")
    private String recorderUnit;

    /**
     *记录人电话
    **/
    @JSONField(name="recorderPhone")
    private String recorderPhone;

    /**
     *记录人
    **/
    @JSONField(name="recorder")
    private String recorder;

    /**
     *处理日期
    **/
    @JSONField(name="dealDate")
    private String dealDate;

    /**
     *处理部门
    **/
    @JSONField(name="dealDepart")
    private String dealDepart;

    /**
     *处理部门意见
    **/
    @JSONField(name="dealDeptOpinion")
    private String dealDeptOpinion;

    /**
     *处理结果意见
    **/
    @JSONField(name="dealResult")
    private String dealResult;

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
     *车辆编号
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

    /**
     *审核意见
    **/
    @JSONField(name="auditContent")
    private String auditContent;

    /**
     *人员扣分
    **/
    @JSONField(name="lostPoint")
    private Double lostPoint;

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
     *从业指标ID
    **/
    @JSONField(name="targetId")
    private String targetId;

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

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompDate() {
        return compDate;
    }

    public void setCompDate(String compDate) {
        this.compDate = compDate;
    }

    public String getCompContent() {
        return compContent;
    }

    public void setCompContent(String compContent) {
        this.compContent = compContent;
    }

    public String getCompDepart() {
        return compDepart;
    }

    public void setCompDepart(String compDepart) {
        this.compDepart = compDepart;
    }

    public String getSocialInfluence() {
        return socialInfluence;
    }

    public void setSocialInfluence(String socialInfluence) {
        this.socialInfluence = socialInfluence;
    }

    public String getCompInfact() {
        return compInfact;
    }

    public void setCompInfact(String compInfact) {
        this.compInfact = compInfact;
    }

    public String getCompDeal() {
        return compDeal;
    }

    public void setCompDeal(String compDeal) {
        this.compDeal = compDeal;
    }

    public String getCompPhone() {
        return compPhone;
    }

    public void setCompPhone(String compPhone) {
        this.compPhone = compPhone;
    }

    public String getCompSource() {
        return compSource;
    }

    public void setCompSource(String compSource) {
        this.compSource = compSource;
    }

    public String getComplainted() {
        return complainted;
    }

    public void setComplainted(String complainted) {
        this.complainted = complainted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMediaexp() {
        return mediaexp;
    }

    public void setMediaexp(String mediaexp) {
        this.mediaexp = mediaexp;
    }

    public String getPublishType() {
        return publishType;
    }

    public void setPublishType(String publishType) {
        this.publishType = publishType;
    }

    public String getCompType() {
        return compType;
    }

    public void setCompType(String compType) {
        this.compType = compType;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getRecorderUnit() {
        return recorderUnit;
    }

    public void setRecorderUnit(String recorderUnit) {
        this.recorderUnit = recorderUnit;
    }

    public String getRecorderPhone() {
        return recorderPhone;
    }

    public void setRecorderPhone(String recorderPhone) {
        this.recorderPhone = recorderPhone;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }

    public String getDealDepart() {
        return dealDepart;
    }

    public void setDealDepart(String dealDepart) {
        this.dealDepart = dealDepart;
    }

    public String getDealDeptOpinion() {
        return dealDeptOpinion;
    }

    public void setDealDeptOpinion(String dealDeptOpinion) {
        this.dealDeptOpinion = dealDeptOpinion;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
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

    public String getCmvecid() {
        return cmvecid;
    }

    public void setCmvecid(String cmvecid) {
        this.cmvecid = cmvecid;
    }

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent;
    }

    public Double getLostPoint() {
        return lostPoint;
    }

    public void setLostPoint(Double lostPoint) {
        this.lostPoint = lostPoint;
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