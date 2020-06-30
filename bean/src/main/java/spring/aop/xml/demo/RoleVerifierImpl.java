package spring.aop.xml.demo;

import spring.aop.demo.Role;

import java.util.Objects;

/**
 * FileName: RoleVerifierImpl
 * Author:   haichaoyang3
 * Date:     2020/6/30 10:10
 * Description:
 * History:
 * since: 1.0.0
 */

public class RoleVerifierImpl implements RoleVerifier {
    //TODO

    @Override
    public boolean verify(Role role) {
        return Objects.nonNull(role);
    }
}
