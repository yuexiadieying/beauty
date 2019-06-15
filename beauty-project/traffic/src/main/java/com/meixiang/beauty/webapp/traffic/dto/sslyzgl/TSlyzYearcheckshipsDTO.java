package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TSlyzYearcheckshipsDTO {

    /**
     *编号算法见ServerMaxNo说明
    **/
    @JSONField(name="yearcheckno")
    private String yearcheckno;

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
     *船名
    **/
    @JSONField(name="shipname")
    private String shipname;

    /**
     *船舶类型
    **/
    @JSONField(name="kindno")
    private String kindno;

    /**
     *经营者名
    **/
    @JSONField(name="enterprisename")
    private String enterprisename;

    /**
     *管辖机构
    **/
    @JSONField(name="unitno")
    private String unitno;

    /**
     *航区
    **/
    @JSONField(name="voyagearea")
    private String voyagearea;

    /**
     *船舶总吨，默认0
    **/
    @JSONField(name="totalton")
    private Integer totalton;

    /**
     *船舶总载重吨，默认0
    **/
    @JSONField(name="totalcarry")
    private Integer totalcarry;

    /**
     *船舶净载重吨，默认0
    **/
    @JSONField(name="ton")
    private Integer ton;

    /**
     *箱位数，默认0
    **/
    @JSONField(name="teu")
    private Integer teu;

    /**
     *载客量，默认0
    **/
    @JSONField(name="seat")
    private Integer seat;

    /**
     *功率，默认0
    **/
    @JSONField(name="power")
    private Double power;

    /**
     *年审结论
    **/
    @JSONField(name="yearcheckresult")
    private String yearcheckresult;

    /**
     *年审合格证号
    **/
    @JSONField(name="nshgzno")
    private String nshgzno;

    /**
     *年度审验日期
    **/
    @JSONField(name="nshgzdate")
    private Date nshgzdate;

    /**
     *年审合格证有效期限
    **/
    @JSONField(name="nshgzenddate")
    private Date nshgzenddate;

    /**
     *年审合格证打印日期
    **/
    @JSONField(name="nshgzprintdate")
    private Date nshgzprintdate;

    /**
     *备注
    **/
    @JSONField(name="nshgznote")
    private String nshgznote;

    @JSONField(name="createdate")
    private Date createdate;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getYearcheckno() {
        return yearcheckno;
    }

    public void setYearcheckno(String yearcheckno) {
        this.yearcheckno = yearcheckno;
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

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getUnitno() {
        return unitno;
    }

    public void setUnitno(String unitno) {
        this.unitno = unitno;
    }

    public String getVoyagearea() {
        return voyagearea;
    }

    public void setVoyagearea(String voyagearea) {
        this.voyagearea = voyagearea;
    }

    public Integer getTotalton() {
        return totalton;
    }

    public void setTotalton(Integer totalton) {
        this.totalton = totalton;
    }

    public Integer getTotalcarry() {
        return totalcarry;
    }

    public void setTotalcarry(Integer totalcarry) {
        this.totalcarry = totalcarry;
    }

    public Integer getTon() {
        return ton;
    }

    public void setTon(Integer ton) {
        this.ton = ton;
    }

    public Integer getTeu() {
        return teu;
    }

    public void setTeu(Integer teu) {
        this.teu = teu;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public String getYearcheckresult() {
        return yearcheckresult;
    }

    public void setYearcheckresult(String yearcheckresult) {
        this.yearcheckresult = yearcheckresult;
    }

    public String getNshgzno() {
        return nshgzno;
    }

    public void setNshgzno(String nshgzno) {
        this.nshgzno = nshgzno;
    }

    public Date getNshgzdate() {
        return nshgzdate;
    }

    public void setNshgzdate(Date nshgzdate) {
        this.nshgzdate = nshgzdate;
    }

    public Date getNshgzenddate() {
        return nshgzenddate;
    }

    public void setNshgzenddate(Date nshgzenddate) {
        this.nshgzenddate = nshgzenddate;
    }

    public Date getNshgzprintdate() {
        return nshgzprintdate;
    }

    public void setNshgzprintdate(Date nshgzprintdate) {
        this.nshgzprintdate = nshgzprintdate;
    }

    public String getNshgznote() {
        return nshgznote;
    }

    public void setNshgznote(String nshgznote) {
        this.nshgznote = nshgznote;
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