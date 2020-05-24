use `test_service_platform`;
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


INSERT INTO `sys_menu` VALUES ('74', '访问日志', '1', '/sys/accessLog', null, '1', 'el-icon-info', '10', null, null, null, null, '0');
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


