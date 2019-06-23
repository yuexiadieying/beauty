package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzYearcheckshipsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzYearcheckshipsDTO;
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
public class TSlyzYearcheckshipsService {

    @Autowired
    private TSlyzYearcheckshipsDao tSlyzYearcheckshipsDao;

    public List<Map<String, Object>> getTSlyzYearcheckshipsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzYearcheckshipsDTO> tSlyzYearcheckshipsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzYearcheckshipsDTOs = tSlyzYearcheckshipsDao.getTSlyzYearcheckshipsByPageable(start, end);
        } else {
            tSlyzYearcheckshipsDTOs = tSlyzYearcheckshipsDao.getTSlyzYearcheckshipsByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tSlyzYearcheckshipsDTOs)) {
            for (TSlyzYearcheckshipsDTO tSlyzYearcheckshipsDTO : tSlyzYearcheckshipsDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzYearcheckshipsDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzYearcheckshipsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzYearcheckshipsDao.getTSlyzYearcheckshipsCount();
        } else {
            res = tSlyzYearcheckshipsDao.getTSlyzYearcheckshipsCountByParams();
        }
        return res;
    }
}