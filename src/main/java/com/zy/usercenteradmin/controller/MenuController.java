package com.zy.usercenteradmin.controller;

import com.zy.usercenteradmin.dto.MenuDTO;
import com.zy.usercenteradmin.entity.Menu;
import com.zy.usercenteradmin.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    @Resource
    MenuService menuService;

    @PostMapping("add")
    public void addMenu(@RequestBody Menu menu) {
        menuService.save(menu);
    }

    @PostMapping("update")
    public void updateMenu(@RequestBody Menu menu) {
        menuService.updateById(menu);
    }

    @DeleteMapping("{id}")
    public void deleteMenu(@PathVariable Integer id) {
        menuService.removeById(id);
    }

    @GetMapping("{id}")
    public Menu menuDetail(@PathVariable Integer id) {
        return menuService.getById(id);
    }

    @GetMapping("tree")
    public List<MenuDTO> menuTree() {
        return menuService.menuTree();
    }
}
