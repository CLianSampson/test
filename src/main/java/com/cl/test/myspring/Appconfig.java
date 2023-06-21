package com.cl.test.myspring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author sampson chen
 * @date 2023年06月02日 22:25
 */
@ComponentScan("com.cl.test.myspring")
@EnableTransactionManagement
public class Appconfig {
}
