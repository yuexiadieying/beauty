package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsvectrancertDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvectrancertDTO;
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
public class TsjxttfbsvectrancertService {

    @Autowired
    private TsjxttfbsvectrancertDao tsjxttfbsvectrancertDao;

    public List<Map<String, Object>> getTsjxttfbsvectrancertByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsvectrancertDTO> tsjxttfbsvectrancertDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsvectrancertDTOs = tsjxttfbsvectrancertDao.getTsjxttfbsvectrancertByPageable(start, end);
        } else {
            tsjxttfbsvectrancertDTOs = tsjxttfbsvectrancertDao.getTsjxttfbsvectrancertByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsvectrancertDTOs)) {
            for (TsjxttfbsvectrancertDTO tsjxttfbsvectrancertDTO : tsjxttfbsvectrancertDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsvectrancertDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsvectrancertCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsvectrancertDao.getTsjxttfbsvectrancertCount();
        } else {
            res = tsjxttfbsvectrancertDao.getTsjxttfbsvectrancertCountByParams(params[0]);
        }
        return res;
    }
}