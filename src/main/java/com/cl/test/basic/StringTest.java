package com.cl.test.basic;


import com.cl.test.model.Student;

public class StringTest {

    public static void main(String[] args) {
//        String a = "hello";
//
//        String b = new String("hello");
//
//        System.out.println(a==b);
//        System.out.println(a.equals(b));
//
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());

//        String b = new String("hello");
//        System.out.println(b);
//
//        Student student = new Student();
//        student.setName("hello");
//        student.setAge(13);

        Student xiaoli = new Student();
        xiaoli.setSchool("qinghua");

        Student xiaoming = new Student();

        System.out.println(xiaoli.getSchool());


    }

}
