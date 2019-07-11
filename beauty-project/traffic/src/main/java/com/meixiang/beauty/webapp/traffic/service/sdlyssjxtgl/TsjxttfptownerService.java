package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfptownerDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfptownerDTO;
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
public class TsjxttfptownerService {

    @Autowired
    private TsjxttfptownerDao tsjxttfptownerDao;

    public List<Map<String, Object>> getTsjxttfptownerByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfptownerDTO> tsjxttfptownerDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfptownerDTOs = tsjxttfptownerDao.getTsjxttfptownerByPageable(start, end);
        } else {
            tsjxttfptownerDTOs = tsjxttfptownerDao.getTsjxttfptownerByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfptownerDTOs)) {
            for (TsjxttfptownerDTO tsjxttfptownerDTO : tsjxttfptownerDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfptownerDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfptownerCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfptownerDao.getTsjxttfptownerCount();
        } else {
            res = tsjxttfptownerDao.getTsjxttfptownerCountByParams(params[0]);
        }
        return res;
    }
}