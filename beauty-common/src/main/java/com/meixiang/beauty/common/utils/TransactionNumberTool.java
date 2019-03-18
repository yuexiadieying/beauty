package com.meixiang.beauty.common.utils;

import com.meixiang.beauty.common.dto.product.ProductCodeDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.transaction.TransactionCodeDTO;
import com.meixiang.beauty.common.dto.transaction.TransactionDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/12/13.
 */
public class TransactionNumberTool {

   /* private static final String SERIAL_NUMBER = "20171213019087636784";*/
    private static final String ALLCHAR = "0123456789";
    private static MongoTemplate mongoTemplate;

    /**
     * 随机生成10位数字的字符串
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
