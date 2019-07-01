package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjht7Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht7DTO;
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
public class Ttjjhjht7Service {

    @Autowired
    private Ttjjhjht7Dao ttjjhjht7Dao;

    public List<Map<String, Object>> getTtjjhjht7ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht7DTO> ttjjhjht7DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjht7DTOs = ttjjhjht7Dao.getTtjjhjht7ByPageable(start, end);
        } else {
            ttjjhjht7DTOs = ttjjhjht7Dao.getTtjjhjht7ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjht7DTOs)) {
            for (Ttjjhjht7DTO ttjjhjht7DTO : ttjjhjht7DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht7DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjht7Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjht7Dao.getTtjjhjht7Count();
        } else {
            res = ttjjhjht7Dao.getTtjjhjht7CountByParams(params[0]);
        }
        return res;
    }

    /**
     * 公路旅客货物运营车辆拥有量情况
     **/
    public List<Map<String, Object>> getRoadCarNumInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht7DTO> ttjjhjht7DTOs = Lists.newArrayList();
        ttjjhjht7DTOs = ttjjhjht7Dao.getRoadCarNumInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjht7DTOs)) {
            for (Ttjjhjht7DTO ttjjhjht7DTO : ttjjhjht7DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht7DTO));
            }
        }
        return res;
    }
}