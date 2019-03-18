package com.meixiang.beauty.common.dto.system;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2017/12/18.
 */
public class SuggestionDto {

    @JSONField(name ="id")
    private String id;
    @JSONField(name="userId")
    private String userId;
    @JSONField(name = "suggestion")
    private String suggestion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
