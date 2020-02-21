package com.example.demo.server.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateUtils {
    public static final String pattern = "yyyy-MM-dd";

    public static final int MILLIS_IN_DAY = 24 * 60 * 60 * 1000;

    public static final String HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String formatter(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
