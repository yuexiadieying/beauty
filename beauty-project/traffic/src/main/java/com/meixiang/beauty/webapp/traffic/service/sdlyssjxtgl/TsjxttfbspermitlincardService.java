package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbspermitlincardDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbspermitlincardDTO;
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
public class TsjxttfbspermitlincardService {

    @Autowired
    private TsjxttfbspermitlincardDao tsjxttfbspermitlincardDao;

    public List<Map<String, Object>> getTsjxttfbspermitlincardByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbspermitlincardDTO> tsjxttfbspermitlincardDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbspermitlincardDTOs = tsjxttfbspermitlincardDao.getTsjxttfbspermitlincardByPageable(start, end);
        } else {
            tsjxttfbspermitlincardDTOs = tsjxttfbspermitlincardDao.getTsjxttfbspermitlincardByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbspermitlincardDTOs)) {
            for (TsjxttfbspermitlincardDTO tsjxttfbspermitlincardDTO : tsjxttfbspermitlincardDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbspermitlincardDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbspermitlincardCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbspermitlincardDao.getTsjxttfbspermitlincardCount();
        } else {
            res = tsjxttfbspermitlincardDao.getTsjxttfbspermitlincardCountByParams(params[0]);
        }
        return res;
    }
}