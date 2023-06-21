package com.cl.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sampson chen
 * @date 2021年09月02日 15:30
 */
@RestController
public class TestController {

    @RequestMapping(value = "testtesttest")
    public String test(){
        return "success";
    }

}
