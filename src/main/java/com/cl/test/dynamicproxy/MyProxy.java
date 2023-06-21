package com.cl.test.dynamicproxy;

import com.cl.test.jiekou.Heihei;
import com.cl.test.jiekou.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author sampson chen
 * @date 2021年12月28日 22:57
 *
 *  prxoy类中 newProxyInstance原理 https://blog.csdn.net/weidea/article/details/43348447
 */
public class MyProxy {

    // 原文链接：https://blog.csdn.net/yhl_jxy/article/details/80586785

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /**
        // =========================第一种==========================
        // 1、生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 2、获取动态代理类
        Class proxyClazz = Proxy.getProxyClass(Person.class.getClassLoader(),Person.class);
        // 3、获得代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        // 4、通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
        Person iHello1 = (Person) constructor.newInstance(new MyInvocationHandler(new Heihei()));
        // 5、通过代理对象调用目标方法
        iHello1.eat();
         **/

        // ==========================第二种=============================
        /**
         * Proxy类中还有个将2~4步骤封装好的简便方法来创建动态代理对象，
         *其方法签名为：newProxyInstance(ClassLoader loader,Class<?>[] instance, InvocationHandler h)
         */
        Person  proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), // 加载接口的类加载器
                new Class[]{Person.class}, // 一组接口
                new MyInvocationHandler(new Heihei())); // 自定义的InvocationHandler

        //proxy.eat();

        //对代理继续代理，mybatis 插件使用这种方式
        Person  proxy1 = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), // 加载接口的类加载器
                new Class[]{Person.class}, // 一组接口
                new MyInvocationHandler(proxy)); // 自定义的InvocationHandler

        proxy1.eat();

    }

}
