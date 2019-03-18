package com.meixiang.beauty.modules.system.api;

import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.system.ExportOrderExcelDTO;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface OperationService {

    /**
     * 查询所有商品
     * @param pageParamVoDTO
     * @return
     */
    PageParamVoDTO<List<ProductDTO>> queryAllProducts(PageParamVoDTO<ProductDTO> pageParamVoDTO);

    /**
     * 条件查询商品
     * @param pageParamVoDTO
     * @return
     */
    PageParamVoDTO<List<ProductDTO>> queryProductsByParameters(PageParamVoDTO<ProductDTO> pageParamVoDTO);
    //根据id查询商品
    ProductDTO findProductById(String id);
    //编辑商品
    void updateProductByParameters(ProductDTO<OfflineProductDTO> productDTO);
    //编辑商品-上架
    void putAwayProductById(String id);
    //编辑商品-下架
    void delProductById(String id);
    //上传视频
    String aviUploadToSSO(MultipartFile[] listFile);
    //上传图片
    List<String> imageUploadToOSS(MultipartFile[] listFile, String folder);
    //查询导出Excel所需数据
    List<ExportOrderExcelDTO> selectExcelContent();
    //新增商品
    void addOfflineProduct(ProductDTO<OfflineProductDTO> pageParamVoDTO);
}
