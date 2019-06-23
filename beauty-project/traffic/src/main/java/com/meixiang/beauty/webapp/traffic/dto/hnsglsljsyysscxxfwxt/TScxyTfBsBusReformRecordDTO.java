package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsBusReformRecordDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *整改ID
    **/
    @JSONField(name="reformId")
    private String reformId;

    /**
     *备注
    **/
    @JSONField(name="remark")
    private String remark;

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
     *整改开始时间
    **/
    @JSONField(name="reformStart")
    private String reformStart;

    /**
     *下发日期
    **/
    @JSONField(name="reformDate")
    private String reformDate;

    /**
     *报告提交日期
    **/
    @JSONField(name="commitDate")
    private String commitDate;

    /**
     *整改报告
    **/
    @JSONField(name="reformContent")
    private String reformContent;

    /**
     *验收结果，0-合格，1-不合格
    **/
    @JSONField(name="approvalResult")
    private String approvalResult;

    /**
     *验收人员
    **/
    @JSONField(name="approvalPerson")
    private String approvalPerson;

    /**
     *验收时间
    **/
    @JSONField(name="approvalDate")
    private String approvalDate;

    /**
     *整改状态,0-未下发，1-已下发，2-已提交报告，3-已验收
    **/
    @JSONField(name="reformStatus")
    private String reformStatus;

    /**
     *原整改ID,继续整改保留原先的整改ID
    **/
    @JSONField(name="origReformId")
    private String origReformId;

    /**
     *整改结束时间
    **/
    @JSONField(name="reformEnd")
    private String reformEnd;

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
     *检查机构
    **/
    @JSONField(name="checkOrg")
    private String checkOrg;

    /**
     *验收意见
    **/
    @JSONField(name="approvalRemark")
    private String approvalRemark;

    /**
     *系统评分
    **/
    @JSONField(name="sysScore")
    private Double sysScore;

    /**
     *考核等级
    **/
    @JSONField(name="creditLevel")
    private String creditLevel;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getReformId() {
        return reformId;
    }

    public void setReformId(String reformId) {
        this.reformId = reformId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

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

    public String getReformStart() {
        return reformStart;
    }

    public void setReformStart(String reformStart) {
        this.reformStart = reformStart;
    }

    public String getReformDate() {
        return reformDate;
    }

    public void setReformDate(String reformDate) {
        this.reformDate = reformDate;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    public String getReformContent() {
        return reformContent;
    }

    public void setReformContent(String reformContent) {
        this.reformContent = reformContent;
    }

    public String getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
    }

    public String getApprovalPerson() {
        return approvalPerson;
    }

    public void setApprovalPerson(String approvalPerson) {
        this.approvalPerson = approvalPerson;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getReformStatus() {
        return reformStatus;
    }

    public void setReformStatus(String reformStatus) {
        this.reformStatus = reformStatus;
    }

    public String getOrigReformId() {
        return origReformId;
    }

    public void setOrigReformId(String origReformId) {
        this.origReformId = origReformId;
    }

    public String getReformEnd() {
        return reformEnd;
    }

    public void setReformEnd(String reformEnd) {
        this.reformEnd = reformEnd;
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

    public String getCheckOrg() {
        return checkOrg;
    }

    public void setCheckOrg(String checkOrg) {
        this.checkOrg = checkOrg;
    }

    public String getApprovalRemark() {
        return approvalRemark;
    }

    public void setApprovalRemark(String approvalRemark) {
        this.approvalRemark = approvalRemark;
    }

    public Double getSysScore() {
        return sysScore;
    }

    public void setSysScore(Double sysScore) {
        this.sysScore = sysScore;
    }

    public String getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}