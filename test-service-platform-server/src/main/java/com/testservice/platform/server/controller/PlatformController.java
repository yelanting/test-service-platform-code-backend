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

import com.testservice.platform.server.model.Platform;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.service.PlatformService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * platform控制器
 * 
 * @author administrator
 * @date 2020年2月18日 16:00:23
 */
@RestController
@RequestMapping("platform")
public class PlatformController {

	@Autowired
	private PlatformService platformService;

	@PreAuthorize("hasAuthority('function:platform:add') AND hasAuthority('function:platform:edit')")
	@PostMapping(value = "/save")
	public ResponseData save(@RequestBody Platform record) {
		return ResponseData.getSuccessResult(platformService.save(record));
	}

	@PreAuthorize("hasAuthority('function:platform:delete')")
	@PostMapping(value = "/delete")
	public ResponseData delete(@RequestBody List<Platform> records) {
		return ResponseData.getSuccessResult(platformService.delete(records));
	}

	@PreAuthorize("hasAuthority('function:platform:view')")
	@PostMapping(value = "/findPage")
	public ResponseData findPage(@RequestBody PageRequest pageRequest) {
		return ResponseData.getSuccessResult(platformService.findPage(pageRequest));
	}

	@PreAuthorize("hasAuthority('function:platform:view')")
	@GetMapping(value = "/findAll")
	public ResponseData findAll() {
		return ResponseData.getSuccessResult(platformService.findAll());
	}

	@PreAuthorize("hasAuthority('function:platform:view')")
	@GetMapping(value = "/findByPlatformName")
	public ResponseData findByPlatformName(
	        @RequestParam("platformName") String platformName) {
		return ResponseData.getSuccessResult(platformService.findByPlatformName(platformName));
	}
}
