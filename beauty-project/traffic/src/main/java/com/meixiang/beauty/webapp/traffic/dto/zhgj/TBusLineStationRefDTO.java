package com.meixiang.beauty.webapp.traffic.dto.zhgj;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TBusLineStationRefDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

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
     *站点编号
    **/
    @JSONField(name="stationCode")
    private Double stationCode;

    /**
     *站点id
    **/
    @JSONField(name="stationId")
    private String stationId;

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
     *站点数据库ID
    **/
    @JSONField(name="id")
    private String id;

    /**
     *主键
    **/
    @JSONField(name="pid")
    private String pid;

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
     *距起点距离（KM）
    **/
    @JSONField(name="byStartDistance")
    private Double byStartDistance;

    /**
     *修改时间
    **/
    @JSONField(name="lastModifiedTime")
    private String lastModifiedTime;

    /**
     *修改人
    **/
    @JSONField(name="lastModifier")
    private String lastModifier;

    /**
     *创建时间
    **/
    @JSONField(name="createTime")
    private String createTime;

    /**
     *创建人
    **/
    @JSONField(name="creator")
    private String creator;

    /**
     *备注
    **/
    @JSONField(name="remark")
    private String remark;

    /**
     *系统标识
    **/
    @JSONField(name="sysFlag")
    private char sysFlag;

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

    public Double getStationCode() {
        return stationCode;
    }

    public void setStationCode(Double stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public Double getByStartDistance() {
        return byStartDistance;
    }

    public void setByStartDistance(Double byStartDistance) {
        this.byStartDistance = byStartDistance;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public char getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(char sysFlag) {
        this.sysFlag = sysFlag;
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