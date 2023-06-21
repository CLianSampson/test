package com.cl.test.thread.futuretask;

import java.util.concurrent.*;

/**
 * @author sampson chen
 * @date 2022年01月06日 22:01
 *
 *  重点关注 futureTask.get()方法是如何阻塞的
 *
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test2();
    }

    public static void test1() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return "hello";
            }
        });

        /** 启动线程 */
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    public static void test2() throws ExecutionException, InterruptedException {
        FutureTask one = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return "hello";
            }
        });

        FutureTask two = new FutureTask(()->{
            return "world";
        });

        ExecutorService pool =  Executors.newFixedThreadPool(8);
        pool.submit(one);
        pool.submit(two);

        System.out.println(one.get());
        System.out.println(two.get());
    }

}
