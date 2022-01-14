package com.cl.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chen lian
 * @date 2022年01月14日 18:08
 */
@Component
@ConfigurationProperties(value = "heiehi")
public class TestCityName {
}
