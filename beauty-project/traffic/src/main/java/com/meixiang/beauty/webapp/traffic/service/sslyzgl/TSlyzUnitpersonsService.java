package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzUnitpersonsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzUnitpersonsDTO;
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
public class TSlyzUnitpersonsService {

    @Autowired
    private TSlyzUnitpersonsDao tSlyzUnitpersonsDao;

    public List<Map<String, Object>> getTSlyzUnitpersonsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzUnitpersonsDTO> tSlyzUnitpersonsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzUnitpersonsDTOs = tSlyzUnitpersonsDao.getTSlyzUnitpersonsByPageable(start, end);
        } else {
            tSlyzUnitpersonsDTOs = tSlyzUnitpersonsDao.getTSlyzUnitpersonsByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzUnitpersonsDTOs)) {
            for (TSlyzUnitpersonsDTO tSlyzUnitpersonsDTO : tSlyzUnitpersonsDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzUnitpersonsDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzUnitpersonsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzUnitpersonsDao.getTSlyzUnitpersonsCount();
        } else {
            res = tSlyzUnitpersonsDao.getTSlyzUnitpersonsCountByParams();
        }
        return res;
    }
}