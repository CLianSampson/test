package com.cl.test.init;

import com.cl.test.config.TestCityName;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author chen lian
 * @date 2022年01月14日 17:25
 */
@Component
public class MyRunner implements ApplicationRunner, ApplicationContextAware {


    private ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        TestCityName cityName = (TestCityName) applicationContext.getBean("cityName");
        System.out.println(cityName);
    }


    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
