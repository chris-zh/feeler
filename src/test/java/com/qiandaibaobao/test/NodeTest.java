package com.qiandaibaobao.test;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by chris.zhang on 16-7-12.
 */
public class NodeTest {
    /**
     * 分布式存储原理,基于一致性哈希
     * http://blog.csdn.net/cywosp/article/details/23397179/
     * @param args
     */
    public static void main(String[] args){
        Map<Integer, Node> nodes = getNodes();//获得分布式机器集群
        Object user = new Object();//待储存的对象
        int userKey = hash(user);//得到user对象在哈希环中的key值(也就是位置)
        int nodeKey = mapUserKey(userKey, nodes);//顺时针旋转，得到匹配到的机器的key值
        Node node = nodes.get(nodeKey);//获得这台机器
        node.openConnection();//打开这台机器的链接
        node.save(user);//保存user对象
        node.close();//关闭链接
    }

    /**
     * 根据对象key值，顺时针查找机器
     * @param userKey
     * @return
     */
    private static int mapUserKey(int userKey,Map<Integer, Node> nodes) {
        //这是一个效率非常低的查找方式，复杂度是O(n)
        // 如果nodes是已经排好序的map，那么可以将复杂度提高到O(1)
        for(int key=userKey;key > 0;key--) {
            if (nodes.containsKey(key)) {
                return key;
            }
        }
        return 0;
    }

    /**
     * 获得机器集群
     * @return
     */
    private static Map<Integer, Node> getNodes() {
        return null;
    }

    /**
     * 一致性哈希函数
     * @param object
     * @return
     */
    static int hash(Object object) {
        return object.hashCode();
    }


}

/**
 * 一个Node代表一台机器
 */
class Node implements Serializable {
    private String nodeName;
    private String nodeIP;
    private String nodePort;
    private int hashKey;

    public void openConnection() {

    }
    public void close() {

    }
    public void save(Object obj) {
        //保存这个对象
    }

    public String getNodeName() {
        return nodeName;
    }

    public int getHashKey() {
        return hashKey;
    }

    public Node setHashKey(int hashKey) {
        this.hashKey = hashKey;
        return this;
    }

    public Node setNodeName(String nodeName) {
        this.nodeName = nodeName;
        return this;
    }

    public String getNodeIP() {
        return nodeIP;
    }

    public Node setNodeIP(String nodeIP) {
        this.nodeIP = nodeIP;
        return this;
    }

    public String getNodePort() {
        return nodePort;
    }

    public Node setNodePort(String nodePort) {
        this.nodePort = nodePort;
        return this;
    }
}
