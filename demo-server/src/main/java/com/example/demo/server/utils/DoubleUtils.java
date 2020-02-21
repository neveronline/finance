package com.example.demo.server.utils;


import java.text.DecimalFormat;

public class DoubleUtils {
    private DoubleUtils(){}

    public static Double convertMoney (Integer money) {
        Double tmp = money * 1.0 / 100;
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(tmp));
    }

    public static Integer convertMoney(Double money) {
        return (int)(money * 100);
    }

    public static Double convertInterest(Integer interest) {
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(convertMoney(123456));
    }
}
