package com.meixiang.beauty.webapp.traffic.service.zhgj;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.zhgj.TBusLineStationRefDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusLineStationRefDTO;
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
public class TBusLineStationRefService {

    @Autowired
    private TBusLineStationRefDao tBusLineStationRefDao;

    public List<Map<String, Object>> getTBusLineStationRefByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TBusLineStationRefDTO> tBusLineStationRefDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tBusLineStationRefDTOs = tBusLineStationRefDao.getTBusLineStationRefByPageable(start, end);
        } else {
            tBusLineStationRefDTOs = tBusLineStationRefDao.getTBusLineStationRefByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tBusLineStationRefDTOs)) {
            for (TBusLineStationRefDTO tBusLineStationRefDTO : tBusLineStationRefDTOs) {
                res.add(ClassUtil.toHashMap(tBusLineStationRefDTO));
            }
        }
        return res;
    }

    public Integer getTBusLineStationRefCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tBusLineStationRefDao.getTBusLineStationRefCount();
        } else {
            res = tBusLineStationRefDao.getTBusLineStationRefCountByParams(params[0]);
        }
        return res;
    }
}