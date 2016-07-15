package com.qiandaibaobao.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.qiandaibaobao.pojo.LoginForm;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chris.zhang on 16-7-15.
 */
public class JsonTest {
    public String userList(@RequestBody LoginForm form) {
        System.out.println("hahaha");
        System.out.println(form);
        System.out.println(form.getUsername());
        System.out.println(form.getPassword());
        Gson json = new Gson();
        JsonObject r = new JsonObject();
        r.addProperty("success", "True");
//        String r = {
//                'success': True;
//        }


        String success = "True";
//        JsonElement jSuccess = json.toJson(success);
        JsonObject jSuccess = new JsonObject();
        jSuccess.addProperty("success", "True");
        jSuccess.addProperty("fail", "False");

        List<String> list = Arrays.asList("you", "me", "haha");

        JsonArray jsonArray = new JsonArray();
//        String haha = json.toJson(list);
        jsonArray.add(jSuccess);

        JsonObject finalJson = new JsonObject();
        finalJson.add("fuck", jsonArray);
//        finalJson.add("hehe", haha);
        finalJson.add("keke", jSuccess);
//                String jsonStr = json.toJson(form);
        return success;
    }
}
