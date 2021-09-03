package com.company.xiaofeifei.java.learning.study.proxy;

/**
 * @description: 代理-实现接口
 * @author: zouzhiyong@xiaomi.com
 * @date: 2021/09/02
 **/
public class SmsServiceImpl implements SmsService {

    @Override
    public void send(String message) {
        System.out.println("send message to sms, message = " + message);
    }

}
