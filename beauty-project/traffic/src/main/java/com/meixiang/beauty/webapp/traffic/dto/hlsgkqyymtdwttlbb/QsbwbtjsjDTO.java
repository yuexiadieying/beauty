package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

//全市泊位表中的统计数据
public class QsbwbtjsjDTO {

    //时间
    @JSONField(name = "time")
    private String time;

    //累计港口泊位数，4320
    @JSONField(name = "ljgkbws")
    private String ljgkbws;

    //累计港口泊位数增长率，-10%或者26%
    @JSONField(name = "ljgkbwsRate")
    private String ljgkbwsRate;

    //增加的报告期，342
    @JSONField(name = "zjdbgq")
    private String zjdbgq;

    //增加的报告期增长率，-10%或者26%
    @JSONField(name = "zjdbgqRate")
    private String zjdbgqRate;

    //报废的报告期，342
    @JSONField(name = "bfdbgq")
    private String bfdbgq;

    //报废的报告期的增长率，-10%或者26%
    @JSONField(name = "bfdbgqRate")
    private String bfdbgqRate;

    public String getLjgkbws() {
        return ljgkbws;
    }

    public void setLjgkbws(String ljgkbws) {
        this.ljgkbws = ljgkbws;
    }

    public String getLjgkbwsRate() {
        return ljgkbwsRate;
    }

    public void setLjgkbwsRate(String ljgkbwsRate) {
        this.ljgkbwsRate = ljgkbwsRate;
    }

    public String getZjdbgq() {
        return zjdbgq;
    }

    public void setZjdbgq(String zjdbgq) {
        this.zjdbgq = zjdbgq;
    }

    public String getZjdbgqRate() {
        return zjdbgqRate;
    }

    public void setZjdbgqRate(String zjdbgqRate) {
        this.zjdbgqRate = zjdbgqRate;
    }

    public String getBfdbgq() {
        return bfdbgq;
    }

    public void setBfdbgq(String bfdbgq) {
        this.bfdbgq = bfdbgq;
    }

    public String getBfdbgqRate() {
        return bfdbgqRate;
    }

    public void setBfdbgqRate(String bfdbgqRate) {
        this.bfdbgqRate = bfdbgqRate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
