package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

//行政管理人员
public class XzglryDTO {

    //人员编码
    @JSONField(name = "rybm")
    private String rybm;

    //人员所在机构编码
    @JSONField(name = "jgbm")
    private String jgbm;

    //操作者名
    @JSONField(name = "operatorName")
    private String operatorName;

    //操作口令
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

    //申请口令校验码的MD5
    @JSONField(name = "md5")
    private String md5;

    //注销日期
    @JSONField(name = "zxrq")
    private String zxrq;

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm;
    }

    public String getJgbm() {
        return jgbm;
    }

    public void setJgbm(String jgbm) {
        this.jgbm = jgbm;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
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

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getZxrq() {
        return zxrq;
    }

    public void setZxrq(String zxrq) {
        this.zxrq = zxrq;
    }
}
