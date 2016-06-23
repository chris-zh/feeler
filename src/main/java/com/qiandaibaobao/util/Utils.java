package com.qiandaibaobao.util;

import com.qiandaibaobao.pojo.User;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/12 0012.
 */
public class Utils {
    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static final DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static String SEPARATOR = " ";
    /**
     * 对象是否不为空
     * @param object
     * @return true 是 false 空
     */
    public static boolean isNotNull(Object object){
        return object != null;
    }

    /**
     * 打印日志
     * @param objects
     */
    public static void log(Object...objects){
        StringBuilder sb = new StringBuilder();
        sb.append(df.format(new Date())).append(SEPARATOR).append("\n");
        for (Object obj : objects) {
            sb.append(obj.toString()).append(SEPARATOR);
        }
        sb.append("\n").append(df.format(new Date()));
        System.out.println(sb.toString());
    }

    /**
     * 获得异常的堆栈字符串
     * @param e
     * @return
     */
    public static String getStackTrace(Exception e) {
        StackTraceElement[] elements = e.getStackTrace();
        StringBuilder builder = new StringBuilder();
        for (StackTraceElement element : elements) {
            builder.append(element).append("\n");
        }
        builder.append("异常信息：").append(e.getMessage());
        return builder.toString();
    }

    /**
     * 给密码做md5加密
     * @param password
     * @return
     */
    private static String md5(String password) {
        MessageDigest md;
        String md5Password = null;
        try {
            // 生成一个MD5加密计算摘要
            md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            md5Password = new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5Password;
    }

    /**
     * 用md5加密密码
     * @param password
     * @return
     */
    public static String encrypt(String password, String salt) {
        return md5(confusion(password, salt));
    }

    /**
     * 混淆算法
     * @param str1
     * @param str2
     * @return
     */
    private static String confusion(String str1, String str2) {
        return str1 + str2;
    }

    /**
     * 当前盐值
     * 用当前时间作盐
     * @return
     */
    public static String newSalt() {
       String baseSalt = df.format(new Date());
        return md5(baseSalt);
    }

    /**
     * 从session中获得User
     * @param session
     * @return
     */
    public static User sessionUser(HttpSession session) {
        Object u = session.getAttribute("user");
        if (isNotNull(u)) {
            return (User)u;
        }else{
            return new User();
        }
    }
}