package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsjurctcDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsjurctcDTO;
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
public class TsjxttfbsjurctcService {

    @Autowired
    private TsjxttfbsjurctcDao tsjxttfbsjurctcDao;

    public List<Map<String, Object>> getTsjxttfbsjurctcByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsjurctcDTO> tsjxttfbsjurctcDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsjurctcDTOs = tsjxttfbsjurctcDao.getTsjxttfbsjurctcByPageable(start, end);
        } else {
            tsjxttfbsjurctcDTOs = tsjxttfbsjurctcDao.getTsjxttfbsjurctcByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsjurctcDTOs)) {
            for (TsjxttfbsjurctcDTO tsjxttfbsjurctcDTO : tsjxttfbsjurctcDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsjurctcDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsjurctcCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsjurctcDao.getTsjxttfbsjurctcCount();
        } else {
            res = tsjxttfbsjurctcDao.getTsjxttfbsjurctcCountByParams(params[0]);
        }
        return res;
    }
}