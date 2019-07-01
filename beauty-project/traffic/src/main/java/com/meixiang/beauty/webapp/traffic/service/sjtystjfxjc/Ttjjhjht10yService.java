package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjht10yDao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht10yDTO;
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
public class Ttjjhjht10yService {

    @Autowired
    private Ttjjhjht10yDao ttjjhjht10yDao;

    public List<Map<String, Object>> getTtjjhjht10yByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht10yDTO> ttjjhjht10yDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjht10yDTOs = ttjjhjht10yDao.getTtjjhjht10yByPageable(start, end);
        } else {
            ttjjhjht10yDTOs = ttjjhjht10yDao.getTtjjhjht10yByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjht10yDTOs)) {
            for (Ttjjhjht10yDTO ttjjhjht10yDTO : ttjjhjht10yDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht10yDTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjht10yCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjht10yDao.getTtjjhjht10yCount();
        } else {
            res = ttjjhjht10yDao.getTtjjhjht10yCountByParams(params[0]);
        }
        return res;
    }

    /**
     * 公路水路运输量月度统计基础情况
     **/
    public List<Map<String, Object>> getRoadAndWaterTransportNumInMonthInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht10yDTO> ttjjhjht10yDTOs = Lists.newArrayList();
        ttjjhjht10yDTOs = ttjjhjht10yDao.getRoadAndWaterTransportNumInMonthInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjht10yDTOs)) {
            for (Ttjjhjht10yDTO ttjjhjht10yDTO : ttjjhjht10yDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht10yDTO));
            }
        }
        return res;
    }
}