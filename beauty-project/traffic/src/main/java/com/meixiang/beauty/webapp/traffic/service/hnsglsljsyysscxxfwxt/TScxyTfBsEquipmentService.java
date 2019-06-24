package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsEquipmentDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsEquipmentDTO;
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
public class TScxyTfBsEquipmentService {

    @Autowired
    private TScxyTfBsEquipmentDao tScxyTfBsEquipmentDao;

    public List<Map<String, Object>> getTScxyTfBsEquipmentByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsEquipmentDTO> tScxyTfBsEquipmentDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsEquipmentDTOs = tScxyTfBsEquipmentDao.getTScxyTfBsEquipmentByPageable(start, end);
        } else {
            tScxyTfBsEquipmentDTOs = tScxyTfBsEquipmentDao.getTScxyTfBsEquipmentByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsEquipmentDTOs)) {
            for (TScxyTfBsEquipmentDTO tScxyTfBsEquipmentDTO : tScxyTfBsEquipmentDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsEquipmentDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsEquipmentCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsEquipmentDao.getTScxyTfBsEquipmentCount();
        } else {
            res = tScxyTfBsEquipmentDao.getTScxyTfBsEquipmentCountByParams(params[0]);
        }
        return res;
    }
}