package spring.aop.anno.demo;

import spring.aop.demo.Role;

import java.util.Objects;

/**
 * FileName: RoleVerifierImpl
 * Author:   haichaoyang3
 * Date:     2020/6/29 13:48
 * Description:
 * History:
 * since: 1.0.0
 */

public class RoleVerifierImpl implements RoleVerifier{
    @Override
    public boolean verify(Role role) {
        return Objects.nonNull(role);
    }
}
