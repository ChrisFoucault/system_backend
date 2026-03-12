package org.bussiness.system_backend.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.bussiness.system_backend.VO.MenuVO;
import org.bussiness.system_backend.constants.ConstantEnums;
import org.bussiness.system_backend.entity.Menu;
import org.bussiness.system_backend.mapper.MenuMapper;
import org.bussiness.system_backend.service.MenuService;
import org.springframework.beans.BeanUtils;
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
     * @return 菜单树列表
     */
    public List<Tree<Integer>> getMenuTree() {
        List<Menu> menuList = this.list();
        List<Tree<Integer>> menuTree = TreeUtil.build(menuList, null, (node, tree) -> {
            tree.setId(node.getId());
            tree.setParentId(node.getParentId());
            tree.setName(node.getName());
            tree.putExtra("code", node.getCode());
            tree.putExtra("url", node.getUrl());
        });
        return menuTree;
    }
}