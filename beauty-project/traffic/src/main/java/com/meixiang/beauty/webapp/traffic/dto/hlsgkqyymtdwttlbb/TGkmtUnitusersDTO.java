package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TGkmtUnitusersDTO {

    /**
     *操作者名
    **/
    @JSONField(name="userName")
    private String userName;

    /**
     *用户所在机构编码
    **/
    @JSONField(name="unitNo")
    private String unitNo;

    /**
     *2-10位字，操作口令的MD5串
    **/
    @JSONField(name="userPassword")
    private String userPassword;

    /**
     *操作权限
    **/
    @JSONField(name="userRight")
    private String userRight;

    /**
     *创建时间
    **/
    @JSONField(name="userCreatedate")
    private Date userCreatedate;

    /**
     *帐号状态
    **/
    @JSONField(name="userStatus")
    private String userStatus;

    /**
     *最近修改密码时间
    **/
    @JSONField(name="userChangepswdate")
    private Date userChangepswdate;

    /**
     *联系电话
    **/
    @JSONField(name="userMobile")
    private String userMobile;

    /**
     *申请口令校验码的MD5
    **/
    @JSONField(name="userVerifycode")
    private String userVerifycode;

    /**
     *前4位是机构编码+$,后面是4-16个数字或字母
    **/
    @JSONField(name="userNo")
    private String userNo;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    /**
     *注销日期
    **/
    @JSONField(name="unregisterDate")
    private Date unregisterDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRight() {
        return userRight;
    }

    public void setUserRight(String userRight) {
        this.userRight = userRight;
    }

    public Date getUserCreatedate() {
        return userCreatedate;
    }

    public void setUserCreatedate(Date userCreatedate) {
        this.userCreatedate = userCreatedate;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserChangepswdate() {
        return userChangepswdate;
    }

    public void setUserChangepswdate(Date userChangepswdate) {
        this.userChangepswdate = userChangepswdate;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserVerifycode() {
        return userVerifycode;
    }

    public void setUserVerifycode(String userVerifycode) {
        this.userVerifycode = userVerifycode;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getUnregisterDate() {
        return unregisterDate;
    }

    public void setUnregisterDate(Date unregisterDate) {
        this.unregisterDate = unregisterDate;
    }

}