/**
 * @author : 孙留平
 * @since : 2020年3月22日 上午4:01:41
 * @see:
 */
package com.testservice.platform.server.controller.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testservice.platform.server.service.ZenTaoTestTaskService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * @author : Administrator
 * @since : 2020年3月22日 上午4:01:41
 * @see :
 */
@RestController
@RequestMapping("/mobile/zenTaoTestTask")
public class MobileZenTaoTestTaskController {
    @Autowired
    private ZenTaoTestTaskService zenTaoTestTaskService;

    @GetMapping("/username/{username}")
    public ResponseData getTestCasesByTestTaskId(
            @PathVariable("username") String username) {
        return ResponseData.getSuccessResult(
                zenTaoTestTaskService.findAllByUsername(username));
    }
}
