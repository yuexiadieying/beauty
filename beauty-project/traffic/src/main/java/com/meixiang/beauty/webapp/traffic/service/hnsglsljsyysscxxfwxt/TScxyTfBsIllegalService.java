package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsIllegalDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsIllegalDTO;
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
public class TScxyTfBsIllegalService {

    @Autowired
    private TScxyTfBsIllegalDao tScxyTfBsIllegalDao;

    public List<Map<String, Object>> getTScxyTfBsIllegalByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsIllegalDTO> tScxyTfBsIllegalDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsIllegalDTOs = tScxyTfBsIllegalDao.getTScxyTfBsIllegalByPageable(start, end);
        } else {
            tScxyTfBsIllegalDTOs = tScxyTfBsIllegalDao.getTScxyTfBsIllegalByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsIllegalDTOs)) {
            for (TScxyTfBsIllegalDTO tScxyTfBsIllegalDTO : tScxyTfBsIllegalDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsIllegalDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsIllegalCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsIllegalDao.getTScxyTfBsIllegalCount();
        } else {
            res = tScxyTfBsIllegalDao.getTScxyTfBsIllegalCountByParams(params[0]);
        }
        return res;
    }
}