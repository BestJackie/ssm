package com.jc.yhc.spring.ioc.overview.domain;

import com.jc.yhc.spring.ioc.overview.annotation.Super;

/**
 * FileName: SuperUser
 * Author:   haichaoyang3
 * Date:     2020/4/13 17:20
 * Description:
 * History:
 * since: 1.0.0
 */
@Super
public class SuperUser extends User {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "id=" + id +
                "} " + super.toString();
    }
}
