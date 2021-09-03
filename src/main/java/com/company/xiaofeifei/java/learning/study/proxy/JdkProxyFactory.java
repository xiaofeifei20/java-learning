package com.company.xiaofeifei.java.learning.study.proxy;

import java.lang.reflect.Proxy;

/**
 * @description: 动态代理-jdk代理工厂
 * @author: zouzhiyong@xiaomi.com
 * @date: 2021/09/02
 **/
public class JdkProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DynamicInvocationHandler(target)
        );
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("dynamic-jdk-zou");
    }
}
