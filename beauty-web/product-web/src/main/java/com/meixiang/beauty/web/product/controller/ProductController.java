package com.meixiang.beauty.web.product.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.modules.product.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 关于账户管理
 * @author frank
 * @date 2015-10-14
 */
@Controller
@RequestMapping(value = "product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * 获取某个商品的基本信息
	 *
	 * input PageParamDto
	 *
	 * output ResponseDTO<List<ProductDTO>>
	 *
	 */
	@RequestMapping(value = "getBusinessProductInfo", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO<ProductDTO> getBusinessProductInfo(@RequestParam String productId) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO<ProductDTO> responseDTO = new ResponseDTO<>();
		ProductDTO productDTO = productService.getBusinessProductInfo(productId);
		responseDTO.setResponseData(productDTO);
		responseDTO.setResult(StatusConstant.SUCCESS);
		return responseDTO;
	}

}

