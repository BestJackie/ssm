package com.jc.yhc.spring.bean;

import com.jc.yhc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * FileName: ObjectProviderDemo
 * Author:   haichaoyang3
 * Date:     2020/4/18 14:26
 * Description:
 * History:
 * since: 1.0.0
 */

public class ObjectProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ObjectProviderDemo.class);
//        applicationContext.refresh();


        lookUpByObjectProvider(applicationContext);
        lookupStreamOps(applicationContext);
        applicationContext.close();

    }


    private static void lookupIfAvailable(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        ObjectProvider<User> userObjectProvider = annotationConfigApplicationContext.getBeanProvider(User.class);
        User user = userObjectProvider.getIfAvailable(User::createUser);
        System.out.println("当前user 对象"+user);
    }

    private static void lookupStreamOps(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        ObjectProvider<String> userObjectProvider = annotationConfigApplicationContext.getBeanProvider(String.class);
//        Iterable<String> strings = userObjectProvider;
        userObjectProvider.stream().forEach(System.out::println);

    }


    @Bean
    @Primary
    public String helloWorld(){
        return "hello world";
    }

    @Bean
    public String message(){
        return "hello message";
    }


    private static void lookUpByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }

}

