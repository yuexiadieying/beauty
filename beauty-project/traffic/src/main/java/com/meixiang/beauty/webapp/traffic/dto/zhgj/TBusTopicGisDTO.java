package com.meixiang.beauty.webapp.traffic.dto.zhgj;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TBusTopicGisDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *主键
    **/
    @JSONField(name="pid")
    private String pid;

    /**
     *设备序列号
    **/
    @JSONField(name="devSn")
    private String devSn;

    /**
     *设备id
    **/
    @JSONField(name="devId")
    private String devId;

    /**
     *城市编号
    **/
    @JSONField(name="cityCode")
    private String cityCode;

    /**
     *公司代码
    **/
    @JSONField(name="companyCode")
    private String companyCode;

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
     *系统标识
    **/
    @JSONField(name="sysFlag")
    private char sysFlag;

    /**
     *备注
    **/
    @JSONField(name="remark")
    private String remark;

    /**
     *创建人
    **/
    @JSONField(name="creator")
    private String creator;

    /**
     *创建时间
    **/
    @JSONField(name="createTime")
    private String createTime;

    /**
     *修改人
    **/
    @JSONField(name="lastModifier")
    private String lastModifier;

    /**
     *修改时间
    **/
    @JSONField(name="lastModifiedTime")
    private String lastModifiedTime;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDevSn() {
        return devSn;
    }

    public void setDevSn(String devSn) {
        this.devSn = devSn;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

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

    public char getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(char sysFlag) {
        this.sysFlag = sysFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

}