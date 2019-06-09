package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TGkmtUnitsDTO {

    /**
     *机构所在行政区划名称
    **/
    @JSONField(name="unitXzqhname")
    private String unitXzqhname;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    /**
     *机构编码,见说明
    **/
    @JSONField(name="unitNo")
    private String unitNo;

    /**
     *机构全称,最少4个字符
    **/
    @JSONField(name="unitName")
    private String unitName;

    /**
     *联系电话
    **/
    @JSONField(name="unitTelephone")
    private String unitTelephone;

    /**
     *机构负责人姓名
    **/
    @JSONField(name="unitManager")
    private String unitManager;

    /**
     *部门负责人
    **/
    @JSONField(name="unitBranchmanager")
    private String unitBranchmanager;

    /**
     *填报人姓名
    **/
    @JSONField(name="unitReporter")
    private String unitReporter;

    /**
     *机构简码
    **/
    @JSONField(name="unitBriefname")
    private String unitBriefname;

    public String getUnitXzqhname() {
        return unitXzqhname;
    }

    public void setUnitXzqhname(String unitXzqhname) {
        this.unitXzqhname = unitXzqhname;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitTelephone() {
        return unitTelephone;
    }

    public void setUnitTelephone(String unitTelephone) {
        this.unitTelephone = unitTelephone;
    }

    public String getUnitManager() {
        return unitManager;
    }

    public void setUnitManager(String unitManager) {
        this.unitManager = unitManager;
    }

    public String getUnitBranchmanager() {
        return unitBranchmanager;
    }

    public void setUnitBranchmanager(String unitBranchmanager) {
        this.unitBranchmanager = unitBranchmanager;
    }

    public String getUnitReporter() {
        return unitReporter;
    }

    public void setUnitReporter(String unitReporter) {
        this.unitReporter = unitReporter;
    }

    public String getUnitBriefname() {
        return unitBriefname;
    }

    public void setUnitBriefname(String unitBriefname) {
        this.unitBriefname = unitBriefname;
    }

}