package com.softserve.academy.dreamtour.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DateUtils {

    public static LocalDate dateParser (String inputDate){
        LocalDate localDate = LocalDate.parse(inputDate);
        return localDate;
    }

    public Date addAWeek (String inputDate){

        return null;
    }



}
