package com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtBerthsDao;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.QsbwbtjsjDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtBerthsDTO;
import com.meixiang.beauty.webapp.traffic.utils.ClassUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by WY on 2019/6/10.
 */
@Service
public class TGkmtBerthsService {

    @Autowired
    private TGkmtBerthsDao tGkmtBerthsDao;

    public List<Map<String, Object>> getTGkmtBerthsByPageable(Integer start, Integer end, String... params) {
        List<Map<String, Object>> res = Lists.newArrayList();
        List<TGkmtBerthsDTO> tGkmtBerthsDTOs = Lists.newArrayList();
        if (params.length <= 0) {
            tGkmtBerthsDTOs = tGkmtBerthsDao.getTGkmtBerthsByPageable(start, end);
        } else {
            tGkmtBerthsDTOs = tGkmtBerthsDao.getTGkmtBerthsByParamsPageable(start, end, params[0], params[1], params[2], params[3]);
        }
        if (!CollectionUtils.isEmpty(tGkmtBerthsDTOs)) {
            for (TGkmtBerthsDTO tGkmtBerthsDTO : tGkmtBerthsDTOs) {
                res.add(ClassUtil.toHashMap(tGkmtBerthsDTO));
            }
        }
        return res;
    }

    public Integer getTGkmtBerthsCount(String... params) {
        Integer res = 0;
        if (params.length <= 0) {
            res = tGkmtBerthsDao.getTGkmtBerthsCount();
        } else {
            res = tGkmtBerthsDao.getTGkmtBerthsCountByParams();
        }
        return res;
    }

    public QsbwbtjsjDTO getgetQsbwbtjsjDTO() {
        QsbwbtjsjDTO res = new QsbwbtjsjDTO();
        String format_month = "yyyyMM";
        String format_day = "yyyyMMdd";
        DateTime now = new DateTime();
        SimpleDateFormat formatMonth = new SimpleDateFormat(format_month);
        String preMonth = formatMonth.format(now.minusMonths(1).toDate());
        String nowMonth = formatMonth.format(now.toDate());
        List<QsbwbtjsjDTO> berths = tGkmtBerthsDao.getBerthsNumInMonthsByParams("","",preMonth, nowMonth);
        Map<String, QsbwbtjsjDTO> berthsMap = berths.stream().collect(Collectors.toMap(QsbwbtjsjDTO::getTime, Function.identity()));
        String nowBerthNum = Objects.isNull(berthsMap.get(nowMonth)) ? "0" : berthsMap.get(nowMonth).getLjgkbws();
        String preBerthNum = Objects.isNull(berthsMap.get(preMonth)) ? "0" : berthsMap.get(nowMonth).getLjgkbws();
        res.setLjgkbws(nowBerthNum);
        res.setLjgkbwsRate(caculateRate(preBerthNum, nowBerthNum));

        SimpleDateFormat formatDay = new SimpleDateFormat(format_day);
        String startWeekDay = formatDay.format(new DateTime(now.withDayOfWeek(1).getMillis() - 7*24*3600*1000).toDate());
        String middleWeekDay = formatDay.format(now.withDayOfWeek(1).toDate());
        String endWeekDay = formatDay.format(now.toDate());
        List<QsbwbtjsjDTO> reports = tGkmtBerthsDao.getBerthsReportInWeeksByParams("","",startWeekDay,endWeekDay,middleWeekDay);
        Map<String, QsbwbtjsjDTO> reportsMap = reports.stream().collect(Collectors.toMap(QsbwbtjsjDTO::getTime, Function.identity()));
        String preAddRep = Objects.isNull(reportsMap.get(startWeekDay)) ? "0" : reportsMap.get(startWeekDay).getZjdbgq();
        String nowAddRep = Objects.isNull(reportsMap.get(endWeekDay)) ? "0" : reportsMap.get(endWeekDay).getZjdbgq();
        res.setZjdbgq(nowAddRep);
        res.setZjdbgqRate(caculateRate(preAddRep, nowAddRep));

        String preDiscardRep = Objects.isNull(reportsMap.get(startWeekDay)) ? "0" : reportsMap.get(startWeekDay).getBfdbgq();
        String nowDiscardRep = Objects.isNull(reportsMap.get(endWeekDay)) ? "0" : reportsMap.get(endWeekDay).getBfdbgq();
        res.setBfdbgq(nowDiscardRep);
        res.setBfdbgqRate(caculateRate(preDiscardRep, nowDiscardRep));
        return res;
    }

    private String caculateRate(String pre, String now) {
        if ("0".equalsIgnoreCase(pre)) {
            return "100%";
        }
        return String.valueOf((Integer.valueOf(now) - Integer.valueOf(pre)) * 100 / Integer.valueOf(pre)) + "%";
    }

    public static void main(String[] args) {
        String format_month = "yyyyMM";
        String format_day = "yyyyMMdd";
        DateTime now = new DateTime();
        SimpleDateFormat formatMonth = new SimpleDateFormat(format_month);
        String preMonth = formatMonth.format(now.minusMonths(1).toDate());
        String nowMonth = formatMonth.format(now.toDate());

        SimpleDateFormat formatDay = new SimpleDateFormat(format_day);
        String startWeekDay = formatDay.format(new DateTime(now.withDayOfWeek(1).getMillis() - 7*24*3600*1000).toDate());
        String middleWeekDay = formatDay.format(now.withDayOfWeek(1).toDate());
        String endWeekDay = formatDay.format(now.toDate());

        System.out.println(preMonth);
        System.out.println(nowMonth);
        System.out.println(startWeekDay);
        System.out.println(middleWeekDay);
        System.out.println(endWeekDay);
    }
}