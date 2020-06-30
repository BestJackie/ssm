package com.jc.yhc.spring.bean.factory;

import com.jc.yhc.spring.ioc.overview.domain.User;

public interface UserFactory {

    default User createUser(){
        User user = new User();
        user.setName("zwz");
        user.setAge(18);
        return user;
    }
}
