/**
 * @Author: ZhaoYang
 * @Date: 2022/1/15
 */
package com.zy.usercenteradmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 创建时间
     */
    @TableField
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField
    private Date gmtModified;
}
