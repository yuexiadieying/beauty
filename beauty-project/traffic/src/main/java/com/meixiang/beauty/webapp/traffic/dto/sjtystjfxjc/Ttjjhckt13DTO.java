package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class Ttjjhckt13DTO {


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
     *公交车运营车数
    **/
    @JSONField(name="ck1310001")
    private Double ck1310001;

    /**
     *公交车运营线路总长度
    **/
    @JSONField(name="ck1310002")
    private Double ck1310002;

    /**
     *公交车客运量
    **/
    @JSONField(name="ck1310003")
    private Double ck1310003;

    /**
     *公交车运营里程
    **/
    @JSONField(name="ck1310004")
    private Double ck1310004;

    /**
     *轨道交通运营车数
    **/
    @JSONField(name="ck1330001")
    private Double ck1330001;

    /**
     *地铁运营车数
    **/
    @JSONField(name="ck1330002")
    private Double ck1330002;

    /**
     *轻轨运营车数
    **/
    @JSONField(name="ck1330003")
    private Double ck1330003;

    /**
     *轨道交通运营线路总长度
    **/
    @JSONField(name="ck1330004")
    private Double ck1330004;

    /**
     *地铁运营线路长度
    **/
    @JSONField(name="ck1330005")
    private Double ck1330005;

    /**
     *轻轨运营线路长度
    **/
    @JSONField(name="ck1330006")
    private Double ck1330006;

    /**
     *轨道交通客运量
    **/
    @JSONField(name="ck1330007")
    private Double ck1330007;

    /**
     *轨道交通运营里程
    **/
    @JSONField(name="ck1330008")
    private Double ck1330008;

    /**
     *出租车运营车数
    **/
    @JSONField(name="ck1320001")
    private Double ck1320001;

    /**
     *出租车客运量
    **/
    @JSONField(name="ck1320002")
    private Double ck1320002;

    /**
     *出租车运营里程
    **/
    @JSONField(name="ck1320003")
    private Double ck1320003;

    /**
     *城市客运轮渡运营船数
    **/
    @JSONField(name="ck1340001")
    private Double ck1340001;

    /**
     *城市客运轮渡运营航线总长度
    **/
    @JSONField(name="ck1340002")
    private Double ck1340002;

    /**
     *城市客运轮渡客运量
    **/
    @JSONField(name="ck1340003")
    private Double ck1340003;

    @JSONField(name="csky")
    private String csky;

    /**
     *轨道交通经营业户数
    **/
    @JSONField(name="ck1330009")
    private Double ck1330009;

    /**
     *出租汽车经营业户数
    **/
    @JSONField(name="ck1320004")
    private Double ck1320004;

    /**
     *城市客运轮渡经营业户数
    **/
    @JSONField(name="ck1340004")
    private Double ck1340004;

    /**
     *公共汽电车经营业户数
    **/
    @JSONField(name="ck1310005")
    private Double ck1310005;

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

    public Double getCk1310001() {
        return ck1310001;
    }

    public void setCk1310001(Double ck1310001) {
        this.ck1310001 = ck1310001;
    }

    public Double getCk1310002() {
        return ck1310002;
    }

    public void setCk1310002(Double ck1310002) {
        this.ck1310002 = ck1310002;
    }

    public Double getCk1310003() {
        return ck1310003;
    }

    public void setCk1310003(Double ck1310003) {
        this.ck1310003 = ck1310003;
    }

    public Double getCk1310004() {
        return ck1310004;
    }

    public void setCk1310004(Double ck1310004) {
        this.ck1310004 = ck1310004;
    }

    public Double getCk1330001() {
        return ck1330001;
    }

    public void setCk1330001(Double ck1330001) {
        this.ck1330001 = ck1330001;
    }

    public Double getCk1330002() {
        return ck1330002;
    }

    public void setCk1330002(Double ck1330002) {
        this.ck1330002 = ck1330002;
    }

    public Double getCk1330003() {
        return ck1330003;
    }

    public void setCk1330003(Double ck1330003) {
        this.ck1330003 = ck1330003;
    }

    public Double getCk1330004() {
        return ck1330004;
    }

    public void setCk1330004(Double ck1330004) {
        this.ck1330004 = ck1330004;
    }

    public Double getCk1330005() {
        return ck1330005;
    }

    public void setCk1330005(Double ck1330005) {
        this.ck1330005 = ck1330005;
    }

    public Double getCk1330006() {
        return ck1330006;
    }

    public void setCk1330006(Double ck1330006) {
        this.ck1330006 = ck1330006;
    }

    public Double getCk1330007() {
        return ck1330007;
    }

    public void setCk1330007(Double ck1330007) {
        this.ck1330007 = ck1330007;
    }

    public Double getCk1330008() {
        return ck1330008;
    }

    public void setCk1330008(Double ck1330008) {
        this.ck1330008 = ck1330008;
    }

    public Double getCk1320001() {
        return ck1320001;
    }

    public void setCk1320001(Double ck1320001) {
        this.ck1320001 = ck1320001;
    }

    public Double getCk1320002() {
        return ck1320002;
    }

    public void setCk1320002(Double ck1320002) {
        this.ck1320002 = ck1320002;
    }

    public Double getCk1320003() {
        return ck1320003;
    }

    public void setCk1320003(Double ck1320003) {
        this.ck1320003 = ck1320003;
    }

    public Double getCk1340001() {
        return ck1340001;
    }

    public void setCk1340001(Double ck1340001) {
        this.ck1340001 = ck1340001;
    }

    public Double getCk1340002() {
        return ck1340002;
    }

    public void setCk1340002(Double ck1340002) {
        this.ck1340002 = ck1340002;
    }

    public Double getCk1340003() {
        return ck1340003;
    }

    public void setCk1340003(Double ck1340003) {
        this.ck1340003 = ck1340003;
    }

    public String getCsky() {
        return csky;
    }

    public void setCsky(String csky) {
        this.csky = csky;
    }

    public Double getCk1330009() {
        return ck1330009;
    }

    public void setCk1330009(Double ck1330009) {
        this.ck1330009 = ck1330009;
    }

    public Double getCk1320004() {
        return ck1320004;
    }

    public void setCk1320004(Double ck1320004) {
        this.ck1320004 = ck1320004;
    }

    public Double getCk1340004() {
        return ck1340004;
    }

    public void setCk1340004(Double ck1340004) {
        this.ck1340004 = ck1340004;
    }

    public Double getCk1310005() {
        return ck1310005;
    }

    public void setCk1310005(Double ck1310005) {
        this.ck1310005 = ck1310005;
    }

}