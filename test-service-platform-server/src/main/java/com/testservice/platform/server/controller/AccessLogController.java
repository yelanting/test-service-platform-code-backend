package com.testservice.platform.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testservice.platform.server.model.AccessLog;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.service.AccessLogService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * 操作日志控制器
 * 
 * @author administrator
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("accessLog")
public class AccessLogController {

	@Autowired
	private AccessLogService accessLogService;

	@PreAuthorize("hasAuthority('sys:accessLog:view')")
	@PostMapping(value = "/findPage")
	public ResponseData findPage(@RequestBody PageRequest pageRequest) {
		return ResponseData
		        .getSuccessResult(accessLogService.findPage(pageRequest));
	}

	@PreAuthorize("hasAuthority('sys:accessLog:delete')")
	@PostMapping(value = "/delete")
	public ResponseData delete(@RequestBody List<AccessLog> records) {
		return ResponseData.getSuccessResult(accessLogService.delete(records));
	}
}
