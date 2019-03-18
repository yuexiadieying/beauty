package com.meixiang.beauty.common.dto.wexin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by zbm84 on 2017/6/7.
 */
public class WeixinShareDTO {

    @JSONField(name = "sysUserId")
    private String sysUserId;

    @JSONField(name = "userPhone")
    private String userPhone;

    @JSONField(name = "qrCodeURL")
    private String qrCodeURL;

    @JSONField(name = "shareCode")
    private String shareCode;

    @JSONField(name = "userImage")
    private String userImage;

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getQrCodeURL() {
        return qrCodeURL;
    }

    public void setQrCodeURL(String qrCodeURL) {
        this.qrCodeURL = qrCodeURL;
    }

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
