package org.bussiness.system_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.bussiness.system_backend.constants.ConstantEnums;
import org.bussiness.system_backend.entity.Role;
import org.bussiness.system_backend.mapper.RoleMapper;
import org.bussiness.system_backend.service.RoleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}

