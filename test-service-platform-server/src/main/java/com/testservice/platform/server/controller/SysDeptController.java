package com.testservice.platform.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testservice.platform.server.model.SysDept;
import com.testservice.platform.server.service.SysDeptService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * 机构控制器
 * @author administrator
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("dept")
public class SysDeptController {

	@Autowired
	private SysDeptService sysDeptService;
	
	@PreAuthorize("hasAuthority('sys:dept:add') AND hasAuthority('sys:dept:edit')")
	@PostMapping(value="/save")
	public ResponseData save(@RequestBody SysDept record) {
		return ResponseData.getSuccessResult(sysDeptService.save(record));
	}

	@PreAuthorize("hasAuthority('sys:dept:delete')")
	@PostMapping(value="/delete")
	public ResponseData delete(@RequestBody List<SysDept> records) {
		return ResponseData.getSuccessResult(sysDeptService.delete(records));
	}

	@PreAuthorize("hasAuthority('sys:dept:view')")
	@GetMapping(value="/findTree")
	public ResponseData findTree() {
		return ResponseData.getSuccessResult(sysDeptService.findTree());
	}

}
