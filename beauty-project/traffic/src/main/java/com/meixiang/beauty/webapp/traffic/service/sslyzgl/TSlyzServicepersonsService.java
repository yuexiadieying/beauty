package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzServicepersonsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzServicepersonsDTO;
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
public class TSlyzServicepersonsService {

    @Autowired
    private TSlyzServicepersonsDao tSlyzServicepersonsDao;

    public List<Map<String, Object>> getTSlyzServicepersonsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzServicepersonsDTO> tSlyzServicepersonsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzServicepersonsDTOs = tSlyzServicepersonsDao.getTSlyzServicepersonsByPageable(start, end);
        } else {
            tSlyzServicepersonsDTOs = tSlyzServicepersonsDao.getTSlyzServicepersonsByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzServicepersonsDTOs)) {
            for (TSlyzServicepersonsDTO tSlyzServicepersonsDTO : tSlyzServicepersonsDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzServicepersonsDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzServicepersonsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzServicepersonsDao.getTSlyzServicepersonsCount();
        } else {
            res = tSlyzServicepersonsDao.getTSlyzServicepersonsCountByParams();
        }
        return res;
    }
}