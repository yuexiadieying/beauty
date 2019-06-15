package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsDriverCreditDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsDriverCreditDTO;
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
public class TScxyTfBsDriverCreditService {

    @Autowired
    private TScxyTfBsDriverCreditDao tScxyTfBsDriverCreditDao;

    public List<Map<String, Object>> getTScxyTfBsDriverCreditByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsDriverCreditDTO> tScxyTfBsDriverCreditDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsDriverCreditDTOs = tScxyTfBsDriverCreditDao.getTScxyTfBsDriverCreditByPageable(start, end);
        } else {
            tScxyTfBsDriverCreditDTOs = tScxyTfBsDriverCreditDao.getTScxyTfBsDriverCreditByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsDriverCreditDTOs)) {
            for (TScxyTfBsDriverCreditDTO tScxyTfBsDriverCreditDTO : tScxyTfBsDriverCreditDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsDriverCreditDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsDriverCreditCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsDriverCreditDao.getTScxyTfBsDriverCreditCount();
        } else {
            res = tScxyTfBsDriverCreditDao.getTScxyTfBsDriverCreditCountByParams();
        }
        return res;
    }
}