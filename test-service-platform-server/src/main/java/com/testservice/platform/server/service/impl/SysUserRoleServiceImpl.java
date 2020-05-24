/**
 * @author : 孙留平
 * @since : 2020年2月27日 下午1:36:23
 * @see:
 */
package com.testservice.platform.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testservice.platform.server.dao.SysUserRoleMapper;
import com.testservice.platform.server.model.SysUserRole;
import com.testservice.platform.server.service.SysUserRoleService;

/**
 * @author : Administrator
 * @since : 2020年2月27日 下午1:36:23
 * @see :
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@Override
	public List<SysUserRole> deleteByUserId(Long userId) {

		List<SysUserRole> currentSysUserRoles = findUserRolesByUserId(userId);
		if (currentSysUserRoles.isEmpty()) {
			return new ArrayList<SysUserRole>();
		}

		sysUserRoleMapper.deleteByUserId(userId);

		return currentSysUserRoles;

	}

	@Override
	public SysUserRole delete(Long id) {
		SysUserRole currentSysUserRole = findById(id);
		if (null == currentSysUserRole) {
			return null;
		}
		sysUserRoleMapper.deleteByPrimaryKey(id);
		return currentSysUserRole;
	}

	@Override
	public SysUserRole save(SysUserRole record) {
		if (null != record.getId()) {
			sysUserRoleMapper.updateByPrimaryKey(record);
			return record;
		}

		sysUserRoleMapper.insert(record);
		return record;
	}

	@Override
	public SysUserRole findById(Long id) {
		return sysUserRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SysUserRole> findUserRolesByUserId(Long userId) {
		return sysUserRoleMapper.findUserRoles(userId);
	}

	@Override
	public List<SysUserRole> deleteByRoleId(Long roleId) {
		List<SysUserRole> currentSysUserRoles = findUserRolesByRoleId(roleId);
		sysUserRoleMapper.deleteByRoleId(roleId);
		return currentSysUserRoles;
	}

	@Override
	public List<SysUserRole> findUserRolesByRoleId(Long roleId) {
		return sysUserRoleMapper.findUserRoles(roleId);
	}

}
