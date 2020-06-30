package com.jc.yhc.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * FileName: DefaultUserFactory
 * Author:   haichaoyang3
 * Date:     2020/4/16 10:16
 * Description:
 * History:
 * since: 1.0.0
 */

public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {
    //TODO

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct : DefaultUserFactory 初始化......");
    }
    public void initUserFactory(){
        System.out.println("自定义初始化方法 initUserFactory(): DefaultUserFactory 初始化......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet(): DefaultUserFactory 初始化......");
    }

    @PreDestroy
    public void stdDestroy(){
        System.out.println("@@PreDestroy : DefaultUserFactory 销毁......");
    }
    public void costomerDestroy(){
        System.out.println("自定义初始化方法 initUserFactory(): DefaultUserFactory 销毁......");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy(): DefaultUserFactory 销毁......");
    }
}
