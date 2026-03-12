package org.bussiness.system_backend.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import org.bussiness.system_backend.VO.MenuVO;
import org.bussiness.system_backend.entity.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {

    /** 获取菜单树
     * @return 菜单树列表
     */
    List<Tree<Integer>> getMenuTree();

}
