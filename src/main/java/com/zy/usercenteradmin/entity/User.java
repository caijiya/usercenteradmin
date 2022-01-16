package com.zy.usercenteradmin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "`user`")
public class User extends BaseEntity implements Serializable {
    /**
     * 部门ID
     */
    @TableField(value = "dept_id")
    private Integer deptId;

    /**
     * 登录账号
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 盐值
     */
    @TableField(value = "salt")
    private String salt;

    /**
     * 是否启用。0：禁用，1：启用
     */
    @TableField(value = "enabled")
    private Byte enabled;

    /**
     * 性别
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    private static final long serialVersionUID = 1L;
}