package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsCreditReportDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsCreditReportDTO;
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
public class TScxyTfBsCreditReportService {

    @Autowired
    private TScxyTfBsCreditReportDao tScxyTfBsCreditReportDao;

    public List<Map<String, Object>> getTScxyTfBsCreditReportByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsCreditReportDTO> tScxyTfBsCreditReportDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsCreditReportDTOs = tScxyTfBsCreditReportDao.getTScxyTfBsCreditReportByPageable(start, end);
        } else {
            tScxyTfBsCreditReportDTOs = tScxyTfBsCreditReportDao.getTScxyTfBsCreditReportByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsCreditReportDTOs)) {
            for (TScxyTfBsCreditReportDTO tScxyTfBsCreditReportDTO : tScxyTfBsCreditReportDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsCreditReportDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsCreditReportCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsCreditReportDao.getTScxyTfBsCreditReportCount();
        } else {
            res = tScxyTfBsCreditReportDao.getTScxyTfBsCreditReportCountByParams(params[0]);
        }
        return res;
    }
}