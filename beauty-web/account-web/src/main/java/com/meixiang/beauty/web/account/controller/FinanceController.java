package com.meixiang.beauty.web.account.controller;


import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.account.AccountDTO;

import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.account.WithDrawRecordDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.product.TrainingProductDTO;
import com.meixiang.beauty.common.dto.system.*;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.dto.transaction.MonthTransactionRecordDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.common.utils.OSSObjectTool;
import com.meixiang.beauty.common.utils.excel.ExportExcel;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.modules.account.AccountService;
import com.meixiang.beauty.modules.account.IncomeRecordService;
import com.meixiang.beauty.modules.account.WithdrawService;
import com.meixiang.beauty.modules.product.api.TrainingProductService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.transaction.api.TransactionService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import com.meixiang.beauty.sys.utils.RandomNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "finance")
public class FinanceController extends BaseController {

    @Autowired
    private WithdrawService withdrawService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private IncomeRecordService incomeRecordService;

    @Autowired
    private TrainingProductService trainingProductService;

    /**
     * 查询所有提现数据
     * @param pageParamDTO
     * @return
     */
    @RequestMapping(value = "getAllWithdraw", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<WithDrawRecordDTO>>> getAllWithdraw(@RequestBody PageParamDTO<WithDrawRecordDTO> pageParamDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<WithDrawRecordDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<WithDrawRecordDTO>> page = withdrawService.queryAllWithdraw(pageParamDTO);
        responseDTO.setResponseData(page);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 提现审核
     * @param
     * @return
     */
    @RequestMapping(value = "updateWithdrawById", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO updateWithdrawById(@RequestBody PageParamDTO<WithDrawRecordDTO> pageParamDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try {
            withdrawService.updateWithdrawById(pageParamDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("提现审核通过");
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setResult(StatusConstant.FAILURE);
            responseDTO.setErrorInfo("提现审核拒绝");
        }
        return responseDTO;
    }

    /**
     * 根据条件查询提现信息
     * @param phoneAndIdentify 手机号或者身份证号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param type 0:时间不参与搜索 1:按申请时间 2：按提现时间
     * @return
     */
    @RequestMapping(value = "queryWithdrawsByParameters", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<WithDrawRecordDTO>>>  queryWithdrawsByParameters(@RequestParam String phoneAndIdentify,
                                                                                   @RequestParam String startTime,
                                                                                   @RequestParam String endTime,
                                                                                   @RequestParam String type,
                                                                                   @RequestParam Integer pageNo,
                                                                                   @RequestParam Integer pageSize) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<WithDrawRecordDTO>>> responseDTO = new ResponseDTO<>();
        String applyStartTime ="";
        String applyEndTime = "";
        String updateStartTime = "";
        String updateEndTime = "";
        String startDate = "1990-01-01";//设定起始时间
        if (!"0".equals(type)){
            if("1".equals(type)){
                applyStartTime = "".equals(startTime) ? startDate : startTime;
                applyEndTime = this.getEndDate(endTime);
            }else if("2".equals(type)){
                updateStartTime = "".equals(startTime) ? startDate : startTime;
                updateEndTime = this.getEndDate(endTime);
            }
        }
        PageParamDTO<List<WithDrawRecordDTO>> page =
                withdrawService.queryWithdrawsByParameters(phoneAndIdentify,applyStartTime,applyEndTime,updateStartTime,updateEndTime,pageNo,pageSize);

        responseDTO.setResponseData(page);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }



    /**
     * 查询所有用户及余额
     * @param pageParamDTO
     * @return
     */
    @RequestMapping(value = "queryAllUserBalance", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<AccountDTO>>> queryAllUserBalance(@RequestBody PageParamDTO pageParamDTO){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<AccountDTO>>> responseDTO = new ResponseDTO<>();

        PageParamDTO<List<AccountDTO>> page= accountService.queryAllUserBalance(pageParamDTO);

        responseDTO.setResponseData(page);

        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据条件查询余额信息
     * @param phoneAndIdentify 手机号或者身份证号
     * @return
     */
    @RequestMapping(value = "queryUserBalanceByParameters", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<AccountDTO>>>  queryUserBalanceByParameters(@RequestParam String phoneAndIdentify,
                                                                              @RequestParam Integer pageNo,
                                                                              @RequestParam Integer pageSize) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<AccountDTO>>> responseDTO = new ResponseDTO<>();

        PageParamDTO<List<AccountDTO>> page =
                accountService.queryUserBalanceByParameters(phoneAndIdentify,pageNo,pageSize);

        responseDTO.setResponseData(page);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }


    /**
     * 查询所有提成信息
     * @return
     */
    @RequestMapping(value = "queryAllUserIncome", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<IncomeRecordDTO>>> queryAllUserIncome(@RequestBody PageParamDTO pageParamDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<IncomeRecordDTO>>> responseDTO = new ResponseDTO<>();

        PageParamDTO<List<IncomeRecordDTO>> page = incomeRecordService.queryAllUserIncome(pageParamDTO);
        responseDTO.setResponseData(page);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 审核月结   是否可提现
     * @return
     */
    @RequestMapping(value = "updateIncomeRecordStatusById", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<IncomeRecordDTO>>> updateIncomeRecordStatusById(@RequestBody PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();

        try{
            incomeRecordService.updateIncomeRecordStatusById(pageParamVoDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("更新月结是否可提现成功");
        }catch (Exception e){
            responseDTO.setErrorInfo("更新月结是否可提现失败");
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;

    }

    /**
     * 查询即时返现和统计推荐下的订单详情
     * @return
     */
    @RequestMapping(value = "queryInstanceInfoByTransactionId", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<PayRecordDTO>>> queryInstanceInfoByTransactionId(@RequestBody PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        pageParamVoDTO.setEndTime(this.getEndDate(pageParamVoDTO.getEndTime()));
        ResponseDTO<PageParamDTO<List<PayRecordDTO>>> responseDTO = new ResponseDTO<>();

        PageParamDTO<List<PayRecordDTO>> page = incomeRecordService.queryInstanceInfoByTransactionId(pageParamVoDTO);
        responseDTO.setResponseData(page);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 查询月度结算下级消费的详情
     * @return
     */
    @RequestMapping(value = "queryMonthTransactionRecordByIncomeRecord", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<MonthTransactionRecordDTO>>> queryMonthTransactionRecordByIncomeRecord(@RequestBody PageParamVoDTO<IncomeRecordDTO> page) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        page.setEndTime(this.getEndDate(page.getEndTime()));
        ResponseDTO<PageParamDTO<List<MonthTransactionRecordDTO>>> responseDTO = new ResponseDTO<>();

        PageParamDTO<List<MonthTransactionRecordDTO>> monthTransactionRecordDTOList = incomeRecordService.queryMonthTransactionRecordByIncomeRecord(page);
        responseDTO.setResponseData(monthTransactionRecordDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据用户id查询这个月都消费了哪些订单
     * @return
     */
    @RequestMapping(value = "queryMonthPayRecordByUserId", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<PayRecordDTO>>> queryMonthPayRecordByUserId(@RequestBody PageParamVoDTO<IncomeRecordDTO> page) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        page.setEndTime(this.getEndDate(page.getEndTime()));
        ResponseDTO<PageParamDTO<List<PayRecordDTO>>> responseDTO = new ResponseDTO<>();

        PageParamDTO<List<PayRecordDTO>> payRecordDTOList = incomeRecordService.queryMonthPayRecordByUserId(page);
        responseDTO.setResponseData(payRecordDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据条件查询提成信息
     * @param phoneAndIdentify 手机号或者身份证号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    @RequestMapping(value = "queryUserIncomeByParameters", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<IncomeRecordDTO>>> queryUserIncomeByParameters(@RequestParam String phoneAndIdentify,
                                                                                 @RequestParam String incomeType,
                                                                                 @RequestParam String startTime,
                                                                                 @RequestParam String endTime,
                                                                                 @RequestParam Integer pageNo,
                                                                                 @RequestParam Integer pageSize) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<IncomeRecordDTO>>> responseDTO = new ResponseDTO<>();
        String applyStartTime ="";
        String applyEndTime = "";
        String startDate = "1990-01-01";//设定起始时间
        applyStartTime = "".equals(startTime) ? startDate : startTime;
        applyEndTime = this.getEndDate(endTime);
        PageParamDTO<List<IncomeRecordDTO>> page = incomeRecordService.queryUserIncomeByParameters(phoneAndIdentify,incomeType,applyStartTime,applyEndTime,pageNo,pageSize);

        responseDTO.setResponseData(page);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据条件查询账单信息
     * @param transactionIdOrOrderId 账单编号或者订单编号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param type 0:时间不参与搜索 1：按付款时间: 2：按完成时间
     * @return
     */
    @RequestMapping(value = "queryPayRecordsByParameters", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<PayRecordDTO>>>  queryPayRecordsByParameters(@RequestParam String transactionIdOrOrderId,
                                                                              @RequestParam String startTime,
                                                                              @RequestParam String endTime,
                                                                              @RequestParam String type,
                                                                              @RequestParam Integer pageNo,
                                                                              @RequestParam Integer pageSize) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<PayRecordDTO>>> responseDTO = new ResponseDTO<>();
        String applyStartTime ="";
        String applyEndTime = "";
        String updateStartTime = "";
        String updateEndTime = "";
        String startDate = "1990-01-01";//设定起始时间
        if (!"0".equals(type)){
            if("1".equals(type)){
                applyStartTime = "".equals(startTime) ? startDate : startTime;
                applyEndTime = this.getEndDate(endTime);
            }else if("2".equals(type)){
                updateStartTime = "".equals(startTime) ? startDate : startTime;
                updateEndTime = this.getEndDate(endTime);
            }
        }
        PageParamDTO<List<PayRecordDTO>> page =
                transactionService.queryPayRecordsByParameters(transactionIdOrOrderId,applyStartTime,applyEndTime,updateStartTime,updateEndTime,pageNo,pageSize);

        responseDTO.setResponseData(page);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据条件查询人员List
     * @return
     */
    @RequestMapping(value = "queryUserInfoDTOByParameters", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<UserInfoDTO>>>  queryUserInfoDTOByParameters(@RequestBody PageParamVoDTO<UserInfoDTO> pageParamVoDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<UserInfoDTO>>> responseDTO = new ResponseDTO<>();


        String startDate = "1990-01-01";//设定起始时间
        pageParamVoDTO.setStartTime("".equals(pageParamVoDTO.getStartTime()) ? startDate : pageParamVoDTO.getStartTime());
        pageParamVoDTO.setEndTime(this.getEndDate(pageParamVoDTO.getEndTime()));
        PageParamDTO<List<UserInfoDTO>> page =
                userService.queryUserInfoDTOByParameters(pageParamVoDTO);
        responseDTO.setResponseData(page);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据id查询下级代理
     * @return
     */
    @RequestMapping(value = "queryNextUserById", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<UserInfoDTO>>>  queryNextUserById(@RequestParam String sysUserId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<UserInfoDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<UserInfoDTO>> userInfoDTOs = userService.queryNextUserById(sysUserId);
        responseDTO.setResponseData(userInfoDTOs);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据id查询等级详情
     * @return
     */
    @RequestMapping(value = "queryUserBusinessById", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<UserBusinessTypeDTO>>>  queryUserBusinessById(@RequestParam String sysUserId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<UserBusinessTypeDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<UserBusinessTypeDTO>> userBusinessTypeDTOs = userService.queryUserBusinessById(sysUserId);
        responseDTO.setResponseData(userBusinessTypeDTOs);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }


    /**
     * 条件查询查询订单
     * @return
     */
    @RequestMapping(value = "queryBusinessOrderByParameters", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamVoDTO<List<BusinessOrderDTO>>>  queryBusinessOrderByParameters(@RequestBody PageParamVoDTO<BusinessOrderDTO> pageParamVoDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamVoDTO<List<BusinessOrderDTO>>> responseDTO = new ResponseDTO<>();


        String startDate = "1990-01-01";//设定起始时间
        if (!"0".equals(pageParamVoDTO.getTimeType())){
            if("1".equals(pageParamVoDTO.getTimeType())){
                pageParamVoDTO.setStartTime("".equals(pageParamVoDTO.getStartTime()) ? startDate : pageParamVoDTO.getStartTime());
                pageParamVoDTO.setEndTime(this.getEndDate(pageParamVoDTO.getEndTime()));
            }else if("2".equals(pageParamVoDTO.getTimeType())){
                pageParamVoDTO.setStartTime("".equals(pageParamVoDTO.getStartTime()) ? startDate : pageParamVoDTO.getStartTime());
                pageParamVoDTO.setEndTime(this.getEndDate(pageParamVoDTO.getEndTime()));
            }
        }
        PageParamVoDTO<List<BusinessOrderDTO>> page =
                transactionService.queryBusinessOrderByParameters(pageParamVoDTO);

        if("Y".equals(pageParamVoDTO.getIsExportExcel())){
            try{
            String[] orderHeaders =
                    {"订单编号ID","用户id","用户名","用户手机号", "付款时间", "变更时间"
                            , "订单状态", "id", "订单地址id", "订单商品id", "订单类型", "创建时间"
                            , "商品数量", "商品名字", "商品图片url", "商品价格", "此订单订单价格", "收货人姓名"
                            , "收货人联系方式", "收货地址", "商品型号", "身份证号", "senderAddress"};
            ExportExcel<BusinessOrderDTO> ex = new ExportExcel<>();
            ByteArrayInputStream in = ex.getWorkbookIn("订单EXCEL文档",orderHeaders, page.getResponseData(),"yyy-MM-dd");
            String url = orderExcelToOSS(in);
            responseDTO.setResult(url);
            responseDTO.setErrorInfo(StatusConstant.SUCCESS);
            }catch (Exception e){
                e.printStackTrace();
                responseDTO.setErrorInfo(StatusConstant.FAILURE);
            }
            return responseDTO;
        }

        responseDTO.setResponseData(page);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 查询所有订单
     * @return
     */
    @RequestMapping(value = "queryAllBusinessOrders", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<BusinessOrderDTO>>>  queryAllBusinessOrders(@RequestBody PageParamVoDTO<BusinessOrderDTO> pageParamVoDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<BusinessOrderDTO>>> responseDTO = new ResponseDTO<>();

        PageParamDTO<List<BusinessOrderDTO>> page =
                transactionService.queryAllBusinessOrders(pageParamVoDTO);
        responseDTO.setResponseData(page);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }
    /**
     * 订单详情
     * @param
     * @return
     */
    @RequestMapping(value = "queryOrderDetailsById", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<BusinessOrderDTO> queryOrderDetailsById(@RequestParam String orderId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<BusinessOrderDTO> responseDTO = new ResponseDTO<>();
        BusinessOrderDTO businessOrderDTO = transactionService.queryOrderDetailsById(orderId);
        responseDTO.setResponseData(businessOrderDTO);
        responseDTO.setErrorInfo(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 修改订单收货地址
     *
     * input PageParamDto
     *
     * output ResponseDTO
     *
     */
    @RequestMapping(value = "updateOrderAddress", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO updateOrderAddress(@RequestBody UserOrderAddressDTO userOrderAddressDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try{
            transactionService.updateOrderAddress(userOrderAddressDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("更新用户收货地址成功");
        }catch (Exception e){
            responseDTO.setErrorInfo("更新用户收货地址失败");
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }

    /**
     * 查询所有视频
     * @return
     */
    @RequestMapping(value = "queryAllTrainingProductDTO", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<TrainingProductDTO>>> queryAllTrainingProductDTO(@RequestBody PageParamDTO pageParamDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamDTO<List<TrainingProductDTO>>> responseDTO = new ResponseDTO<>();

        PageParamDTO<List<TrainingProductDTO>> page =
                trainingProductService.queryAllTrainingProductDTO(pageParamDTO);

        responseDTO.setResponseData(page);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }
    /**
     * 获取向后一天的日期
     * @return
     */
    public String getEndDate(String endTime){
        if( endTime == null || "".equals(endTime)){
            endTime = DateUtils.getDate();//设定当前时间
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = DateUtils.StrToDate(endTime,"date");//string转Date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,+1);//当前日期加一
        String endData = dateFormat.format(calendar.getTime());//结束时间
        return endData;
    }

    /**
     * 上传Excel到OSS
     * @param in
     * @return
     */
    public String orderExcelToOSS(ByteArrayInputStream in) {
        int i = in.available();
        Long length = (long) i;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = dateFormat.format(new Date());
        String random = RandomNumberUtil.getFourRandom();
        String bucketName = "mxexcel";
        String folder = "orderExcel/";
        String fileName = folder + time + random + ".xls";
        //上传OSS
        String url = OSSObjectTool.uploadFileInputStream(fileName, length, in, bucketName);
        return url;
    }
}
