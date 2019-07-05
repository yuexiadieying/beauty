package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhdlsy013ngdDao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhdlsy013ngdDTO;
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
public class Ttjjhdlsy013ngdService {

    @Autowired
    private Ttjjhdlsy013ngdDao ttjjhdlsy013ngdDao;

    public List<Map<String, Object>> getTtjjhdlsy013ngdByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhdlsy013ngdDTO> ttjjhdlsy013ngdDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhdlsy013ngdDTOs = ttjjhdlsy013ngdDao.getTtjjhdlsy013ngdByPageable(start, end);
        } else {
            ttjjhdlsy013ngdDTOs = ttjjhdlsy013ngdDao.getTtjjhdlsy013ngdByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhdlsy013ngdDTOs)) {
            for (Ttjjhdlsy013ngdDTO ttjjhdlsy013ngdDTO : ttjjhdlsy013ngdDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhdlsy013ngdDTO));
            }
        }
        return res;
    }

    public Integer getTtjjhdlsy013ngdCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhdlsy013ngdDao.getTtjjhdlsy013ngdCount();
        } else {
            res = ttjjhdlsy013ngdDao.getTtjjhdlsy013ngdCountByParams(params[0]);
        }
        return res;
    }

    /**
     *  港澳台及外商投资道路运输业情况数据
     **/
    public List<Map<String, Object>> getRoadTransportInvestedByGOTInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhdlsy013ngdDTO> ttjjhdlsy013ngdDTOs = Lists.newArrayList();
        ttjjhdlsy013ngdDTOs = ttjjhdlsy013ngdDao.getRoadTransportInvestedByGOTInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhdlsy013ngdDTOs)) {
            for (Ttjjhdlsy013ngdDTO ttjjhdlsy013ngdDTO : ttjjhdlsy013ngdDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhdlsy013ngdDTO));
            }
        }
        return res;
    }
}