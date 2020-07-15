package com.jc.message.converter;

import com.jc.pojo.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * FileName: String2RoleConventer
 *
 * @author: haichaoyang3
 * @date: 2020/7/14 17:09
 * Description:
 * History:
 * since: 1.0.0
 */

public class String2RoleConverter implements Converter<String, Role> {
    @Override
    public Role convert(String source) {
        if (StringUtils.isEmpty(source))
            return null;
        if (source.indexOf("-") == -1)
            return null;
        String[] strs = source.split("-");
        if (strs.length != 3)
            return null;
        Role role = new Role();
        role.setId(Integer.parseInt(strs[0]));
        role.setRoleName(strs[1]);
        role.setNote(strs[2]);
        return role;
    }
    //TODO
}
