package com.meixiang.beauty.webapp.education.dto.vpn;

import com.alibaba.fastjson.annotation.JSONField;

public class StatusDTO {

    @JSONField(name = "vpnServiceStartDate")
    private String vpnServiceStartDate;

    @JSONField(name = "vpnServiceEndDate")
    private String vpnServiceEndDate;

    @JSONField(name = "orderId")
    private String orderId;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
