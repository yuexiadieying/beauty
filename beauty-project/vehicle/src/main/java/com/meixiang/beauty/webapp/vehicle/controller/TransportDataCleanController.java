package com.meixiang.beauty.webapp.vehicle.controller;

import com.meixiang.beauty.webapp.vehicle.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;


@Controller
public class TransportDataCleanController {

    @Autowired
    TransportService transportService;

    @PostConstruct
    public void clean(){
        transportService.cleanData();
    }
}
