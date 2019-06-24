package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhfpjb02Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhfpjb02DTO;
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
public class Ttjjhfpjb02Service {

    @Autowired
    private Ttjjhfpjb02Dao ttjjhfpjb02Dao;

    public List<Map<String, Object>> getTtjjhfpjb02ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhfpjb02DTO> ttjjhfpjb02DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhfpjb02DTOs = ttjjhfpjb02Dao.getTtjjhfpjb02ByPageable(start, end);
        } else {
            ttjjhfpjb02DTOs = ttjjhfpjb02Dao.getTtjjhfpjb02ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhfpjb02DTOs)) {
            for (Ttjjhfpjb02DTO ttjjhfpjb02DTO : ttjjhfpjb02DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhfpjb02DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhfpjb02Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhfpjb02Dao.getTtjjhfpjb02Count();
        } else {
            res = ttjjhfpjb02Dao.getTtjjhfpjb02CountByParams(params[0]);
        }
        return res;
    }
}