package com.meixiang.beauty.webapp.traffic.service.zhgj;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.zhgj.TBusTopicGisDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusTopicGisDTO;
import com.meixiang.beauty.webapp.traffic.utils.ClassUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by WY on 2019/6/10.
 */
@Service
public class TBusTopicGisService {

    @Autowired
    private TBusTopicGisDao tBusTopicGisDao;

    public List<Map<String, Object>> getTBusTopicGisInfo(String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TBusTopicGisDTO> tBusTopicGisDTOs = Lists.newArrayList();
        if (params.length <= 0 || params[0] == null || "".equalsIgnoreCase(params[0])) {

        } else {
            String format_day = "yyyyMMdd";
            DateTime now = new DateTime();
            SimpleDateFormat formatDay = new SimpleDateFormat(format_day);
            tBusTopicGisDTOs = tBusTopicGisDao.getTBusTopicGisInfo(formatDay.format(now.toDate()), params[0]);
        }
        if (!CollectionUtils.isEmpty(tBusTopicGisDTOs)) {
            for (TBusTopicGisDTO tBusTopicGisDTO : tBusTopicGisDTOs) {
                res.add(ClassUtil.toHashMap(tBusTopicGisDTO));
            }
        }
        return res;
    }

    public Integer getTBusTopicGisCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tBusTopicGisDao.getTBusTopicGisCount();
        } else {
            res = tBusTopicGisDao.getTBusTopicGisCountByParams(params[0]);
        }
        return res;
    }
}