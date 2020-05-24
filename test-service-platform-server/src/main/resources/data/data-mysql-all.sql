DROP DATABASE IF EXISTS `test_service_platform`;
CREATE DATABASE `test_service_platform` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

use `test_service_platform`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='系统配置表';


-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '机构名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级机构ID，一级机构为0',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='机构管理';


-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='字典表';


-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2897 DEFAULT CHARSET=utf8 COMMENT='系统操作日志';


-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `status` varchar(50) DEFAULT NULL COMMENT '登录状态（online:在线，登录初始状态，方便统计在线人数；login:退出登录后将online置为login；logout:退出登录）',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2804 DEFAULT CHARSET=utf8 COMMENT='系统登录日志';


-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='菜单管理';


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色管理';


-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色机构';


-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=623 DEFAULT CHARSET=utf8 COMMENT='角色菜单';


-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `nick_name` varchar(150) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(150) DEFAULT NULL COMMENT '头像',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(40) DEFAULT NULL COMMENT '加密盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='用户管理';


-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COMMENT='用户角色';

use `test_service_platform`;
-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', '#14889A', 'theme', 'color', '主题色', '0', 'admin', '2018-09-23 19:52:54', null, null, '主题色', '0');


-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '测试服务平台', null, '0', 'admin', '2018-09-23 19:35:22', null, null, '0');
INSERT INTO `sys_dept` VALUES ('3', '南京分公司', '1', '0', 'admin', '2020-02-18 16:51:59', null, null, '0');
INSERT INTO `sys_dept` VALUES ('4', '杭州分公司', '1', '0', 'admin', '2020-02-18 16:51:59', null, null, '0');
INSERT INTO `sys_dept` VALUES ('5', '天津分公司', '1', '1', 'admin', '2020-02-18 16:51:59', null, null, '0');
INSERT INTO `sys_dept` VALUES ('6', '重庆分公司', '1', '1', 'admin', '2020-02-18 16:51:59', null, null, '0');
INSERT INTO `sys_dept` VALUES ('7', '技术部', '5', '0', 'admin', '2018-09-23 19:38:00', null, null, '0');
INSERT INTO `sys_dept` VALUES ('8', '技术部', '4', '0', 'admin', '2018-09-23 19:38:10', null, null, '0');
INSERT INTO `sys_dept` VALUES ('9', '技术部', '6', '0', 'admin', '2018-09-23 19:38:17', null, null, '0');
INSERT INTO `sys_dept` VALUES ('10', '市场部', '5', '0', 'admin', '2018-09-23 19:38:45', null, null, '0');
INSERT INTO `sys_dept` VALUES ('11', '市场部', '6', '0', 'admin', '2018-09-23 19:39:01', null, null, '0');

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', 'male', '男', 'sex', '性别', '0', 'admin', '2018-09-23 19:52:54', null, null, '性别', '0');
INSERT INTO `sys_dict` VALUES ('2', 'female', '女', 'sex', '性别', '1', 'admin', '2018-09-23 19:53:17', null, null, '性别', '0');

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', null, 'com.testservice.platform.server.service.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:16', null, null);
INSERT INTO `sys_log` VALUES ('2', 'admin', null, 'com.testservice.platform.server.service.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:17', null, null);
INSERT INTO `sys_log` VALUES ('3', 'admin', null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '36', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:18', null, null);
INSERT INTO `sys_log` VALUES ('4', 'admin', null, 'com.testservice.platform.server.service.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:20', null, null);
INSERT INTO `sys_log` VALUES ('5', 'admin', null, 'com.testservice.platform.server.service.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:20', null, null);
INSERT INTO `sys_log` VALUES ('6', 'admin', null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '27', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:21', null, null);
INSERT INTO `sys_log` VALUES ('7', 'admin', null, 'com.testservice.platform.server.service.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:22', null, null);
INSERT INTO `sys_log` VALUES ('8', 'admin', null, 'com.testservice.platform.server.service.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:23', null, null);
INSERT INTO `sys_log` VALUES ('2798', null, null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findByName()', '\"admin\"', '361', '0:0:0:0:0:0:0:1', null, null, null, null);
INSERT INTO `sys_log` VALUES ('2799', null, null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findByName()', '\"admin\"', '4', '0:0:0:0:0:0:0:1', null, null, null, null);
INSERT INTO `sys_log` VALUES ('2800', null, null, 'com.testservice.platform.server.service.impl.SysMenuServiceImpl.findByUser()', '\"admin\"', '43', '0:0:0:0:0:0:0:1', null, null, null, null);
INSERT INTO `sys_log` VALUES ('2801', null, null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findPermissions()', '\"admin\"', '49', '0:0:0:0:0:0:0:1', null, null, null, null);
INSERT INTO `sys_log` VALUES ('2802', null, null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findByName()', '\"admin\"', '221', '0:0:0:0:0:0:0:1', null, null, null, null);
INSERT INTO `sys_log` VALUES ('2803', null, null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findByName()', '\"admin\"', '3', '0:0:0:0:0:0:0:1', null, null, null, null);
INSERT INTO `sys_log` VALUES ('2804', null, null, 'com.testservice.platform.server.service.impl.SysMenuServiceImpl.findByUser()', '\"admin\"', '37', '0:0:0:0:0:0:0:1', null, null, null, null);
INSERT INTO `sys_log` VALUES ('2805', null, null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findPermissions()', '\"admin\"', '43', '0:0:0:0:0:0:0:1', null, null, null, null);
INSERT INTO `sys_log` VALUES ('2806', 'admin', null, 'com.testservice.platform.server.service.impl.SysLoginLogServiceImpl.writeLoginLog()', '\"admin\"', '138', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:43', null, null);
INSERT INTO `sys_log` VALUES ('2807', 'admin', null, 'com.testservice.platform.server.service.impl.SysMenuServiceImpl.findTree()', '\"admin\"', '15', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:44', null, null);
INSERT INTO `sys_log` VALUES ('2808', 'admin', null, 'com.testservice.platform.server.service.impl.SysMenuServiceImpl.findByUser()', '\"admin\"', '16', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:44', null, null);
INSERT INTO `sys_log` VALUES ('2809', 'admin', null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findPermissions()', '\"admin\"', '22', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:44', null, null);
INSERT INTO `sys_log` VALUES ('2876', 'admin', null, 'com.testservice.platform.server.service.impl.SysLoginLogServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"userName\",\"value\":\"\"}]}', '13', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:10', null, null);
INSERT INTO `sys_log` VALUES ('2877', 'admin', null, 'com.testservice.platform.server.service.impl.SysRoleServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', '15', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:13', null, null);
INSERT INTO `sys_log` VALUES ('2878', 'admin', null, 'com.testservice.platform.server.service.impl.SysMenuServiceImpl.findTree()', 'null', '10', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:13', null, null);
INSERT INTO `sys_log` VALUES ('2879', 'admin', null, 'com.testservice.platform.server.service.impl.SysDeptServiceImpl.findTree()', null, '3', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:14', null, null);
INSERT INTO `sys_log` VALUES ('2880', 'admin', null, 'com.testservice.platform.server.service.impl.SysDeptServiceImpl.findTree()', null, '2', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:14', null, null);
INSERT INTO `sys_log` VALUES ('2881', 'admin', null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', '49', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:14', null, null);
INSERT INTO `sys_log` VALUES ('2882', 'admin', null, 'com.testservice.platform.server.service.impl.SysRoleServiceImpl.findAll()', null, '1', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:14', null, null);
INSERT INTO `sys_log` VALUES ('2883', 'admin', null, 'com.testservice.platform.server.service.impl.SysMenuServiceImpl.findTree()', 'null', '3', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:15', null, null);
INSERT INTO `sys_log` VALUES ('2884', 'admin', null, 'com.testservice.platform.server.service.impl.SysConfigServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"label\",\"value\":\"\"}]}', '8', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:15', null, null);
INSERT INTO `sys_log` VALUES ('2885', 'admin', null, 'com.testservice.platform.server.service.impl.SysLoginLogServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"userName\",\"value\":\"\"}]}', '7', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:16', null, null);
INSERT INTO `sys_log` VALUES ('2886', 'admin', null, 'com.testservice.platform.server.service.impl.SysDeptServiceImpl.findTree()', null, '2', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:22', null, null);
INSERT INTO `sys_log` VALUES ('2887', 'admin', null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', '61', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:22', null, null);
INSERT INTO `sys_log` VALUES ('2888', 'admin', null, 'com.testservice.platform.server.service.impl.SysRoleServiceImpl.findAll()', null, '1', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:22', null, null);
INSERT INTO `sys_log` VALUES ('2889', 'admin', null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findPage()', '{\"pageNum\":2,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', '18', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:25', null, null);
INSERT INTO `sys_log` VALUES ('2890', 'admin', null, 'com.testservice.platform.server.service.impl.SysRoleServiceImpl.findAll()', null, '2', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:25', null, null);
INSERT INTO `sys_log` VALUES ('2891', 'admin', null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', '43', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:27', null, null);
INSERT INTO `sys_log` VALUES ('2892', 'admin', null, 'com.testservice.platform.server.service.impl.SysRoleServiceImpl.findAll()', null, '1', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:27', null, null);
INSERT INTO `sys_log` VALUES ('2893', 'admin', null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.createUserExcelFile()', '{\"pageNum\":1,\"pageSize\":100000,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', '1577', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:38', null, null);
INSERT INTO `sys_log` VALUES ('2894', 'admin', null, 'com.testservice.platform.server.service.impl.SysDeptServiceImpl.findTree()', null, '1', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:49:24', null, null);
INSERT INTO `sys_log` VALUES ('2895', 'admin', null, 'com.testservice.platform.server.service.impl.SysUserServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', '75', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:49:24', null, null);
INSERT INTO `sys_log` VALUES ('2896', 'admin', null, 'com.testservice.platform.server.service.impl.SysRoleServiceImpl.findAll()', null, '2', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:49:24', null, null);

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------
INSERT INTO `sys_login_log` VALUES ('1', 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:16', null, null);
INSERT INTO `sys_login_log` VALUES ('2', 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:17', null, null);
INSERT INTO `sys_login_log` VALUES ('3', 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:18', null, null);
INSERT INTO `sys_login_log` VALUES ('4', 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:20', null, null);
INSERT INTO `sys_login_log` VALUES ('5', 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:20', null, null);
INSERT INTO `sys_login_log` VALUES ('6', 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:21', null, null);
INSERT INTO `sys_login_log` VALUES ('7', 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:22', null, null);
INSERT INTO `sys_login_log` VALUES ('8', 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:23', 'admin', '2019-01-21 10:15:43');
INSERT INTO `sys_login_log` VALUES ('2798', 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:43', null, null);
INSERT INTO `sys_login_log` VALUES ('2799', 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:43', 'admin', '2019-01-21 10:16:54');
INSERT INTO `sys_login_log` VALUES ('2800', 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:16:54', null, null);
INSERT INTO `sys_login_log` VALUES ('2801', 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:16:54', 'admin', '2019-01-22 14:43:09');
INSERT INTO `sys_login_log` VALUES ('2802', 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:43:09', null, null);
INSERT INTO `sys_login_log` VALUES ('2803', 'admin', 'online', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:43:09', null, null);

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', null, null, '0', 'el-icon-setting', '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('2', '用户管理', '1', '/sys/user', null, '1', 'el-icon-service', '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('3', '查看', '2', null, 'sys:user:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('4', '新增', '2', null, 'sys:user:add', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('5', '修改', '2', null, 'sys:user:edit', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('6', '删除', '2', null, 'sys:user:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('7', '机构管理', '1', '/sys/dept', null, '1', 'el-icon-news', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('8', '查看', '7', null, 'sys:dept:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('9', '新增', '7', null, 'sys:dept:add', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('10', '修改', '7', null, 'sys:dept:edit', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('11', '删除', '7', null, 'sys:dept:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('12', '角色管理', '1', '/sys/role', null, '1', 'el-icon-view', '4', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('13', '查看', '12', null, 'sys:role:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('14', '新增', '12', null, 'sys:role:add', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('15', '修改', '12', null, 'sys:role:edit', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('16', '删除', '12', null, 'sys:role:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('17', '菜单管理', '1', '/sys/menu', null, '1', 'el-icon-menu', '5', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('18', '查看', '17', null, 'sys:menu:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('19', '新增', '17', null, 'sys:menu:add', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('20', '修改', '17', null, 'sys:menu:edit', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('21', '删除', '17', null, 'sys:menu:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('22', '字典管理', '1', '/sys/dict', null, '1', 'el-icon-edit-outline', '7', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('23', '查看', '22', null, 'sys:dict:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('24', '新增', '22', null, 'sys:dict:add', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('25', '修改', '22', null, 'sys:dict:edit', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('26', '删除', '22', null, 'sys:dict:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('27', '系统配置', '1', '/sys/config', null, '1', 'el-icon-edit-outline', '7', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('28', '查看', '27', null, 'sys:config:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('29', '新增', '27', null, 'sys:config:add', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('30', '修改', '27', null, 'sys:config:edit', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('31', '删除', '27', null, 'sys:config:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('32', '登录日志', '1', '/sys/loginlog', null, '1', 'el-icon-info', '8', null, null, 'admin', '2018-09-23 19:32:28', '0');
INSERT INTO `sys_menu` VALUES ('33', '查看', '32', null, 'sys:loginlog:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('34', '删除', '32', null, 'sys:loginlog:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('35', '操作日志', '1', '/sys/log', null, '1', 'el-icon-info', '8', null, null, 'admin', '2018-09-23 19:32:28', '0');
INSERT INTO `sys_menu` VALUES ('36', '查看', '35', null, 'sys:log:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('37', '删除', '35', null, 'sys:log:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('38', '系统监控', '0', '', '', '0', 'el-icon-info', '4', 'admin', '2018-12-27 10:57:29', 'admin', '2019-01-10 17:31:04', '0');
INSERT INTO `sys_menu` VALUES ('39', '数据监控', '38', 'http://127.0.0.1:8098/druid/login.html', null, '1', 'el-icon-warning', '0', null, null, 'admin', '2018-12-27 11:03:45', '0');
INSERT INTO `sys_menu` VALUES ('40', '查看', '39', null, 'sys:druid:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('41', '服务监控', '38', 'http://127.0.0.1:8000/', null, '1', 'el-icon-view', '1', 'admin', '2018-11-02 20:02:15', 'admin', '2018-12-27 11:03:53', '0');
INSERT INTO `sys_menu` VALUES ('42', '查看', '41', null, 'sys:monitor:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('43', '服务治理', '0', '', '', '0', 'el-icon-service', '2', 'admin', '2018-12-27 11:05:48', 'admin', '2018-12-27 11:06:39', '0');
INSERT INTO `sys_menu` VALUES ('44', '注册中心', '43', 'http://127.0.0.1:8500', null, '1', ' el-icon-view', '0', 'admin', '2018-11-03 11:06:48', 'admin', '2018-12-27 11:08:11', '0');
INSERT INTO `sys_menu` VALUES ('45', '查看', '44', null, 'sys:consul:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('46', '接口文档', '0', 'http://127.0.0.1:8098/swagger-ui.html', null, '1', 'el-icon-document', '3', null, null, 'admin', '2018-12-27 11:04:18', '0');
INSERT INTO `sys_menu` VALUES ('47', '查看', '46', null, 'sys:swagger:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('48', '代码生成', '0', '/generator/generator', '', '1', 'el-icon-star-on', '5', 'admin', '2018-11-15 14:39:30', 'admin', '2018-11-15 14:56:18', '0');
INSERT INTO `sys_menu` VALUES ('49', '查看', '48', null, 'sys:generator:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('50', '在线用户', '0', '/sys/online', '', '1', 'el-icon-view', '5', 'admin', '2018-11-15 14:39:30', 'admin', '2018-11-15 14:56:18', '0');
INSERT INTO `sys_menu` VALUES ('51', '查看', '50', null, 'sys:online:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('52', '使用案例', '0', null, null, '0', 'el-icon-picture-outline', '6', null, null, 'admin', '2018-11-15 14:39:43', '0');
INSERT INTO `sys_menu` VALUES ('53', '国际化', '52', '/demo/i18n', null, '1', 'el-icon-edit', '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('54', '查看', '53', null, 'sys:dict:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('55', '换皮肤', '52', '/demo/theme', null, '1', 'el-icon-picture', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('56', '查看', '55', null, 'sys:dict:view', '2', null, '0', null, null, null, null, '0');

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '超级管理员', 'admin', '2019-01-19 11:11:11', 'admin', '2019-01-19 19:07:18', '0');
INSERT INTO `sys_role` VALUES ('2', 'mng', '项目经理', 'admin', '2019-01-19 11:11:11', 'admin', '2019-01-19 11:39:28', '0');
INSERT INTO `sys_role` VALUES ('3', 'dev', '开发人员', 'admin', '2019-01-19 11:11:11', 'admin', '2019-01-19 11:39:28', '0');
INSERT INTO `sys_role` VALUES ('4', 'test', '测试人员', 'admin', '2019-01-19 11:11:11', 'admin', '2019-01-19 11:11:11', '0');

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('1', '1', '1', 'admin', '2019-01-11 08:30:37', 'admin', '2019-01-11 08:30:25');
INSERT INTO `sys_role_dept` VALUES ('2', '2', '4', 'admin', '2019-01-11 08:31:01', 'admin', '2019-01-11 08:31:04');
INSERT INTO `sys_role_dept` VALUES ('3', '3', '4', 'admin', '2019-01-11 08:31:18', 'admin', '2019-01-11 08:31:21');


-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, '1', '1', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (2, '1', '2', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (3, '1', '3', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (4, '1', '4', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (5, '1', '5', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (6, '1', '6', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (7, '1', '7', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (8,'1', '8', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (9, '1', '9', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (10, '1', '10', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (11, '1', '11', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (12, '1', '12', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (13, '1', '13', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (14,'1', '14', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (15, '1', '15', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (16, '1', '16', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (17, '1', '17', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (18, '1', '18', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (19, '1', '19', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (20, '1', '20', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (21, '1', '21', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (22, '1', '22', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (23, '1', '23', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (24, '1', '24', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (25, '1', '25', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (26, '1', '26', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (27, '1', '27', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (28, '1', '28', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (29, '1', '29', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (30, '1', '30', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (31, '1', '31', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (32, '1', '32', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (33, '1', '33', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (34, '1', '34', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (35, '1', '35', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (36, '1', '36', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (37, '1', '37', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (38, '1', '38', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (39, '1', '39', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (40, '1', '40', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (41, '1', '41', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (42, '1', '42', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (43, '1', '43', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (44, '1', '44', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (45, '1', '45', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (46, '1', '46', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (47, '1', '47', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (48, '1', '48', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (49, '1', '49', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (50, '1', '50', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (51, '1', '51', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (52, '1', '52', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (53, '1', '53', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (54, '1', '54', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (55, '1', '55', 'admin', NOW(), null, null);
INSERT INTO `sys_role_menu` VALUES (56, '1', '56', 'admin', NOW(), null, null);

INSERT INTO `sys_role_menu` VALUES ('431', '8', '1', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('432', '8', '2', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('433', '8', '9', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('434', '8', '3', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('435', '8', '13', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('436', '8', '4', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('437', '8', '17', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('438', '8', '5', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('439', '8', '21', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('440', '8', '7', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('441', '8', '31', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('442', '8', '8', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('443', '8', '6', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('444', '8', '35', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('469', '2', '1', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('470', '2', '2', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('471', '2', '3', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('472', '2', '4', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('473', '2', '5', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('474', '2', '6', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('475', '2', '7', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('476', '2', '8', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('477', '2', '9', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('478', '2', '10', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('479', '2', '11', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('480', '2', '12', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('481', '2', '13', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('482', '2', '14', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('483', '2', '15', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('484', '2', '16', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('485', '2', '17', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('486', '2', '18', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('487', '2', '19', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('488', '2', '20', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('489', '2', '21', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('490', '2', '22', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('491', '2', '23', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('492', '2', '24', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('493', '2', '25', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('494', '2', '26', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('495', '2', '27', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('496', '2', '28', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('497', '2', '29', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('498', '2', '30', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('499', '2', '31', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('500', '2', '32', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('501', '2', '33', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('502', '2', '34', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('503', '2', '35', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('504', '2', '36', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('505', '2', '37', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('506', '2', '43', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('507', '2', '44', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('508', '2', '45', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('509', '2', '46', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('510', '2', '47', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('511', '2', '38', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('512', '2', '39', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('513', '2', '40', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('514', '2', '41', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('515', '2', '42', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('516', '2', '48', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('517', '2', '49', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('518', '2', '50', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('519', '2', '51', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('520', '2', '52', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('521', '2', '53', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('522', '2', '54', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('523', '2', '55', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('524', '2', '56', null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('572', '3', '1', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('573', '3', '2', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('574', '3', '3', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('575', '3', '4', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('576', '3', '5', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('577', '3', '6', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('578', '3', '7', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('579', '3', '8', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('580', '3', '12', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('581', '3', '13', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('582', '3', '17', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('583', '3', '18', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('584', '3', '22', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('585', '3', '23', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('586', '3', '24', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('587', '3', '25', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('588', '3', '26', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('589', '3', '27', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('590', '3', '28', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('591', '3', '29', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('592', '3', '30', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('593', '3', '31', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('594', '3', '32', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('595', '3', '33', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('596', '3', '35', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('597', '3', '36', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('598', '3', '43', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('599', '3', '44', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('600', '3', '45', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('601', '3', '38', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('602', '3', '39', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('603', '3', '40', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('604', '3', '41', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('605', '3', '42', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('606', '3', '50', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('607', '3', '51', 'admin', '2019-01-22 14:45:28', null, null);
INSERT INTO `sys_role_menu` VALUES ('608', '4', '1', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('609', '4', '2', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('610', '4', '3', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('611', '4', '7', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('612', '4', '8', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('613', '4', '17', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('614', '4', '18', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('615', '4', '32', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('616', '4', '33', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('617', '4', '35', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('618', '4', '36', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('619', '4', '46', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('620', '4', '47', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('621', '4', '50', 'admin', '2019-01-22 14:46:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('622', '4', '51', 'admin', '2019-01-22 14:46:44', null, null);


-- ----------------------------
-- Records of sys_user 3fb03ab948c734c3c6d0e612dc331357=Admin@1234
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '超管', null, 'bd1718f058d8a02468134432b8656a86', 'YzcmCZNvbXocrsz9dm8e', 'admin@qq.com', '13612345678', '1', '4', 'admin', '2018-08-14 11:11:11', 'admin', '2018-08-14 11:11:11', '0');
INSERT INTO `sys_user` VALUES ('2', 'sunliuping', '孙留平', null, '3fb03ab948c734c3c6d0e612dc331357', 'YzcmCZNvbXocrsz9dm8e', 'sunliuping@testservice.com', '15869107902', '1', '7', 'admin', '2020-02-18 16:43:11', 'admin', '2020-02-18 16:43:18', '0');

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('2', '2', '1', null, null, null, null);


DROP TABLE IF EXISTS `apk`;
CREATE TABLE `apk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `app_name` varchar(100) NOT NULL COMMENT '应用名',
  `package_name` varchar(100) NOT NULL COMMENT '包名',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='应用表';


DROP TABLE IF EXISTS `platform`;
CREATE TABLE `platform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `platform_name` varchar(100) NOT NULL COMMENT '平台名',
  `access_url` varchar(1000) NOT NULL COMMENT '访问地址',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='平台表';

alter table `platform` add column `image_url` varchar(500) DEFAULT "" COMMENT '图标地址';

use `test_service_platform`;
-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('57', '录制回放', '0', null, null, '0', 'el-icon-setting', '0', null, null, null, null, '0');

INSERT INTO `sys_menu` VALUES ('58', 'app管理', '57', '/record/app', null, '1', 'el-icon-service', '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('59', '新增', '58', null, 'record:app:add', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('60', '修改', '58', null, 'record:app:edit', '2', null, '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('61', '删除', '58', null, 'record:app:delete', '2', null, '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('62', '查看', '58', null, 'record:app:view', '2', null, '4', null, null, null, null, '0');

INSERT INTO `sys_menu` VALUES ('63', '脚本管理', '57', '/record/script', null, '1', 'el-icon-service', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('64', '新增', '63', null, 'record:script:add', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('65', '修改', '63', null, 'record:script:edit', '2', null, '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('66', '删除', '63', null, 'record:script:delete', '2', null, '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('67', '查看', '63', null, 'record:script:view', '2', null, '4', null, null, null, null, '0');

INSERT INTO `sys_menu` VALUES ('68', '功能管理', '0', null, null, '0', 'el-icon-setting', '0', null, null, null, null, '0');

INSERT INTO `sys_menu` VALUES ('69', '平台管理', '68', '/function/platform', null, '1', 'el-icon-service', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('70', '新增', '69', null, 'function:platform:add', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('71', '修改', '69', null, 'function:platform:edit', '2', null, '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('72', '删除', '69', null, 'function:platform:delete', '2', null, '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('73', '查看', '69', null, 'function:platform:view', '2', null, '4', null, null, null, null, '0');

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (624, '1', '57', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (625, '1', '58', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (626, '1', '59', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (627, '1', '60', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (628, '1', '61', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (629, '1', '62', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (630, '1', '63', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (631, '1', '64', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (632, '1', '65', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (633, '1', '66', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (634, '1', '67', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (635, '1', '68', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (636, '1', '69', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (637, '1', '70', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (638, '1', '71', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (639, '1', '72', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (640, '1', '73', 'admin', NOW(), 'admin', NOW());



use `test_service_platform`;
DROP TABLE IF EXISTS `script`;
CREATE TABLE `script`
(
   `id` bigint (20) NOT NULL AUTO_INCREMENT COMMENT '编号',
   `script_name` varchar (100) NOT NULL COMMENT '脚本名',
   `app_id` bigint (20) NOT NULL COMMENT '所属应用id',
   `description` varchar (100) DEFAULT NULL COMMENT '描述',
   `create_by` varchar (50) DEFAULT NULL COMMENT '创建人',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `last_update_by` varchar (50) DEFAULT NULL COMMENT '更新人',
   `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
   `remarks` varchar (255) DEFAULT NULL COMMENT '备注信息',
   `del_flag` tinyint (4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
   PRIMARY KEY (`id`)
)
ENGINE= InnoDB AUTO_INCREMENT= 5 DEFAULT CHARSET= utf8 COMMENT= '脚本表';
DROP TABLE IF EXISTS `script_step`;
CREATE TABLE `script_step`
(
   `id` bigint (20) NOT NULL AUTO_INCREMENT COMMENT '编号',
   `script_id` bigint (20) NOT NULL COMMENT '脚本id',
   `operation_id` varchar (1000) NOT NULL COMMENT '操作id',
   `operation_index` bigint (100) DEFAULT NULL COMMENT '操作索引',
   `create_by` varchar (50) DEFAULT NULL COMMENT '创建人',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `last_update_by` varchar (50) DEFAULT NULL COMMENT '更新人',
   `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
   `remarks` varchar (255) DEFAULT NULL COMMENT '备注信息',
   `del_flag` tinyint (4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
   PRIMARY KEY (`id`)
)
ENGINE= InnoDB AUTO_INCREMENT= 5 DEFAULT CHARSET= utf8 COMMENT= '脚本步骤表';


use `test_service_platform`;
DROP TABLE IF EXISTS `timer_task_policy`;
CREATE TABLE IF NOT EXISTS `timer_task_policy`
(
   `id` bigint (20) NOT NULL AUTO_INCREMENT,
   `cname` varchar (100) NOT NULL COMMENT '中文名',
   `ename` varchar (100) NOT NULL COMMENT '英文名',
   `code` varchar (1000) NOT NULL COMMENT '执行的代码',
   `description` varchar (100) DEFAULT NULL COMMENT '备注',
   `create_time` timestamp DEFAULT CURRENT_TIMESTAMP () COMMENT '创建时间',
   `last_update_time` timestamp DEFAULT CURRENT_TIMESTAMP () COMMENT '更新时间',
   `create_by` VARCHAR (100) DEFAULT NULL COMMENT '创建人',
   `last_update_by` VARCHAR (100) DEFAULT NULL COMMENT '更新人',
   `remarks` varchar (255) DEFAULT NULL COMMENT '备注信息',
   `del_flag` tinyint (4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
   PRIMARY KEY (`id`)
)
ENGINE = InnoDB CHARSET = utf8;
DROP TABLE IF EXISTS `timer_task`;
CREATE TABLE IF NOT EXISTS `timer_task`
(
   `id` bigint (20) NOT NULL AUTO_INCREMENT,
   `policy_id` bigint (20) NOT NULL COMMENT '策略id',
   `task_name` varchar (100) DEFAULT NULL COMMENT '任务名称',
   `task_group` varchar (100) DEFAULT NULL COMMENT '任务组名称',
   `config` varchar (100) DEFAULT NULL COMMENT '定时任务配置',
   `closed` tinyint (4) DEFAULT 0 COMMENT '是否关闭',
   `description` varchar (100) DEFAULT NULL COMMENT '备注',
   `create_time` timestamp DEFAULT CURRENT_TIMESTAMP () COMMENT '创建时间',
   `last_update_time` timestamp DEFAULT CURRENT_TIMESTAMP () COMMENT '更新时间',
   `create_by` VARCHAR (100) DEFAULT NULL COMMENT '创建人',
   `last_update_by` VARCHAR (100) DEFAULT NULL COMMENT '更新人',
   `other_params` varchar (1000) DEFAULT NULL COMMENT '额外的参数',
   `remarks` varchar (255) DEFAULT NULL COMMENT '备注信息',
   `del_flag` tinyint (4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
   PRIMARY KEY (`id`)
)
ENGINE = InnoDB CHARSET = utf8;
DROP TABLE IF EXISTS `timer_task_monitor`;
CREATE TABLE IF NOT EXISTS `timer_task_monitor`
(
   `id` bigint (20) NOT NULL AUTO_INCREMENT,
   `job_name` varchar (100) DEFAULT NULL COMMENT '任务名称',
   `success` tinyint (4) DEFAULT 0 COMMENT '是否成功',
   `description` varchar (1000) DEFAULT NULL COMMENT '备注',
   `create_time` timestamp DEFAULT CURRENT_TIMESTAMP () COMMENT '创建时间',
   `last_update_time` timestamp DEFAULT CURRENT_TIMESTAMP () COMMENT '更新时间',
   `create_by` VARCHAR (100) DEFAULT NULL COMMENT '创建人',
   `last_update_by` VARCHAR (100) DEFAULT NULL COMMENT '更新人',
   `start_date` timestamp DEFAULT CURRENT_TIMESTAMP () COMMENT '开始时间',
   `end_date` timestamp DEFAULT CURRENT_TIMESTAMP () COMMENT '结束时间',
   `remarks` varchar (255) DEFAULT NULL COMMENT '备注信息',
   `del_flag` tinyint (4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
   PRIMARY KEY (`id`)
)
ENGINE = InnoDB CHARSET = utf8;


DROP TABLE IF EXISTS `access_log`;
CREATE TABLE `access_log`
(
   `id` bigint (20) NOT NULL AUTO_INCREMENT COMMENT '编号',
   `user_name` varchar (50) DEFAULT NULL COMMENT '用户名',
   `access_url` varchar (5000) DEFAULT NULL COMMENT '访问的地址',
   `operation` varchar (50) DEFAULT NULL COMMENT '用户操作',
   `method` varchar (200) DEFAULT NULL COMMENT '请求方法',
   `params` varchar (5000) DEFAULT NULL COMMENT '请求参数',
   `time` bigint (20) NOT NULL COMMENT '执行时长(毫秒)',
   `ip` varchar (64) DEFAULT NULL COMMENT 'IP地址',
   `create_by` varchar (50) DEFAULT NULL COMMENT '创建人',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `last_update_by` varchar (50) DEFAULT NULL COMMENT '更新人',
   `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
   PRIMARY KEY (`id`)
)
ENGINE= InnoDB AUTO_INCREMENT= 2897 DEFAULT CHARSET= utf8 COMMENT= '系统访问日志';


INSERT INTO `sys_menu` VALUES ('74', '访问管理', '1', '/sys/accessLog', null, '1', 'el-icon-service', '10', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('75', '新增', '74', null, 'sys:accessLog:add', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('76', '修改', '74', null, 'sys:accessLog:edit', '2', null, '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('77', '删除', '74', null, 'sys:accessLog:delete', '2', null, '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('78', '查看', '74', null, 'sys:accessLog:view', '2', null, '4', null, null, null, null, '0');

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (641, '1', '74', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (642, '1', '75', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (643, '1', '76', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (644, '1', '77', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (645, '1', '78', 'admin', NOW(), 'admin', NOW());

INSERT INTO `sys_menu` VALUES ('79', '定时任务', '0', null, null, '1', 'el-icon-timer', '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('80', '定时任务', '79', '/timerTask/timerTask', null, '1', 'el-icon-timer', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('81', '新增', '80', null, 'timerTask:timerTask:add', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('82', '修改', '80', null, 'timerTask:timerTask:edit', '2', null, '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('83', '删除', '80', null, 'timerTask:timerTask:delete', '2', null, '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('84', '查看', '80', null, 'timerTask:timerTask:view', '2', null, '4', null, null, null, null, '0');

INSERT INTO `sys_menu` VALUES ('85', '定时策略', '79', '/timerTask/timerTaskPolicy', null, '1', 'el-icon-timer', '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('86', '新增', '85', null, 'timerTask:timerTaskPolicy:add', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('87', '修改', '85', null, 'timerTask:timerTaskPolicy:edit', '2', null, '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('88', '删除', '85', null, 'timerTask:timerTaskPolicy:delete', '2', null, '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('89', '查看', '85', null, 'timerTask:timerTaskPolicy:view', '2', null, '4', null, null, null, null, '0');

INSERT INTO `sys_menu` VALUES ('90', '任务监控', '79', '/timerTask/timerTaskMonitor', null, '1', 'el-icon-monitor', '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('91', '新增', '90', null, 'timerTask:timerTaskMonitor:add', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('92', '修改', '90', null, 'timerTask:timerTaskMonitor:edit', '2', null, '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('93', '删除', '90', null, 'timerTask:timerTaskMonitor:delete', '2', null, '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('94', '查看', '90', null, 'timerTask:timerTaskMonitor:view', '2', null, '4', null, null, null, null, '0');


INSERT INTO `sys_role_menu` VALUES (646, '1', '79', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (647, '1', '80', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (648, '1', '81', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (649, '1', '82', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (650, '1', '83', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (651, '1', '84', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (652, '1', '85', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (653, '1', '86', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (654, '1', '87', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (655, '1', '88', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (656, '1', '89', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (657, '1', '90', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (658, '1', '91', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (659, '1', '92', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (660, '1', '93', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (661, '1', '94', 'admin', NOW(), 'admin', NOW());

INSERT INTO `sys_menu` VALUES ('95', 'Actuator监控', '38', '/sys/actuator', null, '3', 'el-icon-monitor', '0', null, null, 'admin', '2020-03-17 11:03:45', '0');
INSERT INTO `sys_role_menu` VALUES (662, '1', '95', 'admin', NOW(), 'admin', NOW());

INSERT INTO `sys_menu` VALUES ('96', '查看', '95', null, 'sys:actautor:view', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_role_menu` VALUES (663, '1', '96', 'admin', NOW(), 'admin', NOW());


DROP TABLE IF EXISTS `global_param`;
CREATE TABLE IF NOT EXISTS `global_param` (
        `id` int(8) NOT NULL AUTO_INCREMENT,
        `param_key` varchar(100) NOT NULL,
        `param_value` varchar(100) DEFAULT NULL,
        `param_comment` varchar(100) DEFAULT NULL,
        `create_by` varchar (50) DEFAULT NULL COMMENT '创建人',
	    `create_time` timestamp DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
	    `last_update_by` varchar (50) DEFAULT NULL COMMENT '更新人',
	    `last_update_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	    `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
	    `description` varchar(100) DEFAULT NULL COMMENT '描述',
	    `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB CHARSET = utf8;

INSERT INTO `sys_menu` VALUES ('97', '全局参数', '1', '/sys/globalParam', null, '1', 'el-icon-info', '11', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('98', '新增', '97', null, 'sys:globalParam:add', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('99', '修改', '97', null, 'sys:globalParam:edit', '2', null, '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('100', '删除', '97', null, 'sys:globalParam:delete', '2', null, '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('101', '查看', '97', null, 'sys:globalParam:view', '2', null, '4', null, null, null, null, '0');

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (664, '1', '97', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (665, '1', '98', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (666, '1', '99', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (667, '1', '100', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (668, '1', '101', 'admin', NOW(), 'admin', NOW());

DROP TABLE IF EXISTS `zentao_testtask`;
CREATE TABLE IF NOT EXISTS `zentao_testtask` (
        `id` int(8) NOT NULL AUTO_INCREMENT,
        `zentao_testtask_id` BIGINT(10) NOT NULL COMMENT '禅道测试单的ID',
        `create_by` varchar (50) DEFAULT NULL COMMENT '创建人',
	    `create_time` timestamp DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
	    `last_update_by` varchar (50) DEFAULT NULL COMMENT '更新人',
	    `last_update_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	    `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
	    `description` varchar(100) DEFAULT NULL COMMENT '描述',
	    `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB CHARSET = utf8;

INSERT INTO `sys_menu` VALUES ('102', '禅道管理', '68', null, null, '0', 'el-icon-my-zentao', '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('103', '测试单', '102', '/function/zenTaoTestTask', null, '0', 'el-icon-my-zentao', '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('104', '测试用例', '102', '/function/zenTaoTestCase', null, '0', 'el-icon-my-zentao', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('105', '新增', '103', null, 'function:zenTaoTestTask:add', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('106', '修改', '103', null, 'function:zenTaoTestTask:edit', '2', null, '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('107', '删除', '103', null, 'function:zenTaoTestTask:delete', '2', null, '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('108', '查看', '103', null, 'function:zenTaoTestTask:view', '2', null, '4', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('109', '新增', '104', null, 'function:zenTaoTestCase:add', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('110', '修改', '104', null, 'function:zenTaoTestCase:edit', '2', null, '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('111', '删除', '104', null, 'function:zenTaoTestCase:delete', '2', null, '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('112', '查看', '104', null, 'function:zenTaoTestCase:view', '2', null, '4', null, null, null, null, '0');

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (669, '1', '102', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (670, '1', '103', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (671, '1', '104', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (672, '1', '105', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (673, '1', '106', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (674, '1', '107', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (675, '1', '108', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (676, '1', '109', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (677, '1', '110', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (678, '1', '111', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (679, '1', '112', 'admin', NOW(), 'admin', NOW());

------
-- 添加所属人
-----

alter table `global_param` add column `owner` varchar(50) DEFAULT "alter table `global_param` add column `owner` varchar(50) DEFAULT "DEFAULT" COMMENT '参数所属人';" COMMENT '参数所属人';

