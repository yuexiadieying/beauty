package com.meixiang.beauty.webapp.traffic.dto.zhgj;

import com.alibaba.fastjson.annotation.JSONField;

public class TBusLineDTO {

    /**
     *下行发班时间
    **/
    @JSONField(name="downFirstTime")
    private String downFirstTime;

    /**
     *上行发班时间
    **/
    @JSONField(name="upFirstTime")
    private String upFirstTime;

    /**
     *票价
    **/
    @JSONField(name="ticketPrice")
    private Double ticketPrice;

    /**
     *线路编码
    **/
    @JSONField(name="gprsId")
    private Double gprsId;

    /**
     *线路名称
    **/
    @JSONField(name="lineName")
    private String lineName;

    /**
     *下行收班时间
    **/
    @JSONField(name="downEndTime")
    private String downEndTime;

    /**
     *上行收班时间
    **/
    @JSONField(name="upEndTime")
    private String upEndTime;


    /**
     *车辆所属企业名
     **/
    @JSONField(name="departmentName")
    private String departmentName;


    /**
     *车名
     **/
    @JSONField(name="name")
    private String name;


    /**
     *车牌
     **/
    @JSONField(name="licensePlate")
    private String licensePlate;

    public String getDownFirstTime() {
        return downFirstTime;
    }

    public void setDownFirstTime(String downFirstTime) {
        this.downFirstTime = downFirstTime;
    }

    public String getUpFirstTime() {
        return upFirstTime;
    }

    public void setUpFirstTime(String upFirstTime) {
        this.upFirstTime = upFirstTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Double getGprsId() {
        return gprsId;
    }

    public void setGprsId(Double gprsId) {
        this.gprsId = gprsId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getDownEndTime() {
        return downEndTime;
    }

    public void setDownEndTime(String downEndTime) {
        this.downEndTime = downEndTime;
    }

    public String getUpEndTime() {
        return upEndTime;
    }

    public void setUpEndTime(String upEndTime) {
        this.upEndTime = upEndTime;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}