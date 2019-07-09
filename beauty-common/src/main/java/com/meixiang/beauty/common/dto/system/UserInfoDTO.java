package com.meixiang.beauty.common.dto.system;

import com.alibaba.fastjson.annotation.JSONField;
import jxl.write.DateTime;

import java.util.Date;
import java.util.List;

public class UserInfoDTO {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "nickname")
    private String nickname;

    @JSONField(name = "loginName")
    private String loginName;

    @JSONField(name = "password")
    private String password;

    @JSONField(name = "userLevel")
    private List<String> userLevel;

    @JSONField(name = "email")
    private String email;

    //身份证号
    @JSONField(name = "departmentId")
    private String departmentId;

    //身份证号
    @JSONField(name = "departmentName")
    private String departmentName;

    //身份证号
    @JSONField(name = "roleId")
    private String roleId;

    //身份证号
    @JSONField(name = "roleName")
    private String roleName;

    //身份证号
    @JSONField(name = "identifyNumber")
    private String identifyNumber;

    @JSONField(name = "mobile")
    private String mobile;

    @JSONField(name = "userType")
    private String userType;

    @JSONField(name = "userOpenid")
    private String userOpenid;

    @JSONField(name = "parentUserId")
    private String parentUserId;

    @JSONField(name = "weixinAttentionStatus")
    private String weixinAttentionStatus;

    @JSONField(name = "photo")
    private String photo;

    @JSONField(name = "loginIp")
    private String loginIp;

    @JSONField(name = "loginDate")
    private Date loginDate;

    @JSONField(name = "createDate")
    private Date createDate;

    @JSONField(name = "delFlag")
    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }

    public String getWeixinAttentionStatus() {
        return weixinAttentionStatus;
    }

    public void setWeixinAttentionStatus(String weixinAttentionStatus) {
        this.weixinAttentionStatus = weixinAttentionStatus;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public List<String> getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(List<String> userLevel) {
        this.userLevel = userLevel;
    }


}