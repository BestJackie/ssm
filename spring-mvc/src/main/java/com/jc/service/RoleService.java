package com.jc.service;

import com.jc.pojo.Role;

import java.util.List;

public interface RoleService {
    Role getRole(Integer id);
    int addRoles(List<Role> roleList);

    void addRole(Role role);

    List<Role> getAllRoles();
}
