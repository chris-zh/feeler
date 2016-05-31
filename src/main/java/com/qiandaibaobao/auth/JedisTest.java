package com.qiandaibaobao.auth;

import io.protostuff.runtime.RuntimeSchema;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/29 0029.
 */
public class JedisTest {



    private static Jedis jedis = new Jedis("121.42.149.46",6379);
    public static void main(String[] args){
        Jedis jedis =JedisTest.jedis;
        jedis.auth("redis");
        Emp emp = new Emp();
        emp.setEmpId(1);
        emp.setEmpName("张三");
        emp.setEmpNo("0001");
        emp.setOrganId("101");
        emp.setPassword("zhangsanm101");
        String key = "emp:" + emp.getEmpId();


    }
//    private static RuntimeSchema schema =

    private static void testList(Jedis jedis) {
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        System.out.println(jedis.lrange("java framework", 0, -1));
        jedis.rpush("java framework", "spring");
        jedis.set("newname", "中文测试");
        System.out.println(jedis.get("newname"));

    }

    public static void testString(Jedis jedis){
        jedis.set("userName", "chris.zhang");
        System.out.println(jedis.get("userName"));
        jedis.append("userName", " zhangxh");
        System.out.println(jedis.get("userName"));
        jedis.del("userName");
        System.out.println(jedis.get("userName"));
        System.out.println("jedis.get(\"userName\") = " + jedis.get("userName"));
        jedis.mset("name","chris.zhang","age","18");
        jedis.incr("age");
        System.out.println(jedis.get("age"));
    }
    private static void testMap(Jedis jedis){
        Map<String, String> map = new HashMap();
        map.put("name", "elsa");
        map.put("age", "20");
        jedis.hmset("user",map);
        List<String> rsmap = jedis.hmget("user","name","age");
        System.out.println(rsmap);
        jedis.hdel("user","age");
        System.out.println("rsmap = " + rsmap);
        for (String key : jedis.hkeys("user")) {
            System.out.println("key = " + key);
        }
    }

}



