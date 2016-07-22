package com.qiandaibaobao;

import com.qiandaibaobao.test.TestBO;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 这个类的包名为com.qiandaibaobao.IocTest
 */
public class IocTest {

    TestBO bo;

    public IocTest setBo(TestBO bo) {
        this.bo = bo;
        return this;
    }

    public void testIoc() {
        bo.fuck();
    }


    public static void main(String[] args) throws Exception {
        IocTest test = (IocTest) ioc();
        System.out.println("test = " + test);
        test.testIoc();
    }

    /**
     * 思路：
     * 目标：将bean注入到target中，并返回target
     * 1. 从配置文件中读取target和bean
     * 2. 生成target和bean的实例
     * 2. 遍历target的属性，找到与bean属性相同的成员变量M
     * 3. 找到M对应的set方法
     * 4. 通过反射，调用该set方法，将bean的实例作为参数传入
     * 5. 返回target实例，得到被注入成功的target对象
     * @return
     * @throws Exception
     */
    public static Object ioc() throws Exception {
        //读取文件
        File file = new File("f:\\bean.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.readLine();//去掉第一行
        String line = bufferedReader.readLine();

        //得到配置文件中的两个类名
        String[] beans = line.split(",");
        String target = beans[0];//被注入的类
        String bean = beans[1];//作为bean注入的类

        //生成两个类的实例
        String methodName = "";
        Class targetClazz = Class.forName(target);
        Class beanClazz = Class.forName(bean);//
        Object targetObject = targetClazz.newInstance();//获得目标对象实例
        Object beanObject = beanClazz.newInstance();//获得bean的实例

        //开始遍历target成员变量和方法
        Method invokeMethod = null;
        for (Field field : targetClazz.getDeclaredFields()) {
            String fieldType = field.getType().getName();
            //找到类型相同的属性，并获得该属性对应的set方法
            if (fieldType.equals(bean)) {
                String fieldName = field.getName();
                methodName = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1, fieldName.length());
            }
        }
        //获得set方法对象
        for (Method method : targetClazz.getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {
                invokeMethod = method;
            }
        }

        //通过反射，将bean注入到target中
        invokeMethod.invoke(targetObject, beanObject);
        return targetObject;
    }
}

/**
 *配置文件全路径为:
     f:\bean.txt
 *内容：
    #将TestBO注入到IocTest中。第一行是注释，不解析
    com.qiandaibaobao.IocTest,com.qiandaibaobao.test.TestBO
 *
 *
 */
