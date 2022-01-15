/**
 * @Author: ZhaoYang
 * @Date: 2022/1/15
 */
package com.zy.usercenteradmin.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.zy.usercenteradmin.entity.User;
import lombok.Data;

@Data
public class UserPageDTO extends User {
    private PageDTO pageDTO;
}
