package com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtReportdataDao;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtReportdataDTO;
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
public class TGkmtReportdataService {

    @Autowired
    private TGkmtReportdataDao tGkmtReportdataDao;

    public List<Map<String, Object>> getTGkmtReportdataByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TGkmtReportdataDTO> tGkmtReportdataDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tGkmtReportdataDTOs = tGkmtReportdataDao.getTGkmtReportdataByPageable(start, end);
        } else {
            tGkmtReportdataDTOs = tGkmtReportdataDao.getTGkmtReportdataByParamsPageable(start, end, params[0],params[1],params[2],params[3]);
        }
        if (!CollectionUtils.isEmpty(tGkmtReportdataDTOs)) {
            for (TGkmtReportdataDTO tGkmtReportdataDTO : tGkmtReportdataDTOs) {
                res.add(ClassUtil.toHashMap(tGkmtReportdataDTO));
            }
        }
        return res;
    }

    public Integer getTGkmtReportdataCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tGkmtReportdataDao.getTGkmtReportdataCount();
        } else {
            res = tGkmtReportdataDao.getTGkmtReportdataCountByParams();
        }
        return res;
    }
}