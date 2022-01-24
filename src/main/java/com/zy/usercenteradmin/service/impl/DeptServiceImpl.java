package com.zy.usercenteradmin.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.usercenteradmin.dto.DeptDTO;
import com.zy.usercenteradmin.entity.Dept;
import com.zy.usercenteradmin.repository.DeptMapper;
import com.zy.usercenteradmin.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Override
    public List<DeptDTO> deptTree() {
        List<Dept> depts = this.list();
        List<DeptDTO> deptDTOS = JSONUtil.toList(JSONUtil.toJsonStr(depts), DeptDTO.class);
        List<DeptDTO> tree = deptDTOS.stream().filter(dept ->
                dept.getPid() == 0
        ).peek(dept -> dept.setChildren(getChild(dept, deptDTOS))).sorted(Comparator.comparingInt(Dept::getSort)).collect(Collectors.toList());
        return tree;
    }

    private List<DeptDTO> getChild(DeptDTO root, List<DeptDTO> all) {
        List<DeptDTO> child = all.stream().filter(dept ->
                dept.getPid().equals(root.getId())).peek((dept) -> dept.setChildren(getChild(dept, all))).collect(Collectors.toList());
        return child;
    }
}






