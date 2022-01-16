package com.zy.usercenteradmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zy.usercenteradmin.dto.MenuDTO;
import com.zy.usercenteradmin.entity.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {


    List<MenuDTO> menuTree();
}








