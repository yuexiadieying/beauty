package com.meixiang.beauty.webapp.traffic.service;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.TGkmtPortsDao;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtPortsDTO;
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
public class TGkmtPortsService {

    @Autowired
    private TGkmtPortsDao tGkmtPortsDao;

    public List<Map<String, Object>> getTGkmtPortsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TGkmtPortsDTO> tGkmtPortsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tGkmtPortsDTOs = tGkmtPortsDao.getTGkmtPortsByPageable(start, end);
        } else {
            tGkmtPortsDTOs = tGkmtPortsDao.getTGkmtPortsByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tGkmtPortsDTOs)) {
            for (TGkmtPortsDTO tGkmtPortsDTO : tGkmtPortsDTOs) {
                res.add(ClassUtil.toHashMap(tGkmtPortsDTO));
            }
        }
        return res;
    }

    public Integer getTGkmtPortsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tGkmtPortsDao.getTGkmtPortsCount();
        } else {
            res = tGkmtPortsDao.getTGkmtPortsCountByParams();
        }
        return res;
    }
}