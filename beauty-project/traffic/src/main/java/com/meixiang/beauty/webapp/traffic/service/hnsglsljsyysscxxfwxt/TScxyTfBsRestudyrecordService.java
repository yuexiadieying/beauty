package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsRestudyrecordDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsRestudyrecordDTO;
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
public class TScxyTfBsRestudyrecordService {

    @Autowired
    private TScxyTfBsRestudyrecordDao tScxyTfBsRestudyrecordDao;

    public List<Map<String, Object>> getTScxyTfBsRestudyrecordByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsRestudyrecordDTO> tScxyTfBsRestudyrecordDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsRestudyrecordDTOs = tScxyTfBsRestudyrecordDao.getTScxyTfBsRestudyrecordByPageable(start, end);
        } else {
            tScxyTfBsRestudyrecordDTOs = tScxyTfBsRestudyrecordDao.getTScxyTfBsRestudyrecordByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsRestudyrecordDTOs)) {
            for (TScxyTfBsRestudyrecordDTO tScxyTfBsRestudyrecordDTO : tScxyTfBsRestudyrecordDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsRestudyrecordDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsRestudyrecordCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsRestudyrecordDao.getTScxyTfBsRestudyrecordCount();
        } else {
            res = tScxyTfBsRestudyrecordDao.getTScxyTfBsRestudyrecordCountByParams(params[0]);
        }
        return res;
    }
}