package com.qiandaibaobao.test;

import java.io.*;
import java.util.Map;

/**
 * Created by chris.zhang on 16-6-28.
 */
public class Emp implements Cloneable {
    private String empId;
    private Map name;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Emp) {
            return this.empId.equals(((Emp) obj).empId);
        } else {
            return false;
        }
    }

    public Map getName() {
        return name;

    }

    public void setName(Map name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public Emp setEmpId(String empId) {
        this.empId = empId;
        return this;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestFuck fuck = new TestFuck();
        fuck.setName("夏星");
        fuck.setId(1);
        fuck.setAge("18");
//        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:\\testfuck.txt"));
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(fuck);
//        objectOutputStream.close();
//        fileOutputStream.close();
        FileInputStream inputStream = new FileInputStream(new File("d:\\testfuck.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        TestFuck fuck2 = (TestFuck)objectInputStream.readObject();
        System.out.println(fuck.hashCode());
        System.out.println(fuck2.hashCode());
    }


}

class TestFuck implements Serializable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String age;


}