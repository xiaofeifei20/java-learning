package com.company.xiaofeifei.java.learning.study;

import com.company.xiaofeifei.java.learning.entity.Person;
import com.google.common.collect.Lists;
import com.xiaomi.cnzone.sampleapi.api.monitor.SampleMonitorProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class HelloWorld {

    private static Logger log = LoggerFactory.getLogger(HelloWorld.class);

    public static void main2(String[] args) {
        log.info("welcome to my first + tool");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        log.info("result is： " + (a + b));
    }

    public static void main3(String[] args) {
        System.out.println("create success");
        int size = 1024 * 1024;
        byte[] i = new byte[50 * size];
    }

    public static void main0(String[] args) {
        Person p1 = new Person("小李");
        Person p2 = new Person("小张");
        HelloWorld.swap(p1, p2);
        log.info(p1.getName());
        log.info(p2.getName());

        int n1 = 8;
        int n = n1 - 1;
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
    }

    public static void swap(Person p1, Person p2) {
        Person tmp = p1;
        p1 = p2;
        p2 = tmp;
        log.info(p1.getName());
        log.info(p2.getName());

    }

    public static void main4(String[] args) {
        Person p1 = new Person("张小三", 25, "男", "湖北省武汉市", false);
        Person p2 = new Person("王晓云", 23, "女", "广东省广州市", false);
        List<Person> family = Lists.newArrayList();

        family.add(p1);
        family.add(p2);

        System.out.println(family);

    }

    public static void main(String[] args) {
        int i = -2;
        System.out.println("before, i = " + Integer.toBinaryString(i));
        int r = Integer.signum(i);
        System.out.println("result = " + r);
        System.out.println("---------");
        int s1 = i >> 31;
        int s2 = -i >>> 31;
        System.out.println(Integer.toBinaryString(s1));
        System.out.println(Integer.toBinaryString(s2));
        System.out.println(s1 | s2);
        System.out.println("---------");
    }
}
