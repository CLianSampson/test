
package com.cl.test.thread.threadlocal;

/**
 * TODO 类功能描述
 *
 * @author chenlian
 * @version 1.0
 * @date 2022/11/21 11:18
 */
public class MyInheritableThreadLocal {

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("world");

        InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.set("hello");

        Thread  thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            }
        });

        thread.start();

    }

}