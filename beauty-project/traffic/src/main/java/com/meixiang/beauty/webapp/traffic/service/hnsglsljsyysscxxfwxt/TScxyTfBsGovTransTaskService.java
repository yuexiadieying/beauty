package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsGovTransTaskDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsGovTransTaskDTO;
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
public class TScxyTfBsGovTransTaskService {

    @Autowired
    private TScxyTfBsGovTransTaskDao tScxyTfBsGovTransTaskDao;

    public List<Map<String, Object>> getTScxyTfBsGovTransTaskByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsGovTransTaskDTO> tScxyTfBsGovTransTaskDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsGovTransTaskDTOs = tScxyTfBsGovTransTaskDao.getTScxyTfBsGovTransTaskByPageable(start, end);
        } else {
            tScxyTfBsGovTransTaskDTOs = tScxyTfBsGovTransTaskDao.getTScxyTfBsGovTransTaskByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsGovTransTaskDTOs)) {
            for (TScxyTfBsGovTransTaskDTO tScxyTfBsGovTransTaskDTO : tScxyTfBsGovTransTaskDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsGovTransTaskDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsGovTransTaskCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsGovTransTaskDao.getTScxyTfBsGovTransTaskCount();
        } else {
            res = tScxyTfBsGovTransTaskDao.getTScxyTfBsGovTransTaskCountByParams();
        }
        return res;
    }
}