package com.meixiang.beauty.modules.system.dao;

import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.system.ExportOrderExcelDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@MyBatisDao
@Repository
public interface OperationDao {

    //查询所有商品
    Page<ProductDTO> queryAllProducts(Page<ProductDTO> page);

    //条件查询商品Count
    int queryProductsCountByParameters(PageParamVoDTO<ProductDTO> pageParamVoDTO);

    //条件查询商品
    List<ProductDTO> queryProductsByParameters(PageParamVoDTO<ProductDTO> pageParamVoDTO);

    //根据id查询商品
    ProductDTO findProductById(String id);

    //编辑商品
    void updateProductByParameters(ProductDTO<OfflineProductDTO> pageParamVoDTO);

    //编辑商品-上架
    void putAwayProductById(String id);

    //编辑商品-下架
    void delProductById(String id);
    //查询导出Excel信息
    List<ExportOrderExcelDTO> selectExcelContent();
    //新增商品
    void addOfflineProduct(ProductDTO<OfflineProductDTO> productDTO);
    //修改未发货订单为已发货
    void updateOrderStatusByExcelDTO(ExportOrderExcelDTO exportOrderExcelDTO);
}
