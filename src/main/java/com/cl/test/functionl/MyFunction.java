package com.cl.test.functionl;

import com.cl.test.jiekou.Person;
import com.cl.test.model.Student;

import java.util.function.Supplier;

/**
 * @author sampson chen
 * @date 2022年01月01日 20:53
 */
public class MyFunction {

    public static void main(String[] args) {
//        Supplier<Student> studentSupplier = new Supplier<Student>() {
//            @Override
//            public Student get() {
//                System.out.println("生成者。。。。");
//                return new Student();
//            }
//        };


//        test(new Supplier<Student>() {
//            @Override
//            public Student get() {
//                System.out.println("生成者。。。。");
//                return new Student();
//            }
//        });

        test(()->{
            return new Student();
        });


    }


    public static void test(Supplier<Student> supplier){
        Student student = supplier.get();
        student.eat();
    }

}
