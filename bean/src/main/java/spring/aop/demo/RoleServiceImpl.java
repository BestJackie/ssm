package spring.aop.demo;

/**
 * FileName: RoleServiceImpl
 * Author:   haichaoyang3
 * Date:     2020/6/28 14:08
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
