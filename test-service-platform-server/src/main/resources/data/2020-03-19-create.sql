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