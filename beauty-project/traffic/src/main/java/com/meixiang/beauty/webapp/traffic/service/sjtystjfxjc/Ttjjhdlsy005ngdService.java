package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhdlsy005ngdDao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhdlsy005ngdDTO;
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
public class Ttjjhdlsy005ngdService {

    @Autowired
    private Ttjjhdlsy005ngdDao ttjjhdlsy005ngdDao;

    public List<Map<String, Object>> getTtjjhdlsy005ngdByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhdlsy005ngdDTO> ttjjhdlsy005ngdDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhdlsy005ngdDTOs = ttjjhdlsy005ngdDao.getTtjjhdlsy005ngdByPageable(start, end);
        } else {
            ttjjhdlsy005ngdDTOs = ttjjhdlsy005ngdDao.getTtjjhdlsy005ngdByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhdlsy005ngdDTOs)) {
            for (Ttjjhdlsy005ngdDTO ttjjhdlsy005ngdDTO : ttjjhdlsy005ngdDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhdlsy005ngdDTO));
            }
        }
        return res;
    }

    public Integer getTtjjhdlsy005ngdCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhdlsy005ngdDao.getTtjjhdlsy005ngdCount();
        } else {
            res = ttjjhdlsy005ngdDao.getTtjjhdlsy005ngdCountByParams(params[0]);
        }
        return res;
    }
}