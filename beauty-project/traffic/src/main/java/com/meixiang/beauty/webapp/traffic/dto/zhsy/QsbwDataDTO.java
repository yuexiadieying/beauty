package com.meixiang.beauty.webapp.traffic.dto.zhsy;

import com.alibaba.fastjson.annotation.JSONField;

//全市泊位
public class QsbwDataDTO {

    //港口泊位基础数据
    @JSONField(name = "gkbwjcsj")
    private String gkbwjcsj;

    //港口泊位增长率，同比上月
    @JSONField(name = "gkbwjcsjRate")
    private String gkbwjcsjRate;

    //设计靠泊能力（吨级）
    @JSONField(name = "sjkbnl")
    private String sjkbnl;

    public String getGkbwjcsj() {
        return gkbwjcsj;
    }

    public void setGkbwjcsj(String gkbwjcsj) {
        this.gkbwjcsj = gkbwjcsj;
    }

    public String getGkbwjcsjRate() {
        return gkbwjcsjRate;
    }

    public void setGkbwjcsjRate(String gkbwjcsjRate) {
        this.gkbwjcsjRate = gkbwjcsjRate;
    }

    public String getSjkbnl() {
        return sjkbnl;
    }

    public void setSjkbnl(String sjkbnl) {
        this.sjkbnl = sjkbnl;
    }

}
