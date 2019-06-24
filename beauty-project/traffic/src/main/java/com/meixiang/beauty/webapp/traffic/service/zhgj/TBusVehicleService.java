package com.meixiang.beauty.webapp.traffic.service.zhgj;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.zhgj.TBusVehicleDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusVehicleDTO;
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
public class TBusVehicleService {

    @Autowired
    private TBusVehicleDao tBusVehicleDao;

    public List<Map<String, Object>> getTBusVehicleByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TBusVehicleDTO> tBusVehicleDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tBusVehicleDTOs = tBusVehicleDao.getTBusVehicleByPageable(start, end);
        } else {
            tBusVehicleDTOs = tBusVehicleDao.getTBusVehicleByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tBusVehicleDTOs)) {
            for (TBusVehicleDTO tBusVehicleDTO : tBusVehicleDTOs) {
                res.add(ClassUtil.toHashMap(tBusVehicleDTO));
            }
        }
        return res;
    }

    public Integer getTBusVehicleCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tBusVehicleDao.getTBusVehicleCount();
        } else {
            res = tBusVehicleDao.getTBusVehicleCountByParams(params[0]);
        }
        return res;
    }
}