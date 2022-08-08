package com.cl.test.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 类功能描述
 *
 * @author chenlian
 * @version 1.0
 * @date 2022/6/28 17:47
 */
public class TestEXception {

    public static void main(String[] args) {

        final List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");

        List<String> list1 = Arrays.asList("cccccccc","bbbbbb");
        System.out.println(list1);

        String test = "aaaaaa";
        try {
            test = "bbbb";
            throw new RuntimeException("aaaaa");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(test);

    }

}