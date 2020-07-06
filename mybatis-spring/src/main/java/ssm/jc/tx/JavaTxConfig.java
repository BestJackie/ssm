package ssm.jc.tx;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

/**
 * FileName: JavaTxConfig
 * Author:   haichaoyang3
 * Date:     2020/7/6 9:53
 * Description: 用Java配置方式实现spring数据库事务
 * History:
 * since: 1.0.0
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
public class JavaTxConfig implements TransactionManagementConfigurer {

    private DataSource dataSource = null;
    @Bean
    public DataSource dataSource(){
        if (Objects.nonNull(dataSource)){
            return dataSource;
        }
        Properties properties = new Properties();
        properties.setProperty("username","root");
        properties.setProperty("password","123456");
        properties.setProperty("driverClassName","com.mysql.cj.jdbc.Driver");
        properties.setProperty("url","jdbc:mysql://192.168.163.128:3306/test");
        properties.setProperty("maxActive","15");
        properties.setProperty("maxIdle","5");
        properties.setProperty("maxWait","60000");
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());

    }

    @Bean
    @Primary
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }



}
