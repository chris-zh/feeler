package com.net;

/**
 * Created by Administrator on 2016/7/31 0031.
 */
public class Test {
    public static void main(String[] args){





    }
}

class Memory{
    //初始化一个数组，当做内存空间。内存大小1024
//    Object[] memory = new Object[1024];

    Object[] youngGeneration = new Object[256];//新生代
    Object[] oldGeneration = new Object[256];//老年代
    Object[] permanentGeneration = new Object[512];//永久代

    int currentSize = 0;

    //申请内存空间
    //返回申请到的内存的首地址
    public int maclloc(int size, Object obj){
        int startAddress = currentSize+1;
        youngGeneration[startAddress] = obj;//对象存在currentSize + 1这个位置
        currentSize += size;//占用了size这么大的空间。
        return startAddress;//返回对象的首地址
    }
}
