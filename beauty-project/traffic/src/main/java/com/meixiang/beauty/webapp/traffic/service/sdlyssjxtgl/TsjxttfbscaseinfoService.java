package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbscaseinfoDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbscaseinfoDTO;
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
public class TsjxttfbscaseinfoService {

    @Autowired
    private TsjxttfbscaseinfoDao tsjxttfbscaseinfoDao;

    public List<Map<String, Object>> getTsjxttfbscaseinfoByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbscaseinfoDTO> tsjxttfbscaseinfoDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbscaseinfoDTOs = tsjxttfbscaseinfoDao.getTsjxttfbscaseinfoByPageable(start, end);
        } else {
            tsjxttfbscaseinfoDTOs = tsjxttfbscaseinfoDao.getTsjxttfbscaseinfoByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbscaseinfoDTOs)) {
            for (TsjxttfbscaseinfoDTO tsjxttfbscaseinfoDTO : tsjxttfbscaseinfoDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbscaseinfoDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbscaseinfoCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbscaseinfoDao.getTsjxttfbscaseinfoCount();
        } else {
            res = tsjxttfbscaseinfoDao.getTsjxttfbscaseinfoCountByParams(params[0]);
        }
        return res;
    }
}