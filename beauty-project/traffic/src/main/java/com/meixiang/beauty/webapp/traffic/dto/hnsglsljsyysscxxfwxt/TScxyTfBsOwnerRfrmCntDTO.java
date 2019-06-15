package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsOwnerRfrmCntDTO {

    /**
     *整改ID
    **/
    @JSONField(name="reformId")
    private String reformId;

    /**
     *整改内容ID
    **/
    @JSONField(name="contentId")
    private String contentId;

    /**
     *整改内容
    **/
    @JSONField(name="reformContent")
    private String reformContent;

    /**
     *排序
    **/
    @JSONField(name="showOrder")
    private Double showOrder;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getReformId() {
        return reformId;
    }

    public void setReformId(String reformId) {
        this.reformId = reformId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getReformContent() {
        return reformContent;
    }

    public void setReformContent(String reformContent) {
        this.reformContent = reformContent;
    }

    public Double getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Double showOrder) {
        this.showOrder = showOrder;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}