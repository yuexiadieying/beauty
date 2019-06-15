package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerRfrmCntDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerRfrmCntDTO;
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
public class TScxyTfBsOwnerRfrmCntService {

    @Autowired
    private TScxyTfBsOwnerRfrmCntDao tScxyTfBsOwnerRfrmCntDao;

    public List<Map<String, Object>> getTScxyTfBsOwnerRfrmCntByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsOwnerRfrmCntDTO> tScxyTfBsOwnerRfrmCntDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsOwnerRfrmCntDTOs = tScxyTfBsOwnerRfrmCntDao.getTScxyTfBsOwnerRfrmCntByPageable(start, end);
        } else {
            tScxyTfBsOwnerRfrmCntDTOs = tScxyTfBsOwnerRfrmCntDao.getTScxyTfBsOwnerRfrmCntByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsOwnerRfrmCntDTOs)) {
            for (TScxyTfBsOwnerRfrmCntDTO tScxyTfBsOwnerRfrmCntDTO : tScxyTfBsOwnerRfrmCntDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsOwnerRfrmCntDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsOwnerRfrmCntCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsOwnerRfrmCntDao.getTScxyTfBsOwnerRfrmCntCount();
        } else {
            res = tScxyTfBsOwnerRfrmCntDao.getTScxyTfBsOwnerRfrmCntCountByParams();
        }
        return res;
    }
}