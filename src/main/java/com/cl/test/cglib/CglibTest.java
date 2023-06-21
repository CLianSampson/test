package com.cl.test.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author sampson chen
 * @date 2022年01月06日 22:06
 *
 *  //原文链接：https://blog.csdn.net/yhl_jxy/article/details/80633194
 */
public class CglibTest {

    //TODO cglib和asm不能同时存在pom文件中
    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);
        // 设置enhancer的回调对象
        //enhancer.setCallback(new MyMethodInterceptor());
        enhancer.setCallbacks(new Callback[]{new MyMethodInterceptor(),new MyMethodInterceptor1()});
        enhancer.setCallbackFilter(new MyCallbackFilter());
        // 创建代理对象
        HelloService proxy= (HelloService)enhancer.create();
        // 通过代理对象调用目标方法
        proxy.sayHello();



    }

}
