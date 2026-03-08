package org.bussiness.system_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.bussiness.system_backend.entity.Role;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}

