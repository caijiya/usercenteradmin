package com.zy.usercenteradmin.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.usercenteradmin.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> menusByUserId(@Param("userId") Integer userId);
}