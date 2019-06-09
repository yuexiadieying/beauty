package com.meixiang.beauty.webapp.traffic.dto.zhsy;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.List;

//高速公路浏览观测
public class GsglllgcDataDTO {

    //某个月的中小客车平均车速  67KM
    @JSONField(name = "zxkccs")
    private String zxkccs;

    //同比上月变化情况
    @JSONField(name = "zxkccsRate")
    private String zxkccsRate;

    //某个月的中小客车车速的图形化数据,X轴数据为Key，表示日期，Y轴数据为Value，表示车速
    @JSONField(name = "zxkccsDatas")
    private List<HashMap<String,Object>> zxkccsDatas;

    //中型车车速  67KM
    @JSONField(name = "zxccs")
    private String zxccs;

    //同比上月变化情况
    @JSONField(name = "zxccsRate")
    private String zxccsRate;

    //某个月的中型车车速的图形化数据,X轴数据为Key，表示日期，Y轴数据为Value，表示车速
    @JSONField(name = "zxccsDatas")
    private List<HashMap<String,Object>> zxccsDatas;

    public String getZxkccs() {
        return zxkccs;
    }

    public void setZxkccs(String zxkccs) {
        this.zxkccs = zxkccs;
    }

    public String getZxkccsRate() {
        return zxkccsRate;
    }

    public void setZxkccsRate(String zxkccsRate) {
        this.zxkccsRate = zxkccsRate;
    }

    public String getZxccs() {
        return zxccs;
    }

    public void setZxccs(String zxccs) {
        this.zxccs = zxccs;
    }

    public String getZxccsRate() {
        return zxccsRate;
    }

    public void setZxccsRate(String zxccsRate) {
        this.zxccsRate = zxccsRate;
    }

    public List<HashMap<String, Object>> getZxkccsDatas() {
        return zxkccsDatas;
    }

    public void setZxkccsDatas(List<HashMap<String, Object>> zxkccsDatas) {
        this.zxkccsDatas = zxkccsDatas;
    }

    public List<HashMap<String, Object>> getZxccsDatas() {
        return zxccsDatas;
    }

    public void setZxccsDatas(List<HashMap<String, Object>> zxccsDatas) {
        this.zxccsDatas = zxccsDatas;
    }
}
