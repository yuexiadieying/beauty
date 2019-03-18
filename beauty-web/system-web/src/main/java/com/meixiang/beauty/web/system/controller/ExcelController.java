package com.meixiang.beauty.web.system.controller;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.dto.system.BannerDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.transaction.InstanceReturnMoneySignalDTO;
import com.meixiang.beauty.common.dto.transaction.MonthTransactionRecordDTO;
import com.meixiang.beauty.common.dto.transaction.OrderProductRelationDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.common.utils.RedisLock;
import com.meixiang.beauty.modules.account.AccountService;
import com.meixiang.beauty.modules.account.IncomeRecordService;
import com.meixiang.beauty.modules.account.PayRecordService;
import com.meixiang.beauty.modules.account.dao.PayRecordDao;
import com.meixiang.beauty.modules.system.api.BannerService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.dao.UserDao;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.modules.transaction.api.TransactionService;
import com.meixiang.beauty.modules.transaction.dao.TransactionDao;
import com.meixiang.beauty.sys.utils.ObjectUtils;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.shiro.crypto.hash.Hash;
import org.h2.mvstore.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Controller
@RequestMapping(value = "system")
public class ExcelController {

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private PayRecordDao payRecordDao;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private PayRecordService payRecordService;

	@Autowired
	private IncomeRecordService incomeRecordService;

	@Autowired
	private UserDao userDao;

	private static ExecutorService threadExecutorSingle = Executors.newSingleThreadExecutor();

	@RequestMapping(value = "importSysUser", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO importSysUser() {
		ResponseDTO responseDto=new ResponseDTO<>();

		File file = new File("D:\\xls\\sysUser.xls");// 表格存储的位置
		List<Map<String, String>> list = readExcel(file);

		for(Map<String,String> data:list)
		{
			try
			{
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				userInfoDTO.setId(data.get("id"));
				userInfoDTO.setDelFlag(data.get("delFlag"));
				userInfoDTO.setNickname(data.get("name"));

				if(data.get("type").equals("A"))
				{
					userInfoDTO.setUserType(ConfigConstant.businessA1);
				}
				else if(data.get("type").equals("B"))
				{
					userInfoDTO.setUserType(ConfigConstant.businessB1);
				}
				else if(data.get("type").equals("C"))
				{
					userInfoDTO.setUserType(ConfigConstant.businessC1);
				}
				if(data.get("parentUserId").equals("/"))
				{
					userInfoDTO.setParentUserId("");
				}
				else
				{
					userInfoDTO.setParentUserId(data.get("parentUserId"));
				}
				userInfoDTO.setUserOpenid(data.get("openid"));
				userInfoDTO.setWeixinAttentionStatus(data.get("attention"));
				userInfoDTO.setMobile(data.get("mobile"));
				userInfoDTO.setIdentifyNumber(data.get("identity"));
				userInfoDTO.setLoginIp(data.get("loginIp"));
				userInfoDTO.setCreateDate(DateUtils.parseDate(data.get("createDate")));
				userService.insertUserInfo(userInfoDTO);

				UserBusinessTypeDTO userBusinessTypeDTO = new UserBusinessTypeDTO();
				userBusinessTypeDTO.setSysUserId(userInfoDTO.getId());
				userBusinessTypeDTO.setStatus("1");
				userBusinessTypeDTO.setCreateDate(userInfoDTO.getCreateDate());
				userBusinessTypeDTO.setId(UUID.randomUUID().toString());
				userBusinessTypeDTO.setUserType(userInfoDTO.getUserType());
				userBusinessTypeDTO.setParentUserId(userInfoDTO.getParentUserId());
				userService.insertUserBusinessType(userBusinessTypeDTO);

				AccountDTO accountDTO = new AccountDTO();
				accountDTO.setId(UUID.randomUUID().toString());
				accountDTO.setSysUserId(userInfoDTO.getId());
				accountDTO.setUserOpenId(userInfoDTO.getUserOpenid());
				accountDTO.setBalance((float)0.00);
				accountDTO.setScore((float)0.00);
				accountDTO.setStatus("nomral");
				accountDTO.setUpdateDate(userInfoDTO.getCreateDate());
				accountDTO.setBalanceDeny((float)0.00);
				accountService.createUserAccount(accountDTO);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return responseDto;
	}

	@RequestMapping(value = "importBusinessOrder", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO importBusinessOrder() {
		ResponseDTO responseDto=new ResponseDTO<>();

		File file = new File("D:\\xls\\businessOrder.xls");// 表格存储的位置
		List<Map<String, String>> list = readExcel(file);

		for(Map<String,String> data:list)
		{
			try
			{
				BusinessOrderDTO businessOrderDTO = new BusinessOrderDTO();
				businessOrderDTO.setId(data.get("id"));
				businessOrderDTO.setSysUserId(data.get("userId"));
				businessOrderDTO.setType(data.get("type"));
				businessOrderDTO.setStatus("1");
				businessOrderDTO.setBusinessOrderId(data.get("orderId"));
				businessOrderDTO.setUserOrderAddressId(data.get("addressId"));
				businessOrderDTO.setUpdateDate(DateUtils.parseDate(data.get("updateDate")));
				businessOrderDTO.setCreateDate(DateUtils.parseDate(data.get("createDate")));
				transactionDao.createBusinessOrder(businessOrderDTO);

			}catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		File file1 = new File("D:\\xls\\orderProductRelation.xls");// 表格存储的位置
		List<Map<String, String>> list1 = readExcel(file1);
		for(Map<String,String> data:list1)
		{
			OrderProductRelationDTO orderProductRelationDTO = new OrderProductRelationDTO();
			orderProductRelationDTO.setId(data.get("id"));
			orderProductRelationDTO.setBusinessOrderId(data.get("orderId"));
			orderProductRelationDTO.setBusinessProductId(data.get("productId"));
			orderProductRelationDTO.setProductNum(Integer.parseInt(data.get("productNum")));
			orderProductRelationDTO.setProductSpec(data.get("productSpec"));
			transactionDao.createOrderProductRelation(orderProductRelationDTO);
		}

		return responseDto;
	}

	@RequestMapping(value = "importPayRecord", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO importPayRecord() {
		ResponseDTO responseDto=new ResponseDTO<>();

		File file = new File("D:\\xls\\payRecord.xls");// 表格存储的位置
		List<Map<String, String>> list = readExcel(file);

		for(Map<String,String> data:list)
		{
			try
			{
				if(data.get("userId").equals("1f9cec96-eba3-11e7-8c4u-9a214cf179zw"))
				{
					int i = 0;
				}
				PayRecordDTO payRecordDTO = new PayRecordDTO();
				payRecordDTO.setId(data.get("id"));
				payRecordDTO.setSysUserId(data.get("userId"));
				payRecordDTO.setTransactionId(data.get("transactionId"));
				payRecordDTO.setOrderId(data.get("businessOrderId"));
				payRecordDTO.setOutTradeNo(data.get("transactionId"));
				payRecordDTO.setAmount(Float.parseFloat(data.get("amount")));
				payRecordDTO.setPayType(data.get("type"));
				payRecordDTO.setStatus("1");
				payRecordDTO.setPayDate(DateUtils.parseDate(data.get("createDate")));
				payRecordDTO.setOpenid(data.get("openid"));
				payRecordDTO.setInvoice(data.get("invoice"));
				payRecordDao.insertPayRecord(payRecordDTO);

				BusinessOrderDTO businessOrderDTO = new BusinessOrderDTO();
				businessOrderDTO.setBusinessOrderId(payRecordDTO.getOrderId());
				List<BusinessOrderDTO> businessOrderDTOS = transactionDao.getBusinessOrderList(businessOrderDTO);
				if(businessOrderDTOS.get(0).getType().equals("offline"))
				{

					//实时提现不跟交易放在一起，在此设置一个信号灯
					InstanceReturnMoneySignalDTO instanceReturnMoneySignalDTO = new InstanceReturnMoneySignalDTO();
					instanceReturnMoneySignalDTO.setSysUserId(payRecordDTO.getSysUserId());
					instanceReturnMoneySignalDTO.setOutTradeNo(payRecordDTO.getOutTradeNo());
					instanceReturnMoneySignalDTO.setTransactionId(payRecordDTO.getTransactionId());
					instanceReturnMoneySignalDTO.setStatus("0");
					mongoTemplate.insert(instanceReturnMoneySignalDTO,"instanceReturnMoneySignal");

					//开启一个线程，进行即时返现和提升处理
					Runnable processInstancePayThread = new ProcessInstancePayThread(instanceReturnMoneySignalDTO);
					threadExecutorSingle.execute(processInstancePayThread);
				}
			}catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return responseDto;
	}

	//进入即时返现和提升处理线程
	private class ProcessInstancePayThread extends Thread {
		private InstanceReturnMoneySignalDTO instanceReturnMoneySignalDTO;

		public ProcessInstancePayThread(InstanceReturnMoneySignalDTO instanceReturnMoneySignalDTO) {
			this.instanceReturnMoneySignalDTO = instanceReturnMoneySignalDTO;
		}

		@Override
		public void run() {
			try
			{
				//todo 开启A、B店的规则，给不同的用户给与不同的金额入账，此处涉及到修改用户的account表和income表
				UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromUserId(instanceReturnMoneySignalDTO.getSysUserId());

				//todo 此处的逻辑主要是用来实现即时返现功能，此时即时返现的资金是冻结的，需要用户收货之后，获得返现的用户才能拿到钱
				if(!ObjectUtils.isNullOrEmpty(userInfoDTO.getParentUserId()))
				{
					if(userInfoDTO.getUserType().equals(ConfigConstant.businessB1))
					{
						//走B店用户消费返现逻辑
						//1、查询父一级用户是否是A店用户
						UserInfoDTO parentUserInfoDTO =  UserUtils.getUserInfoFromUserId(userInfoDTO.getParentUserId());
						if(parentUserInfoDTO.getUserType()!=null)
						{
							if(parentUserInfoDTO.getUserType().equals(ConfigConstant.businessA1))
							{
								updateReturnMoneyDataBase(parentUserInfoDTO.getId(),ConfigConstant.businessB1,ConfigConstant.businessA1, instanceReturnMoneySignalDTO);
							}
						}
					}
					if(userInfoDTO.getUserType().equals(ConfigConstant.businessC1))
					{
						//走普通用户消费逻辑
						//1、查询父一级的用户信息
						UserInfoDTO parentUserInfoDTO = UserUtils.getUserInfoFromUserId(userInfoDTO.getParentUserId());
						if(parentUserInfoDTO.getUserType()!=null)
						{
							if(parentUserInfoDTO.getUserType().equals(ConfigConstant.businessA1))  //2、如果父一级用户为A店用户
							{
								updateReturnMoneyDataBase(parentUserInfoDTO.getId(),ConfigConstant.businessC1,ConfigConstant.businessA1, instanceReturnMoneySignalDTO);
							}
							else if(parentUserInfoDTO.getUserType().equals(ConfigConstant.businessB1)) //3、如果父一级用户为B店用户
							{
								//先更新用户上一级B店用户的返现金额
								updateReturnMoneyDataBase(parentUserInfoDTO.getId(),ConfigConstant.businessC1,ConfigConstant.businessB1, instanceReturnMoneySignalDTO);

								if(parentUserInfoDTO.getParentUserId()!=null)
								{
									UserInfoDTO grandpaUserInfoDTO = UserUtils.getUserInfoFromUserId(parentUserInfoDTO.getParentUserId());

									//在更新爷爷一级用户的类型为A店店主的返现金额
									if(grandpaUserInfoDTO.getUserType()!=null)
									{
										if(grandpaUserInfoDTO.getUserType().equals(ConfigConstant.businessA1))
										{
											updateReturnMoneyDataBase(grandpaUserInfoDTO.getId(),ConfigConstant.businessC1,"A1B1", instanceReturnMoneySignalDTO);
										}
									}
								}
							}
						}
					}
				}

				//判断此笔交易可否提升用户等级
				PayRecordDTO payRecordDTO = new PayRecordDTO();
				payRecordDTO.setStatus("1");
				payRecordDTO.setTransactionId(instanceReturnMoneySignalDTO.getTransactionId());
				List<PayRecordDTO> payRecordDTOList = payRecordService.getUserPayRecordList(payRecordDTO);

				float expenseMoney = 0;
				for(PayRecordDTO payRecord : payRecordDTOList)
				{
					expenseMoney = expenseMoney + payRecord.getAmount();
				}

				//判断，消费额度是否可以提升用户的等级
				if(ConfigConstant.businessC1.equals(userInfoDTO.getUserType()))
				{
					//如果是C用户
					if(expenseMoney>=ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE&&expenseMoney<=ConfigConstant.PROMOTE_B_LEVEL_MAX_EXPENSE)
					{
						//消费金额在B的区间段，升级为B
						promoteUserBusinessTypeForExpenseSecond(userInfoDTO,ConfigConstant.businessB1);
					}
					else if(expenseMoney>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
					{
						//消费金额在A的区间段，升级为A
						promoteUserBusinessTypeForExpenseSecond(userInfoDTO,ConfigConstant.businessA1);
					}
				}
				else if(ConfigConstant.businessB1.equals(userInfoDTO.getUserType()))
				{
					if(expenseMoney>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
					{
						//消费金额在A的区间段，升级为A
						promoteUserBusinessTypeForExpenseSecond(userInfoDTO,ConfigConstant.businessA1);
					}
				}

				//正常完成分账和升级处理后，关闭信号灯
				Query query = new Query().addCriteria(Criteria.where("status").is("0")).addCriteria(Criteria.where("transactionId").is(instanceReturnMoneySignalDTO.getTransactionId()));
				Update update = new Update();
				update.set("status","1");
				mongoTemplate.updateFirst(query,update,"instanceReturnMoneySignal");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
	}

	public void promoteUserBusinessTypeForExpenseSecond(UserInfoDTO userInfoDTO, String businessType) {

		//更新用户的级别
		userInfoDTO.setUserType(businessType);
		userDao.updateUserInfo(userInfoDTO);

		//更新user_business_type表的数据
		//1、把老级别变为失效
		UserBusinessTypeDTO userBusinessTypeDTO = new UserBusinessTypeDTO();
		userBusinessTypeDTO.setSysUserId(userInfoDTO.getId());
		userBusinessTypeDTO.setStatus("1");
		List<UserBusinessTypeDTO> userBusinessTypeDTOS = userService.getUserBusinessType(userBusinessTypeDTO);
		if(userBusinessTypeDTOS.size()==0)
		{
			return;
		}
		userBusinessTypeDTO = userBusinessTypeDTOS.get(0);
		userBusinessTypeDTO.setStatus("0");
		userService.updateUserBusinessType(userBusinessTypeDTO);

		//2、级别更新创建新的记录
		userBusinessTypeDTO = new UserBusinessTypeDTO();
		userBusinessTypeDTO.setId(UUID.randomUUID().toString());
		userBusinessTypeDTO.setParentUserId(userInfoDTO.getParentUserId());
		userBusinessTypeDTO.setSysUserId(userInfoDTO.getId());
		userBusinessTypeDTO.setUserType(businessType);
		userBusinessTypeDTO.setCreateDate(new Date());
		userBusinessTypeDTO.setStatus("1");
		userService.insertUserBusinessType(userBusinessTypeDTO);

	}

	public void updateReturnMoneyDataBase(String parentUserId, String userRuleType, String parentRuleType, InstanceReturnMoneySignalDTO instanceReturnMoneySignalDTO) {

		try{
			//计算提成给上一级用户ruleType对应店的钱
			PayRecordDTO payRecordDTO = new PayRecordDTO();
			payRecordDTO.setTransactionId(instanceReturnMoneySignalDTO.getTransactionId());
			payRecordDTO.setOutTradeNo(instanceReturnMoneySignalDTO.getOutTradeNo());
			payRecordDTO.setSysUserId(instanceReturnMoneySignalDTO.getSysUserId());
			payRecordDTO.setStatus("1");
			List<PayRecordDTO> payRecordDTOList = payRecordService.getUserPayRecordList(payRecordDTO);

			float expenseAmount = 0;
			for(PayRecordDTO payRecord : payRecordDTOList)
			{
				expenseAmount = expenseAmount + payRecord.getAmount();
			}
			
			float returnMoney = 0;
			//逻辑先写死
			if(userRuleType.equals(ConfigConstant.businessC1))
			{
				if(parentRuleType.equals(ConfigConstant.businessA1)){

					if(expenseAmount>=ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE&&expenseAmount<=ConfigConstant.PROMOTE_B_LEVEL_MAX_EXPENSE)
					{
						returnMoney = ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE*10/100 + (expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE)*2/100;

						//记录月度交易流水
						float amount = expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE;;
						recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
					}
					else if(expenseAmount>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
					{
						returnMoney = ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE*5/100 + (expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)*2/100;

						//记录月度交易流水
						float amount = expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE;
						recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
					}
					else
					{
						returnMoney = expenseAmount * 2/100;

						//记录月度交易流水
						float amount = expenseAmount;
						recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
					}

				}
				else if(parentRuleType.equals(ConfigConstant.businessB1))
				{
					if(expenseAmount>=ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE&&expenseAmount<=ConfigConstant.PROMOTE_B_LEVEL_MAX_EXPENSE)
					{
						returnMoney = ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE*10/100 + (expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE)*10/100;

						//记录月度交易流水
						float amount = expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE;
						recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
					}
					else if(expenseAmount>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
					{
						returnMoney = ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE*5/100 + (expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)*10/100;

						//记录月度交易流水
						float amount = expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE;
						recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
					}
					else
					{
						returnMoney = expenseAmount * 10/100;

						//记录月度交易流水
						float amount = expenseAmount;
						recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
					}
				}
				else if(parentRuleType.equals("A1B1"))
				{
					if(expenseAmount>=ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE&&expenseAmount<=ConfigConstant.PROMOTE_B_LEVEL_MAX_EXPENSE)
					{
						returnMoney = (expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE)*2/100;

						//记录月度交易流水
						float amount = expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE;;
						recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
					}
					else if(expenseAmount>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
					{
						returnMoney = (expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)*2/100;

						//记录月度交易流水
						float amount = expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE;
						recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
					}
					else
					{
						returnMoney = expenseAmount * 2/100;

						//记录月度交易流水
						float amount = expenseAmount;
						recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
					}
				}
			}
			else if(userRuleType.equals(ConfigConstant.businessB1))
			{
				if(parentRuleType.equals(ConfigConstant.businessA1)){
					if(expenseAmount>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
					{
						returnMoney = ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE*5/100 + (expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)*2/100;

						//记录月度交易流水
						float amount = expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE;
						recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
					}
					else
					{
						returnMoney = expenseAmount * 2/100;

						//记录月度交易流水
						float amount = expenseAmount;
						recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
					}
				}
			}

			if(returnMoney>0)
			{
				//将returnMoney去更新要返现的用户ID的account和income两个表的数据
				AccountDTO accountDTO = accountService.getUserAccountInfo(parentUserId);
				if(accountDTO==null)
				{
					//为用户创建一个账户
					accountDTO = new AccountDTO();
					accountDTO.setId(UUID.randomUUID().toString());
					accountDTO.setSysUserId(parentUserId);

					UserInfoDTO userInfoDTO = new UserInfoDTO();
					userInfoDTO.setId(parentUserId);
					List<UserInfoDTO> userInfoDTOList = userService.getUserInfo(userInfoDTO);
					accountDTO.setUserOpenId(userInfoDTOList.get(0).getUserOpenid());

					accountDTO.setBalance((float)0.00);
					accountDTO.setScore((float)0.00);
					accountDTO.setStatus("normal");
					accountDTO.setUpdateDate(new Date());
					accountDTO.setBalanceDeny((float)0.00);
					accountService.createUserAccount(accountDTO);
				}
				float balance = accountDTO.getBalance() + returnMoney;
				float balanceDeny = accountDTO.getBalanceDeny() + returnMoney;
				accountDTO.setBalance(balance);
				accountDTO.setBalanceDeny(balanceDeny);
				accountDTO.setUpdateDate(new Date());
				accountService.updateUserAccountInfo(accountDTO);

				IncomeRecordDTO incomeRecordDTO = new IncomeRecordDTO();
				incomeRecordDTO.setId(UUID.randomUUID().toString());
				incomeRecordDTO.setSysUserId(parentUserId);
				incomeRecordDTO.setAmount(returnMoney);
				incomeRecordDTO.setCreateDate(new Date());
				incomeRecordDTO.setIncomeType("instance");
				incomeRecordDTO.setUpdateDate(new Date());
				incomeRecordDTO.setTransactionId(instanceReturnMoneySignalDTO.getTransactionId());
				incomeRecordDTO.setStatus("0");
				incomeRecordService.insertUserIncomeInfo(incomeRecordDTO);
			}

		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void recordMonthTransaction(String userId, InstanceReturnMoneySignalDTO instanceReturnMoneySignalDTO, float amount) {
		MonthTransactionRecordDTO monthTransactionRecordDTO = new MonthTransactionRecordDTO();
		monthTransactionRecordDTO.setId(UUID.randomUUID().toString());
		monthTransactionRecordDTO.setTransactionId(instanceReturnMoneySignalDTO.getTransactionId());
		monthTransactionRecordDTO.setAmount(amount);
		monthTransactionRecordDTO.setUserId(userId);
		monthTransactionRecordDTO.setCreateDate(new Date());
		monthTransactionRecordDTO.setUpdateDate(new Date());
		transactionDao.recordMonthTransaction(monthTransactionRecordDTO);
	}


	private static List<Map<String,String>> readExcel(File file){
		List<Map<String, String>>list =new ArrayList<Map<String,String>>();
		try {
			// 判断文件是否存在
			// 创建工作簿
			Workbook workbook = Workbook.getWorkbook(file);
			// 获得第一个工作表sheet1
			Sheet sheet = workbook.getSheet(0);
			// 获得数据
			for (int i = 1; i < sheet.getRows(); i++) {// sheet.getRows():获得表格文件行数
				Map<String, String>map = new HashMap<String, String>();
				for (int j = 0; j < sheet.getColumns(); j++) {// sheet.getColumns():获得表格文件列数
					Cell cell = sheet.getCell(j, i);
					//    System.out.print(cell.getContents() + " ");
					map.put(sheet.getCell(j,0).getContents(), cell.getContents());
					//(列，行)
				}
				//System.out.println("");// 换行
				list.add(map);
			}
			System.out.println(list);
			workbook.close();// 关闭
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
