package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzTfBsRestudyrecordScDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzTfBsRestudyrecordScDTO;
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
public class TSlyzTfBsRestudyrecordScService {

    @Autowired
    private TSlyzTfBsRestudyrecordScDao tSlyzTfBsRestudyrecordScDao;

    public List<Map<String, Object>> getTSlyzTfBsRestudyrecordScByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzTfBsRestudyrecordScDTO> tSlyzTfBsRestudyrecordScDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzTfBsRestudyrecordScDTOs = tSlyzTfBsRestudyrecordScDao.getTSlyzTfBsRestudyrecordScByPageable(start, end);
        } else {
            tSlyzTfBsRestudyrecordScDTOs = tSlyzTfBsRestudyrecordScDao.getTSlyzTfBsRestudyrecordScByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzTfBsRestudyrecordScDTOs)) {
            for (TSlyzTfBsRestudyrecordScDTO tSlyzTfBsRestudyrecordScDTO : tSlyzTfBsRestudyrecordScDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzTfBsRestudyrecordScDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzTfBsRestudyrecordScCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzTfBsRestudyrecordScDao.getTSlyzTfBsRestudyrecordScCount();
        } else {
            res = tSlyzTfBsRestudyrecordScDao.getTSlyzTfBsRestudyrecordScCountByParams();
        }
        return res;
    }
}