/**
 * @author : 孙留平
 * @since : 2020年3月12日 上午9:34:00
 * @see:
 */
package com.testservice.platform.server.aspect;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
import com.testservice.platform.server.model.AccessLog;
import com.testservice.platform.server.service.AccessLogService;
import com.testservice.platform.server.util.AspectPackageUtil;
import com.testservice.platform.server.util.HttpUtils;
import com.testservice.platform.server.util.IPUtils;
import com.testservice.platform.server.util.SecurityUtils;

/**
 * @author : Administrator
 * @since : 2020年3月12日 上午9:34:00
 * @see :
 */
@Aspect
@Component
public class AccessLogAspect {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(AccessLogAspect.class);
	private static final String CONTROLLER_PACKAGE = ".controller";

	private static final String FINAL_CONTROLLER_ASPECT_EXPRESSION = AspectPackageUtil.ASPECT_EXPRESSION_PREFIX
	        + AspectPackageUtil.THIS_PACKAGE_PREFIX + CONTROLLER_PACKAGE
	        + AspectPackageUtil.ASPECT_EXPRESSION_SUFFIX;

	private static List<String> IGNORED_ACCESS_URLS = new ArrayList<String>();

	static {
		IGNORED_ACCESS_URLS
		        .add(AspectPackageUtil.THIS_PACKAGE_PREFIX + CONTROLLER_PACKAGE
		                + ".SysUserController." + "findPermissions()");
		IGNORED_ACCESS_URLS
		        .add(AspectPackageUtil.THIS_PACKAGE_PREFIX + CONTROLLER_PACKAGE
		                + ".SysUserController." + "findByUserName()");
		IGNORED_ACCESS_URLS.add(AspectPackageUtil.THIS_PACKAGE_PREFIX
		        + CONTROLLER_PACKAGE + ".SysMenuController." + "findNavTree()");
		IGNORED_ACCESS_URLS
		        .add(AspectPackageUtil.THIS_PACKAGE_PREFIX + CONTROLLER_PACKAGE
		                + ".DefaultErrorController." + "errorException()");

	}

	@PostConstruct
	private void logData() {
		LOGGER.debug("包切面:{}", FINAL_CONTROLLER_ASPECT_EXPRESSION);
	}

	@Autowired
	private AccessLogService accessLogService;

	@Pointcut(FINAL_CONTROLLER_ASPECT_EXPRESSION)
	public void accessLogPointCut() {

	}

	@Around("accessLogPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		LOGGER.debug("拦截系统访问，加入访问日志");
		long beginTime = System.currentTimeMillis();
		// 执行方法
		Object result = point.proceed();
		// 执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;
		// 保存日志
		saveAccessLog(point, time);
		return result;
	}

	/**
	 * 保存访问日志
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param joinPoint
	 * @param time
	 */
	private void saveAccessLog(ProceedingJoinPoint joinPoint, long time) {
		LOGGER.debug("加入访问日志");
		String userName = SecurityUtils.getUsername();
		if (joinPoint.getTarget() instanceof AccessLogService) {
			return;
		}
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		AccessLog accessLog = new AccessLog();

		// 请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();

		String fullMethodName = className + "." + methodName + "()";

		if (ifUrlIgnored(fullMethodName)) {
			return;
		}

		accessLog.setMethod(className + "." + methodName + "()");

		// 请求的参数
		Object[] args = joinPoint.getArgs();
		try {
			String params = JSONObject.toJSONString(args[0]);
			accessLog.setParams(params);
		} catch (Exception e) {
			LOGGER.error("Json转换出错了:{}", e.getMessage());
		}

		// 获取request
		HttpServletRequest request = HttpUtils.getHttpServletRequest();

		if (null == request) {
			return;
		}

		// 设置IP地址
		accessLog.setIp(IPUtils.getIpAddr(request));

		// 设置操作方法
		accessLog.setOperation(request.getMethod().toString());

		// 设置访问url
		accessLog.setAccessUrl(request.getRequestURL().toString());

		// 用户名
		accessLog.setUserName(userName);

		// 执行时长(毫秒)
		accessLog.setTime(time);
		LOGGER.debug("访问日志为:{}", accessLog);
		// 保存系统日志
		accessLogService.save(accessLog);

		LOGGER.debug("加入访问日志完成");
	}

	/**
	 * 判断方法是不是需要忽略
	 * 
	 * @see :
	 * @param :
	 * @return : boolean
	 * @param url
	 * @return
	 */
	private static boolean ifUrlIgnored(String methodUrl) {

		LOGGER.debug("忽略方法名单：{}", IGNORED_ACCESS_URLS);
		if (IGNORED_ACCESS_URLS.contains(methodUrl)) {

			LOGGER.debug("methodUrl:{}被忽略记录", methodUrl);
			return true;
		} else {
			return false;
		}

	}
}
