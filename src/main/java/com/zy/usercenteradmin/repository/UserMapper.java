package com.zy.usercenteradmin.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.usercenteradmin.dto.UserDTO;
import com.zy.usercenteradmin.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    UserDTO userDetail(Integer id);
}