/**
 * @Author: ZhaoYang
 * @Date: 2022/1/15
 */
package com.zy.usercenteradmin.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.zy.usercenteradmin.entity.Role;
import lombok.Data;

@Data
public class RolePageDTO extends Role {
    private PageDTO pageDTO;
}
