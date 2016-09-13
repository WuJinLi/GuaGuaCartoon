package com.wu.my.guagua.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将字符串的是时间值转换成时间格式
 */
public class DataFormat {

    public static String dataFormat(String strDate){
        long timeLong = Long.parseLong(strDate) * 1000;
        Date date = new Date(timeLong);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);

    }
}
