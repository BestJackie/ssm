package ssm.jc.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ssm.jc.dao.RoleMapper;
import ssm.jc.pojo.Role;
import ssm.jc.service.RoleService;

/**
 * FileName: RoleServiceImpl
 *
 * @author: haichaoyang3
 * @date: 2020/7/6 16:04
 * Description:
 * History:
 * since: 1.0.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Transactional(propagation = Propagation.NESTED,isolation = Isolation.READ_COMMITTED)
    @Override
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);
    }
}
