package com.jc.yhc.spring.ioc.overview.domain;

/**
 * FileName: User
 * Author:   haichaoyang3
 * Date:     2020/4/13 16:07
 * Description:
 * History:
 * since: 1.0.0
 */

public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static User createUser(){
        User user =  new User();
        user.setAge(18);
        user.setName("zwz");
        return user;
    }
}
