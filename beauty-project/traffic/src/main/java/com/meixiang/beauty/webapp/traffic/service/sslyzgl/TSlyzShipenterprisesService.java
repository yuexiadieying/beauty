package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShipenterprisesDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShipenterprisesDTO;
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
public class TSlyzShipenterprisesService {

    @Autowired
    private TSlyzShipenterprisesDao tSlyzShipenterprisesDao;

    public List<Map<String, Object>> getTSlyzShipenterprisesByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TSlyzShipenterprisesDTO> tSlyzShipenterprisesDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tSlyzShipenterprisesDTOs = tSlyzShipenterprisesDao.getTSlyzShipenterprisesByPageable(start, end);
        } else {
            tSlyzShipenterprisesDTOs = tSlyzShipenterprisesDao.getTSlyzShipenterprisesByParamsPageable(start, end);
        }
        if (!CollectionUtils.isEmpty(tSlyzShipenterprisesDTOs)) {
            for (TSlyzShipenterprisesDTO tSlyzShipenterprisesDTO : tSlyzShipenterprisesDTOs) {
                res.add(ClassUtil.toHashMap(tSlyzShipenterprisesDTO));
            }
        }
        return res;
    }

    public Integer getTSlyzShipenterprisesCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tSlyzShipenterprisesDao.getTSlyzShipenterprisesCount();
        } else {
            res = tSlyzShipenterprisesDao.getTSlyzShipenterprisesCountByParams();
        }
        return res;
    }
}