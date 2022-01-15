package com.zy.usercenteradmin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 资源
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "menu")
public class Menu extends BaseEntity implements Serializable {
    /**
     * 父id
     */
    @TableField(value = "pid")
    private Integer pid;

    /**
     * 资源名称
     */
    @TableField(value = "resource_name")
    private String resourceName;

    /**
     * 资源类型
     */
    @TableField(value = "resource_type")
    private String resourceType;

    /**
     * 资源uri
     */
    @TableField(value = "resource_uri")
    private String resourceUri;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 权限标识
     */
    @TableField(value = "permission")
    private String permission;

    /**
     * 路由地址
     */
    @TableField(value = "lydz")
    private String lydz;

    /**
     * 组件路径
     */
    @TableField(value = "zjlj")
    private String zjlj;

    /**
     * 是否启用
     */
    @TableField(value = "is_enabled")
    private Byte isEnabled;

    /**
     * 排序号
     */
    @TableField(value = "sort")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}