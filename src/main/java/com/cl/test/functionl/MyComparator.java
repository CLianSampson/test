

package com.cl.test.functionl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 比较器
 *
 * @author chenlian
 * @version 1.0
 * @date 2022/12/1 19:59
 */
public class MyComparator implements Comparator<Integer> {


    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 == 20 && o2 == 30){
            return 1;
        }else if (o1 == 30 && o2 == 20){
            return -1;
        }else {
            return o1 - o2;
        }
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);
        list.add(30);

        list.sort(new MyComparator());

        System.out.println(list);
    }


}