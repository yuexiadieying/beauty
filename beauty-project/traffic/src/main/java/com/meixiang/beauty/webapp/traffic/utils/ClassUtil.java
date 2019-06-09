package com.meixiang.beauty.webapp.traffic.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WY on 2019/6/9.
 */
public class ClassUtil {

    public static Map<String, Object> toHashMap(Object o) {
        Map<String, Object> res = new HashMap<>();
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                res.put(field.getName(),field.get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
