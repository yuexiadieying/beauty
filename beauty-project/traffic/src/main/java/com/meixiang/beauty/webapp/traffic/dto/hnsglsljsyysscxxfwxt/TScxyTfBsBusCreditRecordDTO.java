package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsBusCreditRecordDTO {

    /**
     *评定ID
    **/
    @JSONField(name="recordId")
    private String recordId;

    /**
     *车辆ID
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

    /**
     *考核年度
    **/
    @JSONField(name="reportYear")
    private String reportYear;

    /**
     *业户ID
    **/
    @JSONField(name="ownerId")
    private String ownerId;

    /**
     *考核等级
    **/
    @JSONField(name="creditLevel")
    private String creditLevel;

    /**
     *累计记分
    **/
    @JSONField(name="creditScore")
    private Double creditScore;

    /**
     *系统记分
    **/
    @JSONField(name="sysScore")
    private Double sysScore;

    /**
     *0-否，1-是
    **/
    @JSONField(name="isReform")
    private String isReform;

    /**
     *0-未整改，1-已整改
    **/
    @JSONField(name="reformStatus")
    private String reformStatus;

    /**
     *备注
    **/
    @JSONField(name="remark")
    private String remark;

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
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getCmvecid() {
        return cmvecid;
    }

    public void setCmvecid(String cmvecid) {
        this.cmvecid = cmvecid;
    }

    public String getReportYear() {
        return reportYear;
    }

    public void setReportYear(String reportYear) {
        this.reportYear = reportYear;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }

    public Double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Double creditScore) {
        this.creditScore = creditScore;
    }

    public Double getSysScore() {
        return sysScore;
    }

    public void setSysScore(Double sysScore) {
        this.sysScore = sysScore;
    }

    public String getIsReform() {
        return isReform;
    }

    public void setIsReform(String isReform) {
        this.isReform = isReform;
    }

    public String getReformStatus() {
        return reformStatus;
    }

    public void setReformStatus(String reformStatus) {
        this.reformStatus = reformStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}