package com.testservice.platform.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testservice.platform.server.constant.SysConstants;
import com.testservice.platform.server.model.SysRole;
import com.testservice.platform.server.model.SysRoleMenu;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.service.SysRoleService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * 角色控制器
 * 
 * @author administrator
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("role")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	@PreAuthorize("hasAuthority('sys:role:add') AND hasAuthority('sys:role:edit')")
	@PostMapping(value = "/save")
	public ResponseData save(@RequestBody SysRole record) {
		SysRole role = sysRoleService.findById(record.getId());
		if (role != null) {
			if (SysConstants.ADMIN.equalsIgnoreCase(role.getName())) {
				return ResponseData.getErrorResult("超级管理员不允许修改!");
			}
		}
		// 新增角色
		if ((record.getId() == null || record.getId() == 0)
		        && !sysRoleService.findByName(record.getName()).isEmpty()) {
			return ResponseData.getErrorResult("角色名已存在!");
		}
		return ResponseData.getSuccessResult(sysRoleService.save(record));
	}

	@PreAuthorize("hasAuthority('sys:role:delete')")
	@PostMapping(value = "/delete")
	public ResponseData delete(@RequestBody List<SysRole> records) {
		return ResponseData.getSuccessResult(sysRoleService.delete(records));
	}

	@PreAuthorize("hasAuthority('sys:role:view')")
	@PostMapping(value = "/findPage")
	public ResponseData findPage(@RequestBody PageRequest pageRequest) {
		return ResponseData.getSuccessResult(sysRoleService.findPage(pageRequest));
	}

	// @PreAuthorize("hasAuthority('sys:role:view')")
	@GetMapping(value = "/findAll")
	public ResponseData findAll() {
		return ResponseData.getSuccessResult(sysRoleService.findAll());
	}

	@PreAuthorize("hasAuthority('sys:role:view')")
	@GetMapping(value = "/findRoleMenus")
	public ResponseData findRoleMenus(@RequestParam Long roleId) {
		return ResponseData.getSuccessResult(sysRoleService.findRoleMenus(roleId));
	}

	@PreAuthorize("hasAuthority('sys:role:view')")
	@PostMapping(value = "/saveRoleMenus")
	public ResponseData saveRoleMenus(@RequestBody List<SysRoleMenu> records) {
		for (SysRoleMenu record : records) {
			SysRole sysRole = sysRoleService.findById(record.getRoleId());
			if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
				// 如果是超级管理员，不允许修改
				return ResponseData.getErrorResult("超级管理员拥有所有菜单权限，不允许修改！");
			}
		}
		return ResponseData.getSuccessResult(sysRoleService.saveRoleMenus(records));
	}
}
