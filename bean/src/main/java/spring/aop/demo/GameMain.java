package spring.aop.demo;

/**
 * FileName: GameMain
 * Author:   haichaoyang3
 * Date:     2020/6/28 14:12
 * Description:
 * History:
 * since: 1.0.0
 */

public class GameMain {
    public static void main(String[] args) {
        RoleService roleService = new RoleServiceImpl();
        Interceptor interceptor = new RoleInterceptor();
        RoleService proxy = ProxyBeanFactory.getBean(roleService,interceptor);
        Role role = new Role(1L,"role_name_1","this is tese demo role");
        proxy.printRole(role);
        System.out.println("######################测 试 afterThorwing 方法#####################");
        role = null;
        proxy.printRole(role);
    }
    //TODO
}
