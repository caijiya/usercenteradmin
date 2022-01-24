package com.zy.usercenteradmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.usercenteradmin.entity.LoginLog;
import com.zy.usercenteradmin.repository.LoginLogMapper;
import com.zy.usercenteradmin.service.LoginLogService;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

}
