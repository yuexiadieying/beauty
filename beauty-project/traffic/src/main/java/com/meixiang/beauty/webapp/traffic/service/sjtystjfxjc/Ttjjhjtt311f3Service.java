package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjtt311f3Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtt311f3DTO;
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
public class Ttjjhjtt311f3Service {

    @Autowired
    private Ttjjhjtt311f3Dao ttjjhjtt311f3Dao;

    public List<Map<String, Object>> getTtjjhjtt311f3ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtt311f3DTO> ttjjhjtt311f3DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjtt311f3DTOs = ttjjhjtt311f3Dao.getTtjjhjtt311f3ByPageable(start, end);
        } else {
            ttjjhjtt311f3DTOs = ttjjhjtt311f3Dao.getTtjjhjtt311f3ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjtt311f3DTOs)) {
            for (Ttjjhjtt311f3DTO ttjjhjtt311f3DTO : ttjjhjtt311f3DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtt311f3DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjtt311f3Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjtt311f3Dao.getTtjjhjtt311f3Count();
        } else {
            res = ttjjhjtt311f3Dao.getTtjjhjtt311f3CountByParams(params[0]);
        }
        return res;
    }


    /**
     * 内河航道通航里程年底达到量情况
     **/
    public List<Map<String, Object>> getEndOfYearMileageInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtt311f3DTO> ttjjhjtt311f3DTOs = Lists.newArrayList();
        ttjjhjtt311f3DTOs = ttjjhjtt311f3Dao.getEndOfYearMileageInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjtt311f3DTOs)) {
            for (Ttjjhjtt311f3DTO ttjjhjtt311f3DTO : ttjjhjtt311f3DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtt311f3DTO));
            }
        }
        return res;
    }

}