package com.hellozjf.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {
    public static void main(String[] args) throws Exception {
        String str = "08/16/2017 05:00:00 PM";
//        String[] d1 = str.split(" ");
//        String[] d2 = d1[0].split("/");
//        System.out.println("hellozjf date " + Arrays.toString(d2));
//        System.out.println(d2[2] + "-" + d2[0] + "-" + d2[1]);
        SimpleDateFormat formerDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", Locale.US);
        SimpleDateFormat needDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = formerDateFormat.parse(str);
        System.out.println(needDateFormat.format(d));
    }
}
