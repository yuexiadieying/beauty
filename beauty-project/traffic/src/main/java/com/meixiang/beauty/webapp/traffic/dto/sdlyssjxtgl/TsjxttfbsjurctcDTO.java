package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsjurctcDTO {


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
     *许可证字
    **/
    @JSONField(name="perword")
    private String perword;

    /**
     *业户类型
    **/
    @JSONField(name="ownertype")
    private String ownertype;

    /**
     *经营范围
    **/
    @JSONField(name="scopebusiness")
    private String scopebusiness;

    /**
     *核发日期
    **/
    @JSONField(name="gradate")
    private String gradate;

    /**
     *有效期起
    **/
    @JSONField(name="startdate")
    private String startdate;

    /**
     *有效期止
    **/
    @JSONField(name="enddate")
    private String enddate;

    /**
     *发证机关
    **/
    @JSONField(name="gradepcode")
    private String gradepcode;

    /**
     *经营状态
    **/
    @JSONField(name="operatingstate")
    private String operatingstate;

    /**
     *许可证号
    **/
    @JSONField(name="licensenumber")
    private String licensenumber;

    /**
     *经营性质
    **/
    @JSONField(name="managenature")
    private String managenature;

    /**
     *备注
    **/
    @JSONField(name="jurctcremark")
    private String jurctcremark;

    /**
     *维修类型
    **/
    @JSONField(name="repairclass")
    private String repairclass;

    /**
     *驾校级别
    **/
    @JSONField(name="drvschsort")
    private String drvschsort;

    /**
     *经营范围扩展
    **/
    @JSONField(name="scopeextend")
    private String scopeextend;

    /**
     *经营范围备份20160818
    **/
    @JSONField(name="scopeback")
    private String scopeback;

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

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getPerword() {
        return perword;
    }

    public void setPerword(String perword) {
        this.perword = perword;
    }

    public String getOwnertype() {
        return ownertype;
    }

    public void setOwnertype(String ownertype) {
        this.ownertype = ownertype;
    }

    public String getScopebusiness() {
        return scopebusiness;
    }

    public void setScopebusiness(String scopebusiness) {
        this.scopebusiness = scopebusiness;
    }

    public String getGradate() {
        return gradate;
    }

    public void setGradate(String gradate) {
        this.gradate = gradate;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getGradepcode() {
        return gradepcode;
    }

    public void setGradepcode(String gradepcode) {
        this.gradepcode = gradepcode;
    }

    public String getOperatingstate() {
        return operatingstate;
    }

    public void setOperatingstate(String operatingstate) {
        this.operatingstate = operatingstate;
    }

    public String getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    public String getManagenature() {
        return managenature;
    }

    public void setManagenature(String managenature) {
        this.managenature = managenature;
    }

    public String getJurctcremark() {
        return jurctcremark;
    }

    public void setJurctcremark(String jurctcremark) {
        this.jurctcremark = jurctcremark;
    }

    public String getRepairclass() {
        return repairclass;
    }

    public void setRepairclass(String repairclass) {
        this.repairclass = repairclass;
    }

    public String getDrvschsort() {
        return drvschsort;
    }

    public void setDrvschsort(String drvschsort) {
        this.drvschsort = drvschsort;
    }

    public String getScopeextend() {
        return scopeextend;
    }

    public void setScopeextend(String scopeextend) {
        this.scopeextend = scopeextend;
    }

    public String getScopeback() {
        return scopeback;
    }

    public void setScopeback(String scopeback) {
        this.scopeback = scopeback;
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