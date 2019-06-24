package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsDriverCreditDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *从业人员考核ID
    **/
    @JSONField(name="dcId")
    private String dcId;

    /**
     *考核年度
    **/
    @JSONField(name="creditYear")
    private String creditYear;

    /**
     *考核周期起始日期
    **/
    @JSONField(name="startDate")
    private String startDate;

    /**
     *结束日期
    **/
    @JSONField(name="endDate")
    private String endDate;

    /**
     *得分
    **/
    @JSONField(name="score")
    private Double score;

    /**
     *累计积分
    **/
    @JSONField(name="totalScore")
    private Double totalScore;

    /**
     *从业人员ID
    **/
    @JSONField(name="cmpsnid")
    private String cmpsnid;

    /**
     *状态
    **/
    @JSONField(name="dcStatus")
    private String dcStatus;

    /**
     *从业资格类别
    **/
    @JSONField(name="beworscope")
    private String beworscope;

    /**
     *考核级别
    **/
    @JSONField(name="dcLevel")
    private String dcLevel;

    /**
     *备注
    **/
    @JSONField(name="remark")
    private String remark;

    /**
     *评定人
    **/
    @JSONField(name="auditUser")
    private String auditUser;

    /**
     *评定时间
    **/
    @JSONField(name="auditDate")
    private String auditDate;

    /**
     *评定备注
    **/
    @JSONField(name="auditMemo")
    private String auditMemo;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *修改时间
    **/
    @JSONField(name="editime")
    private String editime;

    /**
     *修改日期
    **/
    @JSONField(name="edidate")
    private String edidate;

    /**
     *修改人
    **/
    @JSONField(name="ediusrcode")
    private String ediusrcode;

    /**
     *创建时间
    **/
    @JSONField(name="cretime")
    private String cretime;

    /**
     *创建日期
    **/
    @JSONField(name="credate")
    private String credate;

    /**
     *创建人
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private String iseffect;

    /**
     *从业资格证编号
    **/
    @JSONField(name="enbeworrecordid")
    private String enbeworrecordid;

    /**
     *从业资格证照片1
    **/
    @JSONField(name="enbeworrecordimg1")
    private String enbeworrecordimg1;

    /**
     *从业资格证照片2
    **/
    @JSONField(name="enbeworrecordimg2")
    private String enbeworrecordimg2;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getDcId() {
        return dcId;
    }

    public void setDcId(String dcId) {
        this.dcId = dcId;
    }

    public String getCreditYear() {
        return creditYear;
    }

    public void setCreditYear(String creditYear) {
        this.creditYear = creditYear;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public String getCmpsnid() {
        return cmpsnid;
    }

    public void setCmpsnid(String cmpsnid) {
        this.cmpsnid = cmpsnid;
    }

    public String getDcStatus() {
        return dcStatus;
    }

    public void setDcStatus(String dcStatus) {
        this.dcStatus = dcStatus;
    }

    public String getBeworscope() {
        return beworscope;
    }

    public void setBeworscope(String beworscope) {
        this.beworscope = beworscope;
    }

    public String getDcLevel() {
        return dcLevel;
    }

    public void setDcLevel(String dcLevel) {
        this.dcLevel = dcLevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public String getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(String auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditMemo() {
        return auditMemo;
    }

    public void setAuditMemo(String auditMemo) {
        this.auditMemo = auditMemo;
    }

    public Double getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(Double sysopertime) {
        this.sysopertime = sysopertime;
    }

    public String getEditime() {
        return editime;
    }

    public void setEditime(String editime) {
        this.editime = editime;
    }

    public String getEdidate() {
        return edidate;
    }

    public void setEdidate(String edidate) {
        this.edidate = edidate;
    }

    public String getEdiusrcode() {
        return ediusrcode;
    }

    public void setEdiusrcode(String ediusrcode) {
        this.ediusrcode = ediusrcode;
    }

    public String getCretime() {
        return cretime;
    }

    public void setCretime(String cretime) {
        this.cretime = cretime;
    }

    public String getCredate() {
        return credate;
    }

    public void setCredate(String credate) {
        this.credate = credate;
    }

    public String getCreusrcode() {
        return creusrcode;
    }

    public void setCreusrcode(String creusrcode) {
        this.creusrcode = creusrcode;
    }

    public String getIseffect() {
        return iseffect;
    }

    public void setIseffect(String iseffect) {
        this.iseffect = iseffect;
    }

    public String getEnbeworrecordid() {
        return enbeworrecordid;
    }

    public void setEnbeworrecordid(String enbeworrecordid) {
        this.enbeworrecordid = enbeworrecordid;
    }

    public String getEnbeworrecordimg1() {
        return enbeworrecordimg1;
    }

    public void setEnbeworrecordimg1(String enbeworrecordimg1) {
        this.enbeworrecordimg1 = enbeworrecordimg1;
    }

    public String getEnbeworrecordimg2() {
        return enbeworrecordimg2;
    }

    public void setEnbeworrecordimg2(String enbeworrecordimg2) {
        this.enbeworrecordimg2 = enbeworrecordimg2;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}