package com.jc.yhc.spring.bean;

import com.jc.yhc.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * FileName: BeanDefinitionDemo
 * Author:   haichaoyang3
 * Date:     2020/4/15 14:01
 * Description: BeanDefinition 构建示例
 * History:
 * since: 1.0.0
 */

public class BeanDefinitionDemo {
    public static void main(String[] args) {
        //1.通过beandefinitionbuilder构建
        BeanDefinitionBuilder  definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //设置属性
        definitionBuilder.addPropertyValue("id","12").addPropertyValue("name","yhc").addPropertyValue("age","18");
        //获取beandefinition实例
        BeanDefinition beanDefinition = definitionBuilder.getBeanDefinition();
        //beandefinition 并非bean的终态，可以自定义修改

        //2.通过abstractBeanDefinition以及派生类构建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();

        propertyValues.add("id","12").add("name","yhc");

        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
