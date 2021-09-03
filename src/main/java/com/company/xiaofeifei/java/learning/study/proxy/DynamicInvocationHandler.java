package com.company.xiaofeifei.java.learning.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 动态代理-jdk动态代理
 * 缺点：只能代理实现了接口的类
 * @author: zouzhiyong@xiaomi.com
 * @date: 2021/09/02
 **/
public class DynamicInvocationHandler implements InvocationHandler {

    private final Object target;

    public DynamicInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[dynamic jdk invoke] before send, i can do this");
        System.out.println("method = " +  method.getName());
        Object object = method.invoke(target, args);
        System.out.println("[dynamic jdk invoke] after send, i can do that");
        return object;
    }

}
