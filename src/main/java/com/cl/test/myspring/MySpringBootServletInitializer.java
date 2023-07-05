package com.cl.test.myspring;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author sampson chen
 * @date 2023年06月11日 10:14
 */
public class MySpringBootServletInitializer extends SpringBootServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("进入初始化了");
        super.onStartup(servletContext);
    }
}
