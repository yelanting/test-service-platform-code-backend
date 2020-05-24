package com.testservice.platform.server.service;

import java.util.List;

import com.testservice.platform.server.model.SysDept;

/**
 * 机构管理
 * 
 * @author administrator
 * @date Jan 13, 2019
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * 
	 * @param userId
	 * @return
	 */
	List<SysDept> findTree();

	SysDept findByNameAndParentId(String deptName, Long parentId);

	SysDept findDefaultDept();
}
