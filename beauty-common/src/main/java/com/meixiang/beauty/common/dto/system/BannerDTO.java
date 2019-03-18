package com.meixiang.beauty.common.dto.system;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by zbm84 on 2017/8/3.
 */
public class BannerDTO {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "uri")
    private String uri;

    @JSONField(name = "status")
    private String status;

    @JSONField(name = "place")
    private String place;

    @JSONField(name = "forward")
    private String forward;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }
}
