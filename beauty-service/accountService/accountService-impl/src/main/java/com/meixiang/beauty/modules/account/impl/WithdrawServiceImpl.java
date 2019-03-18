package com.meixiang.beauty.modules.account.impl;

import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.account.WithDrawRecordDTO;
import com.meixiang.beauty.common.dto.product.TrainingProductDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.UserBankCardInfoDTO;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.transaction.TransactionDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.common.utils.FrontUtils;
import com.meixiang.beauty.common.utils.RedisLock;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.modules.account.WithdrawService;
import com.meixiang.beauty.modules.account.dao.AccountDao;
import com.meixiang.beauty.modules.account.dao.WithdrawDao;
import com.meixiang.beauty.modules.system.dao.UserDao;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.modules.system.util.WeixinTemplateMessageUtil;
import com.meixiang.beauty.sys.utils.CodeGenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = false)
public class WithdrawServiceImpl implements WithdrawService {

    @Autowired
    private WithdrawDao withdrawDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void updateWithdrawById(PageParamDTO<WithDrawRecordDTO> pageParamDTO) {

        String withdrawId = pageParamDTO.getRequestData().getWithdrawId();
        String status = pageParamDTO.getRequestData().getStatus();
        String openid = "";
        String token  = WeixinUtil.getToken();
        String moneyAmount = String.valueOf(pageParamDTO.getRequestData().getMoneyAmount());
        String time = DateUtils.getDateTime();

        withdrawDao.updateWithdrawById(withdrawId,status);
        if("2".equals(status)){//拒绝提现,提现金额返还余额
            AccountDTO accountDTO = accountDao.getUserAccountInfoByUserId(pageParamDTO.getRequestData().getSysUserId());
            Float money = accountDTO.getBalance();//用户余额
            Float balance = pageParamDTO.getRequestData().getMoneyAmount();//提现金额
            Float f = money + balance;
            accountDTO.setBalance(f);
            accountDao.updateUserAccountInfo(accountDTO);
            //发送提现失败消息模板
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setId(pageParamDTO.getRequestData().getSysUserId());
            List<UserInfoDTO> userInfoDTOList = userDao.getUserByInfo(userInfoDTO);
            for (UserInfoDTO userInfoDTO1 : userInfoDTOList) {
                openid = userInfoDTO1.getUserOpenid();
            }
            WeixinTemplateMessageUtil.sendWithDrawTemplateFailureMessage(moneyAmount,time,token,"",openid);
        }
    }

    @Override
    public PageParamDTO<List<WithDrawRecordDTO>> queryWithdrawsByParameters(String phoneAndIdentify,
                                                                            String applyStartTime,
                                                                            String applyEndTime,
                                                                            String updateStartTime,
                                                                            String updateEndTime,
                                                                            int pageNo,
                                                                            int pageSize) {
        PageParamDTO<List<WithDrawRecordDTO>> page = new  PageParamDTO<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int pageStartNo = (pageNo-1)*pageSize;
        int count = withdrawDao.queryWithdrawsCountByParameters(
                phoneAndIdentify,applyStartTime,applyEndTime,updateStartTime,updateEndTime);
        page.setTotalCount(count);
        List<WithDrawRecordDTO> withDrawRecordDTOList = withdrawDao.queryWithdrawsByParameters(
                phoneAndIdentify,applyStartTime,applyEndTime,updateStartTime,updateEndTime,pageStartNo,pageSize);

        for(WithDrawRecordDTO withDrawRecordDTO : withDrawRecordDTOList){
            try {
                withDrawRecordDTO.setNickName(URLDecoder.decode(withDrawRecordDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        page.setResponseData(withDrawRecordDTOList);

        return page;

    }

    @Override
    public PageParamDTO<List<WithDrawRecordDTO>> queryAllWithdraw(PageParamDTO pageParamDTO) {
        PageParamDTO<List<WithDrawRecordDTO>> pageResult = new  PageParamDTO<>();
//        int count = withdrawDao.getWithdrawCount();
//        pageParamDTO.setTotalCount(count);

        String currentPage = String.valueOf(pageParamDTO.getPageNo());
        String pageSize = String.valueOf(pageParamDTO.getPageSize());
        Page<WithDrawRecordDTO> page = FrontUtils.generatorPage(currentPage, pageSize);


        Page<WithDrawRecordDTO> resultPage = withdrawDao.queryAllWithdraw(page);
        for(WithDrawRecordDTO withDrawRecordDTO : resultPage.getList()){
            try {
                withDrawRecordDTO.setNickName(URLDecoder.decode(withDrawRecordDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        pageResult.setTotalCount((int)resultPage.getCount());
//        int count = incomeRecordDTOList.size();
//        pageResult.setTotalCount(count);
        pageResult.setResponseData(resultPage.getList());
       // pageParamDTO.setResponseData(withDrawRecordDTOList);

        return pageResult;
    }

    @Override
    public List<WithDrawRecordDTO> getWithdrawInfoByPage(String userId, PageParamDTO pageParamDTO) {
        return  withdrawDao.getWithdrawInfoByPage(userId,pageParamDTO.getPageNo(),pageParamDTO.getPageSize());
    }

    @Override
    public WithDrawRecordDTO getWithdrawDetail(String transactionId) {
        return withdrawDao.getWithdrawDetail(transactionId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void withDrawMoneyFromAccount(float moneyAmount, HttpServletRequest request, String openid, UserBankCardInfoDTO userBankCardInfoDTO)  throws Exception{

        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();

        AccountDTO accountDTO = accountDao.getUserAccountInfoByUserId(userInfoDTO.getId());

        //生成提现记录
        RedisLock withDrawRecordLock = new RedisLock("withDrawRecordLock");

        WithDrawRecordDTO withDrawRecordDTO = new WithDrawRecordDTO();
        try{

            withDrawRecordDTO.setId(UUID.randomUUID().toString());
            withDrawRecordDTO.setWithdrawId(CodeGenUtil.getTransactionCodeNumber());
            withDrawRecordDTO.setMoneyAmount(moneyAmount);
            withDrawRecordDTO.setStatus("0");
            withDrawRecordDTO.setSysUserId(userInfoDTO.getId());
            withDrawRecordDTO.setCreateDate(new Date());
            withDrawRecordDTO.setUpdateDate(new Date());
            withDrawRecordDTO.setUserOpenId(openid);
            withDrawRecordDTO.setUserAccountId(accountDTO.getId());
            withdrawDao.addWithDrawRecord(withDrawRecordDTO);

        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            withDrawRecordLock.unlock();
        }

        //扣除账户余额中的款项
        RedisLock userAccountLock = new RedisLock("userAccountLock");

        try{
            if((accountDTO.getBalance()-moneyAmount)<0)
            {
                throw new Exception();
            }
            else
            {
                accountDTO.setBalance(accountDTO.getBalance()-moneyAmount);
                accountDTO.setUpdateDate(new Date());
                accountDao.updateUserAccountInfo(accountDTO);
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            userAccountLock.unlock();
        }

        userBankCardInfoDTO.setWithDrawId(withDrawRecordDTO.getWithdrawId());
        mongoTemplate.insert(userBankCardInfoDTO,"userBankCardInfo");

        //公众号中的提现操作，moneyAmount为提现金额
//        Float returnMoney = moneyAmount*100;
//
//        //调用企业统一支付接口对用户进行退款
//        SortedMap<Object,Object> parameters = new TreeMap<>();
//        parameters.put("mch_appid", ConfigConstant.APP_ID);//APPid
//        parameters.put("mchid", ConfigConstant.MCH_ID);
//        parameters.put("nonce_str", IdGen.uuid());
//        parameters.put("partner_trade_no",IdGen.uuid());
//        parameters.put("check_name","NO_CHECK");
//        parameters.put("amount", returnMoney.toString());//金额
//        parameters.put("desc", "退款");
//        parameters.put("spbill_create_ip",request.getRemoteAddr());
//        parameters.put("openid", openid);
//        String sign = JsApiTicketUtil.createSign("UTF-8", parameters);
//        parameters.put("sign", sign);
//        String requestXML = JsApiTicketUtil.getRequestXml(parameters);
//        try{
//            String result =HttpRequestUtil.clientCustomSSLS(ConfigConstant.TRANSFERS, requestXML);
//            Map<String, String> returnMap = XMLUtil.doXMLParse(result);//解析微信返回的信息，以Map形式存储便于取值
//            if(!"SUCCESS".equals(returnMap.get("result_code"))){
//                throw new Exception();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            throw e;
//        }

//        Query query = new Query(Criteria.where("weixinFlag").is(ConfigConstant.weixinFlag));
//        WeixinTokenDTO weixinTokenDTO = this.mongoTemplate.findOne(query,WeixinTokenDTO.class,"weixinParameter");
//        String token = weixinTokenDTO.getToken();
//        BusinessMsgTemplate.withdrawalsSuccess2Weixin(openid,token,"",returnMoney.toString(),DateUtils.DateToStr(new Date(), "date"));
    }

}
