package com.cl.test.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author chen lian
 * @date 2022年01月14日 17:59
 */
@Configuration
public class MyConfig {

    @Bean
    public TestCityName cityName(){
        return new TestCityName();
    }

}
