package spring.aop.xml.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import spring.aop.demo.Role;

/**
 * FileName: RoleServiceImpl
 * Author:   haichaoyang3
 * Date:     2020/6/29 14:02
 * Description:
 * History:
 * since: 1.0.0
 */

public class RoleServiceImpl implements RoleService {
    //TODO

    @Override
    public void printRole(Role role) {
        System.out.println(role.toString());
    }


}
