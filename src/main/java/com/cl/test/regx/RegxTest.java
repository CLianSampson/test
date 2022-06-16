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

package com.cl.test.regx;

import java.io.PushbackInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO 类功能描述
 *
 * @author chenlian
 * @version 1.0
 * @date 2022/6/15 16:56
 */
public class RegxTest {

    /**
     *    * 匹配0次或多次
     *    ? 匹配0次或一次
     *    + 匹配一次或多次
     *    . 匹配除换行符 \n 之外的任何单字符
     * @param args
     */
    public static void main(String[] args) {
        //demoCainiao();
        testUrl();
    }


    public static void testUrl(){
        String url = "http://wwww.aaa.com:19734/restrict/list";
        //String pattern = "^(http|https)";
        String pattern = "^((http|https)://)[w]{3}.*";


        // 创建 Pattern 对象
        boolean matches = Pattern.matches(pattern, url);
        System.out.println(matches);
    }



    private static void demoCainiao() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        System.out.println(m.groupCount());
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

}