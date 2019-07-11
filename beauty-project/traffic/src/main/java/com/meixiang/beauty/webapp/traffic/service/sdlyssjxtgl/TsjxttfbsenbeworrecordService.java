package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsenbeworrecordDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsenbeworrecordDTO;
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
public class TsjxttfbsenbeworrecordService {

    @Autowired
    private TsjxttfbsenbeworrecordDao tsjxttfbsenbeworrecordDao;

    public List<Map<String, Object>> getTsjxttfbsenbeworrecordByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsenbeworrecordDTO> tsjxttfbsenbeworrecordDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsenbeworrecordDTOs = tsjxttfbsenbeworrecordDao.getTsjxttfbsenbeworrecordByPageable(start, end);
        } else {
            tsjxttfbsenbeworrecordDTOs = tsjxttfbsenbeworrecordDao.getTsjxttfbsenbeworrecordByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsenbeworrecordDTOs)) {
            for (TsjxttfbsenbeworrecordDTO tsjxttfbsenbeworrecordDTO : tsjxttfbsenbeworrecordDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsenbeworrecordDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsenbeworrecordCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsenbeworrecordDao.getTsjxttfbsenbeworrecordCount();
        } else {
            res = tsjxttfbsenbeworrecordDao.getTsjxttfbsenbeworrecordCountByParams(params[0]);
        }
        return res;
    }
}