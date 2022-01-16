package com.zy.usercenteradmin.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.usercenteradmin.dto.UserDTO;
import com.zy.usercenteradmin.dto.UserPageDTO;
import com.zy.usercenteradmin.entity.User;
import com.zy.usercenteradmin.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public IPage<User> pageList(@RequestBody UserPageDTO userPageDTO) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>().likeRight(StrUtil.isNotBlank(userPageDTO.getNickName()), User::getNickName, userPageDTO.getNickName());
        return userService.page(userPageDTO.getPageDTO(), wrapper);
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

}
