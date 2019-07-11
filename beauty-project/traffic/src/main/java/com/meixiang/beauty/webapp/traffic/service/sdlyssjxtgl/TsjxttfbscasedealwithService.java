package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbscasedealwithDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbscasedealwithDTO;
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
public class TsjxttfbscasedealwithService {

    @Autowired
    private TsjxttfbscasedealwithDao tsjxttfbscasedealwithDao;

    public List<Map<String, Object>> getTsjxttfbscasedealwithByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbscasedealwithDTO> tsjxttfbscasedealwithDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbscasedealwithDTOs = tsjxttfbscasedealwithDao.getTsjxttfbscasedealwithByPageable(start, end);
        } else {
            tsjxttfbscasedealwithDTOs = tsjxttfbscasedealwithDao.getTsjxttfbscasedealwithByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbscasedealwithDTOs)) {
            for (TsjxttfbscasedealwithDTO tsjxttfbscasedealwithDTO : tsjxttfbscasedealwithDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbscasedealwithDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbscasedealwithCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbscasedealwithDao.getTsjxttfbscasedealwithCount();
        } else {
            res = tsjxttfbscasedealwithDao.getTsjxttfbscasedealwithCountByParams(params[0]);
        }
        return res;
    }
}