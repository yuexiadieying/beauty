package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsvectrancertDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    @JSONField(name = "braColor")
    private String braColor;

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getBraColor() {
        return braColor;
    }

    public void setBraColor(String braColor) {
        this.braColor = braColor;
    }

    /**
     *车辆ID
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

    /**
     *经营范围
    **/
    @JSONField(name="bnscope")
    private String bnscope;

    /**
     *有效期止
    **/
    @JSONField(name="enddate")
    private String enddate;

    /**
     *有效期起
    **/
    @JSONField(name="stadate")
    private String stadate;

    /**
     *核发日期
    **/
    @JSONField(name="gradate")
    private String gradate;

    /**
     *发证机构
    **/
    @JSONField(name="gradepcode")
    private String gradepcode;

    /**
     *道路运输证号
    **/
    @JSONField(name="trano")
    private String trano;

    /**
     *城市简称
    **/
    @JSONField(name="areaabbr")
    private String areaabbr;

    /**
     *道路运输证字
    **/
    @JSONField(name="traword")
    private String traword;

    /**
     *车辆档案号
    **/
    @JSONField(name="arcno")
    private String arcno;

    /**
     *打印备注
    **/
    @JSONField(name="printremark")
    private String printremark;

    @JSONField(name="ctcentype")
    private String ctcentype;

    /**
     *经营范围备份20160820
    **/
    @JSONField(name="bnscopeback")
    private String bnscopeback;

    /**
     *经营范围编码和名称
    **/
    @JSONField(name="bnscopecode")
    private String bnscopecode;

    /**
     *经营范围编码和品名名称
    **/
    @JSONField(name="productcode")
    private String productcode;

    /**
     *打印经营范围完整中文
    **/
    @JSONField(name="prbnscopename")
    private String prbnscopename;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getCmvecid() {
        return cmvecid;
    }

    public void setCmvecid(String cmvecid) {
        this.cmvecid = cmvecid;
    }

    public String getBnscope() {
        return bnscope;
    }

    public void setBnscope(String bnscope) {
        this.bnscope = bnscope;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getStadate() {
        return stadate;
    }

    public void setStadate(String stadate) {
        this.stadate = stadate;
    }

    public String getGradate() {
        return gradate;
    }

    public void setGradate(String gradate) {
        this.gradate = gradate;
    }

    public String getGradepcode() {
        return gradepcode;
    }

    public void setGradepcode(String gradepcode) {
        this.gradepcode = gradepcode;
    }

    public String getTrano() {
        return trano;
    }

    public void setTrano(String trano) {
        this.trano = trano;
    }

    public String getAreaabbr() {
        return areaabbr;
    }

    public void setAreaabbr(String areaabbr) {
        this.areaabbr = areaabbr;
    }

    public String getTraword() {
        return traword;
    }

    public void setTraword(String traword) {
        this.traword = traword;
    }

    public String getArcno() {
        return arcno;
    }

    public void setArcno(String arcno) {
        this.arcno = arcno;
    }

    public String getPrintremark() {
        return printremark;
    }

    public void setPrintremark(String printremark) {
        this.printremark = printremark;
    }

    public String getCtcentype() {
        return ctcentype;
    }

    public void setCtcentype(String ctcentype) {
        this.ctcentype = ctcentype;
    }

    public String getBnscopeback() {
        return bnscopeback;
    }

    public void setBnscopeback(String bnscopeback) {
        this.bnscopeback = bnscopeback;
    }

    public String getBnscopecode() {
        return bnscopecode;
    }

    public void setBnscopecode(String bnscopecode) {
        this.bnscopecode = bnscopecode;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getPrbnscopename() {
        return prbnscopename;
    }

    public void setPrbnscopename(String prbnscopename) {
        this.prbnscopename = prbnscopename;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}