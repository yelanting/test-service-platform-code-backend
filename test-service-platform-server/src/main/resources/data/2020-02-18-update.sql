use `test_service_platform`;
-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('57', '录制回放', '0', null, null, '1', 'el-icon-setting', '0', null, null, null, null, '0');

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

INSERT INTO `sys_menu` VALUES ('68', '功能管理', '0', null, null, '0', 'el-icon-setting', '2', null, null, null, null, '0');

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
