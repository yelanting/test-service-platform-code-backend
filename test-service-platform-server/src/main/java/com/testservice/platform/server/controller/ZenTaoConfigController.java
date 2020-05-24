/**
 * @author : 孙留平
 * @since : 2020年3月18日 上午1:06:07
 * @see:
 */
package com.testservice.platform.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import com.testservice.platform.server.model.GlobalParam;
import com.testservice.platform.server.service.ZenTaoConfigService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * @author : Administrator
 * @since : 2020年3月18日 上午1:06:07
 * @see :
 */
@RestController
@RequestMapping("/zenTaoConfig")
@SessionScope
public class ZenTaoConfigController {
    @Autowired
    private ZenTaoConfigService zenTaoConfigService;

    @PreAuthorize("hasAuthority('function:zenTaoConfig:add') AND hasAuthority('function:zenTaoConfig:edit')")
    @PostMapping(value = "/save")
    public ResponseData save(@RequestBody GlobalParam record) {
        return ResponseData.getSuccessResult(zenTaoConfigService.save(record));
    }

    @PreAuthorize("hasAuthority('function:zenTaoConfig:view')")
    @GetMapping(value = "/getCurrentZenTaoData")
    public ResponseData getCurrentZenTaoData() {
        return ResponseData
                .getSuccessResult(zenTaoConfigService.getCurrentZenTaoData());
    }
}
