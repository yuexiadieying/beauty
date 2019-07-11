package com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl.TsjxttfbscmpsnrecordDao;
import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbscmpsnrecordDTO;
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
public class TsjxttfbscmpsnrecordService {

    @Autowired
    private TsjxttfbscmpsnrecordDao tsjxttfbscmpsnrecordDao;

    public List<Map<String, Object>> getTsjxttfbscmpsnrecordByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TsjxttfbscmpsnrecordDTO> tsjxttfbscmpsnrecordDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tsjxttfbscmpsnrecordDTOs = tsjxttfbscmpsnrecordDao.getTsjxttfbscmpsnrecordByPageable(start, end);
        } else {
            tsjxttfbscmpsnrecordDTOs = tsjxttfbscmpsnrecordDao.getTsjxttfbscmpsnrecordByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(tsjxttfbscmpsnrecordDTOs)) {
            for (TsjxttfbscmpsnrecordDTO tsjxttfbscmpsnrecordDTO : tsjxttfbscmpsnrecordDTOs) {
                res.add(ClassUtil.toHashMap(tsjxttfbscmpsnrecordDTO));
            }
        }
        return res;
    }

    public Integer getTsjxttfbscmpsnrecordCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tsjxttfbscmpsnrecordDao.getTsjxttfbscmpsnrecordCount();
        } else {
            res = tsjxttfbscmpsnrecordDao.getTsjxttfbscmpsnrecordCountByParams(params[0]);
        }
        return res;
    }
}