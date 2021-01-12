package com.problemfighter.pfspring.jwt.processor;

import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    public Date adjustDateTime(Integer adjustmentType, Integer adjustAmount){
        Calendar calendar = Calendar.getInstance();
        calendar.add(adjustmentType, adjustAmount);
        return calendar.getTime();
    }

    public Date adjustCurrentDateWithMinute(Integer adjustAmount){
        return adjustDateTime(Calendar.MINUTE, adjustAmount);
    }

    public Date adjustCurrentDateWithMonth(Integer adjustAmount){
        return adjustDateTime(Calendar.MONTH, adjustAmount);
    }

    public Date adjustCurrentDateWithSecond(Integer adjustAmount){
        return adjustDateTime(Calendar.SECOND, adjustAmount);
    }


    public Date adjustCurrentDateWithHour(Integer adjustAmount){
        return adjustDateTime(Calendar.HOUR, adjustAmount);
    }

    public Date adjustCurrentDateWithDay(Integer adjustAmount){
        return adjustDateTime(Calendar.DATE, adjustAmount);
    }

    public static DateHelper instance(){
        return new DateHelper();
    }
}
