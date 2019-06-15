package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsBusReformRecordDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsBusReformRecordDTO;
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
public class TScxyTfBsBusReformRecordService {

    @Autowired
    private TScxyTfBsBusReformRecordDao tScxyTfBsBusReformRecordDao;

    public List<Map<String, Object>> getTScxyTfBsBusReformRecordByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsBusReformRecordDTO> tScxyTfBsBusReformRecordDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsBusReformRecordDTOs = tScxyTfBsBusReformRecordDao.getTScxyTfBsBusReformRecordByPageable(start, end);
        } else {
            tScxyTfBsBusReformRecordDTOs = tScxyTfBsBusReformRecordDao.getTScxyTfBsBusReformRecordByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsBusReformRecordDTOs)) {
            for (TScxyTfBsBusReformRecordDTO tScxyTfBsBusReformRecordDTO : tScxyTfBsBusReformRecordDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsBusReformRecordDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsBusReformRecordCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsBusReformRecordDao.getTScxyTfBsBusReformRecordCount();
        } else {
            res = tScxyTfBsBusReformRecordDao.getTScxyTfBsBusReformRecordCountByParams();
        }
        return res;
    }
}