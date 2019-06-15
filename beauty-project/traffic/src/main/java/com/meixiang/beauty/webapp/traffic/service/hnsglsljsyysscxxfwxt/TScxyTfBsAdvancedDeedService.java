package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsAdvancedDeedDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsAdvancedDeedDTO;
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
public class TScxyTfBsAdvancedDeedService {

    @Autowired
    private TScxyTfBsAdvancedDeedDao tScxyTfBsAdvancedDeedDao;

    public List<Map<String, Object>> getTScxyTfBsAdvancedDeedByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsAdvancedDeedDTO> tScxyTfBsAdvancedDeedDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsAdvancedDeedDTOs = tScxyTfBsAdvancedDeedDao.getTScxyTfBsAdvancedDeedByPageable(start, end);
        } else {
            tScxyTfBsAdvancedDeedDTOs = tScxyTfBsAdvancedDeedDao.getTScxyTfBsAdvancedDeedByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsAdvancedDeedDTOs)) {
            for (TScxyTfBsAdvancedDeedDTO tScxyTfBsAdvancedDeedDTO : tScxyTfBsAdvancedDeedDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsAdvancedDeedDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsAdvancedDeedCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsAdvancedDeedDao.getTScxyTfBsAdvancedDeedCount();
        } else {
            res = tScxyTfBsAdvancedDeedDao.getTScxyTfBsAdvancedDeedCountByParams();
        }
        return res;
    }
}