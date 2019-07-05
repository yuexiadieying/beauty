package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjtgz030405Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtgz030405DTO;
import com.meixiang.beauty.webapp.traffic.utils.ClassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by WY on 2019/6/10.
 */
@Service
public class Ttjjhjtgz030405Service {

    @Autowired
    private Ttjjhjtgz030405Dao ttjjhjtgz030405Dao;

    public List<Map<String, Object>> getTtjjhjtgz030405ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtgz030405DTO> ttjjhjtgz030405DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjtgz030405DTOs = ttjjhjtgz030405Dao.getTtjjhjtgz030405ByPageable(start, end);
        } else {
            ttjjhjtgz030405DTOs = ttjjhjtgz030405Dao.getTtjjhjtgz030405ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjtgz030405DTOs)) {
            for (Ttjjhjtgz030405DTO ttjjhjtgz030405DTO : ttjjhjtgz030405DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtgz030405DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjtgz030405Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjtgz030405Dao.getTtjjhjtgz030405Count();
        } else {
            res = ttjjhjtgz030405Dao.getTtjjhjtgz030405CountByParams(params[0]);
        }
        return res;
    }


    /**
     * l   内贸出港情况
     **/
    public List<Map<String, Object>> getDomesticTradeLeavePortInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtgz030405DTO> ttjjhjtgz030405DTOs = Lists.newArrayList();
        ttjjhjtgz030405DTOs = ttjjhjtgz030405Dao.getDomesticTradeLeavePortInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjtgz030405DTOs)) {
            for (Ttjjhjtgz030405DTO ttjjhjtgz030405DTO : ttjjhjtgz030405DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtgz030405DTO));
            }
        }
        return res;
    }

    /**
     * l   外贸出港情况
     **/
    public List<Map<String, Object>> getForeignTradeLeavePortInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtgz030405DTO> ttjjhjtgz030405DTOs = Lists.newArrayList();
        ttjjhjtgz030405DTOs = ttjjhjtgz030405Dao.getForeignTradeLeavePortInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjtgz030405DTOs)) {
            for (Ttjjhjtgz030405DTO ttjjhjtgz030405DTO : ttjjhjtgz030405DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtgz030405DTO));
            }
        }
        return res;
    }
}