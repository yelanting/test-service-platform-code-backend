package com.testservice.platform.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testservice.platform.server.model.SysUserRole;

public interface SysUserRoleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysUserRole record);

	int insertSelective(SysUserRole record);

	SysUserRole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysUserRole record);

	int updateByPrimaryKey(SysUserRole record);

	List<SysUserRole> findUserRoles(@Param(value = "userId") Long userId);

	List<SysUserRole> findUserRolesByRoleId(
	        @Param(value = "roleId") Long roleId);

	int deleteByUserId(@Param(value = "userId") Long userId);

	int deleteByRoleId(@Param(value = "roleId") Long roleId);
}