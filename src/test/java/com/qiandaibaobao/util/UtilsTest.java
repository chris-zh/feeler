package com.qiandaibaobao.util;

import com.google.gson.JsonObject;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by chris.zhang on 16-6-27.
 */
public class UtilsTest {
    @Test
    public void writeFile() throws Exception {
        Utils.writeFile(new File("D:\\My Documents\\桌面\\T1xkVdXlRqXXXXXXXX.jpg"),"F:\\feeler\\userfiles\\text.jpg");
    }


    public static void main(String[] args) throws Exception {
        String success = null;
        Object[] json = {
                "success",success,
                "message", "成功",
                "next", "/login",
        };
        JsonObject jsonObject = JsonUtil.toJson(json);
        System.out.println("jsonObject = " + jsonObject);
    }

}