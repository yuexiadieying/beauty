package com.meixiang.beauty.web.product.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.product.InvoiceDTO;
import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.product.TrainingProductDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.modules.product.api.ProductService;
import com.meixiang.beauty.modules.product.api.TrainingProductService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 关于账户管理
 * @author frank
 * @date 2015-10-14
 */
@Controller
@RequestMapping(value = "product")
public class TrainingProductController {

	@Autowired
	private TrainingProductService trainingProductService;


	/**
	 * 获取培训商品的详细信息
	 *
	 * input PageParamDto
	 *
	 * output ResponseDTO<List<ProductDTO>>
	 *
	 */
	@RequestMapping(value = "getTrainingProductList", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO<List<ProductDTO>> getTrainingProductList(@RequestBody PageParamDTO pageParamDTO) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO<List<ProductDTO>> responseDTO = new ResponseDTO<>();
		List<ProductDTO> productDTOList = trainingProductService.getTrainingProductList(pageParamDTO);
		responseDTO.setResponseData(productDTOList);
		responseDTO.setResult(StatusConstant.SUCCESS);
		return responseDTO;
	}


	/**
	 * 获取培训商品的详细信息
	 *
	 * input PageParamDto
	 *
	 * output ResponseDTO<List<ProductDTO>>
	 *
	 */
	@RequestMapping(value = "getTrainingProductDetail", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO<ProductDTO<TrainingProductDTO>> getTrainingProductDetail(@RequestParam String productId) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO<ProductDTO<TrainingProductDTO>> responseDTO = new ResponseDTO<>();
		ProductDTO<TrainingProductDTO> productDTO = trainingProductService.getTrainingProductDetailById(productId);
		productDTO.setPrice(productDTO.getPrice());
		responseDTO.setResponseData(productDTO);
		responseDTO.setResult(StatusConstant.SUCCESS);
		return responseDTO;
	}

	/**
	 * 获取某个培训商品的播放次数
	 *
	 * input PageParamDto
	 *
	 * output ResponseDTO<List<ProductDTO>>
	 *
	 */
	@RequestMapping(value = "getTrainingProductPlayNum", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO<Integer> getTrainingProductPlayNum(@RequestParam String productId) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
		int playNum = trainingProductService.getTrainingProductPlayNum(productId);
		responseDTO.setResponseData(playNum);
		responseDTO.setResult(StatusConstant.SUCCESS);
		return responseDTO;
	}

	@RequestMapping(value = "AddTrainingProductPlayNum", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO AddTrainingProductPlayNum(@RequestParam String productId,@RequestParam String playURL) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO responseDTO = new ResponseDTO<>();
		trainingProductService.AddTrainingProductPlayNum(productId,playURL);
		responseDTO.setResult(StatusConstant.SUCCESS);
		return responseDTO;
	}

}

