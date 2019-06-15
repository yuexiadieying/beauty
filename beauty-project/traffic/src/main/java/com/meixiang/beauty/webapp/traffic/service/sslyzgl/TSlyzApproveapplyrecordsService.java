package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzApproveapplyrecordsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzApproveapplyrecordsDTO;
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
public class TSlyzApproveapplyrecordsService {

    @Autowired
    private TSlyzApproveapplyrecordsDao tSlyzApproveapplyrecordsDao;

    public List<Map<String, Object>> getTSlyzApproveapplyrecordsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzApproveapplyrecordsDTO> tSlyzApproveapplyrecordsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzApproveapplyrecordsDTOs = tSlyzApproveapplyrecordsDao.getTSlyzApproveapplyrecordsByPageable(start, end);
        } else {
            tSlyzApproveapplyrecordsDTOs = tSlyzApproveapplyrecordsDao.getTSlyzApproveapplyrecordsByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzApproveapplyrecordsDTOs)) {
            for (TSlyzApproveapplyrecordsDTO tSlyzApproveapplyrecordsDTO : tSlyzApproveapplyrecordsDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzApproveapplyrecordsDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzApproveapplyrecordsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzApproveapplyrecordsDao.getTSlyzApproveapplyrecordsCount();
        } else {
            res = tSlyzApproveapplyrecordsDao.getTSlyzApproveapplyrecordsCountByParams();
        }
        return res;
    }
}