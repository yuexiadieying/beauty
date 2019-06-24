package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class Ttjjhgsgljc01DTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *行标识
    **/
    @JSONField(name="recid")
    private String recid;

    /**
     *行版本
    **/
    @JSONField(name="recver")
    private Double recver;

    /**
     *单位
    **/
    @JSONField(name="unitid")
    private String unitid;

    /**
     *数据时期
    **/
    @JSONField(name="datatime")
    private String datatime;

    /**
     *浮动行顺序号
    **/
    @JSONField(name="floatorder")
    private Double floatorder;

    /**
     *单位负责人
    **/
    @JSONField(name="gsgldwfzr")
    private String gsgldwfzr;

    /**
     *统计负责人
    **/
    @JSONField(name="gsgltjfzr")
    private String gsgltjfzr;

    /**
     *填表人
    **/
    @JSONField(name="gsgltbr")
    private String gsgltbr;

    /**
     *联系电话
    **/
    @JSONField(name="gsgllxdh")
    private String gsgllxdh;

    /**
     *报出日期
    **/
    @JSONField(name="gsglbcrq")
    private Date gsglbcrq;

    /**
     *货车流量
    **/
    @JSONField(name="hcll")
    private Double hcll;

    /**
     *货车流量-新增收费站
    **/
    @JSONField(name="hcllxz")
    private Double hcllxz;

    /**
     *货车流量-同期
    **/
    @JSONField(name="hclltb")
    private Double hclltb;

    /**
     *货车流量-自月初累计
    **/
    @JSONField(name="hcllylj")
    private Double hcllylj;

    /**
     *货车流量-自月初累计-新增收费站
    **/
    @JSONField(name="hcllyljxz")
    private Double hcllyljxz;

    /**
     *货车流量-自月初累计-同期
    **/
    @JSONField(name="hcllyljtb")
    private Double hcllyljtb;

    /**
     *货车流量-非省界收费站
    **/
    @JSONField(name="hcllfsj")
    private Double hcllfsj;

    /**
     *货车流量-非省界收费站-新增收费站
    **/
    @JSONField(name="hcllfsjxz")
    private Double hcllfsjxz;

    /**
     *货车流量-非省界收费站-同期
    **/
    @JSONField(name="hcllfsjtb")
    private Double hcllfsjtb;

    /**
     *货车流量-非省界收费站-自月初累计
    **/
    @JSONField(name="hcllfsjylj")
    private Double hcllfsjylj;

    /**
     *货车流量-非省界收费站-自月初累计-新增收费站
    **/
    @JSONField(name="hcllfsjyljxz")
    private Double hcllfsjyljxz;

    /**
     *货车流量-非省界收费站-自月初累计-同期
    **/
    @JSONField(name="hcllfsjyljtb")
    private Double hcllfsjyljtb;

    /**
     *货运量
    **/
    @JSONField(name="hyl")
    private Double hyl;

    /**
     *货运量-新增收费站
    **/
    @JSONField(name="hylxz")
    private Double hylxz;

    /**
     *货运量-同期
    **/
    @JSONField(name="hyltb")
    private Double hyltb;

    /**
     *货运量-自月初累计
    **/
    @JSONField(name="hylylj")
    private Double hylylj;

    /**
     *货运量-自月初累计-新增收费站
    **/
    @JSONField(name="hylyljxz")
    private Double hylyljxz;

    /**
     *货运量-自月初累计-同期
    **/
    @JSONField(name="hylyljtb")
    private Double hylyljtb;

    /**
     *货运量-非省界收费站
    **/
    @JSONField(name="hylfsj")
    private Double hylfsj;

    /**
     *货运量-非省界收费站-新增收费站
    **/
    @JSONField(name="hylfsjxz")
    private Double hylfsjxz;

    /**
     *货运量-非省界收费站-同期
    **/
    @JSONField(name="hylfsjtb")
    private Double hylfsjtb;

    /**
     *货运量-非省界收费站-自月初累计
    **/
    @JSONField(name="hylfsjylj")
    private Double hylfsjylj;

    /**
     *货运量-非省界收费站-自月初累计-新增收费站
    **/
    @JSONField(name="hylfsjyljxz")
    private Double hylfsjyljxz;

    /**
     *货运量-非省界收费站-自月初累计-同期
    **/
    @JSONField(name="hylfsjyljtb")
    private Double hylfsjyljtb;

    /**
     *货运周转量
    **/
    @JSONField(name="hyzzl")
    private Double hyzzl;

    /**
     *货运周转量-新增收费站
    **/
    @JSONField(name="hyzzlxz")
    private Double hyzzlxz;

    /**
     *货运周转量-同期
    **/
    @JSONField(name="hyzzltb")
    private Double hyzzltb;

    /**
     *货运周转量-自月初累计
    **/
    @JSONField(name="hyzzlylj")
    private Double hyzzlylj;

    /**
     *货运周转量-自月初累计-同期
    **/
    @JSONField(name="hyzzlyljtb")
    private Double hyzzlyljtb;

    /**
     *货运周转量-自月初累计-新增收费站
    **/
    @JSONField(name="hyzzlyljxz")
    private Double hyzzlyljxz;

    public String getRecid() {
        return recid;
    }

    public void setRecid(String recid) {
        this.recid = recid;
    }

    public Double getRecver() {
        return recver;
    }

    public void setRecver(Double recver) {
        this.recver = recver;
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public Double getFloatorder() {
        return floatorder;
    }

    public void setFloatorder(Double floatorder) {
        this.floatorder = floatorder;
    }

    public String getGsgldwfzr() {
        return gsgldwfzr;
    }

    public void setGsgldwfzr(String gsgldwfzr) {
        this.gsgldwfzr = gsgldwfzr;
    }

    public String getGsgltjfzr() {
        return gsgltjfzr;
    }

    public void setGsgltjfzr(String gsgltjfzr) {
        this.gsgltjfzr = gsgltjfzr;
    }

    public String getGsgltbr() {
        return gsgltbr;
    }

    public void setGsgltbr(String gsgltbr) {
        this.gsgltbr = gsgltbr;
    }

    public String getGsgllxdh() {
        return gsgllxdh;
    }

    public void setGsgllxdh(String gsgllxdh) {
        this.gsgllxdh = gsgllxdh;
    }

    public Date getGsglbcrq() {
        return gsglbcrq;
    }

    public void setGsglbcrq(Date gsglbcrq) {
        this.gsglbcrq = gsglbcrq;
    }

    public Double getHcll() {
        return hcll;
    }

    public void setHcll(Double hcll) {
        this.hcll = hcll;
    }

    public Double getHcllxz() {
        return hcllxz;
    }

    public void setHcllxz(Double hcllxz) {
        this.hcllxz = hcllxz;
    }

    public Double getHclltb() {
        return hclltb;
    }

    public void setHclltb(Double hclltb) {
        this.hclltb = hclltb;
    }

    public Double getHcllylj() {
        return hcllylj;
    }

    public void setHcllylj(Double hcllylj) {
        this.hcllylj = hcllylj;
    }

    public Double getHcllyljxz() {
        return hcllyljxz;
    }

    public void setHcllyljxz(Double hcllyljxz) {
        this.hcllyljxz = hcllyljxz;
    }

    public Double getHcllyljtb() {
        return hcllyljtb;
    }

    public void setHcllyljtb(Double hcllyljtb) {
        this.hcllyljtb = hcllyljtb;
    }

    public Double getHcllfsj() {
        return hcllfsj;
    }

    public void setHcllfsj(Double hcllfsj) {
        this.hcllfsj = hcllfsj;
    }

    public Double getHcllfsjxz() {
        return hcllfsjxz;
    }

    public void setHcllfsjxz(Double hcllfsjxz) {
        this.hcllfsjxz = hcllfsjxz;
    }

    public Double getHcllfsjtb() {
        return hcllfsjtb;
    }

    public void setHcllfsjtb(Double hcllfsjtb) {
        this.hcllfsjtb = hcllfsjtb;
    }

    public Double getHcllfsjylj() {
        return hcllfsjylj;
    }

    public void setHcllfsjylj(Double hcllfsjylj) {
        this.hcllfsjylj = hcllfsjylj;
    }

    public Double getHcllfsjyljxz() {
        return hcllfsjyljxz;
    }

    public void setHcllfsjyljxz(Double hcllfsjyljxz) {
        this.hcllfsjyljxz = hcllfsjyljxz;
    }

    public Double getHcllfsjyljtb() {
        return hcllfsjyljtb;
    }

    public void setHcllfsjyljtb(Double hcllfsjyljtb) {
        this.hcllfsjyljtb = hcllfsjyljtb;
    }

    public Double getHyl() {
        return hyl;
    }

    public void setHyl(Double hyl) {
        this.hyl = hyl;
    }

    public Double getHylxz() {
        return hylxz;
    }

    public void setHylxz(Double hylxz) {
        this.hylxz = hylxz;
    }

    public Double getHyltb() {
        return hyltb;
    }

    public void setHyltb(Double hyltb) {
        this.hyltb = hyltb;
    }

    public Double getHylylj() {
        return hylylj;
    }

    public void setHylylj(Double hylylj) {
        this.hylylj = hylylj;
    }

    public Double getHylyljxz() {
        return hylyljxz;
    }

    public void setHylyljxz(Double hylyljxz) {
        this.hylyljxz = hylyljxz;
    }

    public Double getHylyljtb() {
        return hylyljtb;
    }

    public void setHylyljtb(Double hylyljtb) {
        this.hylyljtb = hylyljtb;
    }

    public Double getHylfsj() {
        return hylfsj;
    }

    public void setHylfsj(Double hylfsj) {
        this.hylfsj = hylfsj;
    }

    public Double getHylfsjxz() {
        return hylfsjxz;
    }

    public void setHylfsjxz(Double hylfsjxz) {
        this.hylfsjxz = hylfsjxz;
    }

    public Double getHylfsjtb() {
        return hylfsjtb;
    }

    public void setHylfsjtb(Double hylfsjtb) {
        this.hylfsjtb = hylfsjtb;
    }

    public Double getHylfsjylj() {
        return hylfsjylj;
    }

    public void setHylfsjylj(Double hylfsjylj) {
        this.hylfsjylj = hylfsjylj;
    }

    public Double getHylfsjyljxz() {
        return hylfsjyljxz;
    }

    public void setHylfsjyljxz(Double hylfsjyljxz) {
        this.hylfsjyljxz = hylfsjyljxz;
    }

    public Double getHylfsjyljtb() {
        return hylfsjyljtb;
    }

    public void setHylfsjyljtb(Double hylfsjyljtb) {
        this.hylfsjyljtb = hylfsjyljtb;
    }

    public Double getHyzzl() {
        return hyzzl;
    }

    public void setHyzzl(Double hyzzl) {
        this.hyzzl = hyzzl;
    }

    public Double getHyzzlxz() {
        return hyzzlxz;
    }

    public void setHyzzlxz(Double hyzzlxz) {
        this.hyzzlxz = hyzzlxz;
    }

    public Double getHyzzltb() {
        return hyzzltb;
    }

    public void setHyzzltb(Double hyzzltb) {
        this.hyzzltb = hyzzltb;
    }

    public Double getHyzzlylj() {
        return hyzzlylj;
    }

    public void setHyzzlylj(Double hyzzlylj) {
        this.hyzzlylj = hyzzlylj;
    }

    public Double getHyzzlyljtb() {
        return hyzzlyljtb;
    }

    public void setHyzzlyljtb(Double hyzzlyljtb) {
        this.hyzzlyljtb = hyzzlyljtb;
    }

    public Double getHyzzlyljxz() {
        return hyzzlyljxz;
    }

    public void setHyzzlyljxz(Double hyzzlyljxz) {
        this.hyzzlyljxz = hyzzlyljxz;
    }

}