package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TGkmtEnterpriseusersDTO {

    /**
     *所在企业编码
    **/
    @JSONField(name="enterpriseNo")
    private Double enterpriseNo;

    /**
     *操作者名
    **/
    @JSONField(name="userName")
    private String userName;

    /**
     *2-10位字符，操作口令的MD5串
    **/
    @JSONField(name="userPassword")
    private String userPassword;

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
     *操作权限
    **/
    @JSONField(name="userRight")
    private String userRight;

    /**
     *申请口令校验码的MD5
    **/
    @JSONField(name="userVerifycode")
    private String userVerifycode;

    /**
     *注销日期
    **/
    @JSONField(name="unregisterDate")
    private Date unregisterDate;

    /**
     *前4位是GK$,后面是4-16个数字字母,其中为市州机构码的第2位
    **/
    @JSONField(name="userNo")
    private String userNo;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public Double getEnterpriseNo() {
        return enterpriseNo;
    }

    public void setEnterpriseNo(Double enterpriseNo) {
        this.enterpriseNo = enterpriseNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public String getUserRight() {
        return userRight;
    }

    public void setUserRight(String userRight) {
        this.userRight = userRight;
    }

    public String getUserVerifycode() {
        return userVerifycode;
    }

    public void setUserVerifycode(String userVerifycode) {
        this.userVerifycode = userVerifycode;
    }

    public Date getUnregisterDate() {
        return unregisterDate;
    }

    public void setUnregisterDate(Date unregisterDate) {
        this.unregisterDate = unregisterDate;
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

}