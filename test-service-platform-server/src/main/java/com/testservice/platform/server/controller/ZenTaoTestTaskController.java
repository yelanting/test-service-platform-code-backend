/**
 * @author : 孙留平
 * @since : 2020年3月18日 上午1:06:07
 * @see:
 */
package com.testservice.platform.server.controller;

import java.util.List;

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

import com.testservice.platform.server.model.ZenTaoTestTaskModel;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.service.ZenTaoTestTaskService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * @author : Administrator
 * @since : 2020年3月18日 上午1:06:07
 * @see :
 */
@RestController
@RequestMapping("/zenTaoTestTask")
@SessionScope
public class ZenTaoTestTaskController {
    @Autowired
    private ZenTaoTestTaskService zenTaoTestTaskService;

    @PreAuthorize("hasAuthority('function:zenTaoTestTask:view')")
    @GetMapping("/testTask/{id}")
    public ResponseData getTestTaskById(@PathVariable("id") Long id) {
        return ResponseData.getSuccessResult(
                zenTaoTestTaskService.findZenTaoTestTaskById(id));
    }

    @PreAuthorize("hasAuthority('record:app:add') AND hasAuthority('record:app:edit')")
    @PostMapping(value = "/save")
    public ResponseData save(@RequestBody ZenTaoTestTaskModel record) {
        return ResponseData
                .getSuccessResult(zenTaoTestTaskService.insertOrUpdate(record));
    }

    @PreAuthorize("hasAuthority('record:app:delete')")
    @PostMapping(value = "/delete")
    public ResponseData delete(@RequestBody List<ZenTaoTestTaskModel> records) {
        return ResponseData
                .getSuccessResult(zenTaoTestTaskService.delete(records));
    }

    @PreAuthorize("hasAuthority('record:app:view')")
    @PostMapping(value = "/findPage")
    public ResponseData findPage(@RequestBody PageRequest pageRequest) {
        return ResponseData
                .getSuccessResult(zenTaoTestTaskService.findPage(pageRequest));
    }

    @PreAuthorize("hasAuthority('record:app:view')")
    @GetMapping(value = "/findAll")
    public ResponseData findAll() {
        return ResponseData.getSuccessResult(zenTaoTestTaskService.findAll());
    }

    @PreAuthorize("hasAuthority('record:app:view')")
    @GetMapping(value = "/findByLable")
    public ResponseData findByLable(@RequestParam String lable) {
        return ResponseData
                .getSuccessResult(zenTaoTestTaskService.findByLable(lable));
    }
}
