package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzChangeshiprecordsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzChangeshiprecordsDTO;
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
public class TSlyzChangeshiprecordsService {

    @Autowired
    private TSlyzChangeshiprecordsDao tSlyzChangeshiprecordsDao;

    public List<Map<String, Object>> getTSlyzChangeshiprecordsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzChangeshiprecordsDTO> tSlyzChangeshiprecordsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzChangeshiprecordsDTOs = tSlyzChangeshiprecordsDao.getTSlyzChangeshiprecordsByPageable(start, end);
        } else {
            tSlyzChangeshiprecordsDTOs = tSlyzChangeshiprecordsDao.getTSlyzChangeshiprecordsByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tSlyzChangeshiprecordsDTOs)) {
            for (TSlyzChangeshiprecordsDTO tSlyzChangeshiprecordsDTO : tSlyzChangeshiprecordsDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzChangeshiprecordsDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzChangeshiprecordsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzChangeshiprecordsDao.getTSlyzChangeshiprecordsCount();
        } else {
            res = tSlyzChangeshiprecordsDao.getTSlyzChangeshiprecordsCountByParams();
        }
        return res;
    }
}