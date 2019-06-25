package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhfpjb01Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhfpjb01DTO;
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
public class Ttjjhfpjb01Service {

    @Autowired
    private Ttjjhfpjb01Dao ttjjhfpjb01Dao;

    public List<Map<String, Object>> getTtjjhfpjb01ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhfpjb01DTO> ttjjhfpjb01DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhfpjb01DTOs = ttjjhfpjb01Dao.getTtjjhfpjb01ByPageable(start, end);
        } else {
            ttjjhfpjb01DTOs = ttjjhfpjb01Dao.getTtjjhfpjb01ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhfpjb01DTOs)) {
            for (Ttjjhfpjb01DTO ttjjhfpjb01DTO : ttjjhfpjb01DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhfpjb01DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhfpjb01Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhfpjb01Dao.getTtjjhfpjb01Count();
        } else {
            res = ttjjhfpjb01Dao.getTtjjhfpjb01CountByParams(params[0]);
        }
        return res;
    }
}