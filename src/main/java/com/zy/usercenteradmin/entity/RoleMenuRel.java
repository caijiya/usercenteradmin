package com.zy.usercenteradmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "role_id", type = IdType.INPUT)
    private Integer roleId;

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.INPUT)
    private Integer menuId;

    private static final long serialVersionUID = 1L;
}