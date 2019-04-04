package com.meixiang.beauty.webapp.car.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class AttackParamDTO {

    @JSONField(name = "partName")
    private String partName;

    @JSONField(name = "value")
    private int value;

    @JSONField(name = "gamePlaceId")
    private String gamePlaceId;

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getGamePlaceId() {
        return gamePlaceId;
    }

    public void setGamePlaceId(String gamePlaceId) {
        this.gamePlaceId = gamePlaceId;
    }
}
