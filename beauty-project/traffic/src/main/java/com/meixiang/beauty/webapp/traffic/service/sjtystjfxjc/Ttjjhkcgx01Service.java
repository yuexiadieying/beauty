package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhkcgx01Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhkcgx01DTO;
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
public class Ttjjhkcgx01Service {

    @Autowired
    private Ttjjhkcgx01Dao ttjjhkcgx01Dao;

    public List<Map<String, Object>> getTtjjhkcgx01ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhkcgx01DTO> ttjjhkcgx01DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhkcgx01DTOs = ttjjhkcgx01Dao.getTtjjhkcgx01ByPageable(start, end);
        } else {
            ttjjhkcgx01DTOs = ttjjhkcgx01Dao.getTtjjhkcgx01ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhkcgx01DTOs)) {
            for (Ttjjhkcgx01DTO ttjjhkcgx01DTO : ttjjhkcgx01DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhkcgx01DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhkcgx01Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhkcgx01Dao.getTtjjhkcgx01Count();
        } else {
            res = ttjjhkcgx01Dao.getTtjjhkcgx01CountByParams(params[0]);
        }
        return res;
    }
}