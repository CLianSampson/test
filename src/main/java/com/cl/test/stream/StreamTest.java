package com.cl.test.stream;

import com.cl.test.jiekou.Heihei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chen lian
 * @date 2022年01月07日 10:06
 */
public class StreamTest {

    public static void main(String[] args) {
        Heihei one = new Heihei();
        one.setName("lili");
        one.setCity("shenzhen");

        Heihei two = new Heihei();
        two.setName("lucy");
        two.setCity("shenzhen");

        List<Heihei> list = new ArrayList<>();
        list.add(two);
        list.add(one);


        try {
            Map<String, String> map = list.stream().collect(Collectors.toMap(Heihei::getCity, Heihei::getName));

//            Map<String, Heihei> map = list.stream().collect(Collectors.toMap(Heihei::getCity, Function.identity(), (t1, t2) -> t2));

            System.out.println(map);
        } catch (IllegalStateException e) {
            System.out.println("异常异常");
            e.printStackTrace();
        }

    }

}
