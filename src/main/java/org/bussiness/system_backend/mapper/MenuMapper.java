package org.bussiness.system_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.bussiness.system_backend.entity.Menu;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据菜单类型获取菜单列表
     * @param menuType 菜单类型获
     * @return
     */
    @Results(id = "menuMap")
    @Select("SELECT * FROM a_menu WHERE menu_type = #{menuType}")
    List<Menu> getMenuListByMenuType(@Param("menuType") Integer menuType);
}
