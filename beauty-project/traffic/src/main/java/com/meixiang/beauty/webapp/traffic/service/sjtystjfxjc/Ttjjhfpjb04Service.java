package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhfpjb04Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhfpjb04DTO;
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
public class Ttjjhfpjb04Service {

    @Autowired
    private Ttjjhfpjb04Dao ttjjhfpjb04Dao;

    public List<Map<String, Object>> getTtjjhfpjb04ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhfpjb04DTO> ttjjhfpjb04DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhfpjb04DTOs = ttjjhfpjb04Dao.getTtjjhfpjb04ByPageable(start, end);
        } else {
            ttjjhfpjb04DTOs = ttjjhfpjb04Dao.getTtjjhfpjb04ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhfpjb04DTOs)) {
            for (Ttjjhfpjb04DTO ttjjhfpjb04DTO : ttjjhfpjb04DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhfpjb04DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhfpjb04Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhfpjb04Dao.getTtjjhfpjb04Count();
        } else {
            res = ttjjhfpjb04Dao.getTtjjhfpjb04CountByParams(params[0]);
        }
        return res;
    }


    /**
     * 村公路资金到位情况／县道 省级资金到位／乡道市级资金到位／农村县级公路资金到位／未到位个数，已到位个数
     **/
    public List<Map<String, Object>> getVillageRoadMoneyInPlaceInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhfpjb04DTO> ttjjhfpjb04DTOs = Lists.newArrayList();
        ttjjhfpjb04DTOs = ttjjhfpjb04Dao.getVillageRoadMoneyInPlaceInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhfpjb04DTOs)) {
            for (Ttjjhfpjb04DTO ttjjhfpjb04DTO : ttjjhfpjb04DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhfpjb04DTO));
            }
        }
        return res;
    }
}