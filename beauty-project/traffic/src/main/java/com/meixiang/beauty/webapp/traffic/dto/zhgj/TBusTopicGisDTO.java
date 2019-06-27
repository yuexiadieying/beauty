package com.meixiang.beauty.webapp.traffic.dto.zhgj;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TBusTopicGisDTO {

    /**
     *线路id
    **/
    @JSONField(name="lineId")
    private String lineId;

    /**
     *GPS时间
    **/
    @JSONField(name="gpsTime")
    private String gpsTime;

    /**
     *经度
    **/
    @JSONField(name="lon")
    private String lon;

    /**
     *纬度
    **/
    @JSONField(name="lat")
    private String lat;

    /**
     *速度(km/h)
    **/
    @JSONField(name="speed")
    private Double speed;

    /**
     *里程(米)
    **/
    @JSONField(name="distance")
    private Double distance;

    /**
     *方向，0-359，单位为度(°)，正北为0，顺时针。
    **/
    @JSONField(name="angle")
    private Double angle;

    /**
     *海拔高度，单位为米(m)。
    **/
    @JSONField(name="altitude")
    private Double altitude;

    /**
     *行驶方向
    **/
    @JSONField(name="direction")
    private String direction;

    /**
     *距离下站距离，单位米（m）
    **/
    @JSONField(name="disNext")
    private Double disNext;

    /**
     *距离下站时间，单位秒（s）
    **/
    @JSONField(name="timeNext")
    private Double timeNext;

    /**
     *下一个站点序号
    **/
    @JSONField(name="nextStationNo")
    private Double nextStationNo;

    /**
     *车辆运行状态
    **/
    @JSONField(name="vehicleStatus")
    private String vehicleStatus;

    /**
     *上行收班时间
     **/
    @JSONField(name="upEndTime")
    private String upEndTime;

    /**
     *上行发班时间
     **/
    @JSONField(name="upFirstTime")
    private String upFirstTime;

    /**
     *下行收班时间
     **/
    @JSONField(name="endEndTime")
    private String endEndTime;

    /**
     *下行发班时间
     **/
    @JSONField(name="endFirstTime")
    private String endFirstTime;

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Double getDisNext() {
        return disNext;
    }

    public void setDisNext(Double disNext) {
        this.disNext = disNext;
    }

    public Double getTimeNext() {
        return timeNext;
    }

    public void setTimeNext(Double timeNext) {
        this.timeNext = timeNext;
    }

    public Double getNextStationNo() {
        return nextStationNo;
    }

    public void setNextStationNo(Double nextStationNo) {
        this.nextStationNo = nextStationNo;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getUpEndTime() {
        return upEndTime;
    }

    public void setUpEndTime(String upEndTime) {
        this.upEndTime = upEndTime;
    }

    public String getUpFirstTime() {
        return upFirstTime;
    }

    public void setUpFirstTime(String upFirstTime) {
        this.upFirstTime = upFirstTime;
    }

    public String getEndEndTime() {
        return endEndTime;
    }

    public void setEndEndTime(String endEndTime) {
        this.endEndTime = endEndTime;
    }

    public String getEndFirstTime() {
        return endFirstTime;
    }

    public void setEndFirstTime(String endFirstTime) {
        this.endFirstTime = endFirstTime;
    }
}