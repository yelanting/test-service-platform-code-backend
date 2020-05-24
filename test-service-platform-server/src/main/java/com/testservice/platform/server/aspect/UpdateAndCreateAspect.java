/**
 * @author : 孙留平
 * @since : 2020年2月25日 上午10:28:24
 * @see:
 */
package com.testservice.platform.server.aspect;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.testservice.platform.server.util.SecurityUtils;
import com.testservice.platform.util.core.StringUtil;

/**
 * @author : Administrator
 * @since : 2020年2月25日 上午10:28:24
 * @see :DAO切面，插入创建人，创建时间，修改人，修改时间
 */
@Aspect
@Component
@Configuration
public class UpdateAndCreateAspect {

	private static final Logger LOGGER = LoggerFactory
	        .getLogger(UpdateAndCreateAspect.class);

	/**
	 * @see :
	 */
	public UpdateAndCreateAspect() {
	}

	private static final String CREATE_BY = "createBy";
	private static final String CREATE_TIME = "createTime";
	private static final String LAST_UPDATE_BY = "lastUpdateBy";
	private static final String LAST_UPDATE_TIME = "lastUpdateTime";

	@Pointcut("execution(* com.testservice.platform.server.dao.*.update*(..))")
	public void daoUpdate() {
	}

	@Pointcut("execution(* com.testservice.platform.server.dao.*.insert*(..))")
	public void daoCreate() {
	}

	@Around("daoUpdate()")
	public Object doAroundUpdate(ProceedingJoinPoint pjp) throws Throwable {

		LOGGER.debug("拦截dao的update操作，插入固定字段:lastUpdateBy lastUpdateTime");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
		        .getRequestAttributes();
		if (attributes == null) {
			return pjp.proceed();
		}
		HttpServletRequest request = attributes.getRequest();
		String token = request.getHeader("token");
		String username = getUserName();
		Object[] objects = pjp.getArgs();
		if (objects != null && objects.length > 0) {
			for (Object arg : objects) {
				if (token != null && username != null) {
					if (StringUtil
					        .isBlank(BeanUtils.getProperty(arg, CREATE_BY))) {
						BeanUtils.setProperty(arg, CREATE_BY, username);
					}

					BeanUtils.setProperty(arg, LAST_UPDATE_BY, username);

				}

				if (StringUtil
				        .isBlank(BeanUtils.getProperty(arg, CREATE_TIME))) {
					BeanUtils.setProperty(arg, CREATE_TIME, new Date());
				}
				BeanUtils.setProperty(arg, LAST_UPDATE_TIME, new Date());
			}
		}
		Object object = pjp.proceed();
		return object;

	}

	@Around("daoCreate()")
	public Object doAroundCreate(ProceedingJoinPoint pjp) throws Throwable {

		LOGGER.debug(
		        "拦截dao操作的create，插入固定字段:createBy lastUpdateBy createTime lastUpdateTime");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
		        .getRequestAttributes();
		if (attributes == null) {
			return pjp.proceed();
		}

		String username = getUserName();

		Object[] objects = pjp.getArgs();
		if (objects != null && objects.length > 0) {
			for (Object arg : objects) {
				if (username != null) {
					if (StringUtil
					        .isBlank(BeanUtils.getProperty(arg, CREATE_BY))) {
						BeanUtils.setProperty(arg, CREATE_BY, username);
					}

					BeanUtils.setProperty(arg, LAST_UPDATE_BY, username);

				}

				if (StringUtil
				        .isBlank(BeanUtils.getProperty(arg, CREATE_TIME))) {
					BeanUtils.setProperty(arg, CREATE_TIME, new Date());
				}

				BeanUtils.setProperty(arg, LAST_UPDATE_TIME, new Date());
			}
		}
		Object object = pjp.proceed();
		return object;
	}

	private String getUserName() {
		String username = SecurityUtils.getUsername();
		LOGGER.debug("当前登录用户:{}", username);
		return username;
	}

}
