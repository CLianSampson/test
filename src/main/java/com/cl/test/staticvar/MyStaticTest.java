

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