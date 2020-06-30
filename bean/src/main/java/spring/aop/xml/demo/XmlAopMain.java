package spring.aop.xml.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.demo.Role;

/**
 * FileName: XmlAopMain
 * Author:   haichaoyang3
 * Date:     2020/6/29 14:18
 * Description:
 * History:
 * since: 1.0.0
 */

public class XmlAopMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-aop.xml");
        RoleService roleService = applicationContext.getBean(RoleService.class);
        RoleVerifier roleVerifier = (RoleVerifier) roleService;
        Role role = new Role(3L, "role_name", "this is role demo");
        if (roleVerifier.verify(role))
            roleService.printRole(role);

    }
    //TODO
}
