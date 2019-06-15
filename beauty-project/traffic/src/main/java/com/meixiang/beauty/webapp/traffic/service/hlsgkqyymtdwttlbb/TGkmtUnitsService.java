package com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtUnitsDao;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtUnitsDTO;
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
public class TGkmtUnitsService {

    @Autowired
    private TGkmtUnitsDao tGkmtUnitsDao;

    public List<Map<String, Object>> getTGkmtUnitsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TGkmtUnitsDTO> tGkmtUnitsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tGkmtUnitsDTOs = tGkmtUnitsDao.getTGkmtUnitsByPageable(start, end);
        } else {
            tGkmtUnitsDTOs = tGkmtUnitsDao.getTGkmtUnitsByPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tGkmtUnitsDTOs)) {
            for (TGkmtUnitsDTO tGkmtUnitsDTO : tGkmtUnitsDTOs) {
                res.add(ClassUtil.toHashMap(tGkmtUnitsDTO));
            }
        }
        return res;
    }

    public Integer getTGkmtUnitsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tGkmtUnitsDao.getTGkmtUnitsCount();
        } else {
            res = tGkmtUnitsDao.getTGkmtUnitsCountByParams();
        }
        return res;
    }
}