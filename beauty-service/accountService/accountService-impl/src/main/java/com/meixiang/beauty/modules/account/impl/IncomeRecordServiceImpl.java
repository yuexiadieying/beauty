package com.meixiang.beauty.modules.account.impl;

import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.transaction.MonthTransactionRecordDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.common.utils.FrontUtils;
import com.meixiang.beauty.modules.account.IncomeRecordService;
import com.meixiang.beauty.modules.account.dao.IncomeRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by sunxiao on 2017/6/26.
 */

@Service
@Transactional(readOnly = false)
public class IncomeRecordServiceImpl implements IncomeRecordService {

    @Autowired
    private IncomeRecordDao incomeRecordDao;

    @Override
    public List<IncomeRecordDTO> getUserIncomeInfoByDate(String userId, Date date) {
        List<IncomeRecordDTO> incomeRecordDTOS = incomeRecordDao.getUserIncomeInfoByDate(userId,date);
        return incomeRecordDTOS;
    }

    @Override
    public void insertUserIncomeInfo(IncomeRecordDTO incomeRecordDTO) {
        incomeRecordDao.insertUserIncomeInfo(incomeRecordDTO);
    }

    @Override
    public void updateIncomeInfo(IncomeRecordDTO incomeRecordDTO) {
        incomeRecordDao.updateIncomeInfo(incomeRecordDTO);
    }

    @Override
    public List<IncomeRecordDTO> getUserIncomeRecordInfo(IncomeRecordDTO incomeRecordDTO) {
        return  incomeRecordDao.getUserIncomeInfo(incomeRecordDTO);
    }

    @Override
    public PageParamDTO<List<IncomeRecordDTO>> queryUserIncomeByParameters(String phoneAndIdentify, String incomeType,
                                                                           String applyStartTime, String applyEndTime, Integer pageNo, Integer pageSize) {
        PageParamDTO<List<IncomeRecordDTO>> page = new  PageParamDTO<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int pageStartNo = (pageNo-1)*pageSize;
        int count = incomeRecordDao.queryUserIncomeCountByParameters(
                phoneAndIdentify,incomeType,applyStartTime,applyEndTime);
        page.setTotalCount(count);
        List<IncomeRecordDTO> commissionDTOList = incomeRecordDao.queryUserIncomeByParameters(
                phoneAndIdentify,incomeType,applyStartTime,applyEndTime,pageStartNo,pageSize);

        for(IncomeRecordDTO incomeRecordDTO : commissionDTOList){
            try {
                incomeRecordDTO.setNickName(URLDecoder.decode(incomeRecordDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        page.setResponseData(commissionDTOList);

        return page;
    }

    @Override
    public PageParamDTO<List<IncomeRecordDTO>> queryAllUserIncome(PageParamDTO pageParamDTO) {
        PageParamDTO<List<IncomeRecordDTO>> pageResult = new  PageParamDTO<>();
//        page.setPageNo(pageParamDTO.getPageNo());
//        page.setPageSize(pageParamDTO.getPageSize());

        String currentPage = String.valueOf(pageParamDTO.getPageNo());
        String pageSize = String.valueOf(pageParamDTO.getPageSize());
        Page<IncomeRecordDTO> page = FrontUtils.generatorPage(currentPage, pageSize);


       // int pageStartNo = (page.getPageNo()-1)*page.getPageSize();
        Page<IncomeRecordDTO> resultPage = incomeRecordDao.queryAllUserIncome(page);
        pageResult.setTotalCount((int)resultPage.getCount());
//        int count = incomeRecordDTOList.size();
//        pageResult.setTotalCount(count);
        pageResult.setResponseData(resultPage.getList());
        return pageResult;
    }


    @Override
    public List<IncomeRecordDTO> getUserIncomeRecordInfoByPage(String userId, PageParamDTO pageParamDTO) {
        return incomeRecordDao.getUserIncomeRecordInfoByPage(userId,pageParamDTO.getPageNo(),pageParamDTO.getPageSize());
    }

    @Override
    public IncomeRecordDTO getIncomeRecordDetail(String transactionId) {
        return incomeRecordDao.getIncomeRecordDetail(transactionId);
    }

    @Override
    public PageParamDTO<List<PayRecordDTO>> queryInstanceInfoByTransactionId(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        PageParamDTO<List<PayRecordDTO>> page = new  PageParamDTO<>();
        List<PayRecordDTO> payRecordDTOList = incomeRecordDao.queryInstanceInfoByTransactionId(pageParamVoDTO);
        for(PayRecordDTO payRecordDTO : payRecordDTOList){
            try {
                payRecordDTO.setNickName(URLDecoder.decode(payRecordDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        page.setResponseData(payRecordDTOList);
        return page;
    }

    @Override
    public PageParamDTO<List<MonthTransactionRecordDTO>> queryMonthTransactionRecordByIncomeRecord(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        PageParamDTO<List<MonthTransactionRecordDTO>> pageResult = new  PageParamDTO<>();
        if( pageParamVoDTO.getEndTime() == null || "".equals(pageParamVoDTO.getEndTime())){
            pageParamVoDTO.setEndTime(DateUtils.getDate());//设定当前时间
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = DateUtils.StrToDate(pageParamVoDTO.getEndTime(),"date");//string转Date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,-1);//当前月份减一
        calendar.add(Calendar.DAY_OF_MONTH,-2);//当前日期加一
        String startData = dateFormat.format(calendar.getTime());

        pageParamVoDTO.setStartTime(startData);

        String currentPage = String.valueOf(pageParamVoDTO.getPageNo());
        String pageSize = String.valueOf(pageParamVoDTO.getPageSize());
        Page<MonthTransactionRecordDTO> page = FrontUtils.generatorPage(currentPage, pageSize);
//        page.setStartTime(startData);
//        page.setEndTime(pageParamVoDTO.getEndTime());
//        page.getRequestData().setUserId(pageParamVoDTO.getRequestData().getSysUserId());

        Page<MonthTransactionRecordDTO> pageData = incomeRecordDao.queryMonthTransactionRecordByIncomeRecord(pageParamVoDTO,page);
        for(MonthTransactionRecordDTO monthTransactionRecordDTO : pageData.getList()){
            try {
                monthTransactionRecordDTO.setNickName(URLDecoder.decode(monthTransactionRecordDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        pageResult.setTotalCount((int)pageData.getCount());
        pageResult.setResponseData(pageData.getList());
        return pageResult;
    }

    @Override
    public PageParamDTO<List<PayRecordDTO>> queryMonthPayRecordByUserId(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        PageParamDTO<List<PayRecordDTO>> pageResult = new  PageParamDTO<>();
        if( pageParamVoDTO.getEndTime() == null || "".equals(pageParamVoDTO.getEndTime())){
            pageParamVoDTO.setEndTime(DateUtils.getDate());//设定当前时间
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = DateUtils.StrToDate(pageParamVoDTO.getEndTime(),"date");//string转Date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,-1);//当前月份减一
        calendar.add(Calendar.DAY_OF_MONTH,-2);//当前日期加一
        String startData = dateFormat.format(calendar.getTime());

        pageParamVoDTO.setStartTime(startData);

        String currentPage = String.valueOf(pageParamVoDTO.getPageNo());
        String pageSize = String.valueOf(pageParamVoDTO.getPageSize());
        Page<PayRecordDTO> page = FrontUtils.generatorPage(currentPage, pageSize);

        Page<PayRecordDTO> pageData = incomeRecordDao.queryMonthPayRecordByUserId(pageParamVoDTO,page);
        for(PayRecordDTO payRecordDTO : pageData.getList()){
            try {
                payRecordDTO.setNickName(URLDecoder.decode(payRecordDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        pageResult.setTotalCount((int)pageData.getCount());
        pageResult.setResponseData(pageData.getList());
        return pageResult;
    }

    @Override
    public void updateIncomeRecordStatusById(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        incomeRecordDao.updateIncomeRecordStatusById(pageParamVoDTO);
    }



}
