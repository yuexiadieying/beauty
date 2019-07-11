package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfptownerDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     * 经济类型
     */
    @JSONField(name = "economicType")
    private String economicType;

    /**
     *业户ID
    **/
    @JSONField(name="ownerid")
    private String ownerid;

    /**
     *行政机构ID
    **/
    @JSONField(name="govderpid")
    private String govderpid;

    /**
     *机构ID
    **/
    @JSONField(name="deptid")
    private String deptid;

    /**
     *业户名称
    **/
    @JSONField(name="ownername")
    private String ownername;

    /**
     *是否分支
    **/
    @JSONField(name="isbranch")
    private String isbranch;

    /**
     *总公司
    **/
    @JSONField(name="headoffice")
    private String headoffice;

    /**
     *分支机构编码
    **/
    @JSONField(name="branchcode")
    private String branchcode;

    /**
     *业户代码
    **/
    @JSONField(name="ownercode")
    private String ownercode;

    /**
     *业户状态
    **/
    @JSONField(name="ownerstatus")
    private char ownerstatus;

    /**
     *联系电话
    **/
    @JSONField(name="phone")
    private String phone;

    /**
     *联系地址
    **/
    @JSONField(name="address")
    private String address;

    /**
     *邮政编码
    **/
    @JSONField(name="postalcode")
    private String postalcode;

    /**
     *电子邮箱
    **/
    @JSONField(name="email")
    private String email;

    /**
     *业户主页
    **/
    @JSONField(name="homeresidents")
    private String homeresidents;

    /**
     *企业等级
    **/
    @JSONField(name="enterpriseclass")
    private String enterpriseclass;

    /**
     *备注
    **/
    @JSONField(name="remark")
    private String remark;

    /**
     *所属部门
    **/
    @JSONField(name="depttype")
    private String depttype;

    /**
     *投诉电话
    **/
    @JSONField(name="complaintsphone")
    private String complaintsphone;

    /**
     *传真电话
    **/
    @JSONField(name="faxphone")
    private String faxphone;

    /**
     *建档机构
    **/
    @JSONField(name="deptcode")
    private String deptcode;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private String iseffect;

    /**
     *创建日期
    **/
    @JSONField(name="credate")
    private String credate;

    /**
     *创建时间
    **/
    @JSONField(name="cretime")
    private String cretime;

    /**
     *创建者编号
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *修改日期
    **/
    @JSONField(name="edidate")
    private String edidate;

    /**
     *修改时间
    **/
    @JSONField(name="editime")
    private String editime;

    /**
     *修改者编号
    **/
    @JSONField(name="ediusrcode")
    private String ediusrcode;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *行政区划
    **/
    @JSONField(name="cancode")
    private String cancode;

    /**
     *负责人电话
    **/
    @JSONField(name="priphone")
    private String priphone;

    /**
     *经办人姓名
    **/
    @JSONField(name="doper")
    private String doper;

    /**
     *经办人电话
    **/
    @JSONField(name="doperphone")
    private String doperphone;

    /**
     *负责人姓名
    **/
    @JSONField(name="principal")
    private String principal;

    /**
     *行政区划对应地址
    **/
    @JSONField(name="cancodeaddress")
    private String cancodeaddress;

    /**
     *档案编号
    **/
    @JSONField(name="archisn")
    private String archisn;

    @JSONField(name="inscode")
    private String inscode;

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

    public String getGovderpid() {
        return govderpid;
    }

    public void setGovderpid(String govderpid) {
        this.govderpid = govderpid;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getIsbranch() {
        return isbranch;
    }

    public void setIsbranch(String isbranch) {
        this.isbranch = isbranch;
    }

    public String getHeadoffice() {
        return headoffice;
    }

    public void setHeadoffice(String headoffice) {
        this.headoffice = headoffice;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getOwnercode() {
        return ownercode;
    }

    public void setOwnercode(String ownercode) {
        this.ownercode = ownercode;
    }

    public char getOwnerstatus() {
        return ownerstatus;
    }

    public void setOwnerstatus(char ownerstatus) {
        this.ownerstatus = ownerstatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeresidents() {
        return homeresidents;
    }

    public void setHomeresidents(String homeresidents) {
        this.homeresidents = homeresidents;
    }

    public String getEnterpriseclass() {
        return enterpriseclass;
    }

    public void setEnterpriseclass(String enterpriseclass) {
        this.enterpriseclass = enterpriseclass;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDepttype() {
        return depttype;
    }

    public void setDepttype(String depttype) {
        this.depttype = depttype;
    }

    public String getComplaintsphone() {
        return complaintsphone;
    }

    public void setComplaintsphone(String complaintsphone) {
        this.complaintsphone = complaintsphone;
    }

    public String getFaxphone() {
        return faxphone;
    }

    public void setFaxphone(String faxphone) {
        this.faxphone = faxphone;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getIseffect() {
        return iseffect;
    }

    public void setIseffect(String iseffect) {
        this.iseffect = iseffect;
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

    public Double getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(Double sysopertime) {
        this.sysopertime = sysopertime;
    }

    public String getCancode() {
        return cancode;
    }

    public void setCancode(String cancode) {
        this.cancode = cancode;
    }

    public String getPriphone() {
        return priphone;
    }

    public void setPriphone(String priphone) {
        this.priphone = priphone;
    }

    public String getDoper() {
        return doper;
    }

    public void setDoper(String doper) {
        this.doper = doper;
    }

    public String getDoperphone() {
        return doperphone;
    }

    public void setDoperphone(String doperphone) {
        this.doperphone = doperphone;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getCancodeaddress() {
        return cancodeaddress;
    }

    public void setCancodeaddress(String cancodeaddress) {
        this.cancodeaddress = cancodeaddress;
    }

    public String getArchisn() {
        return archisn;
    }

    public void setArchisn(String archisn) {
        this.archisn = archisn;
    }

    public String getInscode() {
        return inscode;
    }

    public void setInscode(String inscode) {
        this.inscode = inscode;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getEconomicType() {
        return economicType;
    }

    public void setEconomicType(String economicType) {
        this.economicType = economicType;
    }
}