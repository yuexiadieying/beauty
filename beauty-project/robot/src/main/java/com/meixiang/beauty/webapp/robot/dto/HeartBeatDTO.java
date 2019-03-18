package com.meixiang.beauty.webapp.robot.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

public class HeartBeatDTO<T> {

    @JSONField(name = "deviceId")
    private String deviceId;

    @JSONField(name = "gamePlaceId")
    private String gamePlaceId;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "part")
    private String part;

    @JSONField(name = "date")
    private Date date;

    @JSONField(name = "deviceStatus")
    private String deviceStatus;

    @JSONField(name = "extensionData")
    private T extensionData;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getGamePlaceId() {
        return gamePlaceId;
    }

    public void setGamePlaceId(String gamePlaceId) {
        this.gamePlaceId = gamePlaceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public T getExtensionData() {
        return extensionData;
    }

    public void setExtensionData(T extensionData) {
        this.extensionData = extensionData;
    }
}
