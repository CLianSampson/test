package com.cl.test.model;

import com.cl.test.jiekou.Person;

import java.util.ArrayList;

/**
 * @author chen lian
 * @date 2021年11月01日 15:16
 */
public class Student implements Person {

    private static String school = "whptl";

    private String name;

    private Integer age;

    public static String getSchool() {
        return school;
    }

    public static void setSchool(String school) {
        Student.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void eat() {
        System.out.println("start eat .....");
    }

    public static void main(String[] args) {

        String name = "heihei";

        int a = 20;
        int b = 20;
        int c = a + b;

        System.out.println("hello world");
        System.out.println("aaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaa");

        ArrayList arrayList = new ArrayList();
        System.out.println("hello world");



    }
}
