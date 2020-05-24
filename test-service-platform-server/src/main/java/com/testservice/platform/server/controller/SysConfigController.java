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

import com.testservice.platform.server.model.SysConfig;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.service.SysConfigService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * 系统配置控制器
 * @author administrator
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("config")
public class SysConfigController {

	@Autowired
	private SysConfigService sysConfigService;
	
	@PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
	@PostMapping(value="/save")
	public ResponseData save(@RequestBody SysConfig record) {
		return ResponseData.getSuccessResult(sysConfigService.save(record));
	}

	@PreAuthorize("hasAuthority('sys:config:delete')")
	@PostMapping(value="/delete")
	public ResponseData delete(@RequestBody List<SysConfig> records) {
		return ResponseData.getSuccessResult(sysConfigService.delete(records));
	}

	@PreAuthorize("hasAuthority('sys:config:view')")
	@PostMapping(value="/findPage")
	public ResponseData findPage(@RequestBody PageRequest pageRequest) {
		return ResponseData.getSuccessResult(sysConfigService.findPage(pageRequest));
	}
	
	@PreAuthorize("hasAuthority('sys:config:view')")
	@GetMapping(value="/findByLable")
	public ResponseData findByLable(@RequestParam String lable) {
		return ResponseData.getSuccessResult(sysConfigService.findByLable(lable));
	}
}
