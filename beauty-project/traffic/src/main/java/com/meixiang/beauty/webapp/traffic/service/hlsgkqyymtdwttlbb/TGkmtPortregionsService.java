package com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.TGkmtPortregionsDao;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtPortregionsDTO;
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
public class TGkmtPortregionsService {

    @Autowired
    private TGkmtPortregionsDao tGkmtPortregionsDao;

    public List<Map<String, Object>> getTGkmtPortregionsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TGkmtPortregionsDTO> tGkmtPortregionsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tGkmtPortregionsDTOs = tGkmtPortregionsDao.getTGkmtPortregionsByPageable(start, end);
        } else {
            tGkmtPortregionsDTOs = tGkmtPortregionsDao.getTGkmtPortregionsByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tGkmtPortregionsDTOs)) {
            for (TGkmtPortregionsDTO tGkmtPortregionsDTO : tGkmtPortregionsDTOs) {
                res.add(ClassUtil.toHashMap(tGkmtPortregionsDTO));
            }
        }
        return res;
    }

    public Integer getTGkmtPortregionsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tGkmtPortregionsDao.getTGkmtPortregionsCount();
        } else {
            res = tGkmtPortregionsDao.getTGkmtPortregionsCountByParams();
        }
        return res;
    }
}