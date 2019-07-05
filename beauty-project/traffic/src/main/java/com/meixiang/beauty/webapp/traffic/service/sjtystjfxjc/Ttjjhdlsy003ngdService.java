package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhdlsy003ngdDao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhdlsy003ngdDTO;
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
public class Ttjjhdlsy003ngdService {

    @Autowired
    private Ttjjhdlsy003ngdDao ttjjhdlsy003ngdDao;

    public List<Map<String, Object>> getTtjjhdlsy003ngdByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhdlsy003ngdDTO> ttjjhdlsy003ngdDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhdlsy003ngdDTOs = ttjjhdlsy003ngdDao.getTtjjhdlsy003ngdByPageable(start, end);
        } else {
            ttjjhdlsy003ngdDTOs = ttjjhdlsy003ngdDao.getTtjjhdlsy003ngdByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhdlsy003ngdDTOs)) {
            for (Ttjjhdlsy003ngdDTO ttjjhdlsy003ngdDTO : ttjjhdlsy003ngdDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhdlsy003ngdDTO));
            }
        }
        return res;
    }

    public Integer getTtjjhdlsy003ngdCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhdlsy003ngdDao.getTtjjhdlsy003ngdCount();
        } else {
            res = ttjjhdlsy003ngdDao.getTtjjhdlsy003ngdCountByParams(params[0]);
        }
        return res;
    }


    /**
     * l   道路从业人员数据
     **/
    public List<Map<String, Object>> getRoadWorkersInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhdlsy003ngdDTO> ttjjhdlsy003ngdDTOs = Lists.newArrayList();
        ttjjhdlsy003ngdDTOs = ttjjhdlsy003ngdDao.getRoadWorkersInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhdlsy003ngdDTOs)) {
            for (Ttjjhdlsy003ngdDTO ttjjhdlsy003ngdDTO : ttjjhdlsy003ngdDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhdlsy003ngdDTO));
            }
        }
        return res;
    }
}