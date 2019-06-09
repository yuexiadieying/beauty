package com.meixiang.beauty.webapp.traffic.dto.zhsy;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class OverallStatisticDataDTO {

    //最新统计数据  124345
    @JSONField(name = "newStatisticData")
    private String newStatisticData;

    //最新统计数据同比上周增长或者减少的百分比 10%或者-10%
    @JSONField(name = "newStatisticDataRate")
    private String newStatisticDataRate;

    //全港吞吐量 1200
    @JSONField(name = "qgttl")
    private String qgttl;

    //全港吞吐量同比上周变化率 26%或-16%
    @JSONField(name = "qgttlRate")
    private String qgttlRate;

    //高速车流量
    @JSONField(name = "gscll")
    private String gscll;

    //高速车流量增长率
    @JSONField(name = "gscllRate")
    private String gscllRate;

    //全市泊位
    @JSONField(name = "qsbw")
    private String qsbw;

    //全市泊位增长率
    @JSONField(name = "qsbwRate")
    private String qsbwRate;

    //智慧公交运营车辆
    @JSONField(name = "zhgjyycl")
    private String zhgjyycl;

    //智慧公交运营车辆增长率
    @JSONField(name = "zhgjyyclRate")
    private String zhgjyyclRate;

    //城区战场视频监控
    @JSONField(name = "cqzcspjk")
    private String cqzcspjk;

    //城区战场视频监控增长率
    @JSONField(name = "cqzcspjkRate")
    private String cqzcspjkRate;

    public String getNewStatisticData() {
        return newStatisticData;
    }

    public void setNewStatisticData(String newStatisticData) {
        this.newStatisticData = newStatisticData;
    }

    public String getNewStatisticDataRate() {
        return newStatisticDataRate;
    }

    public void setNewStatisticDataRate(String newStatisticDataRate) {
        this.newStatisticDataRate = newStatisticDataRate;
    }

    public String getQgttl() {
        return qgttl;
    }

    public void setQgttl(String qgttl) {
        this.qgttl = qgttl;
    }

    public String getQgttlRate() {
        return qgttlRate;
    }

    public void setQgttlRate(String qgttlRate) {
        this.qgttlRate = qgttlRate;
    }

    public String getGscll() {
        return gscll;
    }

    public void setGscll(String gscll) {
        this.gscll = gscll;
    }

    public String getGscllRate() {
        return gscllRate;
    }

    public void setGscllRate(String gscllRate) {
        this.gscllRate = gscllRate;
    }

    public String getQsbw() {
        return qsbw;
    }

    public void setQsbw(String qsbw) {
        this.qsbw = qsbw;
    }

    public String getQsbwRate() {
        return qsbwRate;
    }

    public void setQsbwRate(String qsbwRate) {
        this.qsbwRate = qsbwRate;
    }

    public String getZhgjyycl() {
        return zhgjyycl;
    }

    public void setZhgjyycl(String zhgjyycl) {
        this.zhgjyycl = zhgjyycl;
    }

    public String getZhgjyyclRate() {
        return zhgjyyclRate;
    }

    public void setZhgjyyclRate(String zhgjyyclRate) {
        this.zhgjyyclRate = zhgjyyclRate;
    }

    public String getCqzcspjk() {
        return cqzcspjk;
    }

    public void setCqzcspjk(String cqzcspjk) {
        this.cqzcspjk = cqzcspjk;
    }

    public String getCqzcspjkRate() {
        return cqzcspjkRate;
    }

    public void setCqzcspjkRate(String cqzcspjkRate) {
        this.cqzcspjkRate = cqzcspjkRate;
    }
}
