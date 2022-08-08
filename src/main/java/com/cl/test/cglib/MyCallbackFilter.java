
package com.cl.test.cglib;




import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * TODO 类功能描述
 *
 * @author chenlian
 * @version 1.0
 * @date 2022/8/1 22:35
 */
public class MyCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if("sayHello".equals(method.getName())){
            return 0;//Callback callbacks[0]
        }else {
            return 1;
        }
    }
}