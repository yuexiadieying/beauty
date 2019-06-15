package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsQualityEventDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsQualityEventDTO;
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
public class TScxyTfBsQualityEventService {

    @Autowired
    private TScxyTfBsQualityEventDao tScxyTfBsQualityEventDao;

    public List<Map<String, Object>> getTScxyTfBsQualityEventByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsQualityEventDTO> tScxyTfBsQualityEventDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsQualityEventDTOs = tScxyTfBsQualityEventDao.getTScxyTfBsQualityEventByPageable(start, end);
        } else {
            tScxyTfBsQualityEventDTOs = tScxyTfBsQualityEventDao.getTScxyTfBsQualityEventByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsQualityEventDTOs)) {
            for (TScxyTfBsQualityEventDTO tScxyTfBsQualityEventDTO : tScxyTfBsQualityEventDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsQualityEventDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsQualityEventCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsQualityEventDao.getTScxyTfBsQualityEventCount();
        } else {
            res = tScxyTfBsQualityEventDao.getTScxyTfBsQualityEventCountByParams();
        }
        return res;
    }
}