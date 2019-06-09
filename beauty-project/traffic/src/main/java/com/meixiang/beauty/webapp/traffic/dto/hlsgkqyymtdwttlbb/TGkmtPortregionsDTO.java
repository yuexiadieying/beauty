package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TGkmtPortregionsDTO {

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    /**
     *港区管理单位
    **/
    @JSONField(name="portregtionOwner")
    private String portregtionOwner;

    /**
     *所在水系
    **/
    @JSONField(name="riversystem")
    private String riversystem;

    /**
     *所在水域
    **/
    @JSONField(name="riverarea")
    private String riverarea;

    /**
     *港区名称
    **/
    @JSONField(name="portregionName")
    private String portregionName;

    /**
     *全国统一港区编号
    **/
    @JSONField(name="portregionNo")
    private String portregionNo;

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getPortregtionOwner() {
        return portregtionOwner;
    }

    public void setPortregtionOwner(String portregtionOwner) {
        this.portregtionOwner = portregtionOwner;
    }

    public String getRiversystem() {
        return riversystem;
    }

    public void setRiversystem(String riversystem) {
        this.riversystem = riversystem;
    }

    public String getRiverarea() {
        return riverarea;
    }

    public void setRiverarea(String riverarea) {
        this.riverarea = riverarea;
    }

    public String getPortregionName() {
        return portregionName;
    }

    public void setPortregionName(String portregionName) {
        this.portregionName = portregionName;
    }

    public String getPortregionNo() {
        return portregionNo;
    }

    public void setPortregionNo(String portregionNo) {
        this.portregionNo = portregionNo;
    }

}