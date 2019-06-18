package com.meixiang.beauty.webapp.traffic.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class UserInfoDTO<T> {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "userName")
    private String userName;

    @JSONField(name = "password")
    private String password;

    @JSONField(name = "userType")
    private String userType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
