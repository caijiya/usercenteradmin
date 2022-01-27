package com.zy.usercenteradmin.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.usercenteradmin.dto.GrantMenuDTO;
import com.zy.usercenteradmin.dto.RolePageDTO;
import com.zy.usercenteradmin.entity.Menu;
import com.zy.usercenteradmin.entity.Role;
import com.zy.usercenteradmin.service.RoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (`role`)
 *
 * @author zhaoyang
 */
@RestController
@RequestMapping("role")
public class RoleController {
    @Resource
    RoleService roleService;

    @PostMapping("pageList")
    public IPage<Role> pageList(@RequestBody RolePageDTO rolePageDTO) {
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<Role>()
                .like(StrUtil.isNotBlank(rolePageDTO.getRoleName()), Role::getRoleName, rolePageDTO.getRoleName())
                .like(StrUtil.isNotBlank(rolePageDTO.getRoleCode()), Role::getRoleCode, rolePageDTO.getRoleCode())
                .eq(rolePageDTO.getIsEnabled() != null, Role::getIsEnabled, rolePageDTO.getIsEnabled());
        return roleService.page(rolePageDTO.getPageDTO(), wrapper);
    }

    @PostMapping("add")
    public void addRole(@RequestBody Role role) {
        roleService.save(role);
    }

    @PostMapping("update")
    public void updateRole(@RequestBody Role role) {
        roleService.updateById(role);
    }

    @DeleteMapping("{id}")
    public void deleteRole(@PathVariable Integer id) {
        roleService.removeById(id);
    }

    @GetMapping("{id}")
    public Role roleDetail(@PathVariable Integer id) {
        return roleService.getById(id);
    }

    @PostMapping("grantMenus")
    public void grantMenus(@RequestBody @Validated GrantMenuDTO grantMenuDTO) {
        roleService.grantMenus(grantMenuDTO);
    }

    @GetMapping("menusByRoleId/{roleId}")
    public List<Menu> menusByRoleId(@PathVariable Integer roleId) {
        return roleService.menusByRoleId(roleId);
    }


}
