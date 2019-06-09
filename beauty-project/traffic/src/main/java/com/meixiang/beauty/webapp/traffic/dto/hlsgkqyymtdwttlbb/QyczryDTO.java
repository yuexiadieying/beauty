package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

//企业操作人员
public class QyczryDTO {

    //人员编号
    @JSONField(name = "rybh")
    private String rybh;

    //所在企业编号
    @JSONField(name = "qybh")
    private String qybh;

    //操作者名
    @JSONField(name = "czzm")
    private String czzm;

    //密码
    @JSONField(name = "password")
    private String password;

    //创建时间
    @JSONField(name = "createDate")
    private String createDate;

    //账号状态
    @JSONField(name = "zhzt")
    private String zhzt;

    //最近修改密码时间
    @JSONField(name = "passwordUpdateDate")
    private String passwordUpdateDate;

    //联系电话
    @JSONField(name = "phone")
    private String phone;

    //操作权限
    @JSONField(name = "operateLevel")
    private String operateLevel;

    //申请口令校验码
    @JSONField(name = "sqkljym")
    private String sqkljym;

    //注销日期
    @JSONField(name = "zxrq")
    private String zxrq;

    public String getRybh() {
        return rybh;
    }

    public void setRybh(String rybh) {
        this.rybh = rybh;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getCzzm() {
        return czzm;
    }

    public void setCzzm(String czzm) {
        this.czzm = czzm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getZhzt() {
        return zhzt;
    }

    public void setZhzt(String zhzt) {
        this.zhzt = zhzt;
    }

    public String getPasswordUpdateDate() {
        return passwordUpdateDate;
    }

    public void setPasswordUpdateDate(String passwordUpdateDate) {
        this.passwordUpdateDate = passwordUpdateDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOperateLevel() {
        return operateLevel;
    }

    public void setOperateLevel(String operateLevel) {
        this.operateLevel = operateLevel;
    }

    public String getSqkljym() {
        return sqkljym;
    }

    public void setSqkljym(String sqkljym) {
        this.sqkljym = sqkljym;
    }

    public String getZxrq() {
        return zxrq;
    }

    public void setZxrq(String zxrq) {
        this.zxrq = zxrq;
    }
}
