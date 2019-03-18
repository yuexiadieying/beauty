package com.meixiang.beauty.web.product.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.modules.product.api.OfflineProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 关于账户管理
 * @author frank
 * @date 2015-10-14
 */
@Controller
@RequestMapping(value = "product")
public class OfflineProductController {

	@Autowired
	private OfflineProductService offlineProductService;

	/**
	 * 获取商城首页的线下产品的列表，每次获取6条产品记录，前端下拉时记载更多的6条，此处不包括产品详情
	 *
	 * input PageParamDto
	 *
	 * output ResponseDTO<List<ProductDTO<OfflineProductDTO>>>
	 *
	 */
	@RequestMapping(value = "getOfflineProductList", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO<List<ProductDTO>> getOfflineProductList(@RequestBody PageParamDTO pageParamDTO, HttpServletRequest request) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO<List<ProductDTO>> responseDTO = new ResponseDTO<>();
		List<ProductDTO> productDTOList = offlineProductService.findOfflineProductList(pageParamDTO);
		responseDTO.setResponseData(productDTOList);
		responseDTO.setResult(StatusConstant.SUCCESS);
		return responseDTO;
	}


	/**
	 * 获取线下商品的详细信息
	 *
	 * input PageParamDto
	 *
	 * output ResponseDTO<List<OfflineProductDTO>>
	 *
	 */
	@RequestMapping(value = "getOfflineProductDetail", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO<ProductDTO<OfflineProductDTO>> getOfflineProductDetail(@RequestParam String productId) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO<ProductDTO<OfflineProductDTO>> responseDTO = new ResponseDTO<>();
		ProductDTO<OfflineProductDTO> offlineProductDTO = offlineProductService.getOfflineProductDetailById(productId);
		responseDTO.setResponseData(offlineProductDTO);
		responseDTO.setResult(StatusConstant.SUCCESS);
		return responseDTO;
	}
}

