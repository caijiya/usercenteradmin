package com.zy.usercenteradmin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.usercenteradmin.dto.GrantRoleDTO;
import com.zy.usercenteradmin.dto.UserDTO;
import com.zy.usercenteradmin.dto.UserPageDTO;
import com.zy.usercenteradmin.entity.Menu;
import com.zy.usercenteradmin.entity.User;
import com.zy.usercenteradmin.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (`user`)
 *
 * @author zhaoyang
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("pageList")
    public IPage<UserDTO> pageList(@RequestBody UserPageDTO userPageDTO) {
        return userService.pageList(userPageDTO);
    }

    @PostMapping("add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping("update")
    public void updateUser(@RequestBody User user) {
        userService.updateById(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.removeById(id);
    }

    @GetMapping("{id}")
    public UserDTO userDetail(@PathVariable Integer id) {
        return userService.userDetail(id);
    }

    @PostMapping("grantRole")
    public void grantRole(@RequestBody GrantRoleDTO grantRoleDTO) {
        userService.grantRole(grantRoleDTO);
    }

    @PostMapping("resetPassword/{userId}")
    public void resetPassword(@PathVariable String userId) {
        userService.resetPassword(userId);
    }

    @GetMapping("menusByUserId/{userId}")
    public List<Menu> menusByUserId(@PathVariable Integer userId) {
        return userService.menusByUserId(userId);
    }

}
