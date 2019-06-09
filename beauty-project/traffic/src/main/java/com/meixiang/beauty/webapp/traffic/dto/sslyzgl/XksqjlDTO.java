package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

//许可申请记录
public class XksqjlDTO {

    //申请机构编码
    @JSONField(name = "sqjgbm")
    private String sqjgbm;

    //申请事项类型
    @JSONField(name = "sqsxlx")
    private String sqsxlx;

    //申请说明
    @JSONField(name = "sqsm")
    private String sqsm;

    //申请提交时间
    @JSONField(name = "sqtjsj")
    private String sqtjsj;

    //提出许可申请对象的记录编号
    @JSONField(name = "tcxksqdxdjlbh")
    private String tcxksqdxdjlbh;

    //许可机构等级
    @JSONField(name = "xkjgdj")
    private String xkjgdj;

    //许可时间
    @JSONField(name = "xksj")
    private String xksj;

    //许可结果
    @JSONField(name = "xkjg")
    private String xkjg;

    //许可说明
    @JSONField(name = "xksm")
    private String xksm;

    //许可机构编码
    @JSONField(name = "xkjgbm")
    private String xkjgbm;

    public String getSqjgbm() {
        return sqjgbm;
    }

    public void setSqjgbm(String sqjgbm) {
        this.sqjgbm = sqjgbm;
    }

    public String getSqsxlx() {
        return sqsxlx;
    }

    public void setSqsxlx(String sqsxlx) {
        this.sqsxlx = sqsxlx;
    }

    public String getSqsm() {
        return sqsm;
    }

    public void setSqsm(String sqsm) {
        this.sqsm = sqsm;
    }

    public String getSqtjsj() {
        return sqtjsj;
    }

    public void setSqtjsj(String sqtjsj) {
        this.sqtjsj = sqtjsj;
    }

    public String getTcxksqdxdjlbh() {
        return tcxksqdxdjlbh;
    }

    public void setTcxksqdxdjlbh(String tcxksqdxdjlbh) {
        this.tcxksqdxdjlbh = tcxksqdxdjlbh;
    }

    public String getXkjgdj() {
        return xkjgdj;
    }

    public void setXkjgdj(String xkjgdj) {
        this.xkjgdj = xkjgdj;
    }

    public String getXksj() {
        return xksj;
    }

    public void setXksj(String xksj) {
        this.xksj = xksj;
    }

    public String getXkjg() {
        return xkjg;
    }

    public void setXkjg(String xkjg) {
        this.xkjg = xkjg;
    }

    public String getXksm() {
        return xksm;
    }

    public void setXksm(String xksm) {
        this.xksm = xksm;
    }

    public String getXkjgbm() {
        return xkjgbm;
    }

    public void setXkjgbm(String xkjgbm) {
        this.xkjgbm = xkjgbm;
    }
}
