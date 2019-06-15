package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerReformDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerReformDTO;
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
public class TScxyTfBsOwnerReformService {

    @Autowired
    private TScxyTfBsOwnerReformDao tScxyTfBsOwnerReformDao;

    public List<Map<String, Object>> getTScxyTfBsOwnerReformByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsOwnerReformDTO> tScxyTfBsOwnerReformDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsOwnerReformDTOs = tScxyTfBsOwnerReformDao.getTScxyTfBsOwnerReformByPageable(start, end);
        } else {
            tScxyTfBsOwnerReformDTOs = tScxyTfBsOwnerReformDao.getTScxyTfBsOwnerReformByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsOwnerReformDTOs)) {
            for (TScxyTfBsOwnerReformDTO tScxyTfBsOwnerReformDTO : tScxyTfBsOwnerReformDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsOwnerReformDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsOwnerReformCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsOwnerReformDao.getTScxyTfBsOwnerReformCount();
        } else {
            res = tScxyTfBsOwnerReformDao.getTScxyTfBsOwnerReformCountByParams();
        }
        return res;
    }
}