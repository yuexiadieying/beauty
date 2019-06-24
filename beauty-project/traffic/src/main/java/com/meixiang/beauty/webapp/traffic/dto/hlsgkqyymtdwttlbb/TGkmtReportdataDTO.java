package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TGkmtReportdataDTO {

    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    /**
     *进港数据:外贸,默认0
    **/
    @JSONField(name="dataImportOversea")
    private Double dataImportOversea;

    /**
     *进港数据:小计,默认0
    **/
    @JSONField(name="dataImport")
    private Double dataImport;

    /**
     *出港数据:外贸,默认0
    **/
    @JSONField(name="dataExportOversea")
    private Double dataExportOversea;

    /**
     *泊位编号
    **/
    @JSONField(name="berthNo")
    private Double berthNo;

    /**
     *合计:外贸,默认0
    **/
    @JSONField(name="dataSumOversea")
    private Double dataSumOversea;

    /**
     *合计,默认0
    **/
    @JSONField(name="dataSum")
    private Double dataSum;

    /**
     *报表行号
    **/
    @JSONField(name="rowNo")
    private String rowNo;

    /**
     *报表报告期
    **/
    @JSONField(name="reportPeriod")
    private Double reportPeriod;

    /**
     *出港数据:小计,默认0
    **/
    @JSONField(name="dataExport")
    private Double dataExport;

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Double getDataImportOversea() {
        return dataImportOversea;
    }

    public void setDataImportOversea(Double dataImportOversea) {
        this.dataImportOversea = dataImportOversea;
    }

    public Double getDataImport() {
        return dataImport;
    }

    public void setDataImport(Double dataImport) {
        this.dataImport = dataImport;
    }

    public Double getDataExportOversea() {
        return dataExportOversea;
    }

    public void setDataExportOversea(Double dataExportOversea) {
        this.dataExportOversea = dataExportOversea;
    }

    public Double getBerthNo() {
        return berthNo;
    }

    public void setBerthNo(Double berthNo) {
        this.berthNo = berthNo;
    }

    public Double getDataSumOversea() {
        return dataSumOversea;
    }

    public void setDataSumOversea(Double dataSumOversea) {
        this.dataSumOversea = dataSumOversea;
    }

    public Double getDataSum() {
        return dataSum;
    }

    public void setDataSum(Double dataSum) {
        this.dataSum = dataSum;
    }

    public String getRowNo() {
        return rowNo;
    }

    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    public Double getReportPeriod() {
        return reportPeriod;
    }

    public void setReportPeriod(Double reportPeriod) {
        this.reportPeriod = reportPeriod;
    }

    public Double getDataExport() {
        return dataExport;
    }

    public void setDataExport(Double dataExport) {
        this.dataExport = dataExport;
    }

}