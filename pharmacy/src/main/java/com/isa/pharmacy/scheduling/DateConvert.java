package com.isa.pharmacy.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {
    private static final Logger logger = LoggerFactory.getLogger(DateConvert.class);

    public static Date mergeDateAndTime(Date date, Date time){
        try {
            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String timeStr = new SimpleDateFormat("HH:mm:ss").format(time);
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse( dateStr + " " + timeStr);
        } catch (ParseException e) {
            logger.error("Error while parsing date to: yyyy-MM-dd HH:mm:ss");
            return null;
        }
    }
}
