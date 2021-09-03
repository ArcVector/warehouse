/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.common.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DataUtils {
    
    public static final ZoneId ZONE_ID =  ZoneId.systemDefault();
    
    public static LocalDateTime localDateTimeOf(Date date)
    {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZONE_ID);
    }
    
    public static LocalDate localDateOf(Date date)
    {
        return localDateTimeOf(date).toLocalDate();
        
    }
    
    public static Date plusDays(Date date, Integer days)
    {
        LocalDate nextLocalDate = localDateOf(date).plusDays(days);
        return Date.from(nextLocalDate.atStartOfDay(ZONE_ID).toInstant());
        
    }
}
