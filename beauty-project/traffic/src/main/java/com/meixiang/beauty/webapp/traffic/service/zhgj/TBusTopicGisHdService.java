package com.meixiang.beauty.webapp.traffic.service.zhgj;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.zhgj.TBusTopicGisHdDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusTopicGisHdDTO;
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
public class TBusTopicGisHdService {

    @Autowired
    private TBusTopicGisHdDao tBusTopicGisHdDao;

    public List<Map<String, Object>> getTBusTopicGisHdByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TBusTopicGisHdDTO> tBusTopicGisHdDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tBusTopicGisHdDTOs = tBusTopicGisHdDao.getTBusTopicGisHdByPageable(start, end);
        } else {
            tBusTopicGisHdDTOs = tBusTopicGisHdDao.getTBusTopicGisHdByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tBusTopicGisHdDTOs)) {
            for (TBusTopicGisHdDTO tBusTopicGisHdDTO : tBusTopicGisHdDTOs) {
                res.add(ClassUtil.toHashMap(tBusTopicGisHdDTO));
            }
        }
        return res;
    }

    public Integer getTBusTopicGisHdCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tBusTopicGisHdDao.getTBusTopicGisHdCount();
        } else {
            res = tBusTopicGisHdDao.getTBusTopicGisHdCountByParams(params[0]);
        }
        return res;
    }
}