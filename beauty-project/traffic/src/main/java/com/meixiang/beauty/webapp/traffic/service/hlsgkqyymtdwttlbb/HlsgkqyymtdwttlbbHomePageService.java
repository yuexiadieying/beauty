package com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb;

import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtUnitsDao;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtUnitusersDao;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtReportdataDao;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtQuickreportdataDao;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtPortsDao;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtPortregionsDao;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtEnterpriseusersDao;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtEnterprisesDao;
import com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb.TGkmtBerthsDao;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WY on 2019/6/11.
 */
@Service
public class HlsgkqyymtdwttlbbHomePageService {
    @Autowired
    private TGkmtUnitsDao tGkmtUnitsDao;

    @Autowired
    private TGkmtUnitusersDao tGkmtUnitusersDao;

    @Autowired
    private TGkmtReportdataDao tGkmtReportdataDao;

    @Autowired
    private TGkmtQuickreportdataDao tGkmtQuickreportdataDao;

    @Autowired
    private TGkmtPortsDao tGkmtPortsDao;

    @Autowired
    private TGkmtPortregionsDao tGkmtPortregionsDao;

    @Autowired
    private TGkmtEnterpriseusersDao tGkmtEnterpriseusersDao;

    @Autowired
    private TGkmtEnterprisesDao tGkmtEnterprisesDao;

    @Autowired
    private TGkmtBerthsDao tGkmtBerthsDao;



    public List<TtlbbDTO> getHomePageInfo() {
        List<TtlbbDTO> res = new ArrayList<>();
        res.add(tGkmtUnitsDao.getHomepageInfo());
        res.add(tGkmtUnitusersDao.getHomepageInfo());
        res.add(tGkmtReportdataDao.getHomepageInfo());
        res.add(tGkmtQuickreportdataDao.getHomepageInfo());
        res.add(tGkmtPortsDao.getHomepageInfo());
        res.add(tGkmtPortregionsDao.getHomepageInfo());
        res.add(tGkmtEnterpriseusersDao.getHomepageInfo());
        res.add(tGkmtEnterprisesDao.getHomepageInfo());
        res.add(tGkmtBerthsDao.getHomepageInfo());

        return res;
    }
}