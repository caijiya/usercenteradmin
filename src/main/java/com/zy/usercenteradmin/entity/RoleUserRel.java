package com.zy.usercenteradmin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色用户关联表
 */
@Data
@TableName(value = "role_user_rel")
public class RoleUserRel implements Serializable {
    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "role_id")
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}