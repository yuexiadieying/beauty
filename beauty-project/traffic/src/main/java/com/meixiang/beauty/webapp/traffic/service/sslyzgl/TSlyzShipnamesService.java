package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShipnamesDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShipnamesDTO;
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
public class TSlyzShipnamesService {

    @Autowired
    private TSlyzShipnamesDao tSlyzShipnamesDao;

    public List<Map<String, Object>> getTSlyzShipnamesByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzShipnamesDTO> tSlyzShipnamesDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzShipnamesDTOs = tSlyzShipnamesDao.getTSlyzShipnamesByPageable(start, end);
        } else {
            tSlyzShipnamesDTOs = tSlyzShipnamesDao.getTSlyzShipnamesByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzShipnamesDTOs)) {
            for (TSlyzShipnamesDTO tSlyzShipnamesDTO : tSlyzShipnamesDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzShipnamesDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzShipnamesCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzShipnamesDao.getTSlyzShipnamesCount();
        } else {
            res = tSlyzShipnamesDao.getTSlyzShipnamesCountByParams();
        }
        return res;
    }
}