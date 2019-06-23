package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsComplaintDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsComplaintDTO;
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
public class TScxyTfBsComplaintService {

    @Autowired
    private TScxyTfBsComplaintDao tScxyTfBsComplaintDao;

    public List<Map<String, Object>> getTScxyTfBsComplaintByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsComplaintDTO> tScxyTfBsComplaintDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsComplaintDTOs = tScxyTfBsComplaintDao.getTScxyTfBsComplaintByPageable(start, end);
        } else {
            tScxyTfBsComplaintDTOs = tScxyTfBsComplaintDao.getTScxyTfBsComplaintByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsComplaintDTOs)) {
            for (TScxyTfBsComplaintDTO tScxyTfBsComplaintDTO : tScxyTfBsComplaintDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsComplaintDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsComplaintCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsComplaintDao.getTScxyTfBsComplaintCount();
        } else {
            res = tScxyTfBsComplaintDao.getTScxyTfBsComplaintCountByParams(params[0]);
        }
        return res;
    }
}