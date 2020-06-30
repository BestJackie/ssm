package com.jc.yhc.spring.bean.factory;

import com.jc.yhc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * FileName: UserFactoryBean
 * Author:   haichaoyang3
 * Date:     2020/4/16 10:26
 * Description:{@link User} Bean的{@link org.springframework.beans.factory.FactoryBean}实现
 * History:
 * since: 1.0.0
 */

public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
