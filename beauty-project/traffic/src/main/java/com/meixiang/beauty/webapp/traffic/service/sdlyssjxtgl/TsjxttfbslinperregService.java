package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbslinperregDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbslinperregDTO;
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
public class TsjxttfbslinperregService {

    @Autowired
    private TsjxttfbslinperregDao tsjxttfbslinperregDao;

    public List<Map<String, Object>> getTsjxttfbslinperregByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbslinperregDTO> tsjxttfbslinperregDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbslinperregDTOs = tsjxttfbslinperregDao.getTsjxttfbslinperregByPageable(start, end);
        } else {
            tsjxttfbslinperregDTOs = tsjxttfbslinperregDao.getTsjxttfbslinperregByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbslinperregDTOs)) {
            for (TsjxttfbslinperregDTO tsjxttfbslinperregDTO : tsjxttfbslinperregDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbslinperregDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbslinperregCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbslinperregDao.getTsjxttfbslinperregCount();
        } else {
            res = tsjxttfbslinperregDao.getTsjxttfbslinperregCountByParams(params[0]);
        }
        return res;
    }
}