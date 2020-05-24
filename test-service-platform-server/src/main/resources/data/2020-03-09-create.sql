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