package com.meixiang.beauty.common.utils.sms;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件读取类
 * Created by Administrator on 2017/12/12.
 */
public class LoadProperties {

    /**
     * 通过key值获取配置文件中value值
     * @description 方法描述
     * @param key 配置文件中key值
     * @return
     * @author xuzihu
     * @date 2015年9月9日
     */
    public static String readValue(String key) {
        String fileName = "/application.properties";
        Properties props = new Properties();
        InputStream in = null;
        String value = "";
        try {
            in = LoadProperties.class.getResourceAsStream(fileName);
            props.load(in);
            value = props.getProperty(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return value;
    }
}
