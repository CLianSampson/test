package com.cl.test.fullgc;

import com.cl.test.model.Student;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen lian
 * @date 2022年03月09日 16:39
 */
public class MyFullGC {

    public static void main(String[] args) {
        //fullGc();
        objectSize();
    }

    private static void fullGc() {
        System.out.println("start");
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 1000000000; i++) {
            Student student = new Student();
            student.setName("zhangsan");
            list.add(student);
        }
        System.out.println("end");
    }

    /**
     * 计算java对象的大小
     * https://www.cnblogs.com/rickiyang/p/14206724.html
     */
    public static void objectSize(){
        //ClassLayout classLayout = ClassLayout.parseInstance(new ObjA());
        //ClassLayout classLayout = ClassLayout.parseInstance(new int[16]);
        ClassLayout classLayout = ClassLayout.parseInstance(1000);
        System.out.println(classLayout.toPrintable());
    }

    static class ObjA {
    }

}
