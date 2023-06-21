package com.cl.test.list.join;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  数组以某个字符串拼接
 *
 * @author chenlian
 * @version 1.0
 * @date 2022/8/11 10:20
 */
public class JoinTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");
            }
        };

        //该list不能删除
        List<String> list1 = Arrays.asList("123");


        System.out.println(String.join(",", list));
        System.out.println(list.stream().collect(Collectors.joining(",")));
    }

}