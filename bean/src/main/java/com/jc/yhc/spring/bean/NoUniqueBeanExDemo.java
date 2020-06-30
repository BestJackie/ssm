package com.jc.yhc.spring.bean;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * FileName: NoUniqueBeanExDemo
 * Author:   haichaoyang3
 * Date:     2020/4/19 12:54
 * Description:{@link NoUniqueBeanDefinitionException}示例代码
 * History:
 * since: 1.0.0
 */

public class NoUniqueBeanExDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(NoUniqueBeanExDemo.class);
        applicationContext.refresh();


        try {
            applicationContext.getBean(String.class);
        } catch (NoUniqueBeanDefinitionException e) {
            System.err.printf("spring 应用中存在 %d 个 %s 类型的Bean，具体原因 %s%n",
                    e.getNumberOfBeansFound(),
                    String.class.getName(),
                    e.getMessage());
        }
        applicationContext.close();
    }

    @Bean
    public String bean1() {
        return "1";
    }

    @Bean
    public String bean2() {
        return "2";
    }

    @Bean
    public String bean3() {
        return "3";
    }


}
