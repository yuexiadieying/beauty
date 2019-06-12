package com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.TGkmtBerthsDao;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtBerthsDTO;
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
public class TGkmtBerthsService {

    @Autowired
    private TGkmtBerthsDao tGkmtBerthsDao;

    public List<Map<String, Object>> getTGkmtBerthsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TGkmtBerthsDTO> tGkmtBerthsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tGkmtBerthsDTOs = tGkmtBerthsDao.getTGkmtBerthsByPageable(start, end);
        } else {
            tGkmtBerthsDTOs = tGkmtBerthsDao.getTGkmtBerthsByParamsPageable(start, end, params[0], params[1], params[2], params[3]);
        }
        if (!CollectionUtils.isEmpty(tGkmtBerthsDTOs)) {
            for (TGkmtBerthsDTO tGkmtBerthsDTO : tGkmtBerthsDTOs) {
                res.add(ClassUtil.toHashMap(tGkmtBerthsDTO));
            }
        }
        return res;
    }

    public Integer getTGkmtBerthsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tGkmtBerthsDao.getTGkmtBerthsCount();
        } else {
            res = tGkmtBerthsDao.getTGkmtBerthsCountByParams();
        }
        return res;
    }
}