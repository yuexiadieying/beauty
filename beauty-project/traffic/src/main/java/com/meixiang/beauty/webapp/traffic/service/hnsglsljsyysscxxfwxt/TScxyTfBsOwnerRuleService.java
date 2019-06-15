package com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerRuleDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerRuleDTO;
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
public class TScxyTfBsOwnerRuleService {

    @Autowired
    private TScxyTfBsOwnerRuleDao tScxyTfBsOwnerRuleDao;

    public List<Map<String, Object>> getTScxyTfBsOwnerRuleByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TScxyTfBsOwnerRuleDTO> tScxyTfBsOwnerRuleDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tScxyTfBsOwnerRuleDTOs = tScxyTfBsOwnerRuleDao.getTScxyTfBsOwnerRuleByPageable(start, end);
        } else {
            tScxyTfBsOwnerRuleDTOs = tScxyTfBsOwnerRuleDao.getTScxyTfBsOwnerRuleByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tScxyTfBsOwnerRuleDTOs)) {
            for (TScxyTfBsOwnerRuleDTO tScxyTfBsOwnerRuleDTO : tScxyTfBsOwnerRuleDTOs) {
                res.add(ClassUtil.toHashMap(tScxyTfBsOwnerRuleDTO));
            }
        }
        return res;
    }

    public Integer getTScxyTfBsOwnerRuleCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tScxyTfBsOwnerRuleDao.getTScxyTfBsOwnerRuleCount();
        } else {
            res = tScxyTfBsOwnerRuleDao.getTScxyTfBsOwnerRuleCountByParams();
        }
        return res;
    }
}