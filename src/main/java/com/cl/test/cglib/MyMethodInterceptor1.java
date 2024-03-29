package com.cl.test.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sampson chen
 * @date 2022年01月06日 22:17
 */
public class MyMethodInterceptor1 implements MethodInterceptor {

    /**
     * sub：cglib生成的代理对象
     * method：被代理对象方法
     * objects：方法入参
     * methodProxy: 代理方法
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("1111======插入前置通知======");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("1111======插入后者通知======");
        return object;
    }

}
