package ssm.jc.dao;

import org.apache.ibatis.annotations.Param;
import ssm.jc.pojo.Role;

public interface BaseMapper<T> {
    int inser(T t);
    T get(@Param("id") Long id);
    int update(T t);
    int delete(@Param("id") Long id);
}
