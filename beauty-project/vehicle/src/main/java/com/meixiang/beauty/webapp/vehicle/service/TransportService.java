package com.meixiang.beauty.webapp.vehicle.service;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.webapp.vehicle.dao.TransportDao;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.Channel;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TransportService {

    @Autowired
    TransportDao transportDao;

    //@Autowired
    //private AmqpTemplate rabbitTemplate;

    public static final Date d = new Date();

    public void cleanData(){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.READ);
        System.out.printf("获取数据开始：%tc%n",TransportService.d);
        int i = 0;
        int pageSize = 50;
        doClean(i,pageSize);
        System.out.printf("获取数据结束：%tc%n",TransportService.d);
    }

    //每次取10000条数据，对比插入
    public void doClean(int i,int pageSize){
        int start = i*pageSize;
        int end = (i+1)*pageSize-1;
        List<Map> list = null;//transportDao.getDataList("T_CheLiangJiBenXinXi",start,end);
        if(list!=null && list.size()>0){
            Gson gson = new Gson();
            gson.toJson(list);
            //this.rabbitTemplate.convertAndSend("transport.exchange","T_CheLiangJiBenXinXi", list);
            /*list.forEach(map -> {
                Gson gson = new Gson();
                String data = gson.toJson(map);
                this.rabbitTemplate.convertAndSend("transport.exchange","T_CheLiangJiBenXinXi", data);
            });*/
            i++;
            doClean(i,pageSize);
        }
    }
}
