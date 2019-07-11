package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsappstationDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsappstationDTO;
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
public class TsjxttfbsappstationService {

    @Autowired
    private TsjxttfbsappstationDao tsjxttfbsappstationDao;

    public List<Map<String, Object>> getTsjxttfbsappstationByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsappstationDTO> tsjxttfbsappstationDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsappstationDTOs = tsjxttfbsappstationDao.getTsjxttfbsappstationByPageable(start, end);
        } else {
            tsjxttfbsappstationDTOs = tsjxttfbsappstationDao.getTsjxttfbsappstationByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsappstationDTOs)) {
            for (TsjxttfbsappstationDTO tsjxttfbsappstationDTO : tsjxttfbsappstationDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsappstationDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsappstationCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsappstationDao.getTsjxttfbsappstationCount();
        } else {
            res = tsjxttfbsappstationDao.getTsjxttfbsappstationCountByParams(params[0]);
        }
        return res;
    }
}