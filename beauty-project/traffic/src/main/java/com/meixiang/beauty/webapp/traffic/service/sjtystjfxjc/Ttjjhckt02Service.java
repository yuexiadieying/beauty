package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhckt02Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhckt02DTO;
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
public class Ttjjhckt02Service {

    @Autowired
    private Ttjjhckt02Dao ttjjhckt02Dao;

    public List<Map<String, Object>> getTtjjhckt02ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhckt02DTO> ttjjhckt02DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhckt02DTOs = ttjjhckt02Dao.getTtjjhckt02ByPageable(start, end);
        } else {
            ttjjhckt02DTOs = ttjjhckt02Dao.getTtjjhckt02ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhckt02DTOs)) {
            for (Ttjjhckt02DTO ttjjhckt02DTO : ttjjhckt02DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhckt02DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhckt02Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhckt02Dao.getTtjjhckt02Count();
        } else {
            res = ttjjhckt02Dao.getTtjjhckt02CountByParams(params[0]);
        }
        return res;
    }

    /**
     * 城市公交运营情况
     **/
    public List<Map<String, Object>> getBusBusinessInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhckt02DTO> ttjjhckt02DTOs = Lists.newArrayList();
        ttjjhckt02DTOs = ttjjhckt02Dao.getBusBusinessInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhckt02DTOs)) {
            for (Ttjjhckt02DTO ttjjhckt02DTO : ttjjhckt02DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhckt02DTO));
            }
        }
        return res;
    }
}