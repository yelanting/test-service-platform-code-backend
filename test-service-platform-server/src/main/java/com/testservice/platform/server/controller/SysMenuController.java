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

import com.testservice.platform.server.model.SysMenu;
import com.testservice.platform.server.service.SysMenuService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * 菜单控制器
 * 
 * @author administrator
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {

	@Autowired
	private SysMenuService sysMenuService;

	@PreAuthorize("hasAuthority('sys:menu:add') AND hasAuthority('sys:menu:edit')")
	@PostMapping(value = "/save")
	public ResponseData save(@RequestBody SysMenu record) {
		return ResponseData.getSuccessResult(sysMenuService.save(record));
	}

	@PreAuthorize("hasAuthority('sys:menu:delete')")
	@PostMapping(value = "/delete")
	public ResponseData delete(@RequestBody List<SysMenu> records) {
		return ResponseData.getSuccessResult(sysMenuService.delete(records));
	}

	// @PreAuthorize("hasAuthority('sys:menu:view')")
	@GetMapping(value = "/findNavTree")
	public ResponseData findNavTree(@RequestParam String userName) {
		return ResponseData.getSuccessResult(sysMenuService.findTree(userName, 1));
	}

	@PreAuthorize("hasAuthority('sys:menu:view')")
	@GetMapping(value = "/findMenuTree")
	public ResponseData findMenuTree() {
		return ResponseData.getSuccessResult(sysMenuService.findTree(null, 0));
	}
}
