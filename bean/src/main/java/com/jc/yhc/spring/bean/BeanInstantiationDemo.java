package com.jc.yhc.spring.bean;

import com.jc.yhc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FileName: BeanInstantiationDemo
 * Author:   haichaoyang3
 * Date:     2020/4/16 10:11
 * Description:bean 实例化示例
 * History:
 * since: 1.0.0
 */

public class BeanInstantiationDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:bean-instance.xml");
        User createByStaticMethod = (User) beanFactory.getBean("user-static-user",User.class);
        User createByFactoryMethod = beanFactory.getBean("user-by-factory-method",User.class);
        User createByFactoryBean = beanFactory.getBean("user-by-factory-bean",User.class);
        //两个bean的创建方式不同就算数据一致也不会相等（== 返回false），equals方法会返回true
        System.out.println(createByStaticMethod);
        System.out.println(createByFactoryMethod);
        System.out.println(createByFactoryBean);
        System.out.println(createByStaticMethod==createByFactoryMethod);
        System.out.println(createByStaticMethod==createByFactoryBean);
    }
}
