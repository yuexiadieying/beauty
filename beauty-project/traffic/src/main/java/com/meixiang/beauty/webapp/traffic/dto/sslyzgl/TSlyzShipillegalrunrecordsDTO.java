package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TSlyzShipillegalrunrecordsDTO {

    /**
     *编号算法见ServerMaxNo说明
    **/
    @JSONField(name="illegalrecordno")
    private String illegalrecordno;

    /**
     *船舶编号
    **/
    @JSONField(name="shipno")
    private String shipno;

    /**
     *船名
    **/
    @JSONField(name="shipname")
    private String shipname;

    /**
     *船检登记号
    **/
    @JSONField(name="shipcheckno")
    private String shipcheckno;

    /**
     *超载载客、船舶违章
    **/
    @JSONField(name="kind")
    private String kind;

    /**
     *经营者名称名称
    **/
    @JSONField(name="enterprisename")
    private String enterprisename;

    /**
     *船舶所有人
    **/
    @JSONField(name="ownername")
    private String ownername;

    /**
     *许可证号
    **/
    @JSONField(name="xkzno")
    private String xkzno;

    /**
     *营运证号
    **/
    @JSONField(name="yyzno")
    private String yyzno;

    /**
     *记录登记日期
    **/
    @JSONField(name="recorddate")
    private Date recorddate;

    /**
     *记录登记账号
    **/
    @JSONField(name="recordusernoandname")
    private String recordusernoandname;

    /**
     *记录登记机构
    **/
    @JSONField(name="recordunitno")
    private String recordunitno;

    /**
     *记录说明
    **/
    @JSONField(name="illegalrunnote")
    private String illegalrunnote;

    @JSONField(name="createdate")
    private Date createdate;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getIllegalrecordno() {
        return illegalrecordno;
    }

    public void setIllegalrecordno(String illegalrecordno) {
        this.illegalrecordno = illegalrecordno;
    }

    public String getShipno() {
        return shipno;
    }

    public void setShipno(String shipno) {
        this.shipno = shipno;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    public String getShipcheckno() {
        return shipcheckno;
    }

    public void setShipcheckno(String shipcheckno) {
        this.shipcheckno = shipcheckno;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getXkzno() {
        return xkzno;
    }

    public void setXkzno(String xkzno) {
        this.xkzno = xkzno;
    }

    public String getYyzno() {
        return yyzno;
    }

    public void setYyzno(String yyzno) {
        this.yyzno = yyzno;
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }

    public String getRecordusernoandname() {
        return recordusernoandname;
    }

    public void setRecordusernoandname(String recordusernoandname) {
        this.recordusernoandname = recordusernoandname;
    }

    public String getRecordunitno() {
        return recordunitno;
    }

    public void setRecordunitno(String recordunitno) {
        this.recordunitno = recordunitno;
    }

    public String getIllegalrunnote() {
        return illegalrunnote;
    }

    public void setIllegalrunnote(String illegalrunnote) {
        this.illegalrunnote = illegalrunnote;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}