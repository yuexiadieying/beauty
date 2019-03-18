package com.meixiang.beauty.web.system.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.product.TrainingProductPlayStatisticDTO;
import com.meixiang.beauty.common.dto.system.ExportOrderExcelDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.utils.FrontUtils;
import com.meixiang.beauty.common.utils.OSSObjectTool;
import com.meixiang.beauty.common.utils.ProductCodeTool;
import com.meixiang.beauty.common.utils.RandomUtils;
import com.meixiang.beauty.common.utils.excel.ExportExcel;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.modules.system.api.OperationService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import com.meixiang.beauty.sys.utils.CodeGenUtil;
import com.meixiang.beauty.sys.utils.RandomNumberUtil;
import com.meixiang.beauty.sys.utils.UUIDUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "operation")
public class OperationController extends BaseController {

    @Autowired
    private OperationService operationService;

    /**
     * 分页查询所有商品
     * @param pageParamVoDTO
     * @return
     */
    @RequestMapping(value = "queryAllProducts", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamVoDTO<List<ProductDTO>>> queryAllProducts(@RequestBody PageParamVoDTO<ProductDTO> pageParamVoDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamVoDTO<List<ProductDTO>>> responseDTO = new ResponseDTO<>();
        PageParamVoDTO<List<ProductDTO>> page = operationService.queryAllProducts(pageParamVoDTO);
        responseDTO.setResponseData(page);
        responseDTO.setErrorInfo(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据id查询商品
     * @param productId  商品id
     * @return
     */
    @RequestMapping(value = "findProductById", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<ProductDTO> findProductById(@RequestParam String productId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<ProductDTO> responseDTO = new ResponseDTO<>();
        ProductDTO productDTO = operationService.findProductById(productId);
        responseDTO.setResponseData(productDTO);
        responseDTO.setErrorInfo(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 条件查询商品
     * @param pageParamVoDTO
     * @return
     */
    @RequestMapping(value = "queryProductsByParameters", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PageParamVoDTO<List<ProductDTO>>> queryProductsByParameters(@RequestBody PageParamVoDTO<ProductDTO> pageParamVoDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<PageParamVoDTO<List<ProductDTO>>> responseDTO = new ResponseDTO<>();
        PageParamVoDTO<List<ProductDTO>> page = operationService.queryProductsByParameters(pageParamVoDTO);
        responseDTO.setResponseData(page);
        responseDTO.setErrorInfo(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 编辑商品
     * @param productDTO
     * @return
     */
    @RequestMapping(value = "updateProductByParameters", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<ProductDTO> updateProductByParameters(@RequestBody ProductDTO<OfflineProductDTO> productDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try {
            operationService.updateProductByParameters(productDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("更新用户收货地址成功");
        }catch (Exception e){
            e.printStackTrace();
            responseDTO.setErrorInfo("更新用户收货地址失败");
            responseDTO.setResult(StatusConstant.FAILURE);
            //CodeGenUtil.getProductCodeNumber();
        }
        return responseDTO;
    }

    /**
     * 添加商品
     * @param productDTO
     * @return
     */
    @RequestMapping(value = "addOfflineProduct", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<ProductDTO> addOfflineProduct(@RequestBody ProductDTO<OfflineProductDTO> productDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        String productId = CodeGenUtil.getProductCodeNumber();
        String uuid = UUIDUtil.getUUID();
        try {
            productDTO.setId(uuid);
            productDTO.setProductId(productId);
            productDTO.getProductDetail().setProductId(productId);
            operationService.addOfflineProduct(productDTO);

            responseDTO.setErrorInfo(StatusConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setErrorInfo(StatusConstant.FAILURE);
        }

        return responseDTO;
    }

    /**
     * 编辑商品-上架
     * @param id
     * @return
     */
    @RequestMapping(value = "putAwayProductById", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO putAwayProductById(@RequestParam String id) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try {
            operationService.putAwayProductById(id);
            responseDTO.setErrorInfo(StatusConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setErrorInfo(StatusConstant.FAILURE);
        }
        return responseDTO;
    }

    /**
     * 编辑商品-下架
     * @param id
     * @return
     */
    @RequestMapping(value = "delProductById", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO delProductById(@RequestParam String id) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try {
            operationService.delProductById(id);
            responseDTO.setErrorInfo(StatusConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setErrorInfo(StatusConstant.FAILURE);
        }
        return responseDTO;
    }

    /**
     * 上传视频
     * @param
     * @return
     */
    @RequestMapping(value = "aviUploadToOSS", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO aviUploadToOSS(@RequestParam MultipartFile[] listFile) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();

        try{
            String url = operationService.aviUploadToSSO(listFile);
            responseDTO.setResult(url);
            responseDTO.setErrorInfo(StatusConstant.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            responseDTO.setErrorInfo(StatusConstant.FAILURE);
        }
        return responseDTO;
    }


    /**
     * 图片上传
     * @param
     * @return
     */
    @RequestMapping(value = "imageUploadToOSS", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO imageUploadToOSS(@RequestParam MultipartFile[] listFile,@RequestParam String folder) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<String> list = new ArrayList<>();
                try{
                    List<String> urlList = operationService.imageUploadToOSS(listFile,folder);
                    responseDTO.setResponseData(urlList);
                    responseDTO.setErrorInfo(StatusConstant.SUCCESS);
                }catch (Exception e){
                    e.printStackTrace();
                    responseDTO.setErrorInfo(StatusConstant.FAILURE);
                }

        return responseDTO;
    }

    /**
     * 导出excel到OSS
     * @param
     * @return
     */
    @RequestMapping(value = "exportExcelToOSS", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO exportExcelToSSO(@RequestBody PageParamVoDTO<ProductDTO> pageParamVoDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        ExportExcel<ExportOrderExcelDTO> ex = new ExportExcel<>();
        //String id = "";
        List<ExportOrderExcelDTO> list = operationService.selectExcelContent();
        //PageParamVoDTO<List<ProductDTO>> page = operationService.queryAllProducts(pageParamVoDTO);
//        List<ProductDTO> list = page.getResponseData();
        try{
            String[] headers =
                    {"订单编号","用户id","用户名","用户手机号", "付款时间", "商品品牌","商品编号", "商品名称", "商品规格", "商品数量"
                            ,"订单状态", "收货人姓名", "收货人电话",
                            "收货人详细地址", "订单金额", "是否要发票", "发票抬头", "纳税人识别号"};
            //OutputStream out = new FileOutputStream("D://ceshiExcel/a.xls");
            //ex.exportExcel(headers, list, out);
            ByteArrayInputStream in = ex.getWorkbookIn("代发货订单EXCEL文档",headers, list,"yyy-MM-dd");
//          InputStream in = new ByteArrayInputStream(workbook.getBytes());
            int i =in.available();
            Long length = (long)i;


            //
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String time = dateFormat.format(new Date());
            String random = RandomNumberUtil.getFourRandom();
            String bucketName = "mxexcel";
            String folder = "orderExcel/";
            String fileName =folder+time+random+".xls";

//            OSSObjectTool oss = new OSSObjectTool();
            //上传OSS
            String url = OSSObjectTool.uploadFileInputStream(fileName,length,in,bucketName);
//            operationService.updateStatus
            responseDTO.setResult(url);
            responseDTO.setErrorInfo(StatusConstant.SUCCESS);
            System.out.println("excel导出成功！");
            in.close();
        }catch (Exception e){
            e.printStackTrace();
            responseDTO.setErrorInfo(StatusConstant.FAILURE);
            System.out.println("excel导出失败！");
        }

        return responseDTO;
    }

}
