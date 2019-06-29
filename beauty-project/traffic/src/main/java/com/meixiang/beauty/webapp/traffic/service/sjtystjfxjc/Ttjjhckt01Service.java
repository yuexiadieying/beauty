package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhckt01Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhckt01DTO;
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
public class Ttjjhckt01Service {

    @Autowired
    private Ttjjhckt01Dao ttjjhckt01Dao;

    public List<Map<String, Object>> getTtjjhckt01ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhckt01DTO> ttjjhckt01DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhckt01DTOs = ttjjhckt01Dao.getTtjjhckt01ByPageable(start, end);
        } else {
            ttjjhckt01DTOs = ttjjhckt01Dao.getTtjjhckt01ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhckt01DTOs)) {
            for (Ttjjhckt01DTO ttjjhckt01DTO : ttjjhckt01DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhckt01DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhckt01Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhckt01Dao.getTtjjhckt01Count();
        } else {
            res = ttjjhckt01Dao.getTtjjhckt01CountByParams(params[0]);
        }
        return res;
    }

    /**
     * 城市（县城）客运交通管理信息
     **/
    public List<Map<String, Object>> getPassengerTrafficManagerInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhckt01DTO> ttjjhckt01DTOs = Lists.newArrayList();
        ttjjhckt01DTOs = ttjjhckt01Dao.getPassengerTrafficManagerInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhckt01DTOs)) {
            for (Ttjjhckt01DTO ttjjhckt01DTO : ttjjhckt01DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhckt01DTO));
            }
        }
        return res;
    }
}