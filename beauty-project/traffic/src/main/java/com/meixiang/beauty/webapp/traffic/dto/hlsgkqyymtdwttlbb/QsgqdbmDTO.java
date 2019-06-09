package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

//全省港区代表码
public class QsgqdbmDTO {

    //全国统一港区编号
    @JSONField(name = "qgtygqbh")
    private String qgtygqbh;

    //港区名称
    @JSONField(name = "gqmc")
    private String gqmc;

    //所在区域
    @JSONField(name = "szsy")
    private String szsy;

    //所在水系
    @JSONField(name = "szsx")
    private String szsx;

    //港区管理单位
    @JSONField(name = "gqgldw")
    private String gqgldw;

    public String getQgtygqbh() {
        return qgtygqbh;
    }

    public void setQgtygqbh(String qgtygqbh) {
        this.qgtygqbh = qgtygqbh;
    }

    public String getGqmc() {
        return gqmc;
    }

    public void setGqmc(String gqmc) {
        this.gqmc = gqmc;
    }

    public String getSzsy() {
        return szsy;
    }

    public void setSzsy(String szsy) {
        this.szsy = szsy;
    }

    public String getSzsx() {
        return szsx;
    }

    public void setSzsx(String szsx) {
        this.szsx = szsx;
    }

    public String getGqgldw() {
        return gqgldw;
    }

    public void setGqgldw(String gqgldw) {
        this.gqgldw = gqgldw;
    }
}
