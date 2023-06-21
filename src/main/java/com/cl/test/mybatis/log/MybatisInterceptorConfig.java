
package com.cl.test.mybatis.log;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * TODO 类功能描述
 *
 * @author chenlian
 * @version 1.0
 * @date 2022/7/12 17:41
 */
//@Configuration
public class MybatisInterceptorConfig {

    @Bean
    public String myInterceptor(SqlSessionFactory sqlSessionFactory) {
        MybatisLogInterceptor executorInterceptor = new MybatisLogInterceptor();
        Properties properties = new Properties();
        properties.setProperty("prop1","value1");
        executorInterceptor.setProperties(properties);
        sqlSessionFactory.getConfiguration().addInterceptor(executorInterceptor);
//        sqlSessionFactory.getConfiguration().addInterceptor(new ParamInterceptor());
//        sqlSessionFactory.getConfiguration().addInterceptor(new ResultInterceptor());
        return "interceptor";
    }


}