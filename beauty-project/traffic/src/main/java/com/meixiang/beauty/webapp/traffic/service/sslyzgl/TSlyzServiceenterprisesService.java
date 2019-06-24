package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzServiceenterprisesDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzServiceenterprisesDTO;
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
public class TSlyzServiceenterprisesService {

    @Autowired
    private TSlyzServiceenterprisesDao tSlyzServiceenterprisesDao;

    public List<Map<String, Object>> getTSlyzServiceenterprisesByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzServiceenterprisesDTO> tSlyzServiceenterprisesDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzServiceenterprisesDTOs = tSlyzServiceenterprisesDao.getTSlyzServiceenterprisesByPageable(start, end);
        } else {
            tSlyzServiceenterprisesDTOs = tSlyzServiceenterprisesDao.getTSlyzServiceenterprisesByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tSlyzServiceenterprisesDTOs)) {
            for (TSlyzServiceenterprisesDTO tSlyzServiceenterprisesDTO : tSlyzServiceenterprisesDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzServiceenterprisesDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzServiceenterprisesCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzServiceenterprisesDao.getTSlyzServiceenterprisesCount();
        } else {
            res = tSlyzServiceenterprisesDao.getTSlyzServiceenterprisesCountByParams();
        }
        return res;
    }
}