package com.jc.yhc.spring.bean;

import com.jc.yhc.spring.bean.factory.DefaultUserFactory;
import com.jc.yhc.spring.bean.factory.UserFactory;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * FileName: BeanInitalizationDemo
 * Author:   haichaoyang3
 * Date:     2020/4/16 10:54
 * Description: bean的初始化
 * History:
 * since: 1.0.0
 */
@Configuration
public class BeanInitalizationDemo {
    public static void main(String[] args) {
        //1基于@postConstruct注解
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitalizationDemo.class);
        applicationContext.refresh();
        System.out.println("应用上下文已经开启");

        UserFactory userFactory = applicationContext.getBean(UserFactory.class);


        System.out.println("应用上下文准备关闭");
        applicationContext.close();
        System.out.println("应用上下文已经关闭");


    }

    @Bean(initMethod = "initUserFactory",destroyMethod = "costomerDestroy")
//    @Lazy
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }

}
