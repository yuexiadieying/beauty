package com.meixiang.beauty.webapp.traffic.dto.zhgj;

import com.alibaba.fastjson.annotation.JSONField;

public class TBusLineDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *下行发班时间
    **/
    @JSONField(name="downFirstTime")
    private String downFirstTime;

    /**
     *修改时间
    **/
    @JSONField(name="lastModifiedTime")
    private String lastModifiedTime;

    /**
     *上行发班时间
    **/
    @JSONField(name="upFirstTime")
    private String upFirstTime;

    /**
     *票价
    **/
    @JSONField(name="ticketPrice")
    private Double ticketPrice;

    /**
     *线路编码
    **/
    @JSONField(name="gprsId")
    private Double gprsId;

    /**
     *线路名称
    **/
    @JSONField(name="lineName")
    private String lineName;

    /**
     *线路id
    **/
    @JSONField(name="lineId")
    private String lineId;

    /**
     *主键
    **/
    @JSONField(name="pid")
    private String pid;

    /**
     *下行收班时间
    **/
    @JSONField(name="downEndTime")
    private String downEndTime;

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
     *上行收班时间
    **/
    @JSONField(name="upEndTime")
    private String upEndTime;

    public String getDownFirstTime() {
        return downFirstTime;
    }

    public void setDownFirstTime(String downFirstTime) {
        this.downFirstTime = downFirstTime;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getUpFirstTime() {
        return upFirstTime;
    }

    public void setUpFirstTime(String upFirstTime) {
        this.upFirstTime = upFirstTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Double getGprsId() {
        return gprsId;
    }

    public void setGprsId(Double gprsId) {
        this.gprsId = gprsId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDownEndTime() {
        return downEndTime;
    }

    public void setDownEndTime(String downEndTime) {
        this.downEndTime = downEndTime;
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

    public String getUpEndTime() {
        return upEndTime;
    }

    public void setUpEndTime(String upEndTime) {
        this.upEndTime = upEndTime;
    }

}