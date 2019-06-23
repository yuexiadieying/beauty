package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerHonorDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerHonorDTO;
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
public class TScxyTfBsOwnerHonorService {

    @Autowired
    private TScxyTfBsOwnerHonorDao tScxyTfBsOwnerHonorDao;

    public List<Map<String, Object>> getTScxyTfBsOwnerHonorByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsOwnerHonorDTO> tScxyTfBsOwnerHonorDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsOwnerHonorDTOs = tScxyTfBsOwnerHonorDao.getTScxyTfBsOwnerHonorByPageable(start, end);
        } else {
            tScxyTfBsOwnerHonorDTOs = tScxyTfBsOwnerHonorDao.getTScxyTfBsOwnerHonorByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsOwnerHonorDTOs)) {
            for (TScxyTfBsOwnerHonorDTO tScxyTfBsOwnerHonorDTO : tScxyTfBsOwnerHonorDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsOwnerHonorDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsOwnerHonorCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsOwnerHonorDao.getTScxyTfBsOwnerHonorCount();
        } else {
            res = tScxyTfBsOwnerHonorDao.getTScxyTfBsOwnerHonorCountByParams(params[0]);
        }
        return res;
    }
}