create table dept
(
    id                int unsigned auto_increment comment 'ID'
        primary key,
    pid               int unsigned                               not null comment '父id',
    dept_name         varchar(100)                               not null comment '部门名称',
    dept_abbreviation varchar(30)                                null comment '部门简称',
    dept_level        int unsigned                               not null comment '部门层级数',
    dept_code         varchar(200)                               not null comment '所有父节点id',
    telephone         varchar(50)                                null comment '联系方式',
    address           varchar(100)                               null comment '地址',
    remark            varchar(200)                               null comment '部门备注',
    sort              int unsigned     default '0'               null comment '排序号',
    is_enabled        tinyint unsigned default '1'               not null comment '是否启用',
    gmt_create        timestamp        default CURRENT_TIMESTAMP not null comment '创建时间',
    gmt_modified      timestamp        default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '部门';

create table login_log
(
    id             int unsigned auto_increment
        primary key,
    info_id        int                  null comment '访问ID',
    username       varchar(50)          null comment '登录账号',
    ipaddr         varchar(50)          null comment '登录IP地址',
    login_location varchar(255)         null comment '登录地点',
    result         tinyint(1) default 1 null comment '登录状态（0成功 1失败）',
    login_time     datetime             null comment '访问时间',
    msg            varchar(255)         null comment '错误信息',
    user_agent     varchar(400)         null comment 'agent信息'
)
    comment '系统访问记录';

create table menu
(
    id           int auto_increment comment '菜单ID'
        primary key,
    menu_name    varchar(50)                            not null comment '菜单名称',
    pid          int          default 0                 null comment '父菜单ID',
    sort         int          default 0                 null comment '显示顺序',
    path         varchar(200) default ''                null comment '路由地址',
    component    varchar(255)                           null comment '组件路径',
    is_frame     tinyint(1)   default 0                 null comment '是否为外链（0是 1否）',
    is_cache     tinyint(1)   default 0                 null comment '是否缓存（0缓存 1不缓存）',
    menu_type    char         default ''                null comment '菜单类型（M目录 C菜单 F按钮）',
    visible      tinyint(1)   default 0                 null comment '菜单状态（2隐藏 1显示）',
    status       tinyint(1)   default 1                 null comment '菜单状态（1正常 0停用）',
    perms        varchar(100)                           null comment '权限标识',
    icon         varchar(100) default '#'               null comment '菜单图标',
    create_by    varchar(64)                            null comment '创建者',
    gmt_create   timestamp    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    update_by    varchar(64)  default ''                null comment '更新者',
    gmt_modified datetime                               null comment '更新时间',
    remark       varchar(500) default ''                null comment '备注'
)
    comment '菜单权限表';

create table operate_log
(
    id               bigint unsigned auto_increment
        primary key,
    operate_id       bigint        null comment '日志主键',
    title            varchar(50)   null comment '模块标题',
    business_type    int default 0 null comment '业务类型（0其它 1新增 2修改 3删除）',
    method           varchar(100)  null comment '方法名称',
    request_method   varchar(10)   null comment '请求方式',
    operator_type    int default 0 null comment '操作类别（0其它 1后台用户 2手机端用户）',
    operate_name     varchar(50)   null comment '操作人员',
    dept_name        varchar(50)   null comment '部门名称',
    operate_url      varchar(255)  null comment '请求URL',
    operate_ip       varchar(50)   null comment '主机地址',
    operate_location varchar(255)  null comment '操作地点',
    operate_param    varchar(2000) null comment '请求参数',
    operate_status   int default 0 null comment '操作状态（0正常 1异常）',
    error_msg        varchar(2000) null comment '错误消息',
    operate_time     datetime      null comment '操作时间'
)
    comment '操作日志记录';

create table role
(
    id           int auto_increment
        primary key,
    role_name    varchar(50)                                null comment '角色名称',
    role_code    varchar(50)                                null comment '角色编码',
    is_enabled   tinyint unsigned default '1'               not null comment '是否启用',
    gmt_create   timestamp        default CURRENT_TIMESTAMP not null comment '创建时间',
    gmt_modified timestamp        default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    remark       varchar(200)                               null comment '备注',
    constraint role_id_uindex
        unique (id)
)
    comment '角色';

create table role_menu_rel
(
    role_id int not null comment '角色ID',
    menu_id int not null comment '菜单ID',
    primary key (role_id, menu_id)
)
    comment '角色和菜单关联表';

create table role_user_rel
(
    role_id int not null,
    user_id int not null,
    primary key (user_id, role_id)
)
    comment '角色用户关联表';

create table test
(
    id   int auto_increment
        primary key,
    auto int not null,
    constraint test_auto_uindex
        unique (auto),
    constraint test_id_uindex
        unique (id)
);

create table user
(
    id           int unsigned auto_increment comment 'ID'
        primary key,
    dept_id      int unsigned                               null comment '部门ID',
    username     varchar(8)                                 not null comment '登录账号',
    password     varchar(100)                               not null comment '密码',
    salt         varchar(4000)                              null comment '盐值',
    enabled      tinyint unsigned default '1'               not null comment '是否启用。0：禁用，1：启用',
    gender       varchar(10)                                not null comment '性别',
    nick_name    varchar(50)                                null comment '昵称',
    gmt_create   timestamp        default CURRENT_TIMESTAMP null,
    gmt_modified timestamp        default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint name
        unique (username),
    constraint user_id_uindex
        unique (id)
)
    comment '用户';

create index department_id
    on user (dept_id);

