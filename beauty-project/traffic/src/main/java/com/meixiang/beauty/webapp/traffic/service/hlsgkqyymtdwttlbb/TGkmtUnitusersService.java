package com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtUnitusersDao;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtUnitusersDTO;
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
public class TGkmtUnitusersService {

    @Autowired
    private TGkmtUnitusersDao tGkmtUnitusersDao;

    public List<Map<String, Object>> getTGkmtUnitusersByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TGkmtUnitusersDTO> tGkmtUnitusersDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tGkmtUnitusersDTOs = tGkmtUnitusersDao.getTGkmtUnitusersByPageable(start, end);
        } else {
            tGkmtUnitusersDTOs = tGkmtUnitusersDao.getTGkmtUnitusersByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tGkmtUnitusersDTOs)) {
            for (TGkmtUnitusersDTO tGkmtUnitusersDTO : tGkmtUnitusersDTOs) {
                res.add(ClassUtil.toHashMap(tGkmtUnitusersDTO));
            }
        }
        return res;
    }

    public Integer getTGkmtUnitusersCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tGkmtUnitusersDao.getTGkmtUnitusersCount();
        } else {
            res = tGkmtUnitusersDao.getTGkmtUnitusersCountByParams();
        }
        return res;
    }
}