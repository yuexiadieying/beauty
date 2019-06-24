package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TGkmtPortsDTO {

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
     *报告期类型
    **/
    @JSONField(name="periodkind")
    private String periodkind;

    /**
     *港口管理单位
    **/
    @JSONField(name="portOwner")
    private String portOwner;

    /**
     *港口归属机构编码
    **/
    @JSONField(name="unitNo")
    private String unitNo;

    /**
     *港口名称
    **/
    @JSONField(name="portName")
    private String portName;

    /**
     *全国统一港口编号
    **/
    @JSONField(name="portNo")
    private String portNo;

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getPeriodkind() {
        return periodkind;
    }

    public void setPeriodkind(String periodkind) {
        this.periodkind = periodkind;
    }

    public String getPortOwner() {
        return portOwner;
    }

    public void setPortOwner(String portOwner) {
        this.portOwner = portOwner;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortNo() {
        return portNo;
    }

    public void setPortNo(String portNo) {
        this.portNo = portNo;
    }

}