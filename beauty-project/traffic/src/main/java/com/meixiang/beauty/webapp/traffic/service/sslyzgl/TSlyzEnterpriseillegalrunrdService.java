package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzEnterpriseillegalrunrdDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzEnterpriseillegalrunrdDTO;
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
public class TSlyzEnterpriseillegalrunrdService {

    @Autowired
    private TSlyzEnterpriseillegalrunrdDao tSlyzEnterpriseillegalrunrdDao;

    public List<Map<String, Object>> getTSlyzEnterpriseillegalrunrdByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzEnterpriseillegalrunrdDTO> tSlyzEnterpriseillegalrunrdDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzEnterpriseillegalrunrdDTOs = tSlyzEnterpriseillegalrunrdDao.getTSlyzEnterpriseillegalrunrdByPageable(start, end);
        } else {
            tSlyzEnterpriseillegalrunrdDTOs = tSlyzEnterpriseillegalrunrdDao.getTSlyzEnterpriseillegalrunrdByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzEnterpriseillegalrunrdDTOs)) {
            for (TSlyzEnterpriseillegalrunrdDTO tSlyzEnterpriseillegalrunrdDTO : tSlyzEnterpriseillegalrunrdDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzEnterpriseillegalrunrdDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzEnterpriseillegalrunrdCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzEnterpriseillegalrunrdDao.getTSlyzEnterpriseillegalrunrdCount();
        } else {
            res = tSlyzEnterpriseillegalrunrdDao.getTSlyzEnterpriseillegalrunrdCountByParams();
        }
        return res;
    }
}