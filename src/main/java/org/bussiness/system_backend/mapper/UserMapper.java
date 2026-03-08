package org.bussiness.system_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.bussiness.system_backend.entity.User;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户对象，如果不存在则返回 null
     */
    @Results(id = "userMap")
    @Select("SELECT * FROM a_user WHERE username = #{username}")
    User findByUsername(@Param("username") String username);
}
