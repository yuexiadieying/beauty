package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsvecgoodstecgrdDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvecgoodstecgrdDTO;
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
public class TsjxttfbsvecgoodstecgrdService {

    @Autowired
    private TsjxttfbsvecgoodstecgrdDao tsjxttfbsvecgoodstecgrdDao;

    public List<Map<String, Object>> getTsjxttfbsvecgoodstecgrdByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsvecgoodstecgrdDTO> tsjxttfbsvecgoodstecgrdDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsvecgoodstecgrdDTOs = tsjxttfbsvecgoodstecgrdDao.getTsjxttfbsvecgoodstecgrdByPageable(start, end);
        } else {
            tsjxttfbsvecgoodstecgrdDTOs = tsjxttfbsvecgoodstecgrdDao.getTsjxttfbsvecgoodstecgrdByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsvecgoodstecgrdDTOs)) {
            for (TsjxttfbsvecgoodstecgrdDTO tsjxttfbsvecgoodstecgrdDTO : tsjxttfbsvecgoodstecgrdDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsvecgoodstecgrdDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsvecgoodstecgrdCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsvecgoodstecgrdDao.getTsjxttfbsvecgoodstecgrdCount();
        } else {
            res = tsjxttfbsvecgoodstecgrdDao.getTsjxttfbsvecgoodstecgrdCountByParams(params[0]);
        }
        return res;
    }
}