package com.wm.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DateAndTimeFormat {
    Logger logger=Logger.getLogger(DateAndTimeFormat.class);

    public static List<String> getDate(){
        List<String> list=new ArrayList<>();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        for (int i=0;i<7;i++){
            list.add(simpleDateFormat.format(new Date(new Date().getTime()+i*24*60*60*1000)));
        }
        return list;
    }

    public static Timestamp getTimestamp(String date, String time){
        String timestampStr=date(date)+" "+time(time);
        Timestamp timestamp=Timestamp.valueOf(timestampStr);
        return timestamp;
    }


    public static Date getDate1(String newDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date= null;
        try {
            date=simpleDateFormat.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Timestamp dateTime_Lacal(String time) {
        char[] times = time.toCharArray();
        times[10] = ' ';
        String timeStr = "";
        for (int i = 0; i < times.length; i++) {
            timeStr += times[i];
        }
        timeStr += ":00";
        Timestamp dateTime = Timestamp.valueOf(timeStr);
        return dateTime;
    }

    private static String date(String date){
        //4 October, 2022
        //12:30 PM
        String monthStr=date.substring(date.indexOf(" ")+1,date.indexOf(","));
        System.out.println(monthStr);
        System.out.println(month(monthStr));

        String dateStr=date.substring(date.lastIndexOf(" ")+1)+"-"+month(monthStr)+"-"+date.substring(0,date.indexOf(" "));
        return dateStr;
    }
    private static int month(String monthEnglish){
        int monthnum=0;
        String [] monthEnglishs={"January","February","March","April","May","June","July","August","September","October","November","December"};
        for (int i=0;i<monthEnglishs.length;i++){
            if (monthEnglish.equals(monthEnglishs[i])){
                monthnum=i+1;
                break ;
            }
        }
        return monthnum;
    }
    private static String time(String time){
        String h=time.substring(time.indexOf(" ")+1);
        System.out.println(h);
        if (h.equals("AM")){
            return time.substring(0,time.indexOf(" "))+":00";
        }
        if (h.equals("PM")){
            if (Integer.valueOf(time.substring(0,time.indexOf(":")))==12){
                return "00"+time.substring(time.indexOf(":"),time.indexOf(" "))+":00";
            }
            return Integer.valueOf(time.substring(0,time.indexOf(":")))+12+time.substring(time.indexOf(":"),time.indexOf(" "))+":00";
        }
        return time;
    }

}
