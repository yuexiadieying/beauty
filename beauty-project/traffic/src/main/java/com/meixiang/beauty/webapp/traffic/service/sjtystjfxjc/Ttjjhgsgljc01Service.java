package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhgsgljc01Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhgsgljc01DTO;
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
public class Ttjjhgsgljc01Service {

    @Autowired
    private Ttjjhgsgljc01Dao ttjjhgsgljc01Dao;

    public List<Map<String, Object>> getTtjjhgsgljc01ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhgsgljc01DTO> ttjjhgsgljc01DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhgsgljc01DTOs = ttjjhgsgljc01Dao.getTtjjhgsgljc01ByPageable(start, end);
        } else {
            ttjjhgsgljc01DTOs = ttjjhgsgljc01Dao.getTtjjhgsgljc01ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhgsgljc01DTOs)) {
            for (Ttjjhgsgljc01DTO ttjjhgsgljc01DTO : ttjjhgsgljc01DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhgsgljc01DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhgsgljc01Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhgsgljc01Dao.getTtjjhgsgljc01Count();
        } else {
            res = ttjjhgsgljc01Dao.getTtjjhgsgljc01CountByParams(params[0]);
        }
        return res;
    }
}