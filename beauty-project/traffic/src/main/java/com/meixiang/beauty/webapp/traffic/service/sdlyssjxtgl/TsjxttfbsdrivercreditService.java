package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsdrivercreditDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsdrivercreditDTO;
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
public class TsjxttfbsdrivercreditService {

    @Autowired
    private TsjxttfbsdrivercreditDao tsjxttfbsdrivercreditDao;

    public List<Map<String, Object>> getTsjxttfbsdrivercreditByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsdrivercreditDTO> tsjxttfbsdrivercreditDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsdrivercreditDTOs = tsjxttfbsdrivercreditDao.getTsjxttfbsdrivercreditByPageable(start, end);
        } else {
            tsjxttfbsdrivercreditDTOs = tsjxttfbsdrivercreditDao.getTsjxttfbsdrivercreditByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsdrivercreditDTOs)) {
            for (TsjxttfbsdrivercreditDTO tsjxttfbsdrivercreditDTO : tsjxttfbsdrivercreditDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsdrivercreditDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsdrivercreditCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsdrivercreditDao.getTsjxttfbsdrivercreditCount();
        } else {
            res = tsjxttfbsdrivercreditDao.getTsjxttfbsdrivercreditCountByParams(params[0]);
        }
        return res;
    }
}