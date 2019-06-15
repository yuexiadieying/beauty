package com.meixiang.beauty.webapp.traffic.service.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzApproveapplyrecordsDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzChangeshiprecordsDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzEnterpriseillegalrunrdDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzExitenterpriserecordsDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzPortsHnDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzServiceenterprisesDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzServicepersonsDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShipenterprisesDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShipillegalrunrecordsDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShipkindsDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShipnamesDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShippersonsDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzShipsDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzTfBsRestudyrecordScDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzUnitpersonsDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzUnitsHnDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzXzqhsDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzYearcheckenterprisesDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.TSlyzYearcheckshipsDao;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WY on 2019/6/11.
 */
@Service
public class HomePageService {
    @Autowired
    private TSlyzApproveapplyrecordsDao tSlyzApproveapplyrecordsDao;

    @Autowired
    private TSlyzChangeshiprecordsDao tSlyzChangeshiprecordsDao;

    @Autowired
    private TSlyzEnterpriseillegalrunrdDao tSlyzEnterpriseillegalrunrdDao;

    @Autowired
    private TSlyzExitenterpriserecordsDao tSlyzExitenterpriserecordsDao;

    @Autowired
    private TSlyzPortsHnDao tSlyzPortsHnDao;

    @Autowired
    private TSlyzServiceenterprisesDao tSlyzServiceenterprisesDao;

    @Autowired
    private TSlyzServicepersonsDao tSlyzServicepersonsDao;

    @Autowired
    private TSlyzShipenterprisesDao tSlyzShipenterprisesDao;

    @Autowired
    private TSlyzShipillegalrunrecordsDao tSlyzShipillegalrunrecordsDao;

    @Autowired
    private TSlyzShipkindsDao tSlyzShipkindsDao;

    @Autowired
    private TSlyzShipnamesDao tSlyzShipnamesDao;

    @Autowired
    private TSlyzShippersonsDao tSlyzShippersonsDao;

    @Autowired
    private TSlyzShipsDao tSlyzShipsDao;

    @Autowired
    private TSlyzTfBsRestudyrecordScDao tSlyzTfBsRestudyrecordScDao;

    @Autowired
    private TSlyzUnitpersonsDao tSlyzUnitpersonsDao;

    @Autowired
    private TSlyzUnitsHnDao tSlyzUnitsHnDao;

    @Autowired
    private TSlyzXzqhsDao tSlyzXzqhsDao;

    @Autowired
    private TSlyzYearcheckenterprisesDao tSlyzYearcheckenterprisesDao;

    @Autowired
    private TSlyzYearcheckshipsDao tSlyzYearcheckshipsDao;


    public List<SslyzglDTO> getHomePageInfo() {
        List<SslyzglDTO> res = new ArrayList<>();
        res.add(tSlyzApproveapplyrecordsDao.getHomepageInfo());
        res.add(tSlyzChangeshiprecordsDao.getHomepageInfo());
        res.add(tSlyzEnterpriseillegalrunrdDao.getHomepageInfo());
        res.add(tSlyzExitenterpriserecordsDao.getHomepageInfo());
        res.add(tSlyzPortsHnDao.getHomepageInfo());
        res.add(tSlyzServiceenterprisesDao.getHomepageInfo());
        res.add(tSlyzServicepersonsDao.getHomepageInfo());
        res.add(tSlyzShipenterprisesDao.getHomepageInfo());
        res.add(tSlyzShipillegalrunrecordsDao.getHomepageInfo());
        res.add(tSlyzShipkindsDao.getHomepageInfo());
        res.add(tSlyzShipnamesDao.getHomepageInfo());
        res.add(tSlyzShippersonsDao.getHomepageInfo());
        res.add(tSlyzShipsDao.getHomepageInfo());
        res.add(tSlyzTfBsRestudyrecordScDao.getHomepageInfo());
        res.add(tSlyzUnitpersonsDao.getHomepageInfo());
        res.add(tSlyzUnitsHnDao.getHomepageInfo());
        res.add(tSlyzXzqhsDao.getHomepageInfo());
        res.add(tSlyzYearcheckenterprisesDao.getHomepageInfo());
        res.add(tSlyzYearcheckshipsDao.getHomepageInfo());

        return res;
    }
}