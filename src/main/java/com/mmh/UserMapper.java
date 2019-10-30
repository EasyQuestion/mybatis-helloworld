package com.mmh;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**根据用户ID获取用户信息*/
    @Select("select * from t_user where id = #{id}")
    User getById(Long id);
}
