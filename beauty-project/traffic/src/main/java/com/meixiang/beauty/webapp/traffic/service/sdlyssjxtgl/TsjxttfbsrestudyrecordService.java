package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsrestudyrecordDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsrestudyrecordDTO;
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
public class TsjxttfbsrestudyrecordService {

    @Autowired
    private TsjxttfbsrestudyrecordDao tsjxttfbsrestudyrecordDao;

    public List<Map<String, Object>> getTsjxttfbsrestudyrecordByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsrestudyrecordDTO> tsjxttfbsrestudyrecordDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsrestudyrecordDTOs = tsjxttfbsrestudyrecordDao.getTsjxttfbsrestudyrecordByPageable(start, end);
        } else {
            tsjxttfbsrestudyrecordDTOs = tsjxttfbsrestudyrecordDao.getTsjxttfbsrestudyrecordByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsrestudyrecordDTOs)) {
            for (TsjxttfbsrestudyrecordDTO tsjxttfbsrestudyrecordDTO : tsjxttfbsrestudyrecordDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsrestudyrecordDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsrestudyrecordCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsrestudyrecordDao.getTsjxttfbsrestudyrecordCount();
        } else {
            res = tsjxttfbsrestudyrecordDao.getTsjxttfbsrestudyrecordCountByParams(params[0]);
        }
        return res;
    }
}