package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjtg92Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtg92DTO;
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
public class Ttjjhjtg92Service {

    @Autowired
    private Ttjjhjtg92Dao ttjjhjtg92Dao;

    public List<Map<String, Object>> getTtjjhjtg92ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtg92DTO> ttjjhjtg92DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjtg92DTOs = ttjjhjtg92Dao.getTtjjhjtg92ByPageable(start, end);
        } else {
            ttjjhjtg92DTOs = ttjjhjtg92Dao.getTtjjhjtg92ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjtg92DTOs)) {
            for (Ttjjhjtg92DTO ttjjhjtg92DTO : ttjjhjtg92DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtg92DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjtg92Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjtg92Dao.getTtjjhjtg92Count();
        } else {
            res = ttjjhjtg92Dao.getTtjjhjtg92CountByParams(params[0]);
        }
        return res;
    }
}