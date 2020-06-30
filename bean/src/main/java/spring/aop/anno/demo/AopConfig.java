package spring.aop.anno.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * FileName: AopConfig
 * Author:   haichaoyang3
 * Date:     2020/6/28 16:18
 * Description:
 * History:
 * since: 1.0.0
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AopConfig {

    @Bean
    public RoleAspect getRoleAspect(){
        return new RoleAspect();
    }
}
