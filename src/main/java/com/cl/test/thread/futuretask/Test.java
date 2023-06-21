package com.cl.test.thread.futuretask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author sampson chen
 * @date 2022年01月06日 22:01
 *
 *  重点关注 futureTask.get()方法是如何阻塞的
 *
 */
public class Test {

    public static ExecutorService threadPool =  Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return "hello";
            }
        });

        log("start");
        /** 启动线程 */
        new Thread(futureTask).start();

        System.out.println(futureTask.get());

        List<Future<String>> futureTaskList = new ArrayList<>();

        List<String> arrys = Arrays.asList("aaa","bbb","ccc");
        for (String s : arrys) {
//            FutureTask<String> task = new FutureTask<>(new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    return s + " " + "sucess";
//                }
//            });
//            futureTaskList.add(task);
//
//            pool.submit(task);
            futureTaskList.add(threadPool.submit(()-> s + " " + "sucess"));
            //pool.submit(()-> s + " " + "sucess");
        }

        for (Future<String> task : futureTaskList) {
            log(task.get());
        }


        CompletableFuture c1 = CompletableFuture.supplyAsync(()->{
            log("异步异步");
            return "提供一个结果";
        },threadPool).thenAcceptAsync((v)->{
            log(v);
        },threadPool);

    }

    public static void log(String value){
        System.out.println("[当前线程:" + Thread.currentThread().getName()+"]" + "   " + value);
    }

}
