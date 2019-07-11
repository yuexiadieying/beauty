package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsvecgoodsvecexaDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvecgoodsvecexaDTO;
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
public class TsjxttfbsvecgoodsvecexaService {

    @Autowired
    private TsjxttfbsvecgoodsvecexaDao tsjxttfbsvecgoodsvecexaDao;

    public List<Map<String, Object>> getTsjxttfbsvecgoodsvecexaByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsvecgoodsvecexaDTO> tsjxttfbsvecgoodsvecexaDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsvecgoodsvecexaDTOs = tsjxttfbsvecgoodsvecexaDao.getTsjxttfbsvecgoodsvecexaByPageable(start, end);
        } else {
            tsjxttfbsvecgoodsvecexaDTOs = tsjxttfbsvecgoodsvecexaDao.getTsjxttfbsvecgoodsvecexaByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsvecgoodsvecexaDTOs)) {
            for (TsjxttfbsvecgoodsvecexaDTO tsjxttfbsvecgoodsvecexaDTO : tsjxttfbsvecgoodsvecexaDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsvecgoodsvecexaDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsvecgoodsvecexaCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsvecgoodsvecexaDao.getTsjxttfbsvecgoodsvecexaCount();
        } else {
            res = tsjxttfbsvecgoodsvecexaDao.getTsjxttfbsvecgoodsvecexaCountByParams(params[0]);
        }
        return res;
    }
}