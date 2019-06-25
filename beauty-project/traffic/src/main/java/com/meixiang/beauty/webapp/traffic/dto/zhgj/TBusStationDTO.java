package com.meixiang.beauty.webapp.traffic.dto.zhgj;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TBusStationDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

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

    /**
     *主键
    **/
    @JSONField(name="pid")
    private String pid;

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
     *创建时间
    **/
    @JSONField(name="createTime")
    private String createTime;

    /**
     *出站纬度
    **/
    @JSONField(name="exitLatitude")
    private String exitLatitude;

    /**
     *站点经度
    **/
    @JSONField(name="longitude")
    private String longitude;

    /**
     *站点纬度
    **/
    @JSONField(name="latitude")
    private String latitude;

    /**
     *进站经度
    **/
    @JSONField(name="entranceLongitude")
    private String entranceLongitude;

    /**
     *进站纬度
    **/
    @JSONField(name="entranceLatitude")
    private String entranceLatitude;

    /**
     *站台id
    **/
    @JSONField(name="id")
    private String id;

    /**
     *出站经度
    **/
    @JSONField(name="exitLongitude")
    private String exitLongitude;

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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExitLatitude() {
        return exitLatitude;
    }

    public void setExitLatitude(String exitLatitude) {
        this.exitLatitude = exitLatitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getEntranceLongitude() {
        return entranceLongitude;
    }

    public void setEntranceLongitude(String entranceLongitude) {
        this.entranceLongitude = entranceLongitude;
    }

    public String getEntranceLatitude() {
        return entranceLatitude;
    }

    public void setEntranceLatitude(String entranceLatitude) {
        this.entranceLatitude = entranceLatitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExitLongitude() {
        return exitLongitude;
    }

    public void setExitLongitude(String exitLongitude) {
        this.exitLongitude = exitLongitude;
    }

}