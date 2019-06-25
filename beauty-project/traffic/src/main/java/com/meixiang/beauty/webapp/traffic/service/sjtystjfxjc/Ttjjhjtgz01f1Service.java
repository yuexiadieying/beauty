package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjtgz01f1Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtgz01f1DTO;
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
public class Ttjjhjtgz01f1Service {

    @Autowired
    private Ttjjhjtgz01f1Dao ttjjhjtgz01f1Dao;

    public List<Map<String, Object>> getTtjjhjtgz01f1ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtgz01f1DTO> ttjjhjtgz01f1DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjtgz01f1DTOs = ttjjhjtgz01f1Dao.getTtjjhjtgz01f1ByPageable(start, end);
        } else {
            ttjjhjtgz01f1DTOs = ttjjhjtgz01f1Dao.getTtjjhjtgz01f1ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjtgz01f1DTOs)) {
            for (Ttjjhjtgz01f1DTO ttjjhjtgz01f1DTO : ttjjhjtgz01f1DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtgz01f1DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjtgz01f1Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjtgz01f1Dao.getTtjjhjtgz01f1Count();
        } else {
            res = ttjjhjtgz01f1Dao.getTtjjhjtgz01f1CountByParams(params[0]);
        }
        return res;
    }
}