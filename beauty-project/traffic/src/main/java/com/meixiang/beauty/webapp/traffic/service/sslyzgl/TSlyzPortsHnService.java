package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzPortsHnDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzPortsHnDTO;
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
public class TSlyzPortsHnService {

    @Autowired
    private TSlyzPortsHnDao tSlyzPortsHnDao;

    public List<Map<String, Object>> getTSlyzPortsHnByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzPortsHnDTO> tSlyzPortsHnDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzPortsHnDTOs = tSlyzPortsHnDao.getTSlyzPortsHnByPageable(start, end);
        } else {
            tSlyzPortsHnDTOs = tSlyzPortsHnDao.getTSlyzPortsHnByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzPortsHnDTOs)) {
            for (TSlyzPortsHnDTO tSlyzPortsHnDTO : tSlyzPortsHnDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzPortsHnDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzPortsHnCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzPortsHnDao.getTSlyzPortsHnCount();
        } else {
            res = tSlyzPortsHnDao.getTSlyzPortsHnCountByParams();
        }
        return res;
    }
}