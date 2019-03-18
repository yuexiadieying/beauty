package com.meixiang.beauty.web.transaction.controller;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.dto.account.WithDrawRecordDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.transaction.*;

import com.meixiang.beauty.common.utils.JedisUtils;
import com.meixiang.beauty.common.utils.SpringContextHolder;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.modules.account.IncomeRecordService;
import com.meixiang.beauty.modules.account.PayRecordService;
import com.meixiang.beauty.modules.account.WithdrawService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.modules.transaction.api.TransactionService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

@Controller
@RequestMapping(value = "transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private WithdrawService withdrawService;

    @Autowired
    private IncomeRecordService incomeRecordService;

    @Autowired
    private UserService userService;

    @LoginRequired
    @RequestMapping(value ="putNeedPayOrderListToRedis",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResponseDTO putNeedPayOrderListToRedis(@RequestBody NeedPayOrderListDTO needPayOrderList) {
        ResponseDTO responseDTO = new ResponseDTO();
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        String needPayValue = (new Gson()).toJson(needPayOrderList);
        JedisUtils.del(userInfoDTO.getId()+"needPay");
        JedisUtils.set(userInfoDTO.getId()+"needPay",needPayValue,60*5);

        //将商品放入未支付订单列表
        for(NeedPayOrderDTO needPayOrderDTO:needPayOrderList.getNeedPayOrderList())
        {
            BusinessOrderDTO businessOrderDTO = new BusinessOrderDTO();
            businessOrderDTO.setBusinessProductId(needPayOrderDTO.getProductId());
            businessOrderDTO.setProductSpec(needPayOrderDTO.getProductSpec());
            businessOrderDTO = transactionService.getBusinessOrderByOrderId(needPayOrderDTO.getOrderId());
            businessOrderDTO.setStatus("0");
            try {
                transactionService.updateBusinessOrderStatus(businessOrderDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    @LoginRequired
    @RequestMapping(value ="getNeedPayOrderListToRedis",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResponseDTO<NeedPayOrderListDTO> getNeedPayOrderListToRedis() {
        ResponseDTO<NeedPayOrderListDTO> responseDTO = new ResponseDTO();
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        String value = JedisUtils.get(userInfoDTO.getId()+"needPay");
        NeedPayOrderListDTO needPayOrderListDTO = (new Gson()).fromJson(value, NeedPayOrderListDTO.class);
        if(needPayOrderListDTO==null)
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        else
        {
            responseDTO.setResponseData(needPayOrderListDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        return responseDTO;
    }

    @LoginRequired
    @RequestMapping(value ="getTransactionList",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResponseDTO<List<TransactionDTO>> getTransactionList(@RequestBody PageParamDTO pageParamDTO) {
        ResponseDTO<List<TransactionDTO>> responseDTO = new ResponseDTO();
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        List<TransactionDTO> transactionDTOList =  new ArrayList<>();
        List<IncomeRecordDTO> incomeRecordDTOS = incomeRecordService.getUserIncomeRecordInfoByPage(userInfoDTO.getId(),pageParamDTO);
        List<WithDrawRecordDTO> withDrawRecordDTOS = withdrawService.getWithdrawInfoByPage(userInfoDTO.getId(),pageParamDTO);

        for(IncomeRecordDTO incomeRecordDTO : incomeRecordDTOS)
        {
            TransactionDTO transactionDTO = new TransactionDTO();
            transactionDTO.setTransactionType(incomeRecordDTO.getIncomeType());
            transactionDTO.setAmount(incomeRecordDTO.getAmount());
            transactionDTO.setTransactionDate(incomeRecordDTO.getUpdateDate());
            transactionDTO.setTransactionId(incomeRecordDTO.getTransactionId());
            transactionDTO.setTransactionStatus(incomeRecordDTO.getStatus());
            transactionDTOList.add(transactionDTO);
        }
        for(WithDrawRecordDTO withDrawRecordDTO:withDrawRecordDTOS)
        {
            TransactionDTO transactionDTO = new TransactionDTO();
            transactionDTO.setTransactionType("withdraw");
            transactionDTO.setAmount(withDrawRecordDTO.getMoneyAmount());
            transactionDTO.setTransactionDate(withDrawRecordDTO.getUpdateDate());
            transactionDTO.setTransactionId(withDrawRecordDTO.getWithdrawId());
            transactionDTO.setTransactionStatus(withDrawRecordDTO.getStatus());
            transactionDTOList.add(transactionDTO);
        }

        //快速排序
        Collections.sort(transactionDTOList, new Comparator<TransactionDTO>() {
            @Override
            public int compare(TransactionDTO p1, TransactionDTO p2) {
                return (p1.getTransactionDate().getTime() - p2.getTransactionDate().getTime())>0?1:0;
            }
        });

        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(transactionDTOList);
        return responseDTO;
    }

    @LoginRequired
    @RequestMapping(value ="getUserTransactionDetail",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResponseDTO<TransactionDTO> getUserTransactionDetail(@RequestParam String transactionId,@RequestParam String transactionType) {
        ResponseDTO<TransactionDTO> responseDTO = new ResponseDTO();

        if(transactionType.equals("withdraw"))
        {
            WithDrawRecordDTO withDrawRecordDTO = withdrawService.getWithdrawDetail(transactionId);
            if(withDrawRecordDTO==null)
            {
                responseDTO.setResult(StatusConstant.FAILURE);
            }else
            {
                TransactionDTO transactionDTO = new TransactionDTO();
                transactionDTO.setTransactionType("withdraw");
                transactionDTO.setAmount(withDrawRecordDTO.getMoneyAmount());
                transactionDTO.setTransactionDate(withDrawRecordDTO.getUpdateDate());
                transactionDTO.setTransactionId(withDrawRecordDTO.getWithdrawId());
                transactionDTO.setTransactionStatus(withDrawRecordDTO.getStatus());
                responseDTO.setResponseData(transactionDTO);
                responseDTO.setResult(StatusConstant.SUCCESS);
            }
        }
        else
        {
            IncomeRecordDTO incomeRecordDTO = incomeRecordService.getIncomeRecordDetail(transactionId);
            if(incomeRecordDTO==null)
            {
                responseDTO.setResult(StatusConstant.FAILURE);
            }
            else
            {
                TransactionDTO transactionDTO = new TransactionDTO();
                transactionDTO.setTransactionType(incomeRecordDTO.getIncomeType());
                transactionDTO.setAmount(incomeRecordDTO.getAmount());
                transactionDTO.setTransactionDate(incomeRecordDTO.getUpdateDate());
                transactionDTO.setTransactionId(incomeRecordDTO.getTransactionId());
                transactionDTO.setTransactionStatus(incomeRecordDTO.getStatus());
                responseDTO.setResponseData(transactionDTO);
                responseDTO.setResult(StatusConstant.SUCCESS);
            }
        }

        return responseDTO;
    }

    @RequestMapping(value ="getBusinessOrderByProductId",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResponseDTO<String> getBusinessOrderByProductId(@RequestParam String productId, HttpSession session, HttpServletRequest request) {
        ResponseDTO<String> responseDTO = new ResponseDTO<>();

        String openId = WeixinUtil.getOpenId(session,request);
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserOpenid(openId);
        List<UserInfoDTO> userInfoDTOS = userService.getUserInfo(userInfoDTO);
        if(userInfoDTOS.size()>0)
        {
            userInfoDTO = userInfoDTOS.get(0);
            List<BusinessOrderDTO> businessOrderDTOS = transactionService.getBusinessOrderByUserIdAndProductId(userInfoDTO.getId(),productId);
            if(businessOrderDTOS.size()>0)
            {
                responseDTO.setResult(StatusConstant.SUCCESS);
            }
            else
            {
                responseDTO.setResult(StatusConstant.FAILURE);
            }
        }
        else
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return  responseDTO;
    }

}
