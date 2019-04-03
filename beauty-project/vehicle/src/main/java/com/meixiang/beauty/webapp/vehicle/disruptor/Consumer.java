package com.meixiang.beauty.webapp.vehicle.disruptor;

import com.lmax.disruptor.WorkHandler;
import com.meixiang.beauty.webapp.vehicle.dao.TransportDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

public class Consumer implements WorkHandler<PCData> {

    private JLabel jLabel;

    @Autowired
    TransportDao transportDao;

    public Consumer(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    public Consumer() {
    }

    @Override
    public void onEvent(PCData pcData) throws Exception {
        transportDao.insert_T_CheLiangJiBenXinXiBatch(pcData.getData());
        jLabel.setText("消费------第"+pcData.getData().get(0).get("id")+"条");
    }
}
