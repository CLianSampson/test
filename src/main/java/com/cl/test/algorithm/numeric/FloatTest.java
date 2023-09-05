package com.cl.test.algorithm.numeric;

import lombok.extern.slf4j.Slf4j;

/**
 * 浮点数测试
 *
 * @author chenlian
 * @version 1.0
 * @date 2023/8/4 9:21
 */
@Slf4j
public class FloatTest {

    public static void main(String[] args) {
        Double a = 0.2;
        log.info("a is :{}", a);
        System.out.println(a);

        double b = 0.1;
        log.info("b is :{}",b);
        System.out.println(b);

        double c = 1/5;
        log.info("c is :{}",c);
        System.out.println(c);

        double d = 0.1 + 0.2;
        log.info("d is :{}",d);
        System.out.println(d);

    }

}