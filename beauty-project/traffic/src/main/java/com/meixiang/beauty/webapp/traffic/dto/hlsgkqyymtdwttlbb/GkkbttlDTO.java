package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

//港口快报吞吐量
public class GkkbttlDTO {

    //港区编号
    @JSONField(name = "qgtygqbh")
    private String qgtygqbh;

    //报表报告
    @JSONField(name = "bbbg")
    private String bbbg;

    //报表行号
    @JSONField(name = "bbhh")
    private String bbhh;

    //合计
    @JSONField(name = "heji")
    private String heji;

    //外贸
    @JSONField(name = "waimao")
    private String waimao;

    //出港数据
    @JSONField(name = "cgsj")
    private String cgsj;

    //进港数据
    @JSONField(name = "jgsj")
    private String jgsj;

    public String getQgtygqbh() {
        return qgtygqbh;
    }

    public void setQgtygqbh(String qgtygqbh) {
        this.qgtygqbh = qgtygqbh;
    }

    public String getBbbg() {
        return bbbg;
    }

    public void setBbbg(String bbbg) {
        this.bbbg = bbbg;
    }

    public String getBbhh() {
        return bbhh;
    }

    public void setBbhh(String bbhh) {
        this.bbhh = bbhh;
    }

    public String getHeji() {
        return heji;
    }

    public void setHeji(String heji) {
        this.heji = heji;
    }

    public String getWaimao() {
        return waimao;
    }

    public void setWaimao(String waimao) {
        this.waimao = waimao;
    }

    public String getCgsj() {
        return cgsj;
    }

    public void setCgsj(String cgsj) {
        this.cgsj = cgsj;
    }

    public String getJgsj() {
        return jgsj;
    }

    public void setJgsj(String jgsj) {
        this.jgsj = jgsj;
    }

}
