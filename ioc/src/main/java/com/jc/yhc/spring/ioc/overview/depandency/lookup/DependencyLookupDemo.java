package com.jc.yhc.spring.ioc.overview.depandency.lookup;

import com.jc.yhc.spring.ioc.overview.annotation.Super;
import com.jc.yhc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * FileName: DependencyLookupDemo
 * Author:   haichaoyang3
 * Date:     2020/4/13 16:06
 * Description:依赖查找demo 通过名称
 * History:
 * since: 1.0.0
 */

public class DependencyLookupDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:dependency-lookup.xml");
        lookupInRealTime(beanFactory);
        lookupInLazy(beanFactory);
        lookupByType(beanFactory);
        lookupCollectionByType(beanFactory);
        lookupCollectionByAnnotation(beanFactory);
    }

    private static void lookupCollectionByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> map = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("lookupCollectionByAnnotation :"+ map);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookupCollectionByType :"+ map);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User u = beanFactory.getBean(User.class);
        System.out.println("type: "+u);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        System.out.println("lazy : " + objectFactory.getObject());
    }


    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("real : " + user);
    }
}
