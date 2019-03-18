package com.meixiang.beauty.webapp.robot.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class DeviceParamDTO<T> {

    @JSONField(name = "deviceId")
    private String deviceId;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "deviceType")
    private String deviceType;

    @JSONField(name = "num")
    private String num;

    @JSONField(name = "gamePlaceId")
    private String gamePlaceId;

    @JSONField(name = "attackParts")
    private List<String> attackParts;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getGamePlaceId() {
        return gamePlaceId;
    }

    public void setGamePlaceId(String gamePlaceId) {
        this.gamePlaceId = gamePlaceId;
    }

    public List<String> getAttackParts() {
        return attackParts;
    }

    public void setAttackParts(List<String> attackParts) {
        this.attackParts = attackParts;
    }
}
