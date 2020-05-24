/**
 * @author : 孙留平
 * @since : 2020年2月27日 下午1:35:33
 * @see:
 */
package com.testservice.platform.server.service;

import java.util.List;

import com.testservice.platform.server.model.SysUserRole;

/**
 * @author : Administrator
 * @since : 2020年2月27日 下午1:35:33
 * @see :
 */
public interface SysUserRoleService {
	SysUserRole delete(Long id);

	SysUserRole save(SysUserRole record);

	SysUserRole findById(Long id);

	List<SysUserRole> findUserRolesByUserId(Long userId);

	List<SysUserRole> findUserRolesByRoleId(Long roleId);

	List<SysUserRole> deleteByUserId(Long userId);

	List<SysUserRole> deleteByRoleId(Long roleId);
}
