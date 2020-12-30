package com.huade.Utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToDatetime {
    public Timestamp timeChanges(Date time){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_change = df.format(time);
        Timestamp timeChange = Timestamp.valueOf(time_change);
        return timeChange;
    }

    public static String getDate(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String time_change = dateFormat.format(date);
        return time_change;
    }
}

