package org.bussiness.system_backend.controller;

import cn.hutool.core.lang.tree.Tree;
import org.bussiness.system_backend.VO.MenuVO;
import org.bussiness.system_backend.entity.Menu;
import org.bussiness.system_backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/tree")
    public List<Tree<Integer>> getMenuTree() {
        return menuService.getMenuTree();
    }

}
