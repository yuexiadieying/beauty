package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbsvecgoodsDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvecgoodsDTO;
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
public class TsjxttfbsvecgoodsService {

    @Autowired
    private TsjxttfbsvecgoodsDao tsjxttfbsvecgoodsDao;

    public List<Map<String, Object>> getTsjxttfbsvecgoodsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbsvecgoodsDTO> tsjxttfbsvecgoodsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbsvecgoodsDTOs = tsjxttfbsvecgoodsDao.getTsjxttfbsvecgoodsByPageable(start, end);
        } else {
            tsjxttfbsvecgoodsDTOs = tsjxttfbsvecgoodsDao.getTsjxttfbsvecgoodsByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbsvecgoodsDTOs)) {
            for (TsjxttfbsvecgoodsDTO tsjxttfbsvecgoodsDTO : tsjxttfbsvecgoodsDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbsvecgoodsDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbsvecgoodsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbsvecgoodsDao.getTsjxttfbsvecgoodsCount();
        } else {
            res = tsjxttfbsvecgoodsDao.getTsjxttfbsvecgoodsCountByParams(params[0]);
        }
        return res;
    }
}