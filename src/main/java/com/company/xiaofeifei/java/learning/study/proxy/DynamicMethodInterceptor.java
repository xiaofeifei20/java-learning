package com.company.xiaofeifei.java.learning.study.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: 动态代理-cglib代理
 * @author: zouzhiyong@xiaomi.com
 * @date: 2021/09/02
 **/
public class DynamicMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("[dynamic cglib invoke] before send, i can do this");
        System.out.println("method = " +  method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("[dynamic cglib invoke] after send, i can do that");
        return object;
    }
}
