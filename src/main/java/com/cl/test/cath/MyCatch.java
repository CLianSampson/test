package com.cl.test.cath;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chen lian
 * @date 2022年01月13日 15:23
 */
public class MyCatch {

    public static void main(String[] args) {
        try {
            try {
                System.out.println("11111");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                throw new Exception("hhhhhh");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
