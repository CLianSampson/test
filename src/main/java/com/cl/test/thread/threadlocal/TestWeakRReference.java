
package com.cl.test.thread.threadlocal;

import com.cl.test.model.Student;

import java.lang.ref.WeakReference;

/**
 *  测试弱引用
 *  https://blog.csdn.net/weixin_39827728/article/details/111103912
 *
 * @author chenlian
 * @version 1.0
 * @date 2022/11/14 10:31
 */
public class TestWeakRReference {

    public static void main(String[] args) {

        test();
//        test2();
//        test3();
    }

    //可以被回收
    private static void test3() {
        WeakReference<Student> weakReference = new WeakReference(new Student("ganhuojun"));
        System.gc();
        Student user = weakReference.get();
        String name = user.getName();
        System.out.println(name);
    }

    //不能被回收
    private static void test2() {
        Student student = new Student("ganhuojun");
        WeakReference<Student> weakReference = new WeakReference(student);
        System.gc();//主动gc
        Student res = weakReference.get();
        String name = res.getName();
        System.out.println(name);

    }

    private static void test() {

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(new Student());

        System.out.println(threadLocal.get().toString());

        System.gc();

        System.out.println(threadLocal.get().toString());



    }

}