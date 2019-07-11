package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsvehicleinsuranceDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    @JSONField(name="insuranceid")
    private String insuranceid;

    /**
     *车辆ID
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

    /**
     *承运人保险保单号
    **/
    @JSONField(name="trainsno")
    private String trainsno;

    /**
     *承运人保险有效期
    **/
    @JSONField(name="trainsenddate")
    private String trainsenddate;

    @JSONField(name="insurancecompany")
    private String insurancecompany;

    @JSONField(name="trainsstadate")
    private String trainsstadate;

    /**
     *承运人责任保险实际投保金额
    **/
    @JSONField(name="trainsmoney")
    private String trainsmoney;

    /**
     *最高赔偿金额
    **/
    @JSONField(name="hnmaxtrainsmoney")
    private String hnmaxtrainsmoney;

    /**
     *签单日期
    **/
    @JSONField(name="hnsigningdate")
    private String hnsigningdate;

    /**
     *第三者责任保险实际投保金额
    **/
    @JSONField(name="thrinsmoney")
    private String thrinsmoney;

    /**
     *第三者责任保险实际投保数量
    **/
    @JSONField(name="thrinsamount")
    private String thrinsamount;

    /**
     *第三者保险保单号
    **/
    @JSONField(name="thrinsno")
    private String thrinsno;

    /**
     *第三者保险有效期
    **/
    @JSONField(name="thrinsenddate")
    private String thrinsenddate;

    /**
     *车辆建档日期
    **/
    @JSONField(name="credate")
    private String credate;

    /**
     *车辆建档时间
    **/
    @JSONField(name="cretime")
    private String cretime;

    /**
     *车辆建档人员编号
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *车辆档案变更日期
    **/
    @JSONField(name="edidate")
    private String edidate;

    /**
     *车辆档案变更时间
    **/
    @JSONField(name="editime")
    private String editime;

    /**
     *车辆档案变更人员编号
    **/
    @JSONField(name="ediusrcode")
    private String ediusrcode;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private String iseffect;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    @JSONField(name="coinsurance")
    private String coinsurance;

    @JSONField(name="barcodeid")
    private String barcodeid;

    /**
     *投保险种
    **/
    @JSONField(name="insurancecoverage")
    private String insurancecoverage;

    /**
     *投保日期
    **/
    @JSONField(name="insuredate")
    private String insuredate;

    /**
     *起保日期
    **/
    @JSONField(name="insurestartdate")
    private String insurestartdate;

    /**
     *终保日期
    **/
    @JSONField(name="insureenddate")
    private String insureenddate;

    /**
     *总保额
    **/
    @JSONField(name="totalinsured")
    private Double totalinsured;

    /**
     *总保费
    **/
    @JSONField(name="totalpremium")
    private Double totalpremium;

    /**
     *每座保额
    **/
    @JSONField(name="seattotalpremium")
    private Double seattotalpremium;

    /**
     *是否为有效保单
    **/
    @JSONField(name="iseffectivepolicy")
    private String iseffectivepolicy;

    /**
     *保单状态
    **/
    @JSONField(name="policystate")
    private String policystate;

    /**
     *被保险人名称
    **/
    @JSONField(name="insuranceperson")
    private String insuranceperson;

    /**
     *第三者每次每人责任限额
    **/
    @JSONField(name="thrineachsmoney")
    private String thrineachsmoney;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getInsuranceid() {
        return insuranceid;
    }

    public void setInsuranceid(String insuranceid) {
        this.insuranceid = insuranceid;
    }

    public String getCmvecid() {
        return cmvecid;
    }

    public void setCmvecid(String cmvecid) {
        this.cmvecid = cmvecid;
    }

    public String getTrainsno() {
        return trainsno;
    }

    public void setTrainsno(String trainsno) {
        this.trainsno = trainsno;
    }

    public String getTrainsenddate() {
        return trainsenddate;
    }

    public void setTrainsenddate(String trainsenddate) {
        this.trainsenddate = trainsenddate;
    }

    public String getInsurancecompany() {
        return insurancecompany;
    }

    public void setInsurancecompany(String insurancecompany) {
        this.insurancecompany = insurancecompany;
    }

    public String getTrainsstadate() {
        return trainsstadate;
    }

    public void setTrainsstadate(String trainsstadate) {
        this.trainsstadate = trainsstadate;
    }

    public String getTrainsmoney() {
        return trainsmoney;
    }

    public void setTrainsmoney(String trainsmoney) {
        this.trainsmoney = trainsmoney;
    }

    public String getHnmaxtrainsmoney() {
        return hnmaxtrainsmoney;
    }

    public void setHnmaxtrainsmoney(String hnmaxtrainsmoney) {
        this.hnmaxtrainsmoney = hnmaxtrainsmoney;
    }

    public String getHnsigningdate() {
        return hnsigningdate;
    }

    public void setHnsigningdate(String hnsigningdate) {
        this.hnsigningdate = hnsigningdate;
    }

    public String getThrinsmoney() {
        return thrinsmoney;
    }

    public void setThrinsmoney(String thrinsmoney) {
        this.thrinsmoney = thrinsmoney;
    }

    public String getThrinsamount() {
        return thrinsamount;
    }

    public void setThrinsamount(String thrinsamount) {
        this.thrinsamount = thrinsamount;
    }

    public String getThrinsno() {
        return thrinsno;
    }

    public void setThrinsno(String thrinsno) {
        this.thrinsno = thrinsno;
    }

    public String getThrinsenddate() {
        return thrinsenddate;
    }

    public void setThrinsenddate(String thrinsenddate) {
        this.thrinsenddate = thrinsenddate;
    }

    public String getCredate() {
        return credate;
    }

    public void setCredate(String credate) {
        this.credate = credate;
    }

    public String getCretime() {
        return cretime;
    }

    public void setCretime(String cretime) {
        this.cretime = cretime;
    }

    public String getCreusrcode() {
        return creusrcode;
    }

    public void setCreusrcode(String creusrcode) {
        this.creusrcode = creusrcode;
    }

    public String getEdidate() {
        return edidate;
    }

    public void setEdidate(String edidate) {
        this.edidate = edidate;
    }

    public String getEditime() {
        return editime;
    }

    public void setEditime(String editime) {
        this.editime = editime;
    }

    public String getEdiusrcode() {
        return ediusrcode;
    }

    public void setEdiusrcode(String ediusrcode) {
        this.ediusrcode = ediusrcode;
    }

    public String getIseffect() {
        return iseffect;
    }

    public void setIseffect(String iseffect) {
        this.iseffect = iseffect;
    }

    public Double getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(Double sysopertime) {
        this.sysopertime = sysopertime;
    }

    public String getCoinsurance() {
        return coinsurance;
    }

    public void setCoinsurance(String coinsurance) {
        this.coinsurance = coinsurance;
    }

    public String getBarcodeid() {
        return barcodeid;
    }

    public void setBarcodeid(String barcodeid) {
        this.barcodeid = barcodeid;
    }

    public String getInsurancecoverage() {
        return insurancecoverage;
    }

    public void setInsurancecoverage(String insurancecoverage) {
        this.insurancecoverage = insurancecoverage;
    }

    public String getInsuredate() {
        return insuredate;
    }

    public void setInsuredate(String insuredate) {
        this.insuredate = insuredate;
    }

    public String getInsurestartdate() {
        return insurestartdate;
    }

    public void setInsurestartdate(String insurestartdate) {
        this.insurestartdate = insurestartdate;
    }

    public String getInsureenddate() {
        return insureenddate;
    }

    public void setInsureenddate(String insureenddate) {
        this.insureenddate = insureenddate;
    }

    public Double getTotalinsured() {
        return totalinsured;
    }

    public void setTotalinsured(Double totalinsured) {
        this.totalinsured = totalinsured;
    }

    public Double getTotalpremium() {
        return totalpremium;
    }

    public void setTotalpremium(Double totalpremium) {
        this.totalpremium = totalpremium;
    }

    public Double getSeattotalpremium() {
        return seattotalpremium;
    }

    public void setSeattotalpremium(Double seattotalpremium) {
        this.seattotalpremium = seattotalpremium;
    }

    public String getIseffectivepolicy() {
        return iseffectivepolicy;
    }

    public void setIseffectivepolicy(String iseffectivepolicy) {
        this.iseffectivepolicy = iseffectivepolicy;
    }

    public String getPolicystate() {
        return policystate;
    }

    public void setPolicystate(String policystate) {
        this.policystate = policystate;
    }

    public String getInsuranceperson() {
        return insuranceperson;
    }

    public void setInsuranceperson(String insuranceperson) {
        this.insuranceperson = insuranceperson;
    }

    public String getThrineachsmoney() {
        return thrineachsmoney;
    }

    public void setThrineachsmoney(String thrineachsmoney) {
        this.thrineachsmoney = thrineachsmoney;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}