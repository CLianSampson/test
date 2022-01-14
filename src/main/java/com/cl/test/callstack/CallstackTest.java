package com.cl.test.callstack;

/**
 * @author chen lian
 * @date 2022年01月10日 10:23
 */
public class CallstackTest {

    public static void main(String[] args) {

    }


    public static void t1(){
        t2();
    }

    public static void t2(){
        t3();
    }

    public static void t3(){
        t4();;
    }

    public static void t4(){
        t5();
    }

    public static void t5(){
        System.out.println("over");
    }


}
