package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhfpjb03Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhfpjb03DTO;
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
public class Ttjjhfpjb03Service {

    @Autowired
    private Ttjjhfpjb03Dao ttjjhfpjb03Dao;

    public List<Map<String, Object>> getTtjjhfpjb03ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhfpjb03DTO> ttjjhfpjb03DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhfpjb03DTOs = ttjjhfpjb03Dao.getTtjjhfpjb03ByPageable(start, end);
        } else {
            ttjjhfpjb03DTOs = ttjjhfpjb03Dao.getTtjjhfpjb03ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhfpjb03DTOs)) {
            for (Ttjjhfpjb03DTO ttjjhfpjb03DTO : ttjjhfpjb03DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhfpjb03DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhfpjb03Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhfpjb03Dao.getTtjjhfpjb03Count();
        } else {
            res = ttjjhfpjb03Dao.getTtjjhfpjb03CountByParams(params[0]);
        }
        return res;
    }
}