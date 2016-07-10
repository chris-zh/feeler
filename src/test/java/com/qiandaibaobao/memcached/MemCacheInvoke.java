//package com.qiandaibaobao.memcached;
//
//import com.danga.MemCached.MemCachedClient;
//import com.danga.MemCached.SockIOPool;
//
///**
// * Created by IntelliJ IDEA.
// * User: liuzhy
// * Date: 2010-12-3
// * Time: 16:43:36
// */
//public class MemCacheInvoke {
//    protected static MemCachedClient mcc = new MemCachedClient();
//
//    static {
//
//        // 设置缓存服务器列表，当使用分布式缓存的时，可以指定多个缓存服务器。这里应该设置为多个不同的服务，我这里将两个服务设置为一样的，大家不要向我学习，呵呵。
//        String[] servers =
//                {
//                        "121.42.149.46:12000",
//                        "121.42.149.46:12001",
//                        "121.42.149.46:12002",
//                        "121.42.149.46:12002"
//                };
//
//// 设置服务器权重
//        Integer[] weights = {3, 2, 1, 1};
//
//        // 创建一个Socked连接池实例
//        SockIOPool pool = SockIOPool.getInstance();
//
//        // 向连接池设置服务器和权重
//        pool.setServers(servers);
////        pool.setWeights(weights);
//
//        // set some TCP settings
//        // disable nagle
//        // set the read timeout to 3 secs
//        // and don't set a connect timeout
//        pool.setNagle(false);
//        pool.setSocketTO(3000);
//        pool.setSocketConnectTO(0);
//
//        // initialize the connection pool
//        pool.initialize();
//    }
//
//    public static void main(String[] args) {
//        System.out.println("mcc = " + mcc);
//        mcc.set("foo", "This is a test String");
////        String bar = mcc.get("foo").toString();
////        System.out.println(">>> " + bar);
//        System.out.println("mcc.get(\"foo\") = " + mcc.get("foo"));
//    }
//}