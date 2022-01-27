package com.zy.usercenteradmin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zy.usercenteradmin.dto.GrantRoleDTO;
import com.zy.usercenteradmin.dto.UserDTO;
import com.zy.usercenteradmin.dto.UserPageDTO;
import com.zy.usercenteradmin.entity.Menu;
import com.zy.usercenteradmin.entity.User;

import java.util.List;

public interface UserService extends IService<User> {


    UserDTO userDetail(Integer id);

    void addUser(User user);

    void grantRole(GrantRoleDTO grantRoleDTO);

    IPage<UserDTO> pageList(UserPageDTO userPageDTO);

    void resetPassword(String userId);

    List<Menu> menusByUserId(Integer userId);
}







