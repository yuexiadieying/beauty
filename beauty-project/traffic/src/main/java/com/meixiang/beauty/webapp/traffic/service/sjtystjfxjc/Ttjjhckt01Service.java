package com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc.Ttjjhckt01Dao;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.CskyjtglDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhckt01DTO;
import com.meixiang.beauty.webapp.traffic.utils.ClassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by WY on 2019/6/10.
 */
@Service
public class Ttjjhckt01Service {

    @Autowired
    private Ttjjhckt01Dao ttjjhckt01Dao;

    public List<Map<String, Object>> getTtjjhckt01ByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhckt01DTO> ttjjhckt01DTOs = Lists.newArrayList();
        if (params.length <= 0) {
            ttjjhckt01DTOs = ttjjhckt01Dao.getTtjjhckt01ByPageable(start, end);
        } else {
            ttjjhckt01DTOs = ttjjhckt01Dao.getTtjjhckt01ByParamsPageable(start, end, params[0]);
        }
        if (!CollectionUtils.isEmpty(ttjjhckt01DTOs)) {
            for (Ttjjhckt01DTO ttjjhckt01DTO : ttjjhckt01DTOs) {
                res.add(ClassUtil.toHashMap(ttjjhckt01DTO));
            }
        }
        return res;
    }

    public Integer getTtjjhckt01Count(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = ttjjhckt01Dao.getTtjjhckt01Count();
        } else {
            res = ttjjhckt01Dao.getTtjjhckt01CountByParams(params[0]);
        }
        return res;
    }

    /**
     * 城市（县城）客运交通管理信息
     **/
    public List<Map<String, Object>> getPassengerTrafficManagerInfo(String start, String end) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<Ttjjhckt01DTO> ttjjhckt01DTOs = Lists.newArrayList();
        ttjjhckt01DTOs = ttjjhckt01Dao.getPassengerTrafficManagerInfo(start, end);
        if (CollectionUtils.isEmpty(ttjjhckt01DTOs)) {
            return res;
        }
        List<String> cks = ttjjhckt01DTOs.stream().map(Ttjjhckt01DTO::getCk0110021).collect(Collectors.toList());
        String preYear = String.valueOf(Integer.valueOf(start) - 1);
        List<Ttjjhckt01DTO> preYearDtos = ttjjhckt01Dao.getPassengerTrafficManagerInfoIn(cks, preYear,preYear);
        Map<String, Ttjjhckt01DTO> preYearDTOMap = preYearDtos.stream()
                .collect(Collectors.toMap(Ttjjhckt01DTO::getCk0110021, Function.identity()));

        List<Ttjjhckt01DTO> sumTtjjhckt01DTOs = ttjjhckt01Dao.getPassengerTrafficManagerSumInfo(start, end);
        Double sum = sumTtjjhckt01DTOs.get(0).getCk0120011();

        List<CskyjtglDataDTO> cskyjtglDataDTOS = Lists.newArrayList();
        for (Ttjjhckt01DTO ttjjhckt01DTO : ttjjhckt01DTOs) {
            Ttjjhckt01DTO preyearDto = preYearDTOMap.get(ttjjhckt01DTO.getCk0110021());
            CskyjtglDataDTO cskyjtglDataDTO = new CskyjtglDataDTO();
            cskyjtglDataDTO.setName(ttjjhckt01DTO.getCk0110021());
            cskyjtglDataDTO.setGlxx(ttjjhckt01DTO.getCk0110021());
            cskyjtglDataDTO.setZb(sum == 0.0 ? "0" : String.valueOf(ttjjhckt01DTO.getCk0120011()/sum));
            if (Objects.isNull(preyearDto) || Objects.isNull(preyearDto.getCk0120011())) {
                if (Objects.isNull(ttjjhckt01DTO.getCk0120011()) || ttjjhckt01DTO.getCk0120011() == 0.0) {
                    cskyjtglDataDTO.setYhb("0%");
                } else {
                    cskyjtglDataDTO.setYhb("100%");
                }
            } else {
                cskyjtglDataDTO.setYhb(String.valueOf(
                        (ttjjhckt01DTO.getCk0120011() - preyearDto.getCk0120011()) * 100/preyearDto.getCk0120011()) + "%");
            }
            cskyjtglDataDTOS.add(cskyjtglDataDTO);
        }


        if (!CollectionUtils.isEmpty(cskyjtglDataDTOS)) {
            for (CskyjtglDataDTO cskyjtglDataDTO : cskyjtglDataDTOS) {
                res.add(ClassUtil.toHashMap(cskyjtglDataDTO));
            }
        }
        return res;
    }
}