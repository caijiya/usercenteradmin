package com.zy.usercenteradmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zy.usercenteradmin.dto.DeptDTO;
import com.zy.usercenteradmin.entity.Dept;

import java.util.List;

public interface DeptService extends IService<Dept> {


    List<DeptDTO> deptTree();
}






