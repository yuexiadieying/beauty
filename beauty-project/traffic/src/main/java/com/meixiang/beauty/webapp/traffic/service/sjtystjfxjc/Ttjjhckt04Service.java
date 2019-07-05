package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhckt04Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhckt04DTO;
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
public class Ttjjhckt04Service {

    @Autowired
    private Ttjjhckt04Dao ttjjhckt04Dao;

    public List<Map<String, Object>> getTtjjhckt04ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhckt04DTO> ttjjhckt04DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhckt04DTOs = ttjjhckt04Dao.getTtjjhckt04ByPageable(start, end);
        } else {
            ttjjhckt04DTOs = ttjjhckt04Dao.getTtjjhckt04ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhckt04DTOs)) {
            for (Ttjjhckt04DTO ttjjhckt04DTO : ttjjhckt04DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhckt04DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhckt04Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhckt04Dao.getTtjjhckt04Count();
        } else {
            res = ttjjhckt04Dao.getTtjjhckt04CountByParams(params[0]);
        }
        return res;
    }

    /**
     * 出租汽车运营情况
     **/
    public List<Map<String, Object>> getTextBusinessInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhckt04DTO> ttjjhckt04DTOs = Lists.newArrayList();
        ttjjhckt04DTOs = ttjjhckt04Dao.getTextBusinessInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhckt04DTOs)) {
            for (Ttjjhckt04DTO ttjjhckt04DTO : ttjjhckt04DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhckt04DTO));
            }
        }
        return res;
    }
}