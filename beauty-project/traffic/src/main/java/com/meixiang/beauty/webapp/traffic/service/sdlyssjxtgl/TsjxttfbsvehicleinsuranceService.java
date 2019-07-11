package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsvehicleinsuranceDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvehicleinsuranceDTO;
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
public class TsjxttfbsvehicleinsuranceService {

    @Autowired
    private TsjxttfbsvehicleinsuranceDao tsjxttfbsvehicleinsuranceDao;

    public List<Map<String, Object>> getTsjxttfbsvehicleinsuranceByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsvehicleinsuranceDTO> tsjxttfbsvehicleinsuranceDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsvehicleinsuranceDTOs = tsjxttfbsvehicleinsuranceDao.getTsjxttfbsvehicleinsuranceByPageable(start, end);
        } else {
            tsjxttfbsvehicleinsuranceDTOs = tsjxttfbsvehicleinsuranceDao.getTsjxttfbsvehicleinsuranceByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsvehicleinsuranceDTOs)) {
            for (TsjxttfbsvehicleinsuranceDTO tsjxttfbsvehicleinsuranceDTO : tsjxttfbsvehicleinsuranceDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsvehicleinsuranceDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsvehicleinsuranceCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsvehicleinsuranceDao.getTsjxttfbsvehicleinsuranceCount();
        } else {
            res = tsjxttfbsvehicleinsuranceDao.getTsjxttfbsvehicleinsuranceCountByParams(params[0]);
        }
        return res;
    }
}