package com.cl.test.myspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sampson chen
 * @date 2023年06月02日 22:24
 */
public class TestSpring {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        Student student = (Student) context.getBean("student");
        System.out.println(student);

    }

}
