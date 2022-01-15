package com.zy.usercenteradmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zy.usercenteradmin.dto.UserDTO;
import com.zy.usercenteradmin.entity.User;

public interface UserService extends IService<User> {


    UserDTO userDetail(Integer id);
}




