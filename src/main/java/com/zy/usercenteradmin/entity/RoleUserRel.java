package com.zy.usercenteradmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 角色用户关联表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "role_user_rel")
public class RoleUserRel extends BaseEntity implements Serializable {
    @TableId(value = "user_id", type = IdType.INPUT)
    private Integer userId;

    @TableField(value = "role_id")
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}