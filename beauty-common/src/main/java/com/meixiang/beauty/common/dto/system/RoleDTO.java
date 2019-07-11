package com.meixiang.beauty.common.dto.system;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class RoleDTO {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "roleName")
    private String roleName;

    @JSONField(name = "levels")
    private List<String> levels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<String> getLevels() {
        return levels;
    }

    public void setLevels(List<String> levels) {
        this.levels = levels;
    }
}
