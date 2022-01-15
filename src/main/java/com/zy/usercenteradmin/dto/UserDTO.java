/**
 * @Author: ZhaoYang
 * @Date: 2022/1/15
 */
package com.zy.usercenteradmin.dto;

import com.zy.usercenteradmin.entity.Dept;
import com.zy.usercenteradmin.entity.Role;
import com.zy.usercenteradmin.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO extends User {
    private Dept dept;
    private List<Role> roles;
}
