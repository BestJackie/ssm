package ssm.jc.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.jc.pojo.Role;
import ssm.jc.service.RoleListService;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: ProgramTx
 * Author:   haichaoyang3
 * Date:     2020/7/6 13:42
 * Description: 编程式事务
 * History:
 * since: 1.0.0
 */

public class ProgramTx {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg.xml");
      /*  PlatformTransactionManager tm = ctx.getBean(PlatformTransactionManager.class);
        JdbcTemplate template = ctx.getBean(JdbcTemplate.class);
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();

        TransactionStatus transactionStatus = tm.getTransaction(transactionDefinition);
        try {
            template.update("insert into t_role(role_name,note) values ('role_name_program_tx','program')");
            tm.commit(transactionStatus);
        } catch (Exception e) {
            tm.rollback(transactionStatus);
        }*/

        RoleListService roleListService = ctx.getBean(RoleListService.class);
        List<Role> roleList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Role role = new Role();
            role.setRoleName("role_name_" + i);
            role.setNote("note_" + i);
            roleList.add(role);
        }
        int count = roleListService.insertRoleList(roleList);
        System.out.println(count);

    }
}
