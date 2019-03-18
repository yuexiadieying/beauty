package com.meixiang.beauty.webapp.robot.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class GameParamDTO<T> {

    @JSONField(name = "gamePlaceId")
    private String gamePlaceId;

    @JSONField(name = "winPoint")
    private String winPoint;

    @JSONField(name = "dizzyTime")
    private int dizzyTime;

    @JSONField(name = "invulnerableTime")
    private int invulnerableTime;

    @JSONField(name = "maxHP")
    private String maxHP;

    @JSONField(name = "gameTotalTime")
    private int gameTotalTime;

    @JSONField(name = "gameStartTime")
    private Date gameStartTime;

    @JSONField(name = "gameEndTime")
    private Date gameEndTime;

    @JSONField(name = "gameResult")
    private String gameResult;

    @JSONField(name = "extensionData")
    private T extensionData;

    public String getGamePlaceId() {
        return gamePlaceId;
    }

    public void setGamePlaceId(String gamePlaceId) {
        this.gamePlaceId = gamePlaceId;
    }

    public String getWinPoint() {
        return winPoint;
    }

    public void setWinPoint(String winPoint) {
        this.winPoint = winPoint;
    }

    public int getDizzyTime() {
        return dizzyTime;
    }

    public void setDizzyTime(int dizzyTime) {
        this.dizzyTime = dizzyTime;
    }

    public String getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(String maxHP) {
        this.maxHP = maxHP;
    }

    public int getInvulnerableTime() {
        return invulnerableTime;
    }

    public void setInvulnerableTime(int invulnerableTime) {
        this.invulnerableTime = invulnerableTime;
    }

    public int getGameTotalTime() {
        return gameTotalTime;
    }

    public void setGameTotalTime(int gameTotalTime) {
        this.gameTotalTime = gameTotalTime;
    }

    public Date getGameStartTime() {
        return gameStartTime;
    }

    public void setGameStartTime(Date gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    public Date getGameEndTime() {
        return gameEndTime;
    }

    public void setGameEndTime(Date gameEndTime) {
        this.gameEndTime = gameEndTime;
    }

    public T getExtensionData() {
        return extensionData;
    }

    public void setExtensionData(T extensionData) {
        this.extensionData = extensionData;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }
}
