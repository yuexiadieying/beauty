package com.meixiang.beauty.webapp.traffic.utils;

import org.bouncycastle.util.Strings;

import java.text.DecimalFormat;

public class NumUtil {

    public static String format2W(Double num) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return String.valueOf(df.format(num));
    }

    public static void main(String[] args) {
        System.out.println(format2W(123.120032));
    }
}
