package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjht5Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht5DTO;
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
public class Ttjjhjht5Service {

    @Autowired
    private Ttjjhjht5Dao ttjjhjht5Dao;

    public List<Map<String, Object>> getTtjjhjht5ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht5DTO> ttjjhjht5DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjht5DTOs = ttjjhjht5Dao.getTtjjhjht5ByPageable(start, end);
        } else {
            ttjjhjht5DTOs = ttjjhjht5Dao.getTtjjhjht5ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjht5DTOs)) {
            for (Ttjjhjht5DTO ttjjhjht5DTO : ttjjhjht5DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht5DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjht5Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjht5Dao.getTtjjhjht5Count();
        } else {
            res = ttjjhjht5Dao.getTtjjhjht5CountByParams(params[0]);
        }
        return res;
    }
}