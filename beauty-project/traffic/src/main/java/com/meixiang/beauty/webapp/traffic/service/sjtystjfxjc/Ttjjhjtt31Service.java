package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjtt31Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtt31DTO;
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
public class Ttjjhjtt31Service {

    @Autowired
    private Ttjjhjtt31Dao ttjjhjtt31Dao;

    public List<Map<String, Object>> getTtjjhjtt31ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtt31DTO> ttjjhjtt31DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjtt31DTOs = ttjjhjtt31Dao.getTtjjhjtt31ByPageable(start, end);
        } else {
            ttjjhjtt31DTOs = ttjjhjtt31Dao.getTtjjhjtt31ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjtt31DTOs)) {
            for (Ttjjhjtt31DTO ttjjhjtt31DTO : ttjjhjtt31DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtt31DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjtt31Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjtt31Dao.getTtjjhjtt31Count();
        } else {
            res = ttjjhjtt31Dao.getTtjjhjtt31CountByParams(params[0]);
        }
        return res;
    }
}