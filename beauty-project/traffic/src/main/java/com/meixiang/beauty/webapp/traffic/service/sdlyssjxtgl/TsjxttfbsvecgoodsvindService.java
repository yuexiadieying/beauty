package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsvecgoodsvindDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvecgoodsvindDTO;
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
public class TsjxttfbsvecgoodsvindService {

    @Autowired
    private TsjxttfbsvecgoodsvindDao tsjxttfbsvecgoodsvindDao;

    public List<Map<String, Object>> getTsjxttfbsvecgoodsvindByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsvecgoodsvindDTO> tsjxttfbsvecgoodsvindDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsvecgoodsvindDTOs = tsjxttfbsvecgoodsvindDao.getTsjxttfbsvecgoodsvindByPageable(start, end);
        } else {
            tsjxttfbsvecgoodsvindDTOs = tsjxttfbsvecgoodsvindDao.getTsjxttfbsvecgoodsvindByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsvecgoodsvindDTOs)) {
            for (TsjxttfbsvecgoodsvindDTO tsjxttfbsvecgoodsvindDTO : tsjxttfbsvecgoodsvindDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsvecgoodsvindDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsvecgoodsvindCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsvecgoodsvindDao.getTsjxttfbsvecgoodsvindCount();
        } else {
            res = tsjxttfbsvecgoodsvindDao.getTsjxttfbsvecgoodsvindCountByParams(params[0]);
        }
        return res;
    }
}