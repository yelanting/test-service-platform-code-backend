/**
 * @author : 孙留平
 * @since : 2020年2月27日 下午1:35:33
 * @see:
 */
package com.testservice.platform.server.service;

import java.util.List;

import com.testservice.platform.server.model.SysRoleDept;

/**
 * @author : Administrator
 * @since : 2020年2月27日 下午1:35:33
 * @see :
 */
public interface SysRoleDeptService {
	SysRoleDept delete(Long id);

	SysRoleDept save(SysRoleDept record);

	SysRoleDept findById(Long id);

	List<SysRoleDept> findRoleDeptsByRoleId(Long roleId);

	List<SysRoleDept> findRoleDeptsByDeptId(Long deptId);

	List<SysRoleDept> deleteByRoleId(Long roleId);
}
