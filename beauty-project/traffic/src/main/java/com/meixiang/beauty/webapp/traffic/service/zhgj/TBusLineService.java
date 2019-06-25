package com.meixiang.beauty.webapp.traffic.service.zhgj;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.zhgj.TBusLineDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusLineDTO;
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
public class TBusLineService {

    @Autowired
    private TBusLineDao tBusLineDao;

    public List<Map<String, Object>> getTBusLineByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TBusLineDTO> tBusLineDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tBusLineDTOs = tBusLineDao.getTBusLineByPageable(start, end);
        } else {
            tBusLineDTOs = tBusLineDao.getTBusLineByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tBusLineDTOs)) {
            for (TBusLineDTO tBusLineDTO : tBusLineDTOs) {
                res.add(ClassUtil.toHashMap(tBusLineDTO));
            }
        }
        return res;
    }

    public Integer getTBusLineCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tBusLineDao.getTBusLineCount();
        } else {
            res = tBusLineDao.getTBusLineCountByParams(params[0]);
        }
        return res;
    }
}