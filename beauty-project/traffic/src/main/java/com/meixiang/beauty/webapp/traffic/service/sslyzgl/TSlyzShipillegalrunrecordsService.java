package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShipillegalrunrecordsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShipillegalrunrecordsDTO;
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
public class TSlyzShipillegalrunrecordsService {

    @Autowired
    private TSlyzShipillegalrunrecordsDao tSlyzShipillegalrunrecordsDao;

    public List<Map<String, Object>> getTSlyzShipillegalrunrecordsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzShipillegalrunrecordsDTO> tSlyzShipillegalrunrecordsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzShipillegalrunrecordsDTOs = tSlyzShipillegalrunrecordsDao.getTSlyzShipillegalrunrecordsByPageable(start, end);
        } else {
            tSlyzShipillegalrunrecordsDTOs = tSlyzShipillegalrunrecordsDao.getTSlyzShipillegalrunrecordsByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzShipillegalrunrecordsDTOs)) {
            for (TSlyzShipillegalrunrecordsDTO tSlyzShipillegalrunrecordsDTO : tSlyzShipillegalrunrecordsDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzShipillegalrunrecordsDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzShipillegalrunrecordsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzShipillegalrunrecordsDao.getTSlyzShipillegalrunrecordsCount();
        } else {
            res = tSlyzShipillegalrunrecordsDao.getTSlyzShipillegalrunrecordsCountByParams();
        }
        return res;
    }
}