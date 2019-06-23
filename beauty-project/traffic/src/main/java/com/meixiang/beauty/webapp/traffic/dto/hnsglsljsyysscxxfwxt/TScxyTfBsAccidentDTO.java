package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TScxyTfBsAccidentDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *事故编号
    **/
    @JSONField(name="accidentId")
    private String accidentId;

    /**
     *OWNER_ID
    **/
    @JSONField(name="ownerId")
    private String ownerId;

    /**
     *车辆编码
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

    /**
     *车牌号码
    **/
    @JSONField(name="branum")
    private String branum;

    /**
     *车牌颜色
    **/
    @JSONField(name="bracolor")
    private String bracolor;

    /**
     *从业人员编号
    **/
    @JSONField(name="cmpsnid")
    private String cmpsnid;

    /**
     *身份证号码
    **/
    @JSONField(name="cardno")
    private String cardno;

    /**
     *从业资格证号码
    **/
    @JSONField(name="titno")
    private String titno;

    /**
     *驾驶员姓名
    **/
    @JSONField(name="drivername")
    private String drivername;

    /**
     *事故日期
    **/
    @JSONField(name="accDate")
    private String accDate;

    /**
     *事故时间
    **/
    @JSONField(name="accTime")
    private String accTime;

    /**
     *事故地点
    **/
    @JSONField(name="accPlace")
    private String accPlace;

    /**
     *死亡人数
    **/
    @JSONField(name="death")
    private Double death;

    /**
     *事故原因
    **/
    @JSONField(name="accReason")
    private String accReason;

    /**
     *事故情况
    **/
    @JSONField(name="accDetail")
    private String accDetail;

    /**
     *记录人
    **/
    @JSONField(name="recorder")
    private String recorder;

    /**
     *直接经济损失
    **/
    @JSONField(name="alllostmoney")
    private String alllostmoney;

    /**
     *事故责任与性质
    **/
    @JSONField(name="accDuty")
    private String accDuty;

    /**
     *路况
    **/
    @JSONField(name="roadcondition")
    private String roadcondition;

    /**
     *二级维护情况
    **/
    @JSONField(name="secondmain")
    private String secondmain;

    /**
     *天气情况
    **/
    @JSONField(name="weather")
    private String weather;

    /**
     *轻伤人数
    **/
    @JSONField(name="slightinjurynum")
    private Double slightinjurynum;

    /**
     *重伤人数
    **/
    @JSONField(name="seriousinjurynum")
    private Double seriousinjurynum;

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
     *从业资格证号
    **/
    @JSONField(name="enbeworrecordid")
    private String enbeworrecordid;

    /**
     *人员扣分
    **/
    @JSONField(name="lostPoint")
    private Double lostPoint;

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
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(String accidentId) {
        this.accidentId = accidentId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCmvecid() {
        return cmvecid;
    }

    public void setCmvecid(String cmvecid) {
        this.cmvecid = cmvecid;
    }

    public String getBranum() {
        return branum;
    }

    public void setBranum(String branum) {
        this.branum = branum;
    }

    public String getBracolor() {
        return bracolor;
    }

    public void setBracolor(String bracolor) {
        this.bracolor = bracolor;
    }

    public String getCmpsnid() {
        return cmpsnid;
    }

    public void setCmpsnid(String cmpsnid) {
        this.cmpsnid = cmpsnid;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getTitno() {
        return titno;
    }

    public void setTitno(String titno) {
        this.titno = titno;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getAccDate() {
        return accDate;
    }

    public void setAccDate(String accDate) {
        this.accDate = accDate;
    }

    public String getAccTime() {
        return accTime;
    }

    public void setAccTime(String accTime) {
        this.accTime = accTime;
    }

    public String getAccPlace() {
        return accPlace;
    }

    public void setAccPlace(String accPlace) {
        this.accPlace = accPlace;
    }

    public Double getDeath() {
        return death;
    }

    public void setDeath(Double death) {
        this.death = death;
    }

    public String getAccReason() {
        return accReason;
    }

    public void setAccReason(String accReason) {
        this.accReason = accReason;
    }

    public String getAccDetail() {
        return accDetail;
    }

    public void setAccDetail(String accDetail) {
        this.accDetail = accDetail;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getAlllostmoney() {
        return alllostmoney;
    }

    public void setAlllostmoney(String alllostmoney) {
        this.alllostmoney = alllostmoney;
    }

    public String getAccDuty() {
        return accDuty;
    }

    public void setAccDuty(String accDuty) {
        this.accDuty = accDuty;
    }

    public String getRoadcondition() {
        return roadcondition;
    }

    public void setRoadcondition(String roadcondition) {
        this.roadcondition = roadcondition;
    }

    public String getSecondmain() {
        return secondmain;
    }

    public void setSecondmain(String secondmain) {
        this.secondmain = secondmain;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Double getSlightinjurynum() {
        return slightinjurynum;
    }

    public void setSlightinjurynum(Double slightinjurynum) {
        this.slightinjurynum = slightinjurynum;
    }

    public Double getSeriousinjurynum() {
        return seriousinjurynum;
    }

    public void setSeriousinjurynum(Double seriousinjurynum) {
        this.seriousinjurynum = seriousinjurynum;
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

    public String getEnbeworrecordid() {
        return enbeworrecordid;
    }

    public void setEnbeworrecordid(String enbeworrecordid) {
        this.enbeworrecordid = enbeworrecordid;
    }

    public Double getLostPoint() {
        return lostPoint;
    }

    public void setLostPoint(Double lostPoint) {
        this.lostPoint = lostPoint;
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

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}