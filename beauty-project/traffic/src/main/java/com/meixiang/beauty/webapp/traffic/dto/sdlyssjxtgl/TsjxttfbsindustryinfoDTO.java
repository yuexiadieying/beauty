package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsindustryinfoDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *业户ID
    **/
    @JSONField(name="ownerid")
    private String ownerid;

    /**
     *法定代表人
    **/
    @JSONField(name="jurperson")
    private String jurperson;

    /**
     *经营业户经济类型
    **/
    @JSONField(name="economictype")
    private String economictype;

    /**
     *法人身份证
    **/
    @JSONField(name="ctcno")
    private String ctcno;

    /**
     *工商注册号
    **/
    @JSONField(name="busiregnumber")
    private String busiregnumber;

    /**
     *法定代表人证件类型
    **/
    @JSONField(name="jurctctype")
    private String jurctctype;

    /**
     *法人联系电话
    **/
    @JSONField(name="jurctcphone")
    private String jurctcphone;

    /**
     *法人手机
    **/
    @JSONField(name="jurctcmobile")
    private String jurctcmobile;

    /**
     *组织机构代码证
    **/
    @JSONField(name="orgcode")
    private String orgcode;

    /**
     *税务登记号
    **/
    @JSONField(name="taxregnumber")
    private String taxregnumber;

    /**
     *注册资本
    **/
    @JSONField(name="registeredcapital")
    private String registeredcapital;

    /**
     *开户银行
    **/
    @JSONField(name="bankofdeposit")
    private String bankofdeposit;

    /**
     *银行账号
    **/
    @JSONField(name="bankaccount")
    private String bankaccount;

    /**
     *投资总金额
    **/
    @JSONField(name="totalinvamount")
    private String totalinvamount;

    /**
     *固定资金
    **/
    @JSONField(name="fixedfunds")
    private String fixedfunds;

    /**
     *流程资金
    **/
    @JSONField(name="processfunds")
    private String processfunds;

    /**
     *发证日期
    **/
    @JSONField(name="gradate")
    private String gradate;

    /**
     *核算方式
    **/
    @JSONField(name="calculatetype")
    private String calculatetype;

    /**
     *中方经营者
    **/
    @JSONField(name="nativeprincipal")
    private String nativeprincipal;

    /**
     *外方经营者
    **/
    @JSONField(name="foreignprincipal")
    private String foreignprincipal;

    /**
     *外方注册资金
    **/
    @JSONField(name="foreignregisteredcapital")
    private String foreignregisteredcapital;

    /**
     *固定资产净值
    **/
    @JSONField(name="netfixedcapital")
    private String netfixedcapital;

    /**
     *固定资产原值
    **/
    @JSONField(name="originalfixedcapital")
    private String originalfixedcapital;

    /**
     *流动资金
    **/
    @JSONField(name="flowcapital")
    private String flowcapital;

    /**
     *实收资本
    **/
    @JSONField(name="paiclupcapital")
    private String paiclupcapital;

    /**
     *营业期限
    **/
    @JSONField(name="operatingperiod")
    private String operatingperiod;

    /**
     *组织机构代码
    **/
    @JSONField(name="organizationcode")
    private String organizationcode;

    /**
     *应急值班电话
    **/
    @JSONField(name="emergenciesphone")
    private String emergenciesphone;

    /**
     *成立日期
    **/
    @JSONField(name="establishdate")
    private String establishdate;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getJurperson() {
        return jurperson;
    }

    public void setJurperson(String jurperson) {
        this.jurperson = jurperson;
    }

    public String getEconomictype() {
        return economictype;
    }

    public void setEconomictype(String economictype) {
        this.economictype = economictype;
    }

    public String getCtcno() {
        return ctcno;
    }

    public void setCtcno(String ctcno) {
        this.ctcno = ctcno;
    }

    public String getBusiregnumber() {
        return busiregnumber;
    }

    public void setBusiregnumber(String busiregnumber) {
        this.busiregnumber = busiregnumber;
    }

    public String getJurctctype() {
        return jurctctype;
    }

    public void setJurctctype(String jurctctype) {
        this.jurctctype = jurctctype;
    }

    public String getJurctcphone() {
        return jurctcphone;
    }

    public void setJurctcphone(String jurctcphone) {
        this.jurctcphone = jurctcphone;
    }

    public String getJurctcmobile() {
        return jurctcmobile;
    }

    public void setJurctcmobile(String jurctcmobile) {
        this.jurctcmobile = jurctcmobile;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getTaxregnumber() {
        return taxregnumber;
    }

    public void setTaxregnumber(String taxregnumber) {
        this.taxregnumber = taxregnumber;
    }

    public String getRegisteredcapital() {
        return registeredcapital;
    }

    public void setRegisteredcapital(String registeredcapital) {
        this.registeredcapital = registeredcapital;
    }

    public String getBankofdeposit() {
        return bankofdeposit;
    }

    public void setBankofdeposit(String bankofdeposit) {
        this.bankofdeposit = bankofdeposit;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getTotalinvamount() {
        return totalinvamount;
    }

    public void setTotalinvamount(String totalinvamount) {
        this.totalinvamount = totalinvamount;
    }

    public String getFixedfunds() {
        return fixedfunds;
    }

    public void setFixedfunds(String fixedfunds) {
        this.fixedfunds = fixedfunds;
    }

    public String getProcessfunds() {
        return processfunds;
    }

    public void setProcessfunds(String processfunds) {
        this.processfunds = processfunds;
    }

    public String getGradate() {
        return gradate;
    }

    public void setGradate(String gradate) {
        this.gradate = gradate;
    }

    public String getCalculatetype() {
        return calculatetype;
    }

    public void setCalculatetype(String calculatetype) {
        this.calculatetype = calculatetype;
    }

    public String getNativeprincipal() {
        return nativeprincipal;
    }

    public void setNativeprincipal(String nativeprincipal) {
        this.nativeprincipal = nativeprincipal;
    }

    public String getForeignprincipal() {
        return foreignprincipal;
    }

    public void setForeignprincipal(String foreignprincipal) {
        this.foreignprincipal = foreignprincipal;
    }

    public String getForeignregisteredcapital() {
        return foreignregisteredcapital;
    }

    public void setForeignregisteredcapital(String foreignregisteredcapital) {
        this.foreignregisteredcapital = foreignregisteredcapital;
    }

    public String getNetfixedcapital() {
        return netfixedcapital;
    }

    public void setNetfixedcapital(String netfixedcapital) {
        this.netfixedcapital = netfixedcapital;
    }

    public String getOriginalfixedcapital() {
        return originalfixedcapital;
    }

    public void setOriginalfixedcapital(String originalfixedcapital) {
        this.originalfixedcapital = originalfixedcapital;
    }

    public String getFlowcapital() {
        return flowcapital;
    }

    public void setFlowcapital(String flowcapital) {
        this.flowcapital = flowcapital;
    }

    public String getPaiclupcapital() {
        return paiclupcapital;
    }

    public void setPaiclupcapital(String paiclupcapital) {
        this.paiclupcapital = paiclupcapital;
    }

    public String getOperatingperiod() {
        return operatingperiod;
    }

    public void setOperatingperiod(String operatingperiod) {
        this.operatingperiod = operatingperiod;
    }

    public String getOrganizationcode() {
        return organizationcode;
    }

    public void setOrganizationcode(String organizationcode) {
        this.organizationcode = organizationcode;
    }

    public String getEmergenciesphone() {
        return emergenciesphone;
    }

    public void setEmergenciesphone(String emergenciesphone) {
        this.emergenciesphone = emergenciesphone;
    }

    public String getEstablishdate() {
        return establishdate;
    }

    public void setEstablishdate(String establishdate) {
        this.establishdate = establishdate;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}