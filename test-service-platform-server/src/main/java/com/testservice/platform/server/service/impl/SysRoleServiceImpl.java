package com.testservice.platform.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testservice.platform.server.constant.SysConstants;
import com.testservice.platform.server.dao.SysMenuMapper;
import com.testservice.platform.server.dao.SysRoleMapper;
import com.testservice.platform.server.dao.SysRoleMenuMapper;
import com.testservice.platform.server.model.SysMenu;
import com.testservice.platform.server.model.SysRole;
import com.testservice.platform.server.model.SysRoleMenu;
import com.testservice.platform.server.page.MybatisPageHelper;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.page.PageResult;
import com.testservice.platform.server.page.Param;
import com.testservice.platform.server.service.SysRoleDeptService;
import com.testservice.platform.server.service.SysRoleService;
import com.testservice.platform.server.service.SysUserRoleService;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Autowired
	private SysUserRoleService sysUserRoleService;

	@Autowired
	private SysRoleDeptService sysRoleDeptService;

	@Override
	public int save(SysRole record) {
		if (record.getId() == null || record.getId() == 0) {
			return sysRoleMapper.insertSelective(record);
		}
		return sysRoleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysRole record) {
		// 删除角色之后，删除角色和部门、和菜单之间的关系表
		sysUserRoleService.deleteByRoleId(record.getId());
		sysRoleDeptService.deleteByRoleId(record.getId());
		sysRoleMapper.deleteByPrimaryKey(record.getId());
		return 1;
	}

	@Override
	public int delete(List<SysRole> records) {
		for (SysRole record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysRole findById(Long id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Param label = pageRequest.getParam("name");
		if (label != null) {
			return MybatisPageHelper.findPage(pageRequest, sysRoleMapper,
			        "findPageByName", label.getValue());
		}
		return MybatisPageHelper.findPage(pageRequest, sysRoleMapper);
	}

	@Override
	public List<SysRole> findAll() {
		return sysRoleMapper.findAll();
	}

	public SysRoleMapper getSysRoleMapper() {
		return sysRoleMapper;
	}

	public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
		this.sysRoleMapper = sysRoleMapper;
	}

	@Override
	public List<SysMenu> findRoleMenus(Long roleId) {
		SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
		if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
			// 如果是超级管理员，返回全部
			return sysMenuMapper.findAll();
		}
		return sysMenuMapper.findRoleMenus(roleId);
	}

	@Transactional
	@Override
	public int saveRoleMenus(List<SysRoleMenu> records) {
		if (records == null || records.isEmpty()) {
			return 1;
		}
		Long roleId = records.get(0).getRoleId();
		sysRoleMenuMapper.deleteByRoleId(roleId);
		for (SysRoleMenu record : records) {
			sysRoleMenuMapper.insertSelective(record);
		}
		return 1;
	}

	@Override
	public List<SysRole> findByName(String name) {
		return sysRoleMapper.findByName(name);
	}

}
