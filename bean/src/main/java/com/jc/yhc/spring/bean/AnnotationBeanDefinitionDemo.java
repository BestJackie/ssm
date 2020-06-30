package com.jc.yhc.spring.bean;

import com.jc.yhc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * FileName: AnnotationBeanDefinitionDemo
 * Author:   haichaoyang3
 * Date:     2020/4/15 16:09
 * Description:
 * History:
 * since: 1.0.0
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)////通过@Import
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        applicationContext.refresh();//启动上下文

        //通过API方式
        //1.命名bean的注册方式
        registerBeanDefinition(applicationContext,"yanghaichao-user",User.class);
        //2非命名的bean的注册方式
        registerBeanDefinition(applicationContext,User.class);


        System.out.println("config 类型的所有的 beans"+ applicationContext.getBeansOfType(Config.class));
        System.out.println("user 类型的所有的 beans"+ applicationContext.getBeansOfType(User.class));



        applicationContext.close();
    }


    public static void registerBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry,String beanName,Class<?> beanClass){
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(beanClass);
        beanDefinitionBuilder.addPropertyValue("name","yanghaichao").addPropertyValue("age",15);

        if (StringUtils.hasText(beanName)){
            //注册BeanDefinition
            beanDefinitionRegistry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        }else {
            //非命名的方式注册BeanDefinition
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),beanDefinitionRegistry);
        }

    }

    public static void registerBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry,Class<?> beanClass) {
        registerBeanDefinition(beanDefinitionRegistry,null,beanClass);

    }

        @Component// //通过@Component
    public static class Config{
        @Bean(name = {"user","yhc-user"})//通过@Bean
        public User user() {
            User user = new User();
            user.setAge(13);
            user.setName("yhc");
            return user;
        }
    }



}
