package com.company.xiaofeifei.java.learning.study.proxy;

/**
 * @description: 静态代理-实现代理类
 * @author: zouzhiyong@xiaomi.com
 * @date: 2021/09/02
 **/
public class SmsProxy implements SmsService {

    private SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public void send(String message) {
        System.out.println("[static invoke] before send, i can do this");
        smsService.send(message);
        System.out.println("[static invoke] after send, i can do that");
    }

    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("static-zou");
    }
}
