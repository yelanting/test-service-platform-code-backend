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