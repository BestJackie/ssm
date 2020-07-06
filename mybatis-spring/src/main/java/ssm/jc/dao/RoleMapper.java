package ssm.jc.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.jc.pojo.Role;
//@Repository
public interface RoleMapper extends BaseMapper<Role> {

    int insertRole(Role role);
    Role getRole(@Param("id") Long id);
    int updateRole(Role role);
    int deleteRole(@Param("id") Long id);
}
