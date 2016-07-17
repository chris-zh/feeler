package com.qiandaibaobao.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

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
//        String success = null;
//        Object[] json = {
//                "success",success,
//                "message", "成功",
//                "next", "/login",
//        };
//        JsonObject jsonObject = JsonUtil.toJson(json);
//        System.out.println("jsonObject = " + jsonObject);
        Object[] j = {};
        Map<String, Object> map = Maps.newHashMap();
        List<String> success = Lists.asList("Sdfsd",new String[]{"dd","sdfasdf"});

        map.put("success", success);
        map.put("message", "成功");
        map.put("next", "/login");
        Gson json = new Gson();
        String fuck = json.toJson(map);
        System.out.println(fuck);
    }

}