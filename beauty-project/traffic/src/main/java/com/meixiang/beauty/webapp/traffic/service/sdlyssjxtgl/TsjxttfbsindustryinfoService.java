package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsindustryinfoDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsindustryinfoDTO;
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
public class TsjxttfbsindustryinfoService {

    @Autowired
    private TsjxttfbsindustryinfoDao tsjxttfbsindustryinfoDao;

    public List<Map<String, Object>> getTsjxttfbsindustryinfoByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsindustryinfoDTO> tsjxttfbsindustryinfoDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsindustryinfoDTOs = tsjxttfbsindustryinfoDao.getTsjxttfbsindustryinfoByPageable(start, end);
        } else {
            tsjxttfbsindustryinfoDTOs = tsjxttfbsindustryinfoDao.getTsjxttfbsindustryinfoByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsindustryinfoDTOs)) {
            for (TsjxttfbsindustryinfoDTO tsjxttfbsindustryinfoDTO : tsjxttfbsindustryinfoDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsindustryinfoDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsindustryinfoCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsindustryinfoDao.getTsjxttfbsindustryinfoCount();
        } else {
            res = tsjxttfbsindustryinfoDao.getTsjxttfbsindustryinfoCountByParams(params[0]);
        }
        return res;
    }
}