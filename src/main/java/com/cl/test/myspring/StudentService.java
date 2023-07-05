package com.cl.test.myspring;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sampson chen
 * @date 2023年06月17日 20:06
 */
@Service
@Transactional
public class StudentService {

    public void test(){
        System.out.println("test");
    }

}
