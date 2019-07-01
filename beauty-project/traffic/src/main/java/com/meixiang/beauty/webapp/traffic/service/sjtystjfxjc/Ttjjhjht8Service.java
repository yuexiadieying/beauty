package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjht8Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht8DTO;
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
public class Ttjjhjht8Service {

    @Autowired
    private Ttjjhjht8Dao ttjjhjht8Dao;

    public List<Map<String, Object>> getTtjjhjht8ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht8DTO> ttjjhjht8DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjht8DTOs = ttjjhjht8Dao.getTtjjhjht8ByPageable(start, end);
        } else {
            ttjjhjht8DTOs = ttjjhjht8Dao.getTtjjhjht8ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjht8DTOs)) {
            for (Ttjjhjht8DTO ttjjhjht8DTO : ttjjhjht8DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht8DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjht8Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjht8Dao.getTtjjhjht8Count();
        } else {
            res = ttjjhjht8Dao.getTtjjhjht8CountByParams(params[0]);
        }
        return res;
    }

    /**
     * 水路运输工具拥有量情况
     **/
    public List<Map<String, Object>> getWaterRoadTransportToolsNumInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht8DTO> ttjjhjht8DTOs = Lists.newArrayList();
        ttjjhjht8DTOs = ttjjhjht8Dao.getWaterRoadTransportToolsNumInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjht8DTOs)) {
            for (Ttjjhjht8DTO ttjjhjht8DTO : ttjjhjht8DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht8DTO));
            }
        }
        return res;
    }
}