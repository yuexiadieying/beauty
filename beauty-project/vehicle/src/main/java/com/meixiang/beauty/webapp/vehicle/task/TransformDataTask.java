package com.meixiang.beauty.webapp.vehicle.task;

import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.sys.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.meixiang.beauty.webapp.vehicle.service.*;
import org.springframework.stereotype.Controller;

import java.util.*;

@Component
public class TransformDataTask {

    @Autowired
    ApprovalService approvalService;

    public void transformData(){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.READ);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-1);
        String yesterday = String.format("%tF%n",calendar.getTime());
        yesterday = "2018-12-03";
        List<Map> CheLiang_list = approvalService.getCheLiangList(yesterday);
        List<Map> JiaShiYuanTaiZhang_list = approvalService.getJiaShiYuanTaiZhangList(yesterday);
        List<Map> YeHu_list = approvalService.getYeHuList(yesterday);

        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        CheLiang_list.forEach(map -> {
            try{
                approvalService.saveCheLiangList(map);
            }catch (Exception e){
                Map failMap = new HashMap();
                failMap.put("id", UUIDUtil.getUUID());
                failMap.put("table_name","T_CheLiang");
                failMap.put("table_id",map.get("Id"));
                failMap.put("fail_message",e.getMessage().substring(0,e.getMessage().length()>200?200:e.getMessage().length()));
                approvalService.saveFailData(failMap);
            }finally {
                return;
            }
        });
        JiaShiYuanTaiZhang_list.forEach(map -> {
            try{
                approvalService.saveJiaShiYuanTaiZhangList(map);
            }catch (Exception e){
                Map failMap = new HashMap();
                failMap.put("id", UUIDUtil.getUUID());
                failMap.put("table_name","T_JiaShiYuanTaiZhang");
                failMap.put("table_id",map.get("Id"));
                failMap.put("fail_message",e.getMessage().substring(0,e.getMessage().length()>200?200:e.getMessage().length()));
                approvalService.saveFailData(failMap);
            }finally {
                return;
            }
        });
        YeHu_list.forEach(map -> {
            try{
                approvalService.saveYeHuList(map);
            }catch (Exception e){
                Map failMap = new HashMap();
                failMap.put("id", UUIDUtil.getUUID());
                failMap.put("table_name","T_JiaShiYuanTaiZhang");
                failMap.put("table_id",map.get("Id"));
                failMap.put("fail_message",e.getMessage().substring(0,e.getMessage().length()>200?200:e.getMessage().length()));
                approvalService.saveFailData(failMap);
            }finally {
                return;
            }
        });
        System.out.println("success");
    }
}
