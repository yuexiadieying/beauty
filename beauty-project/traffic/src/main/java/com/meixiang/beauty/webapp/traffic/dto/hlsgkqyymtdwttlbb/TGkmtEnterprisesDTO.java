package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TGkmtEnterprisesDTO {

    /**
     *报表年份
    **/
    @JSONField(name="reportYear")
    private Double reportYear;

    /**
     *唯一标识号
    **/
    @JSONField(name="enterpriseNo")
    private Double enterpriseNo;

    /**
     *管辖机构编码
    **/
    @JSONField(name="managedUnitNo")
    private String managedUnitNo;

    /**
     *企业名称
    **/
    @JSONField(name="enterpriseName")
    private String enterpriseName;

    /**
     *经济类型
    **/
    @JSONField(name="enterpriseJjkind")
    private String enterpriseJjkind;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    /**
     *报表填报人(联系人)
    **/
    @JSONField(name="enterpriseReporter")
    private String enterpriseReporter;

    /**
     *创建报告期
    **/
    @JSONField(name="addReportPeriod")
    private Double addReportPeriod;

    /**
     *注销时的报告期,默认0
    **/
    @JSONField(name="unregisterReportPeriod")
    private Double unregisterReportPeriod;

    /**
     *企业状态，默认正常
    **/
    @JSONField(name="enterpriseStatus")
    private String enterpriseStatus;

    /**
     *联系电话
    **/
    @JSONField(name="enterpriseTelephone")
    private String enterpriseTelephone;

    public Double getReportYear() {
        return reportYear;
    }

    public void setReportYear(Double reportYear) {
        this.reportYear = reportYear;
    }

    public Double getEnterpriseNo() {
        return enterpriseNo;
    }

    public void setEnterpriseNo(Double enterpriseNo) {
        this.enterpriseNo = enterpriseNo;
    }

    public String getManagedUnitNo() {
        return managedUnitNo;
    }

    public void setManagedUnitNo(String managedUnitNo) {
        this.managedUnitNo = managedUnitNo;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseJjkind() {
        return enterpriseJjkind;
    }

    public void setEnterpriseJjkind(String enterpriseJjkind) {
        this.enterpriseJjkind = enterpriseJjkind;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getEnterpriseReporter() {
        return enterpriseReporter;
    }

    public void setEnterpriseReporter(String enterpriseReporter) {
        this.enterpriseReporter = enterpriseReporter;
    }

    public Double getAddReportPeriod() {
        return addReportPeriod;
    }

    public void setAddReportPeriod(Double addReportPeriod) {
        this.addReportPeriod = addReportPeriod;
    }

    public Double getUnregisterReportPeriod() {
        return unregisterReportPeriod;
    }

    public void setUnregisterReportPeriod(Double unregisterReportPeriod) {
        this.unregisterReportPeriod = unregisterReportPeriod;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getEnterpriseTelephone() {
        return enterpriseTelephone;
    }

    public void setEnterpriseTelephone(String enterpriseTelephone) {
        this.enterpriseTelephone = enterpriseTelephone;
    }

}