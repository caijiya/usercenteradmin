package com.zy.usercenteradmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.usercenteradmin.entity.OperateLog;
import com.zy.usercenteradmin.repository.OperateLogMapper;
import com.zy.usercenteradmin.service.OperateLogService;
import org.springframework.stereotype.Service;

@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements OperateLogService {

}
