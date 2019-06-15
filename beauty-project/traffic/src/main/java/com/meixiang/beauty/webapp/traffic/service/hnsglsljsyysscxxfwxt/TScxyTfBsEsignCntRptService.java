package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsEsignCntRptDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsEsignCntRptDTO;
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
public class TScxyTfBsEsignCntRptService {

    @Autowired
    private TScxyTfBsEsignCntRptDao tScxyTfBsEsignCntRptDao;

    public List<Map<String, Object>> getTScxyTfBsEsignCntRptByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsEsignCntRptDTO> tScxyTfBsEsignCntRptDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsEsignCntRptDTOs = tScxyTfBsEsignCntRptDao.getTScxyTfBsEsignCntRptByPageable(start, end);
        } else {
            tScxyTfBsEsignCntRptDTOs = tScxyTfBsEsignCntRptDao.getTScxyTfBsEsignCntRptByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsEsignCntRptDTOs)) {
            for (TScxyTfBsEsignCntRptDTO tScxyTfBsEsignCntRptDTO : tScxyTfBsEsignCntRptDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsEsignCntRptDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsEsignCntRptCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsEsignCntRptDao.getTScxyTfBsEsignCntRptCount();
        } else {
            res = tScxyTfBsEsignCntRptDao.getTScxyTfBsEsignCntRptCountByParams();
        }
        return res;
    }
}