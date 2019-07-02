package com.meixiang.beauty.webapp.traffic.utils;


import org.joda.time.DateTime;

import java.text.SimpleDateFormat;

public class DateUtil {

    private static String dayformat = "yyyyMMdd";
    private static String monthformat = "yyyyMM";

    public static String getNowYear() {
        DateTime now = new DateTime();
        return String.valueOf(now.getYear());
    }

    public static String getPreYear() {
        DateTime now = new DateTime();
        return String.valueOf(now.getYear() - 1);
    }

    /**
     * 获取当前月份
     * @return YYYYMM
     */
    public static String getNowMonth() {
        SimpleDateFormat formatMonth =
                new SimpleDateFormat(monthformat);
        DateTime now = new DateTime();
        return formatMonth.format(now.toDate());
    }


    /**
     * 获取当前月份
     * @return YYYYMM
     */
    public static String getPreMonth() {
        SimpleDateFormat formatMonth =
                new SimpleDateFormat(monthformat);
        DateTime preMonth = new DateTime().minusMonths(1);
        return formatMonth.format(preMonth.toDate());
    }

    public static String getMonthFrom(String date) {
        if ("".equalsIgnoreCase(date) || date == null) {
            return "";
        }
        date = date.replaceAll("-|_|/", "");
        int year = Integer.valueOf(date.substring(0,4));
        int month = Integer.valueOf(date.substring(4,6));
        int day = Integer.valueOf(date.substring(6));
        DateTime dateTime = new DateTime(year, month, day,0,0);

        SimpleDateFormat formatMonth =
                new SimpleDateFormat(monthformat);
        return formatMonth.format(dateTime.toDate());
    }

    public static String getPreMonthFrom(String date) {
        if ("".equalsIgnoreCase(date) || date == null) {
            return "";
        }
        date = date.replaceAll("-|_|/", "");
        int year = Integer.valueOf(date.substring(0,4));
        int month = Integer.valueOf(date.substring(4,6));
        int day = Integer.valueOf(date.substring(6));
        DateTime dateTime = new DateTime(year, month, day,0,0);

        SimpleDateFormat formatMonth =
                new SimpleDateFormat(monthformat);
        return formatMonth.format(dateTime.minus(1).toDate());
    }

    public static String getYearFrom(String date) {
        if ("".equalsIgnoreCase(date) || date == null) {
            return "";
        }
        date = date.replaceAll("-|_|/", "");
        return date.substring(0,4);
    }

    public static String getDayFrom(String date) {
        if ("".equalsIgnoreCase(date) || date == null) {
            return "";
        }
        date = date.replaceAll("-|_|/", "");
        return date;
    }

}
