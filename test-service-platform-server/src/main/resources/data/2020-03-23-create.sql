alter table `global_param` add column `owner` varchar(50) DEFAULT "DEFAULT" COMMENT '参数所属人';

INSERT INTO `sys_menu` VALUES ('113', '禅道配置', '102', '/function/zenTaoConfig', null, '0', 'el-icon-my-zentao', '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('114', '新增', '113', null, 'function:zenTaoConfig:add', '2', null, '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('115', '修改', '113', null, 'function:zenTaoConfig:edit', '2', null, '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('116', '删除', '113', null, 'function:zenTaoConfig:delete', '2', null, '3', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('117', '查看', '113', null, 'function:zenTaoConfig:view', '2', null, '4', null, null, null, null, '0');

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (680, '1', '113', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (681, '1', '114', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (682, '1', '115', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (683, '1', '116', 'admin', NOW(), 'admin', NOW());
INSERT INTO `sys_role_menu` VALUES (684, '1', '117', 'admin', NOW(), 'admin', NOW());
