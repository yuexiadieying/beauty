package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfptcmpsnDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfptcmpsnDTO;
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
public class TsjxttfptcmpsnService {

    @Autowired
    private TsjxttfptcmpsnDao tsjxttfptcmpsnDao;

    public List<Map<String, Object>> getTsjxttfptcmpsnByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfptcmpsnDTO> tsjxttfptcmpsnDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfptcmpsnDTOs = tsjxttfptcmpsnDao.getTsjxttfptcmpsnByPageable(start, end);
        } else {
            tsjxttfptcmpsnDTOs = tsjxttfptcmpsnDao.getTsjxttfptcmpsnByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfptcmpsnDTOs)) {
            for (TsjxttfptcmpsnDTO tsjxttfptcmpsnDTO : tsjxttfptcmpsnDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfptcmpsnDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfptcmpsnCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfptcmpsnDao.getTsjxttfptcmpsnCount();
        } else {
            res = tsjxttfptcmpsnDao.getTsjxttfptcmpsnCountByParams(params[0]);
        }
        return res;
    }
}