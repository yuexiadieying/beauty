package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class Ttjjhjtg92DTO {


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
     *快报-本月-旅客吞吐量
    **/
    @JSONField(name="gk03010102000000k00000010000")
    private Double gk03010102000000k00000010000;

    /**
     *快报-本月-货物吞吐量
    **/
    @JSONField(name="gk03010202000000k00000020000")
    private Double gk03010202000000k00000020000;

    /**
     *快报-本月-外贸货物吞吐量
    **/
    @JSONField(name="gk03010202000000k00000030000")
    private Double gk03010202000000k00000030000;

    /**
     *快报-本月-集装箱吞吐量
    **/
    @JSONField(name="gk03010202000000k00000040000")
    private Double gk03010202000000k00000040000;

    /**
     *快报-本月-集装吞吐量-货重
    **/
    @JSONField(name="gk03010202000000k00000050000")
    private Double gk03010202000000k00000050000;

    /**
     *快报-年初至上月累计-旅客吞吐量
    **/
    @JSONField(name="gk03010202000000k00000060000")
    private Double gk03010202000000k00000060000;

    /**
     *快报-年初至上月累计-货物吞吐量
    **/
    @JSONField(name="gk03010202000000k00000070000")
    private Double gk03010202000000k00000070000;

    /**
     *快报-年初至上月累计-外贸货物吞吐量
    **/
    @JSONField(name="gk03010202000000k00000080000")
    private Double gk03010202000000k00000080000;

    /**
     *快报-年初至上月累计-集装箱吞吐量
    **/
    @JSONField(name="gk03010202000000k00000090000")
    private Double gk03010202000000k00000090000;

    /**
     *快报-年初至上月累计-集装吞吐量-货重
    **/
    @JSONField(name="gk03010202000000k00000100000")
    private Double gk03010202000000k00000100000;

    /**
     *快报-年底实有数-生产用泊位个数
    **/
    @JSONField(name="gk01010102000000k00000110000")
    private Double gk01010102000000k00000110000;

    /**
     *快报-年底实有数-万吨级以上泊位
    **/
    @JSONField(name="gk01010102000000k00000120000")
    private Double gk01010102000000k00000120000;

    /**
     *快报-年底实有数-泊位通过能力
    **/
    @JSONField(name="gk01010102000000k00000130000")
    private Double gk01010102000000k00000130000;

    /**
     *快报-本月-沿海合计-旅客吞吐量
    **/
    @JSONField(name="gk03010102100000k00000010000")
    private Double gk03010102100000k00000010000;

    /**
     *快报-本月-沿海合计-货物吞吐量
    **/
    @JSONField(name="gk03010202100000k00000020000")
    private Double gk03010202100000k00000020000;

    /**
     *快报-本月-沿海合计-外贸货物吞吐量
    **/
    @JSONField(name="gk03010202100000k00000030000")
    private Double gk03010202100000k00000030000;

    /**
     *快报-本月-沿海合计-集装箱吞吐量
    **/
    @JSONField(name="gk03010202100000k00000040000")
    private Double gk03010202100000k00000040000;

    /**
     *快报-本月-沿海合计-集装吞吐量-货重
    **/
    @JSONField(name="gk03010202100000k00000050000")
    private Double gk03010202100000k00000050000;

    /**
     *快报-年初至上月累计-沿海合计-旅客吞吐量
    **/
    @JSONField(name="gk03010202100000k00000060000")
    private Double gk03010202100000k00000060000;

    /**
     *快报-年初至上月累计-沿海合计-货物吞吐量
    **/
    @JSONField(name="gk03010202100000k00000070000")
    private Double gk03010202100000k00000070000;

    /**
     *快报-年初至上月累计-沿海合计-外贸货物吞吐量
    **/
    @JSONField(name="gk03010202100000k00000080000")
    private Double gk03010202100000k00000080000;

    /**
     *快报-年初至上月累计-沿海合计-集装箱吞吐量
    **/
    @JSONField(name="gk03010202100000k00000090000")
    private Double gk03010202100000k00000090000;

    /**
     *快报-年初至上月累计-沿海合计-集装吞吐量-货重
    **/
    @JSONField(name="gk03010202100000k00000100000")
    private Double gk03010202100000k00000100000;

    /**
     *快报-年底实有数-沿海合计-生产用泊位个数
    **/
    @JSONField(name="gk01010102100000k00000110000")
    private Double gk01010102100000k00000110000;

    /**
     *快报-年底实有数-沿海合计-万吨级以上泊位
    **/
    @JSONField(name="gk01010102100000k00000120000")
    private Double gk01010102100000k00000120000;

    /**
     *快报-年底实有数-沿海合计-泊位通过能力
    **/
    @JSONField(name="gk01010102100000k00000130000")
    private Double gk01010102100000k00000130000;

    /**
     *快报-本月-内河合计-旅客吞吐量
    **/
    @JSONField(name="gk03010102200000k00000010000")
    private Double gk03010102200000k00000010000;

    /**
     *快报-本月-内河合计-货物吞吐量
    **/
    @JSONField(name="gk03010202200000k00000020000")
    private Double gk03010202200000k00000020000;

    /**
     *快报-本月-内河合计-外贸货物吞吐量
    **/
    @JSONField(name="gk03010202200000k00000030000")
    private Double gk03010202200000k00000030000;

    /**
     *快报-本月-内河合计-集装箱吞吐量
    **/
    @JSONField(name="gk03010202200000k00000040000")
    private Double gk03010202200000k00000040000;

    /**
     *快报-本月-内河合计-集装吞吐量-货重
    **/
    @JSONField(name="gk03010202200000k00000050000")
    private Double gk03010202200000k00000050000;

    /**
     *快报-年初至上月累计-内河合计-旅客吞吐量
    **/
    @JSONField(name="gk03010202200000k00000060000")
    private Double gk03010202200000k00000060000;

    /**
     *快报-年初至上月累计-内河合计-货物吞吐量
    **/
    @JSONField(name="gk03010202200000k00000070000")
    private Double gk03010202200000k00000070000;

    /**
     *快报-年初至上月累计-内河合计-外贸货物吞吐量
    **/
    @JSONField(name="gk03010202200000k00000080000")
    private Double gk03010202200000k00000080000;

    /**
     *快报-年初至上月累计-内河合计-集装箱吞吐量
    **/
    @JSONField(name="gk03010202200000k00000090000")
    private Double gk03010202200000k00000090000;

    /**
     *快报-年初至上月累计-内河合计-集装吞吐量-货重
    **/
    @JSONField(name="gk03010202200000k00000100000")
    private Double gk03010202200000k00000100000;

    /**
     *快报-年底实有数-内河合计-生产用泊位个数
    **/
    @JSONField(name="gk01010102200000k00000110000")
    private Double gk01010102200000k00000110000;

    /**
     *快报-年底实有数-内河合计-万吨级以上泊位
    **/
    @JSONField(name="gk01010102200000k00000120000")
    private Double gk01010102200000k00000120000;

    /**
     *快报-年底实有数-内河合计-泊位通过能力
    **/
    @JSONField(name="gk01010102200000k00000130000")
    private Double gk01010102200000k00000130000;

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

    public Double getGk03010102000000k00000010000() {
        return gk03010102000000k00000010000;
    }

    public void setGk03010102000000k00000010000(Double gk03010102000000k00000010000) {
        this.gk03010102000000k00000010000 = gk03010102000000k00000010000;
    }

    public Double getGk03010202000000k00000020000() {
        return gk03010202000000k00000020000;
    }

    public void setGk03010202000000k00000020000(Double gk03010202000000k00000020000) {
        this.gk03010202000000k00000020000 = gk03010202000000k00000020000;
    }

    public Double getGk03010202000000k00000030000() {
        return gk03010202000000k00000030000;
    }

    public void setGk03010202000000k00000030000(Double gk03010202000000k00000030000) {
        this.gk03010202000000k00000030000 = gk03010202000000k00000030000;
    }

    public Double getGk03010202000000k00000040000() {
        return gk03010202000000k00000040000;
    }

    public void setGk03010202000000k00000040000(Double gk03010202000000k00000040000) {
        this.gk03010202000000k00000040000 = gk03010202000000k00000040000;
    }

    public Double getGk03010202000000k00000050000() {
        return gk03010202000000k00000050000;
    }

    public void setGk03010202000000k00000050000(Double gk03010202000000k00000050000) {
        this.gk03010202000000k00000050000 = gk03010202000000k00000050000;
    }

    public Double getGk03010202000000k00000060000() {
        return gk03010202000000k00000060000;
    }

    public void setGk03010202000000k00000060000(Double gk03010202000000k00000060000) {
        this.gk03010202000000k00000060000 = gk03010202000000k00000060000;
    }

    public Double getGk03010202000000k00000070000() {
        return gk03010202000000k00000070000;
    }

    public void setGk03010202000000k00000070000(Double gk03010202000000k00000070000) {
        this.gk03010202000000k00000070000 = gk03010202000000k00000070000;
    }

    public Double getGk03010202000000k00000080000() {
        return gk03010202000000k00000080000;
    }

    public void setGk03010202000000k00000080000(Double gk03010202000000k00000080000) {
        this.gk03010202000000k00000080000 = gk03010202000000k00000080000;
    }

    public Double getGk03010202000000k00000090000() {
        return gk03010202000000k00000090000;
    }

    public void setGk03010202000000k00000090000(Double gk03010202000000k00000090000) {
        this.gk03010202000000k00000090000 = gk03010202000000k00000090000;
    }

    public Double getGk03010202000000k00000100000() {
        return gk03010202000000k00000100000;
    }

    public void setGk03010202000000k00000100000(Double gk03010202000000k00000100000) {
        this.gk03010202000000k00000100000 = gk03010202000000k00000100000;
    }

    public Double getGk01010102000000k00000110000() {
        return gk01010102000000k00000110000;
    }

    public void setGk01010102000000k00000110000(Double gk01010102000000k00000110000) {
        this.gk01010102000000k00000110000 = gk01010102000000k00000110000;
    }

    public Double getGk01010102000000k00000120000() {
        return gk01010102000000k00000120000;
    }

    public void setGk01010102000000k00000120000(Double gk01010102000000k00000120000) {
        this.gk01010102000000k00000120000 = gk01010102000000k00000120000;
    }

    public Double getGk01010102000000k00000130000() {
        return gk01010102000000k00000130000;
    }

    public void setGk01010102000000k00000130000(Double gk01010102000000k00000130000) {
        this.gk01010102000000k00000130000 = gk01010102000000k00000130000;
    }

    public Double getGk03010102100000k00000010000() {
        return gk03010102100000k00000010000;
    }

    public void setGk03010102100000k00000010000(Double gk03010102100000k00000010000) {
        this.gk03010102100000k00000010000 = gk03010102100000k00000010000;
    }

    public Double getGk03010202100000k00000020000() {
        return gk03010202100000k00000020000;
    }

    public void setGk03010202100000k00000020000(Double gk03010202100000k00000020000) {
        this.gk03010202100000k00000020000 = gk03010202100000k00000020000;
    }

    public Double getGk03010202100000k00000030000() {
        return gk03010202100000k00000030000;
    }

    public void setGk03010202100000k00000030000(Double gk03010202100000k00000030000) {
        this.gk03010202100000k00000030000 = gk03010202100000k00000030000;
    }

    public Double getGk03010202100000k00000040000() {
        return gk03010202100000k00000040000;
    }

    public void setGk03010202100000k00000040000(Double gk03010202100000k00000040000) {
        this.gk03010202100000k00000040000 = gk03010202100000k00000040000;
    }

    public Double getGk03010202100000k00000050000() {
        return gk03010202100000k00000050000;
    }

    public void setGk03010202100000k00000050000(Double gk03010202100000k00000050000) {
        this.gk03010202100000k00000050000 = gk03010202100000k00000050000;
    }

    public Double getGk03010202100000k00000060000() {
        return gk03010202100000k00000060000;
    }

    public void setGk03010202100000k00000060000(Double gk03010202100000k00000060000) {
        this.gk03010202100000k00000060000 = gk03010202100000k00000060000;
    }

    public Double getGk03010202100000k00000070000() {
        return gk03010202100000k00000070000;
    }

    public void setGk03010202100000k00000070000(Double gk03010202100000k00000070000) {
        this.gk03010202100000k00000070000 = gk03010202100000k00000070000;
    }

    public Double getGk03010202100000k00000080000() {
        return gk03010202100000k00000080000;
    }

    public void setGk03010202100000k00000080000(Double gk03010202100000k00000080000) {
        this.gk03010202100000k00000080000 = gk03010202100000k00000080000;
    }

    public Double getGk03010202100000k00000090000() {
        return gk03010202100000k00000090000;
    }

    public void setGk03010202100000k00000090000(Double gk03010202100000k00000090000) {
        this.gk03010202100000k00000090000 = gk03010202100000k00000090000;
    }

    public Double getGk03010202100000k00000100000() {
        return gk03010202100000k00000100000;
    }

    public void setGk03010202100000k00000100000(Double gk03010202100000k00000100000) {
        this.gk03010202100000k00000100000 = gk03010202100000k00000100000;
    }

    public Double getGk01010102100000k00000110000() {
        return gk01010102100000k00000110000;
    }

    public void setGk01010102100000k00000110000(Double gk01010102100000k00000110000) {
        this.gk01010102100000k00000110000 = gk01010102100000k00000110000;
    }

    public Double getGk01010102100000k00000120000() {
        return gk01010102100000k00000120000;
    }

    public void setGk01010102100000k00000120000(Double gk01010102100000k00000120000) {
        this.gk01010102100000k00000120000 = gk01010102100000k00000120000;
    }

    public Double getGk01010102100000k00000130000() {
        return gk01010102100000k00000130000;
    }

    public void setGk01010102100000k00000130000(Double gk01010102100000k00000130000) {
        this.gk01010102100000k00000130000 = gk01010102100000k00000130000;
    }

    public Double getGk03010102200000k00000010000() {
        return gk03010102200000k00000010000;
    }

    public void setGk03010102200000k00000010000(Double gk03010102200000k00000010000) {
        this.gk03010102200000k00000010000 = gk03010102200000k00000010000;
    }

    public Double getGk03010202200000k00000020000() {
        return gk03010202200000k00000020000;
    }

    public void setGk03010202200000k00000020000(Double gk03010202200000k00000020000) {
        this.gk03010202200000k00000020000 = gk03010202200000k00000020000;
    }

    public Double getGk03010202200000k00000030000() {
        return gk03010202200000k00000030000;
    }

    public void setGk03010202200000k00000030000(Double gk03010202200000k00000030000) {
        this.gk03010202200000k00000030000 = gk03010202200000k00000030000;
    }

    public Double getGk03010202200000k00000040000() {
        return gk03010202200000k00000040000;
    }

    public void setGk03010202200000k00000040000(Double gk03010202200000k00000040000) {
        this.gk03010202200000k00000040000 = gk03010202200000k00000040000;
    }

    public Double getGk03010202200000k00000050000() {
        return gk03010202200000k00000050000;
    }

    public void setGk03010202200000k00000050000(Double gk03010202200000k00000050000) {
        this.gk03010202200000k00000050000 = gk03010202200000k00000050000;
    }

    public Double getGk03010202200000k00000060000() {
        return gk03010202200000k00000060000;
    }

    public void setGk03010202200000k00000060000(Double gk03010202200000k00000060000) {
        this.gk03010202200000k00000060000 = gk03010202200000k00000060000;
    }

    public Double getGk03010202200000k00000070000() {
        return gk03010202200000k00000070000;
    }

    public void setGk03010202200000k00000070000(Double gk03010202200000k00000070000) {
        this.gk03010202200000k00000070000 = gk03010202200000k00000070000;
    }

    public Double getGk03010202200000k00000080000() {
        return gk03010202200000k00000080000;
    }

    public void setGk03010202200000k00000080000(Double gk03010202200000k00000080000) {
        this.gk03010202200000k00000080000 = gk03010202200000k00000080000;
    }

    public Double getGk03010202200000k00000090000() {
        return gk03010202200000k00000090000;
    }

    public void setGk03010202200000k00000090000(Double gk03010202200000k00000090000) {
        this.gk03010202200000k00000090000 = gk03010202200000k00000090000;
    }

    public Double getGk03010202200000k00000100000() {
        return gk03010202200000k00000100000;
    }

    public void setGk03010202200000k00000100000(Double gk03010202200000k00000100000) {
        this.gk03010202200000k00000100000 = gk03010202200000k00000100000;
    }

    public Double getGk01010102200000k00000110000() {
        return gk01010102200000k00000110000;
    }

    public void setGk01010102200000k00000110000(Double gk01010102200000k00000110000) {
        this.gk01010102200000k00000110000 = gk01010102200000k00000110000;
    }

    public Double getGk01010102200000k00000120000() {
        return gk01010102200000k00000120000;
    }

    public void setGk01010102200000k00000120000(Double gk01010102200000k00000120000) {
        this.gk01010102200000k00000120000 = gk01010102200000k00000120000;
    }

    public Double getGk01010102200000k00000130000() {
        return gk01010102200000k00000130000;
    }

    public void setGk01010102200000k00000130000(Double gk01010102200000k00000130000) {
        this.gk01010102200000k00000130000 = gk01010102200000k00000130000;
    }

}