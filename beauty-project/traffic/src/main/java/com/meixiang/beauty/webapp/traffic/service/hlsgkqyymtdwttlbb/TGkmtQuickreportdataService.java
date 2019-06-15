package com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtQuickreportdataDao;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtQuickreportdataDTO;
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
public class TGkmtQuickreportdataService {

    @Autowired
    private TGkmtQuickreportdataDao tGkmtQuickreportdataDao;

    public List<Map<String, Object>> getTGkmtQuickreportdataByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TGkmtQuickreportdataDTO> tGkmtQuickreportdataDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tGkmtQuickreportdataDTOs = tGkmtQuickreportdataDao.getTGkmtQuickreportdataByPageable(start, end);
        } else {
            tGkmtQuickreportdataDTOs = tGkmtQuickreportdataDao.getTGkmtQuickreportdataByParamsPageable(start, end, params[0],params[1],params[2],params[3]);
        }
        if (!CollectionUtils.isEmpty(tGkmtQuickreportdataDTOs)) {
            for (TGkmtQuickreportdataDTO tGkmtQuickreportdataDTO : tGkmtQuickreportdataDTOs) {
                res.add(ClassUtil.toHashMap(tGkmtQuickreportdataDTO));
            }
        }
        return res;
    }

    public Integer getTGkmtQuickreportdataCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tGkmtQuickreportdataDao.getTGkmtQuickreportdataCount();
        } else {
            res = tGkmtQuickreportdataDao.getTGkmtQuickreportdataCountByParams();
        }
        return res;
    }
}