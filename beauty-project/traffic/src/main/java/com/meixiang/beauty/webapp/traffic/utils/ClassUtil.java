package com.meixiang.beauty.webapp.traffic.utils;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

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

    public static Map<String, List<String>> toHashMap(Object o, String keyName, String... valueNames) {
        Map<String, List<String>> res = new HashMap<>();
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String key = "";
            try {
                if (keyName.equalsIgnoreCase(field.getName())) {
                    key = String.valueOf(field.get(o));
                    Set set = new HashSet();
                    set.addAll(Arrays.asList(valueNames));
                    List<String> values = Lists.newArrayList();
                    for (Field field1 : fields) {
                        if (set.contains(field.getName())) {
                            values.add(String.valueOf(field1.get(o)));
                        }
                    }
                    res.put(key, values);
                    break;
                }
                continue;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
