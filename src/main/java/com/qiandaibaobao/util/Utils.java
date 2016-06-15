package com.qiandaibaobao.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016/6/12 0012.
 */
public class Utils {
    /**
     * 字符串转换成UTF-8
     * @param str
     * @return
     */
    public static String utf8String(String str){
        String newStr = null;
        try {
            newStr = new String(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newStr;
    }
}
