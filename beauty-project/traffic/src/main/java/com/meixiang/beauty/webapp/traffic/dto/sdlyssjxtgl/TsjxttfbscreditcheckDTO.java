package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbscreditcheckDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *业户ID
    **/
    @JSONField(name="ownerid")
    private String ownerid;

    /**
     *考核日期
    **/
    @JSONField(name="rptchkdate")
    private Date rptchkdate;

    /**
     *考核等级
    **/
    @JSONField(name="rptchkrsu")
    private char rptchkrsu;

    /**
     *考核机构
    **/
    @JSONField(name="examineorg")
    private String examineorg;

    /**
     *考核评分
    **/
    @JSONField(name="rptchkscore")
    private Double rptchkscore;

    /**
     *考核年度
    **/
    @JSONField(name="rptchkyear")
    private String rptchkyear;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public Date getRptchkdate() {
        return rptchkdate;
    }

    public void setRptchkdate(Date rptchkdate) {
        this.rptchkdate = rptchkdate;
    }

    public char getRptchkrsu() {
        return rptchkrsu;
    }

    public void setRptchkrsu(char rptchkrsu) {
        this.rptchkrsu = rptchkrsu;
    }

    public String getExamineorg() {
        return examineorg;
    }

    public void setExamineorg(String examineorg) {
        this.examineorg = examineorg;
    }

    public Double getRptchkscore() {
        return rptchkscore;
    }

    public void setRptchkscore(Double rptchkscore) {
        this.rptchkscore = rptchkscore;
    }

    public String getRptchkyear() {
        return rptchkyear;
    }

    public void setRptchkyear(String rptchkyear) {
        this.rptchkyear = rptchkyear;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}