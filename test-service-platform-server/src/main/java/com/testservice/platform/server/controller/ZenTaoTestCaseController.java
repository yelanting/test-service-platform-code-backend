/**
 * @author : 孙留平
 * @since : 2020年3月18日 上午1:06:07
 * @see:
 */
package com.testservice.platform.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.service.ZenTaoTestCaseService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * @author : Administrator
 * @since : 2020年3月18日 上午1:06:07
 * @see :
 */
@RestController
@RequestMapping("/zenTaoTestCase")
@SessionScope
public class ZenTaoTestCaseController {

    @Autowired
    private ZenTaoTestCaseService zenTaoTestCaseService;

    @PreAuthorize("hasAuthority('function:zenTaoTestCase:view')")
    @GetMapping("/getTestCasesByTestTaskId/{testTaskId}")
    public ResponseData getTestCasesByTestTaskId(
            @PathVariable("testTaskId") Long testTaskId) {
        return ResponseData.getSuccessResult(zenTaoTestCaseService
                .findZenTaoTestCasesByTestTaskId(testTaskId));
    }

    @PreAuthorize("hasAuthority('function:zenTaoTestCase:view')")
    @GetMapping("/testCase/{id}")
    public ResponseData getTestCaseId(@PathVariable("id") Long id) {
        return ResponseData.getSuccessResult(
                zenTaoTestCaseService.findZenTaoTestCaseById(id));
    }

    @PreAuthorize("hasAuthority('function:zenTaoTestCase:view')")
    @GetMapping(value = "/findByTestTaskId")
    public ResponseData findByTestTaskId(
            @RequestParam("testTaskId") Long testTaskId) {
        return ResponseData.getSuccessResult(zenTaoTestCaseService
                .findZenTaoTestCasesByTestTaskId(testTaskId));
    }

    @PreAuthorize("hasAuthority('function:zenTaoTestCase:view')")
    @PostMapping(value = "/findPage")
    public ResponseData findPage(@RequestBody PageRequest pageRequest) {
        return ResponseData
                .getSuccessResult(zenTaoTestCaseService.findPage(pageRequest));
    }

    @PreAuthorize("hasAuthority('function:zenTaoTestCase:view')")
    @PostMapping(value = "/findPageByTestTaskId")
    public ResponseData findPageByTestTaskId(
            @RequestBody PageRequest pageRequest) {
        return ResponseData.getSuccessResult(
                zenTaoTestCaseService.findPageByTestTaskId(pageRequest));
    }

}
