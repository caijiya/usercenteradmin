package com.zy.usercenteradmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.usercenteradmin.dto.UserDTO;
import com.zy.usercenteradmin.entity.User;
import com.zy.usercenteradmin.repository.UserMapper;
import com.zy.usercenteradmin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public UserDTO userDetail(Integer id) {
        return userMapper.userDetail(id);
    }
}





