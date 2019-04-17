package com.meixiang.beauty.webapp.vehicle.service;

import io.netty.channel.Channel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class VehicleEquipmentService {

    public final Map<String,Channel> vehicleChannelMapping = new ConcurrentHashMap<>();

    private static VehicleEquipmentService vehicleEquipmentService = new VehicleEquipmentService();

    public static VehicleEquipmentService getVehicleEquipmentService() {
        return vehicleEquipmentService;
    }

    public Map getVehicleEquipmentData(){
        return new HashMap(){{put("deviceId",1);put("messageType","gps");put("value",113);}};
    }

    public void processVehicleService(Map<String, Object> msgMap, Channel channel) {

        String deviceId = String.valueOf(msgMap.get("deviceId"));

        vehicleChannelMapping.put(deviceId,channel);
    }
}
