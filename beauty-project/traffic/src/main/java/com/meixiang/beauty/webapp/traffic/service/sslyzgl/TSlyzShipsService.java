package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShipsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShipsDTO;
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
public class TSlyzShipsService {

    @Autowired
    private TSlyzShipsDao tSlyzShipsDao;

    public List<Map<String, Object>> getTSlyzShipsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzShipsDTO> tSlyzShipsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzShipsDTOs = tSlyzShipsDao.getTSlyzShipsByPageable(start, end);
        } else {
            tSlyzShipsDTOs = tSlyzShipsDao.getTSlyzShipsByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzShipsDTOs)) {
            for (TSlyzShipsDTO tSlyzShipsDTO : tSlyzShipsDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzShipsDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzShipsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzShipsDao.getTSlyzShipsCount();
        } else {
            res = tSlyzShipsDao.getTSlyzShipsCountByParams();
        }
        return res;
    }
}