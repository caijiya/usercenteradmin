package com.zy.usercenteradmin.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/27
 */
@Data
public class GrantMenuDTO {
    @NotNull(message = "角色id不能为空")
    private Integer roleId;
    private List<Integer> menuIds;
}
