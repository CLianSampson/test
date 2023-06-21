
package com.cl.test.thread.future;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * TODO 类功能描述
 *
 * @author chenlian
 * @version 1.0
 * @date 2022/7/19 11:18
 */
public class FutrureList {


    public static void main(String[] args) {
        execuleThread();
    }

    /**
     * 多线程处理list数据
     */
    public static void execuleThread() {
        Map<String, Object> ret = new LinkedHashMap<>();
        try {
            List<String> toProcessList = new ArrayList<>(); // 需要处理的列表数据
            toProcessList.add("1111");
            toProcessList.add("2222");
            toProcessList.add("3333");
            toProcessList.add("4444");
            toProcessList.add("5555");

            List<Future<String>> list = new ArrayList<>();
            ExecutorService executor = Executors.newFixedThreadPool(8);

            //创建future
            for (String s : toProcessList) {
                Future<String> future = executor.submit(()->{
                    return s + "aaaa";
                });
                list.add(future);
            }


            for (Future<String> stringFuture : list) {
                String s = stringFuture.get();
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}