package com.zy.usercenteradmin.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.usercenteradmin.dto.UserDTO;
import com.zy.usercenteradmin.dto.UserPageDTO;
import com.zy.usercenteradmin.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    UserDTO userDetail(Integer id);

    IPage<UserDTO> pageList(UserPageDTO userPageDTO);
}