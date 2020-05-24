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