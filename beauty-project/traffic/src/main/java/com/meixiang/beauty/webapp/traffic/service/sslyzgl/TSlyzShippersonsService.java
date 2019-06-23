package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShippersonsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShippersonsDTO;
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
public class TSlyzShippersonsService {

    @Autowired
    private TSlyzShippersonsDao tSlyzShippersonsDao;

    public List<Map<String, Object>> getTSlyzShippersonsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzShippersonsDTO> tSlyzShippersonsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzShippersonsDTOs = tSlyzShippersonsDao.getTSlyzShippersonsByPageable(start, end);
        } else {
            tSlyzShippersonsDTOs = tSlyzShippersonsDao.getTSlyzShippersonsByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tSlyzShippersonsDTOs)) {
            for (TSlyzShippersonsDTO tSlyzShippersonsDTO : tSlyzShippersonsDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzShippersonsDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzShippersonsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzShippersonsDao.getTSlyzShippersonsCount();
        } else {
            res = tSlyzShippersonsDao.getTSlyzShippersonsCountByParams();
        }
        return res;
    }
}