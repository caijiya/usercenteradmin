package com.zy.usercenteradmin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统访问记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "login_log")
public class LoginLog extends BaseEntity implements Serializable {
    /**
     * 访问ID
     */
    @TableField(value = "info_id")
    private Integer infoId;

    /**
     * 登录账号
     */
    @TableField(value = "username")
    private String username;

    /**
     * 登录IP地址
     */
    @TableField(value = "ipaddr")
    private String ipaddr;

    /**
     * 登录地点
     */
    @TableField(value = "login_location")
    private String loginLocation;

    /**
     * 登录状态（0成功 1失败）
     */
    @TableField(value = "`result`")
    private Boolean result;

    /**
     * 访问时间
     */
    @TableField(value = "login_time")
    private Date loginTime;

    /**
     * 错误信息
     */
    @TableField(value = "msg")
    private String msg;

    /**
     * agent信息
     */
    @TableField(value = "user_agent")
    private String userAgent;

    private static final long serialVersionUID = 1L;
}