package com.softserve.academy.dreamtour.utils;

import java.time.LocalDate;

public class DateUtils {

    public static LocalDate dateParser (String inputDate){
        LocalDate localDate = LocalDate.parse(inputDate);
        return localDate;
    }




}
