package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TSlyzChangeshiprecordsDTO {

    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *编号算法见ServerNumber说明
    **/
    @JSONField(name="changeno")
    private String changeno;

    /**
     *船舶记录号
    **/
    @JSONField(name="shipno")
    private String shipno;

    /**
     *船检登记号
    **/
    @JSONField(name="shipcheckno")
    private String shipcheckno;

    /**
     *船舶名称
    **/
    @JSONField(name="shipname")
    private String shipname;

    /**
     *船舶类型
    **/
    @JSONField(name="kindno")
    private String kindno;

    /**
     *船籍港
    **/
    @JSONField(name="portname")
    private String portname;

    /**
     *总吨
    **/
    @JSONField(name="totalton")
    private Integer totalton;

    /**
     *营运证号
    **/
    @JSONField(name="yyzno")
    private String yyzno;

    /**
     *营运证经营范围
    **/
    @JSONField(name="yyzrunkind")
    private String yyzrunkind;

    /**
     *营运证最近发证日期
    **/
    @JSONField(name="yyzprintdate")
    private Date yyzprintdate;

    /**
     *船舶经营者
    **/
    @JSONField(name="enterprisename")
    private String enterprisename;

    /**
     *船舶所有人
    **/
    @JSONField(name="ownername")
    private String ownername;

    /**
     *管理机构
    **/
    @JSONField(name="unitno")
    private String unitno;

    /**
     *变更日期
    **/
    @JSONField(name="changedate")
    private Date changedate;

    /**
     *变更类别
    **/
    @JSONField(name="changekind")
    private String changekind;

    /**
     *注销证号
    **/
    @JSONField(name="zxdjzno")
    private String zxdjzno;

    /**
     *注销登记证打印日期
    **/
    @JSONField(name="zxdjzprintdate")
    private Date zxdjzprintdate;

    /**
     *简要说明
    **/
    @JSONField(name="changenote")
    private String changenote;

    @JSONField(name="createdate")
    private Date createdate;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getChangeno() {
        return changeno;
    }

    public void setChangeno(String changeno) {
        this.changeno = changeno;
    }

    public String getShipno() {
        return shipno;
    }

    public void setShipno(String shipno) {
        this.shipno = shipno;
    }

    public String getShipcheckno() {
        return shipcheckno;
    }

    public void setShipcheckno(String shipcheckno) {
        this.shipcheckno = shipcheckno;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    public String getKindno() {
        return kindno;
    }

    public void setKindno(String kindno) {
        this.kindno = kindno;
    }

    public String getPortname() {
        return portname;
    }

    public void setPortname(String portname) {
        this.portname = portname;
    }

    public Integer getTotalton() {
        return totalton;
    }

    public void setTotalton(Integer totalton) {
        this.totalton = totalton;
    }

    public String getYyzno() {
        return yyzno;
    }

    public void setYyzno(String yyzno) {
        this.yyzno = yyzno;
    }

    public String getYyzrunkind() {
        return yyzrunkind;
    }

    public void setYyzrunkind(String yyzrunkind) {
        this.yyzrunkind = yyzrunkind;
    }

    public Date getYyzprintdate() {
        return yyzprintdate;
    }

    public void setYyzprintdate(Date yyzprintdate) {
        this.yyzprintdate = yyzprintdate;
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

    public String getUnitno() {
        return unitno;
    }

    public void setUnitno(String unitno) {
        this.unitno = unitno;
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public String getChangekind() {
        return changekind;
    }

    public void setChangekind(String changekind) {
        this.changekind = changekind;
    }

    public String getZxdjzno() {
        return zxdjzno;
    }

    public void setZxdjzno(String zxdjzno) {
        this.zxdjzno = zxdjzno;
    }

    public Date getZxdjzprintdate() {
        return zxdjzprintdate;
    }

    public void setZxdjzprintdate(Date zxdjzprintdate) {
        this.zxdjzprintdate = zxdjzprintdate;
    }

    public String getChangenote() {
        return changenote;
    }

    public void setChangenote(String changenote) {
        this.changenote = changenote;
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