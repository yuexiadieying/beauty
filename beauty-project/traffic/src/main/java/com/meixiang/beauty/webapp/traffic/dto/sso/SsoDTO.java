package com.meixiang.beauty.webapp.traffic.dto.sso;

import com.alibaba.fastjson.annotation.JSONField;

//单点登录
public class SsoDTO {

    //第三方用户登录名
    @JSONField(name = "loginName")
    private String loginName;

    //第三方用户登录密码
    @JSONField(name = "loginPassword")
    private String loginPassword;

    //第三方平台标识 zhgj
    @JSONField(name = "platformFlag")
    private String platformFlag;

    //第三方平台名称 zhgj
    @JSONField(name = "platformName")
    private String platformName;

    //跟平台间约定的密钥 573824
    @JSONField(name = "platformSecret")
    private String platformSecret;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getPlatformFlag() {
        return platformFlag;
    }

    public void setPlatformFlag(String platformFlag) {
        this.platformFlag = platformFlag;
    }

    public String getPlatformSecret() {
        return platformSecret;
    }

    public void setPlatformSecret(String platformSecret) {
        this.platformSecret = platformSecret;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }
}
