package com.qiandaibaobao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class LoginTest{
	
	public static void main(String[] args) throws ParseException {
		String format = "yyyyMMdd";
		String date = "19890416";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		java.util.Date date2 = simpleDateFormat.parse(date);
        System.out.println("TimeZone.getDefault() = " + TimeZone.getDefault());
//        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
//        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println("date2 = " + date2);

    }

}
