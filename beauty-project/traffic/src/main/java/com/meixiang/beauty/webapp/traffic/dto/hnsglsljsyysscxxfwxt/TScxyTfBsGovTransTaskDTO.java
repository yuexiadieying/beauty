package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsGovTransTaskDTO {

    /**
     *任务ID
    **/
    @JSONField(name="taskId")
    private String taskId;

    /**
     *申报ID
    **/
    @JSONField(name="reportId")
    private String reportId;

    /**
     *OWNER_ID
    **/
    @JSONField(name="ownerId")
    private String ownerId;

    /**
     *任务说明
    **/
    @JSONField(name="taskDesc")
    private String taskDesc;

    /**
     *完成情况：0已完成、1未执行、2未按要求完成
    **/
    @JSONField(name="iscomplete")
    private String iscomplete;

    /**
     *投入运力
    **/
    @JSONField(name="inTrans")
    private String inTrans;

    /**
     *完成运量
    **/
    @JSONField(name="completeTrans")
    private String completeTrans;

    /**
     *下达部门
    **/
    @JSONField(name="departName")
    private String departName;

    /**
     *完成时间
    **/
    @JSONField(name="completeDate")
    private String completeDate;

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
     *事件规格主键ID
    **/
    @JSONField(name="repTaskId")
    private String repTaskId;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getIscomplete() {
        return iscomplete;
    }

    public void setIscomplete(String iscomplete) {
        this.iscomplete = iscomplete;
    }

    public String getInTrans() {
        return inTrans;
    }

    public void setInTrans(String inTrans) {
        this.inTrans = inTrans;
    }

    public String getCompleteTrans() {
        return completeTrans;
    }

    public void setCompleteTrans(String completeTrans) {
        this.completeTrans = completeTrans;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
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

    public String getRepTaskId() {
        return repTaskId;
    }

    public void setRepTaskId(String repTaskId) {
        this.repTaskId = repTaskId;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}