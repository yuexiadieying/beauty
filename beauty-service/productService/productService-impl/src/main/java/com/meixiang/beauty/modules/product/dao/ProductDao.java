/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.modules.product.dao;

import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.product.TrainingProductDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@MyBatisDao
@Repository
public interface ProductDao {

	ProductDTO getBusinessProductInfo(@Param("productId") String productId, @Param("type") String type);

	List<ProductDTO> findOfflineProductList(PageParamDTO productDTO);

    List<ProductDTO> findTrainingProductList(PageParamDTO pageParamDTO);

}
