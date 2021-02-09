package com.isa.pharmacy.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {
    private static final Logger logger = LoggerFactory.getLogger(DateConvert.class);

    public static Date mergeDateAndTime(Date date, Date time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date res = new Date();
        try {
            res = sdf.parse(getDateFromFullDate(date).toString() + " " + getTimeFromDate(time).toString());
        } catch (ParseException e) {
            logger.error("Error while parsing date to: yyyy-MM-dd HH:mm:ss");
        }
        return res;
    }

    public static Date getTimeFromDate(Date date){
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        Date res = new Date();
        try {
            res = sdfTime.parse(sdfTime.format(date));
        } catch (ParseException e) {
            logger.error("Error while parsing date to: HH:mm:ss");
        }
        return res;
    }

    public static Date getDateFromFullDate(Date date){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        Date res = new Date();
        try {
            res = sdfDate.parse(sdfDate.format(date));
        } catch (ParseException e) {
            logger.error("Error while parsing date to: yyyy-MM-dd");
        }
        return res;
    }
}
