package com.jc.yhc.spring.bean;

import com.jc.yhc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FileName: BeanAliasDemo
 * Author:   haichaoyang3
 * Date:     2020/4/15 14:51
 * Description:
 * History:
 * since: 1.0.0
 */

public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:bean-definition.xml");
        User yhcUser = (User) beanFactory.getBean("yhc-user");
        User user = beanFactory.getBean("user", User.class);
        System.out.println("yhcUser 与 user " + ((yhcUser == user)?"":"不")+"相等");

    }
}
