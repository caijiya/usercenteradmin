package com.zy.usercenteradmin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "operate_log")
public class OperateLog extends BaseEntity implements Serializable {
    /**
     * 日志主键
     */
    @TableField(value = "operate_id")
    private Long operateId;

    /**
     * 模块标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @TableField(value = "business_type")
    private Integer businessType;

    /**
     * 方法名称
     */
    @TableField(value = "`method`")
    private String method;

    /**
     * 请求方式
     */
    @TableField(value = "request_method")
    private String requestMethod;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @TableField(value = "operator_type")
    private Integer operatorType;

    /**
     * 操作人员
     */
    @TableField(value = "operate_name")
    private String operateName;

    /**
     * 部门名称
     */
    @TableField(value = "dept_name")
    private String deptName;

    /**
     * 请求URL
     */
    @TableField(value = "operate_url")
    private String operateUrl;

    /**
     * 主机地址
     */
    @TableField(value = "operate_ip")
    private String operateIp;

    /**
     * 操作地点
     */
    @TableField(value = "operate_location")
    private String operateLocation;

    /**
     * 请求参数
     */
    @TableField(value = "operate_param")
    private String operateParam;

    /**
     * 操作状态（0正常 1异常）
     */
    @TableField(value = "operate_status")
    private Integer operateStatus;

    /**
     * 错误消息
     */
    @TableField(value = "error_msg")
    private String errorMsg;

    /**
     * 操作时间
     */
    @TableField(value = "operate_time")
    private Date operateTime;

    private static final long serialVersionUID = 1L;
}