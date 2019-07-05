package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjht21Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht21DTO;
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
public class Ttjjhjht21Service {

    @Autowired
    private Ttjjhjht21Dao ttjjhjht21Dao;

    public List<Map<String, Object>> getTtjjhjht21ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht21DTO> ttjjhjht21DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjht21DTOs = ttjjhjht21Dao.getTtjjhjht21ByPageable(start, end);
        } else {
            ttjjhjht21DTOs = ttjjhjht21Dao.getTtjjhjht21ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjht21DTOs)) {
            for (Ttjjhjht21DTO ttjjhjht21DTO : ttjjhjht21DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht21DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjht21Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjht21Dao.getTtjjhjht21Count();
        } else {
            res = ttjjhjht21Dao.getTtjjhjht21CountByParams(params[0]);
        }
        return res;
    }


    /**
     * 营业性运输船舶燃料消耗情况数据
     **/
    public List<Map<String, Object>> getBusinessBoatFuelInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht21DTO> ttjjhjht21DTOs = Lists.newArrayList();
        ttjjhjht21DTOs = ttjjhjht21Dao.getBusinessBoatFuelInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjht21DTOs)) {
            for (Ttjjhjht21DTO ttjjhjht21DTO : ttjjhjht21DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht21DTO));
            }
        }
        return res;
    }

    /**
     * 水路运输法人企业财务状况
     **/
    public List<Map<String, Object>> getWaterRoadTransportEnterpriseAccountInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht21DTO> ttjjhjht21DTOs = Lists.newArrayList();
        ttjjhjht21DTOs = ttjjhjht21Dao.getWaterRoadTransportEnterpriseAccountInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjht21DTOs)) {
            for (Ttjjhjht21DTO ttjjhjht21DTO : ttjjhjht21DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht21DTO));
            }
        }
        return res;
    }


}