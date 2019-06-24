package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsAccidentDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsAccidentDTO;
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
public class TScxyTfBsAccidentService {

    @Autowired
    private TScxyTfBsAccidentDao tScxyTfBsAccidentDao;

    public List<Map<String, Object>> getTScxyTfBsAccidentByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsAccidentDTO> tScxyTfBsAccidentDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsAccidentDTOs = tScxyTfBsAccidentDao.getTScxyTfBsAccidentByPageable(start, end);
        } else {
            tScxyTfBsAccidentDTOs = tScxyTfBsAccidentDao.getTScxyTfBsAccidentByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsAccidentDTOs)) {
            for (TScxyTfBsAccidentDTO tScxyTfBsAccidentDTO : tScxyTfBsAccidentDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsAccidentDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsAccidentCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsAccidentDao.getTScxyTfBsAccidentCount();
        } else {
            res = tScxyTfBsAccidentDao.getTScxyTfBsAccidentCountByParams(params[0]);
        }
        return res;
    }
}