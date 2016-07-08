package com.qiandaibaobao.test;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import java.util.LinkedHashMap;

/**
 * Created by chris.zhang on 16-7-8.
 * 徒手掏一个Lru
 */
public class LRUCache {
    private int currentSize;
    private int cacheSize;
    private CacheNode first;
    private CacheNode last;
    private Hashtable nodes;//缓存容器


    class CacheNode{
        CacheNode prev;//上一个节点
        CacheNode next;//下一个节点
        Object key;//key
        Object value;//value
        CacheNode() {
        }
    }

    /**
     * 根据key值从缓存中取出节点
     * 如果节点不为空，返回这个node，并将这个node移动到队列头
     * 如果节点为空，说明节点不存在，返回null
     * @param key
     * @return
     */
    public Object get(Object key) {
        CacheNode node = (CacheNode) nodes.get(key);
        if (node != null) {
            moveToHead(node);
            return node;
        } else {
            return null;
        }
    }

    /**
     * 存缓存
     * 先判断该节点是否存在，如果存在，替换掉已存在的节点，并移动到队列头
     * 如果节点不存在，存储
     * 存储时，先判断当前容量是否超过最大容量。如果超过，删除最后列表的最后一个节点
     * 如果没有超过最大容量，新建一个节点，将该节点移动到队列头
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {
        CacheNode node = (CacheNode) nodes.get(key);
        if (node == null) {
            if (currentSize > cacheSize) {
                if (last != null) {
                    nodes.remove(last.key);
                }
                removeLast();
            } else {
                currentSize++;
            }
            node = new CacheNode();
        }

        node.value = value;
        node.key = key;
        moveToHead(node);
        nodes.put(key, node);
    }

    /**
     * 删除最后一个节点
     */
    private void removeLast() {
        if (last != null) {
            if (last.prev != null) {
                last.prev.next = null;
            } else {
                first = null;
            }
            last = last.prev;
        }
    }

    /**
     * 移动到链表头，表示这个节点是最近被使用过的
     * @param node
     */
    private void moveToHead(CacheNode node) {
        if (node == first) {
            return;
        }
        /**
         * 连接当前节点的上一个节点和下一个节点，摘下当前节点
         */
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (last == node) {
            last.prev = node.prev;
        }
        if (first != null) {
            node.next = first;
            first.prev = node;
        }
        first = node;
        node.prev = null;
        if (last == null) {
            last = first;
        }
    }

}
