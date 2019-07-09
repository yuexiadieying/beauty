package com.meixiang.beauty.webapp.traffic.dto.system;

import com.alibaba.fastjson.annotation.JSONField;

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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(List<String> userLevel) {
        this.userLevel = userLevel;
    }
}
