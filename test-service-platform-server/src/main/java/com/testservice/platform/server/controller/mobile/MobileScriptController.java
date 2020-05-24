
package com.testservice.platform.server.controller.mobile;

/**
 * @author : 孙留平
 * @since : 2020年3月6日 下午3:05:35
 * @see:
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testservice.platform.server.model.Script;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.service.ScriptService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * @author : Administrator
 * @since : 2020年3月6日 下午3:05:35
 * @see :
 */
@RestController("mobileScriptController")
@RequestMapping("mobile/script")
public class MobileScriptController {
	@Autowired
	private ScriptService scriptService;

	@PostMapping(value = "/save")
	public ResponseData save(@RequestBody Script function) {
		return ResponseData.getSuccessResult(scriptService.save(function));
	}

	@PostMapping(value = "/delete")
	public ResponseData delete(@RequestBody List<Script> functions) {
		return ResponseData.getSuccessResult(scriptService.delete(functions));
	}

	@PostMapping(value = "/findPage")
	public ResponseData findPage(@RequestBody PageRequest pageRequest) {
		return ResponseData.getSuccessResult(scriptService.findPage(pageRequest));
	}

	@GetMapping(value = "/findAll")
	public ResponseData findAll() {
		return ResponseData.getSuccessResult(scriptService.findAll());
	}

	@GetMapping(value = "/findByScriptName")
	public ResponseData findByScriptName(
	        @RequestParam("scriptName") String scriptName) {
		return ResponseData.getSuccessResult(scriptService.findByScriptName(scriptName));
	}

	@GetMapping(value = "/findByAppId")
	public ResponseData findByAppId(@RequestParam("appId") Long appId) {
		return ResponseData.getSuccessResult(scriptService.findAllByAppId(appId));
	}
}
