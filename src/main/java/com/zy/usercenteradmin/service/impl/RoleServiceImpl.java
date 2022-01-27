package com.zy.usercenteradmin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.usercenteradmin.dto.GrantMenuDTO;
import com.zy.usercenteradmin.entity.Menu;
import com.zy.usercenteradmin.entity.Role;
import com.zy.usercenteradmin.entity.RoleMenuRel;
import com.zy.usercenteradmin.repository.RoleMapper;
import com.zy.usercenteradmin.service.MenuService;
import com.zy.usercenteradmin.service.RoleMenuRelService;
import com.zy.usercenteradmin.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    RoleMenuRelService roleMenuRelService;
    @Resource
    MenuService menuService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void grantMenus(GrantMenuDTO grantMenuDTO) {
        roleMenuRelService.remove(new LambdaQueryWrapper<RoleMenuRel>().eq(RoleMenuRel::getRoleId, grantMenuDTO.getRoleId()));
        roleMenuRelService.saveBatch(grantMenuDTO.getMenuIds().stream().map(menuId -> {
            RoleMenuRel roleMenuRel = new RoleMenuRel();
            roleMenuRel.setRoleId(roleMenuRel.getRoleId());
            roleMenuRel.setMenuId(menuId);
            return roleMenuRel;
        }).collect(Collectors.toList()));
    }

    @Override
    public List<Menu> menusByRoleId(Integer roleId) {
        List<RoleMenuRel> roleMenuRels = roleMenuRelService.list(new LambdaQueryWrapper<RoleMenuRel>().eq(RoleMenuRel::getRoleId, roleId));
        if (CollUtil.isEmpty(roleMenuRels)) {
            return Collections.EMPTY_LIST;
        }
        return menuService.list(new LambdaQueryWrapper<Menu>().in(Menu::getId, roleMenuRels.stream().map(RoleMenuRel::getMenuId).collect(Collectors.toList())));
    }
}








