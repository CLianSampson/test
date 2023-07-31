
package com.cl.test.algorithm.arithmetic;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 *  java clone
 *
 *  整形溢出问题  补码
 *
 * @author chenlian
 * @version 1.0
 * @date 2023/7/26 9:11
 */
@Slf4j
public class SpillTest {

    public static void main(String[] args)  {
        short a = 32767;
        short b = 32767;

        // 01111111 11111111
        // 01111111 11111111

        short c = (short) (a + b);

        System.out.println("c的值:" + c);


        byte e = 127;
        byte f = 127;
        byte g = (byte) (e + f);
        System.out.println("g的值:" + g);

        // 11111110
        // 00000001  + 1 =
        // 00000010  -2

        Integer int1 = new Integer(1);
        Integer int2 = new Integer(1);
        System.out.println(int1 == int2);
        System.out.println(int1.equals(int2));

        Market market1 = new Market();
        market1.setNumber(1000000);
        Market market2 = new Market();
        System.out.println(market1.equals(market2));
        System.out.println(market1.hashCode() == market2.hashCode());

        try {
            Market market3 = (Market) market1.clone();
            log.info("market3 is : {}", JSON.toJSON(market3));
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }

        float faaa = 3E28f;
        log.info("faaa is :{}",faaa);

    }

}