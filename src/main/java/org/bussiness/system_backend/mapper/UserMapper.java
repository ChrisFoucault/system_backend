package org.bussiness.system_backend.mapper;

import org.apache.ibatis.annotations.*;
import org.bussiness.system_backend.entity.User;

@Mapper
public interface UserMapper {

    @Select("""
        SELECT id, username, password, real_name, create_time, is_delete
        FROM sys_user
        WHERE username = #{username}
        LIMIT 1
        """)
    @Results(id = "userMap", value = {
        @Result(column = "id", property = "id"),
        @Result(column = "username", property = "username"),
        @Result(column = "password", property = "password"),
        @Result(column = "real_name", property = "realName"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "is_delete", property = "isDelete")
    })
    User findByUsername(@Param("username") String username);

    @Insert("""
        INSERT INTO sys_user(username, password, real_name, create_time, is_delete)
        VALUES(#{username}, #{password}, #{realName}, #{createTime}, #{isDelete})
        """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    @Update("""
        UPDATE sys_user
        SET username = #{username},
            password = #{password},
            real_name = #{realName},
            is_delete = #{isDelete}
        WHERE id = #{id}
        """)
    int updateById(User user);

    default void save(User user) {
        if (user == null) return;
        if (user.getId() == null) {
            insert(user);
        } else {
            updateById(user);
        }
    }
}
