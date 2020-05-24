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

import com.testservice.platform.server.model.SysDict;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.service.SysDictService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * 字典控制器
 * @author administrator
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("dict")
public class SysDictController {

	@Autowired
	private SysDictService sysDictService;
	
	@PreAuthorize("hasAuthority('sys:dict:add') AND hasAuthority('sys:dict:edit')")
	@PostMapping(value="/save")
	public ResponseData save(@RequestBody SysDict record) {
		return ResponseData.getSuccessResult(sysDictService.save(record));
	}

	@PreAuthorize("hasAuthority('sys:dict:delete')")
	@PostMapping(value="/delete")
	public ResponseData delete(@RequestBody List<SysDict> records) {
		return ResponseData.getSuccessResult(sysDictService.delete(records));
	}

	@PreAuthorize("hasAuthority('sys:dict:view')")
	@PostMapping(value="/findPage")
	public ResponseData findPage(@RequestBody PageRequest pageRequest) {
		return ResponseData.getSuccessResult(sysDictService.findPage(pageRequest));
	}
	
	@PreAuthorize("hasAuthority('sys:dict:view')")
	@GetMapping(value="/findByLable")
	public ResponseData findByLable(@RequestParam String lable) {
		return ResponseData.getSuccessResult(sysDictService.findByLable(lable));
	}
}
