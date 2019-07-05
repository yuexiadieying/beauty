package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjht3Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht3DTO;
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
public class Ttjjhjht3Service {

    @Autowired
    private Ttjjhjht3Dao ttjjhjht3Dao;

    public List<Map<String, Object>> getTtjjhjht3ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht3DTO> ttjjhjht3DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjht3DTOs = ttjjhjht3Dao.getTtjjhjht3ByPageable(start, end);
        } else {
            ttjjhjht3DTOs = ttjjhjht3Dao.getTtjjhjht3ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjht3DTOs)) {
            for (Ttjjhjht3DTO ttjjhjht3DTO : ttjjhjht3DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht3DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjht3Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjht3Dao.getTtjjhjht3Count();
        } else {
            res = ttjjhjht3Dao.getTtjjhjht3CountByParams(params[0]);
        }
        return res;
    }

    /**
     * 公路桥梁隧道年底到达数情况
     **/
    public List<Map<String, Object>> getEndOfYearProgressInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht3DTO> ttjjhjht3DTOs = Lists.newArrayList();
        ttjjhjht3DTOs = ttjjhjht3Dao.getEndOfYearProgressInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjht3DTOs)) {
            for (Ttjjhjht3DTO ttjjhjht3DTO : ttjjhjht3DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht3DTO));
            }
        }
        return res;
    }
}