INSERT INTO usercenter.dept (id, pid, dept_name, dept_abbreviation, dept_level, dept_code, telephone, address, remark,
                             sort, is_enabled, gmt_create, gmt_modified)
VALUES (1, 0, '中国人民共和国', '中国', 1, '1', '15522003457', '亚洲', '960万平方公里', 0, 1, '2022-01-15 07:44:24',
        '2022-01-24 16:58:41');
INSERT INTO usercenter.dept (id, pid, dept_name, dept_abbreviation, dept_level, dept_code, telephone, address, remark,
                             sort, is_enabled, gmt_create, gmt_modified)
VALUES (2, 1, '中国-天津', '天津', 2, '1,2', '13039854495', '天津市', 'tianjin', 1, 1, '2022-01-16 08:32:31',
        '2022-01-24 16:58:41');
INSERT INTO usercenter.dept (id, pid, dept_name, dept_abbreviation, dept_level, dept_code, telephone, address, remark,
                             sort, is_enabled, gmt_create, gmt_modified)
VALUES (3, 2, '中国-天津-蓟县', '蓟县', 3, '1,2,3', '13039854495', '蓟县', 'jixian', 1, 1, '2022-01-16 08:34:12',
        '2022-01-24 16:58:41');
INSERT INTO usercenter.dept (id, pid, dept_name, dept_abbreviation, dept_level, dept_code, telephone, address, remark,
                             sort, is_enabled, gmt_create, gmt_modified)
VALUES (4, 1, '中国-北京', '北京', 3, '1,4', '13039854495', '北京', 'jixian', 1, 1, '2022-01-16 08:35:01',
        '2022-01-24 16:58:41');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1, '系统管理', 0, 1, 'system', 'Layout', 1, 0, 'M', 0, 0, '1', 'system', 'admin', '2022-01-23 08:08:53', 'admin',
        '2021-08-13 16:35:52', '系统管理目录');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', 1, 0, 'C', 0, 0, 'system:user:list', 'user', 'admin',
        '2021-08-02 16:45:13', 'admin', '2021-08-03 13:48:04', '用户管理菜单');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', 1, 0, 'C', 0, 0, 'system:role:list', 'peoples', 'admin',
        '2021-08-02 16:45:13', '', null, '角色管理菜单');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', 1, 0, 'C', 0, 0, 'system:menu:list', 'tree-table', 'admin',
        '2021-08-02 16:45:13', '', null, '菜单管理菜单');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', 1, 0, 'C', 0, 0, 'system:dept:list', 'tree', 'admin',
        '2021-08-02 16:45:13', 'admin', '2021-08-12 10:59:54', '部门管理菜单');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', 1, 0, 'C', 0, 0, 'system:dict:list', 'dict', 'admin',
        '2021-08-02 16:45:13', '', null, '字典管理菜单');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1001, '用户查询', 100, 1, '', '', 1, 0, 'F', 0, 0, 'system:user:query', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1002, '用户新增', 100, 2, '', '', 1, 0, 'F', 0, 0, 'system:user:add', '#', 'admin', '2021-08-02 16:45:13', '', null,
        '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1003, '用户修改', 100, 3, '', '', 1, 0, 'F', 0, 0, 'system:user:edit', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1007, '重置密码', 100, 7, '', '', 1, 0, 'F', 0, 0, 'system:user:resetPwd', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1008, '角色查询', 101, 1, '', '', 1, 0, 'F', 0, 0, 'system:role:query', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1009, '角色新增', 101, 2, '', '', 1, 0, 'F', 0, 0, 'system:role:add', '#', 'admin', '2021-08-02 16:45:13', '', null,
        '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1010, '角色修改', 101, 3, '', '', 1, 0, 'F', 0, 0, 'system:role:edit', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1013, '菜单查询', 102, 1, '', '', 1, 0, 'F', 0, 0, 'system:menu:query', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1014, '菜单新增', 102, 2, '', '', 1, 0, 'F', 0, 0, 'system:menu:add', '#', 'admin', '2021-08-02 16:45:13', '', null,
        '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1015, '菜单修改', 102, 3, '', '', 1, 0, 'F', 0, 0, 'system:menu:edit', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1017, '部门查询', 103, 1, '', '', 1, 0, 'F', 0, 0, 'system:dept:query', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1018, '部门新增', 103, 2, '', '', 1, 0, 'F', 0, 0, 'system:dept:add', '#', 'admin', '2021-08-02 16:45:13', '', null,
        '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1019, '部门修改', 103, 3, '', '', 1, 0, 'F', 0, 0, 'system:dept:edit', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1026, '字典查询', 105, 1, '#', '', 1, 0, 'F', 0, 0, 'system:dict:query', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1027, '字典新增', 105, 2, '#', '', 1, 0, 'F', 0, 0, 'system:dict:add', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1028, '字典修改', 105, 3, '#', '', 1, 0, 'F', 0, 0, 'system:dict:edit', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.menu (id, menu_name, pid, sort, path, component, is_frame, is_cache, menu_type, visible, status,
                             perms, icon, create_by, gmt_create, update_by, gmt_modified, remark)
VALUES (1029, '字典删除', 105, 4, '#', '', 1, 0, 'F', 0, 0, 'system:dict:remove', '#', 'admin', '2021-08-02 16:45:13', '',
        null, '');
INSERT INTO usercenter.role (id, role_name, role_code, is_enabled, gmt_create, gmt_modified, remark)
VALUES (1, '系统管理员', 'XTGLY', 1, '2022-01-15 07:42:26', '2022-01-15 07:42:26', null);
INSERT INTO usercenter.role (id, role_name, role_code, is_enabled, gmt_create, gmt_modified, remark)
VALUES (2, '普通用户', 'PTYH', 1, '2022-01-24 16:41:17', '2022-01-24 16:41:17', null);
INSERT INTO usercenter.role_user_rel (role_id, user_id)
VALUES (1, 8);
INSERT INTO usercenter.role_user_rel (role_id, user_id)
VALUES (2, 8);
INSERT INTO usercenter.test (id, auto)
VALUES (102, 1);
INSERT INTO usercenter.user (id, dept_id, username, password, salt, enabled, gender, nick_name, gmt_create,
                             gmt_modified)
VALUES (1, 1, 'CC', '', null, 1, 'MALE', '曹操', '2022-01-15 08:48:45', '2022-01-15 08:48:45');
INSERT INTO usercenter.user (id, dept_id, username, password, salt, enabled, gender, nick_name, gmt_create,
                             gmt_modified)
VALUES (2, 1, 'XC', '', null, 1, 'MALE', '许褚', '2022-01-15 08:48:45', '2022-01-15 08:48:45');
INSERT INTO usercenter.user (id, dept_id, username, password, salt, enabled, gender, nick_name, gmt_create,
                             gmt_modified)
VALUES (3, 2, 'LB', '', null, 1, 'MALE', '刘备', '2022-01-15 08:48:45', '2022-01-15 08:48:45');
INSERT INTO usercenter.user (id, dept_id, username, password, salt, enabled, gender, nick_name, gmt_create,
                             gmt_modified)
VALUES (4, 2, 'GY', '', null, 1, 'MALE', '关羽', '2022-01-15 08:48:45', '2022-01-15 08:48:45');
INSERT INTO usercenter.user (id, dept_id, username, password, salt, enabled, gender, nick_name, gmt_create,
                             gmt_modified)
VALUES (5, 2, 'ZF', '', null, 1, 'MALE', '张飞', '2022-01-15 08:48:45', '2022-01-15 08:48:45');
INSERT INTO usercenter.user (id, dept_id, username, password, salt, enabled, gender, nick_name, gmt_create,
                             gmt_modified)
VALUES (6, 3, 'SQ', '', null, 1, 'MALE', '孙权', '2022-01-15 08:48:45', '2022-01-15 08:48:45');
INSERT INTO usercenter.user (id, dept_id, username, password, salt, enabled, gender, nick_name, gmt_create,
                             gmt_modified)
VALUES (7, 3, 'SSX', '', null, 1, 'FEMALE', '孙尚香', '2022-01-15 08:48:45', '2022-01-15 08:48:45');
INSERT INTO usercenter.user (id, dept_id, username, password, salt, enabled, gender, nick_name, gmt_create,
                             gmt_modified)
VALUES (8, 3, 'admin', '56ae8614ec307135214d460e1c59af1e', 'afd277b6-3fdc-40b0-8551-a4e96b47802e', 1, '男', '超级管理员',
        '2022-01-16 04:00:56', '2022-01-24 16:46:21');
