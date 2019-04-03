package com.meixiang.beauty.webapp.vehicle.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.webapp.vehicle.dao.TransportDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Producer {

    private final RingBuffer<PCData> ringBuffer;

    private JLabel jLabel;

    @Autowired
    TransportDao transportDao;

    public Producer(RingBuffer<PCData> ringBuffer, JLabel jLabel) {
        this.ringBuffer = ringBuffer;
        this.jLabel = jLabel;
    }

    public void pushData(List<Map> data){
        long sequence = ringBuffer.next();
        try{
            PCData event = ringBuffer.get(sequence);
            event.setData(data);
        }finally {
            ringBuffer.publish(sequence);
        }
    }

    public void beginProduce(){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.READ);
        //int i = 2190828;
        //int pageSize = 50;
        for(int start = 2190827;start<11111111;start+=50){
            doClean(start,start+50);
        }
        jLabel.setText("生产结束！！！");
    }

    public void doClean(int start,int end){
        jLabel.setText("生产------第"+start+"条到第"+end+"条");
        try{
            List<Map> list = transportDao.getDataList("",start,end);
            if(list!=null && list.size()>0){
                pushData(list);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}