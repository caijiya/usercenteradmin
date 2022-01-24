package com.zy.usercenteradmin.dto;

import com.zy.usercenteradmin.entity.Dept;
import com.zy.usercenteradmin.entity.Role;
import com.zy.usercenteradmin.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/22
 * 用户全量信息
 */
@Data
public class UserPermissionDTO {
    private User user;
    private List<Role> roleList;
    private Dept dept;
    private List<MenuDTO> menus;
}
