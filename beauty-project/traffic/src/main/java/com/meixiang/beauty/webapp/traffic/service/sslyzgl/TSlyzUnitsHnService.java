package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzUnitsHnDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzUnitsHnDTO;
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
public class TSlyzUnitsHnService {

    @Autowired
    private TSlyzUnitsHnDao tSlyzUnitsHnDao;

    public List<Map<String, Object>> getTSlyzUnitsHnByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzUnitsHnDTO> tSlyzUnitsHnDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzUnitsHnDTOs = tSlyzUnitsHnDao.getTSlyzUnitsHnByPageable(start, end);
        } else {
            tSlyzUnitsHnDTOs = tSlyzUnitsHnDao.getTSlyzUnitsHnByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzUnitsHnDTOs)) {
            for (TSlyzUnitsHnDTO tSlyzUnitsHnDTO : tSlyzUnitsHnDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzUnitsHnDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzUnitsHnCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzUnitsHnDao.getTSlyzUnitsHnCount();
        } else {
            res = tSlyzUnitsHnDao.getTSlyzUnitsHnCountByParams();
        }
        return res;
    }
}