package ssm.jc.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ssm.jc.pojo.Role;
import ssm.jc.service.RoleListService;
import ssm.jc.service.RoleService;

import java.util.List;

/**
 * FileName: RoleListServiceImpl
 *
 * @author: haichaoyang3
 * @date: 2020/7/6 16:05
 * Description:
 * History:
 * since: 1.0.0
 */
@Service
@Log4j
public class RoleListServiceImpl implements RoleListService {
    @Autowired
    private RoleService roleService;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public int insertRoleList(List<Role> roleList) {
        int count = 0;
        for (Role role : roleList) {
            try {
                count+=roleService.insertRole(role);
            }catch (Exception e){
                log.info(e);
            }
        }
        return count;
    }
}
