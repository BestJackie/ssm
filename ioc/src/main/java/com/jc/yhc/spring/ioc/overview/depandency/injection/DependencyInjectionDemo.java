package com.jc.yhc.spring.ioc.overview.depandency.injection;

import com.jc.yhc.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * FileName: DependencyLookupDemo
 * Author:   haichaoyang3
 * Date:     2020/4/13 16:06
 * Description:依赖注入demo
 * History:
 * since: 1.0.0
 */

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:dependency-injection.xml");
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        System.out.println(userRepository);

        System.out.println(userRepository.getBeanFactory()==userRepository.getObjectFactory().getObject());

        whoIsIocContainer(userRepository,beanFactory);
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取容器内建的bean"+environment);
    }



    private static void whoIsIocContainer(UserRepository userRepository,BeanFactory beanFactory){
        //这个表达式为什么不成立
        System.out.println(userRepository.getBeanFactory()==beanFactory);
        //applicationcontext 就是beanfactory

    }

}
