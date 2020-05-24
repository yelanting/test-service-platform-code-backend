package com.testservice.platform.server.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.testservice.platform.server.model.SysLog;
import com.testservice.platform.server.service.SysLogService;
import com.testservice.platform.server.util.HttpUtils;
import com.testservice.platform.server.util.IPUtils;
import com.testservice.platform.server.util.SecurityUtils;

/***
 * 系统日志，切面处理类，记录日志**
 * 
 * @author Administrator
 * @date Jan 19, 2019
 */
@Aspect
@Component
public class SysLogAspect {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(SysLogAspect.class);
	private static final int MAX_REQUEST_ENTITY_LENGTH = 200;
	@Autowired
	private SysLogService sysLogService;

	@Pointcut("execution(* com.testservice.platform.server.service.*.*(..))")
	public void logPointCut() {

	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		LOGGER.debug("拦截系统日志，加入执行日志");
		long beginTime = System.currentTimeMillis();
		// 执行方法
		Object result = point.proceed();
		// 执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;
		// 保存日志
		saveSysLog(point, time);
		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
		LOGGER.debug("加入操作日志");
		String userName = SecurityUtils.getUsername();
		if (joinPoint.getTarget() instanceof SysLogService) {
			return;
		}
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		SysLog sysLog = new SysLog();

		// 请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");

		// 请求的参数
		Object[] args = joinPoint.getArgs();
		try {
			String params = JSONObject.toJSONString(args[0]);
			if (params.length() > MAX_REQUEST_ENTITY_LENGTH) {
				params = params.substring(0, MAX_REQUEST_ENTITY_LENGTH) + "...";
			}
			sysLog.setParams(params);
		} catch (Exception e) {
		}

		// 获取request
		HttpServletRequest request = HttpUtils.getHttpServletRequest();

		if (null == request) {
			return;
		}

		// 设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request));

		// 用户名
		sysLog.setUserName(userName);

		// 执行时长(毫秒)
		sysLog.setTime(time);
		LOGGER.debug("操作日志为:{}", sysLog);
		// 保存系统日志
		sysLogService.save(sysLog);

		LOGGER.debug("加入操作日志完成");
	}
}
