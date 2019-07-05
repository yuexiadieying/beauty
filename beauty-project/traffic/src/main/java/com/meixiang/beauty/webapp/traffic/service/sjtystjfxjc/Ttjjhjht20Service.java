package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjht20Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht20DTO;
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
public class Ttjjhjht20Service {

    @Autowired
    private Ttjjhjht20Dao ttjjhjht20Dao;

    public List<Map<String, Object>> getTtjjhjht20ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht20DTO> ttjjhjht20DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjht20DTOs = ttjjhjht20Dao.getTtjjhjht20ByPageable(start, end);
        } else {
            ttjjhjht20DTOs = ttjjhjht20Dao.getTtjjhjht20ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjht20DTOs)) {
            for (Ttjjhjht20DTO ttjjhjht20DTO : ttjjhjht20DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht20DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjht20Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjht20Dao.getTtjjhjht20Count();
        } else {
            res = ttjjhjht20Dao.getTtjjhjht20CountByParams(params[0]);
        }
        return res;
    }


    /**
     * l   重点联系公路运输企业经营财务状况调查数据
     **/
    public List<Map<String, Object>> getRoadEnterpriseAccountInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht20DTO> ttjjhjht20DTOs = Lists.newArrayList();
        ttjjhjht20DTOs = ttjjhjht20Dao.getRoadEnterpriseAccountInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjht20DTOs)) {
            for (Ttjjhjht20DTO ttjjhjht20DTO : ttjjhjht20DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht20DTO));
            }
        }
        return res;
    }

    /**
     * 公路运输法人企业情况
     **/
    public List<Map<String, Object>> getRoadTransportJuridicalPersonEnterpriseInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht20DTO> ttjjhjht20DTOs = Lists.newArrayList();
        ttjjhjht20DTOs = ttjjhjht20Dao.getRoadTransportJuridicalPersonEnterpriseInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjht20DTOs)) {
            for (Ttjjhjht20DTO ttjjhjht20DTO : ttjjhjht20DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht20DTO));
            }
        }
        return res;
    }

    /**
     * 营业性汽车运输效率和燃料消耗情况
     **/
    public List<Map<String, Object>> getBusinessCarTransportAndFuelInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht20DTO> ttjjhjht20DTOs = Lists.newArrayList();
        ttjjhjht20DTOs = ttjjhjht20Dao.getBusinessCarTransportAndFuelInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjht20DTOs)) {
            for (Ttjjhjht20DTO ttjjhjht20DTO : ttjjhjht20DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht20DTO));
            }
        }
        return res;
    }

    /**
     * 公路运输法人企业财务状况
     **/
    public List<Map<String, Object>> getRoadTransportEnterpriseAccountInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjht20DTO> ttjjhjht20DTOs = Lists.newArrayList();
        ttjjhjht20DTOs = ttjjhjht20Dao.getRoadTransportEnterpriseAccountInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjht20DTOs)) {
            for (Ttjjhjht20DTO ttjjhjht20DTO : ttjjhjht20DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjht20DTO));
            }
        }
        return res;
    }


}