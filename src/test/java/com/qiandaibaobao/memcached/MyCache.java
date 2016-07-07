package com.qiandaibaobao.memcached;

/**
 * Created by chris.zhang on 16-7-7.
 */
import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MyCache {
    public static void main(String[] args) {
        MemCachedClient client=new MemCachedClient();
        String [] addr ={"121.42.149.46:12000"};
        Integer [] weights = {3};
        SockIOPool pool = SockIOPool.getInstance();
        pool.setServers(addr);
        pool.setWeights(weights);
        pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(200);
        pool.setMaxIdle(1000*30*30);
        pool.setMaintSleep(30);
        pool.setNagle(false);
        pool.setSocketTO(30);
        pool.setSocketConnectTO(0);
        pool.initialize();

//      String [] s  =pool.getServers();
//        client.setCompressEnable(true);
//        client.setCompressThreshold(1000*1024);

//      将数据放入缓存
        client.set("test2","test2");

//      将数据放入缓存,并设置失效时间
        Date date=new Date(2000000);
        client.set("test1","test1", date);

//      删除缓存数据
//      client.delete("test1");

//      获取缓存数据
        String str =(String)client.get("test1");
        String str2 =(String)client.get("test2");
        System.out.println(str);
        System.out.println("str2 = " + str2);
    }
}