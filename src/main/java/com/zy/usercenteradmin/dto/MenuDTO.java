package com.zy.usercenteradmin.dto;

import com.zy.usercenteradmin.entity.Menu;
import lombok.Data;

import java.util.List;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
@Data
public class MenuDTO extends Menu {
    private List<MenuDTO> children;
}
