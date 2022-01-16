package com.zy.usercenteradmin.controller;

import com.zy.usercenteradmin.dto.DeptDTO;
import com.zy.usercenteradmin.entity.Dept;
import com.zy.usercenteradmin.service.DeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (dept)
 *
 * @author zhaoyang
 */
@RestController
@RequestMapping("dept")
public class DeptController {

    @Resource
    DeptService deptService;

    @PostMapping("add")
    public void addDept(@RequestBody Dept dept) {
        deptService.save(dept);
    }

    @PostMapping("update")
    public void updateDept(@RequestBody Dept dept) {
        deptService.updateById(dept);
    }

    @DeleteMapping("{id}")
    public void deleteDept(@PathVariable Integer id) {
        deptService.removeById(id);
    }

    @GetMapping("{id}")
    public Dept deptDetail(@PathVariable Integer id) {
        return deptService.getById(id);
    }

    @GetMapping("tree")
    public List<DeptDTO> deptTree() {
        return deptService.deptTree();
    }

}
