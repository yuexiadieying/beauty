package com.meixiang.beauty.modules.system.impl;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.product.InvoiceDTO;
import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.product.TrainingProductPlayStatisticDTO;
import com.meixiang.beauty.common.dto.system.ExportOrderExcelDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.utils.FrontUtils;
import com.meixiang.beauty.common.utils.OSSObjectTool;
import com.meixiang.beauty.modules.system.api.OperationService;
import com.meixiang.beauty.modules.system.dao.OperationDao;
import com.meixiang.beauty.sys.utils.RandomNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationDao operationDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询所有商品
     * @param pageParamVoDTO
     * @return
     */
    @Override
    public PageParamVoDTO<List<ProductDTO>> queryAllProducts(PageParamVoDTO<ProductDTO> pageParamVoDTO) {
        PageParamVoDTO<List<ProductDTO>> pageResult = new  PageParamVoDTO<>();
        String currentPage = String.valueOf(pageParamVoDTO.getPageNo());
        String pageSize = String.valueOf(pageParamVoDTO.getPageSize());
        Page<ProductDTO> page = FrontUtils.generatorPage(currentPage, pageSize);
        Page<ProductDTO> resultPage = operationDao.queryAllProducts(page);
        pageResult.setTotalCount((int)resultPage.getCount());
        pageResult.setResponseData(resultPage.getList());
        return pageResult;
    }

    /**
     * 条件查询商品
     * @param pageParamVoDTO
     * @return
     */
    @Override
    public PageParamVoDTO<List<ProductDTO>> queryProductsByParameters(PageParamVoDTO<ProductDTO> pageParamVoDTO) {
        PageParamVoDTO<List<ProductDTO>> page = new  PageParamVoDTO<>();
        int count = operationDao.queryProductsCountByParameters(pageParamVoDTO);
        page.setTotalCount(count);
        List<ProductDTO> productDTOList = operationDao.queryProductsByParameters(pageParamVoDTO);

        /*for(WithDrawRecordDTO withDrawRecordDTO : withDrawRecordDTOList){
            try {
                withDrawRecordDTO.setNickName(URLDecoder.decode(withDrawRecordDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }*/
        page.setResponseData(productDTOList);

        return page;
    }

    /**
     * 根据id查询商品
     * @param productId
     * @return
     */
    @Override
    public ProductDTO findProductById(String productId) {

        Query query = new Query().addCriteria(Criteria.where("productId").is(productId));
        OfflineProductDTO offlineProductDTO = mongoTemplate.findOne(query, OfflineProductDTO.class,"offlineProduct");
        ProductDTO productDTO = operationDao.findProductById(productId);
        productDTO.setProductDetail(offlineProductDTO);
        return productDTO;
    }

    /**
     * 编辑商品
     * @param productDTO
     */
    @Override
    public void updateProductByParameters(ProductDTO<OfflineProductDTO> productDTO) {

        Query query = new Query().addCriteria(Criteria.where("productId").is(productDTO.getProductId()));

        Update update = new Update();
        update.set("tag",productDTO.getProductDetail().getTag());
        update.set("listPic",productDTO.getProductDetail().getListPic());
        update.set("services",productDTO.getProductDetail().getServices());
        update.set("spec",productDTO.getProductDetail().getSpec());
        update.set("detailPic",productDTO.getProductDetail().getDetailPic());
        update.set("senderAddress",productDTO.getProductDetail().getSenderAddress());
        mongoTemplate.updateFirst(query,update,"offlineProduct");

        operationDao.updateProductByParameters(productDTO);
    }

    /**
     * 编辑商品-上架
     * @param id
     */
    @Override
    public void putAwayProductById(String id) {
        operationDao.putAwayProductById(id);
    }
    /**
     * 编辑商品-下架
     * @param id
     */
    @Override
    public void delProductById(String id) {
        operationDao.delProductById(id);
    }

    @Override
    public String aviUploadToSSO(MultipartFile[] listFile) {

        String bucketName = "mxavi";
        String folder = "jmcpavi/";

        if(listFile.length >0) {
            for (MultipartFile file : listFile) {
                String originalFileName = file.getOriginalFilename();
                String fileName = originalFileName;

                try {
                    String url = OSSObjectTool.imageUploadToOSS(file, bucketName, folder, fileName);
                    return url;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public List<String> imageUploadToOSS(MultipartFile[] listFile, String folder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        List<String> urlList = new ArrayList<>();
        String bucketName = "mximage";
        if(listFile.length >0) {
            for (MultipartFile file : listFile) {
                String time = dateFormat.format(new Date());
                String random = RandomNumberUtil.getFourRandom();
                String originalFileName = file.getOriginalFilename();
                String fileName = time + random + originalFileName;

                try {
                    String url = OSSObjectTool.imageUploadToOSS(file, bucketName, folder, fileName);
                    urlList.add(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return urlList;
    }

    /**
     * 查询导出订单Excel信息
     * @return
     */
    @Override
    public List<ExportOrderExcelDTO> selectExcelContent() {
        List<ExportOrderExcelDTO> productDTOList = operationDao.selectExcelContent();
        for (ExportOrderExcelDTO exportOrderExcelDTO : productDTOList) {
            //修改订单为已发货
            operationDao.updateOrderStatusByExcelDTO(exportOrderExcelDTO);
            if("是".equals(exportOrderExcelDTO.getInvoice())){
                Query query = new Query().addCriteria(Criteria.where("orderId").is(exportOrderExcelDTO.getOrderId()));
                InvoiceDTO invoiceDTO = mongoTemplate.findOne(query, InvoiceDTO.class,"invoice");
                exportOrderExcelDTO.setCompanyName(invoiceDTO.getCompanyName());
                exportOrderExcelDTO.setTaxpayerNumber(invoiceDTO.getTaxpayerNumber());
            }
        }
        return productDTOList;
    }

    @Override
    public void addOfflineProduct(ProductDTO<OfflineProductDTO> productDTO) {
        mongoTemplate.insert(productDTO.getProductDetail(),"offlineProduct");
        operationDao.addOfflineProduct(productDTO);
    }
}
