package com.company.xiaofeifei.java.learning.study.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @description: 动态代理-jdk代理工厂
 * @author: zouzhiyong@xiaomi.com
 * @date: 2021/09/02
 **/
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new DynamicMethodInterceptor());
        return enhancer.create();
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService) CglibProxyFactory.getProxy(SmsServiceImpl.class);
        smsService.send("dynamic-cglib-zou");
    }
}
