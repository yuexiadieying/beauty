/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.modules.system.impl;

import com.aliyuncs.exceptions.ClientException;
import com.meixiang.beauty.common.dto.system.SuggestionDto;
import com.meixiang.beauty.common.dto.system.ValidateCodeDTO;
import com.meixiang.beauty.modules.system.api.SystemService;
import com.meixiang.beauty.sys.utils.RandomNumberUtil;
//import com.meixiang.beauty.sys.utils.SMSMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 * @author ThinkGem
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class SystemServiceImpl implements SystemService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public SuggestionDto addSuggestion(String userId, String suggestion) {

		SuggestionDto suggestionDto=new SuggestionDto();
		suggestionDto.setUserId(userId);
		suggestionDto.setSuggestion(suggestion);
		this.mongoTemplate.insert(suggestionDto, "suggestion");
		return suggestionDto;
	}

	@Override
	public void sendUserValidateCode(String mobile)
	{
		//生成4位数字的验证码
		String num = RandomNumberUtil.getFourRandom();

		//将用户手机号和随机数插入库中
		ValidateCodeDTO validateCodeDTO = new ValidateCodeDTO();
		validateCodeDTO.setCode(num);
		validateCodeDTO.setCreateDate(new Date());
		validateCodeDTO.setMobile(mobile);
		this.mongoTemplate.insert(validateCodeDTO, "validateCode");

//		try {
//			//SMSMessageUtil.sendValidateCodeMessage(mobile,num);
//		} catch (ClientException e) {
//			e.printStackTrace();
//		}
	}

}
