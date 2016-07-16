package com.qiandaibaobao.util;

import com.google.gson.JsonObject;

/**
 * Created by chris.zhang on 16-7-16.
 */
public class JsonUtil {
    /**
     * 转换为Json
     * @param json
     * @return
     */
    public static JsonObject toJson(Object[] json) throws Exception {
        int length = json.length;
        if (length % 2 != 0) {
            throw new Exception("输入的json数组格式错误");
        }
        JsonObject jsonObject = new JsonObject();
        for(int i=0;i<length;i=i+2) {
            String key = String.valueOf(json[i]);
            String value = String.valueOf(json[i + 1]==null?"":json[i + 1]);
            jsonObject.addProperty(key, value);
        }
        return jsonObject;
    }
}
