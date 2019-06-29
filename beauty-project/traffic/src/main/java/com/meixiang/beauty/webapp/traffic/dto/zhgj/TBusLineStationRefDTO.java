package com.meixiang.beauty.webapp.traffic.dto.zhgj;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TBusLineStationRefDTO {


    /**
     * 线路名称
     **/
    @JSONField(name="lineName")
    private Integer lineName;

    /**
     *站点序号
    **/
    @JSONField(name="sequence")
    private Double sequence;

    /**
     *站点名称
    **/
    @JSONField(name="stationName")
    private String stationName;

    /**
     *线路名称
    **/
    @JSONField(name="displayName")
    private String displayName;

    /**
     *线路编号
    **/
    @JSONField(name="gprsId")
    private Double gprsId;

    /**
     *方向(dwon:下行、up:上行)
    **/
    @JSONField(name="direction")
    private String direction;

    /**
     *到下站的时间（分钟）
    **/
    @JSONField(name="toNextTime")
    private Double toNextTime;

    /**
     *纬度
    **/
    @JSONField(name="exitLatitude")
    private String exitLatitude;

    /**
     *经度
    **/
    @JSONField(name="exitLongitude")
    private String exitLongitude;

    public Integer getLineName() {
        return lineName;
    }

    public void setLineName(Integer lineName) {
        this.lineName = lineName;
    }

    public Double getSequence() {
        return sequence;
    }

    public void setSequence(Double sequence) {
        this.sequence = sequence;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Double getGprsId() {
        return gprsId;
    }

    public void setGprsId(Double gprsId) {
        this.gprsId = gprsId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Double getToNextTime() {
        return toNextTime;
    }

    public void setToNextTime(Double toNextTime) {
        this.toNextTime = toNextTime;
    }

    public String getExitLatitude() {
        return exitLatitude;
    }

    public void setExitLatitude(String exitLatitude) {
        this.exitLatitude = exitLatitude;
    }

    public String getExitLongitude() {
        return exitLongitude;
    }

    public void setExitLongitude(String exitLongitude) {
        this.exitLongitude = exitLongitude;
    }
}