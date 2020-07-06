package ssm.jc.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
        PlatformTransactionManager tm = ctx.getBean(PlatformTransactionManager.class);
        JdbcTemplate template = ctx.getBean(JdbcTemplate.class);
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();

        TransactionStatus transactionStatus = tm.getTransaction(transactionDefinition);
        try {
            template.update("insert into t_role(role_name,note) values ('role_name_program_tx','program')");
            tm.commit(transactionStatus);
        } catch (Exception e) {
            tm.rollback(transactionStatus);
        }

    }
}
