package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TSlyzApproveapplyrecordsDTO {

    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *编号算法见ServerMaxNo说明
    **/
    @JSONField(name="applyno")
    private String applyno;

    /**
     *申请机构编码
    **/
    @JSONField(name="applyunitno")
    private String applyunitno;

    /**
     *申请事项类型
    **/
    @JSONField(name="applykind")
    private String applykind;

    /**
     *申请说明
    **/
    @JSONField(name="applyreason")
    private String applyreason;

    /**
     *申请提交时间
    **/
    @JSONField(name="applydate")
    private Date applydate;

    /**
     *提出许可申请对象的记录编号。如果是企业则编号是EnterpriseNo，如果是船舶则是ShipNo
    **/
    @JSONField(name="applyobjectno")
    private String applyobjectno;

    /**
     *许可机构等级
    **/
    @JSONField(name="approveunitgrade")
    private String approveunitgrade;

    /**
     *许可时间
    **/
    @JSONField(name="approvedate")
    private Date approvedate;

    /**
     *许可结果
    **/
    @JSONField(name="approveresult")
    private String approveresult;

    /**
     *许可说明
    **/
    @JSONField(name="approvereason")
    private String approvereason;

    /**
     *许可机构编码
    **/
    @JSONField(name="approveunitno")
    private String approveunitno;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getApplyno() {
        return applyno;
    }

    public void setApplyno(String applyno) {
        this.applyno = applyno;
    }

    public String getApplyunitno() {
        return applyunitno;
    }

    public void setApplyunitno(String applyunitno) {
        this.applyunitno = applyunitno;
    }

    public String getApplykind() {
        return applykind;
    }

    public void setApplykind(String applykind) {
        this.applykind = applykind;
    }

    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getApplyobjectno() {
        return applyobjectno;
    }

    public void setApplyobjectno(String applyobjectno) {
        this.applyobjectno = applyobjectno;
    }

    public String getApproveunitgrade() {
        return approveunitgrade;
    }

    public void setApproveunitgrade(String approveunitgrade) {
        this.approveunitgrade = approveunitgrade;
    }

    public Date getApprovedate() {
        return approvedate;
    }

    public void setApprovedate(Date approvedate) {
        this.approvedate = approvedate;
    }

    public String getApproveresult() {
        return approveresult;
    }

    public void setApproveresult(String approveresult) {
        this.approveresult = approveresult;
    }

    public String getApprovereason() {
        return approvereason;
    }

    public void setApprovereason(String approvereason) {
        this.approvereason = approvereason;
    }

    public String getApproveunitno() {
        return approveunitno;
    }

    public void setApproveunitno(String approveunitno) {
        this.approveunitno = approveunitno;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}