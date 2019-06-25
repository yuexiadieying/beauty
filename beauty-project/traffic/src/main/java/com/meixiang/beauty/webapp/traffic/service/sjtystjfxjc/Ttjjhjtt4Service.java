package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjtt4Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtt4DTO;
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
public class Ttjjhjtt4Service {

    @Autowired
    private Ttjjhjtt4Dao ttjjhjtt4Dao;

    public List<Map<String, Object>> getTtjjhjtt4ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtt4DTO> ttjjhjtt4DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjtt4DTOs = ttjjhjtt4Dao.getTtjjhjtt4ByPageable(start, end);
        } else {
            ttjjhjtt4DTOs = ttjjhjtt4Dao.getTtjjhjtt4ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjtt4DTOs)) {
            for (Ttjjhjtt4DTO ttjjhjtt4DTO : ttjjhjtt4DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtt4DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjtt4Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjtt4Dao.getTtjjhjtt4Count();
        } else {
            res = ttjjhjtt4Dao.getTtjjhjtt4CountByParams(params[0]);
        }
        return res;
    }
}