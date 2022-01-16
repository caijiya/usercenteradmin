package com.zy.rolecenteradmin.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.usercenteradmin.dto.RolePageDTO;
import com.zy.usercenteradmin.entity.Role;
import com.zy.usercenteradmin.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
                .like(StrUtil.isNotBlank(rolePageDTO.getRoleCode()), Role::getRoleCode, rolePageDTO.getRoleCode());
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


}
