package com.zy.usercenteradmin.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.usercenteradmin.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {
}