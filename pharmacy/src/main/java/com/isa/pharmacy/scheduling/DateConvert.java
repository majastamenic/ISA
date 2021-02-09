package com.isa.pharmacy.scheduling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");

    public static Date mergeDateAndTime(Date date, Date time){
        Date res = new Date();
        try {
            res = sdf.parse(getDateFromFullDate(date).toString() + " " + getTimeFromDate(time).toString());
        } catch (ParseException e) {
        }
        return res;
    }

    public static Date getTimeFromDate(Date date){
        Date res = new Date();
        try {
            res = sdfTime.parse(sdfTime.format(date));
        } catch (ParseException e) {
        }
        return res;
    }

    public static Date getDateFromFullDate(Date date){
        Date res = new Date();
        try {
            res = sdfDate.parse(sdfDate.format(date));
        } catch (ParseException e) {
        }
        return res;
    }
}
