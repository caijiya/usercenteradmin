package com.zy.usercenteradmin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 部门
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "dept")
public class Dept extends BaseEntity implements Serializable {
    /**
     * 父id
     */
    @TableField(value = "pid")
    private Integer pid;

    /**
     * 部门名称
     */
    @TableField(value = "dept_name")
    private String deptName;

    /**
     * 部门简称
     */
    @TableField(value = "dept_abbreviation")
    private String deptAbbreviation;

    /**
     * 部门层级数
     */
    @TableField(value = "dept_level")
    private Integer deptLevel;

    /**
     * 所有父节点id
     */
    @TableField(value = "dept_code")
    private String deptCode;

    /**
     * 联系方式
     */
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 部门备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 排序号
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 是否启用
     */
    @TableField(value = "is_enabled")
    private Byte isEnabled;

    private static final long serialVersionUID = 1L;
}