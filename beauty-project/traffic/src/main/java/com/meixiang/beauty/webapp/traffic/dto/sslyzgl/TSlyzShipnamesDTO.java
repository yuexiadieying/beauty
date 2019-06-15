package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TSlyzShipnamesDTO {

    /**
     *名录序号
    **/
    @JSONField(name="nameno")
    private Integer nameno;

    /**
     *报表年份
    **/
    @JSONField(name="reportyear")
    private Integer reportyear;

    /**
     *船舶编码，唯一编码
    **/
    @JSONField(name="shipno")
    private String shipno;

    /**
     *船检登记号，数字字母串
    **/
    @JSONField(name="shipcheckno")
    private String shipcheckno;

    /**
     *管辖机构编码
    **/
    @JSONField(name="unitno")
    private String unitno;

    /**
     *船舶经营人
    **/
    @JSONField(name="enterprisename")
    private String enterprisename;

    /**
     *船名
    **/
    @JSONField(name="shipname")
    private String shipname;

    /**
     *船舶类型名
    **/
    @JSONField(name="shipkindname")
    private String shipkindname;

    /**
     *船旗国
    **/
    @JSONField(name="nationkind")
    private String nationkind;

    /**
     *航区，默认内河
    **/
    @JSONField(name="voyagearea")
    private String voyagearea;

    /**
     *总长（米），默认0
    **/
    @JSONField(name="length")
    private Double length;

    /**
     *型宽（米），默认0
    **/
    @JSONField(name="width")
    private Double width;

    /**
     *满载吃水（米），默认0
    **/
    @JSONField(name="eatwater")
    private Double eatwater;

    /**
     *航速（节），默认0
    **/
    @JSONField(name="speed")
    private Double speed;

    /**
     *船舶总吨，默认0
    **/
    @JSONField(name="totalton")
    private Integer totalton;

    /**
     *总载重量，默认0
    **/
    @JSONField(name="totalcarry")
    private Integer totalcarry;

    /**
     *净载重量，默认0
    **/
    @JSONField(name="ton")
    private Integer ton;

    /**
     *载客量，默认0
    **/
    @JSONField(name="seat")
    private Integer seat;

    /**
     *箱位数，默认0
    **/
    @JSONField(name="teu")
    private Integer teu;

    /**
     *主机合计功率，默认0
    **/
    @JSONField(name="power")
    private Double power;

    /**
     *建造年份
    **/
    @JSONField(name="buildyear")
    private Integer buildyear;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public Integer getNameno() {
        return nameno;
    }

    public void setNameno(Integer nameno) {
        this.nameno = nameno;
    }

    public Integer getReportyear() {
        return reportyear;
    }

    public void setReportyear(Integer reportyear) {
        this.reportyear = reportyear;
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

    public String getUnitno() {
        return unitno;
    }

    public void setUnitno(String unitno) {
        this.unitno = unitno;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    public String getShipkindname() {
        return shipkindname;
    }

    public void setShipkindname(String shipkindname) {
        this.shipkindname = shipkindname;
    }

    public String getNationkind() {
        return nationkind;
    }

    public void setNationkind(String nationkind) {
        this.nationkind = nationkind;
    }

    public String getVoyagearea() {
        return voyagearea;
    }

    public void setVoyagearea(String voyagearea) {
        this.voyagearea = voyagearea;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getEatwater() {
        return eatwater;
    }

    public void setEatwater(Double eatwater) {
        this.eatwater = eatwater;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
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

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getTeu() {
        return teu;
    }

    public void setTeu(Integer teu) {
        this.teu = teu;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Integer getBuildyear() {
        return buildyear;
    }

    public void setBuildyear(Integer buildyear) {
        this.buildyear = buildyear;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}