package com.cl.test.jiekou;

import lombok.Data;

/**
 * @author sampson chen
 * @date 2022年01月01日 20:24
 */
@Data
public class Heihei implements Person{

    private String name;

    private String city;

    @Override
    public void eat() {
        System.out.println("hei start eat");
    }


}
