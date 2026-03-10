package org.bussiness.system_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.bussiness.system_backend.VO.MenuVO;
import org.bussiness.system_backend.constants.ConstantEnums;
import org.bussiness.system_backend.entity.Menu;
import org.bussiness.system_backend.mapper.MenuMapper;
import org.bussiness.system_backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 获取菜单树
     *
     * @return 菜单树列表
     */
    public List<MenuVO> getMenuTree() {
        List<Menu> firstMenuList = menuMapper.getMenuListByMenuType(ConstantEnums.MenuType.一级菜单.getValue());
        List<Menu> secondMenuList = menuMapper.getMenuListByMenuType(ConstantEnums.MenuType.二级菜单.getValue());
        List<MenuVO> result = new ArrayList();
        for (Menu firstMenu : firstMenuList) {
            
        }
        return result;
    }
}