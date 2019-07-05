package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjht2Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht2DTO;
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
public class Ttjjhjht2Service {

    @Autowired
    private Ttjjhjht2Dao ttjjhjht2Dao;

    public List<Map<String, Object>> getTtjjhjht2ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht2DTO> ttjjhjht2DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjht2DTOs = ttjjhjht2Dao.getTtjjhjht2ByPageable(start, end);
        } else {
            ttjjhjht2DTOs = ttjjhjht2Dao.getTtjjhjht2ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjht2DTOs)) {
            for (Ttjjhjht2DTO ttjjhjht2DTO : ttjjhjht2DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht2DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjht2Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjht2Dao.getTtjjhjht2Count();
        } else {
            res = ttjjhjht2Dao.getTtjjhjht2CountByParams(params[0]);
        }
        return res;
    }


    /**
     * 公路桥梁隧道年底到达数情况
     **/
    public List<Map<String, Object>> getEndOfYearProgressInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht2DTO> ttjjhjht2DTOs = Lists.newArrayList();
        ttjjhjht2DTOs = ttjjhjht2Dao.getEndOfYearProgressInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjht2DTOs)) {
            for (Ttjjhjht2DTO ttjjhjht2DTO : ttjjhjht2DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht2DTO));
            }
        }
        return res;
    }
}