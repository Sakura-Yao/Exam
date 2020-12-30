package com.huade.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 获取当前时间
     * @return Date
     */
    public static Date getNow(){
        Date date_now = new Date();
        return date_now;
    }

    /**
     * 获取当前时间String
     * @return String
     */
    public static String getNow_String(){
        Date date_now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dateString = format.format(date_now);
        return dateString;
    }

}
