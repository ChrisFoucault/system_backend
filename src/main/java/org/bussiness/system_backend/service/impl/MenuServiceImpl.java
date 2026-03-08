package org.bussiness.system_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.bussiness.system_backend.entity.Menu;
import org.bussiness.system_backend.mapper.MenuMapper;
import org.bussiness.system_backend.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
