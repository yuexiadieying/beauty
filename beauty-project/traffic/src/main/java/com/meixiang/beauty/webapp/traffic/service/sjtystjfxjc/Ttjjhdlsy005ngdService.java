package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhdlsy005ngdDao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.DlkhzczjqkDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhdlsy005ngdDTO;
import com.meixiang.beauty.webapp.traffic.utils.ClassUtil;
import com.meixiang.beauty.webapp.traffic.utils.DateUtil;
import com.meixiang.beauty.webapp.traffic.utils.NumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.BinaryClient;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by WY on 2019/6/10.
 */
@Service
public class Ttjjhdlsy005ngdService {

    @Autowired
    private Ttjjhdlsy005ngdDao ttjjhdlsy005ngdDao;

    public List<Map<String, Object>> getTtjjhdlsy005ngdByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhdlsy005ngdDTO> ttjjhdlsy005ngdDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhdlsy005ngdDTOs = ttjjhdlsy005ngdDao.getTtjjhdlsy005ngdByPageable(start, end);
        } else {
            ttjjhdlsy005ngdDTOs = ttjjhdlsy005ngdDao.getTtjjhdlsy005ngdByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhdlsy005ngdDTOs)) {
            for (Ttjjhdlsy005ngdDTO ttjjhdlsy005ngdDTO : ttjjhdlsy005ngdDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhdlsy005ngdDTO));
            }
        }
        return res;
    }

    public Integer getTtjjhdlsy005ngdCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhdlsy005ngdDao.getTtjjhdlsy005ngdCount();
        } else {
            res = ttjjhdlsy005ngdDao.getTtjjhdlsy005ngdCountByParams(params[0]);
        }
        return res;
    }


    /**
     * 道路运输统计（半年，年）涵盖道路客运站信息
     **/
    public List<Map<String, List<String>>> getRoadTransportStatisticInfo(String start, String end) {
        List<Map<String, List<String>>> res = Lists.newArrayList();
        List<Ttjjhdlsy005ngdDTO> ttjjhdlsy005ngdDTOs = Lists.newArrayList();
        ttjjhdlsy005ngdDTOs = ttjjhdlsy005ngdDao.getRoadTransportStatisticInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhdlsy005ngdDTOs)) {
            for (Ttjjhdlsy005ngdDTO ttjjhdlsy005ngdDTO : ttjjhdlsy005ngdDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhdlsy005ngdDTO,"year","DLYS12005N0000010","DLYS12005N0000200"));
            }
        }
        return res;
    }

    /**
     * 道路客货站场增减情况
     **/
    public List<DlkhzczjqkDataDTO> getStationNumChangeInfo(String start, String end) {
        List<Ttjjhdlsy005ngdDTO> ttjjhdlsy005ngdDTOs = Lists.newArrayList();
        ttjjhdlsy005ngdDTOs = ttjjhdlsy005ngdDao.getStationNumChangeInfo(start, end);
        Map<String, Ttjjhdlsy005ngdDTO> now = ttjjhdlsy005ngdDTOs.stream()
                .collect(Collectors.toMap(Ttjjhdlsy005ngdDTO::getUnitid, Function.identity()));
        List<Ttjjhdlsy005ngdDTO> preTtjjhdlsy005ngdDTOs = ttjjhdlsy005ngdDao
                .getStationNumChangeInfo(DateUtil.getYearFrom(start), DateUtil.getYearFrom(start));
        Map<String, Ttjjhdlsy005ngdDTO> pre = preTtjjhdlsy005ngdDTOs.stream()
                .collect(Collectors.toMap(Ttjjhdlsy005ngdDTO::getUnitid, Function.identity()));
        Iterator<String> unitIds = now.keySet().iterator();
        List<DlkhzczjqkDataDTO> res = Lists.newArrayList();
        int index = 0;
        while (unitIds.hasNext()) {
            if (index >= 10) {
                break;
            }
            String key = unitIds.next();
            DlkhzczjqkDataDTO tmp = new DlkhzczjqkDataDTO();
            tmp.setZcname(key);
            tmp.setZsl(NumUtil.caculateDValue(
                    Objects.isNull(pre.get(key)) ? 0.0d : pre.get(key).getDlys12005n0000010(),
                    Objects.isNull(now.get(key)) ? 0.0d : pre.get(key).getDlys12005n0000010()));
            res.add(tmp);
            index++;
        }
        return res;
    }

    /**
     *  道路货运场站数据
     **/
    public List<Map<String, Object>> getRoadGoodsStationInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhdlsy005ngdDTO> ttjjhdlsy005ngdDTOs = Lists.newArrayList();
        ttjjhdlsy005ngdDTOs = ttjjhdlsy005ngdDao.getRoadGoodsStationInfo(start, end);
        if (!CollectionUtils.isEmpty(ttjjhdlsy005ngdDTOs)) {
            for (Ttjjhdlsy005ngdDTO ttjjhdlsy005ngdDTO : ttjjhdlsy005ngdDTOs) {
                res.add(ClassUtil.toHashMap(ttjjhdlsy005ngdDTO));
            }
        }
        return res;
    }


}