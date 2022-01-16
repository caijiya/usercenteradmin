package com.zy.usercenteradmin.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/17
 */
@Data
public class GrantRoleDTO {
    private Integer userId;
    private List<Integer> roleIds;
}
