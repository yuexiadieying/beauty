package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhckt13Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhckt13DTO;
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
public class Ttjjhckt13Service {

    @Autowired
    private Ttjjhckt13Dao ttjjhckt13Dao;

    public List<Map<String, Object>> getTtjjhckt13ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhckt13DTO> ttjjhckt13DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhckt13DTOs = ttjjhckt13Dao.getTtjjhckt13ByPageable(start, end);
        } else {
            ttjjhckt13DTOs = ttjjhckt13Dao.getTtjjhckt13ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhckt13DTOs)) {
            for (Ttjjhckt13DTO ttjjhckt13DTO : ttjjhckt13DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhckt13DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhckt13Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhckt13Dao.getTtjjhckt13Count();
        } else {
            res = ttjjhckt13Dao.getTtjjhckt13CountByParams(params[0]);
        }
        return res;
    }

    /**
     * 城市客运主要统计指标快速年报信息
     **/
    public List<Map<String, Object>> getCityPassengerTrafficStatisticInfo(String year) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhckt13DTO> ttjjhckt13DTOs = Lists.newArrayList();
        ttjjhckt13DTOs = ttjjhckt13Dao.getCityPassengerTrafficStatisticInfo(year);
        if (!CollectionUtils.isEmpty(ttjjhckt13DTOs)) {
            for (Ttjjhckt13DTO ttjjhckt13DTO : ttjjhckt13DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhckt13DTO));
            }
        }
        return res;
    }
}