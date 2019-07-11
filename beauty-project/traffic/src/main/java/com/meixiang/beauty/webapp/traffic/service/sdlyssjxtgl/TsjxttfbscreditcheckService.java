package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbscreditcheckDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbscreditcheckDTO;
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
public class TsjxttfbscreditcheckService {

    @Autowired
    private TsjxttfbscreditcheckDao tsjxttfbscreditcheckDao;

    public List<Map<String, Object>> getTsjxttfbscreditcheckByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbscreditcheckDTO> tsjxttfbscreditcheckDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbscreditcheckDTOs = tsjxttfbscreditcheckDao.getTsjxttfbscreditcheckByPageable(start, end);
        } else {
            tsjxttfbscreditcheckDTOs = tsjxttfbscreditcheckDao.getTsjxttfbscreditcheckByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbscreditcheckDTOs)) {
            for (TsjxttfbscreditcheckDTO tsjxttfbscreditcheckDTO : tsjxttfbscreditcheckDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbscreditcheckDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbscreditcheckCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbscreditcheckDao.getTsjxttfbscreditcheckCount();
        } else {
            res = tsjxttfbscreditcheckDao.getTsjxttfbscreditcheckCountByParams(params[0]);
        }
        return res;
    }
}