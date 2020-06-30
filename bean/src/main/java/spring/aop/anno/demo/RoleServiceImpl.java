package spring.aop.anno.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import spring.aop.demo.Role;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * FileName: RoleServiceImpl
 * Author:   haichaoyang3
 * Date:     2020/6/28 16:02
 * Description:
 * History:
 * since: 1.0.0
 */
@Component
public class RoleServiceImpl implements RoleService, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {


    @Override
    public void setBeanName(String name) {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用BeanNameAware接口的setBeanName方法；");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用BeanFactoryAware接口的setBeanFactory方法；");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用ApplicationContextAware接口的setApplicationContext方法；");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用InitializingBean接口的afterPropertiesSet方法；");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用DisposableBean接口的destroy方法；");
    }
    @PostConstruct
    public void init(){
        System.out.println("【"+this.getClass().getSimpleName()+"】自定义初始化方法；");
    }
    @PreDestroy
    public void myDestory(){
        System.out.println("【"+this.getClass().getSimpleName()+"】自定义销毁方法；");
    }

    @Override
    public void printRole(Role role) {
        System.out.println(role.toString());
    }
}
