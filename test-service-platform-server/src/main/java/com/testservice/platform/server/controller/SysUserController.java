package com.testservice.platform.server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testservice.platform.server.constant.SysConstants;
import com.testservice.platform.server.model.SysUser;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.service.SysUserService;
import com.testservice.platform.util.vo.ResponseData;

/**
 * 用户控制器
 * 
 * @author administrator
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("user")
public class SysUserController {
    private static final Logger LOGGER = org.slf4j.LoggerFactory
            .getLogger(SysUserController.class);
    @Autowired
    private SysUserService sysUserService;

    @PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
    @PostMapping(value = "/save")
    public ResponseData save(@RequestBody SysUser record) {
        return ResponseData.getSuccessResult(sysUserService.save(record));
    }

    @PreAuthorize("hasAuthority('sys:user:delete')")
    @PostMapping(value = "/delete")
    public ResponseData delete(@RequestBody List<SysUser> records) {
        for (SysUser record : records) {
            SysUser sysUser = sysUserService.findById(record.getId());
            if (sysUser != null
                    && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
                return ResponseData.getErrorResult("超级管理员不允许删除!");
            }
        }
        return ResponseData.getSuccessResult(sysUserService.delete(records));
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value = "/findByName")
    public ResponseData findByUserName(@RequestParam String name) {
        return ResponseData.getSuccessResult(sysUserService.findByName(name));
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value = "/findPermissions")
    public ResponseData findPermissions(@RequestParam String name) {
        return ResponseData
                .getSuccessResult(sysUserService.findPermissions(name));
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value = "/findUserRoles")
    public ResponseData findUserRoles(@RequestParam Long userId) {
        return ResponseData
                .getSuccessResult(sysUserService.findUserRoles(userId));
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @PostMapping(value = "/findPage")
    public ResponseData findPage(@RequestBody PageRequest pageRequest) {
        return ResponseData
                .getSuccessResult(sysUserService.findPage(pageRequest));
    }

}
