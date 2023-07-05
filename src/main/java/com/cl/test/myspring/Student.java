package com.cl.test.myspring;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author sampson chen
 * @date 2023年06月02日 22:27
 */
@Data
@Component
public class Student {

    private String name = "zhang san";

    public Student(){
        System.out.println("开始初始化bean了...");
    }

}
