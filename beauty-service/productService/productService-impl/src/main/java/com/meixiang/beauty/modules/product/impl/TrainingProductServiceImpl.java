package com.meixiang.beauty.modules.product.impl;

import com.meixiang.beauty.common.dto.product.*;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.modules.product.api.ProductService;
import com.meixiang.beauty.modules.product.api.TrainingProductService;
import com.meixiang.beauty.modules.product.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zbm84 on 2017/7/24.
 */
@Service
@Transactional(readOnly = false)
public class TrainingProductServiceImpl implements TrainingProductService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ProductDao productDao;

    @Override
    public ProductDTO<TrainingProductDTO> getTrainingProductDetailById(String productId) {

        ProductDTO<TrainingProductDTO> productDTO = productDao.getBusinessProductInfo(productId,"training");

        //从mongodb库中获取培训课程详尽信息
        Query query = new Query().addCriteria(Criteria.where("productId").is(productId));
        TrainingProductDTO trainingProductDTO = mongoTemplate.findOne(query, TrainingProductDTO.class,"trainingProduct");
        productDTO.setProductDetail(trainingProductDTO);
        return productDTO;

    }

    @Override
    public List<ProductDTO> getTrainingProductList(PageParamDTO pageParamDTO) {
        List<ProductDTO> trainingProductDTOList = productDao.findTrainingProductList(pageParamDTO);
        return trainingProductDTOList;
    }

    @Override
    public int getTrainingProductPlayNum(String productId) {
        Query query = new Query().addCriteria(Criteria.where("productId").is(productId));
        List<TrainingProductPlayStatisticDTO> trainingProductPlayStatisticDTOS = mongoTemplate.find(query, TrainingProductPlayStatisticDTO.class,"trainingProductPlayStatistic");

        //从mongodb库中获取培训课程详尽信息
        query = new Query().addCriteria(Criteria.where("productId").is(productId));
        TrainingProductDTO trainingProductDTO = mongoTemplate.findOne(query, TrainingProductDTO.class,"trainingProduct");

        int num = 0;
        for(CourseDTO courseDTO:trainingProductDTO.getListCourse())
        {
            for(SecondCourseDTO secondCourseDTO:courseDTO.getList())
            {
                for(TrainingProductPlayStatisticDTO trainingProductPlayStatisticDTO:trainingProductPlayStatisticDTOS)
                {
                    if(secondCourseDTO.getUrl().equals(trainingProductPlayStatisticDTO.getUrl()))
                    {
                        num = num + trainingProductPlayStatisticDTO.getPlayNum();
                    }
                }
            }
        }
        return num;
    }

    @Override
    public void AddTrainingProductPlayNum(String productId, String playURL) {

        Query query = new Query().addCriteria(Criteria.where("productId").is(productId)).addCriteria(Criteria.where("url").is(playURL));
        TrainingProductPlayStatisticDTO trainingProductPlayStatisticDTO = mongoTemplate.findOne(query, TrainingProductPlayStatisticDTO.class,"trainingProductPlayStatistic");

        if(trainingProductPlayStatisticDTO==null)
        {
            trainingProductPlayStatisticDTO = new  TrainingProductPlayStatisticDTO();
            trainingProductPlayStatisticDTO.setPlayNum(1);
            trainingProductPlayStatisticDTO.setProductId(productId);
            trainingProductPlayStatisticDTO.setUrl(playURL);
            mongoTemplate.insert(trainingProductPlayStatisticDTO,"trainingProductPlayStatistic");
        }
        else
        {
            Update update = new Update();
            update.set("playNum",trainingProductPlayStatisticDTO.getPlayNum()+1);
            mongoTemplate.updateFirst(query,update,"trainingProductPlayStatistic");
        }
    }

    /**
     * 查询所有视频
     * @param pageParamDTO
     * @return
     */
    @Override
    public PageParamDTO<List<TrainingProductDTO>> queryAllTrainingProductDTO(PageParamDTO pageParamDTO) {
        PageParamDTO<List<TrainingProductDTO>> page = new  PageParamDTO<>();
        List<TrainingProductDTO> trainingProductDTO = mongoTemplate.findAll(TrainingProductDTO.class,"trainingProduct");
        page.setResponseData(trainingProductDTO);
        return page;
    }
}
