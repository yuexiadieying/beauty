package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

//港口企业和码头单位名录
public class GkqymlDTO {

    //唯一标识号
    @JSONField(name = "wybsh")
    private String wybsh;

    //报表年份
    @JSONField(name = "bbnf")
    private String bbnf;

    //辖机构编码
    @JSONField(name = "xjgbm")
    private String xjgbm;

    //经济类型
    @JSONField(name = "jjlx")
    private String jjlx;

    //联系电话
    @JSONField(name = "lxdh")
    private String lxdh;

    //报表填报人（联系人）
    @JSONField(name = "bbtbr")
    private String bbtbr;

    //创建报告期
    @JSONField(name = "cjbgq")
    private String cjbgq;

    //注销时的报告期
    @JSONField(name = "zxbgq")
    private String zxbgq;

    //企业状态
    @JSONField(name = "qyzt")
    private String qyzt;

    public String getWybsh() {
        return wybsh;
    }

    public void setWybsh(String wybsh) {
        this.wybsh = wybsh;
    }

    public String getBbnf() {
        return bbnf;
    }

    public void setBbnf(String bbnf) {
        this.bbnf = bbnf;
    }

    public String getXjgbm() {
        return xjgbm;
    }

    public void setXjgbm(String xjgbm) {
        this.xjgbm = xjgbm;
    }

    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getBbtbr() {
        return bbtbr;
    }

    public void setBbtbr(String bbtbr) {
        this.bbtbr = bbtbr;
    }

    public String getCjbgq() {
        return cjbgq;
    }

    public void setCjbgq(String cjbgq) {
        this.cjbgq = cjbgq;
    }

    public String getZxbgq() {
        return zxbgq;
    }

    public void setZxbgq(String zxbgq) {
        this.zxbgq = zxbgq;
    }

    public String getQyzt() {
        return qyzt;
    }

    public void setQyzt(String qyzt) {
        this.qyzt = qyzt;
    }
}
