package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TGkmtBerthsDTO {

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    /**
     *码头企业号(原号),默认0
    **/
    @JSONField(name="enterpriseNoOld")
    private Double enterpriseNoOld;

    /**
     *泊位状态
    **/
    @JSONField(name="berthStatus")
    private String berthStatus;

    /**
     *报废的报告期, 默认为0
    **/
    @JSONField(name="discardReportPeriod")
    private Double discardReportPeriod;

    /**
     *增加的报告期
    **/
    @JSONField(name="addReportPeriod")
    private Double addReportPeriod;

    /**
     *设计靠泊能力(吨级)
    **/
    @JSONField(name="designdockcapacity")
    private Double designdockcapacity;

    /**
     *泊位长度
    **/
    @JSONField(name="length")
    private Double length;

    /**
     *货主类型
    **/
    @JSONField(name="ownerkind")
    private String ownerkind;

    /**
     *服务类型
    **/
    @JSONField(name="servicekind")
    private String servicekind;

    /**
     *生产类型
    **/
    @JSONField(name="workkind")
    private String workkind;

    /**
     *泊位代码
    **/
    @JSONField(name="berthCode")
    private String berthCode;

    /**
     *泊位名称
    **/
    @JSONField(name="berthName")
    private String berthName;

    /**
     *归属港区编号
    **/
    @JSONField(name="portregionNo")
    private String portregionNo;

    /**
     *码头企业号,默认0
    **/
    @JSONField(name="enterpriseNo")
    private Double enterpriseNo;

    /**
     *报表年份
    **/
    @JSONField(name="reportYear")
    private Double reportYear;

    /**
     *泊位号
    **/
    @JSONField(name="berthNo")
    private Double berthNo;

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Double getEnterpriseNoOld() {
        return enterpriseNoOld;
    }

    public void setEnterpriseNoOld(Double enterpriseNoOld) {
        this.enterpriseNoOld = enterpriseNoOld;
    }

    public String getBerthStatus() {
        return berthStatus;
    }

    public void setBerthStatus(String berthStatus) {
        this.berthStatus = berthStatus;
    }

    public Double getDiscardReportPeriod() {
        return discardReportPeriod;
    }

    public void setDiscardReportPeriod(Double discardReportPeriod) {
        this.discardReportPeriod = discardReportPeriod;
    }

    public Double getAddReportPeriod() {
        return addReportPeriod;
    }

    public void setAddReportPeriod(Double addReportPeriod) {
        this.addReportPeriod = addReportPeriod;
    }

    public Double getDesigndockcapacity() {
        return designdockcapacity;
    }

    public void setDesigndockcapacity(Double designdockcapacity) {
        this.designdockcapacity = designdockcapacity;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public String getOwnerkind() {
        return ownerkind;
    }

    public void setOwnerkind(String ownerkind) {
        this.ownerkind = ownerkind;
    }

    public String getServicekind() {
        return servicekind;
    }

    public void setServicekind(String servicekind) {
        this.servicekind = servicekind;
    }

    public String getWorkkind() {
        return workkind;
    }

    public void setWorkkind(String workkind) {
        this.workkind = workkind;
    }

    public String getBerthCode() {
        return berthCode;
    }

    public void setBerthCode(String berthCode) {
        this.berthCode = berthCode;
    }

    public String getBerthName() {
        return berthName;
    }

    public void setBerthName(String berthName) {
        this.berthName = berthName;
    }

    public String getPortregionNo() {
        return portregionNo;
    }

    public void setPortregionNo(String portregionNo) {
        this.portregionNo = portregionNo;
    }

    public Double getEnterpriseNo() {
        return enterpriseNo;
    }

    public void setEnterpriseNo(Double enterpriseNo) {
        this.enterpriseNo = enterpriseNo;
    }

    public Double getReportYear() {
        return reportYear;
    }

    public void setReportYear(Double reportYear) {
        this.reportYear = reportYear;
    }

    public Double getBerthNo() {
        return berthNo;
    }

    public void setBerthNo(Double berthNo) {
        this.berthNo = berthNo;
    }

}