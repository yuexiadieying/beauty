package com.meixiang.beauty.modules.product.api;

import com.meixiang.beauty.common.dto.product.InvoiceDTO;
import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.product.TrainingProductDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zbm84 on 2017/7/24.
 */
public interface TrainingProductService {

    ProductDTO<TrainingProductDTO> getTrainingProductDetailById(String productId);

    List<ProductDTO> getTrainingProductList(PageParamDTO pageParamDTO);

    int getTrainingProductPlayNum(String productId);

    void AddTrainingProductPlayNum(String productId, String playURL);

    PageParamDTO<List<TrainingProductDTO>> queryAllTrainingProductDTO(PageParamDTO pageParamDTO);
}
