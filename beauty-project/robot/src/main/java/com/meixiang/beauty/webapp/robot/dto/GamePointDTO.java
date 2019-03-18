package com.meixiang.beauty.webapp.robot.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

public class GamePointDTO {

    @JSONField(name = "gamePlaceId")
    private String gamePlaceId;

    @JSONField(name = "partType")
    private String partType;

    @JSONField(name = "point")
    private int point;

    public String getGamePlaceId() {
        return gamePlaceId;
    }

    public void setGamePlaceId(String gamePlaceId) {
        this.gamePlaceId = gamePlaceId;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
