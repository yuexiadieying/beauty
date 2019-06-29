package com.meixiang.beauty.webapp.traffic.utils;


import org.joda.time.DateTime;

public class DateUtil {
    public static String getNowYear() {
        DateTime now = new DateTime();
        return String.valueOf(now.getYear());
    }

    public static String getPreYear() {
        DateTime now = new DateTime();
        return String.valueOf(now.getYear() - 1);
    }
}
