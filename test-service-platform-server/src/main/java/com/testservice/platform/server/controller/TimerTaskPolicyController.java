/**
 * @author : 孙留平
 * @since : 2018年9月3日 下午8:16:05
 * @see:
 */
package com.testservice.platform.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testservice.platform.server.model.TimerTaskPolicy;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.service.TimerTaskPolicyService;
import com.testservice.platform.util.vo.ResponseData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author : Administrator
 * @since : 2018年9月3日 下午8:16:05
 * @see :
 */
@Controller
@RequestMapping("/timerTaskPolicy")
@Api("策略相关API")
public class TimerTaskPolicyController {
    @Autowired
    private TimerTaskPolicyService timerTaskPolicyService;

    @GetMapping(value = "/getList")
    @ResponseBody
    @ApiOperation(value = "查询策略列表")
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没有填好"),
            @ApiResponse(code = 404, message = "页面查找失败，路径不对") })
    @PreAuthorize("hasAuthority('timerTask:timerTaskPolicy:view')")
    public ResponseData getList() {
        return ResponseData.getSuccessResult(
                timerTaskPolicyService.findAllTimerTaskPolicyList());
    }

    @GetMapping(value = "/searchList")
    @ResponseBody
    @ApiOperation(value = "根据种类名称查询策略列表")
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没有填好"),
            @ApiResponse(code = 404, message = "页面查找失败，路径不对") })
    @PreAuthorize("hasAuthority('timerTask:timerTaskPolicy:view')")
    public ResponseData searchList(
            @RequestParam("searchContent") String searchContent) {
        return ResponseData.getSuccessResult(timerTaskPolicyService
                .findTimerTaskPoliciesByCnameLike(searchContent));
    }

    @PostMapping(value = "/addTimerTaskPolicy")
    @ApiOperation(value = "添加策略")
    @ResponseBody
    @PreAuthorize("hasAuthority('timerTask:timerTaskPolicy:add')")
    public ResponseData addTimerTaskPolicy(
            @ModelAttribute TimerTaskPolicy timerTaskPolicy) {
        return ResponseData.getSuccessResult(
                timerTaskPolicyService.addTimerTaskPolicy(timerTaskPolicy));
    }

    @PostMapping(value = "/updateTimerTaskPolicy")
    @ApiOperation(value = "修改策略")
    @ResponseBody
    @PreAuthorize("hasAuthority('timerTask:timerTaskPolicy:edit')")
    public ResponseData updateTimerTaskPolicy(
            @ModelAttribute TimerTaskPolicy timerTaskPolicy) {
        return ResponseData.getSuccessResult(
                timerTaskPolicyService.updateTimerTaskPolicy(timerTaskPolicy));
    }

    @PostMapping(value = "/deleteTimerTaskPolicy")
    @ApiOperation(value = "删除策略")
    @ResponseBody
    @PreAuthorize("hasAuthority('timerTask:timerTaskPolicy:delete')")
    public ResponseData deleteTimerTaskPolicy(@RequestParam("id") Long id) {
        return ResponseData.getSuccessResult(
                timerTaskPolicyService.deleteTimerTaskPolicy(id));
    }

    @PostMapping(value = "/deleteTimerTaskPolicyInBatch")
    @ApiOperation(value = "批量删除策略")
    @ResponseBody
    @PreAuthorize("hasAuthority('timerTask:timerTaskPolicy:delete')")
    public ResponseData deleteTimerTaskPolicyInBatch(
            @RequestParam("ids[]") Long[] ids) {
        return ResponseData.getSuccessResult(
                timerTaskPolicyService.deleteTimerTaskPolicy(ids));
    }

    // @PostMapping(value = "/getTimerTaskPolicyListForPage")
    // @ApiOperation(value = "分页查询策略信息")
    // @ResponseBody
    // public ResponseData getTimerTaskPolicyListForPage(
    // @RequestParam("page") Integer page,
    // @RequestParam("size") Integer size) {
    // return ResponseData.getSuccessResult(timerTaskPolicyService
    // .findTimerTaskPolicyByPage(page, size).getContent());
    // }

    @PostMapping(value = "/getTimerTaskPolicyById")
    @ApiOperation(value = "查询策略信息详情")
    @ResponseBody
    @PreAuthorize("hasAuthority('timerTask:timerTaskPolicy:view')")
    public ResponseData getTimerTaskPolicyById(@RequestParam("id") Long id) {
        return ResponseData.getSuccessResult(
                timerTaskPolicyService.getTimerTaskPolicyById(id));
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "添加或者修改策略")
    @ResponseBody
    @PreAuthorize("hasAuthority('timerTask:timerTaskPolicy:add') AND hasAuthority('timerTask:timerTaskPolicy:edit')")
    public ResponseData save(@RequestBody TimerTaskPolicy timerTaskPolicy) {
        return ResponseData.getSuccessResult(
                timerTaskPolicyService.insertOrUpdate(timerTaskPolicy));
    }

    @ApiOperation(value = "查询分页")
    @ResponseBody
    @PreAuthorize("hasAuthority('timerTask:timerTaskPolicy:view')")
    @PostMapping(value = "/findPage")
    public ResponseData findPage(@RequestBody PageRequest pageRequest) {
        return ResponseData
                .getSuccessResult(timerTaskPolicyService.findPage(pageRequest));
    }

    @ApiOperation(value = "查询所有")
    @ResponseBody
    @PreAuthorize("hasAuthority('timerTask:timerTaskPolicy:view')")
    @GetMapping(value = "/findAll")
    public ResponseData findAll() {
        return ResponseData.getSuccessResult(
                timerTaskPolicyService.findAllTimerTaskPolicyList());
    }
}
