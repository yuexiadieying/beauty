package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TSlyzUnitsHnDTO {

    /**
     *机构编码，见说明
    **/
    @JSONField(name="unitno")
    private String unitno;

    /**
     *机构全称，最少4个字符
    **/
    @JSONField(name="xzqhno")
    private String xzqhno;

    @JSONField(name="unitname")
    private String unitname;

    /**
     *机构负责人姓名
    **/
    @JSONField(name="briefname")
    private String briefname;

    /**
     *部门负责人
    **/
    @JSONField(name="manager")
    private String manager;

    /**
     *填报人姓名
    **/
    @JSONField(name="branchmanager")
    private String branchmanager;

    /**
     *联系电话
    **/
    @JSONField(name="reporter")
    private String reporter;

    /**
     *机构所在行政区划名称
    **/
    @JSONField(name="telephone")
    private String telephone;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getUnitno() {
        return unitno;
    }

    public void setUnitno(String unitno) {
        this.unitno = unitno;
    }

    public String getXzqhno() {
        return xzqhno;
    }

    public void setXzqhno(String xzqhno) {
        this.xzqhno = xzqhno;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getBriefname() {
        return briefname;
    }

    public void setBriefname(String briefname) {
        this.briefname = briefname;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getBranchmanager() {
        return branchmanager;
    }

    public void setBranchmanager(String branchmanager) {
        this.branchmanager = branchmanager;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}