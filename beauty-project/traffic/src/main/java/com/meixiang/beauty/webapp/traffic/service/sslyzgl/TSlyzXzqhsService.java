package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzXzqhsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzXzqhsDTO;
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
public class TSlyzXzqhsService {

    @Autowired
    private TSlyzXzqhsDao tSlyzXzqhsDao;

    public List<Map<String, Object>> getTSlyzXzqhsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzXzqhsDTO> tSlyzXzqhsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzXzqhsDTOs = tSlyzXzqhsDao.getTSlyzXzqhsByPageable(start, end);
        } else {
            tSlyzXzqhsDTOs = tSlyzXzqhsDao.getTSlyzXzqhsByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzXzqhsDTOs)) {
            for (TSlyzXzqhsDTO tSlyzXzqhsDTO : tSlyzXzqhsDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzXzqhsDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzXzqhsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzXzqhsDao.getTSlyzXzqhsCount();
        } else {
            res = tSlyzXzqhsDao.getTSlyzXzqhsCountByParams();
        }
        return res;
    }
}