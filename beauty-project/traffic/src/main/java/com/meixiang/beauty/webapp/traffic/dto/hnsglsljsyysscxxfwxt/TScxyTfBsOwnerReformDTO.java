package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsOwnerReformDTO {


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
     *原整改ID,继续整改保留原先的整改ID
    **/
    @JSONField(name="origReformId")
    private String origReformId;

    /**
     *OWNER_ID
    **/
    @JSONField(name="ownerId")
    private String ownerId;

    /**
     *整改标题
    **/
    @JSONField(name="reformTitle")
    private String reformTitle;

    /**
     *整改编号
    **/
    @JSONField(name="reformNo")
    private String reformNo;

    /**
     *申请单号
    **/
    @JSONField(name="applyId")
    private String applyId;

    /**
     *下发日期
    **/
    @JSONField(name="reformDate")
    private String reformDate;

    /**
     *检查日期
    **/
    @JSONField(name="checkDate")
    private String checkDate;

    /**
     *检查机构
    **/
    @JSONField(name="checkOrg")
    private String checkOrg;

    /**
     *检查人员
    **/
    @JSONField(name="checkPerson")
    private String checkPerson;

    /**
     *检查内容
    **/
    @JSONField(name="checkContent")
    private String checkContent;

    /**
     *开始整改日期
    **/
    @JSONField(name="startReformDate")
    private String startReformDate;

    /**
     *结束整改日期
    **/
    @JSONField(name="endReformDate")
    private String endReformDate;

    /**
     *法律法规
    **/
    @JSONField(name="lawContent")
    private String lawContent;

    /**
     *整改报告
    **/
    @JSONField(name="reformContent")
    private String reformContent;

    /**
     *报告提交日期
    **/
    @JSONField(name="commitDate")
    private String commitDate;

    /**
     *验收时间
    **/
    @JSONField(name="approvalDate")
    private String approvalDate;

    /**
     *验收人员
    **/
    @JSONField(name="approvalPerson")
    private String approvalPerson;

    /**
     *验收结果，0-合格，1-不合格
    **/
    @JSONField(name="approvalResult")
    private String approvalResult;

    /**
     *整改状态,0-未下发，1-已下发，2-已提交报告，3-已验收
    **/
    @JSONField(name="reformStatus")
    private String reformStatus;

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
     *验收意见
    **/
    @JSONField(name="approvalRemark")
    private String approvalRemark;

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

    public String getOrigReformId() {
        return origReformId;
    }

    public void setOrigReformId(String origReformId) {
        this.origReformId = origReformId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getReformTitle() {
        return reformTitle;
    }

    public void setReformTitle(String reformTitle) {
        this.reformTitle = reformTitle;
    }

    public String getReformNo() {
        return reformNo;
    }

    public void setReformNo(String reformNo) {
        this.reformNo = reformNo;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getReformDate() {
        return reformDate;
    }

    public void setReformDate(String reformDate) {
        this.reformDate = reformDate;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckOrg() {
        return checkOrg;
    }

    public void setCheckOrg(String checkOrg) {
        this.checkOrg = checkOrg;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public String getStartReformDate() {
        return startReformDate;
    }

    public void setStartReformDate(String startReformDate) {
        this.startReformDate = startReformDate;
    }

    public String getEndReformDate() {
        return endReformDate;
    }

    public void setEndReformDate(String endReformDate) {
        this.endReformDate = endReformDate;
    }

    public String getLawContent() {
        return lawContent;
    }

    public void setLawContent(String lawContent) {
        this.lawContent = lawContent;
    }

    public String getReformContent() {
        return reformContent;
    }

    public void setReformContent(String reformContent) {
        this.reformContent = reformContent;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovalPerson() {
        return approvalPerson;
    }

    public void setApprovalPerson(String approvalPerson) {
        this.approvalPerson = approvalPerson;
    }

    public String getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
    }

    public String getReformStatus() {
        return reformStatus;
    }

    public void setReformStatus(String reformStatus) {
        this.reformStatus = reformStatus;
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

    public String getApprovalRemark() {
        return approvalRemark;
    }

    public void setApprovalRemark(String approvalRemark) {
        this.approvalRemark = approvalRemark;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}