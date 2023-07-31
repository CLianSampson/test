package com.cl.test.algorithm.arithmetic;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 *
 * @author chenlian
 * @version 1.0
 * @date 2023/7/27 10:47
 */
@Slf4j
public class BigdecimalTest {

    public static void main(String[] args) {
        BigDecimal  price = BigDecimal.valueOf(99999999999.888D);
        log.info("price is : {}",price);

        BigDecimal aaa = new BigDecimal("9999999999999999999999999999999999999999999999");
        log.info("aaa is : {}",aaa);

        int digit = Character.digit('9', 10);
        log.info("digit is : {}",digit);

        BigInteger bigInteger = new BigInteger("9999999999999999999999999999999999999",10);
        log.info("bigInteger is : {}",bigInteger.intValue());

    }

}