package org.bussiness.system_backend.controller;

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

    @GetMapping("/list")
    public List<Menu> list() {
        return menuService.list();
    }

    @GetMapping("/tree")
    public List<Menu> getMenuTree() {
        return menuService.list();
    }

}
