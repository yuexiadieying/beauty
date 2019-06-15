package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfPtPersonDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfPtPersonDTO;
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
public class TScxyTfPtPersonService {

    @Autowired
    private TScxyTfPtPersonDao tScxyTfPtPersonDao;

    public List<Map<String, Object>> getTScxyTfPtPersonByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfPtPersonDTO> tScxyTfPtPersonDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfPtPersonDTOs = tScxyTfPtPersonDao.getTScxyTfPtPersonByPageable(start, end);
        } else {
            tScxyTfPtPersonDTOs = tScxyTfPtPersonDao.getTScxyTfPtPersonByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfPtPersonDTOs)) {
            for (TScxyTfPtPersonDTO tScxyTfPtPersonDTO : tScxyTfPtPersonDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfPtPersonDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfPtPersonCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfPtPersonDao.getTScxyTfPtPersonCount();
        } else {
            res = tScxyTfPtPersonDao.getTScxyTfPtPersonCountByParams();
        }
        return res;
    }
}