package ssm.jc;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.jc.dao.RoleMapper;
import ssm.jc.pojo.Role;

/**
 * FileName: TMain
 * Author:   haichaoyang3
 * Date:     2020/7/4 10:45
 * Description:
 * History:
 * since: 1.0.0
 */

public class TMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-cfg.xml");
        /*SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate) ctx.getBean("sqlSessionTemplate");
        Role role = new Role();
        role.setRoleName("role_name_sqlSessionTemplate");
        role.setNote("note_sqlSessionTemplate");
        sqlSessionTemplate.insert("ssm.jc.dao.RoleMapper.insertRole",role);*/
       /* RoleMapper roleMapper = (RoleMapper) ctx.getBean("roleMapper");
        Role role = new Role();
        role.setRoleName("role_name_mapperFactoryBean");
        role.setNote("mapperFactoryBean");
        roleMapper.insertRole(role);*/
       /* RoleMapper roleMapper = ctx.getBean(RoleMapper.class);
        Role role = new Role();
        role.setRoleName("role_name_mapperScanConfig");
        role.setNote("mapperScanConfig");
        roleMapper.insertRole(role);*/
        RoleMapper roleMapper = ctx.getBean(RoleMapper.class);
        Role role = new Role();
        role.setRoleName("role_name_baseMapper");
        role.setNote("baseMapper");
        roleMapper.insertRole(role);


    }
}
