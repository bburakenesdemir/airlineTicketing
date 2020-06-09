package com.airline.ticketing.ticketer.util;

import org.omg.CORBA.BAD_PARAM;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

    public static Date toFlightDate(String dateStr) {
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf1 = new SimpleDateFormat(dateFormat);
        java.util.Date date;
        try {
            date = sdf1.parse(dateStr);
        } catch (ParseException e) {
            throw new BAD_PARAM("Date format must be : " + dateFormat);
        }
        return new java.sql.Date(date.getTime());
    }
}
