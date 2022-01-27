package com.zy.usercenteradmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zy.usercenteradmin.dto.GrantMenuDTO;
import com.zy.usercenteradmin.entity.Menu;
import com.zy.usercenteradmin.entity.Role;

import java.util.List;

public interface RoleService extends IService<Role> {


    void grantMenus(GrantMenuDTO grantMenuDTO);

    List<Menu> menusByRoleId(Integer roleId);
}








