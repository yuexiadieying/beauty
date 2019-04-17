package com.meixiang.beauty.webapp.vehicle.task;

import com.alibaba.fastjson.JSONObject;
import com.meixiang.beauty.webapp.vehicle.service.VehicleEquipmentService;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class VehicleEquipmentTask {

    @Autowired
    VehicleEquipmentService vehicleEquipmentService;

    public void getVehicleEquipmentData() {
        System.out.println("获取车载设备信息任务开始====================");
        Map map = vehicleEquipmentService.getVehicleEquipmentData();

    }
}
