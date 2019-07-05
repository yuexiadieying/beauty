package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhdlsy011ngdDao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhdlsy011ngdDTO;
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
public class Ttjjhdlsy011ngdService {

    @Autowired
    private Ttjjhdlsy011ngdDao ttjjhdlsy011ngdDao;

    public List<Map<String, Object>> getTtjjhdlsy011ngdByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhdlsy011ngdDTO> ttjjhdlsy011ngdDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhdlsy011ngdDTOs = ttjjhdlsy011ngdDao.getTtjjhdlsy011ngdByPageable(start, end);
        } else {
            ttjjhdlsy011ngdDTOs = ttjjhdlsy011ngdDao.getTtjjhdlsy011ngdByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhdlsy011ngdDTOs)) {
            for (Ttjjhdlsy011ngdDTO ttjjhdlsy011ngdDTO : ttjjhdlsy011ngdDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhdlsy011ngdDTO));
            }
        }
        return res;
    }

    public Integer getTtjjhdlsy011ngdCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhdlsy011ngdDao.getTtjjhdlsy011ngdCount();
        } else {
            res = ttjjhdlsy011ngdDao.getTtjjhdlsy011ngdCountByParams(params[0]);
        }
        return res;
    }

    /**
     *  道路危险货物运输数据
     **/
    public List<Map<String, Object>> getDangerThingsTransportNumInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhdlsy011ngdDTO> ttjjhdlsy011ngdDTOs = Lists.newArrayList();
        ttjjhdlsy011ngdDTOs = ttjjhdlsy011ngdDao.getDangerThingsTransportNumInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhdlsy011ngdDTOs)) {
            for (Ttjjhdlsy011ngdDTO ttjjhdlsy011ngdDTO : ttjjhdlsy011ngdDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhdlsy011ngdDTO));
            }
        }
        return res;
    }

}