package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjht20Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht20DTO;
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
public class Ttjjhjht20Service {

    @Autowired
    private Ttjjhjht20Dao ttjjhjht20Dao;

    public List<Map<String, Object>> getTtjjhjht20ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht20DTO> ttjjhjht20DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjht20DTOs = ttjjhjht20Dao.getTtjjhjht20ByPageable(start, end);
        } else {
            ttjjhjht20DTOs = ttjjhjht20Dao.getTtjjhjht20ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjht20DTOs)) {
            for (Ttjjhjht20DTO ttjjhjht20DTO : ttjjhjht20DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht20DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjht20Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjht20Dao.getTtjjhjht20Count();
        } else {
            res = ttjjhjht20Dao.getTtjjhjht20CountByParams(params[0]);
        }
        return res;
    }
}