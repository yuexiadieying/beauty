package com.meixiang.beauty.common.utils;

import com.meixiang.beauty.common.dto.product.ProductCodeDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/12/13.
 */
public class ProductCodeTool {
    private static final String PRODUCT_CODE="E";
    private static final String DELIVER_ADDRESS="S";//  S(深圳)/B(北京)
    private static final String ALLCHAR = "0123456789";
    private static MongoTemplate mongoTemplate;


    /**
     * 随机生成5位数字的字符串
     * @param length
     * @return
     */
    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }

}
