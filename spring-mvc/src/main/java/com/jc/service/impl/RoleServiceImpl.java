package com.jc.service.impl;

import com.jc.dao.RoleMapper;
import com.jc.pojo.Role;
import com.jc.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    public Role getRole(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
