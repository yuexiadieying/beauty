package com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.TGkmtEnterpriseusersDao;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtEnterpriseusersDTO;
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
public class TGkmtEnterpriseusersService {

    @Autowired
    private TGkmtEnterpriseusersDao tGkmtEnterpriseusersDao;

    public List<Map<String, Object>> getTGkmtEnterpriseusersByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TGkmtEnterpriseusersDTO> tGkmtEnterpriseusersDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tGkmtEnterpriseusersDTOs = tGkmtEnterpriseusersDao.getTGkmtEnterpriseusersByPageable(start, end);
        } else {
            tGkmtEnterpriseusersDTOs = tGkmtEnterpriseusersDao.getTGkmtEnterpriseusersByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tGkmtEnterpriseusersDTOs)) {
            for (TGkmtEnterpriseusersDTO tGkmtEnterpriseusersDTO : tGkmtEnterpriseusersDTOs) {
                res.add(ClassUtil.toHashMap(tGkmtEnterpriseusersDTO));
            }
        }
        return res;
    }

    public Integer getTGkmtEnterpriseusersCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tGkmtEnterpriseusersDao.getTGkmtEnterpriseusersCount();
        } else {
            res = tGkmtEnterpriseusersDao.getTGkmtEnterpriseusersCountByParams();
        }
        return res;
    }
}