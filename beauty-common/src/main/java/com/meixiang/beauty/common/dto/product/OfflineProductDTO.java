package com.meixiang.beauty.common.dto.product;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class OfflineProductDTO {

    @JSONField(name = "productId")
    private String productId;

    @JSONField(name = "tag")
    private List<String> tag;

    @JSONField(name = "listPic")
    private List<String> listPic;

    @JSONField(name = "services")
    private List<String> services;

    @JSONField(name = "spec")
    private List<String> spec;

    @JSONField(name = "detailPic")
    private List<String> detailPic;

    @JSONField(name = "senderAddress")
    private String senderAddress;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public List<String> getListPic() {
        return listPic;
    }

    public void setListPic(List<String> listPic) {
        this.listPic = listPic;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public List<String> getSpec() {
        return spec;
    }

    public void setSpec(List<String> spec) {
        this.spec = spec;
    }

    public List<String> getDetailPic() {
        return detailPic;
    }

    public void setDetailPic(List<String> detailPic) {
        this.detailPic = detailPic;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
}