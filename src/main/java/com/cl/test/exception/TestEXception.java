package com.cl.test.exception;

/**
 * TODO 类功能描述
 *
 * @author chenlian
 * @version 1.0
 * @date 2022/6/28 17:47
 */
public class TestEXception {

    public static void main(String[] args) {

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