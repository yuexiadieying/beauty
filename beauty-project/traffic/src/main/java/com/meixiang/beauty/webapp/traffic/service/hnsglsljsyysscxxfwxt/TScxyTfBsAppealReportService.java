package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsAppealReportDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsAppealReportDTO;
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
public class TScxyTfBsAppealReportService {

    @Autowired
    private TScxyTfBsAppealReportDao tScxyTfBsAppealReportDao;

    public List<Map<String, Object>> getTScxyTfBsAppealReportByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsAppealReportDTO> tScxyTfBsAppealReportDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsAppealReportDTOs = tScxyTfBsAppealReportDao.getTScxyTfBsAppealReportByPageable(start, end);
        } else {
            tScxyTfBsAppealReportDTOs = tScxyTfBsAppealReportDao.getTScxyTfBsAppealReportByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsAppealReportDTOs)) {
            for (TScxyTfBsAppealReportDTO tScxyTfBsAppealReportDTO : tScxyTfBsAppealReportDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsAppealReportDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsAppealReportCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsAppealReportDao.getTScxyTfBsAppealReportCount();
        } else {
            res = tScxyTfBsAppealReportDao.getTScxyTfBsAppealReportCountByParams();
        }
        return res;
    }
}