package com.meixiang.beauty.modules.product.impl;

import com.meixiang.beauty.common.dto.product.*;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.modules.product.api.InvoiceService;
import com.meixiang.beauty.modules.product.api.ProductService;
import com.meixiang.beauty.modules.product.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zbm84 on 2017/7/24.
 */
@Service
@Transactional(readOnly = false)
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void addInvoiceInfo(InvoiceDTO invoiceDTO) {
        mongoTemplate.insert(invoiceDTO,"invoice");
    }

    @Override
    public InvoiceDTO getInvoiceDetailById(String userId, String transactionId) {

        Query query = new Query().addCriteria(Criteria.where("userId").is(userId)).addCriteria(Criteria.where("transactionId").is(transactionId));
        InvoiceDTO invoiceDTO = mongoTemplate.findOne(query, InvoiceDTO.class,"invoice");
        return invoiceDTO;
    }
}
