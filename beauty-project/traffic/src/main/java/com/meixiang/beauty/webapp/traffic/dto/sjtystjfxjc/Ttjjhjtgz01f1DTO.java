package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class Ttjjhjtgz01f1DTO {


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
     *港口管理单位名称
    **/
    @JSONField(name="gk010100x0000000000000010000")
    private String gk010100x0000000000000010000;

    /**
     *港口名称
    **/
    @JSONField(name="gk010100x0000000000000020000")
    private String gk010100x0000000000000020000;

    /**
     *港区名称
    **/
    @JSONField(name="gk010100x0000000000000030000")
    private String gk010100x0000000000000030000;

    /**
     *港口企业或码头单位
    **/
    @JSONField(name="gk010100x0000000000000040000")
    private String gk010100x0000000000000040000;

    /**
     *港口企业或码头单位代码
    **/
    @JSONField(name="gk010100x0000000000000050000")
    private String gk010100x0000000000000050000;

    /**
     *企业经济类型
    **/
    @JSONField(name="gk010100x0000000000000060000")
    private String gk010100x0000000000000060000;

    /**
     *泊位名称
    **/
    @JSONField(name="gk010100x0000000000000070000")
    private String gk010100x0000000000000070000;

    /**
     *泊位代码
    **/
    @JSONField(name="gk010100x0000000000000080000")
    private String gk010100x0000000000000080000;

    /**
     *泊位属性
    **/
    @JSONField(name="gk010100x0000000000000090000")
    private String gk010100x0000000000000090000;

    /**
     *泊位所在水系
    **/
    @JSONField(name="gk010100x0000000000000100000")
    private String gk010100x0000000000000100000;

    /**
     *生产类型
    **/
    @JSONField(name="gk010100x0000000000000110000")
    private String gk010100x0000000000000110000;

    /**
     *服务类型
    **/
    @JSONField(name="gk010100x0000000000000120000")
    private String gk010100x0000000000000120000;

    /**
     *结构型式
    **/
    @JSONField(name="gk010100x0000000000000130000")
    private String gk010100x0000000000000130000;

    /**
     *主要用途
    **/
    @JSONField(name="gk010100x0000000000000140000")
    private String gk010100x0000000000000140000;

    /**
     *投产年份
    **/
    @JSONField(name="gk010100x0000000000000150000")
    private String gk010100x0000000000000150000;

    /**
     *竣工验收年份
    **/
    @JSONField(name="gk010100x0000000000000160000")
    private String gk010100x0000000000000160000;

    /**
     *码头前沿设计水深
    **/
    @JSONField(name="gk010100x0000000000000170000")
    private Double gk010100x0000000000000170000;

    /**
     *码头前沿实际水深
    **/
    @JSONField(name="gk010100x0000000000000180000")
    private Double gk010100x0000000000000180000;

    /**
     *泊位长度
    **/
    @JSONField(name="gk010100x0000000000000190000")
    private Double gk010100x0000000000000190000;

    /**
     *泊位个数
    **/
    @JSONField(name="gk010100x0000000000000200000")
    private Double gk010100x0000000000000200000;

    /**
     *设计靠泊能力
    **/
    @JSONField(name="gk010100x0000000000000210000")
    private Double gk010100x0000000000000210000;

    /**
     *泊位设计年通过能力
    **/
    @JSONField(name="gk010100x0000000000000220000")
    private Double gk010100x0000000000000220000;

    /**
     *泊位设计年通过能力-散装、件杂货物
    **/
    @JSONField(name="gk010100x0000000000000221100")
    private Double gk010100x0000000000000221100;

    /**
     *泊位设计年通过能力-集装箱箱量
    **/
    @JSONField(name="gk010100x0000000000000221200")
    private Double gk010100x0000000000000221200;

    /**
     *泊位设计年通过能力-集装箱重量
    **/
    @JSONField(name="gk010100x0000000000000221300")
    private Double gk010100x0000000000000221300;

    /**
     *泊位设计年通过能力-旅客
    **/
    @JSONField(name="gk010100x0000000000000221400")
    private Double gk010100x0000000000000221400;

    /**
     *泊位设计年通过能力-滚装汽车数量
    **/
    @JSONField(name="gk010100x0000000000000221500")
    private Double gk010100x0000000000000221500;

    /**
     *泊位设计年通过能力-滚装汽车重量
    **/
    @JSONField(name="gk010100x0000000000000221600")
    private Double gk010100x0000000000000221600;

    /**
     *泊位核查年通过能力-散装、件杂货物
    **/
    @JSONField(name="gk010100x0000000000000222100")
    private Double gk010100x0000000000000222100;

    /**
     *泊位核查年通过能力-集装箱箱量
    **/
    @JSONField(name="gk010100x0000000000000222200")
    private Double gk010100x0000000000000222200;

    /**
     *泊位核查年通过能力-集装箱重量
    **/
    @JSONField(name="gk010100x0000000000000222300")
    private Double gk010100x0000000000000222300;

    /**
     *泊位核查年通过能力-旅客
    **/
    @JSONField(name="gk010100x0000000000000222400")
    private Double gk010100x0000000000000222400;

    /**
     *泊位核查年通过能力-滚装汽车数量
    **/
    @JSONField(name="gk010100x0000000000000222500")
    private Double gk010100x0000000000000222500;

    /**
     *泊位核查年通过能力-滚装汽车重量
    **/
    @JSONField(name="gk010100x0000000000000222600")
    private Double gk010100x0000000000000222600;

    /**
     *增减说明
    **/
    @JSONField(name="gk010100x0000000000000230000")
    private String gk010100x0000000000000230000;

    /**
     *备注
    **/
    @JSONField(name="gk010100x0000000000000240000")
    private String gk010100x0000000000000240000;

    /**
     *港口码头单位一览表唯一标识
    **/
    @JSONField(name="wybzgkmtdwylb")
    private String wybzgkmtdwylb;

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

    public String getGk010100x0000000000000010000() {
        return gk010100x0000000000000010000;
    }

    public void setGk010100x0000000000000010000(String gk010100x0000000000000010000) {
        this.gk010100x0000000000000010000 = gk010100x0000000000000010000;
    }

    public String getGk010100x0000000000000020000() {
        return gk010100x0000000000000020000;
    }

    public void setGk010100x0000000000000020000(String gk010100x0000000000000020000) {
        this.gk010100x0000000000000020000 = gk010100x0000000000000020000;
    }

    public String getGk010100x0000000000000030000() {
        return gk010100x0000000000000030000;
    }

    public void setGk010100x0000000000000030000(String gk010100x0000000000000030000) {
        this.gk010100x0000000000000030000 = gk010100x0000000000000030000;
    }

    public String getGk010100x0000000000000040000() {
        return gk010100x0000000000000040000;
    }

    public void setGk010100x0000000000000040000(String gk010100x0000000000000040000) {
        this.gk010100x0000000000000040000 = gk010100x0000000000000040000;
    }

    public String getGk010100x0000000000000050000() {
        return gk010100x0000000000000050000;
    }

    public void setGk010100x0000000000000050000(String gk010100x0000000000000050000) {
        this.gk010100x0000000000000050000 = gk010100x0000000000000050000;
    }

    public String getGk010100x0000000000000060000() {
        return gk010100x0000000000000060000;
    }

    public void setGk010100x0000000000000060000(String gk010100x0000000000000060000) {
        this.gk010100x0000000000000060000 = gk010100x0000000000000060000;
    }

    public String getGk010100x0000000000000070000() {
        return gk010100x0000000000000070000;
    }

    public void setGk010100x0000000000000070000(String gk010100x0000000000000070000) {
        this.gk010100x0000000000000070000 = gk010100x0000000000000070000;
    }

    public String getGk010100x0000000000000080000() {
        return gk010100x0000000000000080000;
    }

    public void setGk010100x0000000000000080000(String gk010100x0000000000000080000) {
        this.gk010100x0000000000000080000 = gk010100x0000000000000080000;
    }

    public String getGk010100x0000000000000090000() {
        return gk010100x0000000000000090000;
    }

    public void setGk010100x0000000000000090000(String gk010100x0000000000000090000) {
        this.gk010100x0000000000000090000 = gk010100x0000000000000090000;
    }

    public String getGk010100x0000000000000100000() {
        return gk010100x0000000000000100000;
    }

    public void setGk010100x0000000000000100000(String gk010100x0000000000000100000) {
        this.gk010100x0000000000000100000 = gk010100x0000000000000100000;
    }

    public String getGk010100x0000000000000110000() {
        return gk010100x0000000000000110000;
    }

    public void setGk010100x0000000000000110000(String gk010100x0000000000000110000) {
        this.gk010100x0000000000000110000 = gk010100x0000000000000110000;
    }

    public String getGk010100x0000000000000120000() {
        return gk010100x0000000000000120000;
    }

    public void setGk010100x0000000000000120000(String gk010100x0000000000000120000) {
        this.gk010100x0000000000000120000 = gk010100x0000000000000120000;
    }

    public String getGk010100x0000000000000130000() {
        return gk010100x0000000000000130000;
    }

    public void setGk010100x0000000000000130000(String gk010100x0000000000000130000) {
        this.gk010100x0000000000000130000 = gk010100x0000000000000130000;
    }

    public String getGk010100x0000000000000140000() {
        return gk010100x0000000000000140000;
    }

    public void setGk010100x0000000000000140000(String gk010100x0000000000000140000) {
        this.gk010100x0000000000000140000 = gk010100x0000000000000140000;
    }

    public String getGk010100x0000000000000150000() {
        return gk010100x0000000000000150000;
    }

    public void setGk010100x0000000000000150000(String gk010100x0000000000000150000) {
        this.gk010100x0000000000000150000 = gk010100x0000000000000150000;
    }

    public String getGk010100x0000000000000160000() {
        return gk010100x0000000000000160000;
    }

    public void setGk010100x0000000000000160000(String gk010100x0000000000000160000) {
        this.gk010100x0000000000000160000 = gk010100x0000000000000160000;
    }

    public Double getGk010100x0000000000000170000() {
        return gk010100x0000000000000170000;
    }

    public void setGk010100x0000000000000170000(Double gk010100x0000000000000170000) {
        this.gk010100x0000000000000170000 = gk010100x0000000000000170000;
    }

    public Double getGk010100x0000000000000180000() {
        return gk010100x0000000000000180000;
    }

    public void setGk010100x0000000000000180000(Double gk010100x0000000000000180000) {
        this.gk010100x0000000000000180000 = gk010100x0000000000000180000;
    }

    public Double getGk010100x0000000000000190000() {
        return gk010100x0000000000000190000;
    }

    public void setGk010100x0000000000000190000(Double gk010100x0000000000000190000) {
        this.gk010100x0000000000000190000 = gk010100x0000000000000190000;
    }

    public Double getGk010100x0000000000000200000() {
        return gk010100x0000000000000200000;
    }

    public void setGk010100x0000000000000200000(Double gk010100x0000000000000200000) {
        this.gk010100x0000000000000200000 = gk010100x0000000000000200000;
    }

    public Double getGk010100x0000000000000210000() {
        return gk010100x0000000000000210000;
    }

    public void setGk010100x0000000000000210000(Double gk010100x0000000000000210000) {
        this.gk010100x0000000000000210000 = gk010100x0000000000000210000;
    }

    public Double getGk010100x0000000000000220000() {
        return gk010100x0000000000000220000;
    }

    public void setGk010100x0000000000000220000(Double gk010100x0000000000000220000) {
        this.gk010100x0000000000000220000 = gk010100x0000000000000220000;
    }

    public Double getGk010100x0000000000000221100() {
        return gk010100x0000000000000221100;
    }

    public void setGk010100x0000000000000221100(Double gk010100x0000000000000221100) {
        this.gk010100x0000000000000221100 = gk010100x0000000000000221100;
    }

    public Double getGk010100x0000000000000221200() {
        return gk010100x0000000000000221200;
    }

    public void setGk010100x0000000000000221200(Double gk010100x0000000000000221200) {
        this.gk010100x0000000000000221200 = gk010100x0000000000000221200;
    }

    public Double getGk010100x0000000000000221300() {
        return gk010100x0000000000000221300;
    }

    public void setGk010100x0000000000000221300(Double gk010100x0000000000000221300) {
        this.gk010100x0000000000000221300 = gk010100x0000000000000221300;
    }

    public Double getGk010100x0000000000000221400() {
        return gk010100x0000000000000221400;
    }

    public void setGk010100x0000000000000221400(Double gk010100x0000000000000221400) {
        this.gk010100x0000000000000221400 = gk010100x0000000000000221400;
    }

    public Double getGk010100x0000000000000221500() {
        return gk010100x0000000000000221500;
    }

    public void setGk010100x0000000000000221500(Double gk010100x0000000000000221500) {
        this.gk010100x0000000000000221500 = gk010100x0000000000000221500;
    }

    public Double getGk010100x0000000000000221600() {
        return gk010100x0000000000000221600;
    }

    public void setGk010100x0000000000000221600(Double gk010100x0000000000000221600) {
        this.gk010100x0000000000000221600 = gk010100x0000000000000221600;
    }

    public Double getGk010100x0000000000000222100() {
        return gk010100x0000000000000222100;
    }

    public void setGk010100x0000000000000222100(Double gk010100x0000000000000222100) {
        this.gk010100x0000000000000222100 = gk010100x0000000000000222100;
    }

    public Double getGk010100x0000000000000222200() {
        return gk010100x0000000000000222200;
    }

    public void setGk010100x0000000000000222200(Double gk010100x0000000000000222200) {
        this.gk010100x0000000000000222200 = gk010100x0000000000000222200;
    }

    public Double getGk010100x0000000000000222300() {
        return gk010100x0000000000000222300;
    }

    public void setGk010100x0000000000000222300(Double gk010100x0000000000000222300) {
        this.gk010100x0000000000000222300 = gk010100x0000000000000222300;
    }

    public Double getGk010100x0000000000000222400() {
        return gk010100x0000000000000222400;
    }

    public void setGk010100x0000000000000222400(Double gk010100x0000000000000222400) {
        this.gk010100x0000000000000222400 = gk010100x0000000000000222400;
    }

    public Double getGk010100x0000000000000222500() {
        return gk010100x0000000000000222500;
    }

    public void setGk010100x0000000000000222500(Double gk010100x0000000000000222500) {
        this.gk010100x0000000000000222500 = gk010100x0000000000000222500;
    }

    public Double getGk010100x0000000000000222600() {
        return gk010100x0000000000000222600;
    }

    public void setGk010100x0000000000000222600(Double gk010100x0000000000000222600) {
        this.gk010100x0000000000000222600 = gk010100x0000000000000222600;
    }

    public String getGk010100x0000000000000230000() {
        return gk010100x0000000000000230000;
    }

    public void setGk010100x0000000000000230000(String gk010100x0000000000000230000) {
        this.gk010100x0000000000000230000 = gk010100x0000000000000230000;
    }

    public String getGk010100x0000000000000240000() {
        return gk010100x0000000000000240000;
    }

    public void setGk010100x0000000000000240000(String gk010100x0000000000000240000) {
        this.gk010100x0000000000000240000 = gk010100x0000000000000240000;
    }

    public String getWybzgkmtdwylb() {
        return wybzgkmtdwylb;
    }

    public void setWybzgkmtdwylb(String wybzgkmtdwylb) {
        this.wybzgkmtdwylb = wybzgkmtdwylb;
    }

}