package com.zy.usercenteradmin.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.digest.DigestUtil;
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

    @Override
    public void addUser(User user) {
        String salt = UUID.randomUUID().toString();
        String password = DigestUtil.md5Hex(salt + user.getPassword());
        user.setPassword(password);
        user.setSalt(salt);
        this.save(user);
    }
}






