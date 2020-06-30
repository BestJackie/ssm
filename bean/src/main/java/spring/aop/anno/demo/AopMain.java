package spring.aop.anno.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.aop.demo.Role;

/**
 * FileName: AopMain
 * Author:   haichaoyang3
 * Date:     2020/6/28 16:23
 * Description:
 * History:
 * since: 1.0.0
 */

public class AopMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        RoleServiceImpl roleService = applicationContext.getBean(RoleServiceImpl.class);
        RoleVerifier roleVerifier = (RoleVerifier)roleService;
        Role role = new Role(2L,"role_name","this is role demo");
        if (roleVerifier.verify(role))
            roleService.printRole(role);
        /*System.out.println("####################测试 afterThrowing############################");
        role = null;
        roleService.printRole(role);*/
    }
}
