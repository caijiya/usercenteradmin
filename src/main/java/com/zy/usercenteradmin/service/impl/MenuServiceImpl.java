package com.zy.usercenteradmin.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.usercenteradmin.dto.MenuDTO;
import com.zy.usercenteradmin.entity.Menu;
import com.zy.usercenteradmin.repository.MenuMapper;
import com.zy.usercenteradmin.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public List<MenuDTO> menuTree() {
        List<Menu> menus = this.list(new LambdaQueryWrapper<Menu>().in(Menu::getMenuType, "M", "C"));
        List<MenuDTO> menuDTOS = JSONUtil.toList(JSONUtil.toJsonStr(menus), MenuDTO.class);
        List<MenuDTO> tree = menuDTOS.stream().filter(menu ->
                menu.getPid() == 0
        ).map((menu) -> {
            menu.setChildren(getChild(menu, menuDTOS));
            return menu;
        }).sorted(Comparator.comparingInt(Menu::getSort)).collect(Collectors.toList());
        return tree;
    }

    private List<MenuDTO> getChild(MenuDTO root, List<MenuDTO> all) {
        List<MenuDTO> child = all.stream().filter(menu ->
                menu.getPid().equals(root.getId())).map((menu) -> {
            menu.setChildren(getChild(menu, all));
            return menu;
        }).sorted(Comparator.comparingInt(Menu::getSort)).collect(Collectors.toList());
        return child;
    }
}








