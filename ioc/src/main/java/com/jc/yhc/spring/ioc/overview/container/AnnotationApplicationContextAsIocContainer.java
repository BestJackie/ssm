package com.jc.yhc.spring.ioc.overview.container;

import com.jc.yhc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * FileName: AnnotationApplicationContextAsIocContainer
 * Author:   haichaoyang3
 * Date:     2020/4/15 16:00
 * Description:
 * History:
 * since: 1.0.0
 */
@Configuration
public class AnnotationApplicationContextAsIocContainer {
    public static void main(String[] args) {
        //创建beanfactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //把当前类作为配置类
        applicationContext.register(AnnotationApplicationContextAsIocContainer.class);
        //启动应用上下文
        applicationContext.refresh();
        //依赖查找集合对象
        lookupCollectionByType(applicationContext);
        //关闭应用上下文
        applicationContext.close();

    }

    @Bean
    public User user() {
        User user = new User();
        user.setAge(13);
        user.setName("yhc");
        return user;
    }


    private static void lookupCollectionByType(BeanFactory beanFactory){
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String,User> users= listableBeanFactory.getBeansOfType(User.class);
            System.out.println(users);
        }
    }
}
