package com.jc.service.impl;

import com.jc.dao.RoleMapper;
import com.jc.pojo.Role;
import com.jc.pojo.RoleExample;
import com.jc.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * FileName: RoleServiceImpl
 *
 * @author: haichaoyang3
 * @date: 2020/7/8 17:04
 * Description:
 * History:
 * since: 1.0.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public Role getRole(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
    @Override
    public int addRoles(List<Role> roleList) {
        int count = 0;
        for (Role role : roleList) {
            roleMapper.insertSelective(role);
            count++;
        }
        return count;
    }
    @Override
    public void addRole(Role role) {
        roleMapper.insertSelective(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.selectByExample(new RoleExample());
    }
}
