package com.cl.test.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author sampson chen
 * @date 2022年01月06日 22:01
 *
 *  重点关注 futureTask.get()方法是如何阻塞的
 *
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
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

}
