package com.meixiang.beauty.webapp.traffic.utils;

import org.bouncycastle.util.Strings;

import java.text.DecimalFormat;
import java.util.Objects;

public class NumUtil {

    public static String format2W(Double num) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return String.valueOf(df.format(num));
    }

    public static void main(String[] args) {
        System.out.println(format2W(123.120032));
    }

    public static String caculateHB(Double pre, Double now) {
        if (Objects.isNull(pre) && Objects.isNull(now)) {
            return "--";
        } else if (Objects.isNull(pre) && !Objects.isNull(now)) {
            return "100%";
        } else if (!Objects.isNull(pre)) {
            Double res = (now - pre) * 100 / pre;
            return format2W(res);
        }
        return "--";
    }

    public static String caculateDValue(Double pre, Double now) {
        if (Objects.isNull(pre)) {
            pre = 0.0D;
        }
        if (Objects.isNull(now)) {
            now = 0.0D;
        }
        return format2W(pre - now);
    }
}
