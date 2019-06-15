package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsFacilityDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsFacilityDTO;
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
public class TScxyTfBsFacilityService {

    @Autowired
    private TScxyTfBsFacilityDao tScxyTfBsFacilityDao;

    public List<Map<String, Object>> getTScxyTfBsFacilityByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsFacilityDTO> tScxyTfBsFacilityDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsFacilityDTOs = tScxyTfBsFacilityDao.getTScxyTfBsFacilityByPageable(start, end);
        } else {
            tScxyTfBsFacilityDTOs = tScxyTfBsFacilityDao.getTScxyTfBsFacilityByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsFacilityDTOs)) {
            for (TScxyTfBsFacilityDTO tScxyTfBsFacilityDTO : tScxyTfBsFacilityDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsFacilityDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsFacilityCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsFacilityDao.getTScxyTfBsFacilityCount();
        } else {
            res = tScxyTfBsFacilityDao.getTScxyTfBsFacilityCountByParams();
        }
        return res;
    }
}