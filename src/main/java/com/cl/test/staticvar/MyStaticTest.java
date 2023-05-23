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

package com.cl.test.staticvar;

/**
 * 静态变量和静态代码块
 *
 * @author chenlian
 * @version 1.0
 * @date 2022/11/23 20:21
 */
public class MyStaticTest {


    private static String city = "shanghai";

    static {
        System.out.println(city);
    }

    private static String name  = "xiaoli";

    static {
        System.out.println(name);
    }



    public static void main(String[] args) {

    }

}