/**************************************************************************/
/*                                                                        */
/* Copyright (c) 2017 KYE Company                                         */
/* 跨越速运集团有限公司版权所有                                             */
/*                                                                        */
/* PROPRIETARY RIGHTS of KYE Company are involved in the                  */
/* subject matter of this material. All manufacturing, reproduction, use, */
/* and sales rights pertaining to this subject matter are governed by the */
/* license agreement. The recipient of this software implicitly accepts   */
/* the terms of the license.                                              */
/* 本软件文档资料是跨越速运集团有限公司的资产，任何人士阅读和                  */
/* 使用本资料必须获得相应的书面授权，承担保密责任和接受相应的法律约束。         */
/*                                                                        */
/**************************************************************************/

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