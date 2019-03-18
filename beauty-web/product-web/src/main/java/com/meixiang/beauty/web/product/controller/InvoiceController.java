package com.meixiang.beauty.web.product.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.product.InvoiceDTO;
import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.modules.product.api.InvoiceService;
import com.meixiang.beauty.modules.product.api.ProductService;
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
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	/**
	 * 发票
	 *
	 * input PageParamDto
	 *
	 */
	@RequestMapping(value = "addInvoiceInfo", method = {RequestMethod.POST, RequestMethod.GET})
	@LoginRequired
	public
	@ResponseBody
	ResponseDTO addInvoiceInfo(@RequestBody InvoiceDTO invoiceDTO) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO responseDTO = new ResponseDTO<>();
		UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
		if (userInfoDTO!=null)
		{
			invoiceDTO.setUserId(userInfoDTO.getId());
			invoiceService.addInvoiceInfo(invoiceDTO);
			responseDTO.setResult(StatusConstant.SUCCESS);
		}
		else
		{
			responseDTO.setResult(StatusConstant.FAILURE);
		}

		return responseDTO;
	}

	/**
	 * 查询发票
	 *
	 * input PageParamDto
	 *
	 *
	 */
	@RequestMapping(value = "getInvoiceDetailById", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO<InvoiceDTO> getInvoiceDetailById(@RequestParam String transactionId) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO<InvoiceDTO> responseDTO = new ResponseDTO<>();
		UserInfoDTO userInfoDTO=UserUtils.getUserInfoFromRedis();
		InvoiceDTO invoiceDTO = invoiceService.getInvoiceDetailById(userInfoDTO.getId(),transactionId);
		responseDTO.setResponseData(invoiceDTO);
		responseDTO.setResult(StatusConstant.SUCCESS);
		return responseDTO;
	}


}

