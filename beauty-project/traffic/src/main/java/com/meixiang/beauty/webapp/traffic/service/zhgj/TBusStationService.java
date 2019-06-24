package com.meixiang.beauty.webapp.traffic.service.zhgj;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.zhgj.TBusStationDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusStationDTO;
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
public class TBusStationService {

    @Autowired
    private TBusStationDao tBusStationDao;

    public List<Map<String, Object>> getTBusStationByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TBusStationDTO> tBusStationDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tBusStationDTOs = tBusStationDao.getTBusStationByPageable(start, end);
        } else {
            tBusStationDTOs = tBusStationDao.getTBusStationByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tBusStationDTOs)) {
            for (TBusStationDTO tBusStationDTO : tBusStationDTOs) {
                res.add(ClassUtil.toHashMap(tBusStationDTO));
            }
        }
        return res;
    }

    public Integer getTBusStationCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tBusStationDao.getTBusStationCount();
        } else {
            res = tBusStationDao.getTBusStationCountByParams(params[0]);
        }
        return res;
    }
}