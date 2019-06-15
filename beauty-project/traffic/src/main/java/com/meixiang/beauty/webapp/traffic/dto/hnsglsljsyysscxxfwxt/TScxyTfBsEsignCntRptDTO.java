package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsEsignCntRptDTO {

    /**
     *电子签章申报ID
    **/
    @JSONField(name="esignCntId")
    private String esignCntId;

    /**
     *申报ID
    **/
    @JSONField(name="reportId")
    private String reportId;

    /**
     *配置ID
    **/
    @JSONField(name="esignConfigId")
    private String esignConfigId;

    /**
     *材料名称
    **/
    @JSONField(name="esignContent")
    private String esignContent;

    /**
     *排序号
    **/
    @JSONField(name="esignOrder")
    private Double esignOrder;

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
     *主键ID
    **/
    @JSONField(name="esignReportId")
    private String esignReportId;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getEsignCntId() {
        return esignCntId;
    }

    public void setEsignCntId(String esignCntId) {
        this.esignCntId = esignCntId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getEsignConfigId() {
        return esignConfigId;
    }

    public void setEsignConfigId(String esignConfigId) {
        this.esignConfigId = esignConfigId;
    }

    public String getEsignContent() {
        return esignContent;
    }

    public void setEsignContent(String esignContent) {
        this.esignContent = esignContent;
    }

    public Double getEsignOrder() {
        return esignOrder;
    }

    public void setEsignOrder(Double esignOrder) {
        this.esignOrder = esignOrder;
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

    public String getEsignReportId() {
        return esignReportId;
    }

    public void setEsignReportId(String esignReportId) {
        this.esignReportId = esignReportId;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}