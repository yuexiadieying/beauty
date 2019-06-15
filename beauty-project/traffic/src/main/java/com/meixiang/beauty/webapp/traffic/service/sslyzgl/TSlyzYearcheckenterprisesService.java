package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzYearcheckenterprisesDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzYearcheckenterprisesDTO;
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
public class TSlyzYearcheckenterprisesService {

    @Autowired
    private TSlyzYearcheckenterprisesDao tSlyzYearcheckenterprisesDao;

    public List<Map<String, Object>> getTSlyzYearcheckenterprisesByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzYearcheckenterprisesDTO> tSlyzYearcheckenterprisesDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzYearcheckenterprisesDTOs = tSlyzYearcheckenterprisesDao.getTSlyzYearcheckenterprisesByPageable(start, end);
        } else {
            tSlyzYearcheckenterprisesDTOs = tSlyzYearcheckenterprisesDao.getTSlyzYearcheckenterprisesByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzYearcheckenterprisesDTOs)) {
            for (TSlyzYearcheckenterprisesDTO tSlyzYearcheckenterprisesDTO : tSlyzYearcheckenterprisesDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzYearcheckenterprisesDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzYearcheckenterprisesCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzYearcheckenterprisesDao.getTSlyzYearcheckenterprisesCount();
        } else {
            res = tSlyzYearcheckenterprisesDao.getTSlyzYearcheckenterprisesCountByParams();
        }
        return res;
    }
}