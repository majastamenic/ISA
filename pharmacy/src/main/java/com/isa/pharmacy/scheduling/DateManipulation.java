package com.isa.pharmacy.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateManipulation {

    private static final Logger logger = LoggerFactory.getLogger(DateManipulation.class);

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

    public static Date addMinutes(Date date, int minutes){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    public static Date subtractMinutes(Date date, int minutes){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, -minutes);
        return cal.getTime();
    }
}
