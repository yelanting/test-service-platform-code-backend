package com.testservice.platform.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testservice.platform.server.model.SysRoleDept;

public interface SysRoleDeptMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysRoleDept record);

	int insertSelective(SysRoleDept record);

	SysRoleDept selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysRoleDept record);

	int updateByPrimaryKey(SysRoleDept record);

	List<SysRoleDept> findRoleDeptsByRoleId(@Param("roleId") Long roleId);

	List<SysRoleDept> findRoleDeptsByDeptId(@Param("deptId") Long deptId);

	void deleteByRoleId(@Param("roleId") Long roleId);

	void deleteByDeptId(@Param("deptId") Long deptId);
}