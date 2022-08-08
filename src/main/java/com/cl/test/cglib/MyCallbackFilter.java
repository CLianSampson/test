/**************************************************************************/
/*                                                                        */
/* Copyright (c) 2017 KYE Company                                         */
/* 跨越速运集团有限公司版权所有                                             */
/*                                                                        */
/* PROPRIETARY RIGHTS of KYE Company are involved in the                  */
/* subject matter of this material. All manufacturing, reproduction, use, */
/* and sales rights pertaining to this subject matter are governed by the */
/* license agreement. The recipient of this software implicitly accepts   */
/* the terms of the license.                                              */
/* 本软件文档资料是跨越速运集团有限公司的资产，任何人士阅读和                  */
/* 使用本资料必须获得相应的书面授权，承担保密责任和接受相应的法律约束。         */
/*                                                                        */
/**************************************************************************/

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