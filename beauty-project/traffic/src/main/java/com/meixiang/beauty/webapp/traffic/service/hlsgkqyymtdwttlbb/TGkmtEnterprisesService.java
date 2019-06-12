package com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.TGkmtEnterprisesDao;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtEnterprisesDTO;
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
public class TGkmtEnterprisesService {

    @Autowired
    private TGkmtEnterprisesDao tGkmtEnterprisesDao;

    public List<Map<String, Object>> getTGkmtEnterprisesByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TGkmtEnterprisesDTO> tGkmtEnterprisesDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tGkmtEnterprisesDTOs = tGkmtEnterprisesDao.getTGkmtEnterprisesByPageable(start, end);
        } else {
            tGkmtEnterprisesDTOs = tGkmtEnterprisesDao.getTGkmtEnterprisesByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tGkmtEnterprisesDTOs)) {
            for (TGkmtEnterprisesDTO tGkmtEnterprisesDTO : tGkmtEnterprisesDTOs) {
                res.add(ClassUtil.toHashMap(tGkmtEnterprisesDTO));
            }
        }
        return res;
    }

    public Integer getTGkmtEnterprisesCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tGkmtEnterprisesDao.getTGkmtEnterprisesCount();
        } else {
            res = tGkmtEnterprisesDao.getTGkmtEnterprisesCountByParams();
        }
        return res;
    }
}