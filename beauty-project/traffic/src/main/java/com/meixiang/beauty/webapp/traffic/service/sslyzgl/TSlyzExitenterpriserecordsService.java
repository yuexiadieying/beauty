package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzExitenterpriserecordsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzExitenterpriserecordsDTO;
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
public class TSlyzExitenterpriserecordsService {

    @Autowired
    private TSlyzExitenterpriserecordsDao tSlyzExitenterpriserecordsDao;

    public List<Map<String, Object>> getTSlyzExitenterpriserecordsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzExitenterpriserecordsDTO> tSlyzExitenterpriserecordsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzExitenterpriserecordsDTOs = tSlyzExitenterpriserecordsDao.getTSlyzExitenterpriserecordsByPageable(start, end);
        } else {
            tSlyzExitenterpriserecordsDTOs = tSlyzExitenterpriserecordsDao.getTSlyzExitenterpriserecordsByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzExitenterpriserecordsDTOs)) {
            for (TSlyzExitenterpriserecordsDTO tSlyzExitenterpriserecordsDTO : tSlyzExitenterpriserecordsDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzExitenterpriserecordsDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzExitenterpriserecordsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzExitenterpriserecordsDao.getTSlyzExitenterpriserecordsCount();
        } else {
            res = tSlyzExitenterpriserecordsDao.getTSlyzExitenterpriserecordsCountByParams();
        }
        return res;
    }
}