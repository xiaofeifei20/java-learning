package com.company.xiaofeifei.java.learning.study.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description: java 反射 的学习
 * @author: zouzhiyong
 * @date: 2021/09/02
 **/
public class Reflection {

    private String value;
    public Reflection() {
        value = "reflection";
    }
    public void publicToString(String value) {
        System.out.println("public : welcome to study " + value);
    }
    private void privateToString() {
        System.out.println("private : welcome to study " + value);
    }

    public static void main(String[] args) throws Exception {
        Class<?> reflectionClass = Class.forName("com.company.xiaofeifei.java.learning.study.reflect.Reflection");
        Reflection reflectionObject = (Reflection) reflectionClass.newInstance();

        Field[] fields = reflectionClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        Method[] methods = reflectionClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Method publicToStringMethod = reflectionClass.getDeclaredMethod("publicToString", String.class);
        publicToStringMethod.invoke(reflectionObject, "reflection2");

        Field valueField = reflectionClass.getDeclaredField("value");
        valueField.set(reflectionObject, "reflection3");

        Method privateToStringMethod = reflectionClass.getDeclaredMethod("privateToString");
        privateToStringMethod.invoke(reflectionObject);

    }
}
