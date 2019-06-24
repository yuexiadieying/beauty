package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsEntStabilityDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsEntStabilityDTO;
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
public class TScxyTfBsEntStabilityService {

    @Autowired
    private TScxyTfBsEntStabilityDao tScxyTfBsEntStabilityDao;

    public List<Map<String, Object>> getTScxyTfBsEntStabilityByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsEntStabilityDTO> tScxyTfBsEntStabilityDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsEntStabilityDTOs = tScxyTfBsEntStabilityDao.getTScxyTfBsEntStabilityByPageable(start, end);
        } else {
            tScxyTfBsEntStabilityDTOs = tScxyTfBsEntStabilityDao.getTScxyTfBsEntStabilityByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsEntStabilityDTOs)) {
            for (TScxyTfBsEntStabilityDTO tScxyTfBsEntStabilityDTO : tScxyTfBsEntStabilityDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsEntStabilityDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsEntStabilityCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsEntStabilityDao.getTScxyTfBsEntStabilityCount();
        } else {
            res = tScxyTfBsEntStabilityDao.getTScxyTfBsEntStabilityCountByParams(params[0]);
        }
        return res;
    }
}