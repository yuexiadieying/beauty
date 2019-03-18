package com.meixiang.beauty.modules.product.impl;

import com.meixiang.beauty.common.dto.product.*;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.modules.product.api.OfflineProductService;
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
public class OfflineProductServiceImpl implements OfflineProductService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ProductDao productDao;

    @Override
    public ProductDTO<OfflineProductDTO> getOfflineProductDetailById(String productId) {

        ProductDTO<OfflineProductDTO> productDTO = productDao.getBusinessProductInfo(productId,"offline");

        Query query = new Query().addCriteria(Criteria.where("productId").is(productId));
        OfflineProductDTO offlineProductDTO = mongoTemplate.findOne(query, OfflineProductDTO.class,"offlineProduct");

        productDTO.setProductDetail(offlineProductDTO);

        return productDTO;
    }

    @Override
    public List<ProductDTO> findOfflineProductList(PageParamDTO pageParamDTO) {
        List<ProductDTO> productDTOList = productDao.findOfflineProductList(pageParamDTO);
        return productDTOList;
    }

}
