package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShipkindsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShipkindsDTO;
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
public class TSlyzShipkindsService {

    @Autowired
    private TSlyzShipkindsDao tSlyzShipkindsDao;

    public List<Map<String, Object>> getTSlyzShipkindsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzShipkindsDTO> tSlyzShipkindsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzShipkindsDTOs = tSlyzShipkindsDao.getTSlyzShipkindsByPageable(start, end);
        } else {
            tSlyzShipkindsDTOs = tSlyzShipkindsDao.getTSlyzShipkindsByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzShipkindsDTOs)) {
            for (TSlyzShipkindsDTO tSlyzShipkindsDTO : tSlyzShipkindsDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzShipkindsDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzShipkindsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzShipkindsDao.getTSlyzShipkindsCount();
        } else {
            res = tSlyzShipkindsDao.getTSlyzShipkindsCountByParams();
        }
        return res;
    }
}