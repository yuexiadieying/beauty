package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsBusCreditRecordDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsBusCreditRecordDTO;
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
public class TScxyTfBsBusCreditRecordService {

    @Autowired
    private TScxyTfBsBusCreditRecordDao tScxyTfBsBusCreditRecordDao;

    public List<Map<String, Object>> getTScxyTfBsBusCreditRecordByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsBusCreditRecordDTO> tScxyTfBsBusCreditRecordDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsBusCreditRecordDTOs = tScxyTfBsBusCreditRecordDao.getTScxyTfBsBusCreditRecordByPageable(start, end);
        } else {
            tScxyTfBsBusCreditRecordDTOs = tScxyTfBsBusCreditRecordDao.getTScxyTfBsBusCreditRecordByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsBusCreditRecordDTOs)) {
            for (TScxyTfBsBusCreditRecordDTO tScxyTfBsBusCreditRecordDTO : tScxyTfBsBusCreditRecordDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsBusCreditRecordDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsBusCreditRecordCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsBusCreditRecordDao.getTScxyTfBsBusCreditRecordCount();
        } else {
            res = tScxyTfBsBusCreditRecordDao.getTScxyTfBsBusCreditRecordCountByParams();
        }
        return res;
    }
}