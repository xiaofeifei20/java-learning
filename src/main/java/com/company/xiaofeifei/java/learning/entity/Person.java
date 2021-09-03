package com.company.xiaofeifei.java.learning.entity;

/**
 * 实体类-人
 *
 * @author zouzy
 * @date 2019-12-24
 */
public class Person {

    private String name;  //名字
    private int age;  //年龄
    private String sex;  //性别
    private String home;  //住址
    private boolean married;  //是否已婚

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name, int age, String sex, String home, boolean married) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.home = home;
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", home='" + home + '\'' +
                ", married=" + married +
                '}';
    }
}
