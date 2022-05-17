package com.cl.test.fullgc;

import com.cl.test.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen lian
 * @date 2022年03月09日 16:39
 */
public class MyFullGC {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 1000000000; i++) {
            Student student = new Student();
            student.setName("zhangsan");
            list.add(student);
        }
    }

}
