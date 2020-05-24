package com.testservice.platform.server.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.testservice.platform.server.model.SysLoginLog;
import com.testservice.platform.server.model.SysUser;
import com.testservice.platform.server.security.JwtAuthenticatioToken;
import com.testservice.platform.server.service.SysLoginLogService;
import com.testservice.platform.server.service.SysUserService;
import com.testservice.platform.server.util.PasswordUtils;
import com.testservice.platform.server.util.SecurityUtils;
import com.testservice.platform.server.vo.LoginBean;
import com.testservice.platform.util.core.IOUtils;
import com.testservice.platform.util.vo.ResponseData;

/**
 * 登录控制器
 * 
 * @author administrator
 * @date Jan 14, 2019
 */
@RestController
public class SysLoginController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(SysLoginController.class);

    @Autowired
    private Producer producer;
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysLoginLogService sysLoginLogService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response,
            HttpServletRequest request) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        LOGGER.debug("验证码为:{}", text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public ResponseData login(@RequestBody LoginBean loginBean,
            HttpServletRequest request) throws IOException {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession()
                .getAttribute(Constants.KAPTCHA_SESSION_KEY);

        LOGGER.debug("前端传进来的验证码:{},后端保存的验证码:{}", captcha, kaptcha);
        if (kaptcha == null) {
            return ResponseData.getErrorResult("验证码已失效");
        }

        /**
         * 2020年3月26日 09:43:01 改为忽略大小写
         */
        if (!captcha.equalsIgnoreCase((String) kaptcha)) {
            return ResponseData.getErrorResult("验证码不正确");
        }
        // 用户信息
        SysUser user = sysUserService.findByName(username);
        // 帐号不存在、密码错误
        if (user == null) {
            return ResponseData.getErrorResult("帐号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password,
                user.getPassword())) {
            return ResponseData.getErrorResult("密码不正确");
        }
        // 帐号锁定
        if (user.getStatus() == 0) {
            return ResponseData.getErrorResult("帐号已被锁定,请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username,
                password, authenticationManager);

        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setCreateBy(username);
        sysLoginLog.setCreateTime(new Date());
        sysLoginLog.setIp(request.getRemoteHost());
        sysLoginLog.setLastUpdateBy(username);
        sysLoginLog.setLastUpdateTime(new Date());
        sysLoginLog.setStatus("login");
        sysLoginLog.setUserName(username);

        sysLoginLogService.save(sysLoginLog);
        return ResponseData.getSuccessResult(token);
    }

    /**
     * 不带验证码登录接口
     */
    @PostMapping(value = "/loginWithoutCaptcha")
    public ResponseData loginWithoutCaptcha(@RequestBody LoginBean loginBean,
            HttpServletRequest request) throws IOException {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        // 用户信息
        SysUser user = sysUserService.findByName(username);
        // 帐号不存在、密码错误
        if (user == null) {
            return ResponseData.getErrorResult("帐号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password,
                user.getPassword())) {
            return ResponseData.getErrorResult("密码不正确");
        }
        // 帐号锁定
        if (user.getStatus() == 0) {
            return ResponseData.getErrorResult("帐号已被锁定,请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username,
                password, authenticationManager);

        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setCreateBy(username);
        sysLoginLog.setCreateTime(new Date());
        sysLoginLog.setIp(request.getRemoteHost());
        sysLoginLog.setLastUpdateBy(username);
        sysLoginLog.setLastUpdateTime(new Date());
        sysLoginLog.setStatus("login");
        sysLoginLog.setUserName(username);
        sysLoginLogService.save(sysLoginLog);
        return ResponseData.getSuccessResult(token);
    }
}
