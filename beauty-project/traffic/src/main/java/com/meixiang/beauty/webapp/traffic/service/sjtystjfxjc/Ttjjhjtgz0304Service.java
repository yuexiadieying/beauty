package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhjtgz0304Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtgz0304DTO;
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
public class Ttjjhjtgz0304Service {

    @Autowired
    private Ttjjhjtgz0304Dao ttjjhjtgz0304Dao;

    public List<Map<String, Object>> getTtjjhjtgz0304ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtgz0304DTO> ttjjhjtgz0304DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhjtgz0304DTOs = ttjjhjtgz0304Dao.getTtjjhjtgz0304ByPageable(start, end);
        } else {
            ttjjhjtgz0304DTOs = ttjjhjtgz0304Dao.getTtjjhjtgz0304ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhjtgz0304DTOs)) {
            for (Ttjjhjtgz0304DTO ttjjhjtgz0304DTO : ttjjhjtgz0304DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtgz0304DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhjtgz0304Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhjtgz0304Dao.getTtjjhjtgz0304Count();
        } else {
            res = ttjjhjtgz0304Dao.getTtjjhjtgz0304CountByParams(params[0]);
        }
        return res;
    }


    /**
     * l   国际航线进出港集装箱吞吐
     **/
    public List<Map<String, Object>> getInternationalLineInAndOutPortNumInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtgz0304DTO> ttjjhjtgz0304DTOs = Lists.newArrayList();
        ttjjhjtgz0304DTOs = ttjjhjtgz0304Dao.getInternationalLineInAndOutPortNumInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjtgz0304DTOs)) {
            for (Ttjjhjtgz0304DTO ttjjhjtgz0304DTO : ttjjhjtgz0304DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtgz0304DTO));
            }
        }
        return res;
    }

    /**
     * l   国内航线进出港集装箱吞吐
     **/
    public List<Map<String, Object>> getCountryLineInAndOutPortNumInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtgz0304DTO> ttjjhjtgz0304DTOs = Lists.newArrayList();
        ttjjhjtgz0304DTOs = ttjjhjtgz0304Dao.getCountryLineInAndOutPortNumInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjtgz0304DTOs)) {
            for (Ttjjhjtgz0304DTO ttjjhjtgz0304DTO : ttjjhjtgz0304DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtgz0304DTO));
            }
        }
        return res;
    }

    /**
     * l   内  支线进出港集装箱吞吐
     **/
    public List<Map<String, Object>> getCJLineInAndOutPortBoxNumInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtgz0304DTO> ttjjhjtgz0304DTOs = Lists.newArrayList();
        ttjjhjtgz0304DTOs = ttjjhjtgz0304Dao.getCJLineInAndOutPortBoxNumInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjtgz0304DTOs)) {
            for (Ttjjhjtgz0304DTO ttjjhjtgz0304DTO : ttjjhjtgz0304DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtgz0304DTO));
            }
        }
        return res;
    }

    /**
     * l   分货类分运输方式集疏运情况
     **/
    public List<Map<String, Object>> getGoodsTypeTransportInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhjtgz0304DTO> ttjjhjtgz0304DTOs = Lists.newArrayList();
        ttjjhjtgz0304DTOs = ttjjhjtgz0304Dao.getGoodsTypeTransportInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhjtgz0304DTOs)) {
            for (Ttjjhjtgz0304DTO ttjjhjtgz0304DTO : ttjjhjtgz0304DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhjtgz0304DTO));
            }
        }
        return res;
    }
}