package com.meixiang.beauty.webapp.education.dto.vpn;

import com.alibaba.fastjson.annotation.JSONField;

public class VpnOrderDTO {

    @JSONField(name = "orderId")
    private String orderId;

    @JSONField(name = "userEmail")
    private String userEmail;

    @JSONField(name = "vpnServiceStartDate")
    private String vpnServiceStartDate;

    @JSONField(name = "vpnServiceEndDate")
    private String vpnServiceEndDate;

    //0表示过期，1表示有效
    @JSONField(name = "status")
    private String status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getVpnServiceStartDate() {
        return vpnServiceStartDate;
    }

    public void setVpnServiceStartDate(String vpnServiceStartDate) {
        this.vpnServiceStartDate = vpnServiceStartDate;
    }

    public String getVpnServiceEndDate() {
        return vpnServiceEndDate;
    }

    public void setVpnServiceEndDate(String vpnServiceEndDate) {
        this.vpnServiceEndDate = vpnServiceEndDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
