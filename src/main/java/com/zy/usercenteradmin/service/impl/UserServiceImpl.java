package com.zy.usercenteradmin.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.usercenteradmin.dto.GrantRoleDTO;
import com.zy.usercenteradmin.dto.UserDTO;
import com.zy.usercenteradmin.dto.UserPageDTO;
import com.zy.usercenteradmin.entity.RoleUserRel;
import com.zy.usercenteradmin.entity.User;
import com.zy.usercenteradmin.repository.UserMapper;
import com.zy.usercenteradmin.service.RoleUserRelService;
import com.zy.usercenteradmin.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.zy.usercenteradmin.common.Constants.DEFAULT_PASSWORD;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    RoleUserRelService roleUserRelService;


    @Override
    public UserDTO userDetail(Integer id) {
        return userMapper.userDetail(id);
    }

    @Override
    public void addUser(User user) {
        String salt = UUID.randomUUID().toString();
        String password = DigestUtil.md5Hex(salt + user.getPassword());
        user.setPassword(password);
        user.setSalt(salt);
        this.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void grantRole(GrantRoleDTO grantRoleDTO) {
        roleUserRelService.remove(new LambdaQueryWrapper<RoleUserRel>().eq(RoleUserRel::getUserId, grantRoleDTO.getUserId()));
        Integer userId = grantRoleDTO.getUserId();
        List<RoleUserRel> roleUserRels = new ArrayList<>();
        grantRoleDTO.getRoleIds().forEach(roleId -> {
            RoleUserRel roleUserRel = new RoleUserRel();
            roleUserRel.setRoleId(roleId);
            roleUserRel.setUserId(userId);
            roleUserRels.add(roleUserRel);
        });
        roleUserRelService.saveBatch(roleUserRels);
    }

    @Override
    public IPage<UserDTO> pageList(UserPageDTO userPageDTO) {
        return userMapper.pageList(userPageDTO);
    }

    @Override
    public void resetPassword(String userId) {
        User user = this.getById(userId);
        String password = DigestUtil.md5Hex(user.getSalt() + DEFAULT_PASSWORD);
        user.setPassword(password);
        this.updateById(user);
    }
}






