package com.testservice.platform.server.controller.mobile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testservice.platform.server.model.Apk;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.service.ApkService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * apk控制器
 * 
 * @author administrator
 * @date 2020年2月18日 16:00:23
 */
@RestController("mobileApkController")
@RequestMapping("mobile/app")
public class MobileApkController {

	@Autowired
	private ApkService apkService;

	@PostMapping(value = "/save")
	public ResponseData save(@RequestBody Apk record) {
		return ResponseData.getSuccessResult(apkService.insertOrUpdate(record));
	}

	@PostMapping(value = "/delete")
	public ResponseData delete(@RequestBody List<Apk> records) {
		return ResponseData.getSuccessResult(apkService.delete(records));
	}

	@PostMapping(value = "/findPage")
	public ResponseData findPage(@RequestBody PageRequest pageRequest) {
		return ResponseData.getSuccessResult(apkService.findPage(pageRequest));
	}

	@GetMapping(value = "/findAll")
	public ResponseData findAll() {
		return ResponseData.getSuccessResult(apkService.findAll());
	}

	@GetMapping(value = "/findByLable")
	public ResponseData findByLable(@RequestParam String lable) {
		return ResponseData.getSuccessResult(apkService.findByLable(lable));
	}

	@GetMapping(value = "/findByPackageName")
	public ResponseData findByPackageName(
	        @RequestParam("packageName") String packageName) {
		return ResponseData.getSuccessResult(apkService.findByPackageName(packageName));
	}
}
