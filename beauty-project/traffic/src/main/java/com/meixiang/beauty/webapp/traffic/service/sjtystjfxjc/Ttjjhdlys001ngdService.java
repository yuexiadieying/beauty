package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhdlys001ngdDao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhdlys001ngdDTO;
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
public class Ttjjhdlys001ngdService {

    @Autowired
    private Ttjjhdlys001ngdDao ttjjhdlys001ngdDao;

    public List<Map<String, Object>> getTtjjhdlys001ngdByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhdlys001ngdDTO> ttjjhdlys001ngdDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhdlys001ngdDTOs = ttjjhdlys001ngdDao.getTtjjhdlys001ngdByPageable(start, end);
        } else {
            ttjjhdlys001ngdDTOs = ttjjhdlys001ngdDao.getTtjjhdlys001ngdByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhdlys001ngdDTOs)) {
            for (Ttjjhdlys001ngdDTO ttjjhdlys001ngdDTO : ttjjhdlys001ngdDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhdlys001ngdDTO));
            }
        }
        return res;
    }

    public Integer getTtjjhdlys001ngdCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhdlys001ngdDao.getTtjjhdlys001ngdCount();
        } else {
            res = ttjjhdlys001ngdDao.getTtjjhdlys001ngdCountByParams(params[0]);
        }
        return res;
    }
}