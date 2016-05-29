package com.qiandaibaobao.auth;

import org.omg.CORBA.TIMEOUT;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Administrator on 2016/5/29 0029.
 */
public final class RedisUtil {
    //Redis服务器IP
    private static final String ADDR = "121.42.149.46";
    //Redis端口号
    private static final int PORT = 6379;
    //访问密码
    private static final String AUTH = "redis";

    private static final int MAX_IDLE = 200;
    private static JedisPool jedisPool = null;
    private static final int TIMEOUT = 10000;

    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(MAX_IDLE);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public synchronized static Jedis getJedis(){
        Jedis resource = null;
        try{
            if(jedisPool!=null){
                resource = jedisPool.getResource();
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return resource;
    }
    public static void returnResource(final Jedis jedis){
        if(jedis!=null){
            jedisPool.returnResource(jedis);
        }
    }

}
