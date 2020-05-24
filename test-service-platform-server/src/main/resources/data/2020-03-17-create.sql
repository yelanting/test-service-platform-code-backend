use `test_service_platform`;

INSERT INTO `sys_menu` VALUES ('95', 'Actuator监控', '38', '/sys/actuator', null, '3', 'el-icon-monitor', '0', null, null, 'admin', '2020-03-17 11:03:45', '0');
INSERT INTO `sys_role_menu` VALUES (662, '1', '95', 'admin', NOW(), 'admin', NOW());

INSERT INTO `sys_menu` VALUES ('96', '查看', '95', null, 'sys:actautor:view', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_role_menu` VALUES (663, '1', '96', 'admin', NOW(), 'admin', NOW());
