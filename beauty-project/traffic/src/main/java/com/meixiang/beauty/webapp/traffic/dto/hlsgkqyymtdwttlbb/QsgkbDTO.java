package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

//全省港区代表码
public class QsgkbDTO {

    //全国统一港区编号
    @JSONField(name = "qgtygqbh")
    private String qgtygqbh;

    //港口名称
    @JSONField(name = "gkmc")
    private String gkmc;

    //港口归属机构编码
    @JSONField(name = "gkgsjgbm")
    private String gkgsjgbm;

    //报告期类型
    @JSONField(name = "bgqlx")
    private String bgqlx;

    //港口管理单位
    @JSONField(name = "gkgldw")
    private String gkgldw;

    public String getQgtygqbh() {
        return qgtygqbh;
    }

    public void setQgtygqbh(String qgtygqbh) {
        this.qgtygqbh = qgtygqbh;
    }

    public String getGkmc() {
        return gkmc;
    }

    public void setGkmc(String gkmc) {
        this.gkmc = gkmc;
    }

    public String getGkgsjgbm() {
        return gkgsjgbm;
    }

    public void setGkgsjgbm(String gkgsjgbm) {
        this.gkgsjgbm = gkgsjgbm;
    }

    public String getBgqlx() {
        return bgqlx;
    }

    public void setBgqlx(String bgqlx) {
        this.bgqlx = bgqlx;
    }

    public String getGkgldw() {
        return gkgldw;
    }

    public void setGkgldw(String gkgldw) {
        this.gkgldw = gkgldw;
    }
}
