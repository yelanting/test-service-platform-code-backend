/**
 * @author : 孙留平
 * @since : 2020年3月22日 上午4:01:57
 * @see:
 */
package com.testservice.platform.server.controller.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testservice.platform.server.service.ZenTaoTestCaseService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * @author : Administrator
 * @since : 2020年3月22日 上午4:01:57
 * @see :
 */
@RestController
@RequestMapping("/mobile/zenTaoTestCase")
public class MobileZenTaoTestCaseController {
	@Autowired
	private ZenTaoTestCaseService zenTaoTestCaseService;

	@GetMapping("/getTestCasesByTestTaskId/{testTaskId}")
	public ResponseData getTestCasesByTestTaskId(
	        @PathVariable("testTaskId") Long testTaskId) {
		return ResponseData.getSuccessResult(zenTaoTestCaseService
		        .findZenTaoTestCasesByTestTaskId(testTaskId));
	}
}
