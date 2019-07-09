package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class Ttjjhjtgz0304DTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     * 年
     **/
    @JSONField(name="year")
    private Integer year;

    /**
     * 月
     **/
    @JSONField(name="month")
    private Integer month;

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }


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
     *旅客吞吐量
    **/
    @JSONField(name="gk03010102000000000000000000")
    private Double gk03010102000000000000000000;

    /**
     *沿海合计-旅客吞吐量
    **/
    @JSONField(name="gk03010102100000000000000000")
    private Double gk03010102100000000000000000;

    /**
     *内河合计-旅客吞吐量
    **/
    @JSONField(name="gk03010102200000000000000000")
    private Double gk03010102200000000000000000;

    /**
     *出港-旅客吞吐量
    **/
    @JSONField(name="gk03010102000010000000000000")
    private Double gk03010102000010000000000000;

    /**
     *进港-旅客吞吐量
    **/
    @JSONField(name="gk03010102000020000000000000")
    private Double gk03010102000020000000000000;

    /**
     *沿海合计-出港-旅客吞吐量
    **/
    @JSONField(name="gk03010102100010000000000000")
    private Double gk03010102100010000000000000;

    /**
     *内河合计-出港-旅客吞吐量
    **/
    @JSONField(name="gk03010102200010000000000000")
    private Double gk03010102200010000000000000;

    /**
     *滚装汽车吞吐量（车辆数）
    **/
    @JSONField(name="gk03010202000000015100000000")
    private Double gk03010202000000015100000000;

    /**
     *滚装汽车吞吐量（标辆数）
    **/
    @JSONField(name="gk03010202000000015200000000")
    private Double gk03010202000000015200000000;

    /**
     *滚装汽车吞吐量（重量数）
    **/
    @JSONField(name="gk03010202000000015300000000")
    private Double gk03010202000000015300000000;

    /**
     *沿海合计-集装箱吞吐量（箱数）
    **/
    @JSONField(name="gk03010202100000014100000000")
    private Double gk03010202100000014100000000;

    /**
     *沿海合计-集装箱吞吐量（重量）
    **/
    @JSONField(name="gk03010202100000014200000000")
    private Double gk03010202100000014200000000;

    /**
     *沿海合计-集装箱吞吐量（货重）
    **/
    @JSONField(name="gk03010202100000014300000000")
    private Double gk03010202100000014300000000;

    /**
     *沿海合计-滚装汽车吞吐量（车辆数）
    **/
    @JSONField(name="gk03010202100000015100000000")
    private Double gk03010202100000015100000000;

    /**
     *沿海合计-滚装汽车吞吐量（标辆数）
    **/
    @JSONField(name="gk03010202100000015200000000")
    private Double gk03010202100000015200000000;

    /**
     *沿海合计-滚装汽车吞吐量（重量数）
    **/
    @JSONField(name="gk03010202100000015300000000")
    private Double gk03010202100000015300000000;

    /**
     *内河合计-集装箱吞吐量（箱数）
    **/
    @JSONField(name="gk03010202200000014100000000")
    private Double gk03010202200000014100000000;

    /**
     *内河合计-集装箱吞吐量（重量）
    **/
    @JSONField(name="gk03010202200000014200000000")
    private Double gk03010202200000014200000000;

    /**
     *内河合计-集装箱吞吐量（货重）
    **/
    @JSONField(name="gk03010202200000014300000000")
    private Double gk03010202200000014300000000;

    /**
     *内河合计-滚装汽车吞吐量（车辆数）
    **/
    @JSONField(name="gk03010202200000015100000000")
    private Double gk03010202200000015100000000;

    /**
     *内河合计-滚装汽车吞吐量（标辆数）
    **/
    @JSONField(name="gk03010202200000015200000000")
    private Float gk03010202200000015200000000;

    /**
     *内河合计-滚装汽车吞吐量（重量数）
    **/
    @JSONField(name="gk03010202200000015300000000")
    private Double gk03010202200000015300000000;

    /**
     *沿海公用码头-集装箱吞吐量（箱数）
    **/
    @JSONField(name="gk03010202100100014100000000")
    private Double gk03010202100100014100000000;

    /**
     *沿海公用码头-集装箱吞吐量（重量）
    **/
    @JSONField(name="gk03010202100100014200000000")
    private Double gk03010202100100014200000000;

    /**
     *沿海公用码头-集装箱吞吐量（货重）
    **/
    @JSONField(name="gk03010202100100014300000000")
    private Double gk03010202100100014300000000;

    /**
     *沿海货主专用码头-集装箱吞吐量（箱数）
    **/
    @JSONField(name="gk03010202100200014100000000")
    private Double gk03010202100200014100000000;

    /**
     *沿海货主专用码头-集装箱吞吐量（重量）
    **/
    @JSONField(name="gk03010202100200014200000000")
    private Double gk03010202100200014200000000;

    /**
     *沿海货主专用码头-集装箱吞吐量（货重）
    **/
    @JSONField(name="gk03010202100200014300000000")
    private Double gk03010202100200014300000000;

    /**
     *内河公用码头-集装箱吞吐量（箱数）
    **/
    @JSONField(name="gk03010202200100014100000000")
    private Double gk03010202200100014100000000;

    /**
     *内河公用码头-集装箱吞吐量（重量）
    **/
    @JSONField(name="gk03010202200100014200000000")
    private Double gk03010202200100014200000000;

    /**
     *内河公用码头-集装箱吞吐量（货重）
    **/
    @JSONField(name="gk03010202200100014300000000")
    private Double gk03010202200100014300000000;

    /**
     *内河货主专用码头-集装箱吞吐量（箱数）
    **/
    @JSONField(name="gk03010202200200014100000000")
    private Double gk03010202200200014100000000;

    /**
     *内河货主专用码头-集装箱吞吐量（重量）
    **/
    @JSONField(name="gk03010202200200014200000000")
    private Double gk03010202200200014200000000;

    /**
     *内河货主专用码头-集装箱吞吐量（货重）
    **/
    @JSONField(name="gk03010202200200014300000000")
    private Double gk03010202200200014300000000;

    /**
     *合计-进出港旅客
    **/
    @JSONField(name="gk03010102000000000000000001")
    private Double gk03010102000000000000000001;

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

    public Double getGk03010102000000000000000000() {
        return gk03010102000000000000000000;
    }

    public void setGk03010102000000000000000000(Double gk03010102000000000000000000) {
        this.gk03010102000000000000000000 = gk03010102000000000000000000;
    }

    public Double getGk03010102100000000000000000() {
        return gk03010102100000000000000000;
    }

    public void setGk03010102100000000000000000(Double gk03010102100000000000000000) {
        this.gk03010102100000000000000000 = gk03010102100000000000000000;
    }

    public Double getGk03010102200000000000000000() {
        return gk03010102200000000000000000;
    }

    public void setGk03010102200000000000000000(Double gk03010102200000000000000000) {
        this.gk03010102200000000000000000 = gk03010102200000000000000000;
    }

    public Double getGk03010102000010000000000000() {
        return gk03010102000010000000000000;
    }

    public void setGk03010102000010000000000000(Double gk03010102000010000000000000) {
        this.gk03010102000010000000000000 = gk03010102000010000000000000;
    }

    public Double getGk03010102000020000000000000() {
        return gk03010102000020000000000000;
    }

    public void setGk03010102000020000000000000(Double gk03010102000020000000000000) {
        this.gk03010102000020000000000000 = gk03010102000020000000000000;
    }

    public Double getGk03010102100010000000000000() {
        return gk03010102100010000000000000;
    }

    public void setGk03010102100010000000000000(Double gk03010102100010000000000000) {
        this.gk03010102100010000000000000 = gk03010102100010000000000000;
    }

    public Double getGk03010102200010000000000000() {
        return gk03010102200010000000000000;
    }

    public void setGk03010102200010000000000000(Double gk03010102200010000000000000) {
        this.gk03010102200010000000000000 = gk03010102200010000000000000;
    }

    public Double getGk03010202000000015100000000() {
        return gk03010202000000015100000000;
    }

    public void setGk03010202000000015100000000(Double gk03010202000000015100000000) {
        this.gk03010202000000015100000000 = gk03010202000000015100000000;
    }

    public Double getGk03010202000000015200000000() {
        return gk03010202000000015200000000;
    }

    public void setGk03010202000000015200000000(Double gk03010202000000015200000000) {
        this.gk03010202000000015200000000 = gk03010202000000015200000000;
    }

    public Double getGk03010202000000015300000000() {
        return gk03010202000000015300000000;
    }

    public void setGk03010202000000015300000000(Double gk03010202000000015300000000) {
        this.gk03010202000000015300000000 = gk03010202000000015300000000;
    }

    public Double getGk03010202100000014100000000() {
        return gk03010202100000014100000000;
    }

    public void setGk03010202100000014100000000(Double gk03010202100000014100000000) {
        this.gk03010202100000014100000000 = gk03010202100000014100000000;
    }

    public Double getGk03010202100000014200000000() {
        return gk03010202100000014200000000;
    }

    public void setGk03010202100000014200000000(Double gk03010202100000014200000000) {
        this.gk03010202100000014200000000 = gk03010202100000014200000000;
    }

    public Double getGk03010202100000014300000000() {
        return gk03010202100000014300000000;
    }

    public void setGk03010202100000014300000000(Double gk03010202100000014300000000) {
        this.gk03010202100000014300000000 = gk03010202100000014300000000;
    }

    public Double getGk03010202100000015100000000() {
        return gk03010202100000015100000000;
    }

    public void setGk03010202100000015100000000(Double gk03010202100000015100000000) {
        this.gk03010202100000015100000000 = gk03010202100000015100000000;
    }

    public Double getGk03010202100000015200000000() {
        return gk03010202100000015200000000;
    }

    public void setGk03010202100000015200000000(Double gk03010202100000015200000000) {
        this.gk03010202100000015200000000 = gk03010202100000015200000000;
    }

    public Double getGk03010202100000015300000000() {
        return gk03010202100000015300000000;
    }

    public void setGk03010202100000015300000000(Double gk03010202100000015300000000) {
        this.gk03010202100000015300000000 = gk03010202100000015300000000;
    }

    public Double getGk03010202200000014100000000() {
        return gk03010202200000014100000000;
    }

    public void setGk03010202200000014100000000(Double gk03010202200000014100000000) {
        this.gk03010202200000014100000000 = gk03010202200000014100000000;
    }

    public Double getGk03010202200000014200000000() {
        return gk03010202200000014200000000;
    }

    public void setGk03010202200000014200000000(Double gk03010202200000014200000000) {
        this.gk03010202200000014200000000 = gk03010202200000014200000000;
    }

    public Double getGk03010202200000014300000000() {
        return gk03010202200000014300000000;
    }

    public void setGk03010202200000014300000000(Double gk03010202200000014300000000) {
        this.gk03010202200000014300000000 = gk03010202200000014300000000;
    }

    public Double getGk03010202200000015100000000() {
        return gk03010202200000015100000000;
    }

    public void setGk03010202200000015100000000(Double gk03010202200000015100000000) {
        this.gk03010202200000015100000000 = gk03010202200000015100000000;
    }

    public Float getGk03010202200000015200000000() {
        return gk03010202200000015200000000;
    }

    public void setGk03010202200000015200000000(Float gk03010202200000015200000000) {
        this.gk03010202200000015200000000 = gk03010202200000015200000000;
    }

    public Double getGk03010202200000015300000000() {
        return gk03010202200000015300000000;
    }

    public void setGk03010202200000015300000000(Double gk03010202200000015300000000) {
        this.gk03010202200000015300000000 = gk03010202200000015300000000;
    }

    public Double getGk03010202100100014100000000() {
        return gk03010202100100014100000000;
    }

    public void setGk03010202100100014100000000(Double gk03010202100100014100000000) {
        this.gk03010202100100014100000000 = gk03010202100100014100000000;
    }

    public Double getGk03010202100100014200000000() {
        return gk03010202100100014200000000;
    }

    public void setGk03010202100100014200000000(Double gk03010202100100014200000000) {
        this.gk03010202100100014200000000 = gk03010202100100014200000000;
    }

    public Double getGk03010202100100014300000000() {
        return gk03010202100100014300000000;
    }

    public void setGk03010202100100014300000000(Double gk03010202100100014300000000) {
        this.gk03010202100100014300000000 = gk03010202100100014300000000;
    }

    public Double getGk03010202100200014100000000() {
        return gk03010202100200014100000000;
    }

    public void setGk03010202100200014100000000(Double gk03010202100200014100000000) {
        this.gk03010202100200014100000000 = gk03010202100200014100000000;
    }

    public Double getGk03010202100200014200000000() {
        return gk03010202100200014200000000;
    }

    public void setGk03010202100200014200000000(Double gk03010202100200014200000000) {
        this.gk03010202100200014200000000 = gk03010202100200014200000000;
    }

    public Double getGk03010202100200014300000000() {
        return gk03010202100200014300000000;
    }

    public void setGk03010202100200014300000000(Double gk03010202100200014300000000) {
        this.gk03010202100200014300000000 = gk03010202100200014300000000;
    }

    public Double getGk03010202200100014100000000() {
        return gk03010202200100014100000000;
    }

    public void setGk03010202200100014100000000(Double gk03010202200100014100000000) {
        this.gk03010202200100014100000000 = gk03010202200100014100000000;
    }

    public Double getGk03010202200100014200000000() {
        return gk03010202200100014200000000;
    }

    public void setGk03010202200100014200000000(Double gk03010202200100014200000000) {
        this.gk03010202200100014200000000 = gk03010202200100014200000000;
    }

    public Double getGk03010202200100014300000000() {
        return gk03010202200100014300000000;
    }

    public void setGk03010202200100014300000000(Double gk03010202200100014300000000) {
        this.gk03010202200100014300000000 = gk03010202200100014300000000;
    }

    public Double getGk03010202200200014100000000() {
        return gk03010202200200014100000000;
    }

    public void setGk03010202200200014100000000(Double gk03010202200200014100000000) {
        this.gk03010202200200014100000000 = gk03010202200200014100000000;
    }

    public Double getGk03010202200200014200000000() {
        return gk03010202200200014200000000;
    }

    public void setGk03010202200200014200000000(Double gk03010202200200014200000000) {
        this.gk03010202200200014200000000 = gk03010202200200014200000000;
    }

    public Double getGk03010202200200014300000000() {
        return gk03010202200200014300000000;
    }

    public void setGk03010202200200014300000000(Double gk03010202200200014300000000) {
        this.gk03010202200200014300000000 = gk03010202200200014300000000;
    }

    public Double getGk03010102000000000000000001() {
        return gk03010102000000000000000001;
    }

    public void setGk03010102000000000000000001(Double gk03010102000000000000000001) {
        this.gk03010102000000000000000001 = gk03010102000000000000000001;
    }

}