package com.zy.usercenteradmin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 角色和菜单关联表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "role_menu_rel")
public class RoleMenuRel extends BaseEntity implements Serializable {
    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     * 菜单ID
     */
    @TableField(value = "menu_id")
    private Integer menuId;

    private static final long serialVersionUID = 1L;
}