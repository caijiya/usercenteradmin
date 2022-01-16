package com.zy.usercenteradmin.dto;

import com.zy.usercenteradmin.entity.Dept;
import lombok.Data;

import java.util.List;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
@Data
public class DeptDTO extends Dept {
    private List<DeptDTO> children;
}
