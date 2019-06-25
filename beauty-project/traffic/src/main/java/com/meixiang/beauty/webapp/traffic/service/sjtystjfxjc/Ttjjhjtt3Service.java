package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjtt3Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtt3DTO;
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
public class Ttjjhjtt3Service {

    @Autowired
    private Ttjjhjtt3Dao ttjjhjtt3Dao;

    public List<Map<String, Object>> getTtjjhjtt3ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtt3DTO> ttjjhjtt3DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjtt3DTOs = ttjjhjtt3Dao.getTtjjhjtt3ByPageable(start, end);
        } else {
            ttjjhjtt3DTOs = ttjjhjtt3Dao.getTtjjhjtt3ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjtt3DTOs)) {
            for (Ttjjhjtt3DTO ttjjhjtt3DTO : ttjjhjtt3DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtt3DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjtt3Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjtt3Dao.getTtjjhjtt3Count();
        } else {
            res = ttjjhjtt3Dao.getTtjjhjtt3CountByParams(params[0]);
        }
        return res;
    }
}